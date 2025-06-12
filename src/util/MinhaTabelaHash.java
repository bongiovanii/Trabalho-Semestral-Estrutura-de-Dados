package util;

import br.edu.fateczl.bongiovani.Lista;

public class MinhaTabelaHash<T> {

	private Lista<T>[] tabela;
	private int tamanho;

	@SuppressWarnings("unchecked")
	public MinhaTabelaHash(int tamanho) {
		this.tamanho = tamanho;
		tabela = new Lista[tamanho];

		for (int i = 0; i < tamanho; i++) {
			tabela[i] = new Lista<>();
		}
	}

	private int calcularIndiceHash(T elemento) {
		int hash = elemento.hashCode();
		return Math.abs(hash) % tamanho;
	}

	public void inserir(T elemento) {
		int indice = calcularIndiceHash(elemento);
		Lista<T> lista = tabela[indice];

		try {
			if (!existe(lista, elemento)) {
				lista.addLast(elemento);
			} else {
				System.out.println("Elemento já existe na tabela.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean buscar(T elemento) {
		int indice = calcularIndiceHash(elemento);
		Lista<T> lista = tabela[indice];

		try {
			int tamanhoLista = lista.size();
			for (int i = 0; i < tamanhoLista; i++) {
				T atual = lista.get(i);
				if (atual.equals(elemento)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void remover(T elemento) {
		int indice = calcularIndiceHash(elemento);
		Lista<T> lista = tabela[indice];

		try {
			int tamanhoLista = lista.size();
			for (int i = 0; i < tamanhoLista; i++) {
				T atual = lista.get(i);
				if (atual.equals(elemento)) {
					lista.remove(i);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean existe(Lista<T> lista, T elemento) throws Exception {
		int tamanhoLista = lista.size();
		for (int i = 0; i < tamanhoLista; i++) {
			if (lista.get(i).equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	public void imprimirTabela() {
		for (int i = 0; i < tamanho; i++) {
			System.out.print("Índice " + i + ": ");
			try {
				int tamanhoLista = tabela[i].size();
				for (int j = 0; j < tamanhoLista; j++) {
					System.out.print(tabela[i].get(j) + " -> ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("null");
		}
	}
}
