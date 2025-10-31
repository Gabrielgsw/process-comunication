package com.blog.calculadora;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraOperacoes extends Remote {

    public double soma(double x, double y) throws RemoteException;
    public double subtrarcao(double x, double y) throws RemoteException;
    public double multiplicacao(double x, double y) throws RemoteException;
    public double divisao(double x, double y) throws RemoteException;
    public double log(double x) throws RemoteException;
    public double ln(double x) throws RemoteException;
    public double exp(double x, double y) throws RemoteException;
    public double seno(double x) throws RemoteException;
    public double cosseno(double x) throws RemoteException;
    public double raiz(double x) throws RemoteException;
}