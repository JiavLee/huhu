package top.banbianjia.cloud.redis.cache.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/test")
    public String tets() {
        return "xxx";
    }
}
