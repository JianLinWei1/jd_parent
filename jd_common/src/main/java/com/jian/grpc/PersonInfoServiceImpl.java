package com.jian.grpc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.biology.entity.LjFeature;
import com.biology.face.FaceApi;
import com.biology.face.FaceApiImpl;
import com.google.common.primitives.Floats;
import com.google.protobuf.ByteString;
import com.jian.entity.JdPersons;
import com.jian.service.JdPersonService;
import com.jian.util.FileUtil;
import com.ljzn.grpc.personinfo.PersonInfoAuthServiceGrpc.PersonInfoAuthServiceImplBase;
import com.ljzn.grpc.personinfo.PersoninfoMessage.Builder;
import com.ljzn.grpc.personinfo.PersoninfoRequest;
import com.ljzn.grpc.personinfo.PersoninfoResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PersonInfoServiceImpl  extends  PersonInfoAuthServiceImplBase{
	private Logger  logger  =  LoggerFactory.getLogger(PersonInfoServiceImpl.class);
	
	@Autowired
	JdPersonService  jdPerSer;
	
	
	@Override
	public void getPersonInfo(PersoninfoRequest request,StreamObserver<PersoninfoResponse> responseObserver) {
	     
		responseObserver.onNext(getPerInfoRes(request));
		responseObserver.onCompleted();
	    }
	
	
	public  PersoninfoResponse  getPerInfoRes(PersoninfoRequest request){
		List<JdPersons>  jdPersons = jdPerSer.getJdPersonsByVersion(request.getDeviceSeril(), request.getVersion());
		PersoninfoResponse.Builder  builder =  PersoninfoResponse.newBuilder();
		FaceApi  fa  = new FaceApiImpl();
		try{
		for(JdPersons  jp : jdPersons){
			Builder  mBuilder =  builder.addPersonInfoBuilder();
			mBuilder.setAction(jp.getAction());
			mBuilder.setCardId(jp.getIdCard());
			mBuilder.setName(jp.getName());
			mBuilder.setPhoto(ByteString.copyFrom(FileUtil.getPicture2Byte(jp.getPhoto(), "upload\\images\\")));
		    LjFeature  feature  = fa.ByteToFeature(jp.getPhotoFeature());
		    List<Float>  floats =  Floats.asList(feature.data);
		    mBuilder.addAllPhotoFeature(floats);
		    mBuilder.setPhotoFeatureLen(feature.len);
		    mBuilder.setVersion(jp.getVersion());
		    mBuilder.setPersonTypeValue(jp.getPersonType());
		    mBuilder.setUuid(jp.getUuid());
		    logger.info("获取人员cardid:"+mBuilder.getCardId()+":"+mBuilder.getName());
		}
		builder.setCode(1);
		builder.setMessage("ok");
		return  builder.build();
		}catch(Exception e){
			builder.setCode(-1);
			builder.setMessage("异常信息："+e.getMessage());
			logger.error(e.getMessage());
			return builder.build();
		}
	}

}
