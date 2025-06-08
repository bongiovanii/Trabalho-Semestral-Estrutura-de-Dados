package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class TelaCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_codigo;
	private JTextField textField_nomeCurso;
	private JTextField textField_consultaCurso;

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
		lblCodigoCurso.setBounds(23, 125, 91, 17);
		contentPane.add(lblCodigoCurso);

		textField_codigo = new JTextField();
		textField_codigo.setBounds(23, 144, 172, 21);
		contentPane.add(textField_codigo);
		textField_codigo.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(49, 176, 105, 27);
		contentPane.add(btnCadastrar);

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
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();

			}
		});

	}
}
