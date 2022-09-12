package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.midi.MidiDeviceService;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvmonhoc;
    EditText edt_name;
    Button btnthem,btnxoa,btncapnhat;
    int vitri = -1;
    ArrayList<String> arrayCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Việt Nam");
        arrayCourse.add("Lào");
        arrayCourse.add("Thái Lan");
        arrayCourse.add("Indonesia");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse);
        lvmonhoc.setAdapter(adapter);

        lvmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0){
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }
                if(i==1){
                    startActivity(new Intent(MainActivity.this,MainActivity3.class));
                }
                if(i==2){
                    startActivity(new Intent(MainActivity.this, MainActivity4.class));
                }
                if(i==3){
                    startActivity(new Intent(MainActivity.this, MainActivity5.class));
                }
                return false;//su ly o day nua

            }
        });
        //them
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                arrayCourse.add(name);
                adapter.notifyDataSetChanged();
            }
        });
        // xoa
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0 ;i<arrayCourse.size();i++){
                    String namexoa=edt_name.getText().toString();
                    if(arrayCourse.get(i).equals(namexoa)){
                        arrayCourse.remove(i);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"Xóa thành công !",Toast.LENGTH_SHORT).show();
                        break;

                    }else{
                        Toast.makeText(MainActivity.this,"Chưa chọn nước cần xóa !",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Button cap nhat
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_name.setText(arrayCourse.get(i));
                vitri = i;

            }
        });
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edt_name.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    //anh xa
    private void addControls() {
        lvmonhoc =(ListView) findViewById(R.id.lvmonhoc);
        edt_name= (EditText) findViewById(R.id.edt_name);
        btnthem =(Button) findViewById(R.id.btnthem);
        btnxoa = (Button) findViewById(R.id.btnxoa);
        btncapnhat = (Button) findViewById(R.id.btncapnhat);

    }
}