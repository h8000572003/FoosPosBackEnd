package com.food.pos.json;

public enum ReqCode {

	ADD_BIll("A001", "新增BILL"), //
	MODIFY_BIll("B001", "修改BILL"), //
	DELETE("D001", "刪除BILL"), //
	;

	private final String code;
	private final String name;

	private ReqCode(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
