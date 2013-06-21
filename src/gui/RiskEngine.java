package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
		Locale.setDefault(Locale.ENGLISH);
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
		setBounds(100, 100,1000, 600);
		this.setTitle("The PREVEND risk model for new onset heart failure with reduced and preserved ejection fraction v1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		patient = new Patient();
		predictRisk();
		
		// Create and configure MenuBar
		
		JMenuBar menuBar = new JMenuBar(); 
		JMenu helpMen = new JMenu("Help"); 
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new AboutActionListener());
		helpMen.add(aboutItem);
		menuBar.add(Box.createHorizontalGlue()); 
		menuBar.add(helpMen); 
		this.setJMenuBar(menuBar); 
		
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
	
	class AboutActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(RiskEngine.this,
					"PREVEND risk model v1.0 \n \n" +
					"Written by: \n" + 
					"Douwe Postmus \n" + 
					"Department of Epidemiology \n" +
					"University of Groningen \n" +
					"University Medical Center Groningen \n" +
					"The Netherlands \n \n" +
					"E-mail: d.postmus@umcg.nl \n \n",
					"About PREVEND risk model",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
