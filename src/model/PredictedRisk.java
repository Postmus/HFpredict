package model;

import math.NumIntegrate;

public class PredictedRisk {
	
	// Set prediction window
	private static final int PRED_WIDTH = 10;
	private static final double PROB_UAE_LOW = 0.7559967;
		
	public static double[][] predictRisk(Patient patient) {
		IntegrandHFpEF integrandHFpEF_1 = new IntegrandHFpEF(patient,1);
		IntegrandHFpEF integrandHFpEF_2 = new IntegrandHFpEF(patient,2);
		IntegrandHFrEF integrandHFrEF_1 = new IntegrandHFrEF(patient,1);
		IntegrandHFrEF integrandHFrEF_2 = new IntegrandHFrEF(patient,2);
		double[] time = new double[PRED_WIDTH+1];
		double[] cumIncHFpEF = new double[PRED_WIDTH+1];
		double[] cumIncHFrEF = new double[PRED_WIDTH+1];
		
		for (int i = 0; i<=PRED_WIDTH; i++) {
			time[i] = patient.getAge() + i;
			cumIncHFpEF[i] = PROB_UAE_LOW*NumIntegrate.adaptive(integrandHFpEF_1, patient.getAge(), time[i]) + 
					(1-PROB_UAE_LOW)*NumIntegrate.adaptive(integrandHFpEF_2, patient.getAge(), time[i]);
			cumIncHFrEF[i] = PROB_UAE_LOW*NumIntegrate.adaptive(integrandHFrEF_1, patient.getAge(), time[i]) + 
					(1-PROB_UAE_LOW)*NumIntegrate.adaptive(integrandHFrEF_2, patient.getAge(), time[i]);
		}
		
		double[][] result = {time,cumIncHFpEF,cumIncHFrEF};
		return result;
	}
	
}
