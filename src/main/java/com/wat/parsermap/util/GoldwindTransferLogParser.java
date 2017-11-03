/**
 * Copyright (c) 2016（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * GoldwindTransferLogParser.java
 * 描述：map转换成热力图的进度解析
 *
 * 当前版本：1.0
 *
 * 创建时间：Aug 31, 2017
 * 作者: jinxi
 */

package com.wat.parsermap.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("prototype")
public class GoldwindTransferLogParser implements ILogParser {

	private String filename;
	
	private Long userId;
	
	private MeshTask meshtask = new MeshTask("transferprocess");
	
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/*@Bean
    public SystemWebSocketHandler systemWebSocketHandler() {
        return new SystemWebSocketHandler();
    }*/
	
	@Override
	public void parseLine(long lineno, String line) {
		//percentage:5%
		if (line.startsWith("percentage")) {
			
			Pattern p = Pattern.compile("percentage:(\\d+%)");
			Matcher m = p.matcher(line);
			if (m.find()) {
				String percentage = m.group(1);
				sendProcess(percentage);

			}
		}
	}

	private void sendProcess(String percentage) {

		Map<String, Object> properties = new HashMap<String, Object> ();
		properties.put("filename", filename);
		properties.put("percentage", percentage);
		meshtask.setProperties(properties);
		//systemWebSocketHandler().sendMessageToUser(userId, new TextMessage(new GsonBuilder().create().toJson(meshtask)));
	}

	@Override
	public void endParser() {
	}
	
	
	@Override
	public void end() {
		
	}

}
