package com.ctl.telepresencek8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TelepresenceK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelepresenceK8sApplication.class, args);
    }
}
