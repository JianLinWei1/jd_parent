package com.jian.service;

import com.jian.entity.LjClient;
import com.jian.util.ResultUtil;

public interface DeviceService {

	 ResultUtil   getClientsInfo();
	 
	 LjClient  getDeviceBySeril(String  deviceseril);
	 
	 int  addDevice(LjClient client);
	 
	 int upDevice(LjClient client);
}
