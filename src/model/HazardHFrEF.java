package model;

import math.Function;

public class HazardHFrEF implements Function {

	private Patient patient;
	private int stratum;
	
	public HazardHFrEF(Patient patient, int stratum) {
		this.patient = patient;
		this.stratum = stratum;
	}
	
	// Implement the Function interface
	public double value(double time) {
		
		double a, b, baseline, xbeta;
		double hsTnT_1, hsTnT_2;
		
		if (stratum==1) {
			a = 5.365;
			b = 223.214;
		} else {
			a = 2.973;
			b = 490.346;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = -0.702*patient.getFemale() + 0.170*patient.getChol() + 0.604*Math.log(patient.getProBNP()) - 0.162*hsTnT_1 + 0.399*hsTnT_2 + 
				0.595*patient.getSmoking() + 0.912*patient.getMi() + 0.067*patient.getBmi() - 1.046*Math.log(patient.getCreatinine()) + 2.429*patient.getWhr(); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
