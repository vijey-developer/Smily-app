package com.seesha.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hsalf.smilerating.SmileRating;

import java.util.HashMap;
import java.util.Map;

public class FeedbackTamil extends AppCompatActivity {


    TextView fnumber1;//---------text



    Button btn_feed1;
    public void init () {

        btn_feed1 = findViewById(R.id.btn_feed1);
        btn_feed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent thank = new Intent(Feedback.this, Thankyou.class);

                //startActivity(thank);
                addItemToSheet();

                //Toast.makeText(getApplicationContext(), "Thank you", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_tamil);


        init();

        //---------rating function

        SmileRating smileRating = findViewById(R.id.smile_rating_tam);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(getApplicationContext(), "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getApplicationContext(), "GOOD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getApplicationContext(), "GREAT", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getApplicationContext(), "OKAY", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getApplicationContext(), "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level) {

                Toast.makeText(FeedbackTamil.this, "Selected rating" + level, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onBackPressed () {

    }


    private void addItemToSheet() {

        //-------------------------Getting value from Register

        fnumber1 = (TextView)findViewById(R.id.textView6);
        Intent intent = getIntent();
        String numberT = intent.getStringExtra("numberTam");
        fnumber1.setText(numberT);

        //-------------------------------------------------

        final ProgressDialog loading = ProgressDialog.show(this, "Verifying", "Please wait");
        //final String name = number1.getText().toString().trim();
        // final String brand = level.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyzDduQcz0PL0hUzgt9w9BH3102Lf9PIismIrJSNxJA_hGUyv0Z/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(FeedbackTamil.this, response, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), ThankyouTamil.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action", "addItem");
                //parmas.put("itemName", String.valueOf(fnumber1));
                parmas.put("itemName", String.valueOf(fnumber1));
                //parmas.put("brand",brand);

                return parmas;
            }
        };


        //------------HTTP handling

        int socketTimeOut = 50000;     //Timer  is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);





        /*---------------------------feedback
        fnumber1 = (TextView)findViewById(R.id.textView6);

        Intent intent = getIntent();
        String numberT = intent.getStringExtra("numberTam");
        fnumber1.setText(numberT);
-----------------------*/

    }
}
