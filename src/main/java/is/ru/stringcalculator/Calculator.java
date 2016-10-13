package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text) {
		if (text.equals("")) return 0;
		checkNegativeNumbers(text);
		text = excludeTallNumbers(text);
		return sum(text);
    }

    private static String[] splitter(String text) {
    	String delimiter = ",";
    	if (text.length() > 1) {
    		if (text.substring(0,2).equals("//")){
    			delimiter = text.substring(2,3);
    			text = text.substring(4);
    		}
    	}
    	text = text.replace("\n", delimiter);
   		String[] numbs = text.split(delimiter);
   		return numbs;
    }

    private static int sum(String text) {
       	String[] numbs = splitter(text);
		int total = 0;
		for(String n: numbs){
			int res = Integer.parseInt(n);
			total += res;
		}
		return total;
    }

    private static void checkNegativeNumbers(String text) {
    	if (text.contains("-")) {
    		String[] numbs = splitter(text);
			StringBuilder negatives = new StringBuilder();
			int tick = 0;
			for(String n: numbs){
				int res = Integer.parseInt(n);
				if (res < 0) {
					if (tick == 0) {
						negatives.append(res);
					}
					else {
						negatives.append(",");
						negatives.append(res);
					}
					tick++;
				}
			}
			throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
		}
    }

    private static String excludeTallNumbers(String text) {
    	String[] numbs = splitter(text);
    	StringBuilder smallNumbers = new StringBuilder();
    	int tick = 0;
    	for(String n: numbs) {
    		int res = Integer.parseInt(n);
    		if (res <= 1000) {
    			if (tick == 0) {
					smallNumbers.append(res);
    			}
    			else {
    				smallNumbers.append(",");
    				smallNumbers.append(res);
    			}
    			tick ++;
    		}
    	}
    	return smallNumbers.toString();
    }
}
