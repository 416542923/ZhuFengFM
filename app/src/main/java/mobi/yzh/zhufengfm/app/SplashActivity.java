package mobi.yzh.zhufengfm.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class SplashActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //启动扉页没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //启动扉页，进行网络检查与网络请求，下载数据  最终显示主界面


    }
}
