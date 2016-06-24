package com.wk.fragmenttab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tv_title;

    private LinearLayout mll_tab_weixin;
    private LinearLayout mll_tab_frd;
    private LinearLayout mll_tab_address;
    private LinearLayout mll_tab_setting;

    private ImageButton mid_tab_weixin_img;
    private ImageButton mid_tab_frd_img;
    private ImageButton mid_tab_address_img;
    private ImageButton mid_tab_setting_img;

    private WeixinFragment weixinFragment;
    private FrdFragment frdFragment;
    private AddressFragment addressFragment;
    private SettingFragment settingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
        setSelect(0);
    }

    //初始化view
    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        mll_tab_weixin = (LinearLayout) findViewById(R.id.ll_tab_weixin);
        mll_tab_frd = (LinearLayout) findViewById(R.id.ll_tab_frd);
        mll_tab_address = (LinearLayout) findViewById(R.id.ll_tab_address);
        mll_tab_setting = (LinearLayout) findViewById(R.id.ll_tab_settings);

        mid_tab_weixin_img = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mid_tab_frd_img = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mid_tab_address_img = (ImageButton) findViewById(R.id.id_tab_address_img);
        mid_tab_setting_img = (ImageButton) findViewById(R.id.id_tab_settings_img);
    }
    //初始化事件
    private void initEvent() {
        mll_tab_weixin.setOnClickListener(this);
        mll_tab_frd.setOnClickListener(this);
        mll_tab_address.setOnClickListener(this);
        mll_tab_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        resetView();
        switch (v.getId()){
            case R.id.ll_tab_weixin:
                setSelect(0);
                break;
            case R.id.ll_tab_frd:
                setSelect(1);
                break;
            case R.id.ll_tab_address:
                setSelect(2);
                break;
            case R.id.ll_tab_settings:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void setSelect(int index) {
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hiddenFrament(transaction);
        switch (index){
            case 0:
                mid_tab_weixin_img.setSelected(true);
                tv_title.setText("微信");
                if(weixinFragment == null){
                    weixinFragment = new WeixinFragment();
                    transaction.add(R.id.id_content_fragment,weixinFragment);
                }else {
                    transaction.show(weixinFragment);
                }

                break;
            case 1:
                mid_tab_frd_img.setSelected(true);
                tv_title.setText("朋友");
                if(frdFragment == null){
                    frdFragment = new FrdFragment();
                    transaction.add(R.id.id_content_fragment, frdFragment);
                }else {
                    transaction.show(frdFragment);
                }

                break;
            case 2:
                mid_tab_address_img.setSelected(true);
                tv_title.setText("通讯录");
                if(addressFragment == null){
                    addressFragment = new AddressFragment();
                    transaction.add(R.id.id_content_fragment, addressFragment);
                }else {
                    transaction.show(addressFragment);
                }

                break;
            case 3:
                mid_tab_setting_img.setSelected(true);
                tv_title.setText("设置");
                if(settingFragment == null){
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.id_content_fragment, settingFragment);
                }else {
                    transaction.show(settingFragment);
                }

                break;
            default:
                break;
        }

        transaction.commit();
    }

    private void hiddenFrament(FragmentTransaction transaction) {
        if(weixinFragment!=null){
            transaction.hide(weixinFragment);
        }
        if(frdFragment!=null){
            transaction.hide(frdFragment);
        }
        if(addressFragment!=null){
            transaction.hide(addressFragment);
        }
        if(settingFragment!=null){
            transaction.hide(settingFragment);
        }
    }

    //使底部图片颜色全部置为白色
    private void resetView() {

        mid_tab_weixin_img.setSelected(false);
        mid_tab_frd_img.setSelected(false);
        mid_tab_address_img.setSelected(false);
        mid_tab_setting_img.setSelected(false);
    }
}
