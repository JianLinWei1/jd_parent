package com.jian.grpc;


import com.jian.entity.LjClient;
import com.jian.service.DeviceService;

import com.jian.util.HeartBeatUtil;
import com.ljzn.grpc.client.ClientAuthServiceGrpc.ClientAuthServiceImplBase;
import com.ljzn.grpc.client.HeartbeatRequest;
import com.ljzn.grpc.client.HeartbeatResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ljzn.grpc.client.LoginRequest;
import com.ljzn.grpc.client.LoginResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
/**
 * 客户端设备
 * @ClassName:  ClientServiceImpl   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月9日 下午4:31:03   
 *
 */
@GrpcService
public class ClientServiceImpl  extends ClientAuthServiceImplBase {
	private  Logger logger  = LoggerFactory.getLogger(ClientServiceImpl.class);
	private  String sign = "2e18e0f4a65a44c1cb6ca5cad46b5f95";
	
	@Autowired
	private  DeviceService  ds ;
	
	@Override
	 public void login(LoginRequest request,StreamObserver<LoginResponse> responseObserver) {
		      responseObserver.onNext(clientLogin(request));
		      responseObserver.onCompleted();
		    }

	public LoginResponse   clientLogin(LoginRequest request){
		LoginResponse.Builder builder  = LoginResponse.newBuilder();
		try{
		 String client_secret = new Md5Hash(request.getClient().getDeviceSeril()+sign).toString();
		 
		 if(!StringUtils.equals(client_secret, request.getClientSecret())){
			 builder.setCode(-1);
			 builder.setMessage("验证失败");
			 System.out.println("client_secret 验证失败");
			 return builder.build();
		 }
		
		
		System.out.println("s设备："+request.getClient().getDeviceSeril()+"登录");
		  LjClient device_1 = ds.getDeviceBySeril(request.getClient().getDeviceSeril());
		  LjClient device  = new LjClient();
		  device.setDeviceSeril(request.getClient().getDeviceSeril());
		
		  device.setDeviceAccuracy(request.getClient().getDeviceAccuracy());
		  device.setDeviceAddress(request.getClient().getDeviceAddress());
		  device.setDeviceAccuracy(request.getClient().getDeviceName());
		  device.setDeviceType(request.getClient().getDeviceType());
		  device.setTcpIp(request.getClient().getClientIp());
		  /*if(StringUtils.isNotEmpty(request.getClient().getClientPort()))*/
		  device.setTcpPort(Integer.valueOf(request.getClient().getClientPort()));
		  if(device_1 == null){
			int i=  ds.addDevice(device);
			builder.setCode(i);
			builder.setMessage("增加成功");
		   logger.info(device.getDeviceSeril()+"：设备登录成功！增加");
			return builder.build();
		  }else{
			/* if(!device_1.getMerchantId().equals(device.getMerchantId())){
				 ds.upDevice(device);
			 }*/
			 ds.upDevice(device);
			 builder.setCode(1);
			 logger.info(device.getDeviceSeril()+"：设备登录成功！更新");
			 builder.setMessage("已存在该序列号设备,已更新其他信息");
			 
			 return builder.build();
				
		  }
		}catch(Exception e){
			e.printStackTrace();
			builder.setCode(-1);
			builder.setMessage("异常信息："+e.getMessage());
			return builder.build();
		}
	 }
	
	/**
	 * 心跳
     */
	@Override
    public void heartBeat(HeartbeatRequest request,StreamObserver<HeartbeatResponse> responseObserver) {
         HeartbeatResponse.Builder  builder =  HeartbeatResponse.newBuilder();
         String  deviceSeril =  request.getDeviceSeril();
         LjClient  ljDevice =  ds.getDeviceBySeril(deviceSeril);
         if(ljDevice == null){
        	 builder.setCode(-1);
        	 builder.setMessage("设备暂未登录Device not logged in");
         }else{
        	 HeartBeatUtil.setDeviceSeril(request.getDeviceSeril());
        	 builder.setCode(1);
        	 builder.setMessage("心跳发送成功HeartBeat send  ok");
        	 logger.info("心跳发送成功HeartBeat send  ok");
         }
         responseObserver.onNext(builder.build());
         responseObserver.onCompleted();
    }
	
}
