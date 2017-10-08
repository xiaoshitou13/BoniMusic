package model;

import okhttp3.OkHttpClient;

/**
 * Created by 白玉春 on 2017/10/4.
 */

public class Okhttp3 {
    public static OkHttpClient okHttpClient = new OkHttpClient();
    public static OkHttpClient client (){
        return okHttpClient;
    }
}
