package com.lec.android.androidwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    Button btn_ok,btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
    }

    @Override
    public void onBackPressed() {
        dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.my_layout);

        btn_ok=dialog.findViewById(R.id.btn_yes);
        btn_no=dialog.findViewById(R.id.btn_no);

        btn_ok.setOnClickListener(click);
        btn_no.setOnClickListener(click);

        dialog.setTitle("app name");
        dialog.show();
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_yes:
                    finish();
                    break;

                case R.id.btn_no:
                    dialog.dismiss();
                    break;
            }
        }
    };
}