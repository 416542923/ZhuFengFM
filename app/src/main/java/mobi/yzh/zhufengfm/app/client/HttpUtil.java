package mobi.yzh.zhufengfm.app.client;

/**
 * Created by yangzonghui on 2015/7/28.
 */

import android.os.Build;
import mobi.yzh.zhufengfm.app.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * 网络工具类  用于HTTP get，post 请求
 */
public final class HttpUtil {


    public static final int TIMEOUT_CONNECT = 5000;
    private static final int TIMEOUT_READ = 5000;

    private HttpUtil(){}

    /////////////////////////////////////////

    /**
     * 获取Get请求  返回字节数组
     * @param url 网址
     * @return byte[]
     */
    public static byte[] doGet(String url){
        byte[] ret = null;
        if (ret != null) {

            //注意释放链接
            HttpURLConnection conn = null;

            InputStream in = null;
            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();
                conn.setRequestMethod("GET");//GET请求
                conn.setRequestProperty("Accept-Encoding", "gzip");//设置HTTP请求头
                //用于识别手机版本
                conn.setRequestProperty("User-Agent","ting_4.1.7(MI2,Android"+ Build.VERSION.SDK_INT+")");
                //设置联网超时时间,只能用于短时间的联网操作
                //长时间需要重写

                //Socket打开链接的时间
                conn.setConnectTimeout(TIMEOUT_CONNECT);
                //链接打开之后一共可以读数据多长时间

                conn.setReadTimeout(TIMEOUT_READ);

                //设置自动处理302/307跳转 通常返回200
                conn.setInstanceFollowRedirects(true);

                //连接
                conn.connect();

                //服务器的状态码
                int code = conn.getResponseCode();
                if (code == 200) {

                    in = conn.getInputStream();

                    //获取服务器头信息，内容是否压缩

                    //获取指定服务器返回的头信息
                    String connectEncoding = conn.getHeaderField("Content-Encoding");

                    if (connectEncoding == null){
                        connectEncoding = conn.getHeaderField("content-encoding");
                    }
                    if (connectEncoding != null && connectEncoding.equals("gzip")) {
                        //代表数据经过压缩
                        //使用GZIPInputStream解压缩
                        in = new GZIPInputStream(in);
                    }
                    //读in
                    ret = StreamUtil.readStream(in);

                }else{
                    //TODO其他情况
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                StreamUtil.close(in);
                StreamUtil.close(conn);
            }

        }
        return ret;
    }

}
