package controller;

import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

import br.edu.fateczl.bongiovani.Lista;
import model.Curso;
import model.Disciplina;
import model.Professor;

public class FuncionarioController implements IProfessor, IInscricao, IDisciplinas, ICursos {
	Professor professor = new Professor();
	Disciplina disciplina = new Disciplina();
	Lista<Object> inscricoes = new Lista<>();

	static HashMap<Long, Professor> professores = new HashMap<>();

	@Override
	public void cadastrarNovoProfessor(long cpfProfessor, String nome, String area, int pontos) {
		professor.setCpf(cpfProfessor);
		professor.setNome(nome);
		professor.setArea(area);
		professor.setPontos(pontos);

		professores.put(professor.getCpf(), professor);
	}

	@Override
	public void novaInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		Random rand = new Random();

		cpfProfessor = (int) professor.getCpf();
		codigoDisciplina = disciplina.getCodigoDisciplina();
		codigoProcesso = rand.nextInt(99999);

	}

	@Override
	public void salvarInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerProfessor(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarProfessor(long cpf) {
		
		Professor professorAux =  professores.get(cpf);
		JOptionPane.showMessageDialog(null, "Professor: " + professorAux.getNome() + "\nCpf: " + professorAux.getCpf()
		+ "\nPontos: " + professorAux.getPontos() + "\nÁrea: " + professorAux.getArea());

	}

	@Override
	public void cadastraDisciplina(int codigo, String diaSemana, String horario, int qtdDiasSemana) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastraCurso(int codigoCurso, String nomeCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCurso(Curso curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultaCurso(Curso curso) {
		// TODO Auto-generated method stub

	}

}
