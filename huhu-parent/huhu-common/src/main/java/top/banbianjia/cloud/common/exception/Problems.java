package top.banbianjia.cloud.common.exception;

public class Problems {
    /**
     * 成功
     */
    public static final int OK = 200;

    /**
     * 系统错误
     */
    public static final int ERROR_500 = 500;

    public static final int ERROR_404 = 404;

    public static final int ERROR_401 = 401;

    /**
     * 业务逻辑错误 Service 处理的业务逻辑
     */
    public static final int LOGIN_ERROR = 5001;
    public static final int BUSINESS_ERROR = 3000;
}