package cn.mrain22.vboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.mrain22.vboot"})
public class VbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VbootApplication.class, args);
    }
}
