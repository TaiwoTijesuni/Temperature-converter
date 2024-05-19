package temperatureConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Temperatureconverter {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatureconverter window = new Temperatureconverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Temperatureconverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperature Converter");
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
		lblNewLabel.setBounds(131, 6, 187, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox txtFrom = new JComboBox();
		txtFrom.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		txtFrom.setSelectedIndex(0);
		txtFrom.setBounds(152, 98, 131, 28);
		frame.getContentPane().add(txtFrom);
		
		JComboBox txtTo = new JComboBox();
		txtTo.setModel(new DefaultComboBoxModel(new String[] {"Fahrenheit", "Celsius", "Kelvin"}));
		txtTo.setSelectedIndex(0);
		txtTo.setBounds(152, 138, 131, 28);
		frame.getContentPane().add(txtTo);
		
		textField = new JTextField();
		textField.setBounds(152, 47, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//import DecimalFormat
				DecimalFormat df = new DecimalFormat("#.####");
				
				//variable for the textField
				double amount = Double.parseDouble(textField.getText());
				
				double convert = 0.0;
				
				
				Object selectedFrom = txtFrom.getSelectedItem();
				Object selectedTo = txtTo.getSelectedItem();
				
				if(selectedFrom != null && selectedTo != null) {
					String fromTemp = selectedFrom.toString();
					String toTemp = selectedTo.toString();
					
					// Concatenating fromTemp and toTemp to form a single string
					String tempPair = fromTemp + toTemp;
					
					
					switch(tempPair) {
					//convert Celsius to Fahrenheit
					case "CelsiusFahrenheit":
						convert = (amount * 9/5) + 32 ;
						JOptionPane.showMessageDialog(null, convert + " °F");
						break;
						//convert Celsisus to Kelvin
					case "CelsiusKelvin":
						convert = amount + 273.15;
						JOptionPane.showMessageDialog(null, convert + " K");
						break;
					//convert Fahrenheit to Celsius
					case "FahrenheitCelsius":
						convert = (amount - 32) * 5/9;
						String formattedconvert = df.format(convert);
						JOptionPane.showMessageDialog(null, formattedconvert + " °C");
						break;
						//convert Fahrenheit to Kelvin
					case "FahrenheitKelvin":
						convert = (amount - 32) * 5/9 + 273.15;
						String formattedconvert1 = df.format(convert);
						JOptionPane.showMessageDialog(null, formattedconvert1 + " K");
						break;
                       //convert Kelvin to Celsius
					case "KelvinCelsius":
						convert = amount - 273.15;
						JOptionPane.showMessageDialog(null, convert + " °C");
						break;
						//convert Kelvin to Fahrenheit
					case "KelvinFahrenheit":
						convert = (amount - 273.15) * 9/5 + 32;
						JOptionPane.showMessageDialog(null, convert + " °F");
						break;
	
					default:
						JOptionPane.showMessageDialog(null, "Error","Input Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				}
				}
				
				
			}
	);
		convert.setForeground(Color.ORANGE);
		convert.setFont(new Font("Helvetica", Font.PLAIN, 14));
		convert.setBackground(Color.WHITE);
		convert.setBounds(6, 202, 117, 34);
		frame.getContentPane().add(convert);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClear.setForeground(Color.MAGENTA);
		btnClear.setFont(new Font("Helvetica", Font.PLAIN, 14));
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(166, 202, 117, 34);
		frame.getContentPane().add(btnClear);
		
		JButton convert_1_1 = new JButton("Exit");
		convert_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(convert_1_1,"Confirm if you want to exit", "Temperature Converter",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		convert_1_1.setForeground(Color.RED);
		convert_1_1.setFont(new Font("Helvetica", Font.PLAIN, 14));
		convert_1_1.setBackground(Color.WHITE);
		convert_1_1.setBounds(327, 202, 117, 34);
		frame.getContentPane().add(convert_1_1);
	}
}
