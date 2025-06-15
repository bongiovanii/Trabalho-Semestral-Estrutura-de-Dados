package controller;

import model.Curso;

public interface ICursos {
	public void cadastraCurso(int codigoCurso, String nomeCurso);
	public void removeCurso(Curso curso);
	public void consultaCurso(Curso curso);
	

}
