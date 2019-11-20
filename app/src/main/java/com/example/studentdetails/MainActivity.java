package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnsave;
    RadioGroup rdoG;
    EditText etName;
    RadioButton rdobtn;
    RadioButton rdomale,rdofemale,rdoothers;
    Spinner country;
    TextView tvoutput;

    private Spinner spinCountry;
    private AutoCompleteTextView Auto;
    private String[] Batch = {"22A","22B","22C"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinCountry = findViewById(R.id.sCountry);
        Auto = findViewById(R.id.actvBatch);
        etName = findViewById(R.id.etName);
        rdoG = findViewById(R.id.rdoGroup);
        btnsave = findViewById(R.id.btnSave);
        tvoutput = findViewById(R.id.tvOutput);


        String countries[] = {"Nepal","India","China","UK","USA"};
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spinCountry.setAdapter(adapter);

        ArrayAdapter stringArray = new ArrayAdapter(
                this,
                android.R.layout.select_dialog_item,
                Batch
        );
        Auto.setAdapter(stringArray);
        Auto.setThreshold(1);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText())){
                    etName.setError("Enter Name");
                    return;
                }

                String Name;

                Name = etName.getText().toString();

                String Text = spinCountry.getSelectedItem().toString();

                String Batch = Auto.getText().toString();

                int selectedId = rdoG.getCheckedRadioButtonId();

                rdobtn = findViewById(selectedId);

                String value = rdobtn.getText().toString();

                tvoutput.setText(Name);
                tvoutput.append(System.getProperty("line.separator"));
                tvoutput.append(value);
                tvoutput.append(System.getProperty("line.separator"));
                tvoutput.append(Text);
                tvoutput.append(System.getProperty("line.separator"));
                tvoutput.append(Batch);


            }
        });


    }
}
