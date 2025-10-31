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
        return x + y;
    }

    @Override
    public double subtrarcao(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public double multiplicacao(double x, double y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divisao(double x, double y) throws RemoteException {
        return x/y;
    }

    @Override
    public double log(double x) throws RemoteException {
        return Math.log10(x);
    }

    @Override
    public double ln(double x) throws RemoteException {
        return Math.log(x);
    }

    @Override
    public double exp(double x, double y) throws RemoteException {
        return Math.pow(x,y);
    }

    @Override
    public double seno(double x) throws RemoteException {
        return Math.sin(x);
    }

    @Override
    public double cosseno(double x) throws RemoteException {
        return Math.cos(x);
    }

    @Override
    public double raiz(double x) throws RemoteException {
        return 0;
    }
}
