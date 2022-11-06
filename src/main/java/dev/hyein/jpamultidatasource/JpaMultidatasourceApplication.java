package dev.hyein.jpamultidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("dev.hyein.jpamultidatasource.entity.member")
public class JpaMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaMultidatasourceApplication.class, args);
    }

}
