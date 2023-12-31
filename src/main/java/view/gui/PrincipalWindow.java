package view.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.Cursor;

/**
 * Class for the principal window, where the application runs
 * 
 * @author Ethan Damian Sanchez
 * @version 1.0
 */
public class PrincipalWindow extends JFrame implements MouseListener {


	private static final long serialVersionUID = 1L;
	
	private Font fontUnderlined;
	private JPanel contentPane;
	private Controller controller;
	private JPanel principalPanel;
	private JPanel northPanel;
	private JPanel optionsPanel;
	private JPanel convertersPanel;
	private JLabel lblCurrencyOption;
	private JLabel lblTemperatureOption;
	private JLabel lblWeightOption;
	private JLabel lblMeasureOption;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel contenCenterPanel;
	private JLabel lblImage_1;
	private JLabel lblNewLabel_8;
	private JLabel lblHomeOption;
	private JLabel lblLogo;
	private CurrencyWindow currencyWindow;
	private TemperatureWindow temperatureWindow;
	private WeightWindow weightWindow;
	private MeasureWindow measureWindow;
	private static InputStream inputStream;

	/**
	 * Constructor method that calls buildComponents()
	 */
	public PrincipalWindow() {
		buildComponents();

	}

	/**
	 * It creates all the components for the window
	 */
	private void buildComponents() {
		

		

		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 532);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(35, 41, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		principalPanel = new JPanel();
		contentPane.add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));

		northPanel = new JPanel();
		northPanel.setBackground(new Color(184, 193, 236));
		principalPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));

		optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(184, 193, 236));
		northPanel.add(optionsPanel, BorderLayout.EAST);
		optionsPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setFont(createFont(12));
		optionsPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("    ");
		lblNewLabel_2.setBackground(new Color(35, 41, 70));
		lblNewLabel_2.setForeground(new Color(35, 41, 70));
		optionsPanel.add(lblNewLabel_2, BorderLayout.SOUTH);

		JLabel lblNewLabel_3 = new JLabel("   ");
		optionsPanel.add(lblNewLabel_3, BorderLayout.EAST);

		convertersPanel = new JPanel();
		convertersPanel.setForeground(new Color(35, 41, 70));
		optionsPanel.add(convertersPanel, BorderLayout.CENTER);
		convertersPanel.setLayout(new GridLayout(0, 5, 12, 0));
		convertersPanel.setOpaque(false);

		lblHomeOption = new JLabel("Home");
		lblHomeOption.setForeground(new Color(40, 50, 81));
		lblHomeOption.setFont(createFont(13));
		lblHomeOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertersPanel.add(lblHomeOption);
		lblHomeOption.addMouseListener(this);
		setUnderline(lblHomeOption, true);

		lblCurrencyOption = new JLabel("Currency");
		lblCurrencyOption.setForeground(new Color(40, 50, 81));
		lblCurrencyOption.setFont(createFont(13));
		lblCurrencyOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertersPanel.add(lblCurrencyOption);
		lblCurrencyOption.addMouseListener(this);

		lblTemperatureOption = new JLabel("Temperature");
		lblTemperatureOption.setForeground(new Color(40, 50, 81));
		lblTemperatureOption.setFont(createFont(13));
		lblTemperatureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertersPanel.add(lblTemperatureOption);
		lblTemperatureOption.addMouseListener(this);

		lblWeightOption = new JLabel("Weight");
		lblWeightOption.setForeground(new Color(40, 50, 81));
		lblWeightOption.setFont(createFont(13));
		lblWeightOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertersPanel.add(lblWeightOption);
		lblWeightOption.addMouseListener(this);

		lblMeasureOption = new JLabel("Measure");
		lblMeasureOption.setForeground(new Color(40, 50, 81));
		lblMeasureOption.setFont(createFont(13));
		lblMeasureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertersPanel.add(lblMeasureOption);
		lblMeasureOption.addMouseListener(this);

		JPanel panelLogo = new JPanel();
		northPanel.add(panelLogo, BorderLayout.CENTER);
		panelLogo.setLayout(null);
		panelLogo.setOpaque(false);

		lblLogo = new JLabel("   ");
		lblLogo.setBackground(new Color(35, 41, 70));
		lblLogo.setBounds(31, 8, 19, 27);
		panelLogo.add(lblLogo);
		lblLogo.setOpaque(false);
		lblLogo.setIcon(new ImagePanel().paintComponent(lblLogo, "/Vector.png"));

		southPanel = new JPanel();
		southPanel.setBackground(new Color(184, 193, 236));
		principalPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("     ");
		southPanel.add(lblNewLabel_4, BorderLayout.NORTH);

		JLabel lblNewLabel_5 = new JLabel("   ");
		southPanel.add(lblNewLabel_5, BorderLayout.SOUTH);

		JLabel lblNewLabel_6 = new JLabel("Created by Ethan Sanchez");
		lblNewLabel_6.setForeground(new Color(35, 41, 70));
		lblNewLabel_6.setFont(createFont(13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		southPanel.add(lblNewLabel_6, BorderLayout.CENTER);

		centerPanel = new JPanel();
		centerPanel.setForeground(new Color(0, 0, 0));
		principalPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);

		contenCenterPanel = new JPanel();
		contenCenterPanel.setBackground(new Color(56, 69, 114));
		contenCenterPanel.setBounds(0, 0, 816, 401);
		centerPanel.add(contenCenterPanel);
		contenCenterPanel.setLayout(null);

		lblImage_1 = new JLabel("   ");
		lblImage_1.setBounds(277, 10, 285, 343);
		lblImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		contenCenterPanel.add(lblImage_1);
		// setImageLabel(lblImage_1,"/icons/sukuna-chibi.png");
		lblImage_1.setIcon(new ImagePanel().paintComponent(lblImage_1, "/megumi-chibi.png"));

		lblNewLabel_8 = new JLabel("No converter option selected");
		lblNewLabel_8.setForeground(new Color(255, 255, 254));
		lblNewLabel_8.setBounds(250, 346, 301, 26);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(createFont(22));
		contenCenterPanel.add(lblNewLabel_8);

	}
	
	/**
	 * Creates the font that it is used in all the project.
	 * @param fontsize The font size  
	 * @return The Roboto Condesed Bold font 
	 */
	public static Font createFont(float fontsize) {
		Font robotoCondesedBoldFont = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream("src/main/resources/fonts/RobotoCondensed-Bold.ttf")); 
				
			robotoCondesedBoldFont = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontsize);
			
		} catch (IOException |FontFormatException e ) {
			e.printStackTrace();
			
		}
		return robotoCondesedBoldFont;
	}

	/**
	 * Underlines a JLabel text depending if it is called with a 'true' parameter
	 * 
	 * @param labelAsButton The JLabel that is going to be underlined
	 * @param underlineOnOf true if wants the JLabel text underlined, false if don't
	 *                      want it underlined
	 */
	private void setUnderline(JLabel labelAsButton, Boolean underlineOnOf) {
		fontUnderlined = labelAsButton.getFont();
		Map attribute = fontUnderlined.getAttributes();
		if (underlineOnOf) {
			attribute.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		} else {
			attribute.put(TextAttribute.UNDERLINE, -1);
		}

		labelAsButton.setFont(fontUnderlined.deriveFont(attribute));
	}

	/**
	 * This method is used when the user click a converter option, and the label
	 * text of that option underlines
	 * and is colored with a specific color, the other label text options get no
	 * underline and a default color
	 * 
	 * @param array            The JLabel array that has all the converters options
	 * @param label            The label that wants to get
	 * @param colorInSelection
	 */
	private void setNoUnderlineDeaultfColorJlabelsInArray(JLabel[] array, JLabel label, Color colorInSelection) {

		for (int i = 0; i < array.length; i++) {
			setUnderline(array[i], false);
			array[i].setForeground(new Color(40, 50, 81));
		}

		setUnderline(label, true);
		label.setForeground(colorInSelection);
	}

	/**
	 * This method is called when the user change the window converter, all values
	 * that the input options had,
	 * are restored
	 * 
	 * @param windowsArray The array that has all the converters windows
	 */
	private void setNullInputsInWindowsConverters(DefaultConverterWindow[] windowsArray) {
		for (int i = 0; i < windowsArray.length; i++) {
			windowsArray[i].getTextAreaLeftContent().setText("");
			windowsArray[i].getTextFieldCuantityInput().setText("");
			windowsArray[i].getComboBoxFrom().setSelectedIndex(0);
			windowsArray[i].getComboBoxTo().setSelectedIndex(0);
			windowsArray[i].getLblCuantityDescription().setText("");
			windowsArray[i].getLblCuantityResult().setText("");
		}

	}

	/**
	 * Actions for mouse click event, used when the user click a converter option
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		DefaultConverterWindow[] converterWindowsArray = { currencyWindow, temperatureWindow, weightWindow,
				measureWindow };

		JLabel[] labelOptionsArrayJLabels = { lblHomeOption, lblCurrencyOption, lblTemperatureOption, lblWeightOption,
				lblMeasureOption };

		if (e.getSource() == lblHomeOption) {
			setTitle("Home");
			changeCenterPanel(contenCenterPanel);

			setNoUnderlineDeaultfColorJlabelsInArray(labelOptionsArrayJLabels, lblHomeOption, new Color(40, 50, 81));

			setNullInputsInWindowsConverters(converterWindowsArray);

		} else if (e.getSource() == lblCurrencyOption) {
			setTitle("Currency Converter");
			changeCenterPanel(currencyWindow);

			setNoUnderlineDeaultfColorJlabelsInArray(labelOptionsArrayJLabels, lblCurrencyOption,
					new Color(35, 41, 70));

			setNullInputsInWindowsConverters(converterWindowsArray);

		} else if (e.getSource() == lblTemperatureOption) {
			setTitle("Temperature Converter");
			changeCenterPanel(temperatureWindow);

			setNoUnderlineDeaultfColorJlabelsInArray(labelOptionsArrayJLabels, lblTemperatureOption,
					new Color(9, 64, 103));

			setNullInputsInWindowsConverters(converterWindowsArray);

		} else if (e.getSource() == lblWeightOption) {
			setTitle("Weight Converter");
			changeCenterPanel(weightWindow);

			setNoUnderlineDeaultfColorJlabelsInArray(labelOptionsArrayJLabels, lblWeightOption, new Color(56, 28, 104));

			setNullInputsInWindowsConverters(converterWindowsArray);

		} else if (e.getSource() == lblMeasureOption) {
			setTitle("Measure Converter");
			changeCenterPanel(measureWindow);

			setNoUnderlineDeaultfColorJlabelsInArray(labelOptionsArrayJLabels, lblMeasureOption, new Color(5, 88, 88));

			setNullInputsInWindowsConverters(converterWindowsArray);

		}

	}

	/**
	 * Actions when mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Actions when the mouse click is released
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Actions when the mouse enter in a component bounds, it works as a hover event
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblHomeOption || e.getSource() == lblCurrencyOption
				|| e.getSource() == lblTemperatureOption
				|| e.getSource() == lblWeightOption || e.getSource() == lblMeasureOption) {

			JLabel[] labelOptionsArrayJLabels = { lblHomeOption, lblCurrencyOption, lblTemperatureOption,
					lblWeightOption, lblMeasureOption };

			for (int i = 0; i < labelOptionsArrayJLabels.length; i++) {
				labelOptionsArrayJLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

		}

	}

	/**
	 * Actions when the mouse is out of a component bounds
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * It change the centerPanel when a converter option is selected
	 * 
	 * @param panel The panel that is going to be replaced in the centerPanel
	 */
	private void changeCenterPanel(JPanel panel) {
		panel.setSize(816, 401);
		panel.setLocation(0, 0);

		centerPanel.removeAll();
		centerPanel.add(panel, BorderLayout.CENTER);
		centerPanel.revalidate();
		centerPanel.repaint();
	}

	/**
	 * Setter for controller field
	 * 
	 * @param controller The new controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;

	}

	/**
	 * Setter for currency converter view
	 * 
	 * @param currencyWindow The new currencyWindow
	 */
	public void setCurrencyWindow(CurrencyWindow currencyWindow) {
		this.currencyWindow = currencyWindow;

	}

	/**
	 * Setter for temperature converter view
	 * 
	 * @param temperatureWindow The new temperatureWindow
	 */
	public void setTemperatureWindow(TemperatureWindow temperatureWindow) {
		this.temperatureWindow = temperatureWindow;

	}

	/**
	 * Setter for weight converter view
	 * 
	 * @param weightWindow The new weightWindow
	 */
	public void setWeightWindow(WeightWindow weightWindow) {
		this.weightWindow = weightWindow;

	}

	/**
	 * Setter for measure converter view
	 * 
	 * @param measureWindow The new measureWindow
	 */
	public void setMeasureWindow(MeasureWindow measureWindow) {
		this.measureWindow = measureWindow;

	}

}
