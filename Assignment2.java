import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Circle []c = new Circle[2]; /* Creates an array of 2 objects */
        Scanner input = new Scanner(System.in);
        /* This for loop will get user input of radius twice */
        for(int i = 0; i<2; i++){
            System.out.println("Enter a radius for circle " + (i+1) + ": ");
            double userInput = input.nextDouble(); /*Gets user input */
            c[i] = new Circle(userInput); /* Assigns radius value to the respective circle */
        }
        if(c[0].equals(c[1]))
            System.out.println("The 2 circles are equal. " + c[0].toString()); /*Since they're equal I can print either of the circle's circumference/area */
        else
            System.out.println("They are not equal. " + c[0].toString() + "\n" + c[1].toString()); /* Calls toString method and prints their values */

        input.close(); /* Closes the scanner */
     
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

