package com.kshrd.registration.repository;

import com.kshrd.registration.exception.ListTypeHandler;
import com.kshrd.registration.model.Generation;
import com.kshrd.registration.model.Province;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GenerationRepo {
    @Select("SELECT * FROM generation WHERE id = #{genId}")
    @Results(id = "generationResults", value = {
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "delayDay", column = "delay_day"),
            @Result(property = "examUrl", column = "exam_url", typeHandler = ListTypeHandler.class),
            @Result(property = "timelineUrl", column = "timeline_url"),
    })
    Generation getGenerationById(Integer genId);

    @Select("SELECT * FROM generation WHERE status = true")
    @ResultMap("generationResults")
    Generation getOpenGeneration();
}
