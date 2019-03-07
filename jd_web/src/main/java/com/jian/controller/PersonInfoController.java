package com.jian.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jian.entity.JdPersons;
import com.jian.service.JdPersonService;
import com.jian.util.ActionUtil;
import com.jian.util.ResultUtil;

@RestController
@RequestMapping("/person/api")
public class PersonInfoController {
	
	@Autowired
	JdPersonService jdSer;

	
	@PostMapping("/{val}")
	public  ResultUtil  personInfo(@PathVariable String val  , @RequestBody List<JdPersons> jdPersons){
		if(StringUtils.equals(val, ActionUtil.insert.getValue())){
			return jdSer.insertPersons(jdPersons);
		}
		if(StringUtils.equals(val, ActionUtil.update.getValue())){
			return jdSer.updatePersons(jdPersons);
		}
		if(StringUtils.equals(val, ActionUtil.delete.getValue())){
			return jdSer.deletePersons(jdPersons);
		}
		return new ResultUtil(-1, "请求错误");
	}
}
