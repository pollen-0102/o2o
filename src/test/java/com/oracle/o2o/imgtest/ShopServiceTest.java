package com.oracle.o2o.imgtest;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.o2o.BaseTest01;
import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Area;
import com.oracle.o2o.entity.PersonInfo;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.entity.ShopCategory;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.enums.ShopStateEnum;
import com.oracle.o2o.exception.ShopOperationException;
import com.oracle.o2o.service.ShopService;

public class ShopServiceTest extends BaseTest01 {
	@Autowired
	private ShopService shopService;
 
	@Test
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(10L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("≤‚ ‘µƒµÍ∆Ã3");
		shop.setShopDesc("test3");
		shop.setShopAddr("test3");
		shop.setPhone("test3");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("…Û∫À÷–");
		File shopImg = new File("d://a.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, imageHolder );
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

}
