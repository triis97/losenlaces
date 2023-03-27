package org.losenlaces.algorithms.search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(bynarySearch(new int[]{1, 2, 4}, 5));
    }

    public static int bynarySearch(int[] sortedList, int number ){
        int min = 0;
        int max = sortedList.length-1;

        while (min<=max){
            int mid = min + (max-min)/2;

            if(sortedList[mid] == number){
                return min;
            }
            if (sortedList[mid] >  number){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return -1;
    }
}
