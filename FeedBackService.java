package com.rhy.feedback.service;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.rhy.feedback.dao.IFeedBackDao;
import com.rhy.feedback.entity.FeedBack;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class FeedBackService implements IFeedBackService {

	@Autowired
	private IFeedBackDao iFeedBackDao;

	@Override
	public String submitFeedBack(String feedbackContent, String contact) {

		FeedBack feedBack = new FeedBack();
		feedBack.setFeedbackContent(feedbackContent);
		feedBack.setContact(contact);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		String strdate = df.format(System.currentTimeMillis()).toString();
		feedBack.setFeedbackDate(strdate);
		ModelAndView model = new ModelAndView();

		if (iFeedBackDao.insertFeedback(feedBack) == 1) {
			model.addObject("flag", "1");
		} else {
			model.addObject("flag", "0");
		}

		return "1";
	}

	@Override
	public JSONObject getFeedBack() {

		List<FeedBack> feedList = iFeedBackDao.getFeedBack();
		JSONArray newfeedBackList = new JSONArray();
		JSONObject returnJson = new JSONObject();
		JSONObject feed;
		for (int i = 0; i < 5; i++) {
			feed = new JSONObject();
			FeedBack feedBack = feedList.get(i);
			feed.put("id", feedBack.getId());
			feed.put("feedbackContent", feedBack.getFeedbackContent());
			feed.put("contact", feedBack.getContact());
			feed.put("feedbackDate", feedBack.getFeedbackDate());
			newfeedBackList.add(feed);
		}

		returnJson.put("status", 200);
		returnJson.put("result", newfeedBackList);
		return returnJson;
	}

}
