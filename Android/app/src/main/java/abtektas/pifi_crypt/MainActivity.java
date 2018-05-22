package abtektas.pifi_crypt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  static final int PI[] = {1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1, 6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9, 2, 3, 0, 7, 8, 1, 6, 4, 0, 6, 2, 8, 6, 2, 0, 8, 9, 9, 8, 6, 2, 8, 0, 3, 4, 8, 2, 5, 3, 4, 2, 1, 1, 7, 0, 6, 7};
  static final int ALPHABET_LENGTH = 26;
  private EditText inputText, outputText;
  private Button encrypt, decrypt, cleanTextFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Attention : This version is still in development. New version will be publish as soon as possible.", Toast.LENGTH_LONG).show();
        StartProcess();
    }

    private String EncryptPi(String value) {
        char letter;
        char[] buffer = value.toCharArray();
        for (int i = 0; i < buffer.length; i++) {
            letter = buffer[i];
            if(Character.isLetter(letter)){
                letter = (char) (letter + PI[i]);
                if(letter > 'z'){
                    letter = (char) ((letter%'z')+'a'-1);
                }else if(letter>'Z' && letter<'a'){
                    letter = (char) ((letter%'Z')+'A'-1);
                }
            }

            buffer[i] = letter;
        }
        return new String(buffer);
    }

    private String DecryptPi(String value){
        char letter;
        char[] buffer = value.toCharArray();
        for (int i = 0; i < buffer.length; i++) {
            letter = buffer[i];
            //is character
            if(Character.isLetter(letter)){
                letter = (char) (letter - PI[i]);
                if(letter < 'A' || (letter > 'Z' && letter < 'a') || (Character.isUpperCase(letter) != Character.isUpperCase(letter+PI[i]))){
                    letter = (char) (letter+ALPHABET_LENGTH);
                }
            }
            buffer[i] = letter;
        }
        return new String(buffer);
    }

    public void StartProcess(){

        inputText = (EditText) findViewById(R.id.MessageInputTextField);
        outputText  = (EditText) findViewById(R.id.MessageOutputTextField);

        encrypt  = (Button) findViewById(R.id.EncryptButton);
        decrypt  = (Button) findViewById(R.id.DecryptButton);
        cleanTextFields  = (Button) findViewById(R.id.CleanButton);

        cleanTextFields.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                inputText.setText("");
                outputText.setText("");
            }
        });

        encrypt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String output = EncryptPi(inputText.getText().toString());
                outputText.setText(output);
            }
        });

        decrypt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String output = DecryptPi(inputText.getText().toString());
                outputText.setText(output);
            }
        });
    }
}
