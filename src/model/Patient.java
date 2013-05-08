package model;

public class Patient {
	
	private int female, smoking, mi, proBNP, age;
	private double uae, chol, gluc, hsCRP, hsTnT, heartRate, bmi, cystaninC;
	private double[][] predRisk;
	
	public Patient() {
		female = 1;
		smoking = 1;
		mi = 0;
		age = 54;
		uae = 19.03;
		chol = 5.6;
		gluc = 4.5;
		hsCRP = 1.96;
		proBNP = 20;
		hsTnT = 2.5;
		heartRate = 64;
		bmi = 26.95312;
		cystaninC = 0.78;  
		predRisk = null;
	}
	
	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getSmoking() {
		return smoking;
	}
	
	public void setSmoking(int smoking) {
		this.smoking = smoking;
	}
	
	public int getMi() {
		return mi;
	}
	
	public void setMi(int mi) {
		this.mi = mi;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getUae() {
		return uae;
	}
	
	public void setUae(double uae) {
		this.uae = uae;
	}
	
	public double getChol() {
		return chol;
	}
	
	public void setChol(double chol) {
		this.chol = chol;
	}
	
	public double getGluc() {
		return gluc;
	}
	
	public void setGluc(double gluc) {
		this.gluc = gluc;
	}
	
	public double getHsCRP() {
		return hsCRP;
	}
	
	public void setHsCRP(double hsCRP) {
		this.hsCRP = hsCRP;
	}
	
	public int getProBNP() {
		return proBNP;
	}
	
	public void setProBNP(int proBNP) {
		this.proBNP = proBNP;
	}
	
	public double getHsTnT() {
		return hsTnT;
	}
	
	public void setHsTnT(double hsTnT) {
		this.hsTnT = hsTnT;
	}
	
	public double getHeartRate() {
		return heartRate;
	}
	
	public void setHeartRate(double heartRate) {
		this.heartRate = heartRate;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	public double getCystaninC() {
		return cystaninC;
	}
	
	public void setCystaninC(double cystaninC) {
		this.cystaninC = cystaninC;
	}
	
	public double[][] getPredRisk() {
		return predRisk;
	}

	public void setPredRisk(double[][] predRisk) {
		this.predRisk = predRisk;
	}
	
}
