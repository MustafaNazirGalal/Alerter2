package com.example.prof.alerter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;
import com.tapadoo.alerter.OnShowAlertListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showAlerter(View v) {
        Alerter.create(MainActivity.this)
                .setTitle("Alert Title")
                .setText("Alert Text")
                .setIcon(R.drawable.ic_android)
                .setBackgroundColorRes(R.color.colorAccent)
                .setDuration(5000)
                .enableSwipeToDismiss() //seems to not work well with OnClickListener
                .enableProgress(true)
                .setProgressColorRes(R.color.colorPrimary)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do something when Alerter message was clicked
                        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnShowListener(new OnShowAlertListener() {
                    @Override
                    public void onShow() {
                        //do something when Alerter message shows
                        Toast.makeText(MainActivity.this, "New Alert", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnHideListener(new OnHideAlertListener() {
                    @Override
                    public void onHide() {
                        //do something when Alerter message hides
                        Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
