package com.lec.android.a015_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.URLEncoder;

public class Main3Activity extends AppCompatActivity {

    Button btnXML,btnJSON,btnParse;
    public static final String REQ_SERVICE = "stationInfo";
    public static final String API_KEY = "4d46796d7366726f3833774a774955";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String url_address = "";
        StringBuffer sb;

        btnXML=findViewById(R.id.btnXML);
        btnJSON=findViewById(R.id.btnJSON);
        btnParse=findViewById(R.id.btnParse);



        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }//end onCreate()

    public static String buildUrlAddress(int startIndex, int endIndex, String stationName) throws IOException{


        String url_address = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/%s/%d/%d/%s",
                API_KEY,REQ_SERVICE, startIndex, endIndex, URLEncoder.encode(stationName, "UTF-8"));

        return url_address;
    }



}//end Activity
