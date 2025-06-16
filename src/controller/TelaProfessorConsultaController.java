package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

<<<<<<< Updated upstream
public class TelaProfessorConsultaController implements ActionListener{
	private JTextField textField_cpfConsulta;
	FuncionarioController func =  new FuncionarioController();
	
	
=======
public class TelaProfessorConsultaController implements ActionListener {
	private JTextField textField_cpfConsulta;
	FuncionarioController func = new FuncionarioController();

>>>>>>> Stashed changes
	public TelaProfessorConsultaController(JTextField textField_cpfConsulta) {
		super();
		this.textField_cpfConsulta = textField_cpfConsulta;
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	public boolean validaTela() {
		boolean valido = true;
		if (textField_cpfConsulta.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Preencha os campos necessários", "ERRO", JOptionPane.ERROR_MESSAGE);

			valido = false;
		}

		return valido;
	}
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	public void chamaConsultaProfessor() {
		try {
			String cpfConsulta = textField_cpfConsulta.getText();
			long cpf = Long.parseLong(cpfConsulta);
<<<<<<< Updated upstream
			
			func.consultarProfessor(cpf);
			
			
			
			
			// Dado do cpf capturado do text field cpf consulta, agora falta fazer a validação de existencia e mostrar, 
			// através de JOptionpane e HashTables

			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valida =  validaTela();
		
		if(valida) {
			chamaConsultaProfessor();
		}
		
=======

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

>>>>>>> Stashed changes
	}

}
