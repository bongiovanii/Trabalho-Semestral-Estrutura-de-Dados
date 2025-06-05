package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		lblNewLabel.setBounds(23, 60, 178, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 82, 60, 17);
		contentPane.add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(23, 100, 172, 21);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(23, 125, 60, 17);
		contentPane.add(lblCpf);
		
		textField_cpf = new JTextField();
		textField_cpf.setBounds(23, 144, 172, 21);
		contentPane.add(textField_cpf);
		textField_cpf.setColumns(10);
		
		JLabel lblrea = new JLabel("Área");
		lblrea.setBounds(23, 169, 60, 17);
		contentPane.add(lblrea);
		
		textField_area = new JTextField();
		textField_area.setBounds(23, 188, 172, 21);
		contentPane.add(textField_area);
		textField_area.setColumns(10);
		
		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(23, 210, 60, 17);
		contentPane.add(lblPontos);
		
		textField_pontos = new JTextField();
		textField_pontos.setBounds(23, 234, 172, 21);
		contentPane.add(textField_pontos);
		textField_pontos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(52, 267, 105, 27);
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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(154, 153, 150));
		btnVoltar.setBounds(23, 7, 78, 17);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();
				
			}
		});
		
		
		
		btnCadastrar.addActionListener(telaProfessorController);
		
	
	
	}
}
