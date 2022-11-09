package com.example.practical2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Pra2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private Spinner spinner_num_type;
private EditText editTextForNum;
private Button Add_Btn;
private ListView listView123;
private Button nextToAssigement;
private AlertDialog.Builder builder;
    String str1 = "";
    String[] mobiletype = {"Home","Office","Public"};
    ArrayList<String> arrayList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pra2);
        builder = new AlertDialog.Builder(this);
        //list1 = new ArrayList<String>(Arrays.<String>asList(arrayList1));
        addMethodOnBTN();
        //******************************************************************************
        spinner_num_type = (Spinner) findViewById(R.id.spinner_num_type);
        spinner_num_type.setOnItemSelectedListener(this);
        ArrayAdapter mob_type = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mobiletype);
        mob_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_num_type.setAdapter(mob_type);
        //spinner_num_type.setPadding(3,3,3,5);
        //*******************************************************************************************
        nextToAssigement = findViewById(R.id.nextToAssigement);
        nextToAssigement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pra2.this,Assignment2.class);
                startActivity(intent);
            }
        });
        //*******************************************************************************************
    }
    public void addMethodOnBTN(){
        Add_Btn = (Button) findViewById(R.id.Add_Btn);
        Add_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextForNum = (EditText) findViewById(R.id.editTextForNum);
                if(editTextForNum.getText().toString().trim().length() == 10){
                    arrayList1.add(0,"Mobile No.: "+editTextForNum.getText().toString().trim()+"\n"+"Type is : "+str1);
                    showListMethod123();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter correct Mobile no.",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
//********************************************************************************************************
    public void showListMethod123(){
        listView123 = (ListView) findViewById(R.id.LV_1234);
        final ArrayAdapter<String> aa1 = new ArrayAdapter<String>(this,R.layout.layout_for_simple_listview,R.id.textView_ForListItem,arrayList1);
        listView123.setAdapter(aa1);
        listView123.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) listView123.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        });
    }
//***********************************************************************************************************************************************
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            str1 = adapterView.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //************************************************************************************************
    public void onBackPressed() {
        builder.setMessage("Do Want To Exit From Application?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();//code for creating alert Box.
        alert.setTitle("Go To Home Screen...");//
        alert.show();
//        back_prsssed = (back_prsssed + 1);
//        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
//        if (back_prsssed > 1) {
//            this.finish();
//        }
    }
    //*********************************************************************************************************************
}