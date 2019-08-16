package com.rhy.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rhy.feedback.service.FeedBackService;

import net.sf.json.JSONObject;

@Controller
public class FeedController {

	@Autowired
    FeedBackService feedBackService;
	
	@RequestMapping(value = "/submitFeedBack", method = RequestMethod.POST)
	public String submitFeedback(@RequestParam("feedbackContent") String feedbackContent, @RequestParam("contact") String contact) {
		feedBackService.submitFeedBack(feedbackContent,contact);
		return "index";
	}
	
	@GetMapping("/getFeedBack")
	@ResponseBody
	public JSONObject getFeedback() {
		return feedBackService.getFeedBack();	
	}
}
