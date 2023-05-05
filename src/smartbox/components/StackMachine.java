package smartbox.components;

import smartbox.*;

public class StackMachine extends Component implements CommandProcessor {

	private static final long serialVersionUID = 1L;
	
	public IStack myStack;

	@Override
	public String execute(String cmmd) throws Exception {
		String[] tokens = cmmd.split("\\s+");
				
		Double result = 0.0;
		String answer = "";
		
		if (tokens[0].equalsIgnoreCase("add")) {
			result = myStack.top();
			myStack.pop();
			result += myStack.top();
			myStack.pop();
			myStack.push(result);
			answer = "done";
		} else if (tokens[0].equalsIgnoreCase("mul")) {
			result = myStack.top();
			myStack.pop();
			result *= myStack.top();
			myStack.pop();
			myStack.push(result);
			answer = "done";
		}  else if (tokens[0].equalsIgnoreCase("div")) {
			result = myStack.top();
			myStack.pop();
			result /= myStack.top();
			myStack.pop();
			myStack.push(result);
			answer = "done";
		} else if (tokens[0].equalsIgnoreCase("sub")) {
			result = myStack.top();
			myStack.pop();
			result -= myStack.top();
			myStack.pop();
			myStack.push(result);
			answer = "done";
		} else if (tokens[0].equalsIgnoreCase("pop")) {
			myStack.pop();
			answer = "done";
		} else if (tokens[0].equalsIgnoreCase("top")) {
			answer = "" + myStack.top();
		} else if (tokens[0].equalsIgnoreCase("push")) {
			//System.out.println("stack" +Double.valueOf(tokens[1]));
			myStack.push(Double.valueOf(tokens[1]));
			//System.out.println("finish");
			answer = "done";
		}
		else {
			throw new Exception("Unrecognized command: " + tokens[0]);
		}
		System.out.println("stackMachine");
		return answer;
	}
}
