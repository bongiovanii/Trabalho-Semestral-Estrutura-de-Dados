package model;

public class Curso extends AreaConhecimento{
	private long codigocodigo;
	private String nomeCurso;
	private String areaCurso;
	
	public Curso(long codigoCurso, String nomeCurso, String areaCurso) {
		this.codigocodigo = codigoCurso;
		this.nomeCurso = nomeCurso;
		this.areaCurso = areaCurso;
	}
	public long getCodigocodigo() {
		return codigocodigo;
	}
	public void setCodigocodigo(long codigocodigo) {
		this.codigocodigo = codigocodigo;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getAreaCurso() {
		return areaCurso;
	}
	public void setAreaCurso(String areaCurso) {
		this.areaCurso = areaCurso;
	}
	
	
	
}
