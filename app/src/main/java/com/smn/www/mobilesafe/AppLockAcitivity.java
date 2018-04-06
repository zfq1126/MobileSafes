package com.smn.www.mobilesafe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt_unlock, R.id.bt_lock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_unlock:
                // 当点击 未加锁的时候  未加锁的 背景 变为紫色 文字颜色为白色
                // 已加锁 背景变为 白色  文字颜色变为紫色，
                //修改关于背景颜色的设置/////
                btUnlock.setBackgroundResource(R.drawable.shape_unlock_write_bg);
                btUnlock.setTextColor(Color.WHITE);

                btLock.setBackgroundResource(R.drawable.shape_lock_purple_bg);
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
