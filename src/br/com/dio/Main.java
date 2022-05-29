package br.com.dio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String Nome;
            int Escolha = 0;

            System.out.println("Digite o seu nome");
            Nome = scan.next();

            Cliente cliente = new Cliente();
            cliente.setNome(Nome);
            Conta cc = new ContaCorrente(cliente);
            Conta poupanca = new ContaPoupanca(cliente);
            do{
                System.out.println("Qual a sua escolha | 1 - depositar,  2- transferir para poupança, 3- sacar, 4- finalizar");
                Escolha = scan.nextInt();
                System.out.println(Escolha);

                if (Escolha == 1) {
                    int Valor = 0;
                    System.out.println("Digite o valor que irá depositar");
                    Valor = scan.nextInt();
                    cc.depositar(Valor);
                }
                if (Escolha == 2) {
                    int Valor = 0;
                    System.out.println("Digite o valor que irá transferir");
                    Valor = scan.nextInt();
                    cc.transferir(Valor, poupanca);
                }
                if (Escolha == 3) {
                    int Valor = 0;
                    System.out.println("Digite o valor que irá sacar");
                    Valor = scan.nextInt(Valor);
                    if (cc.saldo < Valor) {
                        cc.sacar(Valor);
                    } else {
                        System.out.println("Não há dinheiro o suficiente na poupança para sacar tal valor");
                    }
                }
                if (Escolha >= 1 && Escolha <= 3) {
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                }
            } while(Escolha != 4);
    }

}
