public class Assignment5 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1,4);
        Rational r2 = new Rational(1,2);

        // Operations: +, - , * , /
        Rational r3 = r1.plus(r2);
        Rational r4 = r1.minus(r2);
        Rational r5 = r1.times(r2);
        Rational r6 = r1.divideBy(r2);
        System.out.println("Plus: 1/4 + 1/2 ");
        System.out.println(r3);
        System.out.println("Minus: 1/4 - 1/2 ");
        System.out.println(r4);
        System.out.println("Times: 1/4 * 1/2 ");
        System.out.println(r5);
        System.out.println("Divide By: 1/4 / 1/2 ");
        System.out.println(r6);

//      Equals method
        Rational r7 = new Rational(1,6);
        Rational r8 = new Rational(1,6);
        Rational r12 = new Rational(-1,6);
        Rational r13 = new Rational(1,-6);
        Rational r14 = new Rational(2,12);
        boolean b1 = r7.equals(r8); // Is 1/6 == 1/6?
        boolean b2 = r7.equals(r1); // Is 1/6 == 1/4?
        boolean b3 = r12.equals(r13); // Is -1/6 == 1/-6?
        boolean b4 = r7.equals(r14); // Is 1/6 == 2/12?
        System.out.println("Is 1/6 == 1/6? ");
        System.out.println(b1);
        System.out.println("Is 1/6 == 1/4? ");
        System.out.println(b2);
        System.out.println("Is -1/6 == 1/-6? ");
        System.out.println(b3);
        System.out.println("Is 1/6 == 2/12? ");
        System.out.println(b4);
        System.out.println("\n");

//      Power Method
        Rational r9 = r1.pow(2);
        System.out.println("Power: 1/4^2: ");
        System.out.println(r9);

//      Reciprocal Method
        Rational r10 = r1.reciprocal();
        System.out.println("Reciprocal of 1/4");
        System.out.println(r10);

//      Exception Call
        try{
            Rational r11 = new Rational(1,0);
            System.out.println(r11);
        } catch (IllegalDenominatorException e) {
            System.out.println("Catching IllegalDenominatorException - it works");
        }
    }
}
class Rational {
    private int numerator, denominator;

    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    public Rational(int num, int den) {
        if (den == 0) {
            throw new IllegalDenominatorException("Denominator cannot be zero");
        }
        // If denominator is a negative number, this will make the numerator a negative number instead
        if (den < 0) {
            den = -den;
            num = -num;
        }
        numerator = num;
        denominator = den;
    }
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }
    public void setNumerator(int n) {
        this.numerator = n;
    }
    public void setDenominator(int d) {
        if (d == 0)
            throw new IllegalDenominatorException("Denominator cannot be zero");
        else
            this.denominator = d;
    }
    public String toString() {
        return numerator + "/" + denominator + "\n" + "This is it's decimal value: " + decimalValue() + "\n" ;
    }
    public double decimalValue() {
        return (double) numerator/denominator;
    }
    public boolean equals(Rational other) {
        return this.decimalValue() == other.decimalValue();
    }
    public Rational pow(int x) {
        if(x == 0) return new Rational(1,1); // Base Case
        return this.times(pow(x-1)); // Recursive call
    }
    public Rational reciprocal() {
        return new Rational (denominator, numerator);
    }
    public Rational plus(Rational x) {
        int numerator = (this.numerator * x.denominator) + (this.denominator * x.numerator);
        int denominator = this.denominator * x.denominator;
        return new Rational(numerator, denominator);
    }
    public Rational minus(Rational x) {
        int numerator = (this.numerator * x.denominator) - (this.denominator * x.numerator);
        int denominator = this.denominator * x.denominator;
        return new Rational(numerator, denominator);
    }
    public Rational times(Rational x) {
        return new Rational(this.numerator * x.numerator, this.denominator * x.denominator);
    }
    public Rational divideBy(Rational x) {
        return this.times(x.reciprocal());
    }
}
class IllegalDenominatorException extends RuntimeException {
    public IllegalDenominatorException(String s) {
        super(s);
    }
}
