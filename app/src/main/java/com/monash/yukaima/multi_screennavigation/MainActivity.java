package com.monash.yukaima.multi_screennavigation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText fisrtname;
    private EditText surname;
    private EditText motherMaidenName;
    private EditText birthplace;
    private EditText favouriteBrand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fisrtname = (EditText)findViewById(R.id.firstname);
        surname = (EditText)findViewById(R.id.surname);
        motherMaidenName=(EditText)findViewById(R.id.motherMaidenName);
        birthplace =(EditText)findViewById(R.id.birthplace);
        favouriteBrand = (EditText)findViewById(R.id.favouriteBrand);

    }

    public void createStarswarName(View view)
    {
     String fn = fisrtname.getText().toString().replaceAll("\\s+","");
        String sn = surname.getText().toString().replaceAll("\\s+","");
        String mmn = motherMaidenName.getText().toString().replaceAll("\\s+","");
        String bp = birthplace.getText().toString().replaceAll("\\s+","");
        String fb = favouriteBrand.getText().toString().replaceAll("\\s+", "");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(fn.length()<3 || sn.length()<2|| mmn.length()<2 || bp.length()<3 || fb.length()==0)
        {
            // Set message and title for dialog (we can chain methods here!)
            builder.setTitle("WrongInput!").setMessage("FirstName and Birthplace at least 3 letters."
                    + "\n" +"Surname and maiden name at least 2 letters." + "\n" + "Every Blank" +
                    "can not be none.");
            // Add a button to the dialog with an event handler for clicks (presses)
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) { dialog.dismiss();
                } });
            // Set the dialog to not be distrubed by the application
            builder.setCancelable(false);
            // Create dialog and display it to the user
            builder.create().show();
        }else {

            UserInfo user = new UserInfo(fn, sn, mmn, bp, fb);
            Intent i = new Intent(this, ViewStarswarNameActivity.class);
            i.putExtra("user", user);
            startActivity(i);
        }
    }

}
