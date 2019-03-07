package com.jian.dao;

import com.jian.entity.LjClient;
import com.jian.entity.LjClientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LjClientMapper {
    long countByExample(LjClientExample example);

    int deleteByExample(LjClientExample example);

    int deleteByPrimaryKey(String deviceSeril);

    int insert(LjClient record);

    int insertSelective(LjClient record);

    List<LjClient> selectByExampleWithRowbounds(LjClientExample example, RowBounds rowBounds);

    List<LjClient> selectByExample(LjClientExample example);

    LjClient selectByPrimaryKey(String deviceSeril);

    int updateByExampleSelective(@Param("record") LjClient record, @Param("example") LjClientExample example);

    int updateByExample(@Param("record") LjClient record, @Param("example") LjClientExample example);

    int updateByPrimaryKeySelective(LjClient record);

    int updateByPrimaryKey(LjClient record);
}