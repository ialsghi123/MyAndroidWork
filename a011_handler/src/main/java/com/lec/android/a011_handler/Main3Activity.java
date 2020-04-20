package com.lec.android.a011_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * • 작업 스케쥴링:
 *   ▫ 작업스레드의 실행 시점을 조절하여, 작업 로드가 많은 작업을 나중으로 미룸으로써
 *     응용프로그램이 '끊김'없이 실행될수 있도록할수 있다.
 *
 *  •  Handler 사용한 구현 방법:
 *        boolean sendMessageAtTime (Message msg, uptimeMillis)
 *        boolean sendEmptyMessageAtTime (what, uptimeMillis)
 *        boolean sendMessageDelayed (Message msg, long delayMillis)
 *        boolean sendEmptyMessageDelayed (what, long delayMillis)
 *        boolean postAtTime (Runnable r, uptimeMillis)
 *        boolean postDelayed (Runnable r, long delayMillis)
 *        boolean postAtFrontOfQueue(Runnable r)
 *
 *        xxxAtFrontOfQueue – 큐의 가장 앞에 메세지를 삽입합니다.
 *        xxxAtTime – 지정한 시간으로 설정하여 큐에 삽입합니다.
 *        xxxDelayed – 현재시간으로부터 지정한 시간만큼 뒤로 설정하여 큐에 삽입합니다.
 *
 *  •  java.util.Timer, java.util.TimerTask 사용한 구현 방법:
 *
 */




public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }//end onCreate()

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            doUpload(msg.what);
        }
    };

    void doUpload(int n){
        Toast.makeText(getApplicationContext(),n+":업로드를 완료했습니다.",Toast.LENGTH_LONG).show();
    }

    // #1 메인 스레드가 메인스레드 자신에게 메세지 보내기
    //sendEmptyMessageDelayed()
    public void mOnClick1(View v){
        new AlertDialog.Builder(this)
                .setTitle("질문1")
                .setMessage("업로드 하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("아니오",null)
                .show();
    }

   /*  예제# 2 : Handler 로 Runnable 을 지연(delay)하여 보냄(post)
   메인스레드가 메인스레드 자신에게 Runnable 을 보내는 경우임
   postDelayed(Runnable) 사용
    */


   public void mOnClick2(View v){
       new AlertDialog.Builder(this)
               .setTitle("질문2")
               .setMessage("업로드 하시겠습니까?")
               .setPositiveButton("예", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .show();
   }

   //#3 view 에 Runnable을 담아서 보냄
    //Handler 가 필요 없다.
//
//    public void mOnClick3(View v){
//        new AlertDialog.Builder(this)
//                .setTitle("질문3")
//                .setMessage("업로드 하시겠습니까?")
//                .setPositiveButton("예", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //View(Button)을 통해서도 Runnable을 생성해서 보낼 수 있다.
//                        Button btnUpload = findViewById(R.id.btnUpload3);
//                        btnUpload.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                doUpload(3);
//                            }
//                        }),

                    }
//                })
//                .show();
//    }
//
//    //#4 : Timer,TimerTask 사용
//
//    public void mOnClick4(View v){
//        new AlertDialog.Builder(this)
//                .setTitle("질문4")
//                .setMessage("업로드 하시겠습니까?")
//                .setPositiveButton("예", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        Timer timer= new Timer();
//                        TimerTask task=new TimerTask(){
//                            @Override
//                            public void run() {
//                                mHandlr
//                            }
//                        };
//
//                    }
//                })
//                .show();
//    }


//}//end Activity
