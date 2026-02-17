package com.mashibing.springboot.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * DAOtranslatedText，translatedTextMybatisGeneratortranslatedText
 * @param <Model> The Model Class translatedTextModeltranslatedText
 * @param <PK> The Primary Key Class translatedText，translatedTextModeltranslatedText，translatedTextKeytranslatedText
 * @param <E> The Example Class
 */
public interface MyBatisBaseDao<Model, PK extends Serializable, E> {
    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> selectByExample(E example);

    Model selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") E example);

    int updateByExample(@Param("record") Model record, @Param("example") E example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}