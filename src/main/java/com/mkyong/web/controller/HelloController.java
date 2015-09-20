package com.mkyong.web.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.UnknownHostException;

@Controller
public class HelloController {
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//
//		model.addAttribute("message", "Spring 3 MVC Hello World");
//		return "hello";
//
//	}
//
//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//
//		boolean auth = false;
//		try
//		{
//			MongoClient mongoClient = new MongoClient("127.6.49.4",27017);
//			DB db = mongoClient.getDB("flowers");
//			auth = db.authenticate("admin", "NfAc-CBXGWN9".toCharArray());
//			if(auth)
//			{
//				DBCollection table = db.getCollection("TEST_COLLECTION");
//				BasicDBObject document = new BasicDBObject();
//				document.put("id", 101);
//				document.put("value", "some_value");
//				table.insert(document);
//			}
//		}
//		catch (UnknownHostException e)
//		{
//			e.printStackTrace();
//		}
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("hello");
//		if(auth)
//		{
//			model.addObject("msg", "done");
//		}
//		else
//		{
//			model.addObject("msg", "not done");
//		}
//
//		return model;
//
//	}

}