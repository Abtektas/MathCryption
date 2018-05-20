package abtektas.pifi_crypt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int pi[] = {1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9, 2, 3, 0, 7, 8, 1, 6, 4, 0, 6, 2, 8, 6, 2, 0, 8, 9, 9, 8, 6, 2, 8, 0, 3, 4, 8, 2, 5, 3, 4, 2, 1, 1, 7, 0, 6, 7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Attention : This version is still in development. New version will be publish as soon as possible.", Toast.LENGTH_LONG).show();
        StartProcess();
    }

    static String EncryptPi(String value) {

        char[] buffer = value.toCharArray();

        for (int i = 0; i < buffer.length; i++) {

            char letter = buffer[i];

            if (Character.isLetter(letter)) {
                letter = (char) (letter + pi[i]);

                if (Character.isUpperCase(letter)) {
                    if (letter > 'Z') {
                        letter = (char) (letter - 26);
                    } else if (letter < 'A') {
                        letter = (char) (letter + 26);
                    }
                }else {
                    if (letter > 'z') {
                        letter = (char) (letter - 26);
                    } else if (letter < 'a') {
                        letter = (char) (letter + 26);
                    }
                }
            }

            buffer[i] = letter;
        }
        return new String(buffer);
    }

    static String DecryptPi(String value){

        char[] buffer = value.toCharArray();

        for (int i = 0; i < buffer.length; i++) {

            char letter = buffer[i];

            if (Character.isLetter(letter)) {
                letter = (char) (letter - pi[i]);

                if (Character.isUpperCase(letter)) {
                    if (letter > 'Z') {
                        letter = (char) (letter - 26);
                    } else if (letter < 'A') {
                        letter = (char) (letter + 26);
                    }

                    buffer[i] = letter;

                }
                else {
                    if (letter > 'z') {
                        letter = (char) (letter - 26);
                    } else if (letter < 'a'){
                        letter = (char) (letter + 26);
                    }
                }
            }
            buffer[i] = letter;
        }
        return new String(buffer);
    }

    public void StartProcess(){

        final EditText InputText = (EditText) findViewById(R.id.MessageInputTextField);
        final EditText OutputText = (EditText) findViewById(R.id.MessageOutputTextField);

        final Button Encrypt = (Button) findViewById(R.id.EncryptButton);
        final Button Decrypt = (Button) findViewById(R.id.DecryptButton);
        final Button CleanTextFields = (Button) findViewById(R.id.CleanButton);

        CleanTextFields.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                InputText.setText("");
                OutputText.setText("");
            }
        });

        Encrypt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String output = EncryptPi(InputText.getText().toString());
                OutputText.setText(output);
            }
        });

        Decrypt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String output = DecryptPi(InputText.getText().toString());
                OutputText.setText(output);
            }
        });
    }
}
