package com.rhy.feedback.service;

import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

public interface IFeedBackService {

	JSONObject getFeedBack();

	String submitFeedBack(String feedbackContent, String contact);

}
