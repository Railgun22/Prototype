package com.prototype.enums;

public enum StringEnums {
	
	SOURCE_FILE("Please enter the source file: "),
	DESTINATION_FILE("Please enter the destination file: "),
	TITLE_BAR("Notice");
	
	private String iStringValues;
	
	StringEnums(String iStringValues) {
		this.iStringValues = iStringValues;
	} 
	
	public String getString() {
		return iStringValues;
	}
}
