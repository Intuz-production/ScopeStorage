package com.intuz.scopestorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.intuz.scopedstoragemodule.PermissionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btn_click;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_click) {
            PermissionActivity.requestAllFilesAccessPermission(MainActivity.this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PermissionActivity.ALL_FILES_ACCESS_PERMISSION) {
            PermissionActivity.requestAllFilesAccessPermission(MainActivity.this);
        }
    }
}
