package com.rhy.feedback.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rhy.feedback.entity.FeedBack;

@Mapper
public interface IFeedBackDao {

	int insertFeedback(@Param("feedBack") FeedBack feedBack);
	
	List<FeedBack> getFeedBack();

}
