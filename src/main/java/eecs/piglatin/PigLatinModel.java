package eecs.piglatin;

/**
 * Created by user on 3/13/17.
 */
public class PigLatinModel
{
    private String english;
    private String pig;

    /**
     * Initializes a default constructor by setting the fields to have the empty String
     */
    public PigLatinModel()
    {
        this.english = "";
        this.pig = "";

    }

    /**
     * Initializes the field that is to be translated by assigning a String text
     * @param text The Input string that is to be translated
     */
    public PigLatinModel(String text)
    {
        this.english = text;
        this.pig = "";
    }

    /**
     * Returns the String that is to be translated to PigLatin
     * @return The String to be translated to Piglatin
     */
    public String getEnglish()
    {
        return this.english;
    }

    /**
     * Sets the String of the field that is to be translated into PigLating
     * @param text The Input text that is to be set to this String
     */
    public void setEnglish(String text)
    {
        this.english = text;
    }

    /**
     * Returns the PigLatin translation of the current String
     * @return The PigLatin translation
     */
    public String getPig()
    {
        return this.pig;
    }

    /**
     * Translates this String to a PigLatin String.
     * The String is converted to a lowercase PigLatin text and depending on the last
     * letter/letters the appropriate PigLatin translation is determined.
     * <p>
     *     If the String has words that start with a vowel. Then add a "way" to the end of each word
     *     Else take the consonant at the start of the word and then add it to the end of that word
     *     along with a "ay" at the end or if the word has multiple consonants before its first
     *     vowel then take all those characters and add it to the end of the word and then add "ay"
     * </p>
     *
     */
    public void translate()
    {
        String sentence = this.english.toLowerCase();
        String[] words = sentence.split(" ");
        String firstSub;
        String endSub;
        char[] letters;
        this.pig="";

        for(int i=0;i<words.length;i++)
        {
            letters = words[i].toCharArray();
            for(int j=0;j<letters.length;j++){
                if((letters[j]=='a'||letters[j]=='e'||letters[j]=='i'||letters[j]=='o'||letters[j]=='u') && j==0){
                    words[i] += "way";
                    break;
                }
                else if (letters[j]=='a'||letters[j]=='e'||letters[j]=='i'||letters[j]=='o'||letters[j]=='u'){
                    firstSub = words[i].substring(0,j);
                    endSub = words[i].substring(j,letters.length);
                    words[i] = endSub+firstSub+"ay";
                    break;
                }
                else if (j==letters.length-1){
                    words[i]+="ay";
                    break;
                }
            }

        }
        for(int k=0;k<words.length;k++){
            this.pig+= words[k] + " ";
        }

    }

    public static void main(String[] args)
    {
        PigLatinModel model = new PigLatinModel("Lul aBb tOOrE a");
        System.out.println(model.getEnglish());
        //System.out.println(model
        //model.setEnglish("LUL");
        //System.out.println(model.getEnglish());
        //System.out.println(model.getPig() + "|");
        model.translate();
        System.out.println(model.getPig());
        System.out.println();

    }


}
