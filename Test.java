import java.security.AlgorithmConstraints;
import java.util.Scanner;
import java.lang.Math;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);
        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);
        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = "
                + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = "
                + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = "
                + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = "
                + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());
        Complex c3 = (Complex) c1.clone();
        System.out.println(c1 == c3);
        System.out.println(c3.getRealPart());
        System.out.println(c3.getImaginaryPart());
    }
}

class Complex implements Cloneable {
    private double real;
    private double imaginary;

    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public String getRealPart() {
        return String.valueOf(this.real);
    }

    public String getImaginaryPart() {
        return String.valueOf(this.imaginary);
    }

    public String add(Complex c2) {
        double newA = this.real + Double.parseDouble(c2.getRealPart());
        double newB = this.imaginary + Double.parseDouble(c2.getImaginaryPart());
        return newA + " + " + newB + "i";
    }

    public String subtract(Complex c2) {
        double newA = this.real - Double.parseDouble(c2.getRealPart());
        double newB = this.imaginary - Double.parseDouble(c2.getImaginaryPart());
        return newA + " + " + newB + "i";
    }

    public String multiply(Complex c2) {
        double newAC = this.real * Double.parseDouble(c2.getRealPart());
        double newBD = this.imaginary * Double.parseDouble(c2.getImaginaryPart());

        double newBC = this.imaginary * Double.parseDouble(c2.getRealPart());
        double newAD = this.real * Double.parseDouble(c2.getImaginaryPart());

        double left = newAC - newBD;
        double right = newBC + newAD;
        return left + " + " + right + "i";
    }

    public String divide(Complex c2) {
        double newAC = this.real * Double.parseDouble(c2.getRealPart());
        double newBD = this.imaginary * Double.parseDouble(c2.getImaginaryPart());

        double newBC = this.imaginary * Double.parseDouble(c2.getRealPart());
        double newAD = this.real * Double.parseDouble(c2.getImaginaryPart());

        double cSquared = Math.pow(Double.parseDouble(c2.getRealPart()), 2);
        double dSquared = Math.pow(Double.parseDouble(c2.getImaginaryPart()), 2);

        double left = (newAC + newBD) / (cSquared + dSquared);
        double right = (newBC - newAD) / (cSquared + dSquared);
        return left + " + " + right + "i";
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }

    public String abs() {
        double aSquared = Math.pow(this.real, 2);
        double bSquared = Math.pow(this.imaginary, 2);

        return String.valueOf(Math.sqrt(aSquared + bSquared));
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }
}
