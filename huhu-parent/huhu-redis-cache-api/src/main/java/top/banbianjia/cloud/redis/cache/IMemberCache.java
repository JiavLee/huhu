package top.banbianjia.cloud.redis.cache;

import top.banbianjia.cloud.common.prekey.KeyPrefix;

import java.util.Map;

public interface IMemberCache {
    <T> void set(KeyPrefix keyPrefix, String key, T data);

    <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz);

    Long incr(KeyPrefix keyPrefix, String key);

    Long decr(KeyPrefix keyPrefix, String key);

    boolean exists(KeyPrefix keyPrefix, String key);

    Long expire(KeyPrefix keyPrefix, String key, int expireSeconds);

    <T> void hset(KeyPrefix keyPrefix, String key, String field, T data);

    <T> T hget(KeyPrefix keyPrefix, String key, String field, Class<T> clazz);

    <T> Map<String, T> hgetAll(KeyPrefix keyPrefix, String key, Class<T> clazz);
}
