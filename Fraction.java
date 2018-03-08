// Solution to Project 6.3
// Represents fractions and fraction arithmetic

public class Fraction {

   private int numer, denom;

   public Fraction(){
      this(1, 1);
   }

   public Fraction(int n, int d){
      numer = n;
      denom = d;
   }

   public int numerator(){
      return numer;
   }

   public int denominator(){
      return denom;
   }

   public String toString(){
      return numer + "/" + denom;
   }

   public Fraction add(Fraction other){
      int n = numer * other.denom + other.numer * denom;
      int d = denom * other.denom;
      return new Fraction(n, d);
   }

   public Fraction sub(Fraction other){
      int n = numer * other.denom - other.numer * denom;
      int d = denom * other.denom;
      return new Fraction(n, d);
   }

   public Fraction mul(Fraction other){
      int n = numer * other.numer;
      int d = denom * other.denom;
      return new Fraction(n, d);
   }

   public Fraction div(Fraction other){
      int n = numer * other.denom;
      int d = denom * other.numer;
      return new Fraction(n, d);
   } 
}
