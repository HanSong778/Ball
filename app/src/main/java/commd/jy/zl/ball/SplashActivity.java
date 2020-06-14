package commd.jy.zl.ball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import commd.jy.zl.commonframe.BaseActivity;
import commd.jy.zl.commonframe.frameTest.FrameTestActivity;

public class SplashActivity extends BaseActivity {
    /**
     * Hello World!
     */
    private TextView mTv;
    private int time = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        countTimer();
    }

    private void countTimer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    time--;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (time == 0) {
                                Intent intent = new Intent(SplashActivity.this, FaveListActivity.class);
                                startActivity(intent);
                            } else {
                                countTimer();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initIntent() {
        startActivity(new Intent(SplashActivity.this, FrameTestActivity.class));
    }
}
