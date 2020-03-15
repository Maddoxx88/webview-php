package com.example.webviewphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText edit_word, edit_antonym;
    RadioGroup radioGroup;
    RadioButton actionBtn;
    Button submitBtn;
    WebView webView;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        submitBtn = findViewById(R.id.submitBtn);
        webView = findViewById(R.id.webView);
        edit_word = findViewById(R.id.edit_word);
        edit_antonym = findViewById(R.id.edit_antonym);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID = radioGroup.getCheckedRadioButtonId();

                if(selectedID==-1){
                    Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else if (radioGroup.getCheckedRadioButtonId() == findViewById(R.id.radioInsert).getId()){
                    String word = edit_word.getText().toString();
                    String antonym = edit_antonym.getText().toString();
                    webView.loadUrl("http://10.0.2.2:80/android_php/test.php?word="+word+"&antonym="+antonym);
                    Toast.makeText(MainActivity.this, "Data Inserted successfully!", Toast.LENGTH_SHORT).show();
                }
                else if (radioGroup.getCheckedRadioButtonId() == findViewById(R.id.radioDelete).getId()){
                    String word = edit_word.getText().toString();
                    String antonym = edit_antonym.getText().toString();
                    webView.loadUrl("http://10.0.2.2:80/android_php/test2.php?word="+word+"&antonym="+antonym);
                    Toast.makeText(MainActivity.this, "Data Deleted successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Something doesn't work properly!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
