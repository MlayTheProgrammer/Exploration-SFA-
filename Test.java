import java.util.Random;
public class Test
{
    public static void main(String[] args)
    {
        int START = 0;
        int END = 200;
        long start_time, stop_time, over_time, time;
        Random r = new Random();
        // running once to eliminate first-time-run bug
        Mergesort.mergesort(new int[]{1,2});
        Bubblesort.bubblesort(new int[]{1, 2});
        //table header
        System.out.format("%10s\t%5s\t%20s\n", "TYPE", "INDEX", "TIME(ns)");
        for(int n = START; n< END; n++)
        {
            start_time = System.nanoTime();
            stop_time = System.nanoTime();
            over_time = stop_time - start_time;

            //generate 2 duplicate arrays of length n
            int[] arr1 = new int[n];
            for (int i = 0; i< n; i++){
                arr1[i] = r.nextInt(201)-100; //from -100 to 100
            }
            int[] arr2 = arr1.clone();

            //try mergesort
            start_time = System.nanoTime();
            Mergesort.mergesort(arr1);
            stop_time = System.nanoTime();
            time = stop_time-start_time-over_time;
            System.out.format("%10s\t%5d\t%20d\n","mergesort", n, time);

            //try bubblesort
            start_time = System.nanoTime();
            Bubblesort.bubblesort(arr2);
            stop_time = System.nanoTime();
            time = stop_time-start_time-over_time;
            System.out.format("%10s\t%5d\t%20d\n","bubblesort", n, time);
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
