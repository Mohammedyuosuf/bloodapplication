package com.example.blooddonation;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonatePage extends AppCompatActivity {
    DatabaseHelper mDb;

    EditText name, age,wight, blood, phone;
    Button insert19s, update19s, delete19s, view19s, clear19s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_page);

       mDb = new DatabaseHelper(this);

        //get the IDS of edittext
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        wight = (EditText) findViewById(R.id.wight);
        blood = (EditText) findViewById(R.id.blood);
        phone = (EditText) findViewById(R.id.phone);

        //get the ids for button
        insert19s = (Button) findViewById(R.id.insert19s);
        update19s = (Button) findViewById(R.id.update19s);
        delete19s = (Button) findViewById(R.id.delete19s);
        view19s = (Button) findViewById(R.id.view19s);
        clear19s = (Button) findViewById(R.id.clear19s);


        //define user defined methods
        addData();
        updateData();
        deleteData();
        viewData();
        clearData();



    }
    public void addData(){
        insert19s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean
                        insert=mDb.insertData(name.getText().toString(),age.getText().toString(),wight.getText().toString(),blood.getText().toString(),phone.getText().toString());
                if (insert==true)
                    Toast.makeText(DonatePage.this, "Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DonatePage.this,"Data Not Inserted",Toast.LENGTH_LONG).show();






            }
        });

    }
    public void updateData(){
        update19s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean
                        update=mDb.insertData(name.getText().toString(),age.getText().toString(),wight.getText().toString(),blood.getText().toString(),phone.getText().toString());
                if (update==true)
                    Toast.makeText(DonatePage.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DonatePage.this,"Data Not Updated",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void deleteData(){
        delete19s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer del=mDb.deleteData(phone.getText().toString());
                if (del>0)
                    Toast.makeText(DonatePage.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DonatePage.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void viewData(){
        view19s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor view=mDb.getAllData();
                if (view.getCount()==0)
                {
                    Toast.makeText(DonatePage.this, "Error", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer b=new StringBuffer();
                while (view.moveToNext())
                {
                    b.append("name:" + view.getString(0) + "\n");
                    b.append("age:" + view.getString(1) + "\n");
                    b.append("wight:" + view.getString(2) + "\n");
                    b.append("blood:" + view.getString(3) + "\n");
                    b.append("phone:" + view.getString(4) + "\n");
                }
                Toast.makeText(DonatePage.this,"Donater information",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void clearData(){
        clear19s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("Clear");
                age.setText("Clear");
                wight.setText("Clear");
                blood.setText("Clear");
                phone.setText("Clear");
            }
        });

    }
}
