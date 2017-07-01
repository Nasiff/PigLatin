package eecs.piglatin;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class PigLatinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{
    PigLatinModel model;
    TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_latin);

        this.tts = new TextToSpeech(this, this);
        model = new PigLatinModel();



    }

    public void speak(View v)
    {
        ((EditText)(findViewById(R.id.inputText))).getText().toString();
        String answer = model.getPig();
        say(answer);

    }

    public void clear(View v)
    {
        String emptyTheInputText = "";
        ((EditText)(findViewById(R.id.inputText))).setText(emptyTheInputText);


    }

    public void translate(View v)
    {

        String s = ((EditText)(findViewById(R.id.inputText))).getText().toString();


        model.setEnglish(s);

        model.translate();
        String answer = model.getPig();

        ((TextView)(findViewById(R.id.convertedText))).setText(answer);
        String answer1 = model.getEnglish();
        say(answer1);

    }

    public void onInit(int initStatus)
    {
        if (initStatus != TextToSpeech.ERROR)
        {
            if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
            {
                tts.setLanguage(Locale.US);
            }
        } else
        {
            Toast.makeText(this, "Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

    public void say(String s)
    {
        if (tts != null)
        {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
        }
    }





}
