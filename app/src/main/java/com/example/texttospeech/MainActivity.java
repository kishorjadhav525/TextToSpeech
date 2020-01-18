package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1=findViewById(R.id.editText);
        b1=findViewById(R.id.button);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() { //  TextToSpeech is a built in classand
            // * Called to signal the completion of the TextToSpeech engine initialization.

            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    }

