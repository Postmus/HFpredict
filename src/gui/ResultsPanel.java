package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Patient;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

public class ResultsPanel extends JPanel {
	
	private Patient patient;
	private DefaultXYDataset dataHFpEF, dataHFrEF; 
	private XYPlot IncidenceCurveHFpEF, IncidenceCurveHFrEF;
	
	
	/**
	 * Create the panel.
	 */
	public ResultsPanel(Patient patient) {
		this.patient = patient;
						
		// HFpEF
		dataHFpEF = new DefaultXYDataset();
		JFreeChart chart = ChartFactory.createXYLineChart(null, "Time (years)", "Cumulative incidence", dataHFpEF, PlotOrientation.VERTICAL, false, false, false);
		chart.setBackgroundPaint(null);
		IncidenceCurveHFpEF = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) IncidenceCurveHFpEF.getRenderer();
		renderer.setBaseShapesVisible(true);
		renderer.setBaseShapesFilled(true);
		NumberAxis domainAxis = (NumberAxis) IncidenceCurveHFpEF.getDomainAxis();
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setLabelFont(new Font("TimesNewRoman", Font.PLAIN, 12));
		NumberAxis rangeAxisHFpEF = (NumberAxis) IncidenceCurveHFpEF.getRangeAxis();
		rangeAxisHFpEF.setLabelFont(new Font("TimesNewRoman", Font.PLAIN, 12));	
		ChartPanel HFpEF = new ChartPanel(chart);
		HFpEF.setBorder(BorderFactory.createTitledBorder("HFpEF"));
		
		// HFrEF
		dataHFrEF = new DefaultXYDataset();
		JFreeChart chart2 = ChartFactory.createXYLineChart(null, "Time (years)", "Cumulative incidence", dataHFrEF, PlotOrientation.VERTICAL, false, false, false);
		chart2.setBackgroundPaint(null);
		IncidenceCurveHFrEF = (XYPlot) chart2.getPlot();
		XYLineAndShapeRenderer renderer2 = (XYLineAndShapeRenderer) IncidenceCurveHFrEF.getRenderer();
		renderer2.setBaseShapesVisible(true);
		renderer2.setBaseShapesFilled(true);
		NumberAxis domainAxis2 = (NumberAxis) IncidenceCurveHFrEF.getDomainAxis();
		domainAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis2.setLabelFont(new Font("TimesNewRoman", Font.PLAIN, 12));
		NumberAxis rangeAxisHFrEF = (NumberAxis) IncidenceCurveHFrEF.getRangeAxis();
		rangeAxisHFrEF.setLabelFont(new Font("TimesNewRoman", Font.PLAIN, 12));
		ChartPanel HFrEF = new ChartPanel(chart2);
		HFrEF.setBorder(BorderFactory.createTitledBorder("HFrEF"));
		
		// Add both panels together
		setLayout(new GridLayout(0,2));
		add(HFpEF);
		add(HFrEF);
		setBorder(BorderFactory.createTitledBorder("10-year cumulative incidence functions"));
		updateDisplay();
	}
	
	private void setDataHFpEF() {
		double[][] predRisk = patient.getPredRisk();
		double[][] seriesHFpEF = {predRisk[0],predRisk[1]};
		dataHFpEF.addSeries("HFpEF",seriesHFpEF);
	}
	
	private void setDataHFrEF() {
		double[][] predRisk = patient.getPredRisk();
		double[][] seriesHFrEF = {predRisk[0],predRisk[2]};
		dataHFrEF.addSeries("HFrEF",seriesHFrEF);
	}
	
	public void updateDisplay() {
		setDataHFpEF();
		IncidenceCurveHFpEF.setDataset(dataHFpEF);
		setDataHFrEF();
		IncidenceCurveHFrEF.setDataset(dataHFrEF);
	}
	
}
