package com.blog.calculadora.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {

        try{

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculadora", new Calculadora());


        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Servidor aguardando requisições.");


    }
}