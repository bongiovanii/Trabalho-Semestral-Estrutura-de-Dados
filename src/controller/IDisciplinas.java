package controller;

import model.Disciplina;

public interface IDisciplinas {
	public void cadastraDisciplina(long codigo,String nome, String diaSemana, String horario, String qtdHorasDiarias, long codigoCursoVinculado);
	public void removerDisciplina(Disciplina disciplina);
	public void consultarDisciplina(long disciplina);

}
