package com.frozy.englishkings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<King> kings = (new Kings()).getKings();
    private TextView from, to;
    private ListView kingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = findViewById(R.id.textFrom);
        to = findViewById(R.id.textTo);
        kingList = findViewById(R.id.lstKings);

        kingList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, kings));
        kingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                update(position);

            }
        });
    }

    private void update(int position) {
        int a = kings.get(position).getFrom();
        int b = kings.get(position).getTo();
        from.setText(a == 0 ? "" : "" + a);
        to.setText(b == 9999 ? "" : "" + b);
    }
}
