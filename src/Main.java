import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//values to traverse
		double[] leftVals = {100.0, 25.0, 225.0, 11.0};
        double[] rightVals = {50.0, 92.0, 17.0, 3.0};
        char[] ops = {'d', 'a', 's', 'm'};
        
     
        System.out.println(Arrays.toString(leftVals));
        System.out.println(Arrays.toString(rightVals));
        System.out.println("Calculator operation codes:\na : addition\ns : subtraction\nm : multiplication\nd : division");
        
        double[] results = new double[ops.length];
        for(int i =0; i < ops.length; i++) {
        	results[i] = execute(ops[i], leftVals[i], rightVals[i]);
        }
        
        
      
        if (args.length == 0) {
        	 //enhanced loop
            for(double result : results) {
            	System.out.println(result);
            }
         
        } else if(args.length == 1 && args[0].equals("interactive")) { // interactive mode if user typed interactive
        	executeInteractively();
        } else if (args.length == 3) {  //handling custom input from the command line arguments
        	handleCommandLine(args); 
        } else {
        	System.out.println("Please provide operation code and 2 numeric values");
        }       
	}  
	
	static double execute(char opCode, double left, double right) {
		double result; 
		switch(opCode) {
			case 'a':
				result = left + right;
				break;
			case 's': 
				result = left - right; 
				break; 
			case 'm': 
				result = left * right; 
				break; 
			case 'd': 
				result = left / right; 
				break; 
			default:
				System.out.println("Invalid operation code: " + opCode);
				result = 0.0; 
				break;
		}
		return result; 
	}
	
	static void executeInteractively() {
		System.out.println("Enter an operation and two numbers: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] inputArray = input.split(" ");
		performOperation(inputArray); 
	}
	
	private static void performOperation(String[] arr) {
		char opCode = getOpCode(arr[0]);
		double left = valueFromWord(arr[1]);
		double right = valueFromWord(arr[2]);
		
		double result = execute(opCode, left, right);
		System.out.println(result);
	}
	
	private static void handleCommandLine(String[] args) {
		
		char opCode = args[0].charAt(0);
		double left = Double.parseDouble(args[1]);
		double right = Double.parseDouble(args[2]);
		
		double result = execute(opCode, left, right); 
		System.out.println("Custom input result: " + result); 
	}
	
	//extracts the operation code from the command line
	public static char getOpCode (String args) {
		char opCode = args.charAt(0); 
		return opCode; 
	}
	//translates the command line input to the double
	public static double valueFromWord(String args) {
		String [] words = {
				"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" 
		};
		double value = 0;
		for (int i = 0; i < words.length; index++) {
			if(args.equals(words[i])) {
				if(i < 10) {
					value = i; 
					break;
				} else {
					value = i - 10; 
					break;
				}
			}
		}
		
		return value; 
	}
}
