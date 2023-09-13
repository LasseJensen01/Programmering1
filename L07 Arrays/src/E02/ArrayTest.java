package E02;


import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {4, 6, 7, 2, 3};
        int[] b = {4, 6, 8, 2, 6};
        int[] c = sumArrays(a, b);
        int[] d = {4, 6, 7, 2, 3, 10, 9};
        int[] e = sumArraysButCooler(b, d);
        int[] t = {4, 6, 7, 2, 3};
        System.out.println("Sum of t is: " + sum(t));
        System.out.println("The array of a & b combined is = " + Arrays.toString(c));
        System.out.println("The array of b & d combined is = " + Arrays.toString(e));
        System.out.println("Whether the array of t has an uneven number is stated as " + hasUneven(t));

    }

    public static int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int[] c = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static int[] sumArraysButCooler(int[] d, int[] e) {
        int maxArrayLenght = 0;
        int[] tempMin;
        int[] tempMax;
        if (d.length < e.length) {
            maxArrayLenght = e.length;
            tempMin = Arrays.copyOf(d, maxArrayLenght);
            tempMax = Arrays.copyOf(e, maxArrayLenght);
        } else {
            maxArrayLenght = d.length;
            tempMin = Arrays.copyOf(e, maxArrayLenght);
            tempMax = Arrays.copyOf(d, maxArrayLenght);
        }
        int[] f = new int[maxArrayLenght];
        for (int i = 0; i < f.length; i++) {
            f[i] = tempMax[i] + tempMin[i];
        }
        return f;
    }

    public static boolean hasUneven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
    }
