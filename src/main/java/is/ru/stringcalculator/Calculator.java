package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text) {
		if (text.equals("")) return 0;
		checkNegativeNumbers(text);
		text = excludeTallNumbers(text);
		return sum(text);
    }

    private static int sum(String text) {
    	text = text.replace("\n", ",");
    	String[] numbs = text.split(",");
		int total = 0;
		for(String n: numbs){
			int res = Integer.parseInt(n);
			total += res;
		}
		return total;
    }

    private static void checkNegativeNumbers(String text) {
    	if (text.contains("-")) {
    		text = text.replace("\n", ",");
    		String[] numbs = text.split(",");
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
					tick ++;
				}
			}
			throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
		}
    }

    private static String excludeTallNumbers(String text) {
    	text = text.replace("\n", ",");
    	String[] numbs = text.split(",");
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
