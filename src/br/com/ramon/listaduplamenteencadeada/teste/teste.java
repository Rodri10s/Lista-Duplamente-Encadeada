package br.com.ramon.listaduplamenteencadeada.teste;

import br.com.ramon.listaduplamenteencadeada.ListaDuplamenteEncadeada;

public class teste {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        lista.adiciona("Ramon");
        lista.adiciona("Rodrigues");
        lista.adiciona("Silva");
        lista.imprimir();

        lista.adicionarPorPosicao(2, "1");
        lista.adicionarPorPosicao(3, "2");
        lista.imprimir();

        lista.removerInicio();
        lista.imprimir();

        lista.removerNoFinal();
        lista.imprimir();

        lista.removerPorPosicao(3);
        lista.imprimir();

    }
}
