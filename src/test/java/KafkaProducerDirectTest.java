import com.ujados.kafka.ProducerKafkaMessagesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.file.Files;

@SpringBootTest(classes = ProducerKafkaMessagesApplication.class)
public class KafkaProducerDirectTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPICO = "topico-prueba";

    @Test
    void enviarMensajeJsonADirectoATopico() throws Exception {
        // Cargar archivo JSON desde resources
        String mensajeJson = Files.readString(new ClassPathResource("message.json").getFile().toPath());

        // Enviar mensaje directamente al tópico
        kafkaTemplate.send(TOPICO, mensajeJson).get(); // .get() para esperar que se envíe

        System.out.println("Mensaje enviado correctamente a Kafka:");
        System.out.println(mensajeJson);
    }
}