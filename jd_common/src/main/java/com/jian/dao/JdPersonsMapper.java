package com.jian.dao;

import com.jian.entity.JdPersons;
import com.jian.entity.JdPersonsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface JdPersonsMapper {
    long countByExample(JdPersonsExample example);

    int deleteByExample(JdPersonsExample example);

    int deleteByPrimaryKey(String idCard);

    int insert(JdPersons record);

    int insertSelective(JdPersons record);

    List<JdPersons> selectByExampleWithBLOBsWithRowbounds(JdPersonsExample example, RowBounds rowBounds);

    List<JdPersons> selectByExampleWithBLOBs(JdPersonsExample example);

    List<JdPersons> selectByExampleWithRowbounds(JdPersonsExample example, RowBounds rowBounds);

    List<JdPersons> selectByExample(JdPersonsExample example);

    JdPersons selectByPrimaryKey(String idCard);

    int updateByExampleSelective(@Param("record") JdPersons record, @Param("example") JdPersonsExample example);

    int updateByExampleWithBLOBs(@Param("record") JdPersons record, @Param("example") JdPersonsExample example);

    int updateByExample(@Param("record") JdPersons record, @Param("example") JdPersonsExample example);

    int updateByPrimaryKeySelective(JdPersons record);

    int updateByPrimaryKeyWithBLOBs(JdPersons record);

    int updateByPrimaryKey(JdPersons record);
}