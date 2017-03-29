package com.mufeng.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	public String execute(){
ActionContext actionContext=ActionContext.getContext();

Map<String, Object> applicationMap=actionContext.getApplication();
applicationMap.put("applicationKey", "applicationValue");
System.out.println(applicationMap);
Object date=applicationMap.get("date");
System.out.println("date: " + date);

Map<String,Object> sessionMap=actionContext.getSession();
sessionMap.put("sessionKey", "sessionValue");

System.out.println(sessionMap.getClass()); 
if(sessionMap instanceof SessionMap){
	SessionMap sm = (SessionMap) sessionMap;
	sm.invalidate();
	System.out.println("session 失效了. ");
}
Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
requestMap.put("requestKey", "requestValue");

//4. 获取请求参数对应的 Map, 并获取指定的参数值. 
//键: 请求参数的名字, 值: 请求参数的值对应的字符串数组
//注意: 1. getParameters 的返回值为在 Map<String, Object>, 而不是 Map<String, String[]>
//     2. parameters 这个 Map 只能读, 不能写入数据, 如果写入, 但不出错, 但也不起作用!
HttpParameters parameters = actionContext.getParameters();
System.out.println(parameters);

return "success";


	}
}
