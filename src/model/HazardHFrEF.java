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
			a = 5.738;
			b = 354.060;
		} else {
			a = 3.229;
			b = 1092.458;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = -0.859*patient.getFemale() + 0.159*patient.getChol() + 0.596*Math.log(patient.getProBNP()) - 0.180*hsTnT_1 + 0.371*hsTnT_2 + 0.010*patient.getHeartRate() + 0.677*patient.getSmoking() + 0.945*patient.getMi() + 0.086*patient.getBmi() - 0.516*patient.getCystaninC(); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
