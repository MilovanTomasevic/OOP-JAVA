package kalkulator;

public class Izraz {

	private double prviOperand;
	private double drugiOperand;
	private char operacija;
	
	public Izraz(double prviOperand, double drugiOperand, char operacija) {
		this.prviOperand = prviOperand;
		this.drugiOperand = drugiOperand;
		this.operacija = operacija;
	}

	public double getPrviOperand() {
		return prviOperand;
	}

	public double getDrugiOperand() {
		return drugiOperand;
	}

	public char getOperacija() {
		return operacija;
	}
	
	public double rezultatIzraza() {
		
		switch(operacija) {
		
		case '+':
			return prviOperand + drugiOperand;
		case '-':
			return prviOperand - drugiOperand;
		case '*':
			return prviOperand * drugiOperand;
		case '/':
			return prviOperand / drugiOperand;
		case '\u221A':
			return Math.sqrt(prviOperand);
		default:
			return Double.NEGATIVE_INFINITY;
		}
	}

	public String toString() {
		return prviOperand + " " + operacija + " " + drugiOperand;
	}
	
	
}
