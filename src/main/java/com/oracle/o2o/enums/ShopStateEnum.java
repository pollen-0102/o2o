package com.oracle.o2o.enums;

public enum ShopStateEnum {
	//ö�����޶���ѡ��ķ�Χ
	 CHECK(0,"�����"),
	 OFFLINE(-1, "�Ƿ�����"), 
	 SUCCESS(1, "�����ɹ�"),
	 PASS(2, "ͨ����֤"), 
	 INNER_ERROR(-1001,"�ڲ�ϵͳ����"), 
	 NULL_SHOPID(-1002, "ShopIdΪ��"),
	 NULL_SHOP(-1003, "shop��ϢΪ��");
	private int state;
	private String stateinfo;
	private ShopStateEnum(int state, String stateinfo) {
		this.state = state;
		this.stateinfo = stateinfo;
	}
	
	/**
	 * ���ݴ����state������Ӧ��enumֵ
	 */
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateinfo;
	}
	

}
