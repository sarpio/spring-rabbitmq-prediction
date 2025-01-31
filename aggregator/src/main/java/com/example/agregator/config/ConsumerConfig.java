package com.example.agregator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    @Value("${rabbitmq.weather-queue}")
    private String weatherQueue;

    @Value("${rabbitmq.forex-queue}")
    private String forexQueue;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.weather-routing-key}")
    private String weatherRoutingKey;

    @Value("${rabbitmq.forex-routing-key}")
    private String forexRoutingKey;


    @Bean
    public Queue weatherQueue() {
        return new Queue(weatherQueue);
    }

    @Bean
    public Queue forexQueue() {
        return new Queue(forexQueue);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding bindingWeatherQueue() {
        return BindingBuilder
                .bind(weatherQueue())
                .to(exchange())
                .with(weatherRoutingKey);
    }

    @Bean
    public Binding bindingForexQueue() {
        return BindingBuilder
                .bind(forexQueue())
                .to(exchange())
                .with(forexRoutingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
        return rabbitTemplate;
    }
}
