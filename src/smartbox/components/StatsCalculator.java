package smartbox.components;

import java.util.*;
import smartbox.*;
import smartbox.mvc.Utilities;

public class StatsCalculator extends Component implements App {

	private static final long serialVersionUID = 1L;
	
	public ICalculator arithmeticCalculator;

	public Double mean(List<Double> data) throws Exception {
		System.out.println("Calculator = :" + arithmeticCalculator );
		Double sum = 0.0;
		for(Double val: data) {
			sum = arithmeticCalculator.add(sum, val);
		}
		Double avg = arithmeticCalculator.div(sum, (double)data.size());
		return avg;
	}

	public void main() throws Exception {
        //System.out.println("entering main");
		List<Double> scores = new LinkedList<Double>();
		for(int i = 0; i < 100; i++) {
			scores.add((double)i);
		}
		Double avg = mean(scores);
		Utilities.inform("Average = " + avg);
	}

}
