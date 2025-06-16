package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCursosController implements ActionListener {
	private JTextField textField_codigo;
	private JTextField textField_nomeCurso;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	private JTextField textField_area;

	public TelaCursosController(JTextField textField_codigo, JTextField textField_nomeCurso,
			JTextField textField_area) {
		super();
		this.textField_codigo = textField_codigo;
		this.textField_nomeCurso = textField_nomeCurso;

		this.textField_area = textField_area;
	}

	public boolean validaTela() {
		boolean valido = true;
		if (textField_codigo.getText().trim().equals("") || textField_nomeCurso.getText().trim().equals("")
				|| textField_area.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}

		return valido;
	}

<<<<<<< Updated upstream
	FuncionarioController func = new FuncionarioController();
=======
	FuncionarioController funcionarioController = new FuncionarioController();
>>>>>>> Stashed changes

	private void chamarCadastrarCurso() {
		int codigo = Integer.parseInt(textField_codigo.getText());
		String nome = textField_nomeCurso.getText();
<<<<<<< Updated upstream
		func.cadastraCurso(codigo, nome);
=======
		String area = textField_area.getText();
		funcionarioController.cadastraCurso(codigo, nome, area);
>>>>>>> Stashed changes

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();

		if (valido) {
			chamarCadastrarCurso();
		}

	}

}
