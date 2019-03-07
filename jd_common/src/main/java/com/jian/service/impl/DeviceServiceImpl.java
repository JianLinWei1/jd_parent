package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.dao.LjClientMapper;
import com.jian.entity.LjClient;
import com.jian.entity.LjClientExample;
import com.jian.service.DeviceService;
import com.jian.util.ResultUtil;
/**
 * 设备客户端
 * @ClassName:  DeviceServiceImpl   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年3月7日 上午9:56:58   
 *
 */
@Service
public class DeviceServiceImpl  implements DeviceService {
	@Resource
	LjClientMapper  ljClienMapper;

	@Override
	public ResultUtil getClientsInfo() {
		ResultUtil resultUtil = new ResultUtil();
		LjClientExample example = new LjClientExample();
		List<LjClient>  ljClients  = ljClienMapper.selectByExample(example);
		resultUtil.setCode(0);
		resultUtil.setCount(ljClients.size());
		resultUtil.setData(ljClients);
		resultUtil.setMsg("ok");
		return resultUtil;
		
	}

	@Override
	public LjClient getDeviceBySeril(String deviceseril) {
		
		return ljClienMapper.selectByPrimaryKey(deviceseril);
	}

	@Override
	public int addDevice(LjClient client) {
		
		return ljClienMapper.insert(client);
	}

	@Override
	public int upDevice(LjClient client) {
		
		return ljClienMapper.updateByPrimaryKeySelective(client);
	}

}
