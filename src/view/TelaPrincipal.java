package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;

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
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.setToolTipText("Acessar Disciplinas");
		btnDisciplinas.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		btnDisciplinas.setBounds(10, 10, 125, 25);
		contentPane.add(btnDisciplinas);
		
		JButton btnCursos = new JButton("Cursos");
		btnCursos.setToolTipText("Acessar Cursos");
		btnCursos.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		btnCursos.setBounds(155, 10, 125, 25);
		contentPane.add(btnCursos);
		
		JButton btnProfessores = new JButton("Professores");
		btnProfessores.setToolTipText("Acessar Professores");
		btnProfessores.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		btnProfessores.setBounds(300, 10, 125, 25);
		contentPane.add(btnProfessores);
		
		JButton btnProcessos = new JButton("Processos");
		btnProcessos.setToolTipText("Acessar Processos");
		btnProcessos.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		btnProcessos.setBounds(445, 10, 125, 25);
		contentPane.add(btnProcessos);
	}
}
