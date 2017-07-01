package eecs.piglatin;

import java.util.Arrays;

/**
 * Created by user on 3/13/17.
 */
public class PigLatinModel
{
    private String english;
    private String pig;

    public PigLatinModel()
    {
        this.english = "";
        this.pig = "";

    }

    public PigLatinModel(java.lang.String text)
    {
        this.english = text;
        this.pig = "";
    }

    public java.lang.String getEnglish()
    {
        return this.english;
    }

    public void setEnglish(java.lang.String text)
    {
        this.english = text;
    }

    public java.lang.String getPig()
    {
        return this.pig;
    }

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
