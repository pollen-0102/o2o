package com.oracle.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oracle.o2o.BaseTest;
import com.oracle.o2o.entity.Area;
import com.oracle.o2o.entity.PersonInfo;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testInsertShop() {
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
		shop.setShopName("���Եĵ���");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("�����");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	@Test
	public void testupdat() {
		Shop shop =new Shop();
		shop.setPhone("���Ը��µ绰����");
		shop.setAdvice("���Ը��½���");
		shop.setShopId(45L);
		int i=shopDao.updateShop(shop);
	
		assertEquals(1, i);
	}
	 @Test
		public void testUpdateShop() {
			Shop shop = new Shop();
			shop.setShopId(1L);
			shop.setShopDesc("��������");
			shop.setShopAddr("���Ե�ַ");
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.updateShop(shop);
			assertEquals(1, effectedNum);
		}

}