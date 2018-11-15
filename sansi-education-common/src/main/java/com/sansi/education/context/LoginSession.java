package com.sansi.education.context;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**登录用户模型
 * @author yihang.lv 2018/11/06、15:45
 */
@Data
public class LoginSession implements Serializable {
    private String ip;
    private String sessionKey;
    private Long id;
    private String mobile;
    /**
     * 用于同步的线程信号量，当信号量的值为0时，阻塞的线程（object.wait（）后的代码）可以执行
     */
    public CountDownLatch latch;

    public LoginSession(String ip, String sessionKey, Long id, String mobile, CountDownLatch latch) {
        this.ip = ip;
        this.sessionKey = sessionKey;
        this.id = id;
        this.mobile = mobile;
        this.latch = latch;
    }

    public static LoginSessionBuilder builder(){
        return new LoginSession.LoginSessionBuilder();
    }

    public static class LoginSessionBuilder{
        private String ip;
        private String sessionKey;
        private Long id;
        private String mobile;
        /**
         * 用于同步的线程信号量，当信号量的值为0时，阻塞的线程（object.wait（）后的代码）可以执行
         */
        public CountDownLatch latch;

        public LoginSessionBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public LoginSessionBuilder sessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
            return this;
        }

        public LoginSessionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public LoginSessionBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public LoginSessionBuilder latch(CountDownLatch latch) {
            this.latch = latch;
            return this;
        }

        public LoginSession build(){
            return new LoginSession(this.ip,this.sessionKey, this.id,this.mobile, this.latch);
        }
    }
}
