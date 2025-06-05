package controller;

public interface IInscricao {
	public void novaInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso);
	public void salvarInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso);
	
}
