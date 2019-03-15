package com.jian.util;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jian.dao.JdPersonsMapper;
import com.jian.entity.JdPersons;
import com.jian.entity.JdPersonsExample;
import com.jian.entity.JdPersonsExample.Criteria;

@Component
public class ScheduledUtil {
  private  Logger logger  = LoggerFactory.getLogger(ScheduledUtil.class);
  
  @Autowired
  JdPersonsMapper jdpersonMapper;
	
	@Scheduled(cron = "0/60 * * * * *")
	public  void  delInvaildPeople(){
		JdPersonsExample  example  = new JdPersonsExample();
		Criteria criteria  = example.createCriteria();
		criteria.andActionNotEqualTo(-1);
		criteria.andInvalidTimeLessThan(new Date());
		
		List<JdPersons>  persons = jdpersonMapper.selectByExample(example);
		for(JdPersons j : persons ){
			j.setPhoto(null);
			
	    	  j.setAction(ActionUtil.delete.getCode());
	    	  j.setVersion(System.currentTimeMillis());
	    	  jdpersonMapper.updateByPrimaryKeySelective(j);
	    	  logger.info("定时清理过期人脸:"+JSON.toJSONString(j));
		}
		
	}
	
	@Scheduled(cron = "0 30 18 * * ? ")
	public  void  delPeople(){
		JdPersonsExample  example  = new JdPersonsExample();
		Criteria criteria  = example.createCriteria();
		criteria.andActionEqualTo(ActionUtil.delete.getCode());
		
		List<JdPersons>  persons = jdpersonMapper.selectByExample(example);
		for(JdPersons j : persons ){
			if((new Date().getTime() -j.getVersion()) > 1*60*60*1000 ){
				jdpersonMapper.deleteByPrimaryKey(j.getUuid());
				 logger.info("清理删除数据:"+JSON.toJSONString(j));
			}
	    	 
		}
		
	}
	
}
