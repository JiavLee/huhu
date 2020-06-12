package top.banbianjia.cloud.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class ApolloServer {
    public static void main(String[] args) {
        SpringApplication.run(ApolloServer.class);
        System.out.println("1");
    }
}
