package ru.interprocom;

public class ValidMountainArray {
    public static boolean validMountainArray(int[] arr) {
        boolean ret = true;
        if (arr.length < 3 || arr[0] >= arr[1] || arr[arr.length - 1] >= arr[arr.length - 2]) {
            ret = false;
        } else {
            int i = 1;
            while (arr[i + 1] > arr[i]) {
                i++;
            }
            if (arr[i + 1] == arr[i]) {
                ret = false;
            } else {
                while (i < arr.length - 1 && arr[i + 1] < arr[i]) {
                    i++;
                }
                if (i != arr.length - 1) {
                    ret = false;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{1, 2, 3, 0}));
        System.out.println(validMountainArray(new int[]{1, 2, 3, 1, 2, 0}));
    }
}
