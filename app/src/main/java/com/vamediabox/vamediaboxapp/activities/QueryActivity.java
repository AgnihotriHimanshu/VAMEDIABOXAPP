package com.vamediabox.vamediaboxapp.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andreabaccega.widget.FormEditText;
import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.utilities.GMailSender;
import com.vamediabox.vamediaboxapp.utilities.InternetDetector;


/**
 * Created by HP 101 on 7/28/2017.
 */

public class QueryActivity extends AppCompatActivity {

    Button submit;
    FormEditText name, email, phone, website, message;
    String subject = " Enquiry From Mobile App";
    Boolean isConnectionExist = false;
    InternetDetector cd;
    String nameval, phoneval, websiteval, messageval, emailval;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        submit = (Button) findViewById(R.id.btnsubmit);

        name = (FormEditText) findViewById(R.id.query_name);


        phone = (FormEditText) findViewById(R.id.query_phone);


        email = (FormEditText) findViewById(R.id.query_email);


        website = (FormEditText) findViewById(R.id.query_website);


        message = (FormEditText) findViewById(R.id.query_message);


        cd = new InternetDetector(getApplicationContext());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                    // TODO Auto-generated method stub
                    nameval = name.getText().toString().trim() + "\r\n";
                    phoneval = phone.getText().toString().trim() + "\r\n";
                    emailval = email.getText().toString().trim() + "\r\n";
                    websiteval = website.getText().toString().trim() + "\r\n";
                    messageval = message.getText().toString().trim() + "\r\n";

                    FormEditText[] allFields = {name, phone, email, website, message};
                    boolean allValid = true;
                    for (FormEditText field : allFields) {
                        allValid = field.testValidity() && allValid;
                    }

                    if (allValid) {

                        isConnectionExist = cd.checkMobileInternetConn();
                        if (isConnectionExist) {

                            try {
                                new MyAsyncClass().execute();

                            } catch (Exception ex) {
                                Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                        }


                    }


                       else {


                     // It will show exclaimation mark

//                    showAlertDialog(QueryActivity.this, "No Internet Connection",
//                            "Your device doesn't have working internet", false);
                }


            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it          //     is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(QueryActivity.this, R.style.MyTheme);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }
        String body = "Name :- " + nameval  + "Email :- " + emailval + "Phone Number :- " + phoneval + "Website :- " + websiteval + "Message :- " + messageval;
        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add subject, Body, your mail Id, and receiver mail Id.


                GMailSender sender = new GMailSender("query.vamediabox@gmail.com", "Siddharth@123");
                sender.sendMail(subject, body, "query.vamediabox@gmail.com", "sales@vamediabox.com");
                Toast.makeText(getApplicationContext(), "Query Sent", Toast.LENGTH_SHORT).show();


            }

            catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Couldn't Sent Query ! Please Try Again ", Toast.LENGTH_SHORT).show();


            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();

            name.setText("");  email.setText("");  phone.setText("");  website.setText("");  message.setText("");
        }
    }
}
