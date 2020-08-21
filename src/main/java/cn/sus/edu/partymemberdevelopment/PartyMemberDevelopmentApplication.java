package cn.sus.edu.partymemberdevelopment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.sus.edu.partymemberdevelopment")
@SpringBootApplication
public class PartyMemberDevelopmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyMemberDevelopmentApplication.class, args);
    }

}
