package com.example.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView actxtView;

//    int [] arrNo = new int[]{1,2,3,4,5}; // and we can add the data into the List through the Array but when we know we hava fixed size of data.
    // For List
    ArrayList<String> cityNames = new ArrayList<>();// therefore we used the ArrayList because it is variable size

    // For Spinner -> Spinner is like a dropdown
    ArrayList<String> arrIds = new ArrayList<>();

    // For AutoCompleteTextView -> it is just like a EditTextView
    ArrayList<String> languages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listview);// for List
        spinner = findViewById(R.id.spinner);  // for Spinner
        actxtView = findViewById(R.id.actxtView); // for AutoCompleteTexView

        // List

        // add the data in the ArrayList
        cityNames.add("1.   Bangalore");
        cityNames.add("2.   Guru gram");
        cityNames.add("3.   Noida");
        cityNames.add("4.   Mumbai");
        cityNames.add("5.   Ladakh");
        cityNames.add("6.   Jammu & Kashmir");
        cityNames.add("7.   TungNath Temple");
        cityNames.add("8.   Manali");
        cityNames.add("9.   Himachal Pradesh");
        cityNames.add("10.  Dehradun");
        cityNames.add("11.  Kerla");
        cityNames.add("12.  RishiKesh");
        cityNames.add("13.  Kedarnath");
        cityNames.add("14.  BadriNath");
        cityNames.add("15.  Shimla");
        cityNames.add("16.  Hyderabad");
        cityNames.add("17.  Atal Tanal");
        cityNames.add("18.  Delhi");
        cityNames.add("19.  Tamilnadu");
        cityNames.add("20.  RajKot");
        cityNames.add("21.  Naenital");


        // ArrayAdapter used to put the according their index like 0,1,2...so on
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,cityNames);
        listView.setAdapter(arrayAdapter);// this is set the data

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "First City Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // For Spinner
        arrIds.add("Adhar Card");
        arrIds.add("PAN Card");
        arrIds.add("Driving License Card");
        arrIds.add("Rashan Card");
        arrIds.add("Voter Id Card");
        arrIds.add("Xth Score Card");
        arrIds.add("XIIth Score Card");

        ArrayAdapter<String> arrAdapSpinner = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(arrAdapSpinner);


        // For

        languages.add("JAVA");
        languages.add("C++");
        languages.add("C");
        languages.add("HTML");
        languages.add("C#");
        languages.add("CSCRIPT");
        languages.add("JAVASCIPT");
        languages.add("RUBY");
        languages.add("PHP");
        languages.add("XML");
        languages.add("CSS");
        languages.add("KOTLIN");

        ArrayAdapter autoComplete = new ArrayAdapter(this, android.R.layout.simple_list_item_1,languages);
        actxtView.setAdapter(autoComplete); // this is also put the data into the AutoCompleteTextView
        actxtView.setThreshold(1);// it used to, how many character letter it show you suggestion to fill into the EditText/AutoCompleteTextView


    }

}