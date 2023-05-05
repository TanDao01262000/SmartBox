package smartbox.components;

import smartbox.*;

public class Stack extends Component implements IStack {

	private static final long serialVersionUID = 1L;
	
	//private java.util.Stack<Double> stack = new java.util.Stack<Double>();
	private java.util.Stack<Double> stack;

	public Stack() {
		super();
		// TODO Auto-generated constructor stub
		stack = new java.util.Stack<Double>();
	}

	public void push(Double num) {
		//System.out.print("start");
		stack.push(num);
		//System.out.println("end");
	}
	public void pop() {
		stack.pop();
	}
	public Double top() {
		return stack.peek();
	}
	public void clear() {
		stack.clear();
	}
	public Boolean isEmpty() {
		return stack.empty();
	}
}