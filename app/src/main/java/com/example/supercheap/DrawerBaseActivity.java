package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.supercheap.AddComment.AddCommentActivity;
import com.example.supercheap.Classes.User;
import com.example.supercheap.CreateCart.CreateCart;
import com.example.supercheap.DeleteProduct.DeleteProductsActivity;
import com.example.supercheap.DeleteSale.DeleteSale;
import com.example.supercheap.DisplayCheapestSupers.MainPageDisplay;
import com.example.supercheap.GetSuperInfo.GetSuperInfoActivity;
import com.example.supercheap.Manager.ManagerPage;
import com.example.supercheap.MyAccount.MyAccountActivity;
import com.example.supercheap.MySuper.MySuperActivity;
import com.example.supercheap.Sale.SaleView;
import com.example.supercheap.SignIn.SigninActivity;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    public User user;

    @Override
    public void setContentView(View view) {
        user = (User) getIntent().getParcelableExtra("user1");
        if (user.getIs_manager()) {
            drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_manager, null);
        } else {
            drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_user, null);
        }
        FrameLayout container = drawerLayout.findViewById(R.id.activityConainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        Intent intent;
        switch (item.getItemId()) {
            case (R.id.manager_page):

                intent = new Intent(this, ManagerPage.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,ManagerPage.class));

                overridePendingTransition(0, 0);
                break;
            case (R.id.create_cart):
                intent = new Intent(this, CreateCart.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,CreateCart.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.my_cart):
                intent = new Intent(this, MyCart.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,MyCart.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.add_comment):
                intent = new Intent(this, AddCommentActivity.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.get_super_info):
                intent = new Intent(this, GetSuperInfoActivity.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.DeleteItem):
                intent = new Intent(this, DeleteProductsActivity.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.delete_sale):
                intent = new Intent(this, DeleteSale.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.do_sale):
                intent = new Intent(this, SaleView.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.my_account):
                intent = new Intent(this, MyAccountActivity.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.my_super):
                intent = new Intent(this, MySuperActivity.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.Display_Cheap_Supers):
                intent = new Intent(this, MainPageDisplay.class);
                intent.putExtra("user1", user);
                startActivity(intent);
//                startActivity(new Intent(this,SigninActivity.class));
                overridePendingTransition(0, 0);
                break;
            case (R.id.logout):
                AlertDialog.Builder add_dial = new AlertDialog.Builder(DrawerBaseActivity.this);
                add_dial.setMessage("Log out? ").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                        logout();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alert = add_dial.create();
                alert.setTitle("Finish Cart");
                alert.show();


            break;
        }
        return false;
    }

    private void logout() {
        Intent intent;
        intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    protected void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }
}