/**
 * Copyright (c) 2015（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * ExecuteUtil.java
 * 描述：
 *
 * 当前版本：1.0
 *
 * 创建时间：May 28, 2015
 * 作者: 阮进喜
 */

package com.wat.parsermap.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecuteUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteUtil.class);

	public static ExecuteResult exec(String commands, int tryNum, ILogParser logParser) {
		ExecuteResult r = new ExecuteResult(false);
		for (int i = 0; i < tryNum; i++) {
			r = exec(commands, logParser);
			if (r.isRight()) {
				break;
			}
		}
		return r;
	}

	public static ExecuteResult exec(String commands, ILogParser logParser) {
		ExecuteResult r = new ExecuteResult(false);
		Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象
		try {
			
			Process p = run.exec(commands);// 启动另一个进程来执行命令
			r = runProcess(p, logParser);
		} catch (Exception e) {
			r.setResult(false);
			r.setErrorMessage(e.getMessage());
			LOGGER.error(e.getMessage());
		}
		System.out.println(commands + " || result : " + r.isRight());
		return r;
	}

	private static ExecuteResult runProcess(Process p, ILogParser logParser) {

		BufferedInputStream in = null;
		BufferedReader inBr = null;

		ExecuteResult r = new ExecuteResult(false);

		try {
			in = new BufferedInputStream(p.getInputStream());
			inBr = new BufferedReader(new InputStreamReader(in));

			int lineno = 0;
			String lineStr;
			MessageContainer msglist = new MessageContainer();
			while ((lineStr = inBr.readLine()) != null) {
				// 获得命令执行后在控制台的输出信息
				msglist.add(lineStr + System.lineSeparator());
				if (logParser != null) {
					logParser.parseLine(lineno, lineStr);
					lineno++;
				}

			}
			r.setMessage(msglist.toString());
			// 检查命令是否执行失败
			if (p.waitFor() != 0) {
				if (p.exitValue() != 0) {// p.exitValue()==0表示正常结束，1：非正常结束
					inBr.close();
					in.close();
					in = new BufferedInputStream(p.getErrorStream());
					inBr = new BufferedReader(new InputStreamReader(in));
					String errormsg = "";
					while ((lineStr = inBr.readLine()) != null) {
						errormsg += lineStr + System.lineSeparator();

						r.setErrorMessage(errormsg);
					}
					r.setResult(false);
				} else {
					r.setResult(true);
				}
			} else {
				r.setResult(true);
			}

			if (logParser != null) {
				logParser.endParser();
			}
			System.out.println("process exit value :::: " + p.exitValue());
		} catch (Exception e) {
			e.printStackTrace();
			r.setResult(false);
			r.setErrorMessage(e.getMessage());
			LOGGER.error(e.getMessage());
		} finally {

			try {
				if (inBr != null) {
					inBr.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return r;
	}

}
