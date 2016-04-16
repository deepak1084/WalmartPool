package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by sushant on 4/16/16.
 */
public class ThankYou extends Activity {

    Context con= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thank_you);
        con = this;

        ImageView shareImage =  (ImageView) findViewById(R.id.share_image);
        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I just bought an Item on myntra. You can get your shipping free by selecting groups address. http://www.myntrapool.com");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        Button thankYouBtn = (Button) findViewById(R.id.thankYouBar);
        thankYouBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(con, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }

}
