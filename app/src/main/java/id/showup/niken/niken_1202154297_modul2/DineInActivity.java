package id.showup.niken.niken_1202154297_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DineInActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String mSpinnerlabel = "";
    Button pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
        Toast.makeText(this, "Dine In", Toast.LENGTH_LONG).show();

        //mengambil id
        spinner = (Spinner) findViewById(R.id.SpNoMeja);

        //disini kita membuat sebuah fungsi agar data resource untuk spinnernya bisa muncul ketika di drop down
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.SpNoMeja, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //disini kita mengecek apakah spinner itu kosong atau tidak kalau ada isinya makanya datanya bisa didrop down
        if (spinner != null){
            spinner.setAdapter(adapter);
        }

        pesan = findViewById(R.id.btn_pesan);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meja = spinner.getSelectedItem().toString();
                if (meja != null){
                    Intent intent = new Intent(DineInActivity.this, RecyclerViewActivity.class);
                    Toast.makeText(v.getContext(), meja + " Telah Terpilih", + Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerlabel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
