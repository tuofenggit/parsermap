package com.wat.parsermap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketController {

	@RequestMapping("/test")
	public String test() {
		return "webSocket";
	}
	
	@RequestMapping("/test1")
	public @ResponseBody String test1() {
		return "11";
	}
}
