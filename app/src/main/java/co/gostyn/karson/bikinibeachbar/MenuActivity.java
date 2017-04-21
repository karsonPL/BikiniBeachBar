package co.gostyn.karson.bikinibeachbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity  {

    public Intent intent;
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
    @Bind(R.id.drinkiRV)
    RecyclerView drinkiRV;


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


        MenuObject[] drinki = MenuObject.loadArrayFromJson(this, "drinki");
        drinkiRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        drinkiRV.setAdapter(new MenuObjectsAdapter(drinki));

     /*   drinkiRV.addOnItemTouchListener(
                new RecyclerTouchListener(this, drinkiRV,
                        new RecyclerTouchListener.OnTouchActionListener() {
                            @Override
                            public void onClick(View view, int position) { Log.d("BBB", "onItemClick: ");
                            }
                            @Override
                            public void onRightSwipe(View view, int position) { Log.d("BBB", "onItemClick: ");
                            }
                            @Override
                            public void onLeftSwipe(View view, int position) {Log.d("BBB", "onItemClick: ");
                            }
                        }));*/


       drinkiRV.addOnItemTouchListener(
                new RecyclerItemClickListener(this, drinkiRV ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.d("BBB", "onItemClick: " + position);

                       /* intent = new Intent(getSupportParentActivityIntent(), DrinkiActivity.class);

                        startActivity(intent);*/

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Log.d("BBB", "onItemClickLLLLL: " + position);
                    }
                })
        );


        MenuObject[] piwaButelkowe = MenuObject.loadArrayFromJson(this, "piwa_butelkowe");
        piwaButelkoweRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        piwaButelkoweRV.setAdapter(new MenuObjectsAdapter(piwaButelkowe));


        MenuObject[] napojeZimne = MenuObject.loadArrayFromJson(this, "napoje_zimne");
        napojeZimneRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeZimneRV.setAdapter(new MenuObjectsAdapter(napojeZimne));


        MenuObject[] napojeGorace = MenuObject.loadArrayFromJson(this, "napoje_gorace");
        napojeGoraceRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeGoraceRV.setAdapter(new MenuObjectsAdapter(napojeGorace));


        MenuObject[] fastFood = MenuObject.loadArrayFromJson(this, "fast_food");
        fastFoodRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        fastFoodRV.setAdapter(new MenuObjectsAdapter(fastFood));


    }


}
