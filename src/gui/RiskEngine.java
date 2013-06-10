package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Patient;
import model.PredictedRisk;

public class RiskEngine extends JFrame {
	
	private JPanel contentPane;
	private InputPanel inputPanel; 
	private ResultsPanel resultsPanel;
	private Patient patient;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiskEngine frame = new RiskEngine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RiskEngine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		this.setTitle("The PREVEND risk model for new onset heart failure with reduced and preserved ejection fraction v0.1");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		patient = new Patient();
		predictRisk();
		
		inputPanel = new InputPanel(this,patient);
		contentPane.add(inputPanel,BorderLayout.NORTH);
		resultsPanel = new ResultsPanel(patient);
		contentPane.add(resultsPanel,BorderLayout.CENTER);
		
	}
	
	private void predictRisk() {
		patient.setPredRisk(PredictedRisk.predictRisk(patient));
	}
	
	public void update() {
		patient.setPredRisk(PredictedRisk.predictRisk(patient));
		resultsPanel.updateDisplay();
	}

}
