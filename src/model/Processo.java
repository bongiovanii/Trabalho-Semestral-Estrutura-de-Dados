package model;

import br.edu.fateczl.bongiovani.Lista;

public class Processo {
    private long codigoProcesso;
    private long codigoDisciplina;
    private boolean aberto;
    private String nomeDisciplina;  // Adicionado para fácil acesso
    private Lista<Professor> professoresInscritos;  // Renomeado para ficar mais claro

    public Processo(long codigoDisciplina, long codigoProcesso, boolean aberto, 
                   Lista<Disciplina> disciplinas, Lista<Professor> professoresInscritos) {
        this.codigoProcesso = codigoProcesso;
        this.codigoDisciplina = codigoDisciplina;
        this.aberto = aberto;
        this.professoresInscritos = professoresInscritos;
        
        // Busca o nome da disciplina correspondente
        this.nomeDisciplina = buscarNomeDisciplina(codigoDisciplina, disciplinas);
    }

    private String buscarNomeDisciplina(long codigoDisciplina, Lista<Disciplina> disciplinas) {
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = null;
			try {
				d = disciplinas.get(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (d != null && d.getCodigoDisciplina() == codigoDisciplina) {
                return d.getNomeDisciplina();
            }
        }
        return "Disciplina não encontrada";
    }

    // Getters e Setters
    public long getCodigoProcesso() {
        return codigoProcesso;
    }

    public long getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public Lista<Professor> getProfessoresInscritos() {
        return professoresInscritos;
    }

    @Override
    public String toString() {
        return "Processo [Código: " + codigoProcesso + 
               ", Disciplina: " + nomeDisciplina + 
               ", Status: " + (aberto ? "Aberto" : "Fechado") + 
               ", Inscritos: " + professoresInscritos.size() + "]";
    }
}