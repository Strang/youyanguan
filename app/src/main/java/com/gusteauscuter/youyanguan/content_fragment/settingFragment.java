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
                        Toast.makeText(getActivity(), getString(R.string.update_state_start), Toast.LENGTH_SHORT).show();

                        Toast.makeText(getActivity(), getString(R.string.update_state_end), Toast.LENGTH_SHORT).show();

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
