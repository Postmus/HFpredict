package gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSpinner.DefaultEditor;
import model.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InputPanel extends JPanel {
	
	private RiskEngine re;
	private Patient patient;
	private JComboBox comboBoxSex, comboBoxSmoking;
	private JLabel lblSex, lblSmoking, lblNtprobnp, lblAge;
	private JSpinner proBNPSpinner, ageSpinner;
		
	/**
	 * Create the panel.
	 */
	public InputPanel(RiskEngine re, Patient patient) {
		this.re = re;
		this.patient = patient;
		
		setBorder(new TitledBorder(null, "Patient characteristics", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		lblSex = new JLabel("Sex:");
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.insets = new Insets(5, 5, 5, 5);
		gbc_lblSex.anchor = GridBagConstraints.WEST;
		gbc_lblSex.gridx = 0;
		gbc_lblSex.gridy = 0;
		add(lblSex, gbc_lblSex);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		if (patient.getFemale()==0) {
			comboBoxSex.setSelectedItem("Male");
		} else {
			comboBoxSex.setSelectedItem("Female");
		}
		comboBoxSex.addActionListener(new SexActionListener());
		GridBagConstraints gbc_comboBoxSex = new GridBagConstraints();
		gbc_comboBoxSex.fill = GridBagConstraints.BOTH;
		gbc_comboBoxSex.insets = new Insets(5, 5, 5, 5);
		gbc_comboBoxSex.gridx = 1;
		gbc_comboBoxSex.gridy = 0;
		add(comboBoxSex, gbc_comboBoxSex);
		
		lblSmoking = new JLabel("Smoking:");
		GridBagConstraints gbc_lblSmoking = new GridBagConstraints();
		gbc_lblSmoking.anchor = GridBagConstraints.WEST;
		gbc_lblSmoking.insets = new Insets(5, 5, 5, 5);
		gbc_lblSmoking.gridx = 0;
		gbc_lblSmoking.gridy = 1;
		add(lblSmoking, gbc_lblSmoking);
		
		comboBoxSmoking = new JComboBox();
		comboBoxSmoking.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		if (patient.getSmoking()==0) {
			comboBoxSmoking.setSelectedItem("No");
		} else {
			comboBoxSmoking.setSelectedItem("Yes");
		}
		comboBoxSmoking.addActionListener(new SmokingActionListener());
		GridBagConstraints gbc_comboBoxSmoking = new GridBagConstraints();
		gbc_comboBoxSmoking.insets = new Insets(5, 5, 5, 5);
		gbc_comboBoxSmoking.fill = GridBagConstraints.BOTH;
		gbc_comboBoxSmoking.gridx = 1;
		gbc_comboBoxSmoking.gridy = 1;
		add(comboBoxSmoking, gbc_comboBoxSmoking);
		
		lblNtprobnp = new JLabel("NT-proBNP:");
		GridBagConstraints gbc_lblNtprobnp = new GridBagConstraints();
		gbc_lblNtprobnp.insets = new Insets(5, 5, 5, 5);
		gbc_lblNtprobnp.anchor = GridBagConstraints.WEST;
		gbc_lblNtprobnp.gridx = 0;
		gbc_lblNtprobnp.gridy = 2;
		add(lblNtprobnp, gbc_lblNtprobnp);
		
		proBNPSpinner = new JSpinner();
		proBNPSpinner.setModel(new SpinnerNumberModel(patient.getProBNP(), 10, 200, 1));
		JSpinner.DefaultEditor editor = (DefaultEditor) proBNPSpinner.getEditor(); 
		editor.getTextField().setHorizontalAlignment(JTextField.LEFT);
		proBNPSpinner.addChangeListener(new ProBNPChangeListener());
		GridBagConstraints gbc_proBNPSpinner = new GridBagConstraints();
		gbc_proBNPSpinner.insets = new Insets(5, 5, 5, 5);
		gbc_proBNPSpinner.fill = GridBagConstraints.BOTH;
		gbc_proBNPSpinner.gridx = 1;
		gbc_proBNPSpinner.gridy = 2;
		add(proBNPSpinner, gbc_proBNPSpinner);
		
		lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(5, 5, 5, 5);
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.gridx = 2;
		gbc_lblAge.gridy = 0;
		add(lblAge, gbc_lblAge);
		
		ageSpinner = new JSpinner();
		ageSpinner.setModel(new SpinnerNumberModel(patient.getAge(), 30, 90, 1));
		JSpinner.DefaultEditor editorAge = (DefaultEditor) ageSpinner.getEditor(); 
		editorAge.getTextField().setHorizontalAlignment(JTextField.LEFT);
		ageSpinner.addChangeListener(new AgeChangeListener());
		GridBagConstraints gbc_ageSpinner = new GridBagConstraints();
		gbc_ageSpinner.insets = new Insets(5, 5, 5, 5);
		gbc_ageSpinner.fill = GridBagConstraints.BOTH;
		gbc_ageSpinner.gridx = 3;
		gbc_ageSpinner.gridy = 0;
		add(ageSpinner, gbc_ageSpinner);

	}
	
	class SexActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBoxSex.getSelectedItem()=="Male") {
				patient.setFemale(0);
			} else {
				patient.setFemale(1);
			}
			re.update();
		}
	}
	
	class SmokingActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBoxSmoking.getSelectedItem()=="No") {
				patient.setSmoking(0);
			} else {
				patient.setSmoking(1);
			}
			re.update();
		}
	}
	
	class ProBNPChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setProBNP((Integer) proBNPSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class AgeChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setAge((Integer) ageSpinner.getModel().getValue());
			re.update();
		}
	}

}
