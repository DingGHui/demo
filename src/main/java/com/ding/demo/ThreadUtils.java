package com.ding.demo;

import javax.servlet.http.HttpServletRequest;

public class ThreadUtils {

    private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<HttpServletRequest>();
    /**
     * 当前线程加入request
     * @param request
     */
    public static void setHttpServletRequest(HttpServletRequest request){
        if(request != null){
            threadLocal.set(request);
        }
    }

    /**
     * 当前线程获取request,在API接口中可以直接调用这个方法获取当前线程的request对象
     */
    public static HttpServletRequest getHttpServletRequest(){
        return threadLocal.get();
    }

    /**
     * 清理request，释放空间
     */
    public static void removeHttpServletRequest(){
        threadLocal.remove();
    }
}