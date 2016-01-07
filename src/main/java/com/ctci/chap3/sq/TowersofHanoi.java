package com.ctci.chap3.sq;

public class TowersofHanoi {

	private int noOfDisks = 0;
	private String source;
	private String auxilary;
	private String dest;
	private StringBuilder solution = new StringBuilder();

	public TowersofHanoi(int noOfDisks, String sourcePole, String auxilaryPole, String destPole) {
		this.noOfDisks = noOfDisks;
		source = sourcePole;
		auxilary = auxilaryPole;
		dest = destPole;
	}

	public String solution() {
		towersofHanoi(noOfDisks, source, auxilary, dest);
		return solution.toString();
	}

	private void towersofHanoi(int n, String sourcePole, String auxilaryPole, String destPole) {

		if (n > 0) {
			towersofHanoi(n - 1, sourcePole, destPole, auxilaryPole);
			solution.append(sourcePole + "-" + destPole).append('*');
			towersofHanoi(n - 1, auxilaryPole, sourcePole, destPole);
		}
	}
}
