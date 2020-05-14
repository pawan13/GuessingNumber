package com.pk.guessingnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textViewMsg, textViewNumber;
    Button btnPlus, btnMinus, btnCheck;
    int currentnumber, numbertobeguesssed, attempts;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMsg = findViewById(R.id.textView_msg);
        textViewNumber =findViewById(R.id.textView_number);
        btnPlus=findViewById(R.id.button_plus);
        btnMinus=findViewById(R.id.button_minus);
        btnCheck=findViewById(R.id.button_check);

        textViewNumber.setText("" + currentnumber);
        r = new Random();
        numbertobeguesssed = r.nextInt(51);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentnumber == numbertobeguesssed) {
                    textViewMsg.setText("Congratulations you have guessed the number in" + attempts + "attempts");
                    btnCheck.setEnabled(false);
                    btnMinus.setEnabled(false);
                    btnPlus.setEnabled(false);
                } else if (currentnumber > numbertobeguesssed) {
                    textViewMsg.setText("Keep Guessing, try the smaller number");
                } else if(currentnumber<numbertobeguesssed) {
                        textViewMsg.setText("Keep Guessing, Try the bigger number");
            }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener(){
        @Override
       public void onClick(View v) {
            if(currentnumber < 50){
                currentnumber ++;
                attempts++;
            }
            textViewNumber.setText(""+currentnumber);
       }
   });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentnumber > 0){
                    currentnumber --;
                    attempts++;
                }
                textViewNumber.setText("" + currentnumber);
            }
        });
    }
}
