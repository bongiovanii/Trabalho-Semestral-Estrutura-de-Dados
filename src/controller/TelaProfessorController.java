package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaProfessorController implements ActionListener {
	FuncionarioController func = new FuncionarioController();

	private JTextField textField_nome;
	private JTextField textField_cpf;
	private JTextField textField_area;
	private JTextField textField_pontos;

	public TelaProfessorController(JTextField textField_nome, JTextField textField_cpf, JTextField textField_area,
			JTextField textField_pontos) {
		super();
		this.textField_nome = textField_nome;
		this.textField_cpf = textField_cpf;
		this.textField_area = textField_area;
		this.textField_pontos = textField_pontos;

	}

	public boolean validaTela() {
		boolean valido = true;
		if (textField_nome.getText().trim().equals("") || textField_cpf.getText().trim().equals("")
				|| textField_area.getText().trim().equals("") || textField_pontos.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}

		return valido;
	}

	// Falta fazer funcionar os botões

	public void chamarCadastroProfessor() {
		
		try {
		    String cpfStr = textField_cpf.getText();
		    long cpf = Long.parseLong(cpfStr);
		    int pontos = Integer.parseInt(textField_pontos.getText());

			func.cadastrarNovoProfessor(cpf, textField_nome.getText(), textField_area.getText(), pontos);
		    System.out.println("CPF: " + cpf);
		    System.out.println("Pontos: " + pontos);

			JOptionPane.showMessageDialog(null, "Professor " + textField_nome.getText() + " cadastrado com sucesso!");

		} catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog(null, "Digite um número válido.");
		}
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();

		if (valido) {
			chamarCadastroProfessor();
		}

	}

}
