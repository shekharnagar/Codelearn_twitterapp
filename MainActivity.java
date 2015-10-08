package com.kreate.twitter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button _loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
        String savedUsername = prefs.getString("key_for_username", null);
        String savedPassword = prefs.getString("key_for_password", null);

        if (savedUsername == null && savedPassword == null)
        {
                _loginBtn = (Button) findViewById(R.id.btn_login);


                _loginBtn.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                    public void onClick(View v) {
                                                     EditText username = (EditText) findViewById(R.id.fld_username);
                                                     String usernameValue = username.getText().toString();
                                                     EditText password = (EditText) findViewById(R.id.fld_pwd);
                                                     String passwordValue = username.getText().toString();
                                                     SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
                                                     SharedPreferences.Editor editor = prefs.edit();
                                                     editor.putString("key_for_username", usernameValue);
                                                     editor.putString("key_for_password", passwordValue);
                                                     //Code for extracting password value and saving it in the SharedPreference
                                                     editor.commit();
                                                     //Code for showing next Activity using intent (unchanged)

                                                     Log.d("Codelearn", "username caught - " + usernameValue);
                                                     //Add the following lines
                                                     Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
                                                     startActivity(intent);
                                                     finish();
                                                 }

                                             }
                );

        } else {
            Intent intent = new Intent(this, TweetListActivity.class);
            startActivity(intent);
            finish();
        }

    }

}
