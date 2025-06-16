package model;

<<<<<<< Updated upstream
public class Disciplina extends Curso {
	private int codigoDisciplina;
	private String diaSemana;
	private String horario;
	private int qtdHorasDiarias;
	private String nomeDisciplina;
	private int codigoCurso;

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigoDisciplina() {
=======
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
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	public int getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}

	public void setQtdHorasDiarias(int qtdHorasDiarias) {
=======
	public String getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}

	public void setQtdHorasDiarias(String qtdHorasDiarias) {
>>>>>>> Stashed changes
		this.qtdHorasDiarias = qtdHorasDiarias;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

}
