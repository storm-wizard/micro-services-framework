package ucd.healthcare.yanpharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class YanPharmacyApplication {
    public static void main(String[] args){
        SpringApplication.run(YanPharmacyApplication.class, args);
    }
}
