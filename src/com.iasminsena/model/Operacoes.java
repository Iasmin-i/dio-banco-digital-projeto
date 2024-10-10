package com.iasminsena.model;

import java.util.Scanner;

public class Operacoes {
    Scanner scanner = new Scanner(System.in);
    Cliente clienteDestino = new Cliente();
    Conta conta = new Conta(clienteDestino);

    public void realizarOperacao(Cliente cliente) {
        System.out.println("Olá " + cliente.getNome() + ". Em qual conta você deseja entrar? P para poupança, C para corrente.");
        char contaSelecionada = scanner.next().charAt(0);

        Conta contaDestinoNova;
        char opcao;
        double valor;
        boolean continuar = false;

        if (contaSelecionada == 'P') {
            Conta poupanca = new ContaPoupanca(cliente);
            contaDestinoNova = new ContaCorrente(clienteDestino);
        } else if (contaSelecionada == 'C') {
            Conta cc = new ContaCorrente(cliente);
            contaDestinoNova = new ContaPoupanca(clienteDestino);
        } else {
            System.out.println("Resposta inválida");
            return; // Adicionando um retorno para evitar executar o restante do código em caso de resposta inválida.
        }

        do {
            System.out.println();
            System.out.println("Qual operação você deseja realizar?");
            System.out.println("Realizar saque. (S)");
            System.out.println("Realizar depósito. (D)");
            System.out.println("Realizar transferência. (T)");
            System.out.println("Exibir minhas informações. (I)");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'S':
                    conta.imprimirPergunta("sacar?");
                    valor = scanner.nextDouble();
                    conta.sacar(valor);
                    break;
                case 'D':
                    conta.imprimirPergunta("depositar?");
                    valor = scanner.nextDouble();
                    conta.depositar(valor);
                    break;
                case 'T':
                    conta.imprimirPergunta("transferir?");
                    valor = scanner.nextDouble();
                    conta.transferir(valor, contaDestinoNova);
                    break;
                case 'I':
                    conta.imprimirInfosComuns();
                    break;
                default:
                    System.out.println("Operação inválida!");
                    break;
            }
            System.out.println();
            System.out.println("Deseja realizar mais alguma operação? Sim/Não");
            scanner.nextLine();
            String continuarOpcao = scanner.nextLine();

            if (continuarOpcao.equalsIgnoreCase("Sim")) {
                continuar = true;
            } else if (continuarOpcao.equalsIgnoreCase("Não")) {
                continuar = false;
            } else {
                continuar = false; // Caso a resposta seja inválida, o loop será interrompido.
            }

        } while (continuar);
    }
}