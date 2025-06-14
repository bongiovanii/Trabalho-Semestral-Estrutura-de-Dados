package controller;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.edu.fateczl.bongiovani.Lista;
import util.MinhaTabelaHash;

import model.Curso;
import model.Disciplina;
import model.Professor;

public class FuncionarioController implements IProfessor, IInscricao, IDisciplinas, ICursos {

	private Professor professor = new Professor();
	private Disciplina disciplina = new Disciplina();
	private Lista<Object> inscricoes = new Lista<>();
	private MinhaTabelaHash<Professor> tabHashProfessor;

	private final String caminhoArquivo = "C:\\TEMP\\professor.csv";

	public FuncionarioController() {
		tabHashProfessor = new MinhaTabelaHash<>(53);
		carregarProfessoresCSV();
	}

	@Override
	public void cadastrarNovoProfessor(long cpfProfessor, String nome, String area, int pontos) {
		Professor novoProfessor = new Professor(cpfProfessor, nome, area, pontos);

		// Verifica se já existe na tabela hash
		if (tabHashProfessor.buscar(novoProfessor)) {
			JOptionPane.showMessageDialog(null, "Professor já cadastrado (Hash).");
			return;
		}

		// Verifica se já existe no arquivo CSV (verificação de segurança)
		boolean jaExisteNoArquivo = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				if (partes.length >= 1) {
					long cpfExistente = Long.parseLong(partes[0].trim());
					if (cpfExistente == cpfProfessor) {
						jaExisteNoArquivo = true;
						break;
					}
				}
			}
		} catch (IOException e) {
		}

		if (jaExisteNoArquivo) {
			JOptionPane.showMessageDialog(null, "Professor já cadastrado (Arquivo).");
			return;
		}

		// Insere na hash e no arquivo
		tabHashProfessor.inserir(novoProfessor);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
			String linha = cpfProfessor + ";" + nome + ";" + area + ";" + pontos;
			writer.write(linha);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar no arquivo CSV!");
		}

		JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
	}

	public void carregarProfessoresCSV() {
		File arquivo = new File(caminhoArquivo);

		if (!arquivo.exists()) {
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				if (partes.length == 4) {
					long cpf = Long.parseLong(partes[0].trim());
					String nome = partes[1].trim();
					String area = partes[2].trim();
					int pontos = Integer.parseInt(partes[3].trim());

					Professor professor = new Professor(cpf, nome, area, pontos);
					tabHashProfessor.inserir(professor);
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar professores do CSV: " + e.getMessage());
		}
	}

	@Override
	public boolean removerProfessor(long cpf) {
		Lista<String> linhasMantidas = new Lista<>();
		boolean encontrado = false;
		Professor professorParaRemover = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");

				if (partes.length >= 4) {
					long cpfAtual = Long.parseLong(partes[0].trim());

					if (cpfAtual != cpf) {
						// Adiciona apenas se for diferente do CPF a ser removido
						linhasMantidas.addLast(linha);
					} else {
						// CPF igual: este professor será removido
						String nome = partes[1].trim();
						String area = partes[2].trim();
						int pontos = Integer.parseInt(partes[3].trim());

						professorParaRemover = new Professor(cpfAtual, nome, area, pontos);
						encontrado = true;
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
			return false;
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Professor com CPF " + cpf + " não encontrado.");
			return false;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
			int total = linhasMantidas.size();
			for (int i = 0; i < total; i++) {
				writer.write(linhasMantidas.get(i));
				writer.newLine();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao escrever o arquivo: " + e.getMessage());
			return false;
		}

		// Remove da tabela hash
		if (professorParaRemover != null) {
			boolean removido = tabHashProfessor.remover(professorParaRemover);
			if (!removido) {
				JOptionPane.showMessageDialog(null, "Removido do CSV, mas não encontrado na hash.");
			}
		}

		JOptionPane.showMessageDialog(null, "Professor removido com sucesso.");
		return true;
	}

	@Override
	public void consultarProfessor(long cpf) {
		Professor professor = buscarProfessorPorCpf(cpf);

		if (professor != null) {
			JOptionPane.showMessageDialog(null, "Professor: " + professor.getNome() + "\nCPF: " + professor.getCpf()
					+ "\nÁrea: " + professor.getArea() + "\nPontos: " + professor.getPontos());
		} else {
			JOptionPane.showMessageDialog(null, "Professor com CPF " + cpf + " não encontrado.");
		}
	}

	public Professor buscarProfessorPorCpf(long cpf) {
		File arquivo = new File(caminhoArquivo);

		if (!arquivo.exists()) {
			JOptionPane.showMessageDialog(null, "Arquivo de professores não encontrado!");
			return null;
		}

		try (Scanner scanner = new Scanner(arquivo)) {
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] dados = linha.split(";");

				if (dados.length == 4) {
					long cpfLido = Long.parseLong(dados[0]);

					if (cpfLido == cpf) {
						String nome = dados[1];
						String area = dados[2];
						int pontos = Integer.parseInt(dados[3]);

						Professor prof = new Professor(cpfLido, nome, area, pontos);
						return prof;
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de professores: " + e.getMessage());
		}

		return null; // caso não encontre
	}

	public void atualizarProfessor(long cpf, String novoNome, String novaArea, int novosPontos) throws Exception {
		Lista<String> linhasAtualizadas = new Lista<>();
		boolean encontrado = false;
		Professor professorAtualizado = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");

				if (partes.length == 4) {
					long cpfLido = Long.parseLong(partes[0].trim());

					if (cpfLido == cpf) {
						// Substitui a linha antiga pelo novo conteúdo
						linha = cpf + ";" + novoNome + ";" + novaArea + ";" + novosPontos;
						encontrado = true;

						// Cria objeto atualizado para atualizar na hash
						professorAtualizado = new Professor(cpf, novoNome, novaArea, novosPontos);
					}
				}
				linhasAtualizadas.addLast(linha); // Adiciona a linha (atualizada ou não)
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
			return;
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Professor com CPF " + cpf + " não encontrado.");
			return;
		}

		// Regrava o CSV com as linhas atualizadas
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
			for (int i = 0; i < linhasAtualizadas.size(); i++) {
				writer.write(linhasAtualizadas.get(i));
				writer.newLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o arquivo: " + e.getMessage());
			return;
		}

		// Atualiza na hash
		tabHashProfessor.remover(new Professor(cpf, "", "", 0)); // remove pelo hash baseado no CPF
		tabHashProfessor.inserir(professorAtualizado); // insere o novo

		JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
	}

	@Override
	public void novaInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		// Os dados devem vir por parâmetro — não sobrescreva como estava antes
		Random rand = new Random();
		codigoProcesso = rand.nextInt(99999);

		// Aqui você pode montar a lógica de criar um objeto e salvar na lista
		// 'inscricoes'
	}

	@Override
	public void salvarInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		// TODO: implementar persistência de inscrições se necessário
	}

	@Override
	public void cadastraDisciplina(int codigo, String diaSemana, String horario, int qtdDiasSemana) {
		// TODO: implementar cadastro de disciplina
	}

	@Override
	public void removerDisciplina(Disciplina disciplina) {
		// TODO: implementar remoção de disciplina
	}

	@Override
	public void consultarDisciplina(Disciplina disciplina) {
		// TODO: implementar consulta de disciplina
	}

	@Override
	public void cadastraCurso(int codigoCurso, String nomeCurso) {
		// TODO: implementar se necessário
	}

	@Override
	public void removeCurso(Curso curso) {
		// TODO: implementar
	}

	@Override
	public void consultaCurso(Curso curso) {
		// TODO: implementar
	}
}
