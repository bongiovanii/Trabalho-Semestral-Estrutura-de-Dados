package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaProfessorController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaProfessores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cpf;
	private JTextField textField_area;
	private JTextField textField_pontos;
	private JTextField textField_cpfConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessores frame = new TelaProfessores();
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
	public TelaProfessores() {
		setTitle("Professores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Novo Professor");
		lblNewLabel.setBounds(23, 12, 178, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 41, 60, 17);
		contentPane.add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(23, 58, 172, 21);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(23, 91, 60, 17);
		contentPane.add(lblCpf);
		
		textField_cpf = new JTextField();
		textField_cpf.setBounds(23, 109, 172, 21);
		contentPane.add(textField_cpf);
		textField_cpf.setColumns(10);
		
		JLabel lblrea = new JLabel("Área");
		lblrea.setBounds(23, 142, 60, 17);
		contentPane.add(lblrea);
		
		textField_area = new JTextField();
		textField_area.setBounds(23, 159, 172, 21);
		contentPane.add(textField_area);
		textField_area.setColumns(10);
		
		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(23, 192, 60, 17);
		contentPane.add(lblPontos);
		
		textField_pontos = new JTextField();
		textField_pontos.setBounds(23, 212, 172, 21);
		contentPane.add(textField_pontos);
		textField_pontos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(53, 245, 105, 27);
		contentPane.add(btnCadastrar);
		
		JLabel lblConsultarProfessor = new JLabel("Consultar Professor");
		lblConsultarProfessor.setBounds(230, 12, 124, 17);
		contentPane.add(lblConsultarProfessor);
		
		textField_cpfConsulta = new JTextField();
		textField_cpfConsulta.setColumns(10);
		textField_cpfConsulta.setBounds(230, 58, 172, 21);
		contentPane.add(textField_cpfConsulta);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(230, 41, 60, 17);
		contentPane.add(lblCpf_1);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setBounds(414, 55, 105, 27);
		contentPane.add(btnConsultar);
		
		TelaProfessorController telaProfessorController = new TelaProfessorController(textField_nome, textField_cpf, textField_area, textField_pontos);
		
		btnCadastrar.addActionListener(telaProfessorController);
	
	
	}
}
