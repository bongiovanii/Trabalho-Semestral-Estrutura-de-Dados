package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< Updated upstream
import controller.TelaCursosController;
=======
import controller.FuncionarioController;
import controller.TelaCursosController;
import model.Curso;
import model.Professor;
>>>>>>> Stashed changes

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
<<<<<<< Updated upstream
=======
import javax.swing.JOptionPane;
>>>>>>> Stashed changes
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class TelaCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_codigo;
	private JTextField textField_nomeCurso;
	private JTextField textField_consultaCurso;
<<<<<<< Updated upstream
	private JTextField textField_Area;
=======
	private JTextField textField_area;
>>>>>>> Stashed changes

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCursos frame = new TelaCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCursos() {
		setTitle("Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Novo Curso");
		lblNewLabel.setBounds(23, 60, 178, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNomeCurso = new JLabel("Nome do Curso");
		lblNomeCurso.setBounds(23, 82, 91, 17);
		contentPane.add(lblNomeCurso);

		textField_nomeCurso = new JTextField();
		textField_nomeCurso.setColumns(10);
		textField_nomeCurso.setBounds(23, 100, 172, 21);
		contentPane.add(textField_nomeCurso);

		JLabel lblCodigoCurso = new JLabel("Código do Curso");
		lblCodigoCurso.setBounds(23, 125, 172, 17);
		contentPane.add(lblCodigoCurso);

		textField_codigo = new JTextField();
		textField_codigo.setBounds(23, 144, 172, 21);
		contentPane.add(textField_codigo);
		textField_codigo.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(54, 227, 105, 27);
		contentPane.add(btnCadastrar);
<<<<<<< Updated upstream
=======

		TelaCursosController tccontroller = new TelaCursosController(textField_codigo, textField_nomeCurso,
				textField_area);

		btnCadastrar.addActionListener(tccontroller);
		
>>>>>>> Stashed changes
		


		JLabel lblConsultarProfessor = new JLabel("Consultar Curso");
		lblConsultarProfessor.setBounds(230, 12, 124, 17);
		contentPane.add(lblConsultarProfessor);

		textField_consultaCurso = new JTextField();
		textField_consultaCurso.setColumns(10);
		textField_consultaCurso.setBounds(230, 58, 172, 21);
		contentPane.add(textField_consultaCurso);

		JLabel lblCdigo_Curso = new JLabel("Código do Curso");
		lblCdigo_Curso.setBounds(230, 40, 124, 17);
		contentPane.add(lblCdigo_Curso);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setBounds(414, 55, 105, 27);
		contentPane.add(btnConsultar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(154, 153, 150));
		btnVoltar.setBounds(23, 7, 78, 17);
		contentPane.add(btnVoltar);

		JLabel lblAreaCurso = new JLabel("Área de Conhecimento");
		lblAreaCurso.setBounds(23, 176, 172, 17);
		contentPane.add(lblAreaCurso);

<<<<<<< Updated upstream
		textField_Area = new JTextField();
		textField_Area.setColumns(10);
		textField_Area.setBounds(23, 195, 172, 21);
		contentPane.add(textField_Area);
=======
		textField_area = new JTextField();
		textField_area.setColumns(10);
		textField_area.setBounds(23, 195, 172, 21);
		contentPane.add(textField_area);
>>>>>>> Stashed changes
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();

			}
		});
		
<<<<<<< Updated upstream
		TelaCursosController tccontroller = new TelaCursosController(textField_codigo, textField_nomeCurso,
				textField_Area);
		btnCadastrar.addActionListener(tccontroller);

	}
=======
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(new Color(0, 0, 255));
		btnRemover.setBounds(172, 226, 117, 29);
		contentPane.add(btnRemover);
		
		FuncionarioController funcionarioController =  new FuncionarioController();
		
		TelaCursosController telaCursosController =  new TelaCursosController(textField_codigo, textField_nomeCurso, textField_area);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(14, 52, 255));
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBounds(300, 226, 117, 29);
		contentPane.add(btnAtualizar);
	
		btnCadastrar.addActionListener(e ->{
			telaCursosController.actionPerformed(e);
			limparCampos();
		});
		
		btnRemover.addActionListener(e -> {
			try {
				long codigoRemover = Long.parseLong(textField_codigo.getText().trim());
				boolean sucesso = false;
				try {
					sucesso = funcionarioController.removeCurso(codigoRemover);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (sucesso) {
					limparCampos();
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido para remover.");
			}
		});
		
		btnConsultar.addActionListener(e -> {
		    try {
		        long codigoCurso = Long.parseLong(textField_consultaCurso.getText().trim());  
		        Curso curso = funcionarioController.buscarCursoPorCodigo(codigoCurso);

		        if (curso != null) {
		            textField_codigo.setText(Long.toString(curso.getCodigocodigo()));
		            textField_nomeCurso.setText(curso.getNomeCurso());
		            textField_area.setText(curso.getAreaCurso());
		        } else {
		            JOptionPane.showMessageDialog(null, "Curso com código " + codigoCurso + " não encontrado.");
		            limparCampos();
		        }
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Digite um código válido para consulta.");
		    }
		});
		
		btnAtualizar.addActionListener(e ->{
				try {
					long codigo = Long.parseLong(textField_consultaCurso.getText());
					funcionarioController.atualizarCurso(codigo, textField_nomeCurso.getText(), textField_area.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Digite um código válido para consulta e atualizacao.");
				}

			
		});
		
		
		

	}

	private void limparCampos() {
		textField_codigo.setText("");
		textField_nomeCurso.setText("");
		textField_consultaCurso.setText("");
		textField_area.setText("");// TODO Auto-generated method stub
		
	}
>>>>>>> Stashed changes
}
