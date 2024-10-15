package com.iasminsena.app;
import com.iasminsena.model.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Operacao operacoes = new Operacao();
        cliente.setNome("Mario");

        operacoes.realizarOperacao(cliente);
    }
}
