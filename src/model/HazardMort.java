package model;

import math.Function;

public class HazardMort implements Function {

	private Patient patient;
	private int stratum;
	
	public HazardMort(Patient patient, int stratum) {
		this.patient = patient;
		this.stratum = stratum;
	}
	
	// Implement the Function interface
	public double value(double time) {
		
		double a, b, baseline, xbeta;
		double hsTnT_1, hsTnT_2;
		
		if (stratum==1) {
			a = 6.856;
			b = 120.356;
		} else {
			a = 5.873;
			b = 127.105;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = -0.452*patient.getFemale() + 0.126*Math.log(patient.getUae()) + 0.048*patient.getGluc() + 0.151*Math.log(patient.getHsCRP()) + 0.167*Math.log(patient.getProBNP()) - 0.168*hsTnT_1 + 0.116*hsTnT_2 + 0.010*patient.getHeartRate() + 0.536*patient.getSmoking() + 0.330*patient.getMi() - 0.024*patient.getBmi() + 0.301*patient.getCystaninC(); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
