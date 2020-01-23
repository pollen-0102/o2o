package com.oracle.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.o2o.BaseTest01;
import com.oracle.o2o.entity.Area;
import com.oracle.o2o.service.AreaService;


public class AreaServiceTest extends BaseTest01 {
	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
//		assertEquals("Î÷Ô·", areaList.get(0).getAreaName());
		System.out.println(areaList);
	}
}
