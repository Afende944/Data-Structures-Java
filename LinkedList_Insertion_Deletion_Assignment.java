package Homework6;

public class TrainLine {

    private static final int MAX_LINE_LENGTH = 80;
    /** The name of the trainline */
    private String name;
    /** Points to the first station in the trainline */
    private TrainStation head;
    /** Points to the last station in the trainline */
    private TrainStation tail;
    /** Keeps a running tally of train stations in the trainline */
    private int numberOfStations;

    /** Full constructor */
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            // If head is not null, there is one station in the line
            this.numberOfStations = 1;
        }
        // At initialization head and tail point to the same station even if null
        this.tail = null;
    } // full constructor

    /** Basic constructor */
    public TrainLine(String name) {
        this(name, null);
    } // basic constructor

    /**
     * Creates a new station with the given name and adds it to the end of the line.
     */
    public void add(String name) {
        // Create the new station to add
        TrainStation newStation = new TrainStation(name);
        // Determine where to place the new station
        if (this.head == null) {
            // Trainline is empty, make new station the head of the line
            this.head = newStation;
        } else {
            // When there is a head station already, add the new station after the last
            // station in the line.
            this.tail.setNext(newStation);
        }
        // The new station becomes the tail station of the line
        this.tail = newStation;
        // Update station count
        this.numberOfStations++;
    } // method add



    /** Returns the number of stations in the line >= 0 */
    public int getNumberOfStations() {
        return numberOfStations;
    } // method getNumberOfStations

    public TrainStation remove(int position) {
        TrainStation removedStation = null;
        if (position >= 1 && position <= this.numberOfStations) {
            // Commence safe operations
            if (position == 1) {
                // Remove head
                removedStation = this.head;
                this.head = this.head.getNext();
            } else {
                // Find the station prior to the one to be removed
                TrainStation cursor = this.head;
                for (int i = 1; i < position-1; i++) {
                    cursor = cursor.getNext();
                }
                // cursor should be at the prior station
                if (cursor.getNext() == this.tail) {
                    this.tail = cursor;
                }
                removedStation = cursor.getNext();
                cursor.setNext(cursor.getNext().getNext());
            }
            this.numberOfStations--;
            removedStation.setNext(null);
        }
        return removedStation;
    }
   /*
    * Adds new station with name given as String 
    * after the station in position identified by int
    *
    * @param name
    * @param position
    *
    * Because we are implementing at any given position there needs to be cases 
    * Depending on where (Head, Middle, Some random new position) etc
    * 
    */ 
    void insert (String name, int position) {
       
        TrainStation current = head; 
        TrainStation newStation = new TrainStation(name); 

            if (position < 0 || position > numberOfStations) // Edgecase protection that needs clarfication 
            throw new IllegalArgumentException("Invalid position: " + position);
            

            if (position == 0) { // If its the head nothing previous points to it
                newStation.setNext(head); 
                this.head = newStation; // It becomes the new head
            } else { // Any point besides the tail needs to be traversed 
                
                for (int i = 0; i < position - 1; i++) 
                    current = current.getNext(); // The node before must point to the new node
                    newStation.setNext(current.getNext()); // The new station must point to the next station the old node pointed to
                    current.setNext(newStation); // The current station now becomes the new current 

            }
            if (newStation.getNext() == null) // For tail theres nothing for the new node to point to
            this.tail = newStation; // So the new Station just becomes the tail
            numberOfStations++; 
        }
        

    /*
     * String representation of a TrainLine object
     * 
     * Should be a snake-line visulization of the trainline 
     * 
     * @param Cannot be more than 80 characters long
     * and needs linked list to go backwards
     */

     
     public String toString() {
        StringBuilder result = new StringBuilder();
        TrainStation current = head;

        // Loop until we reach the tail
        while (current != null) {
            StringBuilder currentLine = new StringBuilder();
            int lineLength = 0; 

        }

    
        if (reverseLine.length() > 0) {
            result.append(reverseLine);
        }
    

        return result.toString();
    }

    private TrainStation getTail() {
        TrainStation current = head;
        while (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }
        

    public static void main(String[] args) {
        // A few station names
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
            System.out.println(redLineSB.toString());
        }
        // An empty trainline
        // prep_TrainLine brownLineSB = new prep_TrainLine("Brown Line SB");
        // A random station name
        String randomName = "Oak Park";
        
    } // method main
} // class TrainLine


