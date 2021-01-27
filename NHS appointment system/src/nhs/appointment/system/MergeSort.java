package nhs.appointment.system;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    public static void fillArray(ArrayList array) {

        boolean flag = false;
        int p = 0;
        while (flag == false) {
            try {
                System.out.println("Please enter more numbers");
                Scanner input = new Scanner(System.in);
                int num = input.nextInt();
                array.add(p, num);
                p++;
            } catch (Exception e) {
                //System.out.println(e);
                flag = true;
                break;
            }
        }

//        for (int i = 0; i < 6; i++) {
//
//            System.out.println("Please give us more numbers");
//            Scanner input = new Scanner(System.in);
//            int num = input.nextInt();
//            j--;
//            array.add(i, num);
//        }
    }

    /* A utility function to print array of size n */
    public static void printArrayList(ArrayList array) {
        int n = array.size();
        for (int i = 0; i < n; ++i) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    public static void merge(ArrayList array, int l, int m, int r) {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
//        int L[] = new int[n1];
        ArrayList<Integer> L = new ArrayList<>();
//        int R[] = new int[n2]; 
        ArrayList<Integer> R = new ArrayList<>();

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            int temp;
            temp = (Integer) array.get(l + i);
            L.add(temp);
        }

        for (int j = 0; j < n2; ++j) {
            int temp;
            temp = (Integer) array.get(m + 1 + j);
            R.add(temp);
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                array.set(k, L.get(i));
                i++;
            } else {
                array.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void sort(ArrayList array, int l, int r) {
        if (l >= r) {
            return;
        }
        // Find the middle point 
        int m = (l + r) / 2;
        //possibly should have a minus onwe within this (r-1)

        // Sort first and second halves 
        sort(array, l, m);
        sort(array, m + 1, r);

        // Merge the sorted halves 
        merge(array, l, m, r);
    }

}
