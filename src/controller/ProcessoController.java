package controller;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import br.edu.fateczl.bongiovani.Lista;
import model.Disciplina;
import model.Processo;
import model.Professor;
import util.MinhaTabelaHash;

public class ProcessoController {

    private Lista<Disciplina> disciplinasProcessoAberto;
    private MinhaTabelaHash<Disciplina> tabelaHashDisciplinas;
    private MinhaTabelaHash<Processo> tabHashProcessos;
    private Lista<Professor> professoresInscritos;

    private final String caminhoDisciplinas = "C:\\TEMP\\disciplinas.csv";
    private final String caminhoProfessores = "C:\\TEMP\\professor.csv";
    private final String caminhoInscricoes = "C:\\TEMP\\inscricoes.csv";
    private final String caminhoProcessos = "C:\\TEMP\\processos.csv";

    public ProcessoController() {
        disciplinasProcessoAberto = new Lista<>();
        tabelaHashDisciplinas = new MinhaTabelaHash<>(53);
        tabHashProcessos = new MinhaTabelaHash<>(53);
        professoresInscritos = new Lista<>();
        
        carregarDisciplinasProcessoAberto();
        carregarProcessosCSV();
    }

    // Métodos de carregamento de dados
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

    private void carregarProcessosCSV() {
        File arquivo = new File(caminhoProcessos);
        if (!arquivo.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    int codigoDisciplina = Integer.parseInt(dados[0]);
                    long codigoProcesso = Long.parseLong(dados[1]);
                    boolean aberto = Boolean.parseBoolean(dados[2]);

                    Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
                    Lista<Professor> professores = consultarInscritosPorDisciplina(codigoDisciplina);

                    Processo processo = new Processo(codigoDisciplina, codigoProcesso, aberto, 
                                                   disciplinasProcessoAberto, professores);
                    tabHashProcessos.inserir(processo);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar processos: " + e.getMessage());
        }
    }

    // Métodos principais para a interface
    public void abrirProcesso(long codigoDisciplina, long codigoProcesso) {
        try {
            // Verifica se a disciplina existe
            Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
            if (disciplina == null) {
                JOptionPane.showMessageDialog(null, "Disciplina não encontrada!");
                return;
            }

            // Verifica se o processo já existe
            if (buscarProcessoPorCodigo(codigoProcesso) != null) {
                JOptionPane.showMessageDialog(null, "Já existe um processo com este código!");
                return;
            }

            // Cria o processo
            Processo processo = new Processo(codigoDisciplina, codigoProcesso, true, 
                                          disciplinasProcessoAberto, professoresInscritos);
            
            // Adiciona na tabela hash
            tabHashProcessos.inserir(processo);
            
            // Grava no arquivo CSV
            gravarProcessoCSV(processo);
            
            // Inscreve professores automaticamente
            inscreverProfessoresEmProcessos();
            
            JOptionPane.showMessageDialog(null, "Processo aberto com sucesso! Código: " + codigoProcesso);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir processo: " + e.getMessage());
        }
    }

    public void fecharProcesso(long codigoProcesso) {
        try {
            Processo processo = buscarProcessoPorCodigo(codigoProcesso);
            if (processo == null) {
                JOptionPane.showMessageDialog(null, "Processo não encontrado!");
                return;
            }

            processo.setAberto(false);
            atualizarProcessoCSV(processo);
            JOptionPane.showMessageDialog(null, "Processo fechado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar processo: " + e.getMessage());
        }
    }

    public String consultarInscritosOrdenados(long codigoProcesso) {
        Processo processo = buscarProcessoPorCodigo(codigoProcesso);
        if (processo == null) {
            return "Processo não encontrado!";
        }

        Lista<Professor> inscritos = processo.getProfessoresInscritos();
        try {
            ordenarPorPontuacao(inscritos);
        } catch (Exception e) {
            return "Erro ao ordenar inscritos: " + e.getMessage();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Inscritos no Processo ").append(codigoProcesso).append(":\n");
        sb.append("Disciplina: ").append(buscarDisciplinaPorCodigo(processo.getCodigoDisciplina()).getNomeDisciplina()).append("\n\n");
        
        for (int i = 0; i < inscritos.size(); i++) {
            Professor p = null;
			try {
				p = inscritos.get(i);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            sb.append(i+1).append(". ").append(p.getNome())
              .append(" - CPF: ").append(p.getCpf())
              .append(" - Área: ").append(p.getArea())
              .append(" - Pontos: ").append(p.getPontos()).append("\n");
        }
        
        return sb.toString();
    }

    public String listarDisciplinasComProcessosAbertos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplinas com Processos Abertos:\n\n");
        
        try (Scanner scanner = new Scanner(new File(caminhoProcessos))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                
                if (dados.length == 3 && Boolean.parseBoolean(dados[2])) {
                    long codigoDisciplina = Long.parseLong(dados[0]);
                    long codigoProcesso = Long.parseLong(dados[1]);
                    
                    Disciplina d = buscarDisciplinaPorCodigo(codigoDisciplina);
                    if (d != null) {
                        sb.append("Código Processo: ").append(codigoProcesso)
                          .append(" - Disciplina: ").append(d.getNomeDisciplina())
                          .append(" (").append(d.getCodigoDisciplina()).append(")\n");
                    }
                }
            }
        } catch (Exception e) {
            return "Erro ao listar disciplinas: " + e.getMessage();
        }
        
        return sb.toString();
    }

