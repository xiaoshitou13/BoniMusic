package test.bwie.com.bonimusic;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import Utils.Cengjing;

public class MainHelloActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hello);


        Build b = new Build();
        Cengjing cengjing= new Cengjing(b,this,getSupportActionBar());
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(MainHelloActivity.this,ZhuyeActivity.class));
                finish();
            }
        }.start();

    }
}
