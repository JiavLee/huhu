package top.banbianjia.cloud.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@MapperScan("top.banbianjia.cloud.member.mapper")
public class MemberServer {
    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class);
    }
}
