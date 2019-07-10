/*package com.jian.controller;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.biology.entity.LjFeature;
import com.biology.face.FaceApi;
import com.biology.face.FaceApiImpl;
import com.jian.Application;
import com.jian.entity.JdPersons;
import com.jian.service.JdPersonService;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(classes = Application.class)

@WebAppConfiguration
public class Test {
	@Autowired
	JdPersonService js;
	
	
	@org.junit.Test
	public void  test(){
		List<JdPersons>  jdPersons = js.getJdPersonByIDcard("320122196806020031");
		for(JdPersons j : jdPersons){
			FaceApi api = new FaceApiImpl();
			LjFeature  feature  = api.ByteToFeature(j.getPhotoFeature());
			System.out.println(JSON.toJSON(feature).toString());
		}
	}

}
*/