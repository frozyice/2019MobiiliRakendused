package com.nagel.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import java.util.*;

public class MainActivity extends AppCompatActivity {

  private People people;
  private Zipcodes zipcodes;

  private SQLiteDatabase db;
  private DBHelper dbHelper;

  private ListView lstCodes;
  private EditText etCode, etCity;
  private ArrayAdapter<Zipcode> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dbHelper = new DBHelper(this);
    db = dbHelper.getReadableDatabase();

    zipcodes = new Zipcodes(db);
    lstCodes = findViewById(R.id.lstCodes);
    etCode = findViewById(R.id.etCode);
    etCity = findViewById(R.id.etCity);

    registerForContextMenu(lstCodes);
    displayCodes("", "");
  }
  //creating context menu for list
  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
  {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.context_menu, menu);
  }
  //context menu item click
  @Override
  public boolean onContextItemSelected(MenuItem item)
  {
    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
    Zipcode zipcode = adapter.getItem(menuInfo.position);
    switch (item.getItemId()) {
      case R.id.show:
        showPersons(zipcode);
        return true;
      case R.id.create:
        createPerson(zipcode);
        return true;
      default:
        return super.onContextItemSelected(item);
    }
  }

  private void createPerson(Zipcode zipcode)
  {
    Intent create = new Intent(this, PersonActivity.class);
    create.putExtra("zipcode", zipcode);
    startActivity(create);
  }

  private void showPersons(Zipcode zipcode)
  {
    people = new People(db, zipcode);
    if (people.getPeople().size() == 0) {
      Toast.makeText(this, getResources().getString(R.string.ntf), Toast.LENGTH_LONG).show();
    }
    else if (people.getPeople().size() == 1) {
      Intent person = new Intent(this, PersonActivity.class);
      person.putExtra("person", people.getPeople().get(0));
      startActivity(person);
    }
    else {
      Intent people = new Intent(this, PeopleActivity.class);
      people.putExtra("people", this.people);
      startActivity(people);
    }
  }
  //main menu
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu,menu);
    return true;
  }
  //main menu item click
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.search){
      Intent search = new Intent(getApplicationContext(), SearchActivity.class);
      startActivity(search);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  //clear button action
  public void onClear(View view)
  {
    etCode.setText("");
    etCity.setText("");
  }
  //displaying zipcodes in list
  public void displayCodes(String code, String city) {
    lstCodes.setAdapter(adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCodes(code, city)));
  }
  //getting codes and citys
  public List<Zipcode> getCodes(String code, String city) {
    List<Zipcode> zipcodeList = new ArrayList();
    for (Zipcode zipcode : zipcodes.getZipcodes())
      if (zipcode.getCode().startsWith(code) && zipcode.getCity().contains(city)) zipcodeList.add(zipcode);
    return zipcodeList;
  }
  // search button click uses displaycodes method that get parameters from editext fields
  public void onSearch(View view)
  {
    displayCodes(etCode.getText().toString(), etCity.getText().toString());
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    db.close();
  }
}
