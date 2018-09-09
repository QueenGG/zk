package com.bawei.chenxiaoxu.zk.ui;

import com.bawei.chenxiaoxu.zk.di.IModel;
import com.bawei.chenxiaoxu.zk.di.IPesenter;
import com.bawei.chenxiaoxu.zk.di.IView;

/**
 * Created by _ヽ陌路离殇ゞ on 2018/9/9.
 */

public class IPesenterImp implements IPesenter {

    private IView iView;
    private final IModelImp iModel;

    public IPesenterImp(IView iView) {
        this.iView=iView;
        iModel = new IModelImp();
    }

    public void getData(String name, String password) {
        iModel.requetinfo(name, password, new IModel.CallBack() {
            @Override
            public void error(String message) {
                iView.errorr(message);
            }

            @Override
            public void successful(String string) {
                iView.success(string);
            }
        });
    }

    @Override
    public void getreData(String name, String password) {
        iModel.requetinfo2(name, password, new IModel.CallBack2() {
            @Override
            public void error2(String message) {
                iView.errorr2(message);
            }

            @Override
            public void successful2(String string) {
                iView.success2(string);
            }
        });
    }
}
