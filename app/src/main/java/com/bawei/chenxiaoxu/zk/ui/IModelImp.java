package com.bawei.chenxiaoxu.zk.ui;

import com.bawei.chenxiaoxu.zk.di.IModel;
import com.bawei.chenxiaoxu.zk.utils.Okhttputils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

/**
 * Created by _ヽ陌路离殇ゞ on 2018/9/9.
 */

public class IModelImp implements IModel {

    private String url_login="https://www.zhaoapi.cn/user/login";
    private String url_regist="https://www.zhaoapi.cn/user/reg";

    @Override
    public void requetinfo2(String name, String password, final CallBack2 callBack2) {
        FormBody body = new FormBody.Builder()
                .add("mobile", name)
                .add("password", password)
                .build();
        Okhttputils.getInstance().post(url_login, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack2.error2(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                callBack2.successful2(string);
            }
        });
    }

    @Override
    public void requetinfo(String name, String password, final CallBack callBack) {
        FormBody body = new FormBody.Builder()
                .add("mobile", name)
                .add("password", password)
                .build();
        Okhttputils.getInstance().post(url_regist, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack.error(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                callBack.successful(string);
            }
        });
    }
}
