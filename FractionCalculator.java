import java.util.ArrayList;
import java.util.Scanner;
public class FractionCalculator {

	public static String operatorFinder ( String expression)
	{	String operator ="";

		int i;
		for ( i=0 ; i<expression.length(); i++)
		{
			if (isOperator(expression.charAt(i)))
			{
				operator=expression.substring(i,i+1);
				break;
			}
			else
			{
			operator = "/";
			}
		}
		return operator;
	}
	public static boolean isOperator(char op)
	{
		if (op == '+' || op == '-'|| op == '*' || op == '/'|| op == 'c'|| op == 'n' || op == 'a')
		{
			return true;
		}

		return false;
	}

	public static boolean isOperand(char op)
	{
		String numbers = "0123456789.";
		int a = numbers.indexOf(op);
		return a >= 0;
	}
	public static int denominatorFinder ( String bottomFraction )
	{
		int denom=0;
		for ( int i=0 ; i<bottomFraction.length(); i++)
		{
			boolean denominator =FractionCalculator.isOperand(bottomFraction.charAt(i) );
			if  ( denominator )
			{
				denom = Integer.parseInt(bottomFraction.substring(i,i+1));
				break;
			}
		}
		return  denom;
	}
	public static int  numeratorFinder ( String topFraction )
	{
		int num=0;
		for ( int i=0 ; i<topFraction.length(); i++)
		{
			boolean numerator =FractionCalculator.isOperand(topFraction.charAt(i) );
			if  ( numerator )
			{
				num = Integer.parseInt(topFraction.substring(i,i+1));
				break;
			}
		}
		return  num;
	}
	public static int bottomIndex ( String bottomFraction )
	{
		int bottomIndex=0;
		for ( int i=0 ; i<bottomFraction.length(); i++)
		{
			if ( FractionCalculator.isOperand(bottomFraction.charAt(i)))
			{
				bottomIndex = i;
			}
		}
		return  bottomIndex;
	}
	Fraction calculationExec ( String op , Fraction f1 , Fraction f2 )
	{
		Fraction ans1 = new Fraction (0,1);
		switch ( op )

		{
			case "+" : ans1 = f1.add ( f2);
			break;
			case "-" : ans1 = f1.subtract ( f2);
			break;
			case "*" : ans1 = f1.multiply ( f2);
			break;
			case "/" : ans1 = f1.divide ( f2);
			break;
			case "c" : ans1 = (f1.clear (f2)).add(f2);
			break;
			case "a" : ans1 = (f1.abs (f2)).add(f2.abs(f2));
			break;
			case "n" : ans1 =f1.negate (f2);
			break;
		}
		return ans1;
	}

	public static void main(String[] args)
	{
		ArrayList<Fraction> finalFraction = new ArrayList<Fraction>();
		FractionCalculator calc = new FractionCalculator();
		System.out.println(" Hi my name is Syed Maqsood Ali.Please enter an expression mixture of fractions and operations: ");
		String exp="";
		String operatorSign="";
		Scanner sc = new Scanner(System.in);
		exp = sc.nextLine();
		while ( exp != "end") {
			String[] fractionParts;
			String[] fractionParts1;
			fractionParts1= exp.split(exp);
			for ( int i=0;i<exp.length();i++)
			{
				if (exp.charAt(i) == '+' || exp.charAt(i) == '-')
				{
					Fraction oldFraction = new Fraction ( 0,1 );
					finalFraction.add(oldFraction);
					break;
				}
				else if (exp.charAt(i) == '*')
				{
					Fraction oldFraction = new Fraction ( 1,1 );
					finalFraction.add (oldFraction);
					break;
				}

			}

			while ( exp.length()>=4)
			{
				operatorSign=FractionCalculator.operatorFinder(exp);
				int num=0;
				int denom=0;
				boolean op ;
				fractionParts=exp.split(operatorSign);
				num=numeratorFinder (fractionParts[0]);
				denom=denominatorFinder (fractionParts[1]);
				operatorSign = operatorFinder (fractionParts[1]);
				Fraction newFraction = new Fraction ( num , denom );
				newFraction = calc.calculationExec ( operatorSign , finalFraction.get(finalFraction.size()-1) , newFraction);
				finalFraction.add(newFraction);
				exp = exp.substring(  ( FractionCalculator.bottomIndex(fractionParts[1])+fractionParts[0].length()+1) , exp.length());
			}
			fractionParts = exp.split("/");
			int finalNum = 0;
			int finalDenom =0;
			finalNum = numeratorFinder ( fractionParts[0] );
			finalDenom = denominatorFinder ( fractionParts[1]);
			Fraction lastFraction = new Fraction ( finalNum, finalDenom);
			lastFraction = calc.calculationExec ( operatorSign , finalFraction.get(finalFraction.size()-1) , lastFraction);
			finalFraction.add(lastFraction);
			System.out.println (" The current value in the calculator is "+  finalFraction.get(finalFraction.size()-1).toString());
		sc.close();
		}
	 }
}

