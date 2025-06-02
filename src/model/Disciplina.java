package model;

public class Disciplina extends Curso {
	private int codigoDisciplina;
	private String diaSemana;
	private int horario;
	private int qtdHorasDiarias;
	
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public int getQtdHorasDiarias() {
		return qtdHorasDiarias;
	}
	public void setQtdHorasDiarias(int qtdHorasDiarias) {
		this.qtdHorasDiarias = qtdHorasDiarias;
	}
	
	

}
