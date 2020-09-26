package com.arvorebinaria;

import java.util.Scanner;

class ArvoreBinaria {

    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Arvore arv = new Arvore();
        int opcao;
        long x;
        System.out.print("\n Programa Arvore binaria de long");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----1: Inserir");
            System.out.print("\n ----2: Remover");
            System.out.print("\n ----3: Profundidade");
            System.out.print("\n ----4: Nivel");
            System.out.print("\n ----5: Grau");
            System.out.print("\n ----6: Consultar");
            System.out.print("\n ----7: Exibir");
            System.out.print("\n ----8: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = le.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    arv.inserir(x);
                    break;
                }
                case 2: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    if (!arv.remover(x)) {
                        System.out.print("\n Valor não encontrado!");
                    }
                    ;
                    break;
                }
                case 3: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    System.out.println("Profundidade de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 4: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    System.out.println("Nível de " + x + ": " + arv.profundidade(x));
                    break;
                }
                case 5: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    System.out.println("Grau de " + x + ": " + arv.grau(x));
                    break;
                }
                case 6: {
                    System.out.print("\n Informe o valor: ");
                    x = le.nextLong();
                    if (arv.buscar(x) != null) {
                        System.out.print("\n Valor Encontrado");
                    } else {
                        System.out.print("\n Valor nao encontrado!");
                    }
                    break;
                }
                case 7: {
                    arv.caminhar();
                    break;
                }
            }
        } while (opcao != 8);

    }
}
