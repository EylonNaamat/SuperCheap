package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.supercheap.Classes.User;
import com.example.supercheap.Manager.ManagerPage;
import com.example.supercheap.SignIn.SigninActivity;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    public User user;
    @Override
    public void setContentView(View view) {
        user = (User) getIntent().getParcelableExtra("user1");
        if (user.getIs_manager())
        {
            drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_manager, null);
        }else{
            drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_user, null);
        }
        FrameLayout container =drawerLayout.findViewById(R.id.activityConainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar =drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView =drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        Intent intent;
        switch (item.getItemId()) {
            case(R.id.manager_page):

                intent = new Intent(this, ManagerPage.class);
                intent.putExtra("user1",user);
                startActivity(intent);
//                startActivity(new Intent(this,ManagerPage.class));

                overridePendingTransition(0,0);
                break;
            case(R.id.create_cart):
                intent = new Intent(this,CreateCart.class);
                intent.putExtra("user1",user);
                startActivity(intent);
//                startActivity(new Intent(this,CreateCart.class));
                overridePendingTransition(0,0);
                break;
            case(R.id.my_cart):
                intent = new Intent(this,MyCart.class);
                intent.putExtra("user1",user);
                startActivity(intent);
//                startActivity(new Intent(this,MyCart.class));
                overridePendingTransition(0,0);
                break;
            case(R.id.logout):
                intent = new Intent(this, SigninActivity.class);
//                intent.putExtra("user1",user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0,0);
                break;
        }
        return false;
    }
        protected void  allocateActivityTitle(String titleString){
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(titleString);
        }
        }
}