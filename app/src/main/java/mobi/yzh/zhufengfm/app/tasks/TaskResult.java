package mobi.yzh.zhufengfm.app.tasks;

/**
 * Created by yangzonghui on 2015/7/28.
 */

/**
 * 异步任务的结果抽象描述  用于区分结果属于哪一个Task
 */
public class TaskResult {
    /**
     * 异步任务的标识
     */
    public int taskId;

    /**
     * 异步任务内部获取的数据
     */
    public Object data;
}
