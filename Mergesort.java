import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Mergesort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter an integer (>= 1): ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i< n; i++){
            arr[i] = r.nextInt(201)-100;
        }
        System.out.print("The original array: ");
        print_arr(arr);
        mergesort(arr);
        System.out.print("The sorted array: ");
        print_arr(arr);
    }
    public static void mergesort(int[] A)
    {
        if (A.length > 1) {
            int floor_half = (int)Math.floor(A.length/2.0);
            int ceil_half = A.length - floor_half;
            int[] B  = new int[floor_half];
            for(int i = 0; i < floor_half; i++)
            {
                B[i] = A[i];
            }
            int[] C = new int[ceil_half];
            for(int j = 0; j < ceil_half; j++)
            {
                C[j] = A[j + floor_half];
            }
            mergesort(B);
            mergesort(C);
            merge(B, C, A);
        }
    }
    private static void merge(int[] B, int[] C, int[] A)
    {
        //merge until one of the subarrays is done
        int i=0, j=0, k=0;
        while (i< B.length && j<C.length)
        {
            if(B[i] < C[j])
            {
                A[k] = B[i];
                i++;
            }
            else
            {
                A[k] = C[j];
                j++;
            }
            k++;
        }
        //put leftovers of the other array the back
        if (i == B.length)
        {
            while (j < C.length)
            {
                A[k] = C[j];
                k++;
                j++;
            }
        }
        else
        {
            while (i < B.length)
            {
                A[k] = B[i];
                k++;
                i++;
            }
        }
    }

    private static void print_arr(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if (i == arr.length - 1)
                System.out.print(arr[i] + "\n");
            else
                System.out.print(arr[i] + ", ");
        }
    }
}
