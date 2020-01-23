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
	//�ӱ��д����ĵ�����Ϣ���ᱣ����request������
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "�����˴������֤��");
			return modelMap;
		}
		// 1.���ղ�ת����Ӧ�Ĳ���������������Ϣ�Լ�ͼƬ��Ϣ
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		//ObjectMapper��com.fasterxml.jackson.databind.ObjectMapper; ����json��pojo�����ת����
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			//������ע����н��յ���shop��Ϣת��shop����
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//����ͼƬ
		CommonsMultipartFile shopImg = null;
		//request.getSession().getServletContext() �ӱ��λỰ���е������Ļ�ȡ�ϴ��ļ�������
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//�ж�request���Ƿ����ϴ����ļ���
		if (commonsMultipartResolver.isMultipart(request)) {
			//����У���������ת������requestת��multipartHttpServletRequest
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			//��ȡ���ļ���
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "�ϴ�ͼƬ����Ϊ��");
			return modelMap;
		}
		// 2.ע�����
		if (shop != null && shopImg != null) {
           //û�е�¼ǰ����Ҫ�Լ�����һ�������һ��userId=1
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			shop.setOwner(owner);
			ShopExecution se;
			try {
				ImageHolder imageHolder = new ImageHolder(shopImg.getOriginalFilename(), shopImg.getInputStream());
				se = shopService.addShop(shop, imageHolder);
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
					// ���û����Բ����ĵ����б�
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
			modelMap.put("errMsg", "�����������Ϣ");
			return modelMap;
		}
	}
 
}
