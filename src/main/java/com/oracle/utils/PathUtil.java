package com.oracle.utils;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");
	//������ĿͼƬ�ĸ�·��
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
//windows
			basePath = "D:/projectdev/image";
		} else {
			//linux
			basePath = "/users/work/image";
		}
		//��/�滻��ϵͳ��Ӧ�ķָ���
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	//���ݲ�ͬ��ҵ�����󣬷�����ĿͼƬ��·�����罫ͼƬ�ֱ�洢�ڸ��Եĵ�����
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}