package com.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class AboutDeveloper extends AppCompatActivity {
    LinearLayout lywhatsapp,lygmail,lyCall;
    String subject,bodyText;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        lygmail= (LinearLayout)findViewById(R.id.shregmailrti);
        lywhatsapp= (LinearLayout)findViewById(R.id.shrewhtsapprti);
        lyCall= (LinearLayout)findViewById(R.id.shrecall);

        lygmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailto = "mailto:sarthisevasamiti@gmail.com" +

                        "?cc=" + "sarthisevasamiti@gmail.com" +

                        "&subject=" + Uri.encode(subject) +

                        "&body=" + Uri.encode(bodyText);



                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                emailIntent.setData(Uri.parse(mailto));



                try {

                    startActivity(emailIntent);

                } catch (ActivityNotFoundException e) {

                    //TODO: Handle case where no email app is available

                }
            }
        });
lyCall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+91 7839280424"));
        startActivity(intent);
    }
});

    }
}
