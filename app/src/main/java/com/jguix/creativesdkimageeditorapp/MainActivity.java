package com.jguix.creativesdkimageeditorapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.aviary.android.feather.sdk.AviaryIntent;
import com.aviary.android.feather.sdk.internal.Constants;


public class MainActivity extends AppCompatActivity {
    private ImageView mResultImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mResultImageView = (ImageView) findViewById(R.id.resultImageView);

        /* 1) Choose a random animal image */
        Uri imageUri = Uri.parse("http://lorempixel.com/350/600/animals/");

        /* 2) Create a new Intent */
        Intent imageEditorIntent = new AviaryIntent.Builder(this)
                .setData(imageUri)
                .build();

        /* 3) Start the Image Editor with request code 1 */
        startActivityForResult(imageEditorIntent, 1);
    }

    /* 4) Handle the results */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                /* 5) Make a case for the request code we passed to startActivityForResult() */
                case 1:

                    /* 6) Show the image! */
                    Uri mImageUri = data.getData();
                    mResultImageView.setImageURI(mImageUri);

                    /* 7) Log the image URI in the Android Studio console */
                    Log.d("URI!", mImageUri.toString());

                    /* 8) Find out if the image has been edited */
                    Bundle extra = data.getExtras();
                    if (extra != null) {
                        boolean changed = extra.getBoolean(Constants.EXTRA_OUT_BITMAP_CHANGED);
                        Log.d("Edited?", changed ? "yes" : "no");
                    }

                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
