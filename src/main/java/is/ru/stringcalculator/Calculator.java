package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text) {
		if (text.equals("")) return 0;
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
}
