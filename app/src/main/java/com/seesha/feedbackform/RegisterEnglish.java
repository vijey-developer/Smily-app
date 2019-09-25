package com.seesha.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterEnglish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_english);

        //---------------
        Button btn_chk = findViewById(R.id.regsubmit1);
        final EditText english_v = findViewById(R.id.englishno);


        btn_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CheckNo(english_v.getText().toString())) {

                    String numberE = english_v.getText().toString();//--------------

                    Intent feedbackeng = new Intent(RegisterEnglish.this, FeedbackEnglish.class);

                    feedbackeng.putExtra("numberEng", numberE);//-----------------

                    startActivity(feedbackeng);
                }
                else {
                    Toast.makeText(getApplicationContext(), "\n" + "Enter a valid mobile number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //validation function

    private boolean CheckNo(String phone) {
        boolean check;
        if(!Pattern.matches("[a-zA-Z]+", phone))
        {
            check = phone.length() == 10;
        }
        else
        {
            check=false;
        }
        return check;

    }

}