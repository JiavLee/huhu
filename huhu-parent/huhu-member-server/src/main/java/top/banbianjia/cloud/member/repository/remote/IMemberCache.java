package top.banbianjia.cloud.member.repository.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.banbianjia.cloud.common.prekey.KeyPrefix;

import java.util.Map;


@FeignClient(name = "redis-server")
public interface IMemberCache {
    /**
     * 设置进入缓存
     *
     * @param keyPrefix 前缀
     * @param key
     * @param data
     * @param <T>
     */
    @RequestMapping(value = "/redis/set", method = RequestMethod.GET)
    <T> void set(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("data") T data);

    /**
     * 从缓存中获得
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param clazz     返回的类的类型
     * @param <T>
     * @return
     */
    @RequestMapping(value = "/redis/get", method = RequestMethod.GET)
    <T> T get(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("clazz") Class<T> clazz);

    /**
     * 时间轴+1
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    @RequestMapping(value = "/redis/incr", method = RequestMethod.GET)
    Long incr(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key);

    /**
     * 时间轴-1
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    @RequestMapping(value = "/redis/decr", method = RequestMethod.GET)
    Long decr(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key);

    /**
     * 查看是否存在
     *
     * @param keyPrefix
     * @param key
     * @return
     */
    @RequestMapping(value = "/redis/exists", method = RequestMethod.GET)
    boolean exists(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key);

    /**
     * 设置到期时间
     *
     * @param keyPrefix     前缀
     * @param key           关键字
     * @param expireSeconds 时间
     * @return
     */
    @RequestMapping(value = "/redis/expire", method = RequestMethod.GET)
    Long expire(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("expireSeconds") int expireSeconds);

    /**
     * 设置hash
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param field     字段
     * @param data      对象
     * @param <T>
     */
    @RequestMapping(value = "/redis/hset", method = RequestMethod.GET)
    <T> void hset(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("data") T data);

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
    @RequestMapping(value = "/redis/hget", method = RequestMethod.GET)
    <T> T hget(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("clazz") Class<T> clazz);

    /**
     * 获得hash中的全部
     *
     * @param keyPrefix 前缀
     * @param key       关键字
     * @param clazz     类
     * @param <T>
     * @return
     */
    @RequestMapping(value = "/redis/hgetAll", method = RequestMethod.GET)
    <T> Map<String, T> hgetAll(@RequestParam("keyPrefix") KeyPrefix keyPrefix, @RequestParam("key") String key, @RequestParam("clazz") Class<T> clazz);
}