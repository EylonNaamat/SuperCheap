package com.example.supercheap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supercheap.Classes.Comment;
import com.example.supercheap.Classes.Super;
import com.example.supercheap.Classes.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.UnknownServiceException;
import java.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {
    private DatabaseReference databasereference;
    private User user;
    private Super new_super;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databasereference =FirebaseDatabase.getInstance().getReference();

    }

    public void full_supers(View v) {
//        v.setEnabled(false);
////        Log.d("success", "button disabled");
//        Button b = (Button) v; // casting to a button
//        b.setText("Disabled"); // changing text on button

//        View myView = findViewById(R.id.SignUpButton);
//        myView.setEnabled(false);
//        Button button = (Button)myView;
//        button.setText("new disabled");

//        String[] city_names = {"Afula", "Akko", "Arad", "Ariel", "Ashdod", "Ashkelon", "Bat Yam", "Beer Sheva", "Beit Shean", "Beit Shemesh", "Betar Illit"
//                , "Jerusalem", "Karmiel", "Kfar Sava", "Kiryat Ata", "Kiryat Bialik", "Kiryat Gat", "Kiryat Malachi", "Kiryat Motzkin", "Lod"
//                , "Maale Adumim", "Migdal HaEmek", "Modiin", "Nahariya", "Nazareth", "Nes Ziona", "Netanya", "Ofakim", "Raanana", "Ramat-Gan", "Rehovot"
//                , "Rishon Lezion", "Sderot", "Tel Aviv", "Tiberias", "Yokneam"};
        String[] city_names = {"Ariel","Tel Aviv","Beer Sheva", "Beit Shean", "Beit Shemesh","Jerusalem","Maale Adumim"};
        String[] super_names = {"AM:PM", "Merkaza", "osher ad", "king stor", "bar col", "victory", "zol vbdsol", "hazi hinam", "yenot bitan"
                , "mega", "mahsani a shook", "mahsani hazi hinam", "mahsani lav", "betiv hasad", "super yuda", "pikanti", "preshmarket", "rami levi"
                , "yohananof", "shofer sal"};
        String[] username = {"ben", "eylon", "yossi", "michael", "mor", "rotem", "mosh", "ran", "amit", "tomer", "noam", "yona", "sapir", "yakov", "shaked"};

        String[] temp_super_ids = new String[70];
        Random rn = new Random();
        for (int i = 0; i < 70; i++) {
            int city_place =(rn.nextInt(city_names.length));
            String temp_city = city_names[city_place];
            int name_place = (rn.nextInt(super_names.length));
            String temp_name = super_names[name_place];
            String temp_id = UUID.randomUUID().toString();
            temp_super_ids[i]=temp_id;
            HashMap<String, HashMap<String, Double>> temp_prod = new HashMap<>();
            this.new_super = new Super(temp_id, temp_name, temp_city, temp_prod, new HashMap<String, Comment>(), 0, 2.5);
            this.databasereference = FirebaseDatabase.getInstance().getReference();
            DatabaseReference curr_databasereference2 = databasereference.child("Supers");
            curr_databasereference2.child(this.new_super.getSuper_ID()).setValue(this.new_super);

            int answer = rn.nextInt(100000) ;
            int username_place = rn.nextInt(username.length) ;
            String temp_username = username[username_place] + answer;
            this.user = new User("aaa", "aaa", "yako@gmail.com", temp_username, "12345", "aaa", "12/12/12", "Male", true, this.new_super.getSuper_ID());
            this.databasereference = FirebaseDatabase.getInstance().getReference();
            DatabaseReference curr_databasereference1 = databasereference.child("users");

            curr_databasereference1.child(this.user.getUsername()).setValue(this.user)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("try", "good");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("try", "bad");
                        }
                    });
            this.databasereference.child("cities").child(city_names[city_place]).child(this.new_super.getSuper_ID()).child("active").setValue("true");
        }

        String[] temps_Items = {"tuna","shampoo","milk","yellow cheese","ketchup","mayonnaise","cola","spaghetti","koteg","deodorant","bira"};

        String[][] temp_companys = {{"starkist","posidon","calvo"},{"head and shoulders","hawaii","pinuk"},{"tara","tnuva","yotvata"}
                ,{"tara","tnuva","yotvata"},{"hainze","telma","hellmann"},{"hainze","telma","hellmann","osem"},{"pepsi","coca cola"}
                ,{"osem","dececco"},{"tara","tnuva"},{"nivea","axe","speed stick","dove"},{"corona","budweiser","tuborg","carlsberg"}};
        for(int i=0;i<2000;i++)
        {
            int temp_super_place = (rn.nextInt(temp_super_ids.length));
            String temp_super = temp_super_ids[temp_super_place];
            int item_place =(rn.nextInt(temps_Items.length));
            String itemName  = temps_Items[item_place];
            int prodplace = (rn.nextInt(temp_companys[item_place].length));
            String company =temp_companys[item_place][prodplace];
            int price = (rn.nextInt(50));
            Log.d("try5", temp_super);
            Log.d("try5", itemName);
            Log.d("try5", company);

            databasereference.child("dict_product").child(itemName).child("active").setValue(1);
            databasereference.child("Supers").child(temp_super).child("products").child(itemName).child(company).setValue(price);
        }
    }
}