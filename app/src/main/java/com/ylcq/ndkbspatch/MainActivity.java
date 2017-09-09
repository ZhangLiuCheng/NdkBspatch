package com.ylcq.ndkbspatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bspatch(View view) {
        final String oldFile = "/sdcard/old.apk";
        final String patchFile = "/sdcard/patch.apk";
        final String newFile = "/sdcard/new.apk";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bspatch.patch(oldFile, newFile, patchFile);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "合并成功", Toast.LENGTH_SHORT).show();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView info = (TextView) findViewById(R.id.info);
                        info.setText("合并成功");
                        Toast.makeText(MainActivity.this, "合并成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}
