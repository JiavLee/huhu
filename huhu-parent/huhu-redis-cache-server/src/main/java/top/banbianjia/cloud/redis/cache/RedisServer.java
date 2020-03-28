package top.banbianjia.cloud.redis.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(value = "redis-server")
public class RedisServer {
    public static void main(String[] args) {
        SpringApplication.run(RedisServer.class);
    }
}
