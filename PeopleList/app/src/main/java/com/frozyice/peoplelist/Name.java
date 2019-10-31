package com.frozyice.peoplelist;

import android.widget.EditText;

import androidx.annotation.NonNull;

public class Name {

   private String FirstName;
   private String LastName;

   public Name (String firstName, String lastName)
   {
      FirstName = firstName;
      LastName = lastName;
   }

   public String getFirstName() {
      return FirstName;
   }

   public String getLastName() {
      return LastName;
   }

   public String toString()
   {
      return getFirstName() + " " + getLastName();
   }
}
