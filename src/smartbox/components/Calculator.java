package smartbox.components;

import smartbox.*;

public class Calculator extends Component implements ICalculator {

	private static final long serialVersionUID = 1L;

	public Double add(Double x, Double y) {
		return x + y;
	}

	public Double mul(Double x, Double y) {
		return x * y;
	}

	public Double sub(Double x, Double y) {
		return x - y;
	}

	public Double div(Double x, Double y) {
		return x / y;
	}
}
