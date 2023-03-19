package com.kshrd.registration.repository;

import com.kshrd.registration.model.Education;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EducationRepo {
    @Select("SELECT * FROM education WHERE id = #{EduId}")
    Education getEducationById(Integer EduId);

    @Select("SELECT * FROM education")
    List<Education> getAllEducation();
}
