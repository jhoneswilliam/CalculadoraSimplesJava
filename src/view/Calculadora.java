package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.GridLayout;

import model.ControleCalculadora;
import model.Helper;
import model.Simbolo;

import java.awt.Font;

public class Calculadora implements ActionListener, KeyListener {

	public JFrame frmCalculadora;
	private JTextField textField_Texto;
	private JPanel panel;
	private JButton btnLimpar;
	private JPanel panel_Teclado;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_Div;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_Mult;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_Menos;
	private JButton btn_Ponto;
	private JButton btn_0;
	private JButton btn_Igual;
	private JButton btn_Mais;

	private ArrayList<String> CaracteresAceitos = new ArrayList<>();
	private JButton btnB;
	private JButton btn_A;
	private JButton btnC;
	private JButton btnD;
	private JButton btnE;
	private JButton btnF;
	private JButton btnExp;
	private JButton btnC_1;
	private JButton btnRadiciacao;
	private JButton btnLogaritimos;
	private JButton btnOff;

	/**
	 * Create the application.
	 */
	public Calculadora() {

		for (char e : Helper.Hexadecimal.toCharArray()) {
			CaracteresAceitos.add(e + "");
		}

		for (char e : Helper.Operadores.toCharArray()) {
			CaracteresAceitos.add(e + "");
		}

		CaracteresAceitos.add(Simbolo.PONTO);
		initialize();
	}

	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setResizable(false);
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 486, 290);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.setLocationRelativeTo(null);

		panel = new JPanel();
		frmCalculadora.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField_Texto = new JTextField();
		textField_Texto.setEditable(false);
		textField_Texto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_Texto.setBounds(0, 0, 486, 63);
		panel.add(textField_Texto);
		textField_Texto.setColumns(10);
		textField_Texto.addKeyListener(this);

		panel_Teclado = new JPanel();
		panel_Teclado.setBounds(0, 61, 480, 200);
		panel.add(panel_Teclado);
		panel_Teclado.setLayout(new GridLayout(4, 4, 0, 0));

		btnF = new JButton("F");
		btnF.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnF);
		btnF.addActionListener(this);

		btnE = new JButton("E");
		btnE.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnE);
		btnE.addActionListener(this);

		btnD = new JButton("D");
		btnD.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnD);
		btnD.addActionListener(this);

		btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnC);

		btnLimpar = new JButton("Del");
		btnLimpar.addActionListener(this);
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnLimpar);

		btnC_1 = new JButton("CA");
		btnC_1.addActionListener(this);

		btnC_1.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnC_1);

		btnOff = new JButton("OFF");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCalculadora.dispose();
			}
		});
		btnOff.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnOff);

		btnB = new JButton("B");
		btnB.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnB);
		btnB.addActionListener(this);

		btn_A = new JButton("A");
		btn_A.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_A);

		btn_A.addActionListener(this);
		btnC.addActionListener(this);

		btn_9 = new JButton("9");
		btn_9.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_9);
		btn_9.addActionListener(this);

		btn_8 = new JButton("8");
		btn_8.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_8);
		btn_8.addActionListener(this);

		btnLogaritimos = new JButton("L");
		btnLogaritimos.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnLogaritimos);

		btn_Mais = new JButton("+");
		btn_Mais.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Mais);
		btn_Mais.addActionListener(this);
		

		btn_Menos = new JButton("-");
		btn_Menos.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Menos);
		btn_Menos.addActionListener(this);

		btn_7 = new JButton("7");
		btn_7.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_7);
		btn_7.addActionListener(this);

		btn_6 = new JButton("6");
		btn_6.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_6);
		btn_6.addActionListener(this);

		btn_5 = new JButton("5");
		btn_5.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_5);
		btn_5.addActionListener(this);

		btn_4 = new JButton("4");
		btn_4.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_4);
		btn_4.addActionListener(this);

		btnRadiciacao = new JButton("R");
		btnRadiciacao.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnRadiciacao);

		btn_Mult = new JButton("*");
		btn_Mult.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Mult);
		btn_Mult.addActionListener(this);

		btn_Div = new JButton("/");
		btn_Div.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Div);
		btn_Div.addActionListener(this);

		btn_3 = new JButton("3");
		btn_3.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_3);
		btn_3.addActionListener(this);

		btn_2 = new JButton("2");
		btn_2.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_2);
		btn_2.addActionListener(this);

		btn_1 = new JButton("1");
		btn_1.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_1);
		btn_1.addActionListener(this);

		btn_0 = new JButton("0");
		btn_0.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_0);
		btn_0.addActionListener(this);

		btn_Ponto = new JButton(".");
		btn_Ponto.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Ponto);
		btn_Ponto.addActionListener(this);
		btn_Ponto.addActionListener(this);

		btnExp = new JButton("^");
		btnExp.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btnExp);

		btn_Igual = new JButton("=");
		btn_Igual.setFont(new Font("Arial", Font.BOLD, 17));
		panel_Teclado.add(btn_Igual);
		btn_Igual.addActionListener(this);
		

		btnRadiciacao.addActionListener(this);
		btnLogaritimos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = ((JButton) e.getSource()).getText();
		trataEventoClick(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String key = String.valueOf(e.getKeyChar());
		trataEventoTecla(e, key);
	}

	private void trataEventoClick(String key) {
		Montando(key);
	}

	private void Montando(String key) {

		if (key == Simbolo.APAGARTUDO) {
			ControleCalculadora.LimpaTudo();
			textField_Texto.setText("");
		}

		if (key == Simbolo.APAGARULTIMO) {
			ControleCalculadora.ApagaUltimoCaractereOperacao();
			textField_Texto.setText(ControleCalculadora.getExpressao());
		}

		if (CaracteresAceitos.contains(key.toUpperCase())) {
			try {

				if (key.equals(Simbolo.IGUAL)) {
					// ControleCalculadora.getExpressao()
					// System.out.println("Resultado: " +
					// ControleCalculadora.ObterResultado());
					textField_Texto.setText(ControleCalculadora.getExpressao() + " " + Simbolo.IGUAL + " "
							+ ControleCalculadora.ObterResultado());
				} else {
					ControleCalculadora.montaExpressao(key);
					System.out.println("Expressao: " + ControleCalculadora.getExpressao());
					textField_Texto.setText(ControleCalculadora.getExpressao());
				}

			} catch (Exception e) {
				textField_Texto.setText("ERRO: " + e.getMessage());
				// e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Caractere não aceito: " + key);
		}
	}

	private void trataEventoTecla(KeyEvent e, String key) {
		Montando(key);
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// aguardando para tratar eventos ...

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// aguardando para tratar eventos ...

	}
}
