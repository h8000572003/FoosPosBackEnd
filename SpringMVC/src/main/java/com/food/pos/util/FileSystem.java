package com.food.pos.util;

import java.io.Serializable;

public class FileSystem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path = "";

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
