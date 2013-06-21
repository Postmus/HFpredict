package model;

public class Patient {
	
	private int female, smoking, mi, stroke;
	private double uae, chol, gluc, hsCRP, hsTnT, heartRate, bmi, cystaninC, tgl, ldl, whr, creatinine, proBNP, age;
	private double[][] predRisk;
	
	public Patient() {
		female = 1;
		smoking = 0;
		mi = 0;
		proBNP = 20;
		age = 60;
		stroke = 0;
		uae = 19.1;
		chol = 5.6;
		gluc = 4.5;
		hsCRP = 1.3;
		hsTnT = 2.5;
		heartRate = 64;
		bmi = 25.6;
		cystaninC = 0.77;
		tgl = 1.15;
		ldl = 3.62;
		whr = 0.88;
		creatinine = 82;
		predRisk = null;
	}
	
	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public double getTgl() {
		return tgl;
	}

	public void setTgl(double tgl) {
		this.tgl = tgl;
	}

	public double getLdl() {
		return ldl;
	}

	public void setLdl(double ldl) {
		this.ldl = ldl;
	}

	public double getWhr() {
		return whr;
	}

	public void setWhr(double whr) {
		this.whr = whr;
	}

	public double getCreatinine() {
		return creatinine;
	}

	public void setCreatinine(double creatinine) {
		this.creatinine = creatinine;
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
	
	public double getAge() {
		return age;
	}
	
	public void setAge(double age) {
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
	
	public double getProBNP() {
		return proBNP;
	}
	
	public void setProBNP(double proBNP) {
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
