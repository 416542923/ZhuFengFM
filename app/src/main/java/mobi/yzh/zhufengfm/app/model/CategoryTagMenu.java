package mobi.yzh.zhufengfm.app.model;

/**
 * Created by yangzonghui on 2015/7/28.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 分类与Tag集合  一个分类包含了多个Tag
 */
public class CategoryTagMenu {

    private int id;
    private String name;
    private String title;
    private String intro;
    //对应is_display
    private boolean display;
    private String cover_path;
    private List<String> tagList;


    /**
     * 所有实体类都应该包含这个名称的方法  用于解析Json
     *
     * @param jsonObject
     */
    public void parserJSON(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            id = jsonObject.getInt("id");
            name = jsonObject.getString("name");
            //必须存在
            title = jsonObject.getString("title");
            //可选的内容  可能为空  没有也不会错
            intro = jsonObject.optString("intro");
            display = jsonObject.getBoolean("is_display");
            cover_path = jsonObject.getString("cover_path");
            JSONArray array = jsonObject.optJSONArray("tag_list");

            if (array != null) {
                int len = array.length();
                tagList = new LinkedList<String>();
                for (int i = 0; i < len; i++) {
                    tagList.add(array.getString(i));
                }
            }

        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public boolean isDisplay() {
        return display;
    }

    public String getCover_path() {
        return cover_path;
    }


}
