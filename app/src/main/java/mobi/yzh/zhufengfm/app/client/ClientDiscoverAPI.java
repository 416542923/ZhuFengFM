package mobi.yzh.zhufengfm.app.client;

/**
 * Created by yangzonghui on 2015/7/28.
 */

import java.io.UnsupportedEncodingException;

/**
 * 发现部分的API接口调用
 */
public final class ClientDiscoverAPI {

    public static final String SERVER_MOBILE = "http://mobile.ximalaya.com";

    private ClientDiscoverAPI(){}

    /////////////////////////////////////////

    /**
     * 获取分类Tag菜单<br/>
     * 调用接口是哪个  http://mobile.ximalaya.com/m/category_tag_menu <br/>
     * 请求方法：GET <br/>
     * @param type 可选  默认是user
     * @return
     */
    public static String getCategoryTagMenu(String type){

        String ret = null;

        String url = null;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_MOBILE+"/m/category_tag_menu");

        if (type != null) {
            sb.append("?type=").append(type);
            sb.append("&device=android");
        }
        url = sb.toString();
        sb = null;

        byte[] data = HttpUtil.doGet(url);
        if (data != null) {
            try {
                ret = new String(data,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(data);
            }
        }
        return ret;

    }

}
