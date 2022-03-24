/*  Reggie Mlay     Carl Hawley		Leann		Hortencia	
   This class takes an array of integers and sorts them using Bubblesort

   Files Required: none
   Input     : None
   Output    : None
   Sample Run: n/a
*/
import java.util.Random;
import java.util.Scanner;
public class Bubblesort
{
    public static long count = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter an integer (>= 1): ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(201) - 100;
        }
        System.out.print("The original array: ");
        print_arr(arr);
        bubblesort(arr);
        System.out.print("The sorted array: ");
        print_arr(arr);
    }
    public static void bubblesort(int[] A)
    {
        //alternate take, faster in best cases:
        /*
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < A.length-1; i++){
                if (A[i] > A[i+1]) {
                    //swap
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        */
        //main version:
        for(int i = 0; i < A.length-1; i++)
        {
            for(int j =0; j< A.length-i-1; j++)
            {
                if(A[j]>A[j+1])
                {
                    //swap
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
                count++;
            }
        }


    }
    private static void print_arr(int[] arr)
    {
        for(int i=0; i < arr.length; i++)
        {
            if (i == arr.length - 1)
                System.out.print(arr[i] + "\n");
            else
                System.out.print(arr[i] + ", ");
        }
    }
}
