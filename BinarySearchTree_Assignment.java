/**
 * A simple binary search tree
 */
public class BST {

    /** The entry point to the tree */
    private TreeNode root;
    /** Count of nodes in the tree */
    private int nodesCount;
    


    /** Default constructor */
    public BST() {
        this.root = null; // Declare root and node count
        this.nodesCount = 0;

    } // default constructor

    /**
     * Overloaded add to take a string, wrap it into a TreeNode object, and invoke
     * the principal method that adds a note to the tree.
     * 
     * @param word String to add, as a node, to the tree
     * 
     */
    public void add(String word) {
        this.add(new TreeNode(word));
        
    } // method add


    /* After inserting a new node successfully
     * Incremement nodesCount by 1
     * 
     * Adding a node has a few things to consider,
     * 1: What do to when first creating the BST (the root being null)
     * 2: How to know where to put the new word (Based off its lexcon value)
     * 3: How to compare two Strings (compareTo)
     * 4: And finally what to do if the word already exist
     */

    public void add(TreeNode node) { 

    
        if (this.root == null) { // First case when the BST root is null
            this.root = node; // The node (or word) will become the new root
            nodesCount++; // Because one node now exist nodesCount increases 

        } else {
            TreeNode currentTreeNode = root; // If the current node is the root it is the beginning
            TreeNode parentTreeNode = null; // As such, there is nothing before it meaning it is a orphan

            /*
             * If the current node is not null meaning its place isnt taken
             * the node before said node now becomes its parent
             * (this wouldnt count for root because the node before it doesnt exist)
             */
            while (currentTreeNode != null) { // If the current node is not null meaning its place isnt taken
                parentTreeNode = currentTreeNode; // the node before that (this wouldnt count for root because the node before it doesnt exist)
                                                   

                int compareTo = node.compareTo(currentTreeNode); // This compare to method traverses the tree
                                                                // Checking the lexicon value (dictionary value) of the two strings
                

                /*
                 * To compare the values we use a greater than equal to logic
                 * If the node is less than the value of the previous node
                 * It goes to the left of the current node
                 */
                if (compareTo < 0) { 
                    currentTreeNode = currentTreeNode.left;

                } else if (compareTo > 0) { // If it is greater
                    currentTreeNode = currentTreeNode.right; // It goes to the right of the current node
                } else {

                    return; // If it is equal, it does nothing because the word should already exist in the tree
                            
                }
            }

            /*
             * This part is redundant and wrong
             * Its just placing the value to the left or right based off its size, the putting the value there
             * However, it never actually checks whether theirs a value already there in the first place
             * To change this I would delete this section and just implement it into previous traversal section
             * 
             * Only when the spot is null should a node to added to a spot
             * 
             */

            if (node.compareTo(parentTreeNode) < 0 && parentTreeNode.left == null) {  // The previous implementation of this did not take into consideration
                                                                                        // The left or right of the parent node being null so I added it
                parentTreeNode.left = node;  

            } else if (node.compareTo(parentTreeNode) > 0 && parentTreeNode.right == null) {
                parentTreeNode.right = node; 
            }
            /*
             * Overall, it is important to understand that parent is the node before another node
             * Any node (I use any hesitantly) could be the parent node if it has nodes beneath it
             * We use parent node to compare a string we are attempting to add to BST
             * And figure out were lexiconally it belongs
             * 
             */
            nodesCount++; // Then the node count incremements
        }

     }
    
    
        }
    
    
