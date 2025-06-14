package model;

public class AreaConhecimento {
    private String tipo;

    public AreaConhecimento() {
    }

    public AreaConhecimento(String tipo) {
        this.tipo = tipo;
    }

    // Getter e Setter
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
