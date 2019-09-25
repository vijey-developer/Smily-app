package com.seesha.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long back_pressed;
    private Toast backToast;

    public Button Tamil1;
    public void init(){

        Tamil1= (Button)findViewById(R.id.Tamil);
        Tamil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterT = new Intent(MainActivity.this,RegisterTamil.class);

                startActivity(RegisterT);
            }
        });

    }

    public Button English1;
    public void init2(){

        English1= (Button)findViewById(R.id.English);
        English1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterE = new Intent(MainActivity.this,RegisterEnglish.class);

                startActivity(RegisterE);
            }
        });

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        init2();


    }
    @Override
    public void onBackPressed()
    {
        if(back_pressed >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press once again to exit!", Toast.LENGTH_SHORT).show();
            back_pressed++;
        }
    }
}
