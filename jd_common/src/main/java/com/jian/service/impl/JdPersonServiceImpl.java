package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jian.dao.JdPersonsMapper;
import com.jian.dao.LjClientMapper;
import com.jian.entity.JdPersons;
import com.jian.entity.JdPersonsExample;
import com.jian.entity.JdPersonsExample.Criteria;
import com.jian.service.JdPersonService;
import com.jian.util.ActionUtil;
import com.jian.util.FaceUtil;
import com.jian.util.FileUtil;
import com.jian.util.ResultUtil;
import com.jian.util.UuidUtil;

@Service
public class JdPersonServiceImpl  implements  JdPersonService {
	Logger  logger = LoggerFactory.getLogger(JdPersonServiceImpl.class);
	@Resource
	JdPersonsMapper  ljPersonMapper;
	@Resource
	LjClientMapper ljDeviceMapper;

	@Override
	public ResultUtil insertPersons(List<JdPersons> jdPersons) {
		ResultUtil resultUtil = new ResultUtil();
		if(jdPersons.size() <= 0 )
			return new ResultUtil(-1, "人员数据为空");
		String face_msg = null;
		int  count = 0;
		for (JdPersons lp : jdPersons) {
			try {
				lp.setUuid(UuidUtil.getUUID());
				JdPersonsExample example = new JdPersonsExample();
				Criteria criteria  = example.createCriteria();
				criteria.andActionNotEqualTo(ActionUtil.delete.getCode());
				criteria.andDeviceSerilEqualTo(lp.getDeviceSeril());
				criteria.andIdCardEqualTo(lp.getIdCard());
				List<JdPersons>  lp_2  = ljPersonMapper.selectByExample(example);
				if(lp_2.size() > 0 ){
						face_msg ="已存在";
						lp.setPhoto("");
						resultUtil.setData(JSON.toJSON(lp).toString());
						break;
				}
				
				if(ljDeviceMapper.selectByPrimaryKey(lp.getDeviceSeril()) == null){
					face_msg = "设备序列号不存在";
					lp.setPhoto(null);
					resultUtil.setData(lp);
					break;
				}
				
				byte[] bs = FileUtil.Base642Byte(lp.getPhoto());
				if (bs != null)
					face_msg = FaceUtil.DetectFace(bs);
				if(StringUtils.isNotEmpty(face_msg)){
					resultUtil.setData(JSON.toJSON(lp).toString());
					break;
				}
				lp.setPhoto(FileUtil.addPicture2Midkirs(bs, lp.getIdCard(),"upload/images/"));
				lp.setPhotoFeature(FaceUtil.getFeature(bs));
				lp.setAction(ActionUtil.insert.getCode());
				lp.setVersion(System.currentTimeMillis());
				if(StringUtils.isEmpty(lp.getPhoto())){
					resultUtil.setData(lp);
					face_msg = "500,存入图片异常";
					break;
				}
				
					count +=ljPersonMapper.insert(lp);
			} catch (IllegalArgumentException e) {
				face_msg = "base64解码错误";
				resultUtil.setData(JSON.toJSON(lp).toString());
				break;
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(), e);
				face_msg = "创建失败";
				lp.setPhotoFeature(null);
			   resultUtil.setData(JSON.toJSON(lp).toString());
			   break;
			}
		}
		if (StringUtils.isNotEmpty(face_msg)) {
			resultUtil.setCode(-1);
			resultUtil.setMsg(face_msg);
		}else{
			resultUtil.setCode(0);
			resultUtil.setCount(count);
			resultUtil.setMsg("创建成功");
		}
		return resultUtil;
	}

	@Override
	public ResultUtil updatePersons(List<JdPersons> jdPersons) {
		ResultUtil resultUtil = new ResultUtil();
		String face_msg = null;
		int  count = 0;
		for (JdPersons lp : jdPersons) {
			try {
				JdPersonsExample example = new JdPersonsExample();
				Criteria criteria  = example.createCriteria();
				criteria.andActionNotEqualTo(ActionUtil.delete.getCode());
				if(StringUtils.isNotEmpty(lp.getOld_idCard()))
					criteria.andIdCardEqualTo(lp.getOld_idCard());
				else
					criteria.andIdCardEqualTo(lp.getIdCard());
				criteria.andDeviceSerilEqualTo(lp.getDeviceSeril());
				
				List<JdPersons>  jdPersons2  = ljPersonMapper.selectByExampleWithBLOBs(example);
				if(jdPersons2.size() <= 0){
					face_msg ="不存在";
					lp.setPhoto("");
					resultUtil.setData(JSON.toJSON(lp).toString());
					break;
				}
                	byte[] bs = FileUtil.Base642Byte(lp.getPhoto());
    				if (bs != null)
    					face_msg = FaceUtil.DetectFace(bs);
    				if(StringUtils.isNotEmpty(face_msg)){
    					resultUtil.setData(JSON.toJSON(lp).toString());
    					break;
    				}
    				lp.setPhoto(FileUtil.addPicture2Midkirs(bs, lp.getIdCard() ,"upload/images/"));
    				lp.setPhotoFeature(FaceUtil.getFeature(bs));
    				if(StringUtils.isEmpty(lp.getPhoto())){
    					resultUtil.setData(lp);
    					face_msg = "500,存入图片异常";
    					break;
    				}
    				if(StringUtils.isNotEmpty(lp.getOld_idCard())){
    					for(JdPersons  j : jdPersons2){
    						j.setAction(ActionUtil.delete.getCode());
    						j.setVersion(System.currentTimeMillis());
    						count += ljPersonMapper.updateByExampleSelective(j, example);
    					}
    					
    				}else{
    					lp.setAction(ActionUtil.update.getCode());
    					lp.setVersion(System.currentTimeMillis());
        				
    					
        				count += ljPersonMapper.updateByExampleSelective(lp, example);
    				}
    				
    				
    				if(StringUtils.isNotEmpty(lp.getOld_idCard())){
    					lp.setUuid(UuidUtil.getUUID());
    					lp.setAction(ActionUtil.insert.getCode());
    					lp.setVersion(System.currentTimeMillis());
    					ljPersonMapper.insertSelective(lp);
    				}
    					
			} catch (IllegalArgumentException e) {
				face_msg = "base64解码错误";
				resultUtil.setData(JSON.toJSON(lp).toString());
				break;
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(), e);
				face_msg = "更新失败";
				lp.setPhotoFeature(null);
			   resultUtil.setData(JSON.toJSON(lp).toString());
			   break;
			}
		}
		if (StringUtils.isNotEmpty(face_msg)) {
			resultUtil.setCode(-1);
			resultUtil.setMsg(face_msg);
		}else{
			resultUtil.setCode(0);
			resultUtil.setCount(count);
			resultUtil.setMsg("更新成功");
		}
		return resultUtil;
	}

	@Override
	public ResultUtil deletePersons(List<JdPersons> jdPersons) {
		 ResultUtil  resultUtil  = new ResultUtil();
	      String msg = null;
	      int count =0 ;
	      for(JdPersons  lp : jdPersons){
	    	  JdPersonsExample example = new JdPersonsExample();
				Criteria criteria  = example.createCriteria();
				criteria.andActionNotEqualTo(ActionUtil.delete.getCode());
				criteria.andIdCardEqualTo(lp.getIdCard());
				criteria.andDeviceSerilEqualTo(lp.getDeviceSeril());
				
				List<JdPersons>  jdPersons2  = ljPersonMapper.selectByExampleWithBLOBs(example);
				if(jdPersons2.size() <= 0){
					msg ="不存在";
					lp.setPhoto("");
					resultUtil.setData(JSON.toJSON(lp).toString());
					break;
				}
	    	  lp.setPhoto(null);
	    	  lp.setAction(ActionUtil.delete.getCode());
	    	  lp.setVersion(System.currentTimeMillis());
	    	  count+= ljPersonMapper.updateByExampleSelective(lp, example);
	      }
	      
	      if (StringUtils.isNotEmpty(msg)) {
				resultUtil.setCode(-1);
				resultUtil.setMsg(msg);
			}else{
				resultUtil.setCode(0);
				resultUtil.setCount(count);
				resultUtil.setMsg("删除成功");
			}
			return resultUtil;
	}

	@Override
	public List<JdPersons> getJdPersonsByVersion(String deviceSeril, long version) {
		JdPersonsExample  example  = new JdPersonsExample();
		example.setOrderByClause("version ASC");
		Criteria criteria = example.createCriteria();
		criteria.andVersionGreaterThan(version);
		criteria.andDeviceSerilEqualTo(deviceSeril);
		
		List<JdPersons>    jdPersons  = ljPersonMapper.selectByExampleWithBLOBs(example);
		if(jdPersons.size() > 10)
			return jdPersons.subList(0, 10);
		else
			return  jdPersons; 
		
	}

}
