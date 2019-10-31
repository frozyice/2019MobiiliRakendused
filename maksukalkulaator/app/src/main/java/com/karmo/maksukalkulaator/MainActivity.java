package com.karmo.maksukalkulaator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calca = findViewById(R.id.btnOk);
        calca.setOnLongClickListener((new Button.OnLongClickListener()
        {

            @Override
            public boolean onLongClick(View view) {
                    ((EditText)findViewById(R.id.yhikuhind)).setText("");
                    ((EditText)findViewById(R.id.yhikutearv)).setText("");
                    ((EditText)findViewById(R.id.etVat)).setText("");
                    ((EditText)findViewById(R.id.etVatEx)).setText("");
                    ((EditText)findViewById(R.id.etVatInc)).setText("");
                    findViewById(R.id.yhikuhind).requestFocus();
                    return true;
            }

        }
        ));
    }

    public void onClear(View view) {
        ((EditText)findViewById(R.id.yhikuhind)).setText("");
        ((EditText)findViewById(R.id.yhikutearv)).setText("");
        ((EditText)findViewById(R.id.etVat)).setText("");
        ((EditText)findViewById(R.id.etVatEx)).setText("");
        ((EditText)findViewById(R.id.etVatInc)).setText("");
        findViewById(R.id.yhikuhind).requestFocus();
    }

    public void onOk(View view) {
        try {
            double price =Double.parseDouble(((EditText)findViewById(R.id.yhikuhind)).getText().toString());
            double items =Double.parseDouble(((EditText)findViewById(R.id.yhikutearv)).getText().toString());

            if (price > 0 && items > 0)
            {
                double excl = price*items;
                double vat = excl * 0.20;
                double incl = excl + vat;

                if (((RadioButton)findViewById(R.id.rbtnInVat)).isChecked())
                {
                    vat = excl * 0.2;
                    incl = excl;
                    excl -= vat;
                }
                ((EditText)findViewById(R.id.etVatEx)).setText(NumberFormat.getInstance().format(excl));
                ((EditText)findViewById(R.id.etVat)).setText(NumberFormat.getInstance().format(vat));
                ((EditText)findViewById(R.id.etVatInc)).setText(NumberFormat.getInstance().format(incl));
            }
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            displayExceptsionMessage(ex.getMessage());
        }
    }

    private void displayExceptsionMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
