package com.jian.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class FileUtil {
  static Logger  logger  =  LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 获取文件夹路径 
	 * @Title: getMidkirs   
	 * @Description: TODO   
	 * @param: @param path
	 * @param: @return
	 * @param: @throws FileNotFoundException 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public static String getMidkirs(String path) throws FileNotFoundException{
		 File  file;
		try{
			  file  =new File(ResourceUtils.getFile("classpath:").getPath() +"/" +path) ;
			 if(!file.exists())
				 file.mkdirs();
			 return file.getPath();
		}catch(Exception e){
			logger.debug("获取文件目录："+e.getMessage());
		    file  = new File(System.getProperty("user.dir")+"/"+path);
		    if(!file.exists())
		    	file.mkdirs();
		    return file.getPath();
		}
	}
	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 添加照片到文件夹
	 * @Title: addPicture2Midkirs   
	 * @Description: TODO   
	 * @param: @param file
	 * @param: @param name
	 * @param: @param path 方便不同的数据分开文件夹存放
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public  static String   addPicture2Midkirs(byte[] pic , String name , String path ) throws IOException{
		name = name+"_"+UuidUtil.getUUID()+".jpg";
		path = getMidkirs(path);
		File file  =  new File(path+"/"+name);
		if(!file.exists())
			file.createNewFile();
		OutputStream outputStream  = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		bufferedOutputStream.write(pic);
		return name;
		
	}
	
	/**
	 * @throws IOException 
	 * 从文件夹获取照片
	 * @Title: getPicture2Byte   
	 * @Description: TODO   
	 * @param: @param filename
	 * @param: @param path
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: byte[]      
	 * @throws
	 */
	public  static  byte[]  getPicture2Byte(String filename , String path) throws IOException{
		path = getMidkirs(path) +"/"+ filename;
		File  file  = new File(path);
		if(file.exists()){
		InputStream inputStream = new FileInputStream(file);
		byte[]  buf   = new byte[inputStream.available()];
		inputStream.read(buf);
		return buf;
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @Title: Base642Byte   
	 * @Description: TODO   
	 * @param: @param base64
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: byte[]      
	 * @throws
	 */
	public static byte[]  Base642Byte(String base64){
		Base64.Decoder decoder  = Base64.getDecoder();
		if(StringUtils.isNotEmpty(base64))
			return decoder.decode(base64);
		return null;
		
	}
	
	
	/**
	 * 
	 * @Title: img_base64_head   
	 * @Description: TODO   
	 * @param: @param base
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: String      
	 * @throws
	 */
	public  static String  img_base64_head(byte[] base){
		Base64.Encoder  encoder  = Base64.getEncoder();
		if(base != null)
			return "data:image/jpeg;base64," + encoder.encodeToString(base) ;
		return null;
		
	}
}