    // Métodos auxiliares
    private Disciplina buscarDisciplinaPorCodigo(long codigoDisciplina) {
        File arquivo = new File(caminhoDisciplinas);
        if (!arquivo.exists()) return null;

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");

                if (dados.length == 6) {
                    long codigoLido = Long.parseLong(dados[0]);
                    if (codigoLido == codigoDisciplina) {
                        return new Disciplina(codigoLido, dados[1], dados[2], dados[3], dados[4], 
                                             Long.parseLong(dados[5]));
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Processo buscarProcessoPorCodigo(long codigoProcesso) {
        File arquivo = new File(caminhoProcessos);
        if (!arquivo.exists()) {
            return null;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");

                if (dados.length == 3) {
                    long codigoLido = Long.parseLong(dados[1]);
                    if (codigoLido == codigoProcesso) {
                        int codigoDisciplina = Integer.parseInt(dados[0]);
                        boolean aberto = Boolean.parseBoolean(dados[2]);

                        Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
                        Lista<Professor> professores = consultarInscritosPorDisciplina(codigoDisciplina);

                        return new Processo(codigoDisciplina, codigoProcesso, aberto, 
                                          disciplinasProcessoAberto, professores);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar processo: " + e.getMessage());
        }
        return null;
    }

    private void gravarProcessoCSV(Processo processo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoProcessos, true))) {
            String linha = processo.getCodigoDisciplina() + ";" 
                         + processo.getCodigoProcesso() + ";"
                         + processo.isAberto();
            writer.write(linha);
            writer.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar processo: " + e.getMessage());
        }
    }

    private void atualizarProcessoCSV(Processo processo) {
        Lista<String> linhas = new Lista<>();
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoProcessos))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 2 && Long.parseLong(dados[1]) == processo.getCodigoProcesso()) {
                    linha = processo.getCodigoDisciplina() + ";" 
                          + processo.getCodigoProcesso() + ";"
                          + processo.isAberto();
                    encontrado = true;
                }
                linhas.addLast(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo de processos: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Processo não encontrado no arquivo!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoProcessos))) {
            for (int i = 0; i < linhas.size(); i++) {
                writer.write(linhas.get(i));
                writer.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar arquivo de processos: " + e.getMessage());
        }
    }

    private Lista<Professor> consultarInscritosPorDisciplina(long codigoDisciplina) {
        Lista<Professor> inscritos = new Lista<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoInscricoes))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 7 && Long.parseLong(dados[4]) == codigoDisciplina) {
                    inscritos.addLast(new Professor(
                        Long.parseLong(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3])));
                }
            }
            ordenarPorPontuacao(inscritos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar inscritos: " + e.getMessage());
        }
        return inscritos;
    }

    private void ordenarPorPontuacao(Lista<Professor> lista) throws Exception {
        int tamanho = lista.size();
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                Professor a = lista.get(j);
                Professor b = lista.get(j + 1);
                if (a.getPontos() < b.getPontos()) {
                    lista.remove(j + 1);
                    lista.remove(j);
                    lista.add(b, j);
                    lista.add(a, j + 1);
                }
            }
        }
    }

    private void inscreverProfessoresEmProcessos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoProfessores))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    Professor p = new Professor(
                        Long.parseLong(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]));

                    for (int i = 0; i < disciplinasProcessoAberto.size(); i++) {
                        Disciplina d = disciplinasProcessoAberto.get(i);
                        if (d.getNomeDisciplina().toLowerCase().contains(p.getArea().toLowerCase())) {
                            registrarInscricao(p, d);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inscrever professores: " + e.getMessage());
        }
    }

    private void registrarInscricao(Professor p, Disciplina d) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoInscricoes, true))) {
            String linha = p.getCpf() + ";" + p.getNome() + ";" + p.getArea() + ";" + p.getPontos() + ";"
                        + d.getCodigoDisciplina() + ";" + d.getNomeDisciplina() + ";" + d.getCodigoCurso();
            writer.write(linha);
            writer.newLine();
            professoresInscritos.addLast(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar inscrição: " + e.getMessage());
        }
    }
}