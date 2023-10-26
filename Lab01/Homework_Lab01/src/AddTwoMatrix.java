import java.util.Scanner;
public class AddTwoMatrix {

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       System.out.print("Enter number of rows: "); 
       int rows = sc.nextInt();
       System.out.print("Enter number of columns: ");
       int columns = sc.nextInt();
       int[][] matrixA = new int[rows][columns];
       int[][] matrixB = new int[rows][columns];

       System.out.println("Enter the elements in matrix A");
       for (int i = 0; i < rows; i++) {
              for (int j = 0; j < columns; j++) {
            	  	System.out.print("a" + (i+1) + (j+1) + " = ");
            	  	matrixA[i][j] = sc.nextInt();
              }
       }
       System.out.println("Enter the elements in matrix B :");
       for (int i = 0; i < rows; i++) {
              for (int j = 0; j < columns; j++) {
            	  	System.out.print("b" + (i+1) + (j+1) + " = ");
            	  	matrixB[i][j] = sc.nextInt();
              }
       }

       int[][] result = new int[rows][columns];
       for (int i = 0; i < rows; i++) {
              for (int j = 0; j < columns; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
              }
       }

       System.out.println("\nMatrix A is : ");
       for (int i = 0; i < rows; i++) {
              for (int j = 0; j < columns; j++) {
                    System.out.print(matrixA[i][j] + " ");
              }
              System.out.println();
       }
 
           System.out.println("\nMatrix B is : ");
           for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < columns; j++) {
                        System.out.print(matrixB[i][j] + " ");
                  }
                  System.out.println();
           }
 
           System.out.println("\nThe sum of the two matrices is : ");
           for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < columns; j++) {
                        System.out.print(result[i][j] + " ");
                  }
                  System.out.println();
           }
    }
    
}

