package com.jian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jian.service.DeviceService;
import com.jian.util.ResultUtil;

@RestController
@RequestMapping("/device/api")
public class DeviceController {

	@Autowired
	DeviceService  deSer;
	
	@GetMapping("/query")
	public  ResultUtil  get(){
		return deSer.getClientsInfo();
	}
	
}
