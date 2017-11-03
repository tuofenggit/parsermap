/**
 * Copyright (c) 2015（年）,北京蓝威技术有限公司
 * All rights reserved.
 *
 * TestCloan.java
 * 描述：
 *
 * 当前版本：1.0
 *
 * 创建时间：Nov 10, 2015
 * 作者: zzh
 */

package com.wat.parsermap.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zihong
 *
 */
public class MessageContainer extends ArrayList<String> {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -7438568382780142774L;
	
	private int maxSize = 1000;
	
	private int maxBytes  = 1024*1024;
	
	private int bytes = 0;
	
	public MessageContainer(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public MessageContainer() {
	}

	@Override
	public boolean add(String e) {
		boolean r = super.add(e);
		removeOverrideItems();
		return r;
	}
	
	
	public boolean toAdd(String e) {
		boolean r = super.add(e);
		removeOverRowItems();
		return r;
	}
	
	public int getSize() {
		int size = 0;
		for (String item : this) {
			size += item.getBytes().length;
		}
		return size;
	}
	
	//删除过度的记录
	private void removeOverrideItems() {
		while(this.size() > maxSize|| getSize() >maxBytes) {
			this.remove(0);
		}
	}
	
	//删除过度的记录
	private void removeOverRowItems() {
		while(this.size() > maxSize) {
			this.remove(0);
		}
	}
	

	@Override
	public void add(int index, String element) {
		super.add(index, element);
		removeOverrideItems();
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		boolean r = super.addAll(c);
		removeOverrideItems();
		
		return r;
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		
		boolean r =  super.addAll(index, c);
		removeOverrideItems();
		
		return r;
	}
	
	
	public boolean addAll(String e) {
		boolean r = super.add(e);
		return r;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String item : this) {
			sb.append(item).append("\n");
		}
		return sb.toString();
	}
	
	
	
	
}
