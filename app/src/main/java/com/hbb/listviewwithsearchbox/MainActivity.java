package com.hbb.listviewwithsearchbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private String[] countries =
            {"Turkey", "Germany", "Austria", "America", "England",
                    "Hungary", "Greece", "Russia", "Syria", "Iran", "Iraq",
                    "Chile", "Brazil", "Japan", "Portugal", "Spain",
                    "Macedonia", "Ukraine", "Switzerland"};

    private EditText et_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList=(ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> countryAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, countries);


        myList.setAdapter(countryAdapter);

        et_search=(EditText) findViewById(R.id.et_search);

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                countryAdapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}