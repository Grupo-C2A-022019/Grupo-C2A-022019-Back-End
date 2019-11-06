package ar.edu.unq.dapp.c2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.yuequan.jpa.soft.delete.repository.EnableJpaSoftDeleteRepositories;
import org.zalando.jackson.datatype.money.MoneyModule;

@SpringBootApplication
@EnableJpaSoftDeleteRepositories
@EnableScheduling
public class Application {

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public void configureMoneyMapper() {
        objectMapper.registerModule(new MoneyModule());
    }
}
