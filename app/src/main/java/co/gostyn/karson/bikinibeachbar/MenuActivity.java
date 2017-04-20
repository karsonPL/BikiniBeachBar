package co.gostyn.karson.bikinibeachbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.napojeGoraceRV)
    RecyclerView napojeGoraceRV;
    @Bind(R.id.napojeZimneRV)
    RecyclerView napojeZimneRV;
    @Bind(R.id.fastFoodRV)
    RecyclerView fastFoodRV;
    @Bind(R.id.piwaButelkoweRV)
    RecyclerView piwaButelkoweRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        //ustawienie Toolbara lub w layout app:navigationIcon="?attr/homeAsUpIndicator"
        setSupportActionBar(mToolbar);
      /*  mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });*/


        //ladowanie tablicy pjedynczej i wyswietlanie w RecycleView
        MenuObject[] napojeGorace = MenuObject.loadArrayFromJson(this, "napoje_gorace");
        napojeGoraceRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeGoraceRV.setAdapter(new MenuObjectsAdapter(napojeGorace));

        MenuObject[] napojeZimne = MenuObject.loadArrayFromJson(this, "napoje_zimne");
        napojeZimneRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeZimneRV.setAdapter(new MenuObjectsAdapter(napojeZimne));

        MenuObject[] fastFood = MenuObject.loadArrayFromJson(this, "fast_food");
        fastFoodRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        fastFoodRV.setAdapter(new MenuObjectsAdapter(fastFood));

        MenuObject[] piwaButelkowe = MenuObject.loadArrayFromJson(this, "piwa_butelkowe");
        piwaButelkoweRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        piwaButelkoweRV.setAdapter(new MenuObjectsAdapter(piwaButelkowe));


    }
}
