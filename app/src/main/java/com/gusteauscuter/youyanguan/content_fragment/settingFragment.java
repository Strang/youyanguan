package com.gusteauscuter.youyanguan.content_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gusteauscuter.youyanguan.NavigationActivity;
import com.gusteauscuter.youyanguan.R;
import com.gusteauscuter.youyanguan.DepActivity.AboutActivity;

import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import cn.bmob.v3.update.UpdateStatus;


public class settingFragment extends Fragment {


    public settingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        view.findViewById(R.id.check_update).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(getActivity(), getString(R.string.update_state_start), Toast.LENGTH_SHORT).show();
//
//                        Toast.makeText(getActivity(), getString(R.string.update_state_end), Toast.LENGTH_SHORT).show();

//                        BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() {
//                            @Override
//                            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
//
//                                if (updateStatus == UpdateStatus.Yes) {//版本有更新
//
//                                }else if(updateStatus == UpdateStatus.No){
//                                    Toast.makeText(getActivity(), "版本无更新", Toast.LENGTH_SHORT).show();
//                                }else if(updateStatus==UpdateStatus.EmptyField){//此提示只是提醒开发者关注那些必填项，测试成功后，无需对用户提示
//                                    Toast.makeText(getActivity(), "请检查你AppVersion表的必填项，1、target_size（文件大小）是否填写；2、path或者android_url两者必填其中一项。", Toast.LENGTH_SHORT).show();
//                                }else if(updateStatus==UpdateStatus.IGNORED){
//                                    Toast.makeText(getActivity(), "该版本已被忽略更新", Toast.LENGTH_SHORT).show();
//                                }else if(updateStatus==UpdateStatus.ErrorSizeFormat){
//                                    Toast.makeText(getActivity(), "请检查target_size填写的格式，请使用file.length()方法获取apk大小。", Toast.LENGTH_SHORT).show();
//                                }else if(updateStatus==UpdateStatus.TimeOut){
//                                    Toast.makeText(getActivity(), "查询出错或查询超时", Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                        });
//                        BmobUpdateAgent.update(getActivity());

                        BmobUpdateAgent.forceUpdate(getActivity());

                    }
                });
        view.findViewById(R.id.feedback).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((NavigationActivity)getActivity()).SendEmailIntent("Setting");
                    }
                });
        view.findViewById(R.id.about).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(getActivity(), AboutActivity.class);
                        startActivity(intent);
                    }
                });

        return view;
    }


}
