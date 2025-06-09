package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.TelaDisciplinasController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaDisciplinas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_disciplinaConsulta;
	private JTextField textField_IdDisciplina;
	private JTextField textField_nomeDisciplina;
	private JTextField textField_diaSemana;
	private JTextField textField_horaMinistrada;
	private JTextField textField_horasDiarias;
	private JTextField textField_codigoCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDisciplinas frame = new TelaDisciplinas();
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
	public TelaDisciplinas() {
		setTitle("Disciplinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Nova Disciplina");
		lblNewLabel.setBounds(23, 24, 178, 17);
		contentPane.add(lblNewLabel);

		JLabel lbl_IdDisciplina = new JLabel("Código da disciplina");
		lbl_IdDisciplina.setBounds(23, 46, 172, 17);
		contentPane.add(lbl_IdDisciplina);

		textField_IdDisciplina = new JTextField();
		textField_IdDisciplina.setBounds(23, 64, 172, 21);
		contentPane.add(textField_IdDisciplina);
		textField_IdDisciplina.setColumns(10);

		JLabel lblNomeDisciplina = new JLabel("Nome da disciplina");
		lblNomeDisciplina.setBounds(23, 89, 172, 17);
		contentPane.add(lblNomeDisciplina);

		textField_nomeDisciplina = new JTextField();
		textField_nomeDisciplina.setBounds(23, 108, 172, 21);
		contentPane.add(textField_nomeDisciplina);
		textField_nomeDisciplina.setColumns(10);

		JLabel lblDiaSemana = new JLabel("Dia da semana ministrado");
		lblDiaSemana.setBounds(23, 133, 172, 21);
		contentPane.add(lblDiaSemana);

		textField_diaSemana = new JTextField();
		textField_diaSemana.setBounds(23, 152, 172, 21);
		contentPane.add(textField_diaSemana);
		textField_diaSemana.setColumns(10);

		JLabel lblHoraMinistrada = new JLabel("Hora de início");
		lblHoraMinistrada.setBounds(23, 179, 172, 21);
		contentPane.add(lblHoraMinistrada);

		textField_horaMinistrada = new JTextField();
		textField_horaMinistrada.setBounds(23, 198, 172, 21);
		contentPane.add(textField_horaMinistrada);
		textField_horaMinistrada.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar\n");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(50, 328, 105, 27);
		contentPane.add(btnCadastrar);

		JLabel lblConsultarDisciplinas = new JLabel("Consultar Disciplinas");
		lblConsultarDisciplinas.setBounds(230, 12, 124, 17);
		contentPane.add(lblConsultarDisciplinas);

		textField_disciplinaConsulta = new JTextField();
		textField_disciplinaConsulta.setColumns(10);
		textField_disciplinaConsulta.setBounds(230, 58, 172, 21);
		contentPane.add(textField_disciplinaConsulta);

		JLabel lblCpf_1 = new JLabel("Código da disciplina");
		lblCpf_1.setBounds(230, 41, 172, 17);
		contentPane.add(lblCpf_1);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setBounds(414, 55, 105, 27);
		contentPane.add(btnConsultar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(154, 153, 150));
		btnVoltar.setBounds(23, 7, 78, 17);
		contentPane.add(btnVoltar);

		textField_horasDiarias = new JTextField();
		textField_horasDiarias.setColumns(10);
		textField_horasDiarias.setBounds(23, 243, 172, 21);
		contentPane.add(textField_horasDiarias);

		JLabel lblHorasDiarias = new JLabel("Quantidade de horas diárias");
		lblHorasDiarias.setBounds(23, 222, 195, 21);
		contentPane.add(lblHorasDiarias);
		
		textField_codigoCurso = new JTextField();
		textField_codigoCurso.setColumns(10);
		textField_codigoCurso.setBounds(23, 296, 172, 21);
		contentPane.add(textField_codigoCurso);
		
		JLabel lblCursoVinculado = new JLabel("Código do Curso vinculado");
		lblCursoVinculado.setBounds(23, 275, 195, 21);
		contentPane.add(lblCursoVinculado);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				dispose();

			}
		});

		TelaDisciplinasController tdcontroller = new TelaDisciplinasController();
	}
}
