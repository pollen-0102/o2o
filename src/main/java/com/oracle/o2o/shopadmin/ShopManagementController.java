package com.oracle.o2o.shopadmin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.o2o.dto.ImageHolder;

import com.oracle.o2o.entity.PersonInfo;
import com.oracle.o2o.entity.Shop;
import com.oracle.o2o.enums.ShopExecution;
import com.oracle.o2o.enums.ShopStateEnum;
import com.oracle.o2o.exception.ShopOperationException;
import com.oracle.o2o.service.AreaService;
import com.oracle.o2o.service.ShopService;
import com.oracle.utils.CodeUtil;
import com.oracle.utils.HttpServletRequestUtil;
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;
	 
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	//从表单中传来的店铺信息都会保存在request对象中
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		// 1.接收并转化相应的参数，包括店铺信息以及图片信息
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		//ObjectMapper是com.fasterxml.jackson.databind.ObjectMapper; 用于json和pojo对象的转换。
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			//将店铺注册表单中接收到的shop信息转成shop对象
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//接收图片
		CommonsMultipartFile shopImg = null;
		//request.getSession().getServletContext() 从本次会话当中的上下文获取上传文件的内容
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//判断request中是否有上传的文件流
		if (commonsMultipartResolver.isMultipart(request)) {
			//如果有，先做类型转换。将request转成multipartHttpServletRequest
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			//获取到文件流
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}
		// 2.注册店铺
		if (shop != null && shopImg != null) {
           //没有登录前测试要自己创建一个对象给一下userId=1
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			shop.setOwner(owner);
			ShopExecution se;
			try {
				ImageHolder imageHolder = new ImageHolder(shopImg.getOriginalFilename(), shopImg.getInputStream());
				se = shopService.addShop(shop, imageHolder);
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
					// 该用户可以操作的店铺列表
					@SuppressWarnings("unchecked")
					List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
					if (shopList == null || shopList.size() == 0) {
						shopList = new ArrayList<Shop>();
					}
					shopList.add(se.getShop());
					request.getSession().setAttribute("shopList", shopList);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;
		}
	}
 
}
