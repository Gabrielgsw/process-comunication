package br.com.calcassinc.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receive(String message) {
        System.out.println("Recebido: " + message);

        
        try {
            String[] parts = message.split(":");
            String op = parts[0];
            String numbersPart = parts[1]
                    .replace("[", "")
                    .replace("]", "")
                    .trim();

            String[] nums = numbersPart.split(",");
            double a = Double.parseDouble(nums[0].trim());
            double b = Double.parseDouble(nums[1].trim());

            double result = switch (op.toUpperCase()) {
                case "ADD" -> a + b;
                case "SUB" -> a - b;
                case "MUL" -> a * b;
                case "DIV" -> b != 0 ? a / b : Double.NaN;
                case "LOG" -> Math.log10(a);
                case "LN" -> Math.log(a);
                case "EXP" -> Math.pow(a,b);
                case "SIN" -> Math.sin(a);
                case "COS" -> Math.cos(a);
                case "SQRT" -> Math.sqrt(a);
                default -> Double.NaN;
            };

            System.out.println("Resultado (" + op + "): " + result);
        } catch (Exception e) {
            System.err.println("Erro ao processar: " + e.getMessage());
        }
    }
}
