
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
}
