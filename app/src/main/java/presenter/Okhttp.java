package presenter;

import android.content.Context;

import model.Get;
import model.Okhttp3;
import model.Okhttps;

/**
 * Created by 白玉春 on 2017/10/4.
 */

public class Okhttp {
    private Okhttps okhttps = Okhttps.getOkhttp();
    private   Get get;
    private Context context;

    public Okhttp(Get get, Context context) {
        this.get = get;
        this.context = context;
    }

    /**
     * get
     */
    public void Get(String url){
        get.GetDatas(url);
    }

    /**
     * post
     */
    public void Post(String url){
        get.PostDatas(url);
    }

}
