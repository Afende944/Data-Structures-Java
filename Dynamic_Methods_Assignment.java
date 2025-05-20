import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;
    private static final int NUM_MOVES = 5; 
    private static final String[] MOVES = {"Forward", "Back", "groove-left", "groove-right", "booyeah", "ohyeah", "Hipthrust", "Nae-Nae", "HitthemFolks", "Split"};
    private static final String GOOD_JOB_MESSAGE = "Woahh, Nice moves!";
    private static final String ALPHABET_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String[] NUMERI_ITALIANO = {"uno","due","tre","quattro","cinque","sei","sette","otto","nove","dieci"};
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 10;
    private static final int EVEN_ODD = 2;
    private static final int POEM_WORDS_AMOUNT = 6;
    private static final String POEM_MESSAGE = "What beautiful themes of beautiful memories";
    private static final int END_LOTTO = 70; 
    private static final int LOTTO_NUM_AMOUNT = 5; 

    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    }

    // Getter and Setter methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

           /**
                 * Make a random sound. Actually, produce a random word and print it (no need to
                 * find how to make an actual sound)
                 * 
                 * 
                 * Random can be used for all methods
                 * 
                 * Use PoemWords to produce large array of potential words
                 * Go through array and pick random word
                 */

    
    void makeRandomSound() {
        Random random = new Random();
        int index = random.nextInt(PoemWords.words.length);
        System.out.println(PoemWords.words[index]);
    } 

    /**
     * Perform a silly dance by describing it as a sequence of a few steps left,
     * right, backwards, and forward
     * 
     * 
     * 
     * Remember, no magic values
     * Each possible loop value except the first
     * Has to be a final int value
     * 
     * Even the final message is considered a magic number thus, needs to be declared above
     */
    
    void performSillyDance() {
        Random rand = new Random();
        
        for (int i = 0; i < NUM_MOVES; i++) { 
            int index = rand.nextInt(MOVES.length);
            System.out.println(MOVES[index]);
        }
        System.out.println(GOOD_JOB_MESSAGE); // Wanted to add a fun message just for fun
    }

    /**  Recite the alphabet backwards (but forget one letter)
     * 
     * Loop through the alphabet and randomly skip one each time
     */

    
     String reciteAlphabetBackwards() {
        Random random = new Random();
        int ranSkip = random.nextInt(ALPHABET_LETTERS.length());
        StringBuilder finished = new StringBuilder();

        for (int i = ALPHABET_LETTERS.length() - 1; i >= 0; i--) {
            if (i != ranSkip) {
                finished.append(ALPHABET_LETTERS.charAt(i));
            }
        }
        return finished.toString(); // Non void string so it can have a return statement
    }

    /** Count to ten in an unusual way (maybe skip a number) 
     * 
     * Think: What to do with a simple for loop
     * 
     * String array needs to be declared as private final
     * Finding the even/odd numbers must also be declared
     * Start and Finished declared for loop 
     * 
    */
    
    void countToTenWeirdly() {

        for (int n = START_COUNT; n <= END_COUNT; n++) { // First start count was not needed but thats fine
            if (n % EVEN_ODD == 0) {
                System.out.println(NUMERI_ITALIANO[n - 1]);
            }
        } // Prints Even and ODD values in italian not numerically but it does equal ten

        for (int o = START_COUNT; o <= END_COUNT; o++) {
            if (o % EVEN_ODD != 0) {
                System.out.println(NUMERI_ITALIANO[o - 1]);
            }
        }
    }

    /**
     * Create a whimsical poem about a topic of your choice. Could be a few words at
     * random, as long as string topic is included in the first line
     * 
     * @param String topic must be included in the first line
     */
    
    String createWhimsicalPoem(String topic) { 
            StringBuilder poem = new StringBuilder(topic + ": ");
            Random random = new Random();
            
            for (int p = 0; p < POEM_WORDS_AMOUNT; p++) {
                int index = random.nextInt(PoemWords.words.length); // Randonly picks words from PoemWords
                poem.append(PoemWords.words[index]).append(" "); // Then appends them to String
            }
            
            System.out.println(POEM_MESSAGE); // Prints out a thoughtprovoking message too
            return poem.toString(); // Since Poems are just words afterall
        } 
        
    /**
     * Produce numbers for the state lottery
     * 
     * 
     * State lottery goes from 1-70
     * Powerball goes from 1-25
     * 
     */

    // I'm not sure if every state lottery has powerball 
    // loop 5 times through a random number picker that goes from 1 to 70
    void winStateLottery() {
        Random random = new Random();
        for (int r = 0; r < LOTTO_NUM_AMOUNT; r++) {
            int number = random.nextInt((END_LOTTO - START_COUNT) + 1) + START_COUNT; 
            System.out.println(number);
        }
    } // Void statement so it does not return a value
}