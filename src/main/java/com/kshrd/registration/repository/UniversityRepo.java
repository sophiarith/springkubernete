package com.kshrd.registration.repository;

import com.kshrd.registration.model.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UniversityRepo {
    @Select("SELECT * FROM university WHERE id = #{universityId}")
    University getUniversityById(Integer universityId);

    @Select("SELECT * FROM university")
    List<University> getAllUniversity();
}
