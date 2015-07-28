package mobi.yzh.zhufengfm.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import mobi.yzh.zhufengfm.app.model.CategoryTagMenu;
import mobi.yzh.zhufengfm.app.parsers.DataParser;
import mobi.yzh.zhufengfm.app.tasks.TaskCallback;
import mobi.yzh.zhufengfm.app.tasks.TaskResult;
import mobi.yzh.zhufengfm.app.tasks.impl.CategoryTagMenuTask;
import org.json.JSONObject;

import java.util.List;

public class SplashActivity extends FragmentActivity implements TaskCallback {

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

        CategoryTagMenuTask task = new CategoryTagMenuTask(this);

    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int taskId = result.taskId;

            Object data = result.data;

            if (taskId == TaskConstants.TASK_CATEGORY_TAG_MENU) {
                //TODO 获取category_tag_menu的数据
                if (data != null) {
                    if (data instanceof JSONObject) {
                        JSONObject json = (JSONObject) data;
                        List<CategoryTagMenu> categoryTagMenus =
                                DataParser.parserCategoryTagMenuResult(json);

                        //TODO  存储categoryTagMenus

                    }

                }
                //TODO 处理之后判断教程的启动
            }
        }
    }
}
