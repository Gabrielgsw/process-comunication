package br.com.calcassinc.producer;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "calc_queue";

    @Bean
    public Queue calcQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}

