package uk.ac.cam.kjh67.q55;

public class NewtonRaphsonRooting {
    public static double squareRoot(double x) throws NewtonRaphsonException{
        // EXCEPTIONS NEEDED:
        // negative x
        // f'(x) = 0

        if (x<0) { throw new NewtonRaphsonException("cannot square root a negative number"); }

        // keep iterating until we reach this precision level
        double precision = 1e-6;

        // initial guess
        double x_n = x/2;

        try {
            while (Math.abs(x - (Math.pow(x_n, 2))) > precision) {
                x_n = (x_n + (x / x_n)) / 2;

                // DIVISION BY 0 ONLY THROWS AN ARITHMETIC EXCEPTION FOR INTEGERS
                // NEED ALTERNATIVE CHECKS FOR DEALING WITH FLOATS, AS THEY CAN TAKE THE VALUE 'INFINITY'
                if (x_n == 0) { throw new ArithmeticException(); }
            }
        }

        // This block should never be needed, as x_n shouldn't be able to reach 0 because there is no subtraction in the
        // iterative formula
        catch (ArithmeticException e) {
            throw new NewtonRaphsonException("encountered division by 0");
        }
        return x_n;
    }

    public static void main(String[] args) {
        try {
            System.out.println(String.format("%.6f", squareRoot(4)));
        }
        catch (NewtonRaphsonException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
