package com.blog.calculadora.client;

import com.blog.calculadora.CalculadoraOperacoes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CalculadoraCliente {
    public static void main(String[] args) {
        try {
            CalculadoraOperacoes calc = (CalculadoraOperacoes) Naming.lookup("rmi://localhost:1099/Calculadora");
            Scanner sc = new Scanner(System.in);
            

            double resultado = calc.soma(8.0, 9.8);
            System.out.println("Resultado: " + resultado);

        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }



    }

}