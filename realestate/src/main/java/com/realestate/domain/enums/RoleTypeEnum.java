package com.realestate.domain.enums;

public enum RoleTypeEnum {
	
	ROLE_CUSTOMER("Customer"),
	
	ROLE_ADMIN("Administrator");
	
	private String name;

	private RoleTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	

}
