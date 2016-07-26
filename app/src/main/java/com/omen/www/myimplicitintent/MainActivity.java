package com.omen.www.myimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonDial, mButtonView;
    private ListView mListView;

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.activity_main_dial:
                Uri number = Uri.parse("tel:10086");
                intent = new Intent(Intent.ACTION_DIAL, number);
                break;
            case R.id.activity_main_view:
                Uri url = Uri.parse("http://www.baidu.com");
                intent = new Intent(Intent.ACTION_VIEW, url);
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonDial = (Button) findViewById(R.id.activity_main_dial);
        mButtonView = (Button) findViewById(R.id.activity_main_view);
        mButtonDial.setOnClickListener(this);
        mButtonView.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.activity_main_lv);
        String[] data = {"111111", "22222", "3333", "444", "5555",
                "666666", "7777", "8888", "9999", "000000", "111111",
                "22222", "3333", "444", "5555", "666666", "7777", "8888",
                "9999", "000000"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);

    }

}
