package org.losenlaces.datastructures;


/*
An array is a collection of items stored at contiguous memory locations.
 The idea is to store multiple items of the same type together.
 This makes it easier to calculate the position of each element by
 simply adding an offset to a base value, i.e.,
 the memory location of the first element of the array (generally denoted by the name of the array).
 */
public class ArrayExample {

    static int[] intArray = new int[4];
    static int[] intArray2 = new int[]{1, 2, 3, 4};
    static int[] intArray3 = {1, 2, 3, 4};

    static String[] stringArray = new String[4];
    static String[] stringArray2 = new String[]{"uno","dos","tre","cuatro"};
    static String[] stringArray3 = {"uno","dos","tre","cuatro"};

    static InternalClass[] internalClasses = new InternalClass[4];
    static InternalClass[] internalClasses2 = new InternalClass[]{new InternalClass(), new InternalClass(), new InternalClass()};
    static InternalClass[] internalClasses3 = {new InternalClass(), new InternalClass(), new InternalClass()};


    static class InternalClass{

    }

    public static void main(String[] args) {
        for (int i = 0; i < intArray2.length; i++) {
            //We access the elements through the index
            System.out.println(intArray2[i]);
        }
    }

}
