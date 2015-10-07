package com.gusteauscuter.youyanguan.content_fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gusteauscuter.youyanguan.DepActivity.SearchResultActivity;
import com.gusteauscuter.youyanguan.R;
import com.gusteauscuter.youyanguan.internet.connectivity.NetworkConnectivity;

/**
 * A simple {searchBook Fragment} subclass.
 */
public class searchBookFragment extends Fragment{

    private EditText searchBookEditText;
    private Spinner searchBookTypeSpinner;

    private String bookToSearch;
    private String searchBookType="TITLE";
    private boolean isAllowedToBorrow;

//    private TextView mEmptyInformation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_book, container, false);


//        mEmptyInformation=(TextView) view.findViewById(R.id.emptyInformation);
//        mEmptyInformation.setVisibility(View.GONE);

        searchBookTypeSpinner=(Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.SearchBookType, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchBookTypeSpinner.setAdapter(adapter);
        searchBookTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String type = searchBookTypeSpinner.getItemAtPosition(i).toString();
                switch (type) {
                    case "标题":
                        searchBookType = "TITLE";
                        break;
                    case "作者":
                        searchBookType = "AUTHOR";
                        break;
                    case "ISBN":
                        searchBookType = "ISBN";
                        break;
                    case "ISSN":
                        searchBookType = "ISBN.011$a";
                        break;
                    case "出版社":
                        searchBookType = "PUBLISHER";
                        break;
                    case "分类号":
                        searchBookType = "CLASSNO";
                        break;
                    case "主题词":
                        searchBookType = "SUBJECT";
                        break;
                    case "统一刊号":
                        searchBookType = "UNIONNO";
                        break;
                    case "馆藏条码":
                        searchBookType = "BARCODE";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
//                searchBookType = "TITLE";
            }
        });

        final CheckBox mCheckBox=(CheckBox)view.findViewById(R.id.checkBox);

        Button searchButton = (Button) view.findViewById(R.id.searchButton);
        searchBookEditText = (EditText) view.findViewById(R.id.searchBookEditText);
        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookToSearch = searchBookEditText.getText().toString();

                        if(!bookToSearch.equals("")) {

                            boolean isConnected = NetworkConnectivity.isConnected(getActivity());
                            if (isConnected) {
                                //searchBookType;
                                isAllowedToBorrow = mCheckBox.isChecked();

                                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("bookToSearch", bookToSearch);
                                bundle.putSerializable("searchBookType", searchBookType);
                                bundle.putSerializable("isAllowedToBorrow", isAllowedToBorrow);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getActivity(), R.string.internet_not_connected, Toast.LENGTH_SHORT).show();
                            }
                        }else
                            Toast.makeText(getActivity(), "请输入搜索内容", Toast.LENGTH_SHORT).show();

                    }
                });

        return view;
    }

}
