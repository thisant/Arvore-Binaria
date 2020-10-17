package com.arvorebinaria;

import java.util.Scanner;

class ArvoreBinaria {

    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Arvore arv = new Arvore();
        int opcao;
        int i;
        int a = 0;
        long x;
        System.out.print("\n�rvore bin�ria");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nMenu:");
            System.out.print("\n -1: Inserir n�");
            System.out.print("\n -2: Remover n�");
            System.out.print("\n -3: Profundidade do n�");
            System.out.print("\n -4: Nivel do n�");
            System.out.print("\n -5: Grau do n�");
            System.out.print("\n -6: Consultar valor");
            System.out.print("\n -7: Exibir �rvore");
            System.out.print("\n -8: Inverter Sub-Arvore");
            System.out.print("\n -9: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\nInsira a op��o desejada:");
            opcao = le.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Informe a quantidade de n�s a serem inseridos: ");
                    a = le.nextInt();
                    for (i = 1; i <= a; i = i + 1) {
                        System.out.print("\nInforme o valor do n� para inserir: ");
                        x = le.nextLong();
                        arv.inserir(x);
                    }
                    break;
                }
                case 2: {
                    System.out.print("\nInforme o valor do n� a ser removido: ");
                    x = le.nextLong();
                    System.out.print("\nO n� " + x + " foi removido: ");
                    if (!arv.remover(x)) {
                        System.out.print("\n Valor n�o encontrado!");
                    }
                    ;
                    break;
                }
                case 3: {
                    System.out.print("\nInforme o valor do n�: ");
                    x = le.nextLong();
                    System.out.println("Profundidade de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 4: {
                    System.out.print("\nInforme o valor do n�: ");
                    x = le.nextLong();
                    System.out.println("N�vel de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 5: {
                    System.out.print("\nInforme o valor do n�: ");
                    x = le.nextLong();
                    System.out.println("Grau de " + x + ": " + arv.grau(x));
                    break;
                }
                case 6: {
                    System.out.print("\nInforme o valor do n� a ser consultado: ");
                    x = le.nextLong();
                    if (arv.buscar(x) != null) {
                        System.out.print("\nValor encontrado!");
                    } else {
                        System.out.print("\nValor n�o encontrado!");
                    }
                    break;
                }
                case 7: {
                    System.out.print("\nExibindo Arvore: ");
                    arv.caminhar();
                    break;
                }
                case 8: {
                    arv.inverterEimprimir();
                    break;
                }
            }
        } while (opcao != 9);

    }
}
