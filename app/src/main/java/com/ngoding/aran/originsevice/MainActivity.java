package com.ngoding.aran.originsevice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnMulaiOriginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMulaiOriginService = findViewById(R.id.btn_mulai_service);
        btnMulaiOriginService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent mStartServiceIntent = new Intent(MainActivity.this, OriginalService.class);
        startService(mStartServiceIntent);
    }
}
