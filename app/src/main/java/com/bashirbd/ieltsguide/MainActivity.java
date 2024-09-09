package com.bashirbd.ieltsguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);



//=======================================navbarstart================================================================

        FragmentManager myfragment = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = myfragment.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, new HomePage());
        fragmentTransaction.commit();



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.home){

                    FragmentManager myfragment = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = myfragment.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new HomePage());
                    fragmentTransaction.commit();


                }
                else if (item.getItemId()==R.id.result){

                    Intent nextActivity = new Intent(MainActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 4);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);


                }
                else if (item.getItemId()==R.id.dic_tab) {

                    Intent nextActivity = new Intent(MainActivity.this, Dictionary.class);
                    startActivity(nextActivity);


                }







                return true;
            }
        });


        //===================================================================

        //===================================================================















    }//======================ocreateend==================================

    @Override
    public void onBackPressed() {


        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Confirm Exit!")
                .setIcon(R.drawable.alert)
                .setMessage("Do you want to exit ?")
                .setNegativeButton("RATE US", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Context context= MainActivity.this;
                        final String apppn = context.getPackageName();

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id="+apppn));
                        startActivity(intent);

                        try {

                        } catch (ActivityNotFoundException e){

                            Intent intent1 = new Intent(Intent.ACTION_VIEW);
                            intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id="+apppn));
                            startActivity(intent1);

                        }

                    }
                })
                .setPositiveButton("YES EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .show();

    }

}