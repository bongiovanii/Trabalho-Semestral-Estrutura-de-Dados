package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaProfessorConsultaController implements ActionListener {
	private JTextField textField_cpfConsulta;
	FuncionarioController func = new FuncionarioController();

	public TelaProfessorConsultaController(JTextField textField_cpfConsulta) {
		super();
		this.textField_cpfConsulta = textField_cpfConsulta;
	}

	public boolean validaTela() {
		boolean valido = true;
		if (textField_cpfConsulta.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}

		return valido;
	}

	public void chamaConsultaProfessor() {
		try {
			String cpfConsulta = textField_cpfConsulta.getText();
			long cpf = Long.parseLong(cpfConsulta);

			func.consultarProfessor(cpf);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valida = validaTela();

		if (valida) {
			chamaConsultaProfessor();
		}

	}

}
