package model;

public class Disciplina {
	private int codigoDisciplina;
	private String diaSemana;
	private String horario;
	private int qtdHorasDiarias;
	private String nomeDisciplina;
	private int codigoCurso;
	
	
	

	public Disciplina() {
		super();
	
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}


	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}

	public void setQtdHorasDiarias(int qtdHorasDiarias) {
		this.qtdHorasDiarias = qtdHorasDiarias;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

}
