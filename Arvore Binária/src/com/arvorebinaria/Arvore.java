package com.arvorebinaria;

class Arvore {

    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public void inserir(long v) {
        No novo = new No();
        novo.item = v;
        novo.direita = null;
        novo.esquerda = null;
        novo.pai = null;

        if (raiz == null) {
            raiz = novo;
        } else {
            No atual = raiz;
            No anterior;
            while (true) {
                anterior = atual;
                if (v <= atual.item) {
                    atual = atual.esquerda;
                    if (atual == null) {
                        novo.pai = anterior;
                        anterior.esquerda = novo;
                        return;
                    }
                } else {
                    atual = atual.direita;
                    if (atual == null) {
                        novo.pai = anterior;
                        anterior.direita = novo;
                        return;
                    }
                }
            }
        }

    }

    public No buscar(long chave) {
        if (raiz == null) {
            return null;
        }
        No atual = raiz;
        while (atual.item != chave) {
            if (chave < atual.item) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
            if (atual == null) {
                return null;
            }
        }
        return atual;
    }

    public boolean remover(long v) {
        if (raiz == null) {
            return false;
        }

        No atual = raiz;
        No pai = raiz;
        boolean filho_esq = true;

        while (atual.item != v) {
            pai = atual;
            if (v < atual.item) {
                atual = atual.esquerda;
                filho_esq = true;
            } else {
                atual = atual.direita;
                filho_esq = false;
            }
            if (atual == null) {
                return false;
            }
        }

        if (atual.esquerda == null && atual.direita == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (filho_esq) {
                pai.esquerda = null;
            } else {
                pai.direita = null;
            }
        } else if (atual.direita == null) {
            if (atual == raiz) {
                raiz = atual.esquerda;
            } else if (filho_esq) {
                pai.esquerda = atual.esquerda;
            } else {
                pai.direita = atual.esquerda;
            }
        } else if (atual.esquerda == null) {
            if (atual == raiz) {
                raiz = atual.direita;
            } else if (filho_esq) {
                pai.esquerda = atual.direita;
            } else {
                pai.direita = atual.direita;
            }
        } else {
            No sucessor = no_sucessor(atual);
            if (atual == raiz) {
                raiz = sucessor;
            } else if (filho_esq) {
                pai.esquerda = sucessor;
            } else {
                pai.direita = sucessor;
            }
            sucessor.esquerda = atual.esquerda;

        }

        return true;
    }

    public No no_sucessor(No apaga) {
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.direita;

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esquerda;
        }

        if (sucessor != apaga.direita) {
            paidosucessor.esquerda = sucessor.direita;

            sucessor.direita = apaga.direita;
        }
        return sucessor;
    }

    public void caminhar() {
        System.out.print("\n Ordem: ");
        inOrder(raiz);
        System.out.print("\n P�s-ordem: ");
        posOrder(raiz);
        System.out.print("\n Pr�-ordem: ");
        preOrder(raiz);
        System.out.print("\n Altura da �rvore: " + altura(raiz));
        System.out.print("\n Quantidade de folhas: " + folhas(raiz));
        System.out.print("\n Quantidade de n�s: " + contarNos(raiz));
        if (raiz != null) {
            System.out.print("\n Valor minimo: " + min().item);
            System.out.println("\n Valor m�ximo: " + max().item);
        }
    }

    public void inOrder(No atual) {
        if (atual != null) {
            inOrder(atual.esquerda);
            System.out.print(atual.item + " ");
            inOrder(atual.direita);
        }
    }

    public void preOrder(No atual) {
        if (atual != null) {
            System.out.print(atual.item + " ");
            preOrder(atual.esquerda);
            preOrder(atual.direita);
        }
    }

    public void posOrder(No atual) {
        if (atual != null) {
            posOrder(atual.esquerda);
            posOrder(atual.direita);
            System.out.print(atual.item + " ");
        }
    }

    public int altura(No atual) {
        if (atual == null || (atual.esquerda == null && atual.direita == null)) {
            return 0;
        } else {
            if (altura(atual.esquerda) > altura(atual.direita)) {
                return (1 + altura(atual.esquerda));
            } else {
                return (1 + altura(atual.direita));
            }
        }
    }

    public int folhas(No atual) {
        if (atual == null) {
            return 0;
        }
        if (atual.esquerda == null && atual.direita == null) {
            return 1;
        }
        return folhas(atual.esquerda) + folhas(atual.direita);
    }

    public int contarNos(No atual) {
        if (atual == null) {
            return 0;
        } else {
            return (1 + contarNos(atual.esquerda) + contarNos(atual.direita));
        }
    }

    public No min() {
        No atual = raiz;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esquerda;
        }
        return anterior;
    }

    public No max() {
        No atual = raiz;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.direita;
        }
        return anterior;
    }

    public int profundidade (long v){
        No chave = buscar(v);
        No aux = chave;
        int cont = 0;
        if(chave.pai == null){
            return 0;
        }
        if(chave != null){
            while(aux.pai != null){
                aux = aux.pai;
                cont++;
            }
        }else{
            System.out.println("Valor n�o encontrado");
            return 0;
        }
        return cont;
    }
    
    public int grau(long v){
        No chave = buscar(v);
        if(chave.esquerda == null && chave.direita == null){
            return 0;
        }else if(chave.esquerda != null && chave.direita != null){
            return 2;
        }else{
            return 1;
        }
    }
    
}
