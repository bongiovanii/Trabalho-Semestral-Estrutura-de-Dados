
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.TelaCursos;
import view.TelaDisciplinas;
import view.TelaProcessos;
import view.TelaProfessores;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDisciplinas = new JButton("Disciplinas");

		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDisciplinas telaDisciplinas = new TelaDisciplinas();
				telaDisciplinas.setVisible(true);
				dispose();
			}
		});
		btnDisciplinas.setForeground(Color.WHITE);
		btnDisciplinas.setBackground(new Color(26, 95, 180));
		btnDisciplinas.setToolTipText("Acessar Disciplinas");
		btnDisciplinas.setFont(new Font("Dialog", Font.BOLD, 14));
		btnDisciplinas.setBounds(290, 108, 125, 25);
		contentPane.add(btnDisciplinas);

		JButton btnCursos = new JButton("Cursos");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCursos telaCursos = new TelaCursos();
				telaCursos.setVisible(true);
				dispose();
			}
		});

		btnCursos.setForeground(Color.WHITE);
		btnCursos.setBackground(new Color(26, 95, 180));
		btnCursos.setToolTipText("Acessar Cursos");
		btnCursos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCursos.setBounds(153, 108, 125, 25);
		contentPane.add(btnCursos);

		JButton btnProfessores = new JButton("Professores");
		btnProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProfessores telaProfessores = new TelaProfessores();
				telaProfessores.setVisible(true);
				dispose();
			}
		});
		btnProfessores.setForeground(Color.WHITE);
		btnProfessores.setBackground(new Color(26, 95, 180));
		btnProfessores.setToolTipText("Acessar Professores");
		btnProfessores.setFont(new Font("Dialog", Font.BOLD, 14));
		btnProfessores.setBounds(16, 108, 125, 25);
		contentPane.add(btnProfessores);

		JButton btnProcessos = new JButton("Inscrições");
		btnProcessos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcessos telaProcessos = new TelaProcessos();
				telaProcessos.setVisible(true);
				dispose();
			}
		});
		btnProcessos.setForeground(Color.WHITE);
		btnProcessos.setBackground(new Color(26, 95, 180));
		btnProcessos.setToolTipText("Acessar Inscrições");
		btnProcessos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnProcessos.setBounds(427, 108, 125, 25);
		contentPane.add(btnProcessos);

		JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento De Contratações");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 12, 455, 36);
		contentPane.add(lblNewLabel);

		JLabel lblSejaBemVindo = new JLabel("Bem Vindo!");
		lblSejaBemVindo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSejaBemVindo.setBounds(255, 60, 85, 17);
		contentPane.add(lblSejaBemVindo);

		JButton btnSairDoSistema = new JButton("Sair do Sistema");
		btnSairDoSistema.setForeground(new Color(255, 255, 255));
		btnSairDoSistema.setBackground(new Color(165, 29, 45));
		btnSairDoSistema.setBounds(218, 305, 155, 27);
		contentPane.add(btnSairDoSistema);
		btnSairDoSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}
