package mobi.yzh.zhufengfm.app.parsers;

import mobi.yzh.zhufengfm.app.model.CategoryTagMenu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by yangzonghui on 2015/7/28.
 */
public final class DataParser {

    private DataParser() {
    }

    /**
     * 解析CategoryTagMenuTask 返回的Json结果
     *
     * @param json JSONOBJECT
     * @return List&lt;CategoryTagMenu&gt
     */
    public static List<CategoryTagMenu> parserCategoryTagMenuResult(JSONObject json) {
        List<CategoryTagMenu> ret = null;
        if (json != null) {
            try {
                int code = json.getInt("ret");
                if (code == 0) {
                    JSONObject data = json.getJSONObject("data");
                    int category_count = data.getInt("category_couont");
                    if (category_count > 0) {
                        JSONArray array = data.getJSONArray("category_list");
                        category_count = array.length();
                        if (category_count > 0) {
                            for (int i = 0; i < category_count; i++) {
                                JSONObject jsonObject = array.getJSONObject(i);
                                CategoryTagMenu menu = new CategoryTagMenu();
                                //实体类自己解析自己的数据
                                menu.parserJSON(jsonObject);
                                ret.add(menu);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return ret;

    }
}
