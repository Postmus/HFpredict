package model;

import math.Function;

public class HazardHFpEF implements Function {

	private Patient patient;
	private int stratum;
	
	public HazardHFpEF(Patient patient, int stratum) {
		this.patient = patient;
		this.stratum = stratum;
	}
	
	// Implement the Function interface
	public double value(double time) {
		
		double a, b, baseline, xbeta;
		double hsTnT_1, hsTnT_2;
		
		if (stratum==1) {
			a = 13.299;
			b = 142.913;
		} else {
			a = 6.099;
			b = 275.706;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = 0.243*Math.log(patient.getUae()) + 0.078*patient.getGluc() + 0.319*Math.log(patient.getProBNP()) - 0.383*hsTnT_1 - 0.114*hsTnT_2 + 0.561*patient.getMi() + 0.090*patient.getBmi(); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
