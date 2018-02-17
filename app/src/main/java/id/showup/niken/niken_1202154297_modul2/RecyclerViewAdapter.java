package id.showup.niken.niken_1202154297_modul2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nikenfebriani on 17/02/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> arrayListMenu; //Digunakan untuk Judul
    private ArrayList<String> arrayListsPrice; //Digunakan untuk Menu
    private ArrayList<Integer> gambar; //Digunakan untuk Image/Gambar

    //Membuat Konstruktor pada Class RecyclerViewAdapter
    RecyclerViewAdapter(ArrayList<String> arrayListMenu, ArrayList<String> arrayListsPrice, ArrayList<Integer> gambar) {
        this.arrayListMenu = arrayListMenu;
        this.arrayListsPrice = arrayListsPrice;
        this.gambar = gambar;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView menu, price;
        private ImageView gambar;
        private LinearLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            menu = itemView.findViewById(R.id.txtViewMenu);
            price = itemView.findViewById(R.id.txtViewPrice);
            gambar = itemView.findViewById(R.id.imageView);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_daftar_menu, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String menu = arrayListMenu.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        final String price = arrayListsPrice.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        final Integer image = gambar.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        holder.menu.setText(menu);
        holder.price.setText("Harga Rp. " + price);
        holder.gambar.setImageResource(image); // Mengambil gambar sesuai posisi yang telah ditentukan
        //Membuat Aksi Saat Judul Pada List ditekan
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Membuat Aksi Saat List Ditekan
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuDetail.class);
                String komposisi;
                switch (position) {
                    case 0:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Nasi, Ayam Bakar, Lalapan";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Cream Soup, Ayam, Jamur";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Coffee, Buah Berry, White Cream";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Gule Cumi, Santan, Nasi";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Jus, Guava, ice";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Nasi, Kecap, daging sapi pilihan";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListMenu.size();
    }
}