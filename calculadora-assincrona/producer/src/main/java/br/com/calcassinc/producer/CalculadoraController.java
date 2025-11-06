package br.com.calcassinc.producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calc")
public class CalculadoraController {

    private final RabbitTemplate rabbitTemplate;

    public CalculadoraController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String sendTask(@RequestParam String operation, @RequestParam List<Double> numbers) {
        String message = operation + ":" + numbers.toString();
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
        return "Tarefa enviada: " + message;
    }

}