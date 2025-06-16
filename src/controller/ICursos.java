package controller;

import model.Curso;

public interface ICursos {
	public void cadastraCurso(long codigoCurso, String nomeCurso, String areaCurso);
	public boolean removeCurso(long codigoCurso);
	public void consultaCurso(long codigoCurso);
	

}
