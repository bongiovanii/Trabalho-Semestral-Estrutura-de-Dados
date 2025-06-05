package controller;

import model.Disciplina;

public interface IDisciplinas {
	public void cadastraDisciplina(int codigo, String diaSemana, String horario, int qtdDiasSemana);
	public void removerDisciplina(Disciplina disciplina);
	public void consultarDisciplina(Disciplina disciplina);

}
