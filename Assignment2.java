import java.util.Scanner;

public class RodriguezNadine2 {
    public static void main(String[] args) {

    }
    static class Circle{
        private double radius;

        public double getRadius(){ /* Gets radius */
            return radius;
        }
        public void setRadius(double newRadius){ /* Sets radius */
            radius = newRadius;
        }
        public Circle(double radius){
            this.radius = radius;
        }
        public Circle(){
            radius = 1;
        }
        public double circumference(){
            return 2*Math.PI*radius;
        }
        public double area(){
            return Math.PI*radius*radius; /* or return Math.PI * Math.pow(radius,2); */
        }
        public String toString(){
            String ans = "Circle: " + radius;
            ans += "\nCircumference: " + circumference() + "\n" + "Area: "+ area() + "\n";
            return ans;
        }
        public boolean equals(Circle other){
            return this.radius == other.radius;
        }
    }
}

