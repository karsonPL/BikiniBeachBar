package co.gostyn.karson.bikinibeachbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by karol on 2017-04-19.
 */

public class MenuObjectsAdapter extends RecyclerView.Adapter<MenuObjectsAdapter.MenuObjectViewHolder> {

    private final MenuObject[] menuObjects;

    public MenuObjectsAdapter(MenuObject[] menuObjects) {
        this.menuObjects = menuObjects;
    }

    @Override
    public MenuObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuObjectViewHolder holder, int position) {

        MenuObject menuObject = menuObjects[position];
        holder.setMenuObject(menuObject);


    }

    @Override
    public int getItemCount() {
        return menuObjects.length;
    }

    class MenuObjectViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.itemMenuNazwa)
        TextView itemMenuNazwa;
        @Bind(R.id.itemMenuOpis)
        TextView itemMenuOpis;
        @Bind(R.id.itemMenuCena)
        TextView itemMenuCena;
        @Bind(R.id.itemMenuGfx)
        ImageView itemMenuGfx;

        private MenuObject menuObject;


        public MenuObjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        public void setMenuObject(MenuObject menuObject) {
            this.menuObject = menuObject;


//ladowanie danych z tablicy do widokow
            itemMenuNazwa.setText(menuObject.getNazwa());
            itemMenuOpis.setText(menuObject.getOpis());
            itemMenuCena.setText((menuObject.getCena()));

           Glide.with(itemMenuGfx.getContext())
                    .load(menuObject.getGfxPath())
                    .into(itemMenuGfx);


        }
    }


}
