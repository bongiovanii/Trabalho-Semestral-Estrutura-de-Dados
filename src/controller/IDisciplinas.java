package controller;

import model.Disciplina;

public interface IDisciplinas {
	public void cadastraDisciplina(long codigo,String nome, String diaSemana, String horario, String qtdHorasDiarias, long codigoCursoVinculado);
	public boolean removerDisciplina(long codigoDisciplina);
	public void consultarDisciplina(long codigoDisciplina);

}
