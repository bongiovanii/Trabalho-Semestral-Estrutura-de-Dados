package controller;

public interface IInscricao {
	public void novaInscricao(long cpfProfessor, int codigoDisciplina, int codigoProcesso);
	public void removeInscricao(int codigoProcesso);
	
	
}
