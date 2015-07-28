package mobi.yzh.zhufengfm.app.tasks;

/**
 * Created by yangzonghui on 2015/7/28.
 */

/**
 * TaskCallback  异步任务执行成功之后由onPostExecute来回调
 */
public interface TaskCallback {

    /**
     * 当异步任务执行成功进行回调
     * @param result
     */
    void onFinished(TaskResult result);

}
