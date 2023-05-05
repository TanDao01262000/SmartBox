package smartbox.components;

import smartbox.Component;

public class StackMachine extends Component implements CommandProcessor {


	public IStack myStack;

	@Override
	public String execute(String cmmd) throws Exception {
		String[] tokens = cmmd.split("\\s+");

		Double result = 0.0;
		String answer = "";

		switch (tokens[0].toLowerCase()) {
			case "add":
				result = myStack.top();
				myStack.pop();
				result += myStack.top();
				myStack.pop();
				myStack.push(result);
				answer = "done";
				break;
			case "mul":
				result = myStack.top();
				myStack.pop();
				result *= myStack.top();
				myStack.pop();
				myStack.push(result);
				answer = "done";
				break;
			case "div":
				result = myStack.top();
				myStack.pop();
				result /= myStack.top();
				myStack.pop();
				myStack.push(result);
				answer = "done";
				break;
			case "sub":
				result = myStack.top();
				myStack.pop();
				result -= myStack.top();
				myStack.pop();
				myStack.push(result);
				answer = "done";
				break;
			case "pop":
				myStack.pop();
				answer = "done";
				break;
			case "top":
				answer = "" + myStack.top();
				break;
			case "push":
				myStack.push(Double.valueOf(tokens[1]));
				answer = "done";
				break;
			default:
				throw new Exception("Unrecognized command: " + tokens[0]);
		}

		return answer;
	}
}
