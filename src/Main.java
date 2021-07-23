import java.util.Arrays;

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
          //handling custom input from the command line arguments
        } else if (args.length == 3) {
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
	
	private static void handleCommandLine(String[] args) {
		char opCode = args[0].charAt(0);
		double left = Double.parseDouble(args[1]);
		double right = Double.parseDouble(args[2]);
		
		double result = execute(opCode, left, right); 
		System.out.println("Custom input result: " + result); 
	}

}
