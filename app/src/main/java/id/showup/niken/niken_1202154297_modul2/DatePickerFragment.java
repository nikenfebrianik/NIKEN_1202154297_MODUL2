package id.showup.niken.niken_1202154297_modul2;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

@SuppressLint("ValidFragment")
class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //sebagai default date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //menginstance datepicker dialog dan mengembalikannya
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //mengubah tanggalnya ke string
        //mengeset activity ke takeAwayActivity
        TakeAwayActivity takeAway = (TakeAwayActivity) getActivity();
        //memerintahkan takeAway untuk memproses processDatePickerResult() method
        takeAway.processDatePickerResult(year, month, day);
    }

}
