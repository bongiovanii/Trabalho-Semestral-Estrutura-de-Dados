package controller;

import model.Disciplina;

public interface IDisciplinas {
<<<<<<< Updated upstream
	public void cadastraDisciplina(int codigo, String diaSemana, String horario, int qtdDiasSemana);
	public void removerDisciplina(Disciplina disciplina);
	public void consultarDisciplina(Disciplina disciplina);
=======
	public void cadastraDisciplina(long codigo,String nome, String diaSemana, String horario, String qtdHorasDiarias, long codigoCursoVinculado);
	public boolean removerDisciplina(long codigoDisciplina);
	public void consultarDisciplina(long codigoDisciplina);
>>>>>>> Stashed changes

}
