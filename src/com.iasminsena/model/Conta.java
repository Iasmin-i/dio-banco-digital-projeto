package com.iasminsena.model;
import java.util.Scanner;

public class Conta implements IConta {
    Scanner scanner = new Scanner(System.in);
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    public void imprimirPergunta(String nomeOperacao) {
    	    System.out.println();
        System.out.println("Qual valor você deseja " + nomeOperacao);
    }

    public void sacar(double valor) {
    	if(saldo > valor && saldo != 0.0)
        saldo -= valor;
    		else 
    			System.out.println("Saldo insuficiente");
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, IConta contaDestino) {
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
    	    System.out.println();
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}