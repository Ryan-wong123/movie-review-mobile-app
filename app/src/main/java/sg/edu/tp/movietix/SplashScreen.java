package sg.edu.tp.movietix;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar splashprogressbar;

    private int splashprogressbarstatus = 0;

    private Handler newhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashprogressbar =(ProgressBar)findViewById(R.id.splashscreenprogress);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (splashprogressbarstatus < 100){
                    splashprogressbarstatus++;
                    android.os.SystemClock.sleep(30);
                    newhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            splashprogressbar.setProgress(splashprogressbarstatus);
                        }
                    });
                }
                newhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent splashintent = new Intent(getApplicationContext(), LoginScreen.class);
                        startActivity(splashintent);
                    }
                });
            }
        }).start();

    }
}
