package com.example.practical2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Assignment2 extends AppCompatActivity {
private ListView listView_1;
    String[] listItem;
    TextView textView1;
    LinearLayout background_ListView_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);
        listView_1 = (ListView) findViewById(R.id.listView_1);
        listItem = getResources().getStringArray(R.array.colors_listView);
//        final LayoutInflater inflater = getLayoutInflater();
//        View view2 = inflater.inflate(R.layout.layout_for_simple_listview,null);
//        textView1 = view2.findViewById(R.id.textView_ForListItem);



        final ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this,R.layout.layout_for_simple_listview_1,R.id.textView_ForListItem1,listItem);
        listView_1.setAdapter(aa2);
        listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str1 = (String) listView_1.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),str1,Toast.LENGTH_LONG).show();
                background_ListView_1 = (LinearLayout) findViewById(R.id.background_ListView_1);
                if(str1.equals("Red")){
                    listView_1.setBackgroundColor(Color.parseColor("#ff0000"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#ff0000"));
                }
                else if(str1.equals("Yellow")){
                    listView_1.setBackgroundColor(Color.parseColor("#FCF800"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#FCF800"));
                }
                else if(str1.equals("Orange")){
                    listView_1.setBackgroundColor(Color.parseColor("#FE8200"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#FE8200"));
                }
                else if(str1.equals("Purple")){
                    listView_1.setBackgroundColor(Color.parseColor("#FB07D6"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#FB07D6"));
                }
                else if(str1.equals("Brown")){
                    listView_1.setBackgroundColor(Color.parseColor("#CA2B0E"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#CA2B0E"));
                }
                else if(str1.equals("black")){
                    listView_1.setBackgroundColor(Color.parseColor("#1E1D1D"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#1E1D1D"));
                }
                else if(str1.equals("Pink")){
                    listView_1.setBackgroundColor(Color.parseColor("#FB0881"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#FB0881"));
                }
                else if(str1.equals("Green")){
                    listView_1.setBackgroundColor(Color.parseColor("#04FC00"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#04FC00"));
                }
                else if(str1.equals("Blue")){
                    listView_1.setBackgroundColor(Color.parseColor("#0082FC"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#0082FC"));
                }
                else if(str1.equals("Gray")){
                    listView_1.setBackgroundColor(Color.parseColor("#949480"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#949480"));
                }
                else if(str1.equals("White")){
                    listView_1.setBackgroundColor(Color.parseColor("#ffffff"));
                    background_ListView_1.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                else {}



            }
        });
    }
}