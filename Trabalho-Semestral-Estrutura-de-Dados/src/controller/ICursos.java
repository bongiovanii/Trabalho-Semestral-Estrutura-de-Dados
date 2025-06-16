package controller;

import model.Curso;

public interface ICursos {
<<<<<<< Updated upstream
	public void cadastraCurso(int codigoCurso, String nomeCurso);
	public void removeCurso(Curso curso);
	public void consultaCurso(Curso curso);
=======
	public void cadastraCurso(long codigoCurso, String nomeCurso, String areaCurso);
	public boolean removeCurso(long codigoCurso);
	public void consultaCurso(long codigoCurso);
>>>>>>> Stashed changes
	

}
