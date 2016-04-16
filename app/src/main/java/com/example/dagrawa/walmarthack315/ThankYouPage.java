package com.example.dagrawa.walmarthack315;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ThankYouPage extends Activity {
    Context con = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_page);
        Button b = (Button) findViewById(R.id.ShareOrder);
        con = this;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I just bought an Item on myntra. You can get your shipping free by selecting groups address. http://www.myntrapool.com");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }


}
