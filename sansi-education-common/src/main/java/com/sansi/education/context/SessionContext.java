package com.sansi.education.context;



/**保存session容器
 * @author yihang.lv 2018/11/06、13:12
 */
public class SessionContext {

    private static final ThreadLocal<LoginSession> context = new ThreadLocal<LoginSession>();

    public static ThreadLocal get(){
        return context;
    }


    public static void setSession(LoginSession session){
        context.set(session);
    }

    /**
     * 获取当前线程中的LoginSession对象
     */
    public static LoginSession getSession(){
        return context.get();
    }

    public static void clear(){
        context.remove();
    }
}
