package top.banbianjia.cloud.redis.cache.redisexception;

import lombok.Getter;
import top.banbianjia.cloud.common.response.CodeMsg;

public class RedisCodeMsg extends CodeMsg {
    public RedisCodeMsg(int code, String msg) {
        super(code, msg);
    }

    public static RedisCodeMsg REDIS_ERROR = new RedisCodeMsg(500201, "服务繁忙稍后再试");
}
