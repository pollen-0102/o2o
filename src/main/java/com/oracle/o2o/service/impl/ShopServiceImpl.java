package com.oracle.o2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.oracle.o2o.dao.ShopDao;
import com.oracle.o2o.dto.ImageHolder;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.enums.ShopStateEnum;
import com.oracle.o2o.exception.ShopOperationException;
import com.oracle.o2o.service.ShopService;
import com.oracle.utils.ImageUtil;
import com.oracle.utils.PathUtil;
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
 
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		// 获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		// 空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					// 存储图片
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					// 更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}
}
