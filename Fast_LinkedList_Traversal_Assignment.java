
public class FastQ {


    private String[] array;
    private int size;
    private int used;
    private int front;
    private int back;

    private static final int DEFAULT_SIZE = 4;

    /** Full constructor */
    public FastQ(int size) {
        if (size <1){
            size = DEFAULT_SIZE;
        }
        this.size = size;
        this.array = new String[this.size];
        this.used = 0;
        this.front = 0;
        this.back = 0;
    } // full constructor

    /** Default constructor */
    public FastQ() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * The FIFO system is a first in first out method that makes sure that
     * newer resources are put last in a line while older resources are used first.
     * 
     * @param string
     * @return
     */

    public boolean add(String string) {
        
        boolean worked = false; // Because we can't use loops we have to check if it has added the element and until it does make an artifical "loop"
        if (this.used < this.size) {  // As long as size is bigger than used spots
            this.array[this.back] = string; // We look to add to the back of the line first "FIFO METHOD"
            this.back = (this.back + 1) % this.size; // The back index then updates one space and depending on the value reloops back to position 0.
            this.used++; // Since a space should have technically been used/added
            worked = true; // Our goal should be true
             
        }
   
    return worked; // Return if it worked or not

} // method add
    
/**
 *  @param NO LOOPS OF ANY KIND ***
 *  @param No use of any imports or System functions
 * 
 * @return as method provides following programmers pact
 * Instead of pointing to the back first, point to the front 
 * Similar concept except this.used should decrease until there is no more spaces.
 */
     public String remove() {
        String goalString; // Needs to return the string being removed
        boolean edgecase = (this.back == this.front);

        if (edgecase); // Lets say array is empty
        goalString = null;

        if (this.used > 0) { // As long as used is greater than zero 
            goalString = this.array[this.front]; // String is set to array but the front position
            this.front = (this.front + 1) % this.size; // Using FIFO system the first into the method should be the first out 
                                                       // But its not really deleted, its position is just kind of skip over.
                                                        // Then modulus "reloops" back to first position 0
            this.used--; // Then decrease the amount of spaces since their is one less space 

        }
       
            return goalString; // return wanted String
    }
}
