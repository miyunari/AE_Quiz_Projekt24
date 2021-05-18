package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class StartGUI extends JPanel {
	//Wird vorgeschrieben, warum weiss ich nicht
	private static final long serialVersionUID = -8938412778342920536L;
	
	private JLabel titleLabel;
	private JButton startButton;
	private JButton optionsButton;
	private JButton exitButton;
	
	public StartGUI() {
		this.titleLabel = new JLabel("Quiz Projekt24", SwingConstants.CENTER);
		this.startButton = new JButton("Start");
		this.optionsButton = new JButton("Einstellungen");
		this.exitButton = new JButton("Ende");
		
		createStartGUI();
	}
	
	private void createStartGUI() {
		setFonts();
		setFontColors();
		setComponentsTransparent();
		addComponents();
	}
	
	private void setFonts() {
		Font titleFont = new Font("Arial", Font.BOLD, 100);
		Font buttonFont = new Font("Arial", Font.PLAIN, 50);
		
		this.titleLabel.setFont(titleFont);
		this.startButton.setFont(buttonFont);
		this.optionsButton.setFont(buttonFont);
		this.exitButton.setFont(buttonFont);
	}
	
	private void setFontColors() {
		this.titleLabel.setForeground(Color.CYAN);
		this.startButton.setForeground(Color.CYAN);
		this.optionsButton.setForeground(Color.CYAN);
		this.exitButton.setForeground(Color.CYAN);
	}
	
	private void setComponentsTransparent() {
		this.setOpaque(false);
		
		this.startButton.setContentAreaFilled(false);
		this.startButton.setBackground(new Color(0,0,0,0));
		this.startButton.setBorder(null);
		this.startButton.setFocusPainted(false);
		
		this.optionsButton.setContentAreaFilled(false);
		this.optionsButton.setBackground(new Color(0,0,0,0));
		this.optionsButton.setBorder(null);
		this.optionsButton.setFocusPainted(false);
		
		this.exitButton.setContentAreaFilled(false);
		this.exitButton.setBackground(new Color(0,0,0,0));
		this.exitButton.setBorder(null);
		this.exitButton.setFocusPainted(false);
	}
	
	private void addComponents() {
		this.setLayout(new GridLayout(4, 1));
		this.add(this.titleLabel);
		this.add(this.startButton);
		this.add(this.optionsButton);
		this.add(this.exitButton);
	}
	
	public JButton getStartButton() {
		return this.startButton;
	}
	
	public JButton getOptionsButton() {
		return this.optionsButton;
	}
	
	public JButton getExitButton() {
		return this.exitButton;
	}
}