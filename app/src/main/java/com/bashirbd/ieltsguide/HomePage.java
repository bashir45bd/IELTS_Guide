package com.bashirbd.ieltsguide;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class HomePage extends Fragment {

    CardView cardview1,cardview2,cardview3,cardview4,cardview5,cardview6,cardview7,cardview8;





    MaterialToolbar toolbar;
    NavigationView nav_View;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View myview = inflater.inflate(R.layout.fragment_home_page, container, false);

        cardview1 = myview.findViewById(R.id.cardview1);
        cardview2 = myview.findViewById(R.id.cardview2);
        cardview3 = myview.findViewById(R.id.cardview3);
        cardview4 = myview.findViewById(R.id.cardview4);
        cardview5 = myview.findViewById(R.id.cardview5);
        cardview6 = myview.findViewById(R.id.cardview6);
        cardview7 = myview.findViewById(R.id.cardview7);
        cardview8 = myview.findViewById(R.id.cardview8);








        //=====================identidrwerstsrt==============================
        toolbar = myview.findViewById(R.id.toolbar);
        nav_View = myview.findViewById(R.id.nav_View);
        drawerLayout = myview.findViewById(R.id.drawerLayout);


        //======================indetidrwerend=============================






        //=====================drwerstsrt==============================
       toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,toolbar, R.string.open, R.string.close);
       drawerLayout.addDrawerListener(toggle);


       nav_View.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               if (item.getItemId()==R.id.mHome){

                   drawerLayout.closeDrawer(GravityCompat.START);
               }
               else if (item.getItemId()==R.id.mbook){

                   Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putInt("VAL", 1);
                   nextActivity.putExtras(bundle);
                   startActivity(nextActivity);

                   drawerLayout.closeDrawer(GravityCompat.START);
               }



               else if (item.getItemId()==R.id.shareapp){

                   shareapp(getActivity());

                   drawerLayout.closeDrawer(GravityCompat.START);
               }

               else if (item.getItemId()==R.id.rateapp){

                   Context context= getActivity();
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

                   drawerLayout.closeDrawer(GravityCompat.START);
               }



               else if (item.getItemId()==R.id.policy){

                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setData(Uri.parse("https://sites.google.com/view/ieltsguide-privacy-policy"));
                   startActivity(intent);



                   drawerLayout.closeDrawer(GravityCompat.START);
               }




               else if (item.getItemId()==R.id.more){

                   String devmane = "Modest Software";
                   try {

                       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub: "+devmane)));

                   } catch (ActivityNotFoundException e){

                       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id= "+devmane)));

                   }

                   drawerLayout.closeDrawer(GravityCompat.START);
               }

               else if (item.getItemId()==R.id.developer){

                   new AlertDialog.Builder(getActivity())
                           .setTitle("About me!")
                           .setIcon(R.drawable.dev)
                           .setPositiveButton("Contact", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {

                                   Intent intent = new Intent(Intent.ACTION_VIEW);
                                   intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+8801303135957 &text= What's up, brother!"));
                                   startActivity(intent);
                               }
                           })
                           .setMessage("Hello! This is Bashir Ahmed, an enthusiastic Android app developer with a knack for turning ideas into functional and innovative mobile experiences.")
                           .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   dialog.dismiss();
                               }
                           })
                           .show();
                   drawerLayout.closeDrawer(GravityCompat.START);
               }




               return false;
           }
       });

        //======================drwerend=============================



//======================================pageclik===================================================================
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 1);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 22);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });



        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), Result.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 4);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);



            }
        });


        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 2);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });

        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), Dictionary.class);
                startActivity(nextActivity);


            }
        });

        cardview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 21);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });

        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent nextActivity = new Intent(getActivity(), AllActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 24);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });


        cardview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(getActivity(), Result.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 65);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);


            }
        });
        //======================================pageclik===================================================================





        return myview;

    }//=================oncreate end==============================




    private void shareapp (Context context){

        final String appname = context.getPackageName();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Download Now: https://play.google.com/store/apps/details?id="+appname);
        intent.setType("text/plain");
        context.startActivity(intent);

    }


}