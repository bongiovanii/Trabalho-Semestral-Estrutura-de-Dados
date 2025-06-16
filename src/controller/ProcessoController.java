package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JOptionPane;

import br.edu.fateczl.bongiovani.Lista;
import model.Disciplina;
import model.Professor;
import util.MinhaTabelaHash;

public class ProcessoController {

	private Lista<Disciplina> disciplinasProcessoAberto;
	private MinhaTabelaHash<Disciplina> tabelaHashDisciplinas;
	private Lista<Professor> professoresInscritos;

	private final String caminhoDisciplinas = "C:/TEMP/disciplinas.csv";
	private final String caminhoProfessores = "C:/TEMP/professor.csv";
	private final String caminhoInscricoes = "C:/TEMP/inscricoes.csv";

	public ProcessoController() {
		disciplinasProcessoAberto = new Lista<>();
		tabelaHashDisciplinas = new MinhaTabelaHash<>(53);
		professoresInscritos = new Lista<>();
		carregarDisciplinasProcessoAberto();
	}

	// Carrega disciplinas com processos abertos e preenche a tabela hash
	private void carregarDisciplinasProcessoAberto() {
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoDisciplinas))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] dados = linha.split(";");
				if (dados.length == 6) {
					long codigoDisciplina = Long.parseLong(dados[0]);
					String nome = dados[1];
					String dia = dados[2];
					String horario = dados[3];
					String horasDia = dados[4];
					long codigoCurso = Long.parseLong(dados[5]);

					Disciplina d = new Disciplina(codigoDisciplina, nome, dia, horario, horasDia, codigoCurso);
					disciplinasProcessoAberto.addLast(d);
					tabelaHashDisciplinas.inserir(d);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar disciplinas: " + e.getMessage());
		}
	}

	// Inscreve professores automaticamente se a área for compatível com a
	// disciplina
	public void inscreverProfessoresEmProcessos() {
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoProfessores))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] dados = linha.split(";");
				if (dados.length == 4) {
					long cpf = Long.parseLong(dados[0]);
					String nome = dados[1];
					String area = dados[2];
					int pontos = Integer.parseInt(dados[3]);

					Professor p = new Professor(cpf, nome, area, pontos);
					for (int i = 0; i < disciplinasProcessoAberto.size(); i++) {
						Disciplina d = disciplinasProcessoAberto.get(i);
						if (d.getNomeDisciplina().toLowerCase().contains(area.toLowerCase())) {
							registrarInscricao(p, d);
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Inscrições realizadas com sucesso.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inscrever professores: " + e.getMessage());
		}
	}

	// Registra inscrição em arquivo e em lista interna
	private void registrarInscricao(Professor p, Disciplina d) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoInscricoes, true))) {
			String linha = p.getCpf() + ";" + p.getNome() + ";" + p.getArea() + ";" + p.getPontos() + ";"
					+ d.getCodigoDisciplina() + ";" + d.getNomeDisciplina() + ";" + d.getCodigoCurso();
			writer.write(linha);
			writer.newLine();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao registrar inscrição: " + e.getMessage());
		}
	}

	// Lista todas disciplinas com processos abertos
	public Lista<Disciplina> consultarDisciplinasProcessoAberto() {
		return disciplinasProcessoAberto;
	}

	// Consulta os professores inscritos em determinada disciplina
	public Lista<Professor> consultarInscritosPorDisciplina(long codigoDisciplina) {
		Lista<Professor> inscritos = new Lista<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoInscricoes))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] dados = linha.split(";");
				if (dados.length >= 7 && Long.parseLong(dados[4]) == codigoDisciplina) {
					long cpf = Long.parseLong(dados[0]);
					String nome = dados[1];
					String area = dados[2];
					int pontos = Integer.parseInt(dados[3]);
					inscritos.addLast(new Professor(cpf, nome, area, pontos));
				}
			}
			ordenarPorPontuacao(inscritos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar inscritos: " + e.getMessage());
		}
		return inscritos;
	}

	// Ordena uma lista de professores por pontuação (bubble sort)
	private void ordenarPorPontuacao(Lista<Professor> lista) throws Exception {
		int tamanho = lista.size();
		for (int i = 0; i < tamanho - 1; i++) {
			for (int j = 0; j < tamanho - i - 1; j++) {
				Professor a = lista.get(j);
				Professor b = lista.get(j + 1);
				if (a.getPontos() < b.getPontos()) {
					// Remover e inserir os elementos trocados
					lista.remove(j + 1);
					lista.remove(j);
					lista.add(b, j);
					lista.add(a, j + 1);
				}
			}
		}
	}
}
