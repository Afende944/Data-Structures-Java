/**
 * A simple class to demonstrate dynamic behavior with arrays. Objects of this
 * class store strings in an array that grows to match the demand for storage.
 * 
 * The class is based on an underlying string array. Objects can be initialized
 * to any size; otherwise they'll be initialized to the default size. For
 * example,
 * 
 * DynamicArray da1 = new DynamicArray(10);
 * 
 * will have initially room for 10 strings, while
 * 
 * DynamicArray da2 = new DynamicArray();
 * 
 * will have initially room for 4 strings.
 */
public class DynamicArray {

    /** Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    private int occupancy;
    
    /** The underlying array for this class */
    private String[] foundation;
    
    /**
     * Full constructor. Initializes the underlying array to the specified size. The
     * size must be a positive, non zero value. Otherwise the constructor uses the
     * default size value.
     */
    public DynamicArray(int size) {
        // If size <= 0 use default -- this is a good time to demo ternary operator
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
        this.occupancy = 0;

    } // full constructor

    /** Array-based constructor -- used for testing */
    public DynamicArray(String[] data) {
        if (data == null) {
            this.foundation = new String[DEFAULT_SIZE];
            this.occupancy = 0;
        } else {
        this.occupancy = data.length;
        this.foundation = data;

        }

    }
     // array-based constructor

    /**
     * Default constructor
     */
    public DynamicArray() {
        this(DEFAULT_SIZE);
} // default constructor


/* ACTUAL METHODS START HERE
 * Methods should build on top of each other
 * 
 * @Param No use of of any package except Arrays
 * and only to use Arrays.toString
 */


 /* 
  * Returns true if target is present and false if it isnt
    it would be good to run through it with a for loop 
 */

 public boolean contains(String target) {
    int i = 0;
    boolean found = false;
    while(i < foundation.length && !found) {
        if(foundation[i] != null) { 
            if(foundation[i].equals(target))
                found = true;
        }

    
    }

    return found;
 }
/*
* Public string get - takes the string at 
* a certain index
* 
* @param if index at given position empty return null
*/

// Return 
public String get(int index) {
     String gotcha;
        if (foundation[index] == null) {
                gotcha = null;
        }

        if (foundation[index].isEmpty()) {  
            gotcha = null;
        } 
     else { 
    
            gotcha = foundation[index];

     }
    
     return gotcha;

    }

    /*Returns the value in position index in the underlying array 
     * 
     * Then remvoes the value from position [index]
    */

public String remove(int index) {
        String removed = null;
        int i = index;
        // should be one smaller than current array
        if (index >= 0 && index < foundation.length) {
            removed = foundation[index];
            while (i < foundation.length - 1) {
            foundation[i] = foundation[i + 1];
            i++;

            }

            foundation[foundation.length-1] = null;
        
        }
        return removed;

        }


public void delete(int index) {
        int i = index;
        if (index >= 0 && index < occupancy) {
            while ( i < occupancy - 1) {
                foundation[i] = foundation[i + 1];
                i++;
            }

            foundation[occupancy - 1] = null;
            occupancy--;
        }

}

/*
 * Because it is a fixed size it cannot be fixed at the drop of a dime
 * Instead it needs to be versatile so that the current array is copied
 * to a new array with more capacity, then if there is space
 * add more strings to the array
 */

public void insert(String string) {

        if (occupancy >= foundation.length) {
            resize();

    }
    foundation[occupancy] = string;
    occupancy++;
}
/*
 * Increases the size of foundation array as needed 
 * to accomodate additional strings inserted to the objct
 * 
 * 
 */

private void resize() {
        int a = 0;
        String[] secondFoundation = new String[foundation.length * 2];
        while ( a < foundation.length) {
            secondFoundation[a] = foundation[a];
            a++;
        }

        foundation = secondFoundation;

    }

 


    /** Driver/test code */
public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";
        // Test data
        String[] testData = { "Java", "Python", "C", "C++", "Fortran" };
        DynamicArray test = new DynamicArray(testData);
        DynamicArray tset = new DynamicArray(null);
        // Naive testing - I am ashamed to do this but I need
        // to keep things simple for now.
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;
        String testContainsEmptyData = (!tset.contains("Java")) ? PASS : FAIL;
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;
        String testGetOutOfBounds = (test.get(testData.length + 1) == null) ? PASS : FAIL;
        String testRemove = (testData[1].equals(test.remove(1))) ? PASS : FAIL;
        String testRemoveNull = (tset.remove(1) == null) ? PASS : FAIL;
        String testRemoveOutOfBounds = (test.remove(testData.length + 1) == null) ? PASS : FAIL;
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n", testGetOutOfBounds);
        System.out.printf("\nTest for remove(1): .................... %s", testRemove);
        System.out.printf("\nTest for remove(null): ................. %s", testRemoveNull);
        System.out.printf("\nTest for remove(out of bounds): ........ %s\n\n", testRemoveOutOfBounds);
        // If all is good, these two statemets will not crash the program
        test.insert("Pascal");
        test.insert("Basic");
    } // method main

} // class DynamicArray