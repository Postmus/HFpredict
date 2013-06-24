package gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.JSpinner.DefaultEditor;
import model.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Locale;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InputPanel extends JPanel {
	
	private RiskEngine re;
	private Patient patient;
	private JComboBox comboBoxSex, comboBoxSmoking, comboBoxStroke, comboBoxMi;
	private JSpinner proBNPSpinner, ageSpinner, uaeSpinner, cholSpinner, glucSpinner, hsCRPSpinner, tglSpinner;
	private JSpinner hsTnTSpinner, heartRateSpinner, bmiSpinner, ldlSpinner, cystaninCSpinner, creatinineSpinner, whrSpinner;
		
	/**
	 * Create the panel.
	 */
	public InputPanel(RiskEngine re, Patient patient) {
		this.re = re;
		this.patient = patient;
		
		setBorder(new TitledBorder(null, "Patient characteristics", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		// Combo boxes for the categorical risk factors
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		if (patient.getFemale()==0) {
			comboBoxSex.setSelectedItem("Male");
		} else {
			comboBoxSex.setSelectedItem("Female");
		}
		comboBoxSex.addActionListener(new SexActionListener());
		add(new JLabel("Sex:"), InputPanel.gbcLabel(0,1));
		add(comboBoxSex, InputPanel.gbcSpinner(1,1));
				
		comboBoxSmoking = new JComboBox();
		comboBoxSmoking.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		if (patient.getSmoking()==0) {
			comboBoxSmoking.setSelectedItem("No");
		} else {
			comboBoxSmoking.setSelectedItem("Yes");
		}
		comboBoxSmoking.addActionListener(new SmokingActionListener());
		add(new JLabel("Smoking:"), InputPanel.gbcLabel(2,0));
		add(comboBoxSmoking, InputPanel.gbcSpinner(3,0));
		
		comboBoxStroke = new JComboBox();
		comboBoxStroke.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		if (patient.getStroke()==0) {
			comboBoxStroke.setSelectedItem("No");
		} else {
			comboBoxStroke.setSelectedItem("Yes");
		}
		comboBoxStroke.addActionListener(new StrokeActionListener());
		add(new JLabel("Stroke:"), InputPanel.gbcLabel(2,1));
		add(comboBoxStroke, InputPanel.gbcSpinner(3,1));
		
		comboBoxMi = new JComboBox();
		comboBoxMi.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		if (patient.getMi()==0) {
			comboBoxMi.setSelectedItem("No");
		} else {
			comboBoxMi.setSelectedItem("Yes");
		}
		comboBoxMi.addActionListener(new MiActionListener());
		add(new JLabel("Myocardial infarction:"), InputPanel.gbcLabel(2,2));
		add(comboBoxMi, InputPanel.gbcSpinner(3,2));
		
		// Spinners for the continuous risk factors
		
		ageSpinner = InputPanel.spinnerFactory(patient.getAge(),30, 90, 1);
		ageSpinner.addChangeListener(new AgeChangeListener());
		add(new JLabel("Age (years):"), InputPanel.gbcLabel(0, 0));
		add(ageSpinner, InputPanel.gbcSpinner(1,0));
		
		proBNPSpinner = InputPanel.spinnerFactory(patient.getProBNP(), 5, 63377, 1);
		proBNPSpinner.addChangeListener(new ProBNPChangeListener());
		add(new JLabel("NT-proBNP (ng/L):"), InputPanel.gbcLabel(0, 2));
		add(proBNPSpinner, InputPanel.gbcSpinner(1,2));
		
		cholSpinner = InputPanel.spinnerFactory(patient.getChol(), 2.2, 15.5, 0.1);
		cholSpinner.addChangeListener(new CholChangeListener());
		add(new JLabel("Cholesterol (mmol/L):"), InputPanel.gbcLabel(4, 0));
		add(cholSpinner, InputPanel.gbcSpinner(5,0));
		
		glucSpinner = InputPanel.spinnerFactory(patient.getGluc(), 2.5, 22.7, 0.1);
		glucSpinner.addChangeListener(new GlucChangeListener());
		add(new JLabel("Glucose (mmol/L):"), InputPanel.gbcLabel(4, 1));
		add(glucSpinner, InputPanel.gbcSpinner(5,1));
		
		uaeSpinner = InputPanel.spinnerFactory(patient.getUae(), 1, 4710, 1);
		uaeSpinner.addChangeListener(new UaeChangeListener());
		add(new JLabel("Urinary albumin excretion (mg/24H):"), InputPanel.gbcLabel(4, 2));
		add(uaeSpinner, InputPanel.gbcSpinner(5,2));
		
		hsCRPSpinner = InputPanel.spinnerFactory(patient.getHsCRP(), 0.2, 153, 0.1);
		hsCRPSpinner.addChangeListener(new HsCRPChangeListener());
		add(new JLabel("hs-CRP (mg/L):"), InputPanel.gbcLabel(6, 0));
		add(hsCRPSpinner, InputPanel.gbcSpinner(7,0));
		
		tglSpinner = InputPanel.spinnerFactory(patient.getTgl(), 0.05, 23.85, 0.05);
		tglSpinner.addChangeListener(new TglChangeListener());
		add(new JLabel("Triglycerides (mmol/L):"), InputPanel.gbcLabel(6, 1));
		add(tglSpinner, InputPanel.gbcSpinner(7,1));
		
		hsTnTSpinner = InputPanel.spinnerFactory(patient.getHsTnT(), 2.5, 2600, 1);
		hsTnTSpinner.addChangeListener(new HsTnTChangeListener());
		add(new JLabel("hs-TnT (ng/L):"), InputPanel.gbcLabel(6, 2));
		add(hsTnTSpinner, InputPanel.gbcSpinner(7,2));
		
		heartRateSpinner = InputPanel.spinnerFactory(patient.getHeartRate(), 30, 129, 1);
		heartRateSpinner.addChangeListener(new HeartRateChangeListener());
		add(new JLabel("Heart rate (bmp):"), InputPanel.gbcLabel(0, 3));
		add(heartRateSpinner, InputPanel.gbcSpinner(1,3));
		
		bmiSpinner = InputPanel.spinnerFactory(patient.getBmi(), 16.3, 59.6, 0.1);
		bmiSpinner.addChangeListener(new BmiChangeListener());
		add(new JLabel("Body mass index (kg/m^2):"), InputPanel.gbcLabel(2, 3));
		add(bmiSpinner, InputPanel.gbcSpinner(3,3));
		
		ldlSpinner = InputPanel.spinnerFactory(patient.getLdl(), 0.6, 11.55, 0.01);
		ldlSpinner.addChangeListener(new LdlChangeListener());
		add(new JLabel("Low-density lipoprotein (mmol/L):"), InputPanel.gbcLabel(4, 3));
		add(ldlSpinner, InputPanel.gbcSpinner(5,3));
		
		cystaninCSpinner = InputPanel.spinnerFactory(patient.getCystaninC(), 0.05, 6.15, 0.01);
		cystaninCSpinner.addChangeListener(new CystaninCChangeListener());
		add(new JLabel("Cystanin C (mg/dL):"), InputPanel.gbcLabel(6, 3));
		add(cystaninCSpinner, InputPanel.gbcSpinner(7,3));
		
		creatinineSpinner = InputPanel.spinnerFactory(patient.getCreatinine(), 25, 1043, 1);
		creatinineSpinner.addChangeListener(new CreatinineChangeListener());
		add(new JLabel("Creatinine (umol/L):"), InputPanel.gbcLabel(0, 4));
		add(creatinineSpinner, InputPanel.gbcSpinner(1,4));
		
		whrSpinner = InputPanel.spinnerFactory(patient.getWhr(), 0.27, 1.26, 0.01);
		whrSpinner.addChangeListener(new WhrChangeListener());
		add(new JLabel("Waist-hip ratio:"), InputPanel.gbcLabel(2, 4));
		add(whrSpinner, InputPanel.gbcSpinner(3,4));
		
	}
	
	// Spinner and gridBagConstraints factories
	
	private static JSpinner spinnerFactory(double current, double min, double max, double step) {
		JSpinner currentSpinner = new JSpinner();
		currentSpinner.setModel(new SpinnerNumberModel(current, min, max, step));  
		JSpinner.NumberEditor currentEditor = (NumberEditor) currentSpinner.getEditor();
		currentEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
		return currentSpinner;	
	}
	
	private static GridBagConstraints gbcSpinner(int x, int y) {
		GridBagConstraints gbc_Spinner = new GridBagConstraints();
		gbc_Spinner.insets = new Insets(5, 5, 5, 5);
		gbc_Spinner.fill = GridBagConstraints.BOTH;
		gbc_Spinner.gridx = x;
		gbc_Spinner.gridy = y;
		return gbc_Spinner;
	}
	
	private static GridBagConstraints gbcLabel(int x, int y) {
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.insets = new Insets(5, 5, 5, 5);
		gbc_lbl.anchor = GridBagConstraints.WEST;
		gbc_lbl.gridx = x;
		gbc_lbl.gridy = y;
		return gbc_lbl;
	}
	
	
	// Action listener classes for comboBoxes
	
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
	
	class StrokeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBoxStroke.getSelectedItem()=="No") {
				patient.setStroke(0);
			} else {
				patient.setStroke(1);
			}
			re.update();
		}
	}
	
	class MiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBoxMi.getSelectedItem()=="No") {
				patient.setMi(0);
			} else {
				patient.setMi(1);
			}
			re.update();
		}
	}
	
	// Change listener classes for JSpinners 
	
	class AgeChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setAge((Double) ageSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class ProBNPChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setProBNP((Double) proBNPSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class UaeChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setUae((Double) uaeSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class CholChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setChol((Double) cholSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class GlucChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setGluc((Double) glucSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class HsCRPChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setHsCRP((Double) hsCRPSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class TglChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setTgl((Double) tglSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class HsTnTChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setHsTnT((Double) hsTnTSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class HeartRateChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setHeartRate((Double) heartRateSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class BmiChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setBmi((Double) bmiSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class LdlChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setLdl((Double) ldlSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class CystaninCChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setCystaninC((Double) cystaninCSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class CreatinineChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setCreatinine((Double) creatinineSpinner.getModel().getValue());
			re.update();
		}
	}
	
	class WhrChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			patient.setWhr((Double) whrSpinner.getModel().getValue());
			re.update();
		}
	}

}
