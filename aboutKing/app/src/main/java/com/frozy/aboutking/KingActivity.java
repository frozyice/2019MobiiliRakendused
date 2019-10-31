package com.frozy.aboutking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class KingActivity extends AppCompatActivity {

    private List<King> kings;
    private ListView kingList;
    private ArrayAdapter<King> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_king);

        kingList = findViewById(R.id.listKing);
        reset();
        registerForContextMenu(kingList);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        new MenuInflater(this).inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        King king = kings.get(menuInfo.position);
        switch (item.getItemId()){
            case R.id.king_menu:
                Toast.makeText(this, king.getKing(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.text_menu:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(king.getName());
                builder.setMessage(king.getText());
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_menu:
                remove();
                return true;

            case R.id.reset_menu:
                reset();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void remove() {
        SparseBooleanArray checkedItems = kingList.getCheckedItemPositions();
        if (checkedItems != null) {
            for (int i = checkedItems.size() -1; i >= 0; --i)
            {
                King king = kings.get(checkedItems.keyAt(i));
                adapter.remove(king);
            }
        }
        for (int i = 0; i < kingList.getCount(); i++)
            kingList.setItemChecked(i, false);
    }

    private void reset() {
        kings = (new Kings().getKings());
        kingList.setAdapter(adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, kings));
    }


}
