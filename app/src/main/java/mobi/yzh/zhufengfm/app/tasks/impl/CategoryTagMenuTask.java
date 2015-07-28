package mobi.yzh.zhufengfm.app.tasks.impl;

import mobi.yzh.zhufengfm.app.TaskConstants;
import mobi.yzh.zhufengfm.app.client.ClientDiscoverAPI;
import mobi.yzh.zhufengfm.app.tasks.BaseTask;
import mobi.yzh.zhufengfm.app.tasks.TaskCallback;
import mobi.yzh.zhufengfm.app.tasks.TaskResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yangzonghui on 2015/7/28.
 */

/**
 * category_tag_menu<br/>
 * 这个任务支持一个参数  参数的内容是type值  目前只可以写user<br/>
 */
public class CategoryTagMenuTask extends BaseTask {


    public CategoryTagMenuTask(TaskCallback callback) {
        super(callback);
    }

    @Override
    protected TaskResult doInBackground(String... params) {


        //TaskResult 必须创建用来描述任务类型及数据
        TaskResult ret = new TaskResult();

        ret.taskId = TaskConstants.TASK_CATEGORY_TAG_MENU;
        ///////////////////////////////////////////////////////


        String type = null;
        if (params != null && params.length>0) {
            type = params[0];
        }

        String str = ClientDiscoverAPI.getCategoryTagMenu(type);

        if (str != null) {
            try {
                ret.data= new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
}
