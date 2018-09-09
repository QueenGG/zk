package com.bawei.chenxiaoxu.zk.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by _ヽ陌路离殇ゞ on 2018/9/8.
 */

public class Okhttputils {
    private static Okhttputils okhttputils;
    private OkHttpClient okHttpClient;
    public Okhttputils() {
        if(okhttputils==null){
            okHttpClient=new OkHttpClient();
        }
    }
    //单例
    public static Okhttputils getInstance(){
        if(okhttputils==null){
            synchronized (Okhttputils.class){
                if(okhttputils==null){
                    okhttputils=new Okhttputils();
                }
            }
        }
        return okhttputils;
    }

    //get请求
    public void get(String url_get, Callback callback){
        Request request = new Request.Builder().url(url_get).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //post请求
    public void post(String url_post, FormBody formBody,Callback callback){
        Request request = new Request.Builder().method("POST", formBody).url(url_post).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
