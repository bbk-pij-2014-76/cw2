
 public class Fraction
 {
	private int numerator;
	private int denominator;

	public Fraction(int num, int denom)
	{
		 if (denom == 0)
		 {
			 System.out.println("Invalid fraction with denominator 0"); // this should use exceptions
			 return;
		 }
		 int gcd = myGcd(num, denom);
		 setNumerator(num / gcd);
		 setDenominator(denom / gcd);
     }

	@Override
	public String toString()
	{
		 String s1="";
		 if ( getDenominator() != 1 ) {
			s1 = "" + getNumerator() + '/' + getDenominator();
		 } else {
			s1 = "" + getNumerator();
		 }
		 return s1;
	 }

	public int getNumerator()
	{
		return numerator;
	}

	public void setNumerator(int num)
	{
		numerator = num;
	}

	public int getDenominator()
	{
		return denominator;
	}

	public void setDenominator(int num)
	{
		denominator = num;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fraction fraction = (Fraction) o;
		if (getDenominator() != fraction.getDenominator()) return false;
		if (getNumerator() != fraction.getNumerator()) return false;
		return true;
	}
	@Override
	public int hashCode()
	{
		int result = numerator;
		result = 31 * result + denominator;
		return result;
	}
	public Fraction multiply(Fraction other)
	{
		int num = this.numerator * other.getNumerator();
		int denom = this.denominator * other.getDenominator();
		return new Fraction(num, denom);
	}
	public Fraction negate(Fraction other)
	{
		this.numerator =this.numerator * -1;
		other.numerator= other.numerator * -1;
		int num = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
		int denom = this.denominator * other.getDenominator();
		return new Fraction(num, denom);
	}
	public Fraction abs (Fraction other)
	{
		int num;
		int denom;
		if (this.numerator < 0 )
		{
		this.numerator = this.numerator * -1;
		}
		num =this.numerator;
		denom =this.denominator;
		return new Fraction(num, denom);
	}
	public Fraction clear(Fraction other)
	{
		int num;
		int denom;
		this.numerator =0;
		this.denominator =1;
		num = this.numerator;
		denom= this.denominator;
		return new Fraction ( num,denom);
	}
   	public Fraction divide(Fraction other)
   	{
		int num = this.numerator * other.getDenominator();
		int denom = this.denominator * other.getNumerator();
		return new Fraction(num, denom);
	}
	public Fraction add(Fraction other)
	{
		int num = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
		int denom = this.denominator * other.getDenominator();
		return new Fraction(num, denom);
	}

	public Fraction subtract(Fraction other)
	{
		int num = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
		int denom = this.denominator * other.getDenominator();
		return new Fraction(num, denom);
	}
	public static Fraction multiply(Fraction first, Fraction second)
	{
		int num = first.getNumerator() * second.getNumerator();
		int denom = first.getDenominator() * second.getDenominator();
		return new Fraction(num, denom);
	}

	public static Fraction divide (Fraction first, Fraction second)
	{
		int num = first.getNumerator() * second.getDenominator();
		int denom = first.getDenominator() * second.getNumerator();
		return new Fraction(num, denom);
	}

	public static Fraction add(Fraction first, Fraction second)
	{
		int num = first.getNumerator() * second.getDenominator()+second.getNumerator() * first.getDenominator() ;
		int denom = first.getDenominator() * second.getDenominator();
		return new Fraction(num, denom);
	}

	public static Fraction subtract(Fraction first, Fraction second)
	{
		int num = first.getNumerator() * second.getDenominator()-second.getNumerator() * first.getDenominator() ;
		int denom = first.getDenominator() * second.getDenominator();
		return new Fraction(num, denom);
	}

	private int myGcd(int a, int b)
	{
		while (b != 0)
		{
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
    }
}
