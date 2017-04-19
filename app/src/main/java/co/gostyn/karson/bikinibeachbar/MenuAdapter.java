package co.gostyn.karson.bikinibeachbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by karol on 2017-04-19.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuAdapterHolder> {

    private final Menu[] menus;

    public MenuAdapter(Menu[] menus) {
        this.menus = menus;
    }

    @Override
    public MenuAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapterHolder holder, int position) {

        Menu menu = menus[position];
        holder.setMenu(menu);
        

    }

    @Override
    public int getItemCount() {
        return menus.length;
    }

    class MenuAdapterHolder extends RecyclerView.ViewHolder {

        @Bind (R.id.item_menu_nazwa)
        TextView itemMenuNazwa;
        @Bind (R.id.item_menu_opis)
        TextView itemMenuOpis;
        @Bind (R.id.item_menu_cena)
        TextView itemMenuCena;

        private Menu menu;



        public MenuAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        public void setMenu(Menu menu) {
            this.menu = menu;


//ladowanie danych z tablicy do widokow
            itemMenuNazwa.setText(menu.getNazwa());
            itemMenuOpis.setText(menu.getOpis());
            itemMenuCena.setText((menu.getCena()));
            



        }
    }



}
