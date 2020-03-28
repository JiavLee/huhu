package top.banbianjia.cloud.redis.cache.redisexception;

public class RedisServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    private int code;
    private Object payload;

    public RedisServiceException(RedisCodeMsg redisCodeMsg) {
        super(redisCodeMsg.getMsg());
        this.code = redisCodeMsg.getCode();
        this.msg = redisCodeMsg.getMsg();
    }

    public RedisServiceException(String msg) {
        super(msg);
        this.code = 3000;
        this.msg = msg;
    }

    public RedisServiceException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RedisServiceException(String msg, int code, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
    }

    public RedisServiceException(String msg, int code, Throwable cause, Object payload) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
        this.payload = payload;
    }

    public RedisServiceException(String msg, int code, Object payload) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.payload = payload;
    }
}
