/**
 * Copyright (c) 2015（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * MeshTask.java
 * 描述：
 *
 * 当前版本：1.0
 *
 * 创建时间：Jul 28, 2016
 * 作者: WangHongMei
 */

package com.wat.parsermap.util;

import java.io.Serializable;
import java.util.Map;

/**
 * @author WangHongMei
 *
 */
public class MeshTask extends Task implements Serializable {
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742788923558501879L;

	private long pid;
	
	private String meshName;
	
	private String endTime;
	
	private String startTime;
	
	private Map<String,Object> result;
	
	private Map<String,Object> properties;//输出数据对象
	
	private String id;
	


	/**
	 * @param name
	 */
	public MeshTask(String MESHING) {
		super(MESHING);
	}

	public long getPid() {
		return pid;
	}
	
	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getMeshName() {
		return meshName;
	}

	public void setMeshName(String meshName) {
		this.meshName = meshName;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
