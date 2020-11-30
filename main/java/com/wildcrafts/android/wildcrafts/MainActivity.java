package com.wildcrafts.android.wildcrafts;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private mainAdapter adapter;

    private DrawerLayout mDrawerLayout;

    /*
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.activity_main_appbar, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler1);
        adapter=new mainAdapter(this ,getData());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return layout;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        adapter=new mainAdapter(this ,getData());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
       /*  TextView t2 = (TextView) findViewById(R.id.collapsing_container);
       CoordinatorLayout cl= (CoordinatorLayout) findViewById(R.id.cl);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) t2.getLayoutParams();
         t2.setLayoutParams(params);
*/
/*
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                // Make sure scrolling has stopped before snapping

            }
            });
*/
    }

    public static  List<data> getData(){
        List<data> appleData = new ArrayList<>();
        int icons []={R.drawable.men,R.drawable.women,R.drawable.kids,R.drawable.beauty,R.drawable.sale,
                R.drawable.homefurnishing,R.drawable.kitchenware,R.drawable.furniture};
        String[] titles={"Men","Women","Kids & Babies","Beauty","Sale","Home Furnishing","Kitchenware","Furniture"};
        String[] subTitles={"Clothing, Shoes, Bags, Watches","Clothing, Shoes, Bags, Jewellery & Watches","Girls, Boys, Toys, Sale","Beauty, Appliances, Makeup, Skin care","Men, Women, Kids, Baby",
                "Bath, Home Decor, Home Textile, Sale","Glassware, Tableware, Coffee, Mugs, Sale","Bean Bags, Shelves, Sofas, Wardroves, Stools"};
        for(int i=0;i<icons.length && i<titles.length && i<subTitles.length;i++){
            data current = new data();
            current.listImage=icons[i];
            current.listTitle=titles[i];
            current.listSubTitle=subTitles[i];
            current.ll=icons[i];
            appleData.add(current);

        }
    return  appleData;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

}
