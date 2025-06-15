package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaProcessos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_CpfProfessor;
	private JTextField textField_IdDisciplina;
	private JTextField textField_CodigoProcesso;
	private JTextField textField_codigoConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcessos frame = new TelaProcessos();
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
	public TelaProcessos() {
		setTitle("Inscrição em processos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro em Processos");
		lblNewLabel.setBounds(23, 24, 178, 17);
		contentPane.add(lblNewLabel);

		JLabel lblCpfProfessor = new JLabel("CPF do Professor");
		lblCpfProfessor.setBounds(23, 46, 172, 17);
		contentPane.add(lblCpfProfessor);

		textField_CpfProfessor = new JTextField();
		textField_CpfProfessor.setBounds(23, 64, 172, 21);
		contentPane.add(textField_CpfProfessor);
		textField_CpfProfessor.setColumns(10);

		JLabel lblIdDisciplina = new JLabel("Código da Disciplina");
		lblIdDisciplina.setBounds(23, 89, 172, 17);
		contentPane.add(lblIdDisciplina);

		textField_IdDisciplina = new JTextField();
		textField_IdDisciplina.setBounds(23, 108, 172, 21);
		contentPane.add(textField_IdDisciplina);
		textField_IdDisciplina.setColumns(10);

		JLabel lblCodigoProcesso = new JLabel("Código do Processo");
		lblCodigoProcesso.setBounds(23, 133, 172, 21);
		contentPane.add(lblCodigoProcesso);

		textField_CodigoProcesso = new JTextField();
		textField_CodigoProcesso.setBounds(23, 152, 172, 21);
		contentPane.add(textField_CodigoProcesso);
		textField_CodigoProcesso.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(54, 227, 105, 27);
		contentPane.add(btnCadastrar);

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

		JLabel lblConsultarProfessor = new JLabel("Consultar Processo");
		lblConsultarProfessor.setBounds(230, 12, 124, 17);
		contentPane.add(lblConsultarProfessor);

		textField_codigoConsulta = new JTextField();
		textField_codigoConsulta.setColumns(10);
		textField_codigoConsulta.setBounds(230, 58, 172, 21);
		contentPane.add(textField_codigoConsulta);

		JLabel lblCpf_1 = new JLabel("Código do Processo");
		lblCpf_1.setBounds(230, 41, 124, 17);
		contentPane.add(lblCpf_1);

		JButton btnConsultar = new JButton("Consultar");// permite a pesquisa dos incritos em um processo por meio do
														// código do processo
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setBounds(414, 55, 105, 27);
		contentPane.add(btnConsultar);
	}

}
