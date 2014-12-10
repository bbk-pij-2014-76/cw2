import java.util.Scanner;

public class FractionCalculatorTest {

		public static void evaluate ( Fraction fraction , String inputString ) {

				FractionCalculator calc = new FractionCalculator ();
				int finalOperatorIndex = 0;
				for (int i=0; i<inputString.length() ; i++ ) {
						if (inputString.charAt(i) == '+' || inputString.charAt(i) == '-' || inputString.charAt(i) == '*' ) {
									finalOperatorIndex = i;
						} else if ( inputString.charAt(i) == '/' ) {
									finalOperatorIndex = i-2;
						}
				}
				String finalOperator = inputString.substring (finalOperatorIndex-1,finalOperatorIndex);
				int num;
				int denom;
				String topFraction="";
				String bottomFraction="";
				String op = "";
				String [] fractionParts;
				fractionParts = inputString.split ("/");
				topFraction = fractionParts [0];
				bottomFraction = fractionParts [1];
				num = Integer.parseInt(topFraction.substring (0,1));
				denom = Integer.parseInt (bottomFraction.substring (0,1));
				Fraction valueInCalculator = new Fraction(num,denom);
				System.out.println ( " The first fraction was " + valueInCalculator.toString());
				op =calc.operatorFinder( bottomFraction );
				inputString = inputString.substring ( 6,inputString.length());

									do {
										fractionParts = inputString.split ("/");
										topFraction = fractionParts [0];
										bottomFraction = fractionParts [1];
										num = Integer.parseInt(topFraction.substring (0,1));
										denom = Integer.parseInt (bottomFraction.substring (0,1));
										Fraction newFraction = new Fraction(num,denom);
										valueInCalculator = calc.calculationExec (op,valueInCalculator,newFraction);
										inputString = inputString.substring (6,inputString.length());

									} 	while (inputString.length()>=6);


									 Fraction lastFraction = new Fraction (Integer.parseInt(inputString.substring(0,1)) , Integer.parseInt(inputString.substring(2,3)));
									 System.out.println ( " The last fraction was " + lastFraction.toString());
									 valueInCalculator = calc.calculationExec (finalOperator,valueInCalculator,lastFraction);
					 				 System.out.println (" The answer is " + valueInCalculator.toString() + " Good bye ");


		}
		public static void main ( String [] args ) {
							FractionCalculator calc = new FractionCalculator ();
							System.out.println(" Hi my name is Syed Maqsood Ali.Please enter an inputStringression mixture of fractions and operations: ");
							String inputString="";
							Scanner sc = new Scanner(System.in);
							inputString = sc.nextLine();
							int num;
							int denom;
							String topFraction="";
							String bottomFraction="";

							String [] fractionParts;
							fractionParts = inputString.split ("/");
							topFraction = fractionParts [0];
							bottomFraction = fractionParts [1];
							num = Integer.parseInt(topFraction.substring (0,1));
							denom = Integer.parseInt (bottomFraction.substring (0,1));
							Fraction valueInTheCalculator = new Fraction(num,denom);
							FractionCalculatorTest.evaluate(valueInTheCalculator,inputString);


		}
}








