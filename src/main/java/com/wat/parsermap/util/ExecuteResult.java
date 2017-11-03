/**
 * Copyright (c) 2015（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * ExecuteResult.java
 * 描述：
 *
 * 当前版本：1.0
 *
 * 创建时间：Jun 3, 2015
 * 作者: 阮进喜
 */

package com.wat.parsermap.util;

/**
 * @author jinxi
 *
 */
public class ExecuteResult extends EBoolean {
	
	private String errorMessage;
	
	public ExecuteResult(boolean r) {
		super(r);
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
