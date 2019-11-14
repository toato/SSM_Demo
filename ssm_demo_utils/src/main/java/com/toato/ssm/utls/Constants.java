package com.toato.ssm.utls;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/14 13:40
 */
public class Constants {

    public final static String DEFAULT_STARTPAGE = "1";     // 默认开始页码
    public final static String DEFAULT_PAGESIZE = "5";      // 默认每页数量

    public static enum Page {

        DEFAULT_STARTPAGE("1"),
        DEFAULT_PAGESIZE("5"),        // 默认每页数量
        ;

        Page(String s) {
            this.value = s;
        }

        private final String value;

        public String getValue() {
            return value;
        }
    }

}
