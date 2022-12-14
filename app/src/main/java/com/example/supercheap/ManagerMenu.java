package com.example.supercheap;


public class ManagerMenu {
    public static Object menu(int item_id){
        if (item_id==R.id.CC){
            return CreateCart.class;
        }else if(item_id==R.id.MyC)
        {
            return MyCart.class;
        }else if(item_id==R.id.MP)
        {
            return ManagerPage.class;
        }else if(item_id==R.id.logout)
        {
            return SigninActivity.class;
//            startActivity(new Intent(ManagerPage.this,ViewSignin.class));

        }else if(item_id==R.id.Review)
        {

        }
        return null;
    }
}
