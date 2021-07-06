package sg.edu.rp.c346.id20002288.myapplicationmsa;
//chengxile 20002288
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

import android.os.Bundle;

public class ItemListActivity extends AppCompatActivity {
Button add,delete,update;
EditText name,day,year,month,pos;
ListView lv;
Spinner spinner;




    ArrayList<String> productList;
    ArrayAdapter<String> arrayadaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        add=findViewById(R.id.btnadd);
        delete=findViewById(R.id.btndel);
        update=findViewById(R.id.btnupdate);

        name=findViewById(R.id.etname);
        year=findViewById(R.id.etyear);
        month=findViewById(R.id.etmonth);
        pos=findViewById(R.id.etpos);
        day=findViewById(R.id.etday);
        spinner=findViewById(R.id.spinner);




        lv=findViewById(R.id.lv);

        productList = new ArrayList<>();
        productList.add("Portable Charger"+ " Expires " + "2021"+ "-" + "05"+ "-" + "21");;
        productList.add("Wireless Charger"+ " Expires " + "2022"+ "-" + "11"+ "-" + "07");
        productList.add("Mechanical Keyboard"+ " Expires " + "2021"+ "-" + "03"+ "-" + "15");
        arrayadaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,productList);
        lv.setAdapter(arrayadaptor);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos.setVisibility(View.GONE);
                name.setVisibility(View.VISIBLE);
                year.setVisibility(View.VISIBLE);
                day.setVisibility(View.VISIBLE);
                month.setVisibility(View.VISIBLE);


                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String newyear=year.getText().toString();
                        String newname=name.getText().toString();
                        String newday=day.getText().toString();
                        String newmonth=month.getText().toString();

                        if(newyear!=null&&newname!=null&&newday!=null&&newmonth!=null){
                            String info=(newname+ " Expires " + newyear+ "-" + newmonth+ "-" + newday);
                            productList.add(info);
                            arrayadaptor.notifyDataSetChanged();
                            Collections.sort(productList);

                            year.setText(null);
                            name.setText(null);
                            month.setText(null);
                            day.setText(null);
                        }

                        else{
                            Toast.makeText(ItemListActivity.this,"Please enter all field",Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(productList.size()==0) {
                    Toast.makeText(ItemListActivity.this, "Nothing to Delete", Toast.LENGTH_LONG).show();
                }
                else{
                    name.setVisibility(View.GONE);
                    day.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    month.setVisibility(View.GONE);
                    pos.setVisibility(View.VISIBLE);
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int pos1 = Integer.parseInt(pos.getText().toString());
                            productList.remove(pos1-1);
                            arrayadaptor.notifyDataSetChanged();
                            pos.setText(null);


                            Toast.makeText(ItemListActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();

                        }
                    });

                }}
        });




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setVisibility(View.VISIBLE);
                day.setVisibility(View.VISIBLE);
                year.setVisibility(View.VISIBLE);
                month.setVisibility(View.VISIBLE);
                pos.setVisibility(View.VISIBLE);

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String updatename=name.getText().toString();
                        String updateday=day.getText().toString();
                        String updateyear=year.getText().toString();
                        String updatemonth=month.getText().toString();

                        int updatepos = Integer.parseInt(pos.getText().toString());

                        if(updatename!=null&&updateday!=null&&updateyear!=null&&updatemonth!=null&&updatepos!=0){
                            String updateinfo = (updatename + " Expires " +updateyear+  "-" + updatemonth + "-" + updateday);
                            productList.set(updatepos-1,updateinfo);
                            arrayadaptor.notifyDataSetChanged();


                            name.setText(null);
                            year.setText(null);
                            month.setText(null);
                            day.setText(null);

                            pos.setText(null);
                        }

                        else{
                            Toast.makeText(ItemListActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        Toast.makeText(ItemListActivity.this, "1 Month Selected", Toast.LENGTH_LONG).show();
                    case 2:
                        Toast.makeText(ItemListActivity.this, "3 Month Selected", Toast.LENGTH_LONG).show();
                    case 3:
                        Toast.makeText(ItemListActivity.this, "6 Month Selected", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}