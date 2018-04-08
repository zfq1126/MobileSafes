package com.smn.www.mobilesafe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.smn.www.mobilesafe.bean.AppInfo;
import com.smn.www.mobilesafe.db.AppInfoDao;
import com.smn.www.mobilesafe.engine.AppInfoProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-04-02.
 */
public class AppLockAcitivity extends Activity {
    @InjectView(R.id.bt_unlock)
    Button btUnlock;
    @InjectView(R.id.bt_lock)
    Button btLock;
    @InjectView(R.id.lv_unlock)
    ListView lvUnlock;
    @InjectView(R.id.lv_lock)
    ListView lvLock;
    private List<AppInfo> unLockList;
    private List<AppInfo> lockList;
    private AppInfoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);
        ButterKnife.inject(this);

        dao = new AppInfoDao(this);
        List<AppInfo> appInfos = AppInfoProvider.AppInfoList(this);
        //遍历已将安装城程序的所有信息
        for (AppInfo appInfo:appInfos) {
            // 需要检测这些应用程序是加锁的还是没有加锁
            // 需要一个已加锁的 数据库,专门用来 对是否加锁应用程序信息的 增 删 查
            // 如何判断 属于已加锁 的还是 未加锁的 : 通过包名在数据库中查询 ,如果查到,说明属于已经加锁的 应用,否则属于没有加锁的应用

            //未加锁的集合
            unLockList = new ArrayList<>();
            //已加锁的集合
            lockList = new ArrayList<>();
            boolean b = dao.QueryPackagename(appInfo.getPackageName());
            if (b){
                // 说明属于已经加锁的应用   将这些应用放在一个已加锁的应用集合中
                lockList.add(appInfo);
            }else {
                // 说明属于已经加锁的应用   将这些应用放在一个未加锁的应用集合中
                unLockList.add(appInfo);
            }
            Log.i("zzzzzzzzz",appInfo.toString());
        }
        //4-9开始用适配器适配两个listView，进行数据的填充，；比较难完成
    }

    @OnClick({R.id.bt_unlock, R.id.bt_lock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_unlock:
                // 当点击 未加锁的时候  未加锁的 背景 变为紫色 文字颜色为白色
                // 已加锁 背景变为 白色  文字颜色变为紫色，
                //修改关于背景颜色的设置
                btUnlock.setBackgroundResource(R.drawable.shape_unlock_purple_bg);
                btUnlock.setTextColor(Color.WHITE);

                btLock.setBackgroundResource(R.drawable.shape_lock_write_bg);
                btLock.setTextColor(Color.BLUE);
                lvUnlock.setVisibility(View.VISIBLE);
                lvLock.setVisibility(View.GONE);
                break;
            case R.id.bt_lock:
                // 当点击 已加锁的时候  已加锁的 背景 变为紫色 文字颜色为白色
                // 未加锁 背景变为 白色  文字颜色变为紫色
                btLock.setBackgroundResource(R.drawable.shape_lock_purple_bg);
                btLock.setTextColor(Color.WHITE);

                btUnlock.setBackgroundResource(R.drawable.shape_unlock_write_bg);
                btUnlock.setTextColor(Color.BLUE);

                lvUnlock.setVisibility(View.VISIBLE);
                lvLock.setVisibility(View.GONE);
                break;
        }
    }
}
