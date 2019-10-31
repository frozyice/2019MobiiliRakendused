package com.nagel.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import android.view.*;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import java.util.*;

/* Is used to display contact details, but also used to create new contacts, edit existing contacts, and
delete contacts.
The class defines several variables, but for the sake of the code, the most important are
the first two, which define a Zipcode and a Person object, respectively. The other variables
are components in the user interface and are initialized in onCreate(). When the relevant
activity is opened, a parameter is transferred, either a Zipcode object (if you want to create
a new contact) or a Person object (if you want to view or edit a contact). */
public class PersonActivity extends AppCompatActivity {

  private Zipcode zipcode = null;
  private Person person = null;

  private EditText etZip,etFname,etLname,etAddr,etPhone,etMail,etDate,etTitle, etDescription;

    /* onCreate() starts
    by referencing a Zipcode object, and if this reference is not null, it is a Zipcode object that
    has been transferred and the variable zipcode is initialized (while the variable person is still
    null). Next, the field txtDate is set to date, as this field must contain the date of last change
    of the contact. If obj is zero, it is because the transferred parameter is a Person object, and
    the variable person is then initialized with this object. It is the object to be displayed in the
    user interface, and all fields are initialized with the object’s values. Finally, note that the
    txtDate and txtZip fields are read-only as these fields can not be changed. */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_person);

    Intent intent = getIntent();

    etFname = findViewById(R.id.etFname);
    etLname = findViewById(R.id.etLname);
    etAddr = findViewById(R.id.etAddr);
    etPhone = findViewById(R.id.etPhone);
    etMail = findViewById(R.id.etMail);
    etDate = findViewById(R.id.etDate);
    etTitle = findViewById(R.id.etTitle);
    etZip = findViewById(R.id.etZip);
    etDescription = findViewById(R.id.etDescription);

    Object object = intent.getSerializableExtra("zipcode");
    if (object != null) {
      zipcode = (Zipcode) object;
      Calendar cal = Calendar.getInstance();
      etDate.setText(String.format(Locale.getDefault(),"%02d-%02d-%d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR)));
    }
    else
    {
      person = (Person)intent.getSerializableExtra("person");
      etFname.setText(person.getFirstname());
      etLname.setText(person.getLastname());
      etAddr.setText(person.getAddress());
      etPhone.setText(person.getPhone());
      etMail.setText(person.getMail());
      etDate.setText(person.getDate());
      etTitle.setText(person.getTitle());
      zipcode = person.getZipcode();
      etDescription.setText(person.getDescription());
    }
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    etZip.setText(zipcode.toString());
    disable(etDate);
   // disable(etZip); //TODO:not disabled
  }

  /* adds a back button to the ACTIONBAR*/
  @Override
  public boolean onSupportNavigateUp(){
    finish();
    return true;
  }

  /* onOkay() tests whether a first name has been entered (it is assumed that a contact must have
    a first name). If so, the handler determines the other values entered in the user interface,
    and then create an object that represents the database. Here you must note the syntax as
    well as the database is writeable. Next, a ContentValue object is created containing
    the values to be written to the database, whether it is because a new row must be created
    or it is an existing row to be updated. Note again the syntax and note how to refer to the
    individual columns using the constants defined in the class DbHelper. Next, the variable
    person is tested, and if it is null, it is an INSERT and otherwise it should be an UPDATE.
    Basically, it happens the same way, in the one case, you use the method insert() method,
    while in the second case, you use the method update(), except that in the latter case you
    should specify a WHERE part. */
  public void onOk(View view)
  {
    String fname = etFname.getText().toString().trim();
    if (fname.length() > 0)
    {
      String lname = etLname.getText().toString().trim();
      String addr = etAddr.getText().toString().trim();
      String phone = etPhone.getText().toString().trim();
      String mail = etMail.getText().toString().trim();
      String date = etDate.getText().toString().trim();
      String title = etTitle.getText().toString().trim();
      String description = etDescription.getText().toString().trim();
      String zipcodeFromCell = etZip.getText().toString().trim(); //added
      //add string value to object var
      zipcode.setCode(zipcodeFromCell);

      DBHelper dbHelper = new DBHelper(this);
      SQLiteDatabase db = dbHelper.getWritableDatabase();

      ContentValues values = new ContentValues(8);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_FIRSTNAME], fname);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_LASTNAME], lname);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_ADDRESS], addr);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_CODE], zipcode.getCode());
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_PHONE], phone);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_MAIL], mail);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_TITLE], title);
      values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_DESCRIPTION], description);

      if (person == null)
      {
        values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_DATE], date);
        db.insert(DBHelper.ATABLE_NAME, null, values);
      }
      else
      {
        Calendar cal = Calendar.getInstance();
        values.put(DBHelper.ATABLE_COLUMNS[DBHelper.ACOLNO_DATE], String.format(Locale.getDefault(),"%02d-%02d-%d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR)));
        String[] args = { "" + person.getId() };
        db.update(DBHelper.ATABLE_NAME, values, "id = ?", args);
      }
      db.close();
      onSupportNavigateUp();
    }
  }

  public void onRemove(View view)
  {
    if (person != null)
    {
      DBHelper dbHelper = new DBHelper(this);
      SQLiteDatabase db = dbHelper.getWritableDatabase();
      String[] args = { "" + person.getId() };
      db.delete(DBHelper.ATABLE_NAME, "id = ?", args);
      db.close();
      onSupportNavigateUp();
    }
  }

  private void disable(EditText view)
  {
    view.setKeyListener(null);
    view.setEnabled(false);
  }
}
