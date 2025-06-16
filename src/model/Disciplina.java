package model;

public class Disciplina {
	private long codigoDisciplina;
	private String diaSemana;
	private String horario;
	private String qtdHorasDiarias;
	private String nomeDisciplina;
	private long codigoCurso;

	public Disciplina(long codigoDisciplina, String nomeDisciplina, String diaSemana, String horario,
			String qtdHorasDiarias, long codigoCurso) {
		super();
		this.codigoDisciplina = codigoDisciplina;
		this.diaSemana = diaSemana;
		this.horario = horario;
		this.qtdHorasDiarias = qtdHorasDiarias;
		this.nomeDisciplina = nomeDisciplina;
		this.codigoCurso = codigoCurso;
	}

	public long getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public long getCodigoDisciplina() {
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

	public String getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}

	public void setQtdHorasDiarias(String qtdHorasDiarias) {
		this.qtdHorasDiarias = qtdHorasDiarias;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

}
