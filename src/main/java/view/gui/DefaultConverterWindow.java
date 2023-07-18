package view.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.math.BigDecimal;

import java.awt.BorderLayout;
import controller.Controller;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class DefaultConverterWindow extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentConverterPanel = new JPanel();
	protected Controller controller;
	protected JTextField textFieldCuantityInput;
	protected String[] optionStrings = {" "};
	protected JPanel principalMenuPanel;
	protected JLabel lblCuantity;
	public Controller getController() {
		return controller;
	}

	


	protected JLabel lblFrom;
	protected JComboBox<String> comboBoxFrom;
	protected JLabel lblTo;
	protected JComboBox<String> comboBoxTo;
	protected JButton btnConvert;
	protected JLabel lblCuantityDescription;
	protected JLabel lblCuantityResult;
	protected JPanel principalContentPanel;
	protected JLabel lblConverterTitle;
	
	/**
	 * Create the panel.
	 */
	public DefaultConverterWindow() {
		buildComponents();

	}

	private void buildComponents() {
		
		setLayout(null);
	
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		add(contentConverterPanel);
		contentConverterPanel.setLayout(null);
		contentConverterPanel.setBounds(0,0,816,401);
		
		principalMenuPanel = new JPanel();
		principalMenuPanel.setBounds(0, 0, 816, 401);
		contentConverterPanel.add(principalMenuPanel);
		principalMenuPanel.setLayout(new BorderLayout(0, 0));
		
		principalContentPanel = new JPanel();
		principalContentPanel.setBackground(new Color(35, 41, 70));
		principalMenuPanel.add(principalContentPanel, BorderLayout.CENTER);
		principalContentPanel.setLayout(null);
		
		lblConverterTitle = new JLabel("  ");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		lblConverterTitle.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblConverterTitle.setBounds(182, 46, 236, 36);
		principalContentPanel.add(lblConverterTitle);
		
		textFieldCuantityInput = new JTextField();
		textFieldCuantityInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char keyChar = e.getKeyChar();
				if(Character.isLetter(keyChar)) {
					JOptionPane.showMessageDialog(null,"Please enter a number","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textFieldCuantityInput.setBounds(93, 141, 129, 20);
		principalContentPanel.add(textFieldCuantityInput);
		textFieldCuantityInput.setColumns(10);
		
		lblCuantity = new JLabel("Cuantity:");
		lblCuantity.setForeground(new Color(255, 255, 254));
		lblCuantity.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantity.setBounds(93, 110, 83, 20);
		principalContentPanel.add(lblCuantity);
		
		lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblFrom.setBounds(93, 172, 83, 20);
		principalContentPanel.add(lblFrom);
		
		comboBoxFrom = new JComboBox<>(optionStrings);
		comboBoxFrom.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxFrom.setBounds(93, 203, 129, 22);
		principalContentPanel.add(comboBoxFrom);
		
		lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(255, 255, 254));
		lblTo.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblTo.setBounds(256, 172, 83, 20);
		principalContentPanel.add(lblTo);
		
		comboBoxTo = new JComboBox<>(optionStrings);
		comboBoxTo.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxTo.setBounds(256, 203, 129, 22);
		principalContentPanel.add(comboBoxTo);
		
		btnConvert = new JButton("Convert");
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		btnConvert.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConvert.setBounds(414, 322, 89, 23);
		principalContentPanel.add(btnConvert);
		
		lblCuantityDescription = new JLabel("  ");
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblCuantityDescription.setBounds(93, 266, 292, 19);
		principalContentPanel.add(lblCuantityDescription);
		
		lblCuantityResult = new JLabel("  ");
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantityResult.setBounds(93, 282, 292, 43);
		principalContentPanel.add(lblCuantityResult);
	}

	public Boolean noErrorMessages() {
		if(textFieldCuantityInput.getText().length()<= 0) {
			JOptionPane.showMessageDialog(null,"Type a number input","Error",JOptionPane.ERROR_MESSAGE);
			return false;
			
			
		}else if(comboBoxFrom.getSelectedItem().equals(optionStrings[0]) || comboBoxTo.getSelectedItem().equals(optionStrings[0])) {
			JOptionPane.showMessageDialog(null,"Select a 'From' and 'To' option","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	

	protected abstract String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString);
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JTextField getTextFieldCuantityInput() {
		return textFieldCuantityInput;
	}

	public void setTextFieldCuantityInput(JTextField textFieldCuantityInput) {
		this.textFieldCuantityInput = textFieldCuantityInput;
	}

	public String[] getOptionStrings() {
		return optionStrings;
	}

	public void setOptionStrings(String[] optionStrings) {
		this.optionStrings = optionStrings;
	}

	public JLabel getLblCuantity() {
		return lblCuantity;
	}

	public void setLblCuantity(JLabel lblCuantity) {
		this.lblCuantity = lblCuantity;
	}

}