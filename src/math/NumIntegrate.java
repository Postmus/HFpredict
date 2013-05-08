package math;

import java.lang.Math;

public class NumIntegrate {
	
	private static final double EPSILON = 1E-6;
		
	// Adaptive quadrature
	public static double adaptive(Function f, double a, double b) {
		double h = b - a;
        double c = (a + b) / 2.0;
        double d = (a + c) / 2.0;
        double e = (b + c) / 2.0;
        double Q1 = h/6  * (f.value(a) + 4*f.value(c) + f.value(b));
        double Q2 = h/12 * (f.value(a) + 4*f.value(d) + 2*f.value(c) + 4*f.value(e) + f.value(b));
        if (Math.abs(Q2 - Q1) <= EPSILON) {
        	return Q2 + (Q2 - Q1) / 15;
        } else {
        	return adaptive(f, a, c) + adaptive(f, c, b);
        }        
	}
	    	
}
