package com.wat.parsermap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import com.google.gson.GsonBuilder;
import com.wat.parsermap.common.Constant;
import com.wat.parsermap.util.ExecuteResult;
import com.wat.parsermap.util.ExecuteUtil;
import com.wat.parsermap.util.GoldwindTransferLogParser;
import com.wat.parsermap.util.MeshTask;

@RestController
public class MapController {

	@RequestMapping(value="parserMap")
	public String parserMap() {
		String cmd = Constant.GOLDWIND_PATH + "goldWind "+Constant.MAP_PATH+"yunnanlzk-xian80-3-35.map" +" 819 " + "false" ;
		
		
		//GoldwindTransferLogParser logParser = (GoldwindTransferLogParser) ApplicationContext.getBean(GoldwindTransferLogParser.class);
		GoldwindTransferLogParser parser = new GoldwindTransferLogParser();
		parser.setFilename("1");
		ExecuteResult r = ExecuteUtil.exec(cmd, parser);
		//MeshTask meshtask = new MeshTask("showimage");
		//meshtask.setPid(1);
		//meshtask.setId(String.valueOf(2));
		//systemWebSocketHandler().sendMessageToUser(fh.getUserId(), new TextMessage(new GsonBuilder().create().toJson(meshtask)));
		//System.err.println("::::::::::"+new TextMessage(new GsonBuilder().create().toJson(meshtask))+"::::::::");
		return r.isRight()+"";
		//return null;
	}

}
