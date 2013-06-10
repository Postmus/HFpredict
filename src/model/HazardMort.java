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
			a = 6.522;
			b = 93.212;
		} else {
			a = 5.643;
			b = 93.902;
		}
		
		if (patient.getHsTnT()<=2.5) {
			hsTnT_1 = 1;
			hsTnT_2 = 0;
		} else {
			hsTnT_1 = 0;
			hsTnT_2 = Math.log(patient.getHsTnT() - 2.5);
		}

		baseline = (a/b)*Math.pow((time/b),(a-1));
		xbeta = -0.441*patient.getFemale() + 0.136*Math.log(patient.getUae()) + 0.211*patient.getChol() + 0.039*patient.getGluc() + 0.153*patient.getHsCRP() - 0.229*patient.getTgl() + 
				0.170*Math.log(patient.getProBNP()) - 0.159*hsTnT_1 + 0.124*hsTnT_2 + 0.008*patient.getHeartRate() + 0.461*patient.getSmoking() + 0.345*patient.getMi() - 
				0.032*patient.getBmi() + 0.585*patient.getStroke() - 0.176*patient.getLdl() + 0.784*patient.getCystaninC() - 0.933*Math.log(patient.getCreatinine()) + 1.894*patient.getWhr(); 
		return baseline*Math.exp(xbeta);
		
	}	
	
}
