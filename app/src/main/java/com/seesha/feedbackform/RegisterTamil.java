package com.seesha.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterTamil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_tamil);

        //---------------
        Button btn_chk = findViewById(R.id.regsubmit2);
        final EditText tamil_v = findViewById(R.id.tamilno);


        btn_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CheckNo(tamil_v.getText().toString())) {

                    String numberT = tamil_v.getText().toString();//--------------

                    Intent feedbacktam = new Intent(RegisterTamil.this, FeedbackTamil.class);

                    feedbacktam.putExtra("numberTam", numberT);//-----------------

                    startActivity(feedbacktam);

                }
                else {
                    Toast.makeText(getApplicationContext(), "\n" + "செல்லுபடியாகும் மொபைல் எண்ணை உள்ளிடவும்", Toast.LENGTH_SHORT).show();
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
