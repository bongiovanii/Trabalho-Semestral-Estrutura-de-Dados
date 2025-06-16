package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< Updated upstream
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

=======
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ProcessoController;

>>>>>>> Stashed changes
public class TelaProcessos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
<<<<<<< Updated upstream
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
=======
	private JTextField textField_IdDisciplina;
	private JTextField textField_CodigoProcesso;
	private JTextField textField_codigoConsulta;
	private JTextArea textAreaResultado;

	private ProcessoController controller = new ProcessoController(); // Controller especializado

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaProcessos frame = new TelaProcessos();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
>>>>>>> Stashed changes
			}
		});
	}

<<<<<<< Updated upstream
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

=======
	public TelaProcessos() {
		setTitle("Inscrição em Processos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Gerenciamento de Processos");
		lblTitulo.setBounds(20, 10, 300, 20);
		contentPane.add(lblTitulo);

		JLabel lblIdDisciplina = new JLabel("Código da Disciplina:");
		lblIdDisciplina.setBounds(20, 50, 150, 20);
		contentPane.add(lblIdDisciplina);

		textField_IdDisciplina = new JTextField();
		textField_IdDisciplina.setBounds(170, 50, 150, 21);
		contentPane.add(textField_IdDisciplina);

		JLabel lblCodigoProcesso = new JLabel("Código do Processo:");
		lblCodigoProcesso.setBounds(20, 80, 150, 20);
		contentPane.add(lblCodigoProcesso);

		textField_CodigoProcesso = new JTextField();
		textField_CodigoProcesso.setBounds(170, 80, 150, 21);
		contentPane.add(textField_CodigoProcesso);

		JButton btnAbrirInscricao = new JButton("Abrir Processo");
		btnAbrirInscricao.setBackground(new Color(26, 95, 180));
		btnAbrirInscricao.setForeground(Color.WHITE);
		btnAbrirInscricao.setBounds(20, 120, 140, 27);
		contentPane.add(btnAbrirInscricao);

		JButton btnFecharInscricao = new JButton("Fechar Processo");
		btnFecharInscricao.setBackground(new Color(180, 26, 26));
		btnFecharInscricao.setForeground(Color.WHITE);
		btnFecharInscricao.setBounds(180, 120, 140, 27);
		contentPane.add(btnFecharInscricao);

		JLabel lblConsulta = new JLabel("Consultar Processo por Código:");
		lblConsulta.setBounds(350, 50, 200, 20);
		contentPane.add(lblConsulta);

		textField_codigoConsulta = new JTextField();
		textField_codigoConsulta.setBounds(350, 70, 150, 21);
		contentPane.add(textField_codigoConsulta);

		JButton btnConsultar = new JButton("Consultar Inscritos");
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBounds(510, 68, 140, 25);
		contentPane.add(btnConsultar);

		JButton btnMostrarDisciplinas = new JButton("Mostrar Disciplinas Abertas");
		btnMostrarDisciplinas.setBackground(new Color(90, 160, 90));
		btnMostrarDisciplinas.setForeground(Color.WHITE);
		btnMostrarDisciplinas.setBounds(350, 120, 300, 25);
		contentPane.add(btnMostrarDisciplinas);

		textAreaResultado = new JTextArea();
		textAreaResultado.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textAreaResultado);
		scrollPane.setBounds(20, 170, 630, 250);
		contentPane.add(scrollPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.GRAY);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBounds(580, 10, 70, 25);
		contentPane.add(btnVoltar);

		// AÇÕES DOS BOTÕES

		btnAbrirInscricao.addActionListener(e -> {
			int codigoDisciplina = Integer.parseInt(textField_IdDisciplina.getText());
			int codigoProcesso = Integer.parseInt(textField_CodigoProcesso.getText());
			controller.abrirProcesso(codigoDisciplina, codigoProcesso);
			textAreaResultado.setText("Processo aberto com sucesso e inscrições iniciadas automaticamente.");
		});

		btnFecharInscricao.addActionListener(e -> {
			int codigoProcesso = Integer.parseInt(textField_CodigoProcesso.getText());
			controller.fecharProcesso(codigoProcesso);
			textAreaResultado.setText("Processo fechado com sucesso.");
		});

		btnConsultar.addActionListener(e -> {
			int codigoConsulta = Integer.parseInt(textField_codigoConsulta.getText());
			String resultado = controller.consultarInscritosOrdenados(codigoConsulta);
			textAreaResultado.setText(resultado);
		});

		btnMostrarDisciplinas.addActionListener(e -> {
			String disciplinas = controller.listarDisciplinasComProcessosAbertos();
			textAreaResultado.setText(disciplinas);
		});

		btnVoltar.addActionListener(e -> {
			TelaPrincipal tela = new TelaPrincipal();
			tela.setVisible(true);
			dispose();
		});
	}
>>>>>>> Stashed changes
}
