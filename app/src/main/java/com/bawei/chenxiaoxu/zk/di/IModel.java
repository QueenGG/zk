package com.bawei.chenxiaoxu.zk.di;

/**
 * Created by _ヽ陌路离殇ゞ on 2018/9/9.
 */

public interface IModel {
    interface CallBack{

        void error(String message);

        void successful(String string);
    }
    interface CallBack2{
        void error2(String message);
        void successful2(String string);
    }
    void requetinfo2(String name,String password,CallBack2 callBack2);
    void requetinfo(String name,String password,CallBack callBack);

}
