package controller;

import model.Professor;

public interface IProfessor {
	public void cadastrarNovoProfessor(long cpfProfessor, String nome, String area, int pontos);
	public void removerProfessor(Professor professor);
	public void consultarProfessor(long cpfProfessor);
}
