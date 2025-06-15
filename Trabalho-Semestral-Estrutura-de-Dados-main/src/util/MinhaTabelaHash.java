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
		int hashCode = elemento.hashCode();
		return Math.abs(hashCode % tamanho);
	}

	public void inserir(T elemento) {
		int indice = calcularIndiceHash(elemento);
		try {
			// Verifica se já existe o elemento antes de adicionar
			int tam = tabela[indice].size();
			for (int i = 0; i < tam; i++) {
				if (tabela[indice].get(i).equals(elemento)) {
					return; // já existe, não insere duplicado
				}
			}
			tabela[indice].addLast(elemento);
		} catch (Exception e) {
			System.err.println("Erro ao inserir: " + e.getMessage());
		}
	}

	public boolean buscar(T elemento) {
		int indice = calcularIndiceHash(elemento);
		try {
			int tam = tabela[indice].size();
			for (int i = 0; i < tam; i++) {
				if (tabela[indice].get(i).equals(elemento)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("Erro ao buscar: " + e.getMessage());
		}
		return false;
	}

	public boolean remover(T elemento) {
		int indice = calcularIndiceHash(elemento);
		try {
			int tam = tabela[indice].size();
			for (int i = 0; i < tam; i++) {
				if (tabela[indice].get(i).equals(elemento)) {
					tabela[indice].remove(i);
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("Erro ao remover: " + e.getMessage());
		}
		return false;
	}

	// (Opcional) Para depuração
	public void imprimirTabela() {
		for (int i = 0; i < tamanho; i++) {
			System.out.print("[" + i + "]: ");
			try {
				int tam = tabela[i].size();
				for (int j = 0; j < tam; j++) {
					System.out.print(tabela[i].get(j) + " -> ");
				}
			} catch (Exception e) {
				System.out.print("Erro ao imprimir");
			}
			System.out.println("null");
		}
	}
}
