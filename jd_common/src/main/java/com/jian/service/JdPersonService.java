package com.jian.service;

import java.util.List;

import com.jian.entity.JdPersons;
import com.jian.util.ResultUtil;

public interface JdPersonService {
     ResultUtil  insertPersons(List<JdPersons> jdPersons);
     
     ResultUtil  updatePersons(List<JdPersons> jdPersons);
     
     ResultUtil deletePersons(List<JdPersons>  jdPersons);
     
     
     List<JdPersons>  getJdPersonsByVersion(String deviceSeril , long version);
     
}
