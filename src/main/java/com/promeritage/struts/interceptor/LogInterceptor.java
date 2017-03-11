package com.promeritage.struts.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.promeritage.struts.common.ShareTool;

public class LogInterceptor implements Interceptor {

	private static final long serialVersionUID = 5903854770803973823L;

	private final Logger log = Logger.getLogger(this.getClass());

	/*
	 * called during interceptor destruction
	 */

	public void destroy() {
	}

	/*
	 * called during interceptor initialization
	 */

	public void init() {
	}

	/*
	 * put interceptor code here
	 */

	public String intercept(ActionInvocation invocation) throws Exception {
		print(invocation, "argument");

		invocation.addPreResultListener(new PreResultListener() {
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				print(invocation, "return");
			}
		});

		return invocation.invoke();
	}

	/**
	 * 印出每支action的接收或回傳之參數
	 * 
	 * @param invocation
	 * @param status
	 */

	private void print(ActionInvocation invocation, String status) {
		try {
			Object o = invocation.getAction();
			String className = o.getClass().getSimpleName();
			Field[] fieldList = o.getClass().getDeclaredFields();
			for (Field field : fieldList) {
				Annotation[] annotationsList = field.getDeclaredAnnotations();
				if (annotationsList.length == 0) {
					Method[] methodList = o.getClass().getDeclaredMethods();
					for (Method method : methodList) {
						String methodName = invocation.getProxy().getActionName();
						if (StringUtils.equals(method.getName(), "get" + StringUtils.capitalize(field.getName()))) {
							Object arg = method.invoke(o, null);

							/*
							 * 過濾掉不想Log出來的參數
							 */

							if (arg == null || arg.equals("")) {
								continue;
							}

							if (arg instanceof String) {
								log.info(className + "." + methodName + "() " + status + ": " + field.getName() + "["
										+ ShareTool.toStringBuilder(arg) + "]");
							} else {
								log.info(className + "." + methodName + "() " + status + ": "
										+ ShareTool.toStringBuilder(arg));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}