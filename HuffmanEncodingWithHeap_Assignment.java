public class HuffmanEncodingWithHeap {
    // Create private data field containing forest

    MinHeap<HuffmanNode> forest;

    // Create a constructor method with a string parameter representing the word we
    // want to encode
    public HuffmanEncodingWithHeap(String phrase) {

        // Inside this method we want to create an int[] of frequencies and count them
        // using the countFrequency
        // method from the HuffmanEncoding class
        // Build our forest and tree based off of the frequency array
        // Then print out a representation of the frquency array 
        int[] frequencies = HuffmanEncoding.countFrequency(phrase);
        forest = new MinHeap<>(); // Since I get forest here no need to make a getForest Method 
        buildTree(buildForest(frequencies));
        outputFrequencies(frequencies);
        
    }

    public MinHeap<HuffmanNode> buildForest(int[] frequencies) {
        /*
         * We need to iterate over each letter inside of our frequency array, and any
         * number that has a value > 0,
         * is an instance(s) of it being recorded when we were counting the frequency of
         * the letters in the word.
         * Thus we should add it to the forest.
         */

        for (int ascii = 0; ascii < frequencies.length; ascii++) {
            if (frequencies[ascii] > 0) {
                // Make a new HuffmanNode based on the char and frequency value
                char ch = (char) ascii;
                HuffmanNode charFrq = new HuffmanNode(ch, frequencies[ascii]);
                // Then add it to the forest of nodes.
                forest.insert(charFrq);
            }
        }

        return forest;
    }

    public MinHeap<HuffmanNode> buildTree(MinHeap<HuffmanNode> forest) {
        while (forest.size() > 1) { // Work through the forest nodes make a new node from the smallest frequencies
            HuffmanNode f1 = forest.removeMin(); // Take the two smallest frequencies
            HuffmanNode f2 = forest.removeMin();
            HuffmanNode newNode = new HuffmanNode(f1.getFrequency() + f2.getFrequency()); // Add them into a new Node
            newNode.setLeft(f1); // Make the new node the left and right
            newNode.setRight(f2);
            forest.insert(newNode); // Then insert said node into the forest
        }

        return forest;
    }
   
    /* Creation of the actual forest */
    public String outputForest(HuffmanNode node, String output) {
        if (node == null) { // If the node is null theres nothing to print instead of having two returns
                            // just print output as an empty string
            output = " ";
        }
        if (node.hasRight()) { // Technically you should traverse from left to right but I dont think its 
            outputForest(node.getRight(), output); // neccessary
        }
        output += node.toString() + " ";

        if (node.hasLeft()) {
            outputForest(node.getLeft(), output);
        }

        return output;
    }

     /*
     * For the frequencies to print so that you can see if it actually works
     *  You have to actually print them out Alexis
     * 
     * Create a method that loops through each chars frequency in the string
     * Then print them out with the frequency amount
     */
    public void outputFrequencies(int[] frequencies) {
        for (int x = 0; x < frequencies.length; x++) {
            if (frequencies[x] > 0) {
                char ch = (char) x;
                System.out.println(ch + ": " + frequencies[x]);
            }
        }
    }

    public static void main(String[] args) {
        String phrase = "now is the winter of our discontent made glorious by this son of york and all the clouds that lourd over our house in the deep bossom of the ocean lay"; // Test string 
        String result = " ";
        HuffmanEncodingWithHeap testWord = new HuffmanEncodingWithHeap(phrase);
        System.out.println(testWord.outputForest(testWord.forest.getMin(), result));

    }
}
