package model;

import android.content.Context;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 白玉春 on 2017/10/4.
 */

public class Okhttps {

    // 单利模式
    public static Okhttps okhttps = new Okhttps();
    public static Okhttps getOkhttp(){
        return okhttps;
    }

    public   OkHttpClient client = Okhttp3.client();

    /**
     *   get
     */

    public void GetData(String url, Context context, final Icallnew icallnew){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                icallnew.Result(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               if(response.isSuccessful()){
                   icallnew.Result(response.body().toString());
               }else{
                   icallnew.Result("请求失败");
               }
            }
        });
    }

    /**
     *  post
     */
    public void PostData(String url, Context context, Map<String,String> map , final Icallnew icallnew){
        FormBody.Builder builder =new FormBody.Builder();
        for(Map.Entry<String,String> m :map.entrySet()){
            builder.add(m.getKey(),m.getValue());
        }
        FormBody formBody = builder.build();
        Request builder1 = new Request.Builder().post(formBody).url(url).build();
        client.newCall(builder1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                icallnew.Result(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    icallnew.Result(response.body().toString());
                }else{
                    icallnew.Result("请求失败");
                }
            }
        });
    }

}
