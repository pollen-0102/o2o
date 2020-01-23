package com.oracle.utils;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	/**
	 * �����֤���Ƿ��Ԥ�����
	 * 
	 * @param request
	 * @return
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//��session�л�ȡKaptCha���ɵ���֤��
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//�ӱ��л�ȡ�û���д����֤��
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
