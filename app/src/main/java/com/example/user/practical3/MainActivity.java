package com.example.user.practical3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewAction;
    private EditText etTo;
    private EditText etSub;
    private EditText etMess;
    private int amount = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link UI to program
        textViewAction = (TextView) findViewById(R.id.textViewAction);
        etTo = (EditText) findViewById(R.id.editTextTo);
        etSub = (EditText) findViewById(R.id.editTextSubject);
        etMess = (EditText) findViewById(R.id.editTextMessage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
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
            textViewAction.setText(getString(R.string.action_settings));
            return true;
        } else if (id == R.id.actionSearch) {
            //textViewAction.setText(getString(R.string.search));
            Intent intent = new Intent(this, SearchAvtivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_increase) {
            if(amount <= 30) {
                amount ++;
                etTo.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
                etMess.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
                etSub.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
            }
        } else if (id == R.id.action_decrease) {
            if(amount >=12) {
                amount--;
                etTo.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
                etMess.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
                etSub.setTextSize(TypedValue.COMPLEX_UNIT_SP, amount);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
