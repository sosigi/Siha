package com.sausage.voca;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DictionaryFragment extends Fragment {

    EditText search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dictionary, null);
        search = v.findViewById(R.id.search); //fragment의 경우 여기서 view를 연결하고, 이후에 findViewById를 한다.
        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Intent intent = new Intent(getActivity(), DicSearch.class);
                    // 입력한 단어 data도 넘어가게 하고싶은데,,, 자꾸 에러가 뜬다
                    intent.putExtra("search", search.getText());
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


        return v; // Inflate the layout for this fragment
    }
}