package com.tuantrandev.tuantran.snackbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.support.design.widget.Snackbar.make;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSimple, btnWithAction, btnCustom;
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        btnSimple = (Button)findViewById(R.id.btnSimple);
        btnWithAction = (Button)findViewById(R.id.btnWithAction);
        btnCustom = (Button)findViewById(R.id.btnCustom);
        buttonClicked();
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
    private void buttonClicked(){
        btnSimple.setOnClickListener(this);
        btnWithAction.setOnClickListener(this);
        btnCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnSimple){
            make(coordinatorLayout,"Simple snackbar", Snackbar.LENGTH_SHORT).show();
        }
        if (v==btnWithAction){
            make(coordinatorLayout,"Snackbar with action", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    make(coordinatorLayout,"You've clicked on Action button", Snackbar.LENGTH_SHORT).show();
                }
            }).show();
        }
        if(v==btnCustom){
            Snackbar snackbar = Snackbar.make(coordinatorLayout,"My custom snackbar", Snackbar.LENGTH_SHORT).setAction("Click me", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(coordinatorLayout,"You've clicked on Action button", Snackbar.LENGTH_SHORT).show();
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }
    }
}
