package com.project.gemastik.reminder.impian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.gemastik.reminder.R;

import java.util.ArrayList;

public class AddImpianActivity extends AppCompatActivity {

    LinearLayout layoutList;
    TextView addList;
    CardView btnSimpan;
    ArrayList<KebiasaanItem> itemList = new ArrayList<>();
    ArrayList<ImpianItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_impian);

        layoutList = findViewById(R.id.layout_list);
        addList = findViewById(R.id.btnTambahList);
        btnSimpan = findViewById(R.id.btnsimpan_impian);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListHabits();
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkNullData()){
                    Intent intent = new Intent(AddImpianActivity.this, AktifFragment.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list",itemList);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean checkNullData(){
        boolean result = true;

        for (int i = 0; i < layoutList.getChildCount();i++){
            View layoutView = layoutList.getChildAt(i);

            EditText impian = layoutView.findViewById(R.id.edt_habits);

            KebiasaanItem item = new KebiasaanItem();

            if (!impian.getText().toString().equals("")){
                item.setTextHabits(impian.getText().toString());
            } else {
                result = false;
                break;
            }

            itemList.add(item);
        }

        if (itemList.size() == 0){
            result = false;
            Toast.makeText(this,"Isi data!",Toast.LENGTH_SHORT).show();
        } else if (!result){
            Toast.makeText(this,"Isi semua data!",Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addListHabits(){
        final View habitsView = getLayoutInflater().inflate(R.layout.add_layout_habits,null,false);

        EditText editText = habitsView.findViewById(R.id.edt_habits);
        ImageButton imageButton = habitsView.findViewById(R.id.close_habits);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(habitsView);
            }
        });

        layoutList.addView(habitsView);
    }

    private void removeView(View view){
        layoutList.removeView(view);
    }
}
