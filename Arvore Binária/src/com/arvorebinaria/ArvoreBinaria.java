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
        System.out.print("\nÁrvore binária");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nMenu:");
            System.out.print("\n -1: Inserir nó");
            System.out.print("\n -2: Remover nó");
            System.out.print("\n -3: Profundidade do nó");
            System.out.print("\n -4: Nivel do nó");
            System.out.print("\n -5: Grau do nó");
            System.out.print("\n -6: Consultar valor");
            System.out.print("\n -7: Exibir árvore");
            System.out.print("\n -8: Inverter sub-árvore");
            System.out.print("\n -9: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\nInsira a opção desejada:");
            opcao = le.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Informe a quantidade de nós a serem inseridos: ");
                    a = le.nextInt();
                    for (i = 1; i <= a; i = i + 1) {
                        System.out.print("\nInforme o valor do nó para inserir: ");
                        x = le.nextLong();
                        arv.inserir(x);
                    }
                    break;
                }
                case 2: {
                    System.out.print("\nInforme o valor do nó a ser removido: ");
                    x = le.nextLong();
                    System.out.print("\nO nó " + x + " foi removido: ");
                    if (!arv.remover(x)) {
                        System.out.print("\n Valor não encontrado!");
                    }
                    ;
                    break;
                }
                case 3: {
                    System.out.print("\nInforme o valor do nó: ");
                    x = le.nextLong();
                    System.out.println("Profundidade de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 4: {
                    System.out.print("\nInforme o valor do nó: ");
                    x = le.nextLong();
                    System.out.println("Nível de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 5: {
                    System.out.print("\nInforme o valor do nó: ");
                    x = le.nextLong();
                    System.out.println("Grau de " + x + ": " + arv.grau(x));
                    break;
                }
                case 6: {
                    System.out.print("\nInforme o valor do nó a ser consultado: ");
                    x = le.nextLong();
                    if (arv.buscar(x) != null) {
                        System.out.print("\nValor encontrado!");
                    } else {
                        System.out.print("\nValor não encontrado!");
                    }
                    break;
                }
                case 7: {
                    System.out.print("\nExibindo árvore: ");
                    arv.caminhar();
                    break;
                }
                case 8: {
                	System.out.print("\nInvertendo árvore: ");
                    arv.inverterEimprimir();
                    break;
                }
            }
        } while (opcao != 9);

    }
}
