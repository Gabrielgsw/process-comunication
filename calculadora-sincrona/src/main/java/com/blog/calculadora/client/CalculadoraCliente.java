package com.blog.calculadora.client;

import com.blog.calculadora.CalculadoraOperacoes;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraCliente {

    public static void main(String[] args) {
        try {
            CalculadoraOperacoes calc = (CalculadoraOperacoes) Naming.lookup("rmi://localhost:1099/Calculadora");

            try (Scanner sc = new Scanner(System.in)) {
                menuLoop(calc, sc);
            }

        } catch (NotBoundException ex) {
            System.err.println("Serviço 'Calculadora' não encontrado no registro RMI.");
            System.err.println("Detalhes: " + ex.getMessage());
        } catch (MalformedURLException ex) {
            System.err.println("URL RMI mal formatada.");
            System.err.println("Detalhes: " + ex.getMessage());
        } catch (RemoteException ex) {
            System.err.println("Erro de comunicação com o servidor RMI.");
            System.err.println("Detalhes: " + ex.getMessage());
        }
    }

    static void menuLoop(CalculadoraOperacoes calc, Scanner sc) {
        while (true) {
            System.out.println("\n--- Calculadora Distribuída RMI ---");
            System.out.println("1) Soma");
            System.out.println("2) Subtração");
            System.out.println("3) Multiplicação");
            System.out.println("4) Divisão");
            System.out.println("5) Logaritmo Natural (ln)");
            System.out.println("6) Logaritmo Base 10 (log)");
            System.out.println("7) Exponenciação (base ^ expoente)");
            System.out.println("8) Seno (ângulo em radianos)");
            System.out.println("9) Cosseno (ângulo em radianos)");
            System.out.println("10) Raiz Quadrada");
            System.out.println("11) Encerrar");
            System.out.print("\nDigite o número da operação desejada: ");

            int opcao = 0;
            try {
                opcao = sc.nextInt();
                if (opcao == 11) {
                    System.out.println("Encerrando...");
                    break;
                }
                processarOpcao(opcao, calc, sc);

            } catch (InputMismatchException e) {
                System.err.println("\nErro: Por favor, digite apenas números (1-11).");
                sc.next();
            } catch (RemoteException e) {
                System.err.println("\nErro de comunicação com o servidor durante a operação.");
                System.err.println("Detalhes: " + e.getMessage());
                break;
            } catch (ArithmeticException e) {
                System.err.println("\nErro na operação matemática.");
                System.err.println("Detalhes: " + e.getMessage());
            }
        }
    }

    static void processarOpcao(int opcao, CalculadoraOperacoes calc, Scanner sc) throws RemoteException, ArithmeticException {
        double primeiro, segundo;
        String resultadoMsg = ">> Resultado: ";

        switch (opcao) {
            case 1:
                System.out.print("Digite o primeiro número: ");
                primeiro = sc.nextDouble();
                System.out.print("Digite o segundo número: ");
                segundo = sc.nextDouble();
                System.out.println(resultadoMsg + calc.soma(primeiro, segundo));
                break;
            case 2:
                System.out.print("Digite o primeiro número: ");
                primeiro = sc.nextDouble();
                System.out.print("Digite o segundo número: ");
                segundo = sc.nextDouble();
                System.out.println(resultadoMsg + calc.subtracao(primeiro, segundo));
                break;
            case 3:
                System.out.print("Digite o primeiro número: ");
                primeiro = sc.nextDouble();
                System.out.print("Digite o segundo número: ");
                segundo = sc.nextDouble();
                System.out.println(resultadoMsg + calc.multiplicacao(primeiro, segundo));
                break;
            case 4:
                System.out.print("Digite o dividendo: ");
                primeiro = sc.nextDouble();
                System.out.print("Digite o divisor: ");
                segundo = sc.nextDouble();
                if (segundo == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                System.out.println(resultadoMsg + calc.divisao(primeiro, segundo));
                break;
            case 5:
                System.out.print("Digite o número: ");
                primeiro = sc.nextDouble();
                System.out.println(resultadoMsg + calc.ln(primeiro));
                break;
            case 6:
                System.out.print("Digite o número: ");
                primeiro = sc.nextDouble();
                System.out.println(resultadoMsg + calc.log(primeiro));
                break;
            case 7:
                System.out.print("Digite a base: ");
                primeiro = sc.nextDouble();
                System.out.print("Digite o expoente: ");
                segundo = sc.nextDouble();
                System.out.println(resultadoMsg + calc.exp(primeiro, segundo));
                break;
            case 8:
                System.out.print("Digite o ângulo (em radianos): ");
                primeiro = sc.nextDouble();
                System.out.println(resultadoMsg + calc.seno(primeiro));
                break;
            case 9:
                System.out.print("Digite o ângulo (em radianos): ");
                primeiro = sc.nextDouble();
                System.out.println(resultadoMsg + calc.cosseno(primeiro));
                break;
            case 10:
                System.out.print("Digite o número: ");
                primeiro = sc.nextDouble();
                System.out.println(resultadoMsg + calc.raiz(primeiro));
                break;
            default:
                System.out.println("\nOpção inválida. Por favor, escolha um número de 1 a 11.");
                break;
        }
    }
}