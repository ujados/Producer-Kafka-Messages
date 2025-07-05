package com.ujados.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String TOPIC = "mi-topico";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send(TOPIC, mensaje);
        System.out.println("Mensaje enviado: " + mensaje);
    }
}