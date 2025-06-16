package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Disciplina;


public class TelaDisciplinasController {

    private final JTextField textField_disciplinaConsulta;
    private final JTextField textField_IdDisciplina;
    private final JTextField textField_nomeDisciplina;
    private final JTextField textField_diaSemana;
    private final JTextField textField_horaMinistrada;
    private final JTextField textField_horasDiarias;
    private final JTextField textField_codigoCurso;

    public TelaDisciplinasController(
        JTextField textField_disciplinaConsulta,
        JTextField textField_IdDisciplina,
        JTextField textField_nomeDisciplina,
        JTextField textField_diaSemana,
        JTextField textField_horaMinistrada,
        JTextField textField_horasDiarias,
        JTextField textField_codigoCurso
    ) {
        this.textField_disciplinaConsulta = textField_disciplinaConsulta;
        this.textField_IdDisciplina      = textField_IdDisciplina;
        this.textField_nomeDisciplina    = textField_nomeDisciplina;
        this.textField_diaSemana         = textField_diaSemana;
        this.textField_horaMinistrada    = textField_horaMinistrada;
        this.textField_horasDiarias      = textField_horasDiarias;
        this.textField_codigoCurso       = textField_codigoCurso;
    }

    public void chamarCadastroDisciplina() {
		FuncionarioController funcionarioController = new FuncionarioController();
		long codigoDisciplina = Long.parseLong(textField_IdDisciplina.getText());
		String nome = textField_nomeDisciplina.getText();
		String diaSemana = textField_diaSemana.getText();
		String horario = textField_horaMinistrada.getText();
		String horasDiarias = textField_horasDiarias.getText();

		// Aqui voce deve fazer a logica por tras das disciplinas, cursos e areas de
		// conhecimento
		// talvez usar hash para ir encadeando e colocando uma disciplina dentro de um
		// curso e um curso dentro de uma
		// area de conhecimento, algo do tipo...

		// Por enquanto vou somente pegar a variavel codigoCurso e jogar direto na
		// function de cadastro
		// mas isso ta errado, devemos pegar essa variavel do curso a qual a disciplina
		// pertence

		long codigoCurso = Long.parseLong(textField_codigoCurso.getText());

		funcionarioController.cadastraDisciplina(codigoDisciplina, nome, diaSemana, horario, horasDiarias, codigoCurso);
		limparCampos();
		
	}
	
	public void chamarConsulta() {
		long codigoDisciplina = Long.parseLong(textField_disciplinaConsulta.getText());
		FuncionarioController funcionarioController = new FuncionarioController();
		Disciplina disciplina = funcionarioController.buscarDisciplinaPorCodigo(codigoDisciplina);
		
		if (disciplina != null) {
		   
		    textField_IdDisciplina.setText(String.valueOf(disciplina.getCodigoDisciplina()));
		    textField_nomeDisciplina.setText(disciplina.getNomeDisciplina());
		    textField_diaSemana.setText(disciplina.getDiaSemana());
		    textField_horaMinistrada.setText(disciplina.getHorario());
		    textField_horasDiarias.setText(String.valueOf(disciplina.getQtdHorasDiarias()));
		    textField_codigoCurso.setText(String.valueOf(disciplina.getCodigoCurso()));
		    
		} else {
		    JOptionPane.showMessageDialog(null, "Disciplina com codigo " + codigoDisciplina + " não encontrado.");
		    limparCampos();
		}


	}
	
	public void chamarRemover() {
		long codigoDisciplina = Long.parseLong(textField_disciplinaConsulta.getText());
		FuncionarioController funcionarioController = new FuncionarioController();
		
		try {
			
			boolean sucesso = false;
			try {
				sucesso = funcionarioController.removerDisciplina(codigoDisciplina);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (sucesso) {
				limparCampos();
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Digite um Codigo válido para remover.");
		}

	}
	
	public boolean validaConsulta() {
		boolean valido = true;
		if(textField_disciplinaConsulta.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Código da disciplina' para realizar uma consulta", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}
		
		return valido;
	}
	
	public void chamarAtualiza() {
		long codigoDisciplina = Long.parseLong(textField_disciplinaConsulta.getText());
		FuncionarioController funcionarioController = new FuncionarioController();
	
		String nome = textField_nomeDisciplina.getText();
		String diaSemana = textField_diaSemana.getText();
		String horario = textField_horaMinistrada.getText();
		String horasDiarias = textField_horasDiarias.getText();
		
		funcionarioController.atualizarDisciplina(codigoDisciplina, nome, diaSemana, horario, horasDiarias, codigoDisciplina);
		limparCampos();
	}
	
	public boolean validaTela() {
		boolean valido = true;
		if (textField_IdDisciplina.getText().trim().equals("")
		        || textField_nomeDisciplina.getText().trim().equals("")
		        || textField_diaSemana.getText().trim().equals("")
		        || textField_horaMinistrada.getText().trim().equals("")
		        || textField_horasDiarias.getText().trim().equals("")
		        || textField_codigoCurso.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}

		return valido;
	}
		
	private void limparCampos() {
		textField_disciplinaConsulta.setText("");
		textField_IdDisciplina.setText("");
		textField_nomeDisciplina.setText("");
		textField_diaSemana.setText("");
		textField_horaMinistrada.setText("");
		textField_horasDiarias.setText("");
		textField_codigoCurso.setText("");

	}

	
}



