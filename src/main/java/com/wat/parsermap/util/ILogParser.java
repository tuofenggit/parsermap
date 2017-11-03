/**
 * Copyright (c) 2016（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * ILogParser.java
 * 描述：解析log日志的接口
 *
 * 当前版本：1.0
 *
 * 创建时间：Dec 19, 2016
 * 作者: jinxi
 */

package com.wat.parsermap.util;

public interface ILogParser {
	/**
	 * 解析一行
	 * @param lineno		行号
	 * @param line			日志第几行的内容
	 */
	public void parseLine(long lineno, String line);
	
	/**
	 * 因为获取超算的网格划分和求解的日志，是定时分批下载的
	 * 每次解析日志文件，结束时调用的方法
	 */
	public void endParser();
	
	/**
	 * 所有日志都解析完时，调用的方法
	 */
	public void end();

}
