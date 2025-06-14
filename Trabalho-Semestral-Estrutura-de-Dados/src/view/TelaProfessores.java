package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TelaProfessorConsultaController;
import controller.TelaProfessorController;
import model.Professor;
import controller.FuncionarioController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TelaProfessores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_cpf;
	private JTextField textField_area;
	private JTextField textField_pontos;
	private JTextField textField_cpfConsulta;

	private FuncionarioController funcionarioController;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaProfessores frame = new TelaProfessores();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

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

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(23, 125, 60, 17);
		contentPane.add(lblCpf);

		textField_cpf = new JTextField();
		textField_cpf.setBounds(23, 144, 172, 21);
		contentPane.add(textField_cpf);

		JLabel lblArea = new JLabel("Área");
		lblArea.setBounds(23, 169, 60, 17);
		contentPane.add(lblArea);

		textField_area = new JTextField();
		textField_area.setBounds(23, 188, 172, 21);
		contentPane.add(textField_area);

		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(23, 210, 60, 17);
		contentPane.add(lblPontos);

		textField_pontos = new JTextField();
		textField_pontos.setBounds(23, 234, 172, 21);
		contentPane.add(textField_pontos);

		// Botão Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(26, 95, 180));
		btnCadastrar.setBounds(23, 267, 105, 27);
		contentPane.add(btnCadastrar);

		// Botão Atualizar (a implementar)
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(new Color(26, 95, 180));
		btnAtualizar.setBounds(138, 267, 105, 27);
		contentPane.add(btnAtualizar);

		// Botão Remover
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(new Color(26, 95, 180));
		btnRemover.setBounds(253, 267, 105, 27);
		contentPane.add(btnRemover);

		JLabel lblConsultarProfessor = new JLabel("Consultar Professor");
		lblConsultarProfessor.setBounds(230, 12, 124, 17);
		contentPane.add(lblConsultarProfessor);

		textField_cpfConsulta = new JTextField();
		textField_cpfConsulta.setBounds(230, 58, 172, 21);
		contentPane.add(textField_cpfConsulta);

		JLabel lblCpfConsulta = new JLabel("CPF");
		lblCpfConsulta.setBounds(230, 41, 60, 17);
		contentPane.add(lblCpfConsulta);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(26, 95, 180));
		btnConsultar.setBounds(414, 55, 105, 27);
		contentPane.add(btnConsultar);

		// Inicializando controller
		funcionarioController = new FuncionarioController();

		TelaProfessorController telaProfessorController = new TelaProfessorController(textField_nome, textField_cpf,
				textField_area, textField_pontos);

		// Ação do botão Cadastrar
		btnCadastrar.addActionListener(e -> {
			if (telaProfessorController.validaTela()) {
				telaProfessorController.chamarCadastroProfessor();
				limparCampos();
			}
		});

		// Ação do botão Consultar
		btnConsultar.addActionListener(e -> {
			try {
				long cpfConsulta = Long.parseLong(textField_cpfConsulta.getText().trim());
				Professor professor = funcionarioController.buscarProfessorPorCpf(cpfConsulta);

				if (professor != null) {
					textField_nome.setText(professor.getNome());
					textField_cpf.setText(String.valueOf(professor.getCpf()));
					textField_area.setText(professor.getArea());
					textField_pontos.setText(String.valueOf(professor.getPontos()));
				} else {
					JOptionPane.showMessageDialog(null, "Professor com CPF " + cpfConsulta + " não encontrado.");
					limparCampos();
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Digite um CPF válido para consulta.");
			}
		});

		// Ação do botão Remover
		btnRemover.addActionListener(e -> {
			try {
				long cpfRemover = Long.parseLong(textField_cpfConsulta.getText().trim());
				boolean sucesso = false;
				try {
					sucesso = funcionarioController.removerProfessor(cpfRemover);
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

		btnAtualizar.addActionListener(e -> {
		    try {
		        long cpf = Long.parseLong(textField_cpf.getText().trim());
		        String nome = textField_nome.getText().trim();
		        String area = textField_area.getText().trim();
		        int pontos = Integer.parseInt(textField_pontos.getText().trim());

		        // Validação básica
		        if (nome.isEmpty() || area.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de atualizar.");
		            return;
		        }

		        funcionarioController.atualizarProfessor(cpf, nome, area, pontos);
		        JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
		        limparCampos();

		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Erro: CPF ou pontos inválidos.");
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "Erro ao atualizar professor: " + ex.getMessage());
		    }
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(154, 153, 150));
		btnVoltar.setBounds(23, 7, 78, 17);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(e -> {
			// Supondo que você tenha uma TelaPrincipal
			TelaPrincipal telaPrincipal = new TelaPrincipal();
			telaPrincipal.setVisible(true);
			dispose();
		});
	}

	// Método para limpar os campos após o cadastro ou remoção
	private void limparCampos() {
		textField_nome.setText("");
		textField_cpf.setText("");
		textField_area.setText("");
		textField_pontos.setText("");
		textField_cpfConsulta.setText("");
	}
}
