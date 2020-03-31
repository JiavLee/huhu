package top.banbianjia.cloud.redis.cache.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.banbianjia.cloud.common.prekey.KeyPrefix;
import top.banbianjia.cloud.redis.cache.IMemberCache;
import top.banbianjia.cloud.redis.cache.redisexception.RedisCodeMsg;
import top.banbianjia.cloud.redis.cache.redisexception.RedisServiceException;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类是作为远程调用使用的
 */
@RestController
@RequestMapping("/redis")
public class MemberRedisCacheImpl implements IMemberCache {
//    public static final String PACKAGE_BEAN_NAME = "MemberRedisCacheImpl";
    @Autowired
    private JedisPool pool;

    //set方法
    @GetMapping("/set")
    public <T> void set(KeyPrefix keyPrefix, String key, T data) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            String strVal = JSON.toJSONString(data);
            if (keyPrefix.getExpireSeconds() > 0) {
                //这个key是设置了指定的失效时间
                jedis.setex(realKey, keyPrefix.getExpireSeconds(), strVal);
            } else {
                //这个key是没有设置有效时间的.
                jedis.set(realKey, strVal);
            }
        } catch (Exception ex) {
            throw new RedisServiceException(ex.getMessage());
        }
    }

    //get方法
    @GetMapping("/get")
    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            String strVal = jedis.get(realKey);
            if (StringUtils.isEmpty(strVal)) {
                return null;
            }
            return JSON.parseObject(strVal, clazz);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //incr方法
    @GetMapping("/incr")
    public Long incr(KeyPrefix keyPrefix, String key) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.incr(realKey);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //decr方法
    @GetMapping("/decr")
    public Long decr(KeyPrefix keyPrefix, String key) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.decr(realKey);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //exist方法
    @GetMapping("/exists")
    public boolean exists(KeyPrefix keyPrefix, String key) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.exists(realKey);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //expire方法
    @GetMapping("/expire")
    public Long expire(KeyPrefix keyPrefix, String key, int expireSeconds) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.expire(realKey, expireSeconds);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //hset
    @GetMapping("/hset")
    public <T> void hset(KeyPrefix keyPrefix, String key, String field, T data) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            jedis.hset(realKey, field, JSON.toJSONString(data));
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //hget
    @GetMapping("/hget")
    public <T> T hget(KeyPrefix keyPrefix, String key, String field, Class<T> clazz) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            String strVal = jedis.hget(realKey, field);
            return JSON.parseObject(strVal, clazz);
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }

    //hgetAll
    @GetMapping("/hgetAll")
    public <T> Map<String, T> hgetAll(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        try (Jedis jedis = pool.getResource();) {
            String realKey = keyPrefix.getPrefix() + key;
            Map<String, String> map = jedis.hgetAll(realKey);
            Map<String, T> resultMap = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                resultMap.put(entry.getKey(), JSON.parseObject(entry.getValue(), clazz));
            }
            return resultMap;
        } catch (Exception ex) {
            throw new RedisServiceException(RedisCodeMsg.REDIS_ERROR);
        }
    }
}
