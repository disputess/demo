/**
 * @author pautcher
 * @date 2014-12-31
 * 
 */
package com.example.web.enums;

abstract public class EnumType {

	protected int type;
	protected String name;

	protected EnumType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
