package FinalExam;

/**
 * A simple linked list object. Its nodes are defined as an inner class.
 * 
 * COMP 271 FINAL ASSIGNMENT
 * 
 * Review class SimpleLinkedList below. It's a linked list object, quite similar
 * to our TrainLine, only instead of TrainStations it uses Nodes. The nodes are
 * defined as a class-within-the-class -- this is called an inner class and it's
 * a useful coding practice for simple situations like this one here.
 * 
 * Your job is to complete TWO methods in the SimpleLinkedList. You may NOT
 * modify any part of the class and you may not import ANYTHING. Your code
 * should be focused only within the two methods you are asked to write.
 * 
 * 1) Write method findMiddle() that finds and returns the middle node of
 * a SimpleListList. For example, if the SimpleLinkedList object is:
 * 
 * A -> null ... the middle mode is A
 * 
 * When the SimpleLinkedList object is:
 * 
 * A -> B --> null ... the middle mode is also A
 * 
 * When the SimpleLinkedList object is:
 * 
 * A -> B --> C --> null ... the middle mode is B
 * 
 * When the SimpleLinkedList object is:
 * 
 * A -> B --> C --> D --> null ... the middle mode is also B
 * 
 * When the SimpleLinkedList object is:
 * 
 * A -> B --> C --> D --> E --> null ... the middle mode is C, etc
 * 
 * 
 * 2) Write a method called invert that returns the inverted version of the
 * present SimpleLinkedList object. For example, if the current object is
 * 
 * A --> B --> C --> D --> E --> null
 * 
 * method invert should return the object
 * 
 * E --> D --> C --> B --> A --> null.
 * 
 */

 public class SimpleLinkedList {

    /**
     * Inner class for Node. Node fields can be accessed directly, for simplicity of
     * code. This is an intentional violation of the Pact.
     */
    class Node {
        String data;
        Node next;

        /** Simple string representation for Node */
        public String toString() {
            return this.data;
        } // method Node.toString
    } // inner class Node

    /** The only field in class SimpleLinkedList */
    Node head;

    /** Add a new node to the linked list */
    public void add(String data) {
        Node newNode = new Node();
        newNode.data = data;
        if (this.head == null) {
            this.head = newNode;
        } else {
            // Traverse the list to find the last node
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            // current is now the last node in the list
            current.next = newNode;
        }
    } // method add

    /** Find and return the middle node of the linked list. */
    public Node findMiddle() {

    
        /* 
        * TWO OPTIONS I CAN THINK OF:
        * Edgecase for empty set
        * Iterate through list
        * Count out number of elements
        * Determine the middle point length / 2 
        * Reiterate through the list
        * When the index = 2, we know we have element needed to be returned
        * The iterating (i, j etc) needs to equal the the middle point 
        * If the number at the middle point array[index] length / 2
         Return */ 

         /* 
          * OPTION 2
          * The old game of tortise and the hare
          * 2 pointers iterate through the list since we dont know the size of it
          * One goes to the next node, the other jumps per 2 nodes reading the list faster
          * As the faster pointer finishes the first node going half the speed of the second reaches 
          * the middle target node
          */

        Node slowTurtle = this.head; // Define 2 nodes pointing to the only value we have (the start)
        Node fastRabbit = this.head; 

        if (this.head == null) { // Edgecase if linked list has no nodes
            // As Leo said, dont do anything
     
        } else
        while (fastRabbit.next != null && fastRabbit.next.next != null) { //Traverse while their are nodes
            fastRabbit = fastRabbit.next.next; // Rabbit hops 2x
            slowTurtle = slowTurtle.next; // Turtle moves 1 step
        }
    
        return slowTurtle; // When the rabbit makes it to the end, the turtle is at the middle of the list
    

    } // method SimpleLinkedList.findMiddle

    /**
     * Invert a linked list. 
     * 
     * For this method you may NOT use SimpleLinkedList.add
     */
   public SimpleLinkedList invert() {
        
        /* Make three nodes
         * Nodes = before, current, after
         * Before and after should start as null since we know nothing it can point to
         * REMEMBER Edgecases always
         * When the current node is not null begin pointing and setting nodes 
         */

        Node beforeNode = null; // The only node we can declare for now is the one we have 
        Node currentNode = this.head; // Which is the start
        Node afterNode = null;

        if (this.head == null) { // However of the head doesnt exist then we cannot traverse
     
        } else

        while(currentNode != null) { // As long as the current node exist
          afterNode = currentNode.next; // First lets point to the next node 
          currentNode.next = beforeNode; // Since we are going backwards, the current node points to the previous node
          beforeNode = currentNode; // The previous node is the current node      
          currentNode = afterNode;  // current node then moves to the next node after that
        } 
     
        this.head = beforeNode; 
        
        return this; // Doesnt ask to return a node so we return this instead.


    } // method SimpleLinkedList.invert

    /** String representation for the simple linked list */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head != null) {
            Node current = this.head;
            while (current != null) {
                sb.append(String.format("%s", current.data));
                current = current.next;
            }
        }
        return sb.toString();
    } // method SimpleLinkedList.toString

    /**
     * Driver/test code. This is some of the most embarassing code I've ever written
     * but it works. Learn from it and do not write code that bad! :-)
     */
    public static void main(String[] args) {
        SimpleLinkedList demo = new SimpleLinkedList();
        boolean test1 = demo.findMiddle() == null;
        demo.add("A");
        boolean test2 = demo.findMiddle().data.equals("A");
        demo.add("B");
        boolean test3 = demo.findMiddle().data.equals("A");
        demo.add("C");
        boolean test4 = demo.findMiddle().data.equals("B");
        demo.add("D");
        demo.add("E");
        boolean test5 = demo.findMiddle().data.equals("C");
        boolean success = test1 && test2 && test3 && test4 && test5;
        if (success) {
            System.out.println("Method findMiddle works as specified.");
        } else {
            System.out.println("Method findMiddle not working as specified.");
        }
        String leftToRight = demo.toString();
        String rightToLeft = demo.invert().toString();
        boolean test10 = leftToRight.length() == rightToLeft.length();
        for (int i = 0; i < leftToRight.length(); i++) {
            test10 = test10 && leftToRight.charAt(i) == rightToLeft.charAt(rightToLeft.length() - 1 - i);
        }
        if (test10) {
            System.out.println("Method invert works as specified.");
        } else {
            System.out.println("Method invert not working as specified.");
        }
    } // method SimpleLinkedList.main

} // class SimpleLinkedList