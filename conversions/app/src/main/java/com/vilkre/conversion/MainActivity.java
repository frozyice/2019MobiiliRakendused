package com.vilkre.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
//asa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText userValue = findViewById(R.id.etUserInput);
        if (view.getId() == R.id.btnClear)
        {
            userValue.setText("");
        }
        else if (view.getId() == R.id.btnConvert)
        {
            RadioButton miles = findViewById(R.id.rdbMiles);

            if (userValue.getText().length() == 0)
            {
                Toast.makeText(this, getResources().getString(R.string.toast), Toast.LENGTH_LONG).show();
                return;
            }
            double value = Double.parseDouble(userValue.getText().toString());
            if(miles.isChecked())
                userValue.setText(String.valueOf(converter.toKM(value)));
            else userValue.setText(String.valueOf(converter.toMiles(value)));
        }
    }
}
