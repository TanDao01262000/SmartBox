package smartbox.components;

import smartbox.Component;

public class MathMachine extends Component implements CommandProcessor {


	@Override
	public String execute(String cmmd) throws Exception {
		String[] tokens = cmmd.split("\\s+");
		Double[] args = new Double[tokens.length - 1];
		Double result = 0.0;
		for(int i = 1; i < tokens.length; i++) {
			args[i - 1] = Double.valueOf(tokens[i]);
		}
		switch (tokens[0].toLowerCase()) {
			case "add":
				for(int i = 0; i < args.length; i++) {
					result += args[i];
				}
				break;
			case "mul":
				result = 1.0;
				for(int i = 0; i < args.length; i++) {
					result *= args[i];
				}
				break;
			case "div":
				result = 1.0;
				for(int i = 0; i < args.length; i++) {
					result /= args[i];
				}
				break;
			case "sub":
				for(int i = 0; i < args.length; i++) {
					result -= args[i];
				}
				break;
			default:
				return "Unrecognized command: " + tokens[0];
		}

		return result.toString();
	}

}