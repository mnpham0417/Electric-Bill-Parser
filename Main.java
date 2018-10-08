import java.util.Scanner;
public class Main {
	
		
	 public static void main(String[] args) {
		
	    	Scanner reader = new Scanner(System.in);  // Reading from System.in
		 // System.out.println("Bank name: ");
	    String bankname = reader.nextLine();
	    System.out.println("Text: ");
	    String text = reader.nextLine();
	    
	    Parser parser = new Parser(text, bankname);
	    if(!parser.isElectricText()) { //First layer clean-up
	    		System.out.println("Not electric bill text");
	    }
	    else {
	    		parser.clean_up(); //Second layer clean-up
	    		parser.reduce_price_str(); //Third layer clean-up
	    		System.out.printf("Electric bill is: %d", parser.convert_int());
	    }
	    	

	    }
}
