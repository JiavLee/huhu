package top.banbianjia.huhu.coloud.remote;


import org.springframework.cloud.openfeign.FeignClient;
import top.banbianjia.cloud.common.prekey.KeyPrefix;

import java.util.Map;

@FeignClient(name = "redis-server")
public interface MemberCacheApi {
    /**
     * 设置进入缓存
     *
     * @param keyPrefix 前缀
     * @param key
     * @param data
     * @param <T>
     */
    <T> void set(KeyPrefix keyPrefix, String key, T data);

    /**
     * 从缓存中获得
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param clazz     返回的类的类型
     * @param <T>
     * @return
     */
    <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz);

    /**
     * 时间轴+1
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    Long incr(KeyPrefix keyPrefix, String key);

    /**
     * 时间轴-1
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    Long decr(KeyPrefix keyPrefix, String key);

    /**
     * 查看是否存在
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    boolean exists(KeyPrefix keyPrefix, String key);

    /**
     * 设置到期时间
     *
     * @param keyPrefix     前缀
     * @param key           关键字
     * @param expireSeconds 时间
     * @return
     */
    Long expire(KeyPrefix keyPrefix, String key, int expireSeconds);

    /**
     * 设置hash
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param field     字段
     * @param data      对象
     * @param <T>
     */
    <T> void hset(KeyPrefix keyPrefix, String key, String field, T data);

    /**
     * 获得hash
     *
     * @param keyPrefix
     * @param key
     * @param field
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T hget(KeyPrefix keyPrefix, String key, String field, Class<T> clazz);

    /**
     * 获得hash中的全部
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param clazz     类
     * @param <T>
     * @return
     */
    <T> Map<String, T> hgetAll(KeyPrefix keyPrefix, String key, Class<T> clazz);
}
