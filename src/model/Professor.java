package model;

public class Professor extends AreaConhecimento { // professor herda o atributo area da classe AreaConhecimento
	private long cpf;
	private String nome;
	private int pontos;

	public Professor() {
		super();
	}

	// Construtor com parâmetros incluindo a área (tipo)
	public Professor(long cpf, String nome, String area, int pontos) {
		super(area); // seta a área de conhecimento no construtor da superclasse
		this.cpf = cpf;
		this.nome = nome;
		this.pontos = pontos;
	}

	// Getters e setters

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getArea() {
		return getTipo();
	}

	public void setArea(String area) {
		setTipo(area);
	}

	@Override
	public int hashCode() {
		return Long.hashCode(cpf); // usa o CPF como base de hash
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Professor outro = (Professor) obj;
		return this.cpf == outro.cpf;
	}

	@Override
	public String toString() {
		return "Professor [cpf=" + cpf + ", nome=" + nome + ", area=" + getArea() + ", pontos=" + pontos + "]";
	}
}
