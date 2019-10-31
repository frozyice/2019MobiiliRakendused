package com.nagel.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import android.view.*;

import java.util.Objects;

/* PeopleActivity displays a list of contacts found in the database, it’s a simple activity with a ListVew.
Clicking on a contact PersonActivity is shown. The Java code contains nothing regarding databases. */
public class PeopleActivity extends AppCompatActivity {

  private ArrayAdapter<Person> adapter;
  private ListView peopleList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_people);

    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    Intent intent = getIntent();
    People people = (People)intent.getSerializableExtra("people");

    peopleList = findViewById(R.id.lstPeople);
    peopleList.setAdapter(adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people.getPeople()));
    peopleList.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
      {
        showPerson(adapter.getItem(position));
      }
    });
  }

  private void showPerson(Person person)
  {
    Intent create = new Intent(this, PersonActivity.class);
    create.putExtra("person", person);
    startActivity(create);
    finish();
  }

  @Override
  public boolean onSupportNavigateUp(){
    finish();
    return true;
  }
}
