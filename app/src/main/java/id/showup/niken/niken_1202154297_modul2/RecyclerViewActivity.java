package id.showup.niken.niken_1202154297_modul2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by nikenfebriani on 17/02/18.
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Menu;
    private ArrayList<String> Price;
    private ArrayList<Integer> Gambar;
    //Daftar Menu
    private String[] menu = {"Nasi Goreng", "Mie Goreng Spesial", "Mie Kuah Spesial", "Sate Madura", "Mie Kuah Upnormal", "Nasi Goreng Baawang"};
    //Daftar Harga
    private String[] price = {"15.000", "10.000", "10.000", "25.000", "30.000", "25.000"};
    //Daftar Gambar
    private int[] image = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
            R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Menu = new ArrayList<>();
        Price = new ArrayList<>();
        Gambar = new ArrayList<>();

        recyclerView= findViewById(R.id.recyclerview);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(Menu, Price, Gambar);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);

    }

    private void DaftarItem() {
        for (int w=0; w<menu.length; w++){
            Gambar.add(image[w]);
            Menu.add(menu[w]);
            Price.add(price[w]);
        }
    }
}