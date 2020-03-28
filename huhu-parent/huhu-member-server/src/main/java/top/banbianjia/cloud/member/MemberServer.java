package top.banbianjia.cloud.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
//远程调用的包
@EnableFeignClients("top.banbianjia.cloud.member.repository.remote")
@MapperScan("top.banbianjia.cloud.member.mapper")
public class MemberServer {
    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class);
    }
}
