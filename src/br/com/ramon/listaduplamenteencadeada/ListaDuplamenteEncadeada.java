package br.com.ramon.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    public void adiciona(T elemento) {
        No<T> celula = new No<>(elemento);

        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
            celula.setAnterior(this.ultimo);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionarPorPosicao(int posicao, String informacao) {

        No anterior = this.inicio;

        if (posicao > this.tamanho || posicao < 1) {

            throw new IllegalArgumentException("posição fora do intervalo válido");

        }

        for (int cont = 1; cont < posicao; cont++) {

            anterior = anterior.getProximo();

        }

        No nova = new No(anterior, informacao, null);

        nova.setProximo(anterior.getProximo());
        nova.getProximo().setAnterior(nova);

        anterior.setProximo(nova);
        this.tamanho++;
    }

    public void removerInicio() {

        No aux = this.inicio;
        this.inicio = aux.getProximo();
        aux.setProximo(null);

        this.tamanho--;

    }

    public void removerNoFinal() {
        No<T> anterior = this.inicio;

        if (this.tamanho == 1) {
            removerInicio();
        } else {
            for (int i = 1; i < this.tamanho - 1; i++) {
                anterior = anterior.getProximo();
            }
            No remover = anterior.getProximo();

            anterior.setProximo(null);
        }
        this.tamanho--;
    }

    public void removerPorPosicao(int posicao) {
        No<T> anterior = this.inicio;
        if (posicao > this.tamanho + 1 || posicao < 1) {

            throw new IllegalArgumentException("posição fora do intervalo válido");

        } else if (posicao == 1) {
            removerInicio();
        } else {
            for (int i = 1; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }

            No remover = anterior.getProximo();

            anterior.setProximo(remover.getProximo());
            remover.getProximo().setAnterior(anterior);

            remover.setAnterior(null);
            remover.setProximo(null);
        }

        this.tamanho--;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void imprimir() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("Lista está vazia");
        }

        No<T> aux = this.inicio;
        while (aux != null) {
            System.out.print(aux.getElemento() + "<=>");
            aux = aux.getProximo();
        }
        System.out.println();
    }

}
