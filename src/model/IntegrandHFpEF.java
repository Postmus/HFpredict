package model;

import math.*;
import java.lang.Math;

public class IntegrandHFpEF implements Function {
	
	private Function hazardHFpEF, hazardHFrEF, hazardMort;
	private Patient patient;
	
	public IntegrandHFpEF(Patient patient, int stratum) {
		this.patient = patient;
		this.hazardHFpEF = new HazardHFpEF(patient,stratum);
		this.hazardHFrEF = new HazardHFrEF(patient,stratum);
		this.hazardMort = new HazardMort(patient,stratum);
	}
	
	// Implement the Function interface
		public double value(double time) {
			
			// Compute survival at time t given HF-free at time age
			double cumHazHFpEF = NumIntegrate.adaptive(hazardHFpEF, patient.getAge(), time);
			double cumHazHFrEF = NumIntegrate.adaptive(hazardHFrEF, patient.getAge(), time);
			double cumHazMort = NumIntegrate.adaptive(hazardMort, patient.getAge(), time);
			double sum = cumHazHFpEF + cumHazHFrEF + cumHazMort;
			double survival = Math.exp(-sum); 
			
			return survival*hazardHFpEF.value(time);
		}
	
}
