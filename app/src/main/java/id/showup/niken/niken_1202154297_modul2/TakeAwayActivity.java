package id.showup.niken.niken_1202154297_modul2;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TakeAwayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
        Toast.makeText(this, "Take Away", Toast.LENGTH_LONG).show();
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day){
        //perhitungan tanggal dan bulannya dimulai dari 0 makanya harus di plus 1
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        //menggabungkan string ke tanggal
        String datemessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, datemessage, Toast.LENGTH_LONG).show();
    }

    public void processTimePickerResult(int hourOfDay, int minute){
        //convert waktu yang tadinya ke integer diubah ke string
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        //menggabungkan string ke waktu
        String timemessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, timemessage, Toast.LENGTH_LONG).show();
    }

    public void Pilih(View view) {
        Intent intent = new Intent(TakeAwayActivity.this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
