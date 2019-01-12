package com.homework.feed;

import com.homework.feed.service.QuotationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

@SpringBootApplication
public class FeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedApplication.class, args);
    }

    @Bean
    public CommandLineRunner schedulingRunner(
        @Qualifier("applicationTaskExecutor") TaskExecutor executor,
        QuotationService quotationService
    ) {
        return args -> executor.execute(quotationService);
    }

}

