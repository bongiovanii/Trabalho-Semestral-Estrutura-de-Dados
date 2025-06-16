package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import controller.ProcessoController;



public class TelaProcessos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

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

			}

		});

	}

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
		    try {
		        long codigoDisciplina = Long.parseLong(textField_IdDisciplina.getText());
		        long codigoProcesso = Long.parseLong(textField_CodigoProcesso.getText());
		        
		        controller.abrirProcesso(codigoDisciplina, codigoProcesso);
		        
		        textAreaResultado.setText("Processo " + codigoProcesso + " aberto com sucesso!\n" +
		                                "Disciplina: " + codigoDisciplina + "\n" +
		                                "Professores inscritos automaticamente.");
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos!");
		    }
		});
		
		btnFecharInscricao.addActionListener(e -> {
		    try {
		        long codigoProcesso = Long.parseLong(textField_CodigoProcesso.getText());
		        
		        controller.fecharProcesso(codigoProcesso);
		        
		        textAreaResultado.setText("Processo " + codigoProcesso + " fechado com sucesso!");
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Por favor, insira um código de processo válido!");
		    }
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

}