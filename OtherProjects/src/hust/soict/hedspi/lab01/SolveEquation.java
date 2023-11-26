package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class SolveEquation {
    public static void firstDegreeEquation(double a, double b) {
        if(a == 0) 
            if(b == 0) 
                System.out.println("Infinite solutions");
            else System.out.println("No solution");
        else {
            double x = -b / a;
            System.out.println("Solution x = " + x);
        }
    }
    
    public static void systemDegreeEquation(double a11, double a12,double a21, double a22,double b1, double b2) {
        double det = a11 * a22 - a12 * a21;
        if(det == 0) {
            if(b1 == 0 && b2 == 0) {
                System.out.println("Infinite solutions");
            }else{
                System.out.println("No solution");
            }
        } else {
            double x1 = (a22 * b1 - a12 * b2) / det;
            double x2 = (a11 * b2 - a21 * b1) / det;
            System.out.println("Solution : x1 = " + x1 + ", x2 = " + x2); 
        }
    }
    
    public static void secondDegreeEquation(double a, double b, double c) {
        double discriminant = b * b - 4*a*c;
        if(discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real and distinct roots: x1 = " + root1 + ", x2 = " + root2);
        }else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root (double root): x = " + root);
        } else {
            System.out.println("No real roots");
        }
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input of the first-degree equation");
        System.out.print("a = ");
        Double fd_a = keyboard.nextDouble();
        System.out.print("b = ");
        Double fd_b = keyboard.nextDouble();
        firstDegreeEquation(fd_a, fd_b);

        System.out.println("Input of the system of first-degree equations");
        System.out.print("a11 = ");
        Double sys_fd_a11 = keyboard.nextDouble();
        System.out.print("a12 = ");
        Double sys_fd_a12 = keyboard.nextDouble();
        System.out.print("a21 = ");
        Double sys_fd_a21 = keyboard.nextDouble();
        System.out.print("a22 = ");
        Double sys_fd_a22 = keyboard.nextDouble();
        System.out.print("b1 = ");
        Double sys_fd_b1 = keyboard.nextDouble();
        System.out.print("b2 = ");
        Double sys_fd_b2 = keyboard.nextDouble();
        systemDegreeEquation(sys_fd_a11, sys_fd_a12, sys_fd_a21, sys_fd_a22, sys_fd_b1, sys_fd_b2);

        System.out.println("Input of the second-degree equation");
        System.out.print("a = ");
        Double sd_a = keyboard.nextDouble();
        System.out.print("b = ");
        Double sd_b = keyboard.nextDouble();
        System.out.print("c = ");
        Double sd_c = keyboard.nextDouble();
        secondDegreeEquation(sd_a, sd_b, sd_c);
    }
}
