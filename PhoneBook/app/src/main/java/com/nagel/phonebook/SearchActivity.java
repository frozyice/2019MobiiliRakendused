package com.nagel.phonebook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.util.Objects;

/* SearchActivity is also simple and is used to enter search criteria, code is executed in SQL SELECT, but using the class People. */
public class SearchActivity extends AppCompatActivity {
  private EditText etFname,etLname,etAddr,etTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    etFname = findViewById(R.id.etFname);
    etLname = findViewById(R.id.etLname);
    etAddr = findViewById(R.id.etAddr);
    etTitle = findViewById(R.id.etTitle);
  }

  public void onClear(View view)
  {
    etFname.setText("");
    etLname.setText("");
    etAddr.setText("");
    etTitle.setText("");
  }

  public void onSearch(View view)
  {
    String f_name = etFname.getText().toString().trim();
    String l_name = etLname.getText().toString().trim();
    String addr = etAddr.getText().toString().trim();
    String title = etTitle.getText().toString().trim();
    DBHelper dbHelper = new DBHelper(this);
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    People people = new People(db, f_name, l_name, addr, title);
    if (people.getPeople().size() == 0) {
      Toast.makeText(this, getResources().getString(R.string.ntf), Toast.LENGTH_LONG).show();
      db.close();
    }
    else if (people.getPeople().size() == 1) {
      Intent person = new Intent(this, PersonActivity.class);
      person.putExtra("person", people.getPeople().get(0));
      db.close();
      startActivity(person);
      finish();
    }
    else {
      Intent peopleIn = new Intent(this, PeopleActivity.class);
      peopleIn.putExtra("people", people);
      db.close();
      startActivity(peopleIn);
      finish();
    }
  }

  @Override
  public boolean onSupportNavigateUp(){
    finish();
    return true;
  }
}
