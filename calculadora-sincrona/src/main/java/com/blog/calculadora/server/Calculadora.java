package com.blog.calculadora.server;
import com.blog.calculadora.CalculadoraOperacoes;

import java.io.Serial;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraOperacoes{

    @Serial
    private static final long serialVersionUID = 1L;

    public Calculadora() throws RemoteException {
        super();
    }

    @Override
    public double soma(double x, double y) throws RemoteException {
        System.out.println("Soma: "+x+"+"+y+" = "+(x+y));
        return x + y;
    }



    @Override
    public double subtracao(double x, double y) throws RemoteException {
        System.out.println("Subtração: "+x+"-"+y+" = "+(x-y));
        return x - y;
    }

    @Override
    public double multiplicacao(double x, double y) throws RemoteException {
        System.out.println("Multiplicação: "+x+"*"+y+" = "+(x*y));
        return x * y;
    }

    @Override
    public double divisao(double x, double y) throws RemoteException {
        System.out.println("Divisão: "+x+"/"+y+" = "+(x/y));
        return x/y;
    }

    @Override
    public double log(double x) throws RemoteException {
        System.out.println("Logaritmo: "+x+" = "+Math.log10(x));
        return Math.log10(x);
    }

    @Override
    public double ln(double x) throws RemoteException {
        System.out.println("Logaritmo neperiano: "+x+" = "+Math.log(x));
        return Math.log(x);
    }

    @Override
    public double exp(double x, double y) throws RemoteException {
        System.out.println("Exponenciação: "+x+" elevado a "+y+" = "+(x*y));
        return Math.pow(x,y);
    }

    @Override
    public double seno(double x) throws RemoteException {
        System.out.println("Seno de : "+x+" = "+Math.sin(x));
        return Math.sin(x);
    }

    @Override
    public double cosseno(double x) throws RemoteException {
        System.out.println("Cosseno de : "+x+" = "+Math.cos(x));
        return Math.cos(x);
    }

    @Override
    public double raiz(double x) throws RemoteException {
        System.out.println("Raiz de: "+x+" = "+Math.sqrt(x));
        return Math.sqrt(x);
    }
}
