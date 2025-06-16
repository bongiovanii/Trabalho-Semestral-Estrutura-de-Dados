package controller;

import model.Professor;

public interface IProfessor {
	public void cadastrarNovoProfessor(long cpfProfessor, String nome, String area, int pontos);

	public boolean removerProfessor(long cpfProfessor) throws Exception;

	public void consultarProfessor(long cpfProfessor);
}
