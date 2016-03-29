package com.monash.yukaima.multi_screennavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by yukaima on 20/03/16.
 */
public class ViewStarswarNameActivity  extends AppCompatActivity {

    TextView shownname;
    UserInfo currentUser;
    private  String firstname;
    private  String lastname;
    private String planet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_starswarname);

        shownname = (TextView) findViewById(R.id.shownname);

        Intent i =getIntent();
        currentUser =(UserInfo) i.getParcelableExtra("user");

        //generate names
        firstname =Character.toUpperCase((currentUser.getFirstname().charAt(0)))
                +currentUser.getFirstname().substring(1,3)
                +currentUser.getSurname().substring(0,2).toLowerCase();
        Log.d("1", firstname);

        lastname = String.valueOf(Character.toUpperCase((currentUser.getMothersMaidenName().charAt(0))))
                + String.valueOf(Character.toLowerCase(currentUser.getMothersMaidenName().charAt(1)))
                + currentUser.getBirthPlace().substring(0,3).toLowerCase();

        Log.d("2", lastname);

        planet = String.valueOf(Character.toUpperCase(currentUser.getSurname().charAt(currentUser.getSurname().length()-2)))+
                String.valueOf(Character.toLowerCase(currentUser.getSurname().charAt(currentUser.getSurname().length() - 1)))
                +currentUser.getFavouriteBrand().toLowerCase();

        Log.d("3", lastname);

        shownname.setText(firstname +" " + lastname + " of " + planet);

    }


    }
