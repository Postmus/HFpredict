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
			a = 13.044;
			b = 85.121;
		} else {
			a = 6.135;
			b = 88.520;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = 0.304*Math.log(patient.getUae()) + 0.079*patient.getGluc() - 0.178*Math.log(patient.getHsCRP()) + 
				0.304*Math.log(patient.getProBNP()) - 0.422*hsTnT_1 - 0.070*hsTnT_2 + 0.637*patient.getMi() + 0.092*patient.getBmi() +
				0.966*patient.getCystaninC() - 1.778*Math.log(patient.getCreatinine()); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
