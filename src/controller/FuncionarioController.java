package controller;

import model.Professor;

public class FuncionarioController implements ICadastrarProfessor, IInscricao {
	Professor professor = new Professor();

	@Override
	public void cadastrarNovoProfessor(int cpfProfessor, String nome, String area, int pontos) {
		professor.setCpf(cpfProfessor);
		professor.setNome(nome);
		professor.setArea(area);
		professor.setPontos(pontos);
	}

	@Override
	public void novaInscricao(int cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void salvarInscricao(int cpfProfessor, int codigoDisciplina, int codigoProcesso) {
		// TODO Auto-generated method stub

	}

}
