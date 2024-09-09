package com.bashirbd.ieltsguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Result extends AppCompatActivity {


   AdView AdView1;

    int count = 0;
    int counttime = 3;

    long hidetime = 1800000;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private InterstitialAd mInterstitialAd;

    ListView aclistview,gtlistview,makkarlistview,lizlistview,vocablistview,part1listview,simpleanswer;
    GridView part2listview;
    LinearLayout resultpage,part1,part2,transcribe,wrsimple,read,ads1;
    RelativeLayout acactivity,gtactivity,makkaractivity,lizactivity,vocabactivity,speaking,listening,writing,reading;
    RelativeLayout pronunciation,beverb,haveverb,itthere,pretime,tense,acpass,sub,degree,reletive,readingtips,contractions,sound;

TabLayout tabLayout,speaktab,writingtab,readingtab,tabpronun;
ImageView backp,backb ,backh,backit,backpre,backt,backap,backs,backd,backr,backre;
ScrollView summary,lisummary,wrsummary,resummary;

    HashMap<String,String> hashMap,hashMap1,hashMapac,hashMapgt,hashMapmakkar,hashMapliz,hashMapvocab,hashMapsm;
    ArrayList< HashMap<String,String> > arrayList,arrayList1,arrayListac,arrayListgt,arrayListmakkar,arrayListliz,arrayListvocab,arrayListsm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ads1= findViewById(R.id.ads1);

        adssetting();


        AdView1 = findViewById(R.id.AdView1);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        long currentTime = System.currentTimeMillis();
        long lastclicktime = sharedPreferences.getLong("lastClick",0);

        if (currentTime-lastclicktime>= hidetime){
            bannaradssetting();
            AdView1.setVisibility(View.VISIBLE);

        } else {
            AdView1.setVisibility(View.GONE);
        }



        backp = findViewById(R.id.backp);
        backb = findViewById(R.id.backb);
        backh = findViewById(R.id.backh);
        backit = findViewById(R.id.backit);
        backpre = findViewById(R.id.backpre);
        backt = findViewById(R.id.backt);
        backap = findViewById(R.id.backap);
        backs = findViewById(R.id.backs);
        backd = findViewById(R.id.backd);
        backr = findViewById(R.id.backr);
        backre = findViewById(R.id.backre);


        simpleanswer = findViewById(R.id.simpleanswer);

        pronunciation = findViewById(R.id.pronunciation);
        beverb = findViewById(R.id.beverb);
        haveverb = findViewById(R.id.haveverb);
        itthere = findViewById(R.id.itthere);
        pretime = findViewById(R.id.pretime);
        tense = findViewById(R.id.tense);
        acpass = findViewById(R.id.acpass);
        sub = findViewById(R.id.sub);
        degree = findViewById(R.id.degree);
        reletive = findViewById(R.id.reletive);
        readingtips = findViewById(R.id.readingtips);



        tabLayout = findViewById(R.id.tabLayout);
        speaktab = findViewById(R.id.speaktab);
        writingtab = findViewById(R.id.writingtab);
        readingtab = findViewById(R.id.readingtab);
        tabpronun = findViewById(R.id.tabpronun);



        resultpage = findViewById(R.id.resultpage);
        acactivity = findViewById(R.id.acactivity);
        gtactivity = findViewById(R.id.gtactivity);
        makkaractivity = findViewById(R.id.makkaractivity);
        lizactivity = findViewById(R.id.lizactivity);
        vocabactivity = findViewById(R.id.vocabactivity);

        speaking = findViewById(R.id.speaking);
        listening = findViewById(R.id.listening);
        writing = findViewById(R.id.writing);
        reading = findViewById(R.id.reading);





        Bundle bun=getIntent().getExtras();
        int val =bun.getInt("VAL");

        if(val==4) {
            resultpage.setVisibility(View.VISIBLE);
            acactivity.setVisibility(View.GONE);
        }
        else if(val==5) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.VISIBLE);
        }
        else if(val==6) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.VISIBLE);
        }
        else if(val==7) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.VISIBLE);
        }
        else if(val==8) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.VISIBLE);
        }

         else if(val==9) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.VISIBLE);
        }


        else if(val==31) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.VISIBLE);


        }

        else if(val==32) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.VISIBLE);



        }

        else if(val==33) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.VISIBLE);



        }

        else if(val==34) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.VISIBLE);

        }

        else if(val==60) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.VISIBLE);

        }
        else if(val==61) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.VISIBLE);

        }


          else if(val==62) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.VISIBLE);

        }
         else if(val==63) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.VISIBLE);
        }
        else if(val==64) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.VISIBLE);
        }

        else if(val==65) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.VISIBLE);

        }

        else if(val==66) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.GONE);
            acpass.setVisibility(View.VISIBLE);

        }
        else if(val==67) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.GONE);
            acpass.setVisibility(View.GONE);
            sub.setVisibility(View.VISIBLE);

        }

        else if(val==68) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.GONE);
            acpass.setVisibility(View.GONE);
            sub.setVisibility(View.GONE);
            degree.setVisibility(View.VISIBLE);


        }
        else if(val==69) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.GONE);
            acpass.setVisibility(View.GONE);
            sub.setVisibility(View.GONE);
            degree.setVisibility(View.GONE);
            reletive.setVisibility(View.VISIBLE);


        }
        else if(val==70) {
            resultpage.setVisibility(View.GONE);
            acactivity.setVisibility(View.GONE);
            gtactivity.setVisibility(View.GONE);
            makkaractivity.setVisibility(View.GONE);
            lizactivity.setVisibility(View.GONE);
            vocabactivity.setVisibility(View.GONE);
            speaking.setVisibility(View.GONE);
            listening.setVisibility(View.GONE);
            writing.setVisibility(View.GONE);
            reading.setVisibility(View.GONE);
            pronunciation.setVisibility(View.GONE);
            beverb.setVisibility(View.GONE);
            haveverb.setVisibility(View.GONE);
            itthere.setVisibility(View.GONE);
            pretime.setVisibility(View.GONE);
            tense.setVisibility(View.GONE);
            acpass.setVisibility(View.GONE);
            sub.setVisibility(View.GONE);
            degree.setVisibility(View.GONE);
            reletive.setVisibility(View.GONE);
            readingtips.setVisibility(View.VISIBLE);

        }

        //========================back=====================================

        backp.setOnClickListener(v -> {
            onBackPressed();

        });

        backb.setOnClickListener(v -> {
            onBackPressed();

        });

        backh.setOnClickListener(v -> {
            onBackPressed();

        });

        backit.setOnClickListener(v -> {
            onBackPressed();

        });

        backpre.setOnClickListener(v -> {
            onBackPressed();

        });
        backt.setOnClickListener(v -> {
            onBackPressed();

        });

        backap.setOnClickListener(v -> {
            onBackPressed();

        });
        backs.setOnClickListener(v -> {
            onBackPressed();

        });

        backd.setOnClickListener(v -> {
            onBackPressed();

        });

        backr.setOnClickListener(v -> {
            onBackPressed();

        });

        backre.setOnClickListener(v -> {
            onBackPressed();

        });

        //========================backend=====================================




        //========================speaking=====================================


        summary = findViewById(R.id.summary);
        part1 = findViewById(R.id.part1);
        part2 = findViewById(R.id.part2);

        speaktab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int speaktabp = tab.getPosition();

                if (speaktabp==0){
                    summary.setVisibility(View.VISIBLE);
                    part1.setVisibility(View.GONE);
                    part2.setVisibility(View.GONE);
                }

                else if (speaktabp==1){
                    summary.setVisibility(View.GONE);
                    part1.setVisibility(View.VISIBLE);
                    part2.setVisibility(View.GONE);

                    }
                else {

                    summary.setVisibility(View.GONE);
                    part1.setVisibility(View.GONE);
                    part2.setVisibility(View.VISIBLE);

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {



            }
        });




        part1listview = findViewById(R.id.part1listview);
        part2listview = findViewById(R.id.part2listview);

        part1table();

        part1 part1adapter = new part1();
        part1listview.setAdapter(part1adapter);


        part2table();

        part2 part2adapter = new part2();
        part2listview.setAdapter(part2adapter);








        //========================speaking end=====================================


        //========================listening=====================================


        lisummary = findViewById(R.id.lisummary);
        transcribe = findViewById(R.id.transcribe);


        //========================listening end=====================================


        //========================writing=====================================



        wrsummary = findViewById(R.id.wrsummary);
        wrsimple = findViewById(R.id.wrsimple);


        writingtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                int wrf = tab.getPosition();

                if(wrf==0){

                    wrsummary.setVisibility(View.VISIBLE);
                    wrsimple.setVisibility(View.GONE);
                }
                else {
                    wrsummary.setVisibility(View.GONE);
                    wrsimple.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        smanswer();

        adsimpleanswer sAdapter = new adsimpleanswer();
        simpleanswer.setAdapter(sAdapter);







        //========================writing end=====================================


        //========================reading=====================================

        resummary = findViewById(R.id.resummary);
        read = findViewById(R.id.read);

        readingtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tt = tab.getPosition();


                if(tt==0){

                    resummary.setVisibility(View.VISIBLE);
                    read.setVisibility(View.GONE);

                }
                else {
                    resummary.setVisibility(View.GONE);
                    read.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        //========================reading end=====================================

        //========================pronunciation=====================================

        contractions = findViewById(R.id.contractions);
        sound = findViewById(R.id.sound);


        tabpronun.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int rr = tab.getPosition();

                if(rr==0){
                    contractions.setVisibility(View.VISIBLE);
                    sound.setVisibility(View.GONE);
                } else {
                    contractions.setVisibility(View.GONE);
                    sound.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        //========================pronunciation end=====================================














            //========================acbook=====================================


        aclistview = findViewById(R.id.aclistview);


        actable();

        myadaptar myadaptar = new myadaptar();
        aclistview.setAdapter(myadaptar);

        //========================acbookend=====================================


        //========================gtbook=====================================
        gtlistview = findViewById(R.id.gtlistview);


        gttable();

        gtadaptar gtadaptar = new gtadaptar();
        gtlistview.setAdapter(gtadaptar);

        //========================gtbookend=====================================

        //========================makkarbook=====================================
        makkarlistview = findViewById(R.id.makkarlistview);

        makkar();

        makkaradaptar makkaradaptar = new makkaradaptar();
        makkarlistview.setAdapter(makkaradaptar);

        //========================makkarbookend=====================================

        //========================lizbook=====================================
        lizlistview = findViewById(R.id.lizlistview);

        liz();

        lizadaptar lizadaptar = new lizadaptar();
        lizlistview.setAdapter(lizadaptar);

        //========================lizbookend=====================================

        //========================vocabbook=====================================
        vocablistview = findViewById(R.id.vocablistview);

        vocab();

        vocabadaptar vocabdaptar = new vocabadaptar();
        vocablistview.setAdapter(vocabdaptar);

        //========================vocabbookend=====================================










        FragmentManager myfragment = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = myfragment.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,new ResultAc());
        fragmentTransaction.commit();



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tposition = tab.getPosition();

                if(tposition==0){
                    FragmentManager myfragment = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = myfragment.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new ResultAc());
                    fragmentTransaction.commit();

                }
                else if(tposition==1) {
                    FragmentManager myfragment = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = myfragment.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new Resultgt());
                    fragmentTransaction.commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });








    }//========oncreate end=====================================




    //==========acbook adaper===================

    public class myadaptar extends BaseAdapter {

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayListac.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview =layoutInflater.inflate(R.layout.acbooks,parent,false);

            LinearLayout accliker = myview.findViewById(R.id.accliker);
            TextView acbn = myview.findViewById(R.id.acbn);


            HashMap<String,String> hasmapac = arrayListac.get(position);
            String booklinkac = hasmapac.get("booklinkac");
            acbn.setText(hasmapac.get("nameac"));


            accliker.setOnClickListener( v -> {

                Audioplayer.booklinkac = booklinkac;

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(Result.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();

                                Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL",111);
                                nextActivity.putExtras(bundle);
                                startActivity(nextActivity);

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                mInterstitialAd = null;
                            }
                        });
                    } else {

                        Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL",111);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);
                    }


                }

                else {
                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",111);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }





            });


            return myview;
        }
    }

    //==========acbook adaper end===================

    //==========gtbook adaper===================

    public class gtadaptar extends BaseAdapter{

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayListgt.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview =layoutInflater.inflate(R.layout.gtbook,parent,false);

            LinearLayout gtcliker = myview.findViewById(R.id.gtcliker);
            TextView gtbn = myview.findViewById(R.id.gtbn);


            HashMap<String,String> hasmapgt = arrayListgt.get(position);
            String booklinkgt = hasmapgt.get("booklinkgt");
            gtbn.setText(hasmapgt.get("namegt"));

            gtcliker.setOnClickListener(v -> {


                Audioplayer.booklinkgt = booklinkgt;

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(Result.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();

                                Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL",112);
                                nextActivity.putExtras(bundle);
                                startActivity(nextActivity);

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                mInterstitialAd = null;
                            }
                        });
                    } else {

                        Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL",112);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);
                    }


                }

                else {
                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",112);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }




            });



            return myview;
        }
    }



    //==========gtbook adaper end===================


    //==========makkarbook adaper===================

    public class makkaradaptar extends BaseAdapter{

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayListmakkar.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview =layoutInflater.inflate(R.layout.makkar,parent,false);


            LinearLayout makkarcliker = myview.findViewById(R.id.makkarcliker);
            TextView makkarbn = myview.findViewById(R.id.makkarbn);


            HashMap<String,String> hasmapmakkar = arrayListmakkar.get(position);
            String booklinkmakkar = hasmapmakkar.get("booklinkmakkar");
            makkarbn.setText(hasmapmakkar.get("namemakkar"));

            makkarcliker.setOnClickListener(v -> {


                Audioplayer.booklinkmakkar = booklinkmakkar;


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(Result.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();

                                Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL",113);
                                nextActivity.putExtras(bundle);
                                startActivity(nextActivity);

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                mInterstitialAd = null;
                            }
                        });
                    } else {

                        Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL",113);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);
                    }


                }

                else {
                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",113);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }





            });


            return myview;
        }
    }



    //==========gtbook adaper end===================


    //==========makkarbook adaper===================

    public class lizadaptar extends BaseAdapter{

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayListliz.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview =layoutInflater.inflate(R.layout.liz,parent,false);


            LinearLayout lizcliker = myview.findViewById(R.id.lizcliker);
            TextView lizbn = myview.findViewById(R.id.lizbn);


            HashMap<String,String> hasmapliz = arrayListliz.get(position);
            String booklinkliz = hasmapliz.get("booklinkliz");
            lizbn.setText(hasmapliz.get("nameliz"));

            lizcliker.setOnClickListener(v -> {


                Audioplayer.booklinkliz = booklinkliz;


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(Result.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();

                                Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL",114);
                                nextActivity.putExtras(bundle);
                                startActivity(nextActivity);

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                mInterstitialAd = null;
                            }
                        });
                    } else {

                        Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL",114);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);
                    }


                }

                else {
                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",114);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }



            });


            return myview;

        }
    }



    //==========gtbook adaper end===================

    //==========makkarbook adaper===================

    public class vocabadaptar extends BaseAdapter{

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayListvocab.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview =layoutInflater.inflate(R.layout.vocab,parent,false);


            LinearLayout vocabcliker = myview.findViewById(R.id.vocabcliker);
            TextView vocabbn = myview.findViewById(R.id.vocabbn);


            HashMap<String,String> hasmapvocab = arrayListvocab.get(position);
            String booklinkvocab = hasmapvocab.get("booklinkvocab");
            vocabbn.setText(hasmapvocab.get("namevocab"));

            vocabcliker.setOnClickListener(v -> {


                Audioplayer.booklinkvocab = booklinkvocab;

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(Result.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();

                                Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL",115);
                                nextActivity.putExtras(bundle);
                                startActivity(nextActivity);

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                mInterstitialAd = null;
                            }
                        });
                    } else {

                        Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL",115);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);
                    }


                }

                else {
                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",115);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }



            });



            return myview;
        }
    }



    //==========gtbook adaper end===================



    //========================part1=====================================

    public class part1 extends BaseAdapter{

        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.part1,parent,false);

            TextView topicname = view.findViewById(R.id.topicname);
            TextView q1 = view.findViewById(R.id.q1);
            TextView a1 = view.findViewById(R.id.a1);
            TextView q2 = view.findViewById(R.id.q2);
            TextView a2 = view.findViewById(R.id.a2);
            TextView q3 = view.findViewById(R.id.q3);
            TextView a3 = view.findViewById(R.id.a3);
            TextView q4 = view.findViewById(R.id.q4);
            TextView a4 = view.findViewById(R.id.a4);


            HashMap<String,String> hasmap = arrayList.get(position);



            topicname.setText(hasmap.get("topictoy"));

            q1.setText(hasmap.get("mq1"));

            a1.setText(hasmap.get("ma1"));

            q2.setText(hasmap.get("mq2"));

            a2.setText(hasmap.get("ma2"));

            q3.setText(hasmap.get("mq3"));

            a3.setText(hasmap.get("ma3"));

            q4.setText(hasmap.get("mq4"));

            a4.setText(hasmap.get("ma4"));



            return view;
        }
    }

    //========================part1=====================================

    //========================part3=====================================

    public class part2 extends BaseAdapter{

        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return arrayList1.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.cuecard,parent,false);

            TextView cuecradname = view.findViewById(R.id.cuecradname);
            TextView fullcuecard = view.findViewById(R.id.fullcuecard);
            TextView part3q1 = view.findViewById(R.id.part3q1);
            TextView part3a1 = view.findViewById(R.id.part3a1);
            TextView part3q2 = view.findViewById(R.id.part3q2);
            TextView part3a2 = view.findViewById(R.id.part3a2);
            TextView part3q3 = view.findViewById(R.id.part3q3);
            TextView part3a3 = view.findViewById(R.id.part3a3);

           HashMap<String,String> hasmap = arrayList1.get(position);

            cuecradname.setText(hasmap.get("cuename"));
            fullcuecard.setText(hasmap.get("alltext"));
            part3q1.setText(hasmap.get("q1"));
            part3a1.setText(hasmap.get("a1"));
            part3q2.setText(hasmap.get("q2"));
            part3a2.setText(hasmap.get("a2"));
            part3q3.setText(hasmap.get("q3"));
            part3a3.setText(hasmap.get("a3"));





            return view;
        }
    }


    public class adsimpleanswer extends BaseAdapter{
        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return arrayListsm.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.simpleanswer,parent,false);

            TextView smname = view.findViewById(R.id.sm);
            LinearLayout smcliker = view.findViewById(R.id.smcliker);


            HashMap<String,String> hasmapsm = arrayListsm.get(position);
            String smlink = hasmapsm.get("smlink");
            smname.setText(hasmapsm.get("smname"));


            smcliker.setOnClickListener(v -> {

                Audioplayer.smlink = smlink;





                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){




                    Intent nextActivity = new Intent(Result.this, Audioplayer.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL",116);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);



                }
                else {

                    internet(Result.this);

                }



            });


            return view;
        }
    }

    //=====================================transcribeaudio======================================================


    public void part2table(){


        arrayList1 = new ArrayList<>();

          hashMap1= new HashMap<>();
          hashMap1.put("cuename","1.Describe a recreational public spot that you visited and liked. You should say-");
          hashMap1.put("alltext","\n" +
                  "What is it?\n" +
                  "\n" +
                  "Where it is located?\n" +
                  "\n" +
                  "What are the attractive things for the visitors there? Why people like it and who are the regular visitors there.\n" +
                  "\n" +
                  "In the course of my life, I've had the opportunity to explore numerous recreational public spots, and among them, one place that holds a special place in my heart is Cox's Bazar. Situated in the southern part of Bangladesh, this location is a true testament to natural beauty.\n" +
                  "\n" +
                  "Cox's Bazar is renowned for its picturesque sea beach, offering visitors a plethora of attractions. People flock to this destination to stroll along the sandy shores, bask in the sea breeze, and immerse themselves in a tranquil and leisurely experience. The reasons behind the widespread admiration for this place are diverse and contribute to its status as a favorite spot for regular visitors.\n" +
                  "\n" +
                  "First and foremost, Cox's Bazar is a culinary delight, offering a variety of traditional foods at affordable prices, including delicacies like dry fish and sea fish. Beyond the gastronomic pleasures, visitors find solace in the refreshing environment, allowing them to rejuvenate their minds and re-energize to appreciate the beauty of nature. The landscape is adorned with natural wonders such as mountains, hills, marine drives, and more, captivating the hearts of those who visit.\n" +
                  "\n" +
                  "In essence, Cox's Bazar is a treasure trove of natural beauty and recreational delights, making it a cherished destination for those seeking a respite from the routine of daily life.");
          hashMap1.put("q1","1.In your opinion, where should we spend our free time, at home or outside?");
          hashMap1.put("a1","I believe the choice between spending free time at home or outside is subjective and depends on personal preferences. Personally, I find spending my leisure time outside, such as in cafes, more appealing because it provides an opportunity to meet new people and offers a different, relaxing environment. However, individuals who prefer spending their free time at home often find it more relaxing within the familiar and comfortable surroundings of their personal space.");
          hashMap1.put("q2","2.Which do you think is better, spending our free time doing nothing or doing something we enjoy?");
          hashMap1.put("a2","I am of the opinion that it's better to engage in activities we enjoy during our free time rather than doing nothing. Time is valuable, and by doing something enjoyable, we make our leisure moments more meaningful. Engaging in activities we love brings a sense of fulfillment and relaxation, turning our free time into a rewarding experience.");
          hashMap1.put("q3","3.What other things do you like to do in your leisure time?");
          hashMap1.put("a3","In my leisure time, I engage in various activities that bring me joy. I have a keen interest in reading books and indulging in sketching as creative outlets. Additionally, I enjoy watching movies, with a particular affinity for foreign films, including Bollywood and Hollywood productions. These activities contribute to a well-rounded and enjoyable leisure experience for me.");
          arrayList1.add(hashMap1);



          hashMap1= new HashMap<>();
          hashMap1.put("cuename","2.Describe a street market in your city. You should say- ");
          hashMap1.put("alltext","What can you buy there?\n" +
                  "\n" +
                  "What is it famous for?\n" +
                  "\n" +
                  "And explain how you feel about it." +
                  "Throughout my life, I've explored numerous street markets, but today, I want to share my experiences at a particular one in my city—the N.S Street market in Kushtia, located in the southern part of Bangladesh, adorned with natural beauty.\n" +
                  "\n" +
                  "This market is a treasure trove where I often find myself indulging in a variety of purchases, ranging from food and jewelry to handicrafts. What distinguishes N.S Street market is its fame for offering a diverse array of local products at remarkably reasonable prices. During one visit, I was captivated by colorful lights that I couldn't resist buying. The market is also a hub for mobile shops, adding to its bustling atmosphere.\n" +
                  "\n" +
                  "Several factors contribute to my happiness whenever I visit this street market. As a student on a tight budget, it serves as my go-to destination for affordable yet quality purchases. The market is known for providing high-quality goods at throwaway prices, aligning perfectly with my financial constraints. Additionally, my friends and I often celebrate our achievements at the lively food court within the market premises. Lastly, we savor bites of various traditional snacks readily available, adding a delightful culinary aspect to our visits.\n" +
                  "\n" +
                  "In essence, N.S Street market holds a special place in my heart, not just for its economic convenience but for the vibrant experiences, celebrations, and flavors it offers.");
          hashMap1.put("q1","1.Do you prefer online shopping or traditional in-store shopping?");
          hashMap1.put("a1","I would lean towards online shopping rather than going out for several reasons. Primarily, I find online shopping appealing, especially during sales where products are available at discounted rates. Additionally, my busy study schedule often makes online shopping more convenient. Particularly during the Corona Pandemic, opting for online shopping becomes worthwhile to minimize social interactions.");
          hashMap1.put("q2","2.What distinguishes shopping with friends from shopping alone?");
          hashMap1.put("a2","There are numerous disparities between shopping with friends and shopping alone. Firstly, shopping with friends is enjoyable as it involves advice on suitable choices and engaging conversations. They also contribute to staying updated with the latest fashion trends. In contrast, shopping alone can be mundane and lacks the dynamic social aspect.");
          hashMap1.put("q3","3.What drawbacks come with shopping in a large mall?");
          hashMap1.put("a3","Shopping in a big mall comes with its fair share of disadvantages. Firstly, these malls are often situated at a considerable distance from cities, requiring substantial travel time. Navigating the extensive layout can be time-consuming, and crowded conditions during peak hours may result in lengthy queues at checkout counters. The wide array of products and attractive displays may tempt shoppers to overspend impulsively. Furthermore, the impersonal ambiance of big malls can lead to a lack of personalized assistance compared to smaller, specialized stores.");
          arrayList1.add(hashMap1);



          hashMap1= new HashMap<>();
          hashMap1.put("cuename","3.Describe a part of a city or a town you enjoy spending time in. You should say-");
          hashMap1.put("alltext","\n" +
                  "What it is like?\n" +
                  "What do you do there?\n" +
                  "And explain why you enjoy spending time there. \nThroughout my entire life, I've explored numerous street markets, and among them, I want to highlight one that holds a special place in my heart – N.S Street market in Kushtia, situated in the southern part of Bangladesh. This locale is abundant with natural beauty.\n" +
                  "\n" +
                  "Primarily, I frequent this market to purchase a diverse array of items, including food, jewelry, handicrafts, and more. What sets it apart is the wide range of local products available at remarkably reasonable prices, making it immensely popular. Personally, I've acquired vibrant lights during one of my visits, and the market also boasts numerous mobile shops.\n" +
                  "\n" +
                  "There are numerous reasons why I find joy in visiting this street market. Firstly, as a student on a tight budget, it serves as the ideal destination for affordable purchases. Additionally, the market offers top-quality goods at incredibly competitive prices. Furthermore, my friends and I often celebrate our accomplishments at the market's food court. To conclude, we indulge in various traditional snacks available here. This encapsulates my experiences at N.S Street market, at least for now.");
          hashMap1.put("q1","1.How do public places change in towns or cities?");
          hashMap1.put("a1","Public places in towns or cities undergo transformations for various reasons. Firstly, the younger generations often seek modernized facilities, prompting a demand for updated amenities. Additionally, administrative bodies contribute to these changes by incorporating technology, such as automatic ticket counters at bus stops, to enhance the efficiency and convenience of public spaces.");
          hashMap1.put("q2","2.What public places do old people usually go?");
          hashMap1.put("a2","Older individuals typically gravitate towards places like libraries, parks, and community centers. As family members are occupied with work or studies, seniors may experience feelings of loneliness. Consequently, they visit public parks to spend time with friends or seek solace by visiting places like temples, contributing to their emotional well-being.");
          hashMap1.put("q3","3.Why do young people like to go to public places?");
          hashMap1.put("a3","Young people are drawn to public places for several reasons. Primarily, these spaces provide opportunities for socializing and interaction, allowing them to meet new people and expand their social circles. In essence, public places become venues for forging new friendships, fostering a sense of community among the younger demographic.");
          arrayList1.add(hashMap1);



          hashMap1= new HashMap<>();
        hashMap1.put("cuename","4. Describe a part of a city or a town you enjoy spending time in. You should say-");
        hashMap1.put("alltext","Where it is?\n" +
                "What it is like?\n" +
                "What do you do there?\n" +
                "And explain why you enjoy spending time there. I have visited a lot of places. Among of In my entire life/throughout my all life, them, today, I would like to talk about a place where I really enjoy spending time.\n" +
                "To begin with, the name of the place is Cox's-bazar which is located in the southern part of Bangladesh and this place is full of natural beauty.\n" +
                "In other words, this is outstanding place with longest sea beach in the world. And there are a number of plants, flowers, rides, swings, jogging tracks, and so on available for children and adults.\n" +
                "Most importantly, I go there then I like to walk on the sea beach and like to sit on it. After it, I sit there with my other friends and spend time with them. Sometimes, we play some sports such as; cricket, football and so on.\n" +
                "Moreover, there are a great number (a great many) of reasons why I like to spending time there. First and foremost, I like to spend time there because it is a very peaceful place when I go there I feel relax and burden-free from my work and study. Another prominent point is that I easily refresh my mind and boost up my energy to enjoy the beauty of nature silly things of children. What's more, I always get into a state of flow while having a walk over here. Last but not least, I get a chance to widen my social circle by meeting like-minded people over there. That's all what I can share with your at this moment.");
        hashMap1.put("q1","1. How do public places change in towns or cities?");
        hashMap1.put("a1","Ans. I guess that public places change in towns or cities for some reasons. First off, the new generations want new and modernized facilities. And then, The administration sometimes makes changes to public places like bus stops with the help of technology, for example, automatic ticket counters");
        hashMap1.put("q2","1. Did you play with toys when you were a child?");
        hashMap1.put("a2","Ans. Of course, I loved playing with toys when I was a child; I think all children do. 2. What kinds of toys did you like?\n" +
                "Ans. As far as I remember, I mostly played with toy cars, planes and action figures from films or cartoons. I also liked building things with Lego.");
        hashMap1.put("q3","3. In your country, do boys and girls play with the same types of toys?");
        hashMap1.put("a3","Ans. Definitely, not I think boys like the kinds of toys that I mentioned before, whereas girls play with dolls. I can also add that my niece, for example, doesn't like toy cars; she prefers dressing dolls in different outfits.\n" +
                "4. Do you think that toys help children to learn?\n" +
                "Ans. Obviously, I do. All toys encourage children to use their imagination and creativity. To be more exact, even with simple toys, children imagine situations and invent games and rules.");
        arrayList1.add(hashMap1);



          hashMap1= new HashMap<>();
          hashMap1.put("cuename","5.Describe a café/restaurant that you like (to go to). You should say-");
          hashMap1.put("alltext","What kinds of food and drinks it serves?\n" +
                  "\n" +
                  "What do you do there?\n" +
                  "\n" +
                  "And explain why you like to go there.\n" +
                  "Throughout my life, I've explored numerous cafes and restaurants, and today, I want to highlight one place that holds a special spot in my heart - BBQ, located in the southern part of Bangladesh, surrounded by natural beauty. It is a renowned brand celebrated for its authentic taste and quality ambiance.\n" +
                  "\n" +
                  "BBQ offers a diverse menu, featuring a wide range of beverages and snacks. However, my usual order consists of a cappuccino paired with a sandwich.\n" +
                  "\n" +
                  "What sets BBQ apart for me is not just the delectable taste of the food but also the exquisite presentation. The aesthetic appeal adds to the overall dining experience, creating a feast for the senses. The ambiance is further enhanced by the presence of music, making each visit an enjoyable and immersive experience.\n" +
                  "\n" +
                  "There are several reasons why BBQ is my preferred choice. The staff members exhibit exceptional politeness, providing a top-notch service experience. Additionally, the cafe offers a variety of traditional foods at affordable prices, including delicacies like dry fish and sea fish. The availability of coupons and vouchers adds an extra layer of convenience, allowing us to enjoy additional discounts on our orders. Lastly, the natural beauty surrounding the cafe complements the overall experience, creating a serene and enjoyable atmosphere.\n" +
                  "\n" +
                  "In conclusion, BBQ has become more than just a dining spot for me; it's a place where taste, presentation, service, and natural beauty converge to create a memorable and cherished experience.");
          hashMap1.put("q1","1.What kind of people would enjoy going to a cafe?");
          hashMap1.put("a1","People who appreciate tea and coffee but lack the time to prepare it at home are likely to enjoy visiting cafes. Additionally, individuals seeking a break from the monotony of their lives may find cafes appealing. Some also choose cafes as spaces for study or work when they cannot do so effectively at home.");
          hashMap1.put("q2","2.Why do young people prefer studying in a cafe instead of at home?");
          hashMap1.put("a2","There are several reasons why young people may prefer studying in a cafe over studying at home. Firstly, the atmosphere within a cafe is often more conducive to focus compared to the potential distractions at home. Secondly, cafes provide a social environment where like-minded individuals can gather, fostering a sense of community that might be lacking at home.");
          hashMap1.put("q3","3.Do older people enjoy drinking coffee?");
          hashMap1.put("a3","Yes, many older individuals do enjoy drinking coffee. This preference can be attributed to the potential benefits of coffee, such as providing an energy boost and contributing to the rebuilding of confidence, especially for those experiencing lower blood pressure.");
          arrayList1.add(hashMap1);

          hashMap1= new HashMap<>();
          hashMap1.put("cuename","6.Describe a famous historic place you know about. You should say-");
          hashMap1.put("alltext","What it is?\n" +
                  "\n" +
                  "Where it is located?\n" +
                  "\n" +
                  "What you can see or do there now?\n" +
                  "\n" +
                  "And explain why this historic place is so interesting.\n" +
                  "Throughout my life, I've had the opportunity to visit numerous places, and today, I want to share my fascination for a historical gem—Ahsan Manjil. Located in the central part of Bangladesh, this place not only boasts historical significance but is also adorned with natural beauty.\n" +
                  "\n" +
                  "Ahsan Manjil serves as a recreational haven, inviting people to immerse themselves in its charm and enjoy their leisure time amidst its captivating surroundings. The site offers a plethora of attractions, allowing visitors to relish the fresh air and create memorable moments in a quality leisure environment.\n" +
                  "\n" +
                  "Spanning over 20 acres of lush forestation, Ahsan Manjil unfolds a visual delight with a rose garden, a picturesque lake, tower-like observatories, and an idyllic setting that could be deemed heaven for nature enthusiasts.\n" +
                  "\n" +
                  "The allure of Ahsan Manjil extends beyond its natural splendor. Primarily, it holds historical significance as the former official residence and seat of the Nawab of Dhaka, constructed in the Indo-Saracenic Revival architecture. Today, it stands as a designated national museum, preserving the rich heritage of the region.\n" +
                  "\n" +
                  "Furthermore, Ahsan Manjil offers a culinary journey with a variety of traditional foods available at affordable prices, including delicacies like dry fish and sea fish. The area's natural beauty remains a prominent feature, surrounded by small mountains, hills, a marine drive, and more, catering to the diverse preferences of visitors.\n" +
                  "\n" +
                  "In conclusion, Ahsan Manjil emerges not just as a historical relic but as a multifaceted destination that seamlessly blends history, nature, and cultural richness, making it an enticing place for exploration and enjoyment.");
          hashMap1.put("q1","1.What do you think of the future trend of historic places?");
          hashMap1.put("a1","I firmly believe that the future trend of historic places should prioritize preservation, as these sites play a crucial role in reflecting a country's traditions and history. Historical places are integral components of a nation's cultural heritage, and their preservation ensures the continuation of these valuable aspects. Moreover, certain historically significant sites may gain increased importance and demand more meticulous preservation efforts in the future.");
          hashMap1.put("q2","2.Will the government strengthen its protection toward historic places?");
          hashMap1.put("a2","I am inclined to believe that governments will indeed strengthen their protection of historic places for several reasons. Firstly, these places serve as essential embodiments of a country's history and culture, contributing significantly to the nation's identity. Strengthening protection measures not only ensures the accessibility of these monuments to tourists but also safeguards their original identity, preventing degradation or loss.");
          hashMap1.put("q3","3.What is the effect of tourists on such a place?");
          hashMap1.put("a3","The impact of tourists on historic places generally leads to positive outcomes. Firstly, the influx of visitors contributes to job creation among the local population, providing economic benefits. Additionally, the revenue generated from tourism can bolster the government's budget, supporting various developmental initiatives. Furthermore, a growing number of tourists often stimulates business opportunities in the local area, fostering economic growth and community development.");
          arrayList1.add(hashMap1);

          hashMap1= new HashMap<>();
          hashMap1.put("cuename","7.Describe a popular tourist attraction in your country. You should say-");
          hashMap1.put("alltext","What kind of place it is?\n" +
                  "\n" +
                  "What it looks like?\n" +
                  "\n" +
                  "Where it is?\n" +
                  "\n" +
                  "And explain how the place is related to history.\n" +
                  "Throughout my life, I've had the privilege of visiting numerous tourist attractions, and today, I want to express my enthusiasm for a place I aspire to visit in the future—Cox's Bazar. This destination, nestled in the southern part of Bangladesh, captivates with its natural beauty and recreational offerings.\n" +
                  "\n" +
                  "Spanning over 20 acres of lush forestation, Cox's Bazar is a paradise for nature lovers. The landscape features a rose garden, a serene lake, tower-like observatories, and various elements that promise a haven for those seeking respite in the embrace of nature.\n" +
                  "\n" +
                  "What makes Cox's Bazar stand out is not just its natural allure but also its historical significance. Beyond being a place of scenic beauty, it offers an array of traditional foods at affordable prices, including delicacies like dry fish and sea fish. This amalgamation of history and culinary delights makes it a truly enriching experience.\n" +
                  "\n" +
                  "Importantly, Cox's Bazar provides an ideal setting for refreshing the mind and rejuvenating one's energy amidst the playful innocence of children and the soothing environment. The surrounding area is a visual delight, featuring mountains, hills, a marine drive, and more, adding layers to the overall experience.\n" +
                  "\n" +
                  "Furthermore, the prospect of widening my social circle by meeting like-minded individuals at Cox's Bazar adds an exciting dimension to the visit. Engaging with fellow travelers and sharing in the collective appreciation for nature enhances the overall enjoyment of the trip.\n" +
                  "\n" +
                  "In conclusion, Cox's Bazar beckons as a destination that seamlessly intertwines natural beauty, historical significance, and the potential for meaningful social connections. I eagerly anticipate the day when I can embark on this journey and revel in the unique offerings this captivating place has to offer.");
          hashMap1.put("q1","1.Why is tourism important to a country?");
          hashMap1.put("a1","Tourism holds significant importance for a country on multiple fronts. Firstly, it diversifies the economy by generating additional revenues and creating job opportunities. Additionally, tourism fosters cross-cultural awareness among citizens, promoting a better understanding of different societies. Moreover, it plays a role in environmental conservation through nature-based tourism initiatives.");
          hashMap1.put("q2","2.What are the benefits to individuals of visiting another country as tourists?");
          hashMap1.put("a2","Visiting another country as a tourist offers numerous individual benefits. It allows individuals to explore and discover new experiences that might not be possible in their home country. Additionally, it provides a break from the routine of everyday life, offering the opportunity to immerse oneself in different climates, terrains, and ecosystems. Foreign travel opens doors to new cultures, plants, animals, and enriching encounters.");
          hashMap1.put("q3","3.How necessary is it for tourists to learn the language of the country they're visiting?");
          hashMap1.put("a3","While learning the language of the visited country is beneficial, it may not be strictly necessary. Communication barriers can be overcome through non-verbal means such as signs and expressions when needed. However, learning some basic phrases can enhance the travel experience, facilitating interaction with locals and showing a level of respect for the host country's culture and language.");
          arrayList1.add(hashMap1);

          hashMap1= new HashMap<>();
          hashMap1.put("cuename","8.Describe the person whom you admire most. You should say-");
          hashMap1.put("alltext","What his/her relationship is to you?\n" +
                  "\n" +
                  "What s/he has done in your life?\n" +
                  "\n" +
                  "What s/he does now?\n" +
                  "\n" +
                  "And explain why you admire this person so much.\n" +
                  "\n" +
                  "In my entire life/throughout my all life, I (met/came with) a lot of people, among\n" +
                  "of them, I would like to talk about a person whom I admire a lot.\n" +
                  "\n" +
                  "To start with, the name of this person is Bijoy who is my college teacher. In addition to this, he has done many things to develop my entire life. When I used to learn mathematics from him, he made all the logic and complexities clear to me within the shortest time and I had a good score on that final exam. Most importantly, he is one of my best teachers in my life. He is a famous college teacher in my local area.\n" +
                  "\n" +
                  "Moreover, there are a great number (a great many) of reasons why I like this person. First of all, he is sincere, likes to talk straight, punctual, and sympathetic to others. Another important point is that he inspires me to get admitted to the best university of our country and he is the one who contributes the most to help me become the man I am. What is more, he insists me to take part in the outdoor activities and motivates me to play cricket. Last but not least, he advises me about many things and always supported me and that helps me a lot to come out from the depression. That's all what I can share with you at this moment.");
          hashMap1.put("q1","1. Do you think people who are famous are more admired than others?");
          hashMap1.put("a1","Ans. I do believe that people consider at least most of them good, generous, hospitable, caring people. To kick off, they might be tempted to think those people really are just 'better people, because maybe being a 'better' person makes you more likely to be rich and successful. Furthermore, famous people always try to give advice in different aspects to general people like; education, career and so on.");
          hashMap1.put("q2","2.What kind of people become famous people these days?");
          hashMap1.put("a2","Ans. I mean to say that in the age of modern technology, anyone can be a famous person. First off, people, who are role models or have the potential to be role models, become famous these days. For example, role models would be movie stars, sports superstars, technology \"gurus\", entrepreneurs, and business tycoons, among others.");
          hashMap1.put("q3","3. How do you think people will become famous in the future?\n");
          hashMap1.put("a3","Ans. I do assume that people would become more famous in the future compared to nowadays in many ways. First of all, more and more people would try to use\n" +
                  "media to showcase their success and become famous. What is more, people would have more and more uncommon and unconventional issues, such as environmental activism to thump on in order to become famous.");
          arrayList1.add(hashMap1);




          hashMap1= new HashMap<>();
          hashMap1.put("cuename","9.Describe someone in your family. You should say-");
          hashMap1.put("alltext","How this person is related to you?\n" +
                  "\n" +
                  "What this person looks like?\n" +
                  "\n" +
                  "What kind of person he/she is?\n" +
                  "\n" +
                  "And explain why you like this person.\n" +
                  "\n" +
                  "In my entire life/throughout my all life, 1 (met/came with) a lot of people but I love my family members a lot. Among of them, I would like to talk about a person from my family.\n" +
                  "\n" +
                  "To start with, the name of this person is Bijoy who is my brother.\n" +
                  "\n" +
                  "Most importantly, he is short, slim and he has big brown eyes. He likes to play\n" +
                  "\n" +
                  "sport or do physical things.\n" +
                  "\n" +
                  "In other words, he is a truly patient person, especially in dealing with obstacles in our family, although occasionally he may be strict. Undeniably, he is a glass-half- full person, which inspires me the most no matter how hard are situations we are facing.\n" +
                  "\n" +
                  "Moreover, there are a great number (a great many) of reasons why I like this person. First of all, I like my brother a lot and will continue doing so for his honesty, his sincerity and the sense of responsibility. Another important point is that he inspired me to get admitted to the best university of our country and he is the one who contributed the most to help me become the man I am. What is more, he insisted me to take part in the outdoor activities and motivated me to play cricket. Last but not least, he advised me about many things and always supported me and that helped me a lot to come out from the depression I had at that time. That's all what I can share with you at this moment.\n");
          hashMap1.put("q1","1.What are the values of family in your country?");
          hashMap1.put("a1","\n" +
                  "Ans. I suppose that there different type of values of family in my country. Firstly, most important values of a family are the moral values, which enable people to draw attention between right and wrong, good and bad, true and false. To be frank, lessons learned from the family are invaluable throughout our life. To explain, a family is the most important group that makes life worth living.");
          hashMap1.put("q2","2. How family bonding is necessary for happiness in life?");
          hashMap1.put("a2","Ans. I would say that family bonding is necessary for happiness in our life. To kick off, closeness in a family leads people to have an intrinsically fulfilling and flourishing life. Quite honestly, we rely on parents when we open our eyes for the first time and they are the primary educator and they teach their children how to develop confidence, social skills. ");
          hashMap1.put("q3","3. What type of family do you like? Nuclear family / joint family?");
          hashMap1.put("a3","Ans. I'm certain that I like nuclear family because I grew up in a nuclear family and it was a pleasant memory for me. First off, in a nuclear family, the couple and their children have a stronger relationship. Fighting and quarrel are rare in nuclear families.");
          arrayList1.add(hashMap1);


        hashMap1= new HashMap<>();
        hashMap1.put("cuename","10.Describe your childhood hero. You should say- \nWho he/she was?");
        hashMap1.put("alltext","Is he/she still your hero?\n" +
                "\n" +
                "Why you considered him/her your childhood hero?\n" +
                "\n" +
                "And explain what his/her influence was on you as a child. In my entire life/throughout my all life, I (met/came with) a lot of people. Among of them, I would like to talk about a person who is my childhood hero in my whole.\n" +
                "\n" +
                "To commence with, the name of this person is Alam Ahmed who is beloved father. In other words, he is still hero in my life. I have been an ardent fan of his principles. His beliefs and philosophies have helped me in my life too.\n" +
                "\n" +
                "Most importantly, I always consider him as my childhood hero. I learnt about him during my teenage years. There were numerous mentions and write-ups on his methodologies. His thought process impressed me and I was fascinated to learn more about his simple and powerful practices.\n" +
                "Moreover, there are a great number (a great many) of reasons why I think that I was influenced be him a lot. First of all, I admire my father as a childhood hero and will continue doing so for his honesty, his sincerity and the sense of responsibility. Another important point is that he inspired me to get admitted to the best university of our country and he is the one who contributed the most to help me become the man I am. What is more, he insisted me to take part in the outdoor activities and motivated me to play cricket. Last but not least, he advised me about many things and always supported me and that helped me a lot to come out from the depression I had at that time. That's all what I can share with you at this moment.");
        hashMap1.put("q1","1. Is family important in your country?");
        hashMap1.put("a1","Ans. I do assume that family is important in my country. To kick off, people in my country believe that family comes first and they put their family ahead of anything else. In addition to say, people would do anything for the family and I am proud that family bonding in my country is quite strong.");
        hashMap1.put("q2","2. How do you think the family will change in the future?");
        hashMap1.put("a2","Ans. I'm certain that the family will change in the future in some reasons. Firstly, people will have a nuclear family and the size of the family will be small in the future. And then, people do not like to have more than two children nowadays and who knows they will consider having one baby policy in the distant future.\n");
        hashMap1.put("q3","3. Why is the number of joint families decreasing in modern time?");
        hashMap1.put("a3","Ans. I'm sure that the number of joint families decreasing in modern time. First of all, the city-centric life has diminished the concept of joint family and created the nuclear family. And also, a materialistic life and less inclination towards the traditions and values have ended up making our own nuclear family.");
        arrayList1.add(hashMap1);

        hashMap1= new HashMap<>();
        hashMap1.put("cuename","11.Describe a person who is a good cook. You should say-");
        hashMap1.put("alltext","who this person is?\n" +
                "\n" +
                "How you know him or her?\n" +
                "\n" +
                "What kinds of food he/she cooks?\n" +
                "\n" +
                "And explain why you think this person is good at cooking.\n" +
                "\n" +
                "In my entire life/throughout my all life, I (met/came with) a lot of people, among of them. I would like to talk about a person who is good cook.\n" +
                "\n" +
                "To start with, a person who is a good cook, and she is none other than my mother. The name of this person is Amiron Nesa who is my beloved mother.\n" +
                "\n" +
                "In other words, ever since 1 have grown up, I have seen her making different cuisines and trying out a new one.\n" +
                "\n" +
                "Most importantly, my mother has good cooking skill, and she really makes palatable food. She is able to prepare junk food as well as traditional food. Sometimes she makes desserts, and the taste is superb.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I think this person is good at cooking. First of all, I think a really great cook is calm, relaxed and enjoys the sharing of their labors, she is all these things. Another important point is that she loves cooking for the family and she regularly makes bread, rice, meats, fish, burgers, and sweet-meats, curry and so on. Apart from making Indian dishes she is well versed with knowledge to make various cuisines like Chinese, Thai, Italian and Mexican foods. Last but not least, I think that my aunt is very good at cooking also because she always likes to try new recipes and also, many of her own and experiment with them by trying different combinations for hours until she is fully satisfied. That's all what I can share with you at this moment.");
        hashMap1.put("q1","1. What are the prospects of building a career as a cook in your country? ");
        hashMap1.put("a1","Ans. In my country, there are some prospects of building a career as a cook. To Aick off, they can start their work by making a variety of food items and sell them in the market. To be totally up front, they can exhibit their culinary skills and earn name and fame. To explain, people become self-employed, and they don't feel the need for the help of others.");
        hashMap1.put("q2","2. What special dishes do you want to taste? Why?");
        hashMap1.put("a2","Ans. I would say that I wish to taste the local pizza's and several Malaysian cuisines as I really wonder what the actual taste would be like. Furthermore, a foreign cuisine what we get to eat in Bangladesh is but a version of the same which is fitted and modified to fit the taste buds of the locals. So I would like to eat more western food.");
        hashMap1.put("q3","3. What traditional food you would like your foreign friends to try?");
        hashMap1.put("a3","Ans. I'm sure that there are some traditional foods I would like my foreign friends to try in my country. First off, I'd like my foreign friends to try out Dal-Batti, Beef- curry and Dal-ruti as they have an amazing taste. And also, I feel Bangladeshi have a variety of cuisines and everything is worth a shot.");
        arrayList1.add(hashMap1);

        hashMap1= new HashMap<>();
        hashMap1.put("cuename","11.Describe your favorite author/writer. You should say-");
        hashMap1.put("alltext","What is the name of the author?\n" +
                "\n" +
                "What did you like about his books?\n" +
                "\n" +
                "How do you know him/her?\n" +
                "\n" +
                "And explain why you like this person.\n" +
                "\n" +
                "In my entire life, I came with a lot of writers. Among of them, I would like to talk about a person whom I like a lot.\n" +
                "\n" +
                "To start with, the name of this author is Barack Hussein Obama who is a former president of the United States. He was the first African-American president of the United States.\n" +
                "\n" +
                "In addition to this, Barack Obama is as fine a writer as they come. It is nearly always pleasurable to read, sentence by sentence, the prose gorgeous in places, the detail granular and vivid. He uses a very simple language that anyone can follow comfortably.Most importantly, one of my friends told me that he is the best this writer and his most books sell like hotcakes. He told me about the book two books of Barack Obama.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I like this person. First of all, the story line his book attracts me a lot. Another important point is that what sets this great writer apart from the contemporary writers is that all of his writings seem very effortless. What's more, I also like the fact that his unparalleled imagination skill allows him to describe mundane events and activities. Last but not least, I get lot of guidelines and hacks to improve my writing. That's all what I can share with you at this moment.");
        hashMap1.put("q1","1. What kinds of books are most popular with children in your country?");
        hashMap1.put("a1","Ans. I suppose that comics, detective books, rhyme collections, fairy tales, and fictions are more popular among children in my country. Furthermore, young generations prefer comics that have nice illustration while teenagers like to read detective books and fiction. But, girls, fairy tales are more endured.");
        hashMap1.put("q2","2. Why do you think some children do not read books very often?");
        hashMap1.put("a2","Ans. I suppose so some children do not read books very often for some reasons. First of all, some do not develop this habit either because he/she was too busy with other activities. And also, sometimes his parents did not inspire him to try reading books outside of the academic syllabus.\n");
        hashMap1.put("q3","3. How do you think children can be encouraged to read more?");
        hashMap1.put("a3","Ans. I would say that children can be encouraged to read more in some ways. First and foremost, parents need to be readers and motivate children to read books. And come to think of it, they should read books to their children every night and let the young minds search for a world hidden in books. However, teachers, can play a great role in school and can motivate young students to read more books by arranging reading sessions.");
        arrayList1.add(hashMap1);

        hashMap1= new HashMap<>();
        hashMap1.put("cuename","12.Describe a gift you have received that was important to you. You should say- ");
        hashMap1.put("alltext","Who gave it to you and for what occasion?\nWhat it looks like\n" +
                "\n" +
                "How you use it\n" +
                "\n" +
                "And explain why it is important to you.\n" +
                "\n" +
                "In my entire life/throughout my all life, I have bought many electronic devices, but I would like to talk about a device, which I was really important to me.\n" +
                "To commence with, the name of electronic device is Hp Elite-Book. On my 20th birthday, I was gifted with a HP-Elite Book laptop and ever since. It has been of indispensable importance to me. I was astonished to see the present that my loving mother had given me and felt thrilled and emotional.\n" +
                "\n" +
                "In other words, the laptop was a black color thin one with a 16-inch display and less than a kilo in weight.\n" +
                "\n" +
                "Most importantly, I use this laptop for different purposes like; study research and so on. Sometimes, I use it to contact with my friends to discuss about some difficult study materials.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I think it is important to you. First of all, the knowledge of computing and the related skills are really vital and that's why it is an important gift for me. Another important point is that the laptop was quite handy for me. I could search the internet, get help for my studies and learn many new things from it. What is more, I connect to the internet using this laptop and I can communicate with my friends and relatives easily. Last but not least, the laptop helps me a lot with my higher studies as well as the career I am pursuing, which is computer engineering. That's all what I can share with you at this moment.\n");
        hashMap1.put("q1","1. Do you enjoy giving and receiving gifts? Why or why not?");
        hashMap1.put("a1","Ans. I would say that there are few exact causes of the issue but the most important thing is happiness. From the outset, when I receive any gift I feel very glad. And come to think of it, when someone else receives any gifts, they also turn happy and the happiness is the most important thing in life.");
        hashMap1.put("q2","2. In your country when do people usually give gifts?");
        hashMap1.put("a2","Ans. I'm certain that it depends on situation. Firstly, Pohela Boishakh is the best time for exchanging gifts. In addition to this, it is the largest cultural occasion and majorities of the people wait eagerly for the day to appear. Apart from that, wedding, birthday, graduation day, anniversary etc. are common occasions when people in my country usually give gifts.");
        hashMap1.put("q3","3. Do you think they will change in the future? How?");
        hashMap1.put("a3","Ans. I'm sure that future is always uncertain and currently, it has possibility to change in the future. First of all, it may happen that people will move for virtual gifts rather than physical one-like someone will send electronic cards or flowers or wishes on the occasions instead of the real-life stuff.");
        arrayList1.add(hashMap1);

        hashMap1= new HashMap<>();
        hashMap1.put("cuename","13.Describe a newspaper or a magazine that you like to read. You should say- ");
        hashMap1.put("alltext","What magazine or newspaper it is?\nHow often you read it?\n" +
                "\n" +
                "What kinds of people generally read this magazine or newspaper?\n" +
                "\n" +
                "And explain why you like to read it.\n" +
                "\n" +
                "In my entire life/ throughout my all life, I have read many newspapers or magazines, but I would like to talk about a newspaper, which I really like to read. To start with, the newspaper name is 'The Daily Star' and it is one of the leading newspapers in my country. Also, it produces some live podcasts about trending\n" +
                "\n" +
                "issues. Besides, the weekend issues are made more interesting than the regular issues which I prefer most and wait for the weekend to arrive. In addition to this, as a student I mostly read, study materials 2-3 times in a day. I\n" +
                "\n" +
                "always try to read Friday edition called Special Edition from editorial page. Most importantly, all age's people read this specific because it has lots of benefits from it. By reading newspaper, people become better informed. They know what happened around them and also become more aware of the current content. Moreover, there are a great number (a great many) of reasons why I like to this newspaper. First of all, the news published on it is credible enough that one can trust the information to be true. Another important point is that reporters always try to get the right information for the readers. What is more, the number of pages comparing the price is also an advantage for the readers. Last but not least, the pages like entertainment, sports, opinion, cities etc. are filled with different sorts of news and the most important thing is the use of simple language. That's all what I can share with you at this moment.");
        hashMap1.put("q1","1. What's the influence of reading on people?");
        hashMap1.put("a1","Ans. I guess that there are some benefits of reading newspaper. First of all, the ability to read opens the door to all aspects of education. And also, reading can really broaden our horizons and update us on the up-to-the-minute news around the world.\n");
        hashMap1.put("q2","2. What's the difference between a newspaper and a magazine?");
        hashMap1.put("a2","Ans. I suppose that there are some differences between these two sources of information. Firstly, the first one is the publication; a newspaper is generally published more often than a magazine. And also, a newspaper is generally published daily whereas a magazine is published either on a weekly, monthly or quarterly basis.");
        hashMap1.put("q3","3. Do you think headlines are important?");
        hashMap1.put("a3","Ans. I would say that headlines are important in many ways. Firstly, it can grab the attention of the reader or web visitor. And then, creating a catchy headline is extremely important to bring the reader in to view an article, I suppose.");
        arrayList1.add(hashMap1);


        hashMap1= new HashMap<>();
        hashMap1.put("cuename","14.Describe your favorite gadget. You should say-");
        hashMap1.put("alltext","What is it?\n" +
                "\n" +
                "What do you use it for?\n" +
                "\n" +
                "How long have you owned it?\n" +
                "\n" +
                "And explain why it is important to you.\n" +
                "\n" +
                "In my entire life/ throughout my all life, I have bought many electronic devices, but I would like to talk about a device, which is my favorite gadget.\n" +
                "\n" +
                "To start with, the name of electronic device is Hp Elite-Book. The laptop was a black color thin one with a 16-inch display and less than a kilo in weight. Most importantly, I use this laptop for different purposes like; study research and so on. Sometimes, I use it to contact with my friends to discuss about some difficult study materials.\n" +
                "\n" +
                "Most importantly, on my 20th birthday, I was gifted with a HP-Elite Book laptop and ever since. It has been of indispensable importance to me. As far as I have owned it about 6 years at least.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I think it is important for your family. First of all, the knowledge of computing and the related skills are really vital and that's why it is an important gift for me. Another\n" +
                "important point is that the laptop was quite handy for me. I could search the internet, get help for my studies and learn many new things from it. What is more, I connect to the internet using this laptop and I can communicate with my friends and relatives easily. Last but not least, the laptop helps me a lot with my higher studies as well to the career I am pursuing, which is computer engineering, In my entire life/throughout my all life, I (met/came with) a lot of people, among of them, I would like to talk about a person who cares about me a lot.\n");
        hashMap1.put("q1","1. How can technology make our life easier?");
        hashMap1.put("a1","Ans. I do believe that technology can positively impact our lives in many ways. First of all, the internet has contributed to this to a large extent. And also, this invention dominates our daily life, and it makes it easier by providing a massive amount of information on different subjects. It has made online banking, communication and distance learning possible.");
        hashMap1.put("q2","2. Do you believe technology is making life complex from some perspectives as well? Why/Why not?");
        hashMap1.put("a2","Ans. I'm certain that technology is making life complex from some perspectives. First and foremost, we are physically less active and gaining weight to welcome a plethora of health complexities. In addition to say, too much dependency on technology, like automated traffic systems, online banking and so on, can be disastrous if something goes wrong.");
        hashMap1.put("q3","3. What are some greatest inventions you know about?");
        hashMap1.put("a3","Ans. I'm sure that there are many remarkable inventions. At the outset, Automobile and light bulb are two important inventions that were invented by Karl Benz and Thomas Edison in 1885 and 1870 respectively. And then, the latter invention, which is the internet, allows people to access almost any information located anywhere in the world at any time.");
        arrayList1.add(hashMap1);


        hashMap1= new HashMap<>();
        hashMap1.put("cuename","15.Describe one thing you are going to do next weekend. You should say- What it is?");
        hashMap1.put("alltext","When you want to do it?\n" +
                "\n" +
                "How you want to complete/achieve it?\n" +
                "\n" +
                "And explain why you want to do it.\n" +
                "\n" +
                "In my entire life/ throughout my all life, I have bought many electronic devices, but I would like to talk about a device, which I am going to buy very soon.\n" +
                "\n" +
                "To start with, the name of electronic device is Hp Elite-Book. The laptop is a black color thin one with a 16-inch display and less than a kilo in weight. It is available in different sizes and shapes and I would like to have a small piece among them.\n" +
                "\n" +
                "In addition to this, I am going to buy the latest Laptop within two months. Though I have a desktop computer at home, I want to get a laptop of a renowned brand. I have to travel to many parts of the country for study and research purposes. Carrying a laptop is easier than shifting a desktop.\n" +
                "Most importantly, I want to buy it, not only to earn a living but also learning and reading about different academic subjects. The laptop is a tiny attractive device and it costs about only 50000.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I would like to buy a Laptop. First of all, writing research proposals and reports for my study manually is difficult indeed. If I have a laptop, I can do the tasks smoothly and effectively. Another important point is that I waste my leisure hours without any effective action but if I have a laptop, definitely I would use that for some effective purposes. What is more, the best thing about owning a Laptop is that I can watch those movies at my own pace and convenience. Last but not least, I want to buy it because it helps me find different materials related to my academics. That's all what I can share with you at this moment.\n");
        hashMap1.put("q1","1. Is shopping a popular activity in your country?");
        hashMap1.put("a1","Ans. I do believe that shopping is a popular activity in your country for some reasons. First off, the most important thing is that almost sixty percent of the shoppers belong to countryside that comes here to shop their necessaries. And then, the products they get are the best in their class and quality. Additionally. there is a wide range of products and services are available in the shopping malls.");
        hashMap1.put("q2","2. How have shopping habits changed over recent years?");
        hashMap1.put("a2","Ans. I do assume that shopping habits have changed over recent years. First of all, people used to shop once or twice in a year and therefore, there were less. shopping center. However, they do it weekly basis or regularly. Furthermore, people now prefer to go to the shopping malls rather than bargaining at the street markets.");
        hashMap1.put("q3","3. Do you think shopping habits are likely to change in the future?");
        hashMap1.put("a3","Ans. I would say that think shopping habits are likely to change in the future in many ways. Firstly, it appears that due to e-commerce the entire shopping system may get a massive change in near future. Quite honestly, clients will sit before a computer, will have some mouse clicks to search their desired product or services and will order for that.");
        arrayList1.add(hashMap1);


        hashMap1= new HashMap<>();
        hashMap1.put("cuename","16.Talk about a subject you would like to study in the future. You should say");
        hashMap1.put("alltext","What is it?\n" +
                "\n" +
                "What this subject deals with?\n" +
                "\n" +
                "what benefits you would get?\n" +
                "\n" +
                "And explain why you want to study this subject.\n" +
                "\n" +
                "In my entire life/ throughout my all life, I have read different sorts of subject, but I would like to talk about a subject, which I am going to study in the future. To commence with, the name of the subject is Digital-Marketing which I'd like to take in the future. Digital-Marketing is one subject that has always piqued my interest because it is something we see all around us and also the impact it has on us, humans.\n" +
                "\n" +
                "In other words, this subject deals with consumer behavior. Lots of marketing is happening online on various digital platforms with social media being the focus. Most importantly, I would like to study Digital and Social Marketing in-depth and gain insights that I could apply in the corporate world to advance my career. I want to do several market researches while studying to understand the real-world marketing scenario.\n" +
                "\n" +
                "Moreover, there are a great number (a great many) of reasons why I would like to learn this particular subject. First of all, when I was a kid, every advertisement has fascinated me and guided my purchase decisions, now I understand why I did it. Another important point is that it can never be irrelevant as long as we have a capitalist mindset, which would in turn help me get a job of my liking. What's more, learning marketing and impacting people's lives with products/tools/services from which they could benefit has been my life's dream. Last but not least, to make a difference is the goal and marketing is a practical tool to teach people to make that difference. That's all what I can share with you at this moment.\n");
        hashMap1.put("q1","1. What makes an advertisement effective?");
        hashMap1.put("a1","Ans. I would say that there are a number of facts that makes an advertisement effective. To kick off, the advertisement on a particular product has to be absolutely relevant and specific on its message. Furthermore, for an advertisement\n" +
                "to be effective, the language or the wording has to be unique to the target audience, based on their age, gender, race, culture, religion and geographic location.");
        hashMap1.put("q2","2. What is the purpose of advertising?");
        hashMap1.put("a2","Ans. I do think that there are six main purposes of an advertisement to promote any products. First off, some advertisements may also want to demonstrate new uses for established products and send a reminder to use an existing product. And also, advertisements always try to convince customers, changing the belief about a certain brand, enhance the image of the company.");
        hashMap1.put("q3","3. What are the advantages and disadvantages of advertising?");
        hashMap1.put("a3","Ans. I do believe that there some the advantages and disadvantages of advertising. First of all, advertising allows us to learn about new products and services. And also, it also helps us compare among different kinds of products. However, it increases the cost of the products because it costs to advertise and the companies pass those advertising cost to be picked up by the customers.");
        arrayList1.add(hashMap1);


        hashMap1= new HashMap<>();
        hashMap1.put("cuename","17. Describe a piece of modern technology that you own. You should say:");
        hashMap1.put("alltext","What it is?\n" +
                "\n" +
                "What you use it for?\n" +
                "\n" +
                "How long you have owned it?\n" +
                "\n" +
                "And explain why it is important for you.\n" +
                "\n" +
                "In my entire life/ throughout my all life, I have bought many electronic devices. but I would like to talk about a modern device, which I like most.\n" +
                "\n" +
                "To commence with, the name of electronic device is Hp Elite-Book. The laptop is a black color thin one with a 16-inch display and less than a kilo in weight. I bought it approximately a year ago when I replaced my old Dell laptop with this new one. In addition to this, I use it for a variety of personal and study uses. I use the internet to find information for several projects, communicate with my friends, and listen to music using this laptop. I use my laptop more frequently than any other electronic device I have including my mobile.\n" +
                "\n" +
                "Most importantly, I've been using laptop for more than 7 years now. We need to upgrade our computers and laptops very regularly to ensure good performance; 1 replaced my old laptop with this new one for the same reason.\n" +
                "Moreover, there are a great number (a great many) of reasons why I think it is important to me. First of all, writing research proposals and reports for my study manually is difficult indeed; I can do the tasks smoothly and effectively. Another important point is that I use this laptop to keep in contact with my friends, maintain my blogs and so on. What is more, the best thing about owning a Laptop is that I can watch those movies at my own pace and convenience. Last but not least, it has definitely become an unavoidable technology for me that I use almost every day. That's all what I can share with you at this moment.");
        hashMap1.put("q1","1. How can technology make our life easier?");
        hashMap1.put("a1","Ans. I'm sure that technology can make our life easier in many ways. First off, it has made the day to day communication faster and easier. To be totally up front. communication and shopping have improved as well.\n");
        hashMap1.put("q2","2. What are some greatest inventions you know about?");
        hashMap1.put("a2","Ans. I do assume that there are many remarkable and creative inventions which make our life comfortable. First of all, mobile helps people to communicate with other and it takes a few second only. And also, I should probably mention the wheel, printing press, paper, Penicillin, Integrated Circuit and camera are also necessarily important.");
        hashMap1.put("q3","3. Can you do without your mobile phone?");
        hashMap1.put("a3","Ans. I'm certain that it constitutes an integral part of my life and I don't think without mobile. At the outset, I use it constantly every day to make calls and talk to my friends and family. Quite honestly, I think I'll have a very difficult time even if I lose it for a while.");
        arrayList1.add(hashMap1);

















    }




   public void part1table(){


        arrayList  = new ArrayList<>();



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Myself");
       hashMap.put("mq1","1. What is your full name?");
       hashMap.put("ma1","Ans. My full name is .......... . My family members and friends call me ........ and it/this is my nickname.");
       hashMap.put("mq2","2. Can I see your ID?");
       hashMap.put("ma2","Ans. Of course, / Here it is! / Here you are! / Here you go!");
       hashMap.put("mq3","3. Do you work or study?");
       hashMap.put("ma3","Ans. I am a student - a full time student. Currently, I am studying........sub......at..... College/ University and also I do some tuitions beside my study OR and also I dopart time job.");
       hashMap.put("mq4","4. Where do you live?");
       hashMap.put("ma4","Ans. I originally from ........which is situated in the western part of Bangladesh. But, nowadays, I live at Mirpur for my study purpose precisely last 4-5 years.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Work");
       hashMap.put("mq1","1.Do you have a job?");
       hashMap.put("ma1","Ans. Certainly, I currently hold the position of a Business Analyst at a prominent IT firm called IT Vista. I've been part of this company for the past two years.");
       hashMap.put("mq2","2.What is your profession?");
       hashMap.put("ma2","Ans. Primarily, my occupation serves as my primary source of income. Specifically, I operate as a part-time consultant for a business organization and engage in freelance professional content writing.");
       hashMap.put("mq3","3.How many hours do you dedicate to your work?");
       hashMap.put("ma3","Ans. Typically, I invest approximately 8 hours each day in my regular employment. Notably, I enjoy weekends off, which I use to spend quality time with my family. This routine contributes significantly to maintaining my well-being.");
       hashMap.put("mq4","4.How long have you been employed?");
       hashMap.put("ma4","Answer: In my capacity as a full-time employee, I've been in the workforce for the past four years. However, my freelancing journey commenced long before that, as it has been a consistent means of livelihood for me.\n"+"5.Do you enjoy your job?\n" +
               "\n" +
               "Ans. Absolutely, I have a genuine passion for my job. I find joy in the work I do and take pride in being productive in my field. This stems from the fact that my job not only provides my livelihood but also allows me the privilege of working in a prestigious organization.\n" +
               "\n" +
               "6.What's keeping you busy these days?\n" +
               "\n" +
               "Ans. Currently, I'm immersed in creating requirements for large-scale software projects at my office. Additionally, I am tasked with providing daily progress reports to the team lead. Furthermore, I am working on drafting a PDF manual for a client.\n" +
               "\n" +
               "7.Can you describe a typical day at work?\n" +
               "\n" +
               "Ans. Certainly, my typical workday involves extensive research on various software, understanding the strategies employed by market leaders in specific domains. I meticulously document their strengths and weaknesses and subsequently conduct meetings to present my findings.\n" +
               "\n" +
               "8.How long do you plan to continue in this line of work?\n" +
               "\n" +
               "Ans. The duration is contingent on circumstances; I foresee myself continuing in this profession for at least the next 5 to 6 years. Moreover, I have aspirations of transitioning into entrepreneurship, with plans to establish and run my own software company."
       );
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Study ");
       hashMap.put("mq1","1.What is your field of study?");
       hashMap.put("ma1","Ans. I am currently pursuing Finance because it is a highly esteemed academic discipline. Moreover, I envision turning this academic focus into a prospective career.");
       hashMap.put("mq2","2.Is Finance a popular subject at your university?");
       hashMap.put("ma2","Ans. Indeed, Finance is immensely popular and stands as one of the most sought-after courses. Additionally, many students' parents encourage them to pursue Finance, anticipating lucrative job opportunities upon graduation.");
       hashMap.put("mq3","3.Do you find enjoyment in studying Finance?");
       hashMap.put("ma3","Ans. Absolutely, I find great satisfaction in studying Finance. It's a vast subject with components that resonate differently with each student. Personally, I have a keen interest in the numerical aspects, such as calculations, which I find particularly engaging.");
       hashMap.put("mq4","4.How well do you connect with your classmates?");
       hashMap.put("ma4","Ans.Certainly, I have a wonderful relationship with all of them. Moreover, there's a strong sense of camaraderie among us, and many enjoy socializing in the evenings, fostering a close-knit group. Establishing social connections makes collaborative classwork more seamless.");
       arrayList.add(hashMap);







       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Hometown");
       hashMap.put("mq1","1.Can you tell me about your hometown?");
       hashMap.put("ma1","Ans. Certainly, my hometown is in ........., known as the folk city of Bangladesh. Located in the western part of the country, it's not far from the Padma River.");
       hashMap.put("mq2","2.What activities are there to enjoy in your hometown?");
       hashMap.put("ma2","Ans. Absolutely, there's a wealth of activities in this sizable city. For those who enjoy evenings out, there are numerous quality restaurants and bars. Alternatively, if cultural pursuits are more appealing, there are museums and art galleries to explore.");
       hashMap.put("mq3","3.How would you describe the people in your hometown?");
       hashMap.put("ma3","Ans. Generally, the people are quite friendly, although, like in many bustling cities, most individuals are often preoccupied with their activities. Consequently, it may sometimes seem as if they are not readily available for casual conversations.");
       hashMap.put("mq4","4.What aspects of your hometown do you appreciate the most?");
       hashMap.put("ma4","Ans. Specifically, the area boasts breathtaking natural beauty, making it one of the most stunning places on Earth for me. More precisely, it offers a diverse landscape, including beautiful beaches, rolling mountains, dense forests, and picturesque countryside.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Your Home");
       hashMap.put("mq1","1.What's your current residence?");
       hashMap.put("ma1","Ans. Currently, I reside on the outskirts of Panthopath, located in a district known as Dhaka city. It's approximately 15 km away from the city center.\n");
       hashMap.put("mq2","2.Is it a house or an apartment?");
       hashMap.put("ma2","Ans. Certainly, I reside in a spacious 3-bedroom apartment situated on the 11th floor of a large apartment building. It's noteworthy that this location is surrounded by natural beauty.");
       hashMap.put("mq3","3.Who shares your living space?");
       hashMap.put("ma3","Ans. Typically, I share the apartment with my parents and a younger brother. Additionally, our living arrangement is complemented by various facilities that contribute to our contentment.");
       hashMap.put("mq4","4.How spacious is your place?");
       hashMap.put("ma4","Ans. In terms of a flat, it's quite generous in size. The apartment comprises three sizable bedrooms, one for my parents and me, and another for my brother as he grows older. Furthermore, there's a smaller room designated as my study. While the kitchen is compact, it's part of a large open-plan living room, providing ample space for our family.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Food");
       hashMap.put("mq1","1.What's your preferred cuisine?");
       hashMap.put("ma1","Ans. Without a doubt, my favorite is Pizza, even though it tends to be on the expensive side. To be more precise, having Pizza is a real treat for me, and I particularly enjoy the accompaniments like pepper sauce, chips, mushrooms, and onions.");
       hashMap.put("mq2","2.Have you always had a liking for Pizza?");
       hashMap.put("ma2","Ans. Looking back, I wasn't really fond of vegetables in my younger years. Specifically, my mother would say that I had a penchant for sweet things or breakfast cereals during my childhood, with Coco Pops being my absolute favorite. However, nowadays, I enjoy Pizza with a variety of vegetables.");
       hashMap.put("mq3","3.Are there any foods you have an aversion to?");
       hashMap.put("ma3","Ans. Generally, I'm open to trying most foods, but if I had to choose, I'd say I'm not particularly fond of vegetables, especially the green ones like broccoli or cabbage. It seems they either lack flavor or have a pronounced bitterness. Perhaps, this aversion stems from their reputation for being exceptionally healthy.");
       hashMap.put("mq4","4.What are some traditional dishes in your country?");
       hashMap.put("ma4","Answer: Certainly, if you visit Bangladesh, you must indulge in a bowl of rice and fish curry, a quintessential traditional dish. This dish consists of a generous serving of white rice paired with fish curry, typically prepared with oil, onions, and potatoes, reflecting the rich culinary heritage of my country.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Weather");
       hashMap.put("mq1","1.How's the weather today?");
       hashMap.put("ma1","Ans. Currently, it's quite delightful. There were a few showers in the morning, creating a bit of chilliness, but the weather has significantly improved this afternoon. It's expected to remain pleasant for the rest of the day.");
       hashMap.put("mq2","2.What's your preferred type of weather?");
       hashMap.put("ma2","Ans. It really depends on the activity at hand. Generally, for outdoor pursuits, I prefer sunny weather that's not excessively hot, as extreme heat can become uncomfortable after a while.");
       hashMap.put("mq3","3.How would you describe the climate in your country?");
       hashMap.put("ma3","Answer: I'm originally from Bangladesh, and the predominant feature people often mention is the hot weather. Positioned on the edge of Asia, Bangladesh experiences a significant number of sunny days, contributing to the warm climate.");
       hashMap.put("mq4","4.Does the weather affect people's lives in your country?");
       hashMap.put("ma4","Ans. Typically, during the winter, the weather tends to be consistently overcast, and daylight diminishes early in the afternoon. The reduced sunlight can contribute to a sense of melancholy for some individuals, leading to a potential impact on mood. Consequently, it's not uncommon for people to increase their water intake during the winter months as a coping mechanism for the dreariness.\n");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Neighbors");
       hashMap.put("mq1","1.How acquainted are you with your neighbors?");
       hashMap.put("ma1","Ans. I'm quite familiar with my neighbors. Specifically, Mr. and Mrs. Adnan, who reside next door, are more than just neighbors—they're like close friends. Mr. Adnan, who lives across from us, is a wonderful person, and I frequently visit him to engage in chess games.");
       hashMap.put("mq2","2.How frequently do you interact with them?Why/Why not?");
       hashMap.put("ma2","Ans. I interact with them nearly every day. Specifically, whenever I step outside, there's a friendly exchange of waves between us. This frequent interaction is heightened by the fact that some of our neighbors who walk in the park in the morning often greet me.");
       hashMap.put("mq3","3.What kinds of issues do people sometimes encounter with their neighbors?");
       hashMap.put("ma3","Ans. Typically, disputes over fences and boundaries are common sources of problems among neighbors, occasionally leading to animosity. Additionally, issues such as a lack of mutual respect, irrational behavior, and pets running freely can contribute to strained relationships between neighbors.");
       hashMap.put("mq4","4.In what ways do you believe neighbors can support each other?");
       hashMap.put("ma4","Ans. Neighbors hold a significant role, often becoming more important than relatives. They stand by us in times of need, sharing both joy and sorrow. A supportive neighbor can provide tremendous assistance during times of distress and discomfort, extending a helping hand when it is most needed.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Music");
       hashMap.put("mq1","1.Do you have a preference for music, and if so, why?");
       hashMap.put("ma1","Ans. Absolutely, I have a deep appreciation for music as it serves as a source of refreshment for my mind and soul. I enjoy a variety of genres, including classical and rock");
       hashMap.put("mq2","2.Can you describe the type of music you like the most and explain why?");
       hashMap.put("ma2","Ans. Specifically, I have a fondness for classical music due to its slow rhythm and pleasant melodies. Listening to classical music helps me unwind and relax, providing a soothing experience after a day of hard work.");
       hashMap.put("mq3","3.When do you typically indulge in music?");
       hashMap.put("ma3","Answer: The timing varies, but I often turn to music when I'm feeling bored or low. I have curated different playlists that align with specific moods, assisting me in lifting my spirits. For instance, I particularly enjoy listening to music when I'm traveling.");
       hashMap.put("mq4","4.What genre of music is popular in your country?");
       hashMap.put("ma4","Answer: In my country, folk music holds significant popularity. More precisely, people often engage in dancing to the beats of folk songs during various occasions. This cultural inclination persists, although with the advent of the internet, the younger generation is also embracing a wide range of international artists.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Leisure time");
       hashMap.put("mq1","1.How do you spend your leisure time?");
       hashMap.put("ma1","Answer: Typically, I indulge in light novels during lunch breaks or after dinner, as my work keeps me quite busy, and the respite of a good book is a welcomed escape. Additionally, I often find solace in catching up on some much-needed sleep.");
       hashMap.put("mq2","2.What are common leisure activities, and why do people engage in them?");
       hashMap.put("ma2","Answer: Leisure activities vary from person to person, providing a necessary break from the demands of a hectic schedule. These activities are essential for revitalizing both the mind and body, offering a crucial opportunity to relax and recharge.");
       hashMap.put("mq3","3.What are popular leisure activities in Bangladesh/your country?");
       hashMap.put("ma3","Answer: In Bangladesh, people partake in various leisure activities. Watching films or television programs is quite common, as is reading, playing games, and listening to music. Many also engage in online activities such as surfing the internet or chatting.");
       hashMap.put("mq4","4.Why do you find these activities enjoyable?");
       hashMap.put("ma4","Answer: Personally, I find these activities enjoyable because they serve as a means of relaxation and refreshment, helping me alleviate tiredness. Moreover, engaging in leisure activities contributes to maintaining physical well-being, making them an integral part of my routine.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Holidays");
       hashMap.put("mq1","1.How do you typically spend your holidays?");
       hashMap.put("ma1","Answer: Generally, I use my holidays as an opportunity to travel, exploring new places and appreciating the beauty of nature. At times, I also choose to stay at home and have a small get-together with my family to celebrate the holidays.");
       hashMap.put("mq2","2.Who is your usual holiday companion?");
       hashMap.put("ma2","Answer: It varies based on the occasion. During Eid vacations, I prefer hanging out with friends, engaging in conversations and catching up. On the other hand, for New Year holidays, I lean towards celebrating with my family and relatives in a warm and cozy atmosphere.");
       hashMap.put("mq3","3.Do you prefer solo travel or group travel during holidays?");
       hashMap.put("ma3","Answer: Notably, I consider myself somewhat of an introvert, so I generally prefer traveling alone to serene and peaceful destinations rather than being in a group during the holidays.");
       hashMap.put("mq4","4.Why do holidays hold significance for you?");
       hashMap.put("ma4","Answer: Holidays are significant to me for several reasons. They provide a perfect opportunity to recharge my batteries after a year filled with challenges. Moreover, holidays offer valuable \"me time\" for self-reflection and planning ahead for the upcoming year.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic-Toys");
       hashMap.put("mq1","1. Did you play with toys when you were a child?");
       hashMap.put("ma1","Ans. Of course, I loved playing with toys when I was a child; I think all children do.");
       hashMap.put("mq2","2. What kinds of toys did you like?");
       hashMap.put("ma2","Ans. As far as I remember, I mostly played with toy cars, planes and action figures from films or cartoons. I also liked building things with Lego.");
       hashMap.put("mq3","3. In your country, do boys and girls play with the same types of toys?");
       hashMap.put("ma3","Ans. Definitely, not I think boys like the kinds of toys that I mentioned before, whereas girls play with dolls. I can also add that my niece, for example, doesn't like toy cars; she prefers dressing dolls in different outfits.");
       hashMap.put("mq4","4. Do you think that toys help children to learn?");
       hashMap.put("ma4","Ans. Obviously, I do. All toys encourage children to use their imagination and creativity. To be more exact, even with simple toys, children imagine situations and invent games and rules.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Shoes");
       hashMap.put("mq1","1.How do you feel about shoes?");
       hashMap.put("ma1","Answer: Without a doubt, I have a deep passion for shoes that has been with me since childhood. I firmly believe that shoes play a crucial role in bringing an entire outfit together.");
       hashMap.put("mq2","2.How frequently do you add new shoes to your collection?");
       hashMap.put("ma2","Answer: I make it a point to purchase a new pair at the beginning of each season. Currently, I'm saving up for a new car, so I've reduced the frequency of buying shoes. I prefer not to spend unnecessary money.");
       hashMap.put("mq3","3.Have you ever made an online shoe purchase?");
       hashMap.put("ma3","Answer: Not typically, I generally avoid buying shoes online. However, online shopping, in general, has become more convenient and affordable. If I do purchase shoes online, it's usually from familiar stores like Aldo and Zara.");
       hashMap.put("mq4","4.Why do some individuals have an extensive collection of shoes?");
       hashMap.put("ma4","Answer: There are various reasons for accumulating a large number of shoes. Some people are enticed by sales and buy shoes impulsively. Additionally, individuals might retain their old shoes, contributing to the growth of their collection over time.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Hobby");
       hashMap.put("mq1","1.Is it dangerous for people to spend too much time on a hobby?");
       hashMap.put("ma1","Answer: Indeed, excessive engagement in a hobby, especially one involving physical exercise, can have negative consequences. I've observed some friends who dedicate too much time to sports, leaving themselves overly fatigued and struggling to stay awake during work.");
       hashMap.put("mq2","2.Do you believe hobbies are beneficial to social life?");
       hashMap.put("ma2","Answer: Absolutely, I believe hobbies contribute positively to social life. Personally, I have made numerous friends through playing table tennis, showcasing how hobbies can be a great way to connect with others.");
       hashMap.put("mq3","3.Why do people enjoy watching games?");
       hashMap.put("ma3","Answer: People find enjoyment in watching games for various reasons. Watching games can enhance our leisure experiences, providing excitement, especially during closely contested matches.");
       hashMap.put("mq4","4.What are the advantages and disadvantages of watching games?");
       hashMap.put("ma4","Answer: There are both advantages and disadvantages to watching games. On the positive side, it can broaden our general knowledge and offer thrilling moments during close matches. However, excessive involvement in watching games can negatively impact our rest and overall well-being.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Gift");
       hashMap.put("mq1","1.When is it customary for people to give gifts in your country?");
       hashMap.put("ma1","Answer: In my country, the tradition of giving gifts is commonly observed on special occasions. Particularly, people exchange gifts during holidays such as Christmas, as well as on personal milestones like birthdays, weddings, and anniversaries.");
       hashMap.put("mq2","2.Do you bring a gift when visiting someone's home?");
       hashMap.put("ma2","Answer: Certainly, it's a practice I regularly follow. Bringing a gift when visiting someone's home is a widely accepted custom in our country. The act of presenting a thoughtful gift adds an element of excitement, especially if it aligns with the host's preferences.");
       hashMap.put("mq3","3.When was the last time you received a gift, and what was it?");
       hashMap.put("ma3","Answer: The most recent gift I received was a few weeks ago from a close friend, Nidhi. She visited Italy last November to see her grandparents, and upon her return, she gave me a perfume from Italy.");
       hashMap.put("mq4","Do you enjoy searching for gifts for others?Why/Why not?");
       hashMap.put("ma4","Answer: Absolutely, I take pleasure in exploring various shops to find the perfect gift for someone special. Although it can be time-consuming, the process of finding a suitable gift is a meaningful expression of care and love for the recipient.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Daily Routine");
       hashMap.put("mq1","1.When is it customary for people to give gifts in your country?");
       hashMap.put("ma1","Answer: In my country, the tradition of giving gifts is commonly observed on special occasions. Particularly, people exchange gifts during holidays such as Christmas, as well as on personal milestones like birthdays, weddings, and anniversaries.");
       hashMap.put("mq2","2.Do you bring a gift when visiting someone's home?");
       hashMap.put("ma2","Answer: Certainly, it's a practice I regularly follow. Bringing a gift when visiting someone's home is a widely accepted custom in our country. The act of presenting a thoughtful gift adds an element of excitement, especially if it aligns with the host's preferences.");
       hashMap.put("mq3","3.When was the last time you received a gift, and what was it?");
       hashMap.put("ma3","Answer: The most recent gift I received was a few weeks ago from a close friend, Nidhi. She visited Italy last November to see her grandparents, and upon her return, she gave me a perfume from Italy.");
       hashMap.put("mq4","4.Do you enjoy searching for gifts for others?Why/Why not?");
       hashMap.put("ma4","Answer: Absolutely, I take pleasure in exploring various shops to find the perfect gift for someone special. Although it can be time-consuming, the process of finding a suitable gift is a meaningful expression of care and love for the recipient.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Festivals");
       hashMap.put("mq1","1.Could you tell me about the most significant festival in your country?");
       hashMap.put("ma1","Answer: One of the most important festivals in my country is \"Pohela Boisak.\" Bangladesh, being a multicultural country, celebrates this festival with great historical and cultural significance, bringing people of all religions and faiths together in peace and harmony.");
       hashMap.put("mq2","2.What special foods and activities are associated with this festival?");
       hashMap.put("ma2","Answer: Typically, the celebration of \"Pohela Boisak\" begins at dawn at Dhaka University and extends throughout Bangladesh. Special foods, such as Hilsha fish and wet-rice, are commonly enjoyed. Additionally, people often wear traditional dresses like sarees and lungis during the festivities.");
       hashMap.put("mq3","3.What aspect of this festival do you enjoy the most?");
       hashMap.put("ma3","Answer: Personally, what I enjoy most about \"Pohela Boisak\" is its ability to unite people from all walks of life in the spirit of giving and charity. It's heartening to see individuals making efforts to help the less privileged sections of our society during this festival.");
       hashMap.put("mq4","4.In your opinion, are festivals important for a country?");
       hashMap.put("ma4","Answer: Absolutely, I firmly believe that festivals are crucial for any country. They play a vital role in bringing diverse communities together, fostering understanding, and promoting appreciation among people with different backgrounds and traditions.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Weekends");
       hashMap.put("mq1","How do you typically spend your weekends, and why?");
       hashMap.put("ma1","Answer: Generally, I engage in outdoor activities such as swimming, fishing, and gardening during weekends. This preference stems from spending a significant amount of time indoors at work, making me appreciate the outdoors during my free time.");
       hashMap.put("mq2","2.What is your favorite part of the weekend, and why?");
       hashMap.put("ma2","Answer: My favorite part of the weekend is undoubtedly the morning. It's a time when I don't have to worry about waking up early and rushing to get ready for work. Additionally, I appreciate the freedom to stay up late at night or not be concerned about an early bedtime.");
       hashMap.put("mq3","Do you feel your weekends are long enough?");
       hashMap.put("ma3","3.Answer: Yes, I do feel that my weekends are long enough. Weekends provide the necessary time to rejuvenate and prepare for the challenges of the upcoming week. While an extra weekend day would be welcomed by many, it doesn't seem likely in the near future.");
       hashMap.put("mq4","4.How important do you think it is to have free time on the weekends?");
       hashMap.put("ma4","Answer: Having free time on the weekends is crucial. While work is important, so is recreation, spending time with family and friends. Sufficient free time allows for recharging and meaningful interactions, demonstrating the importance of work-life balance and maintaining connections with loved ones.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Film/Movie");
       hashMap.put("mq1","1.Do you enjoy watching films?");
       hashMap.put("ma1","Answer: Absolutely! Watching films is a great way for me to relax. My friends share a similar interest in films, so it's a fun and enjoyable way for us to spend time together. We often discuss and debate the films we've watched.");
       hashMap.put("mq2","2.What genres of movies do you prefer?");
       hashMap.put("ma2","Answer: I would say I'm still a kid at heart, so I particularly enjoy watching children's movies. Despite their simplicity and innocence, these films often contain valuable life lessons. Additionally, I have a keen interest in drama and historical movies.");
       hashMap.put("mq3","3.Do you have a preference for foreign films or those made in your country?");
       hashMap.put("ma3","Answer: In my country, I exclusively watch films in English as it helps me learn new slang and expressions. Our film industry isn't extensive, and I've always been drawn to American films for their diversity and storytelling.");
       hashMap.put("mq4","4.How frequently do you watch films?");
       hashMap.put("ma4","Answer: Despite being busy, I manage to watch about one or two films a week at home. After a long day of studying, I find solace in snuggling up on the sofa and unwinding with a film. This is typically a Friday or Sunday evening ritual that I often share with my friends.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Chocolate");
       hashMap.put("mq1","1.Do you like chocolate? Why / why not?");
       hashMap.put("ma1","Ans. Obviously, I love chocolate. On top of that I like the taste, the texture and the feeling that you get when you eat it. And then, it goes really well with my favorite drink, coffee.");
       hashMap.put("mq2","2.Which type of chocolate is your preference, and why?");
       hashMap.put("ma2","Answer: I lean towards dark chocolate rather than milk chocolate because of its stronger taste. Whether in the form of a cake or enjoyed as a hot beverage, I find dark chocolate to be particularly enjoyable.");
       hashMap.put("mq3","3.When is your usual time to indulge in chocolate?");
       hashMap.put("ma3","Answer: I try to moderate my chocolate consumption, but on average, I end up enjoying something chocolatey every couple of days.");
       hashMap.put("mq4","How frequently do you treat yourself to chocolate?");
       hashMap.put("ma4","Answer: Given its relatively high price, I typically reserve indulging in chocolate as a special treat. For instance, I often treat myself to a box of hand-made dark Belgian chocolates when I receive my wages.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic -  Parks");
       hashMap.put("mq1","1.Do you have an affinity for parks? Why or why not?");
       hashMap.put("ma1","Answer: Certainly, I enjoy parks because they serve as excellent spaces for relaxation and strolls. I believe every city should have green areas where people can escape the urban crowds and spend quality time with friends and family.");
       hashMap.put("mq2","2.How frequently do you visit parks?");
       hashMap.put("ma2","Answer: There's a park very close to my residence, so I typically visit once or twice a week when the weather is pleasant. Despite time constraints, I make an effort to spend some free time in the park.");
       hashMap.put("mq3","3.Why are parks considered important in many towns and cities?");
       hashMap.put("ma3","Answer: Parks act as oases, providing a retreat from the busy urban life. They serve as places where people can have lunch, engage in physical activity, or simply take a break from work, contributing to the overall well-being of the community.");
       hashMap.put("mq4","4.What improvements do you think could enhance parks?");
       hashMap.put("ma4","Answer: Government initiatives could improve parks by installing adequate lighting along paths, especially in the evening. Additionally, the implementation of security cameras could enhance safety, making parks more enjoyable and secure for visitors.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Shopping");
       hashMap.put("mq1","1.Do you find enjoyment in shopping?");
       hashMap.put("ma1","Answer: Absolutely, I love shopping as it brings joy to my life. Whether it's for my favorite items or essential needs, the act of shopping always lifts my mood and serves as a favorite pastime.");
       hashMap.put("mq2","2.Who takes on the role of the primary shopper in your household?");
       hashMap.put("ma2","Answer: There isn't a single person designated as the primary shopper in my household. Shopping is a shared responsibility, and we often go together as a family.");
       hashMap.put("mq3","3.What type of shopping do you particularly enjoy?");
       hashMap.put("ma3","Answer: I particularly enjoy shopping for presents, especially for birthdays or Christmas. Additionally, my favorite kind of shop would have to be a bookstore.");
       hashMap.put("mq4","4.Is shopping a popular activity in your country?");
       hashMap.put("ma4","Answer: Yes, shopping is immensely popular in my country. Saturdays are notably the busiest shopping days, and many people view shopping not just as a practical necessity but also as a leisure activity.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Cooking");
       hashMap.put("mq1",".Do you have a fondness for cooking?");
       hashMap.put("ma1","Answer: Absolutely, I'm a huge fan of cooking and actually started learning how to cook when I was just eight years old. Over the years, my confidence in cooking grew, especially during my teenage years.");
       hashMap.put("mq2","2.What types of food do you enjoy eating the most? [Why?]");
       hashMap.put("ma2","Answer: I have a preference for homemade food, particularly my mother's recipes. She is an exceptional cook, and I always relish her cooking. Additionally, when dining out, I often opt for Chinese cuisine.");
       hashMap.put("mq3","3.Who typically takes on the cooking responsibilities in your home?");
       hashMap.put("ma3","Answer: Generally, my mother handles the cooking in our house, showcasing her excellent culinary skills. I often express my admiration and playfully suggest that she should start a restaurant in our city, which she finds amusing.");
       hashMap.put("mq4","4.Do you watch cooking programs on TV? [Why/Why not?]");
       hashMap.put("ma4","Answer: Not much, I would say. I'm not a big fan of TV programs and usually prefer watching movies on my laptop. Occasionally, I do tune in to programs related to travel and cooking, such as 'Hell's Kitchen.'");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Managing Time");
       hashMap.put("mq1","1.How do you typically plan your daily schedule?");
       hashMap.put("ma1","Answer: I diligently create a daily plan to effectively manage my time. I prioritize tackling the most challenging tasks in the morning when I feel the most active. Simpler tasks are usually scheduled for the afternoons or evenings.");
       hashMap.put("mq2","2.Is time management easy for you?");
       hashMap.put("ma2","Answer: Yes, time management comes easily to me. I have been adept at creating plans and managing time since my childhood. I utilize various tools such as apps, to-do lists, and notebooks to efficiently organize and execute my daily tasks.");
       hashMap.put("mq3","3.Are you skilled at organizing time?");
       hashMap.put("ma3","Answer: Certainly, I possess strong organizational skills when it comes to managing time on a daily basis. Recognizing time management as an essential skill, I consistently plan my day in advance to ensure smooth operations.");
       hashMap.put("mq4","4.What is your usual approach to organizing time?");
       hashMap.put("ma4","Answer: Typically, I plan my entire day in advance, setting achievable goals and prioritizing tasks based on their importance and urgency. I am focused and diligent in my work, aiming to stay organized and meet deadlines.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Party");
       hashMap.put("mq1","1.Do you have an inclination for parties?");
       hashMap.put("ma1","Answer: Absolutely, I love attending various kinds of parties as they bring fun and enjoyment. It's an opportunity to wear new clothes, indulge in delicious food, and engage in dancing and merriment.");
       hashMap.put("mq2","2.What are the different types of parties that people commonly host?");
       hashMap.put("ma2","Answer: There are numerous types of parties that people commonly host, each carrying its own significance. Whether it's a birthday party, a celebration party, or a farewell party, participants generally experience a high level of joy and excitement.");
       hashMap.put("mq3","3.Do you foresee parties becoming more popular in the future?");
       hashMap.put("ma3","Answer: I don't anticipate any significant change. Parties have always been a part of human socializing, and I believe they will continue to be popular in the future. The need for social interaction and enjoyment is a timeless aspect of human nature.");
       hashMap.put("mq4","4.Why do you think parties hold importance?");
       hashMap.put("ma4","Answer: Parties are crucial as they mark milestones in our lives. They serve as a means to bring people together, fostering connections and providing an outlet for relaxation and enjoyment. Celebrating through parties allows individuals to unwind and share joyous moments with others.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - History");
       hashMap.put("mq1","1.Do you have an affinity for learning history?");
       hashMap.put("ma1","Answer: Certainly, I am a passionate enthusiast when it comes to learning history. I enjoy delving into the lives of past inspirational figures and discovering obscure facts. This pursuit not only enhances my knowledge but also provides a deeper understanding of society and the world.");
       hashMap.put("mq2","2.Which historical event captures your interest the most?");
       hashMap.put("ma2","Answer: The historical event that captivates me the most is Pohela Boishakh. It serves as a fascinating window into the past, allowing me to reminisce about history and traditional practices.");
       hashMap.put("mq3","3.In your view, is history important?");
       hashMap.put("ma3","Answer: Undoubtedly, history is integral to life. Without it, people lack a foundation. It is through history that lessons are taught, and cultures and traditions are learned. Understanding history is crucial for shaping our present and future.");
       hashMap.put("mq4","4.Do you enjoy watching TV programs about history?");
       hashMap.put("ma4","Answer: Indeed, I have a fondness for watching TV programs about history. Witnessing historical achievements on screen fills me with pride and enriches my appreciation for the events that have shaped the course of human history.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Accommodation");
       hashMap.put("mq1","1.Can you describe the type of residence you currently occupy?");
       hashMap.put("ma1","Answer: Certainly, my family and I reside in a spacious apartment. The apartment covers an area of around twenty-five hundred square feet and is situated on the fourth floor. It features four bedrooms, a guest room, and a sizable dining area. Additionally, our building is conveniently located near the city center, providing us with a pleasant view.");
       hashMap.put("mq2","2.How long have you been living there?");
       hashMap.put("ma2","Answer: We have been living in this apartment for approximately three years. Prior to moving here, we resided in a rented flat within the same area.");
       hashMap.put("mq3","3.What aspects of living there do you appreciate?");
       hashMap.put("ma3","Answer: One of the aspects I truly appreciate about our current residence is the breathtaking view of the lake. The building is positioned adjacent to a lovely lake, allowing us to enjoy fresh air and leisurely walks by the lake in the morning and evening. Moreover, the proximity to various modern amenities in the area adds to our satisfaction.");
       hashMap.put("mq4","4.What type of housing would you ideally prefer?");
       hashMap.put("ma4","Answer: In an ideal situation, I would prefer living in a house rather than an apartment. However, considering the challenges of acquiring or renting a house in the city center due to high demand, we are content with our current apartment for the time being.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Fashion");
       hashMap.put("mq1","1.Do you care about fashion?");
       hashMap.put("ma1","Answer: Certainly, I used to be more concerned about fashion in my younger days. I distinctly remember being keen on emulating the styles of my favorite musicians. However, as I've grown older, I don't pay as much attention to it; I simply aim to look smart and presentable.");
       hashMap.put("mq2","2.What kind of things do you normally wear?");
       hashMap.put("ma2","Answer: The choice of clothing depends on the context. For work, I typically opt for a dress shirt and trousers, and fortunately, a tie is not mandatory. When going out casually, I prefer a polo shirt and jeans. For a relaxed setting at home, a simple t-shirt and shorts suffice.");
       hashMap.put("mq3","3.Are there any traditional clothes in your country?");
       hashMap.put("ma3","Answer: I'm not entirely certain. While there may be traditional clothes in my country, I don't recall hearing discussions about them or observing people wearing them in my daily life.");
       hashMap.put("mq4","4.Where do you usually purchase your clothes?");
       hashMap.put("ma4","Answer: Currently, I prefer the convenience of shopping at a big shopping center or department store. This approach saves time, and I can find a variety of clothing items without having to visit multiple shops scattered across town, as I did during my student days.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - The Internet");
       hashMap.put("mq1","1.How important is the internet to you?");
       hashMap.put("ma1","Answer: The internet holds immense importance for me. I rely on it for various aspects of my life, including work, research, study, and entertainment. Without it, I would feel completely lost.");
       hashMap.put("mq2","2.How often do you use the internet?");
       hashMap.put("ma2","Answer: I use the internet consistently throughout the day, every day. It has become a routine for me; I check my emails in the morning, use it for work throughout the day, and engage in activities like watching videos, reading books, or listening to music in the evening.");
       hashMap.put("mq3","3.Do you use it more for work or in your free time?");
       hashMap.put("ma3","Answer: I would say I use it for both work and leisure. On average, I spend about 4 hours a day on the internet. After coming home, when I'm too tired for physical activities, I find it convenient to download a movie, stream music, or engage in other leisure activities until I fall asleep.");
       hashMap.put("mq4","4.What are your favorite websites?");
       hashMap.put("ma4","Answer: My two favorite websites are WordPress and Google. WordPress serves as a blogging tool, facilitating easy publication of blogs and maintenance of a professional-looking website. Google, on the other hand, enables me to quickly and accurately find the information I need. Additionally, I appreciate The Guardian as a favorite site for staying up-to-date with current events.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Punctual");
       hashMap.put("mq1","1.Do you think it's important to be on time?");
       hashMap.put("ma1","Answer: Yes, I believe it's crucial to be punctual. Being on time is a matter of basic manners, and it reflects respect for others. Keeping people waiting can create a negative impression, so I consider punctuality an essential aspect of good behavior.");
       hashMap.put("mq2","2.How do you feel when others are late?");
       hashMap.put("ma2","Answer: It depends on the situation. If there's a valid reason for their lateness, such as being stuck in traffic, I'm understanding. However, if someone is late without a proper excuse and it seems like a lack of effort, I might feel a bit annoyed.");
       hashMap.put("mq3","3.Are you, yourself, late very often?");
       hashMap.put("ma3","Answer: Unfortunately, yes. Despite acknowledging it as a bad habit, I often find myself running late for things. It's an aspect I'm aware of and continuously try to improve.");
       hashMap.put("mq4","4.How do you feel when you are late?");
       hashMap.put("ma4","Answer: I feel a sense of guilt, particularly if I've kept someone waiting for an extended period. To mitigate the impact, if I anticipate being late, I make an effort to inform the person in advance, usually by sending a text message, to ensure they are aware of the delay.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Transportation");
       hashMap.put("mq1","1.What's the most popular means of transportation in your hometown?");
       hashMap.put("ma1","Answer: The most popular means of transportation in my hometown is the motorbike. According to recent news reports, a significant number of adults own motorbikes, and they are a common sight whenever I go outside.");
       hashMap.put("mq2","2.Do you usually commute by public transport?");
       hashMap.put("ma2","Answer: Yes, I typically commute by buses, especially when going to school, as I haven't acquired my own vehicle yet. Additionally, I use buses for visiting relatives or friends' homes.");
       hashMap.put("mq3","3.Is it easy to catch a bus in your country?");
       hashMap.put("ma3","Answer: Absolutely, catching a bus is incredibly easy. There is an extensive network of bus lines, making it convenient for people to access public transportation without long waiting times.");
       hashMap.put("mq4","4.Can you compare the advantages of planes and trains?");
       hashMap.put("ma4","Answer: Certainly, both planes and trains offer unique advantages for passengers. Airplanes are the fastest means of passenger transport available, providing rapid travel. On the other hand, trains are known for their safety, with rare accidents, and passengers can relax in comfortable seats while enjoying scenic views.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Friend");
       hashMap.put("mq1","1.Who is an ideal friend?");
       hashMap.put("ma1","Answer: An ideal friend is someone who is highly understanding and always ready to provide support in times of need. They should be present during both moments of joy and challenges.");
       hashMap.put("mq2","2.How do you make friends?");
       hashMap.put("ma2","Answer: Friends can be found in various places. It could be through classmates, neighbors, or even during travels. Making friends often involves shared interests, mutual understanding, and spending time together.");
       hashMap.put("mq3","3.What is the importance of friends in our life?");
       hashMap.put("ma3","Answer: Friends play a crucial role in our lives as they provide a support system for sharing feelings, thoughts, ideas, and emotions. They are companions with whom we can discuss plans, and they contribute to the overall well-being of an individual.");
       hashMap.put("mq4","4.What is the difference between friends in the past and now?");
       hashMap.put("ma4","Answer: In the past, examples of true friendships were prevalent, characterized by selflessness and mutual support. However, in contemporary times, some friendships are formed with specific reasons, and there may be elements of jealousy and selfishness, leading to a difference in the quality of friendships.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Newspapers and magazines");
       hashMap.put("mq1","1.Do you often read newspapers?");
       hashMap.put("ma1","Answer: Yes, I make it a habit to read the newspaper every day to stay informed about the latest news and current affairs. This routine has been part of my daily life for a long time.");
       hashMap.put("mq2","2.Do you prefer to read local news or international news?");
       hashMap.put("ma2","Answer: I generally have a preference for international news, especially when it involves diplomatic relations and events between countries. I find it important to stay updated on global affairs and understand the relationships between nations.");
       hashMap.put("mq3","3.Which is more popular where you live, newspapers or magazines?");
       hashMap.put("ma3","Answer: Newspapers are more popular where I live. The accessibility and concise information provided by newspapers make them a preferred choice for many people. Magazines, with longer and more specialized articles, may not be as widely read.");
       hashMap.put("mq4","4.Do many people today read newspapers?");
       hashMap.put("ma4","Answer: While many people still read newspapers, there is a trend of shifting towards online news sources. Nowadays, people are increasingly accessing news through digital platforms, and this shift may continue in the future. However, newspapers still hold significance for a considerable portion of the population.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic -  Health");
       hashMap.put("mq1","1.Is it important to you to eat healthy food?");
       hashMap.put("ma1","Answer: Yes, eating healthy food is important to me. I prefer home-cooked meals over fast food or pre-prepared options as it contributes to staying fit and maintaining good health, especially as I age.");
       hashMap.put("mq2","2.If you catch a cold, what do you do to help you feel better?");
       hashMap.put("ma2","Answer: When I catch a cold, I usually take paracetamol tablets and sometimes use a nasal spray or cough medicine. Additionally, I find it beneficial to rest and relax at home to aid the recovery process.");
       hashMap.put("mq3","3.What advantages does living in the countryside have, compared to living in a city?");
       hashMap.put("ma3","Answer: Living in the countryside offers several advantages compared to city living. Firstly, the countryside typically has cleaner air and less traffic and industrial pollution, making it a healthier environment. Additionally, the pace of life is often more relaxed, and there is a closer connection to nature.");
       hashMap.put("mq4","4.Have areas of the countryside in your country changed since you were a child?");
       hashMap.put("ma4","Answer: As far as I can recall, the countryside areas near where I live haven't changed much since my childhood. It seems that areas close to the city, like the Business District, are often protected from significant changes or construction.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Free Time");
       hashMap.put("mq1","1.How much time do you spend at home?");
       hashMap.put("ma1","Answer: I don't spend much time at home during the day due to work commitments, but I sleep at home.");
       hashMap.put("mq2","2.Do you prefer to spend your free time at home or outside the house?");
       hashMap.put("ma2","Answer: I prefer being outside the house, whether visiting family, meeting friends, or relaxing at home in the evenings.");
       hashMap.put("mq3","3.What do you do when you have some free time and you're at home?");
       hashMap.put("ma3","Answer: During free time at home, I usually watch TV or a film, listen to music, and sometimes enjoy sitting outside, especially if the weather is nice.");
       hashMap.put("mq4","4.Would you like to have more spare time to spend at home in the future?");
       hashMap.put("ma4","Answer: No, I wouldn't. I tend to get bored if I stay at home for extended periods. In the future, I anticipate preferring to go out and engage in activities rather than staying indoors.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Transport");
       hashMap.put("mq1","1.Do you use public transport? Why / why not?");
       hashMap.put("ma1","Answer: These days, I mostly drive because it's faster for my usual journeys. For instance, the half-hour drive I do twice a week would take three times as long by train and bus.");
       hashMap.put("mq2","2.Which type of public transport do you prefer? Why?");
       hashMap.put("ma2","Answer: I prefer the train. I like the ability to stroll up and down, and on some trains, I can book a seat with a table, a socket, and a window seat, allowing me to get work done.");
       hashMap.put("mq3","3.How good is the public transport where you live?");
       hashMap.put("ma3","Answer: It's quite good. There's a train station not far from my house, and it provides a direct line to the city center. Additionally, there are numerous bus routes available.");
       hashMap.put("mq4","4.Do you think people should use public transport more? Why / why not?");
       hashMap.put("ma4","Answer: It depends on the situation, but I believe that, as long as it's convenient for them, people should consider using public transport more. It's environmentally friendly, and increased usage could help reduce air pollution.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Walking");
       hashMap.put("mq1","1.Do you like walking?");
       hashMap.put("ma1","Answer: I'm not one for going on really long walks in the countryside, but I don't mind walking when I'm in a town or city, for example when I'm sightseeing in a new place.");
       hashMap.put("mq2","2.Do you think walking is important?");
       hashMap.put("ma2","Answer: Of course, I think it's important to be active, and walking is the most basic physical activity that we can do.");
       hashMap.put("mq3","3.Do you think walking in the countryside is better than walking in the city?");
       hashMap.put("ma3","Answer: Personally, I like walking in the city, especially if it's somewhere with a lot of history like London or Paris.");
       hashMap.put("mq4","4.What could be done to improve the experience of walking in cities?");
       hashMap.put("ma4","Answer: The main issues are space and safety. Pavements need to be wide enough to accommodate lots of pedestrians, and safe places to cross the street should be provided.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Singing");
       hashMap.put("mq1","1.Did you enjoy singing when you were younger?");
       hashMap.put("ma1","Answer: I was never much of a singer, and I remember that I was always a little shy and embarrassed when it came to singing in front of others.");
       hashMap.put("mq2","2.How often do you sing now?");
       hashMap.put("ma2","Answer: I don't sing in public, but I do sometimes find myself singing along to songs if I'm listening to music in the car. This happens once a week or less.");
       hashMap.put("mq3","3.Do you have a favorite song you like listening to?");
       hashMap.put("ma3","Answer: I used to have favorite songs when I was a teenager and discovering new music, but these days I prefer to listen to a variety of music rather than a particular favorite tune");
       hashMap.put("mq4","4.How important is singing in your culture?");
       hashMap.put("ma4","Answer: It seems to be really important these days. TV programs like 'GunRaj,' which are basically singing contests, are hugely popular at the moment. Many young people dream of being famous singers.");
       arrayList.add(hashMap);



       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Travelling");
       hashMap.put("mq1","1.How did you reach the examination center?");
       hashMap.put("ma1","Answer: Usually, the examination center is far from where I live, so I had to take a bus to reach the examination center by road.");
       hashMap.put("mq2","2.Do you like traveling?");
       hashMap.put("ma2","Answer: Surely, I do like traveling. Whenever I get an opportunity, I explore my country and the rest of the world. So far, I have traveled to India, Nepal, Turkey, and Malaysia outside of my country.");
       hashMap.put("mq3","3.How do you usually travel?");
       hashMap.put("ma3","Answer: Usually, I travel by road on a bus unless I am going to work, in which case, I take my motorbike. However, if I am traveling to a foreign country, then I, of course, take a plane.");
       hashMap.put("mq4","4.What are the most common types of transportation running on the streets in your country?");
       hashMap.put("ma4","Answer: Certainly, the most common types of transportation in my country are public buses and taxis. Additionally, we also have a railway system, and the government is planning to expand our water transportation system.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Cold weather");
       hashMap.put("mq1","1.Have you ever been in very cold weather? [When?]");
       hashMap.put("ma1","Answer: Generally, I live in Dhaka where the weather is hot and humid with the effects of a monsoon season. However, I did experience very cold weather when I visited the northern part of Bangladesh. I lived there with my paternal aunt for some time when I was about 10 years old, almost 20 years ago.");
       hashMap.put("mq2","2.How often is the weather cold where you come from?");
       hashMap.put("ma2","Answer: Where I live in Bangladesh, the weather remains cold for about 3 to 4 months from mid-November to February, sometimes stretching till March. However, our winter period can be dry, with temperatures varying from 10 degrees Celsius to 25 degrees Celsius.");
       hashMap.put("mq3","3.Are some parts of your country colder than others? [Why?]");
       hashMap.put("ma3","Answer: Bangladesh is a small country, but temperatures can vary significantly from the North to the South and from valley to valley, depending on the elevation. For example, the northern part, bordering with Sylhet, can be extremely cold and covered with snow because it sits at a higher altitude, while the western parts may have milder temperatures.");
       hashMap.put("mq4","4.Would you prefer to live in a hot place or a cold place? [Why?]");
       hashMap.put("ma4","Answer: Definitely, I feel cold even during the summer. Therefore, the hotter the weather is, the better it is for me. Besides, I find dealing with too many clothes every time I go out and then taking them off after coming back home to be a waste of time.");
       arrayList.add(hashMap);

       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Your favorite place");
       hashMap.put("mq1","1.What place do you most like to visit? [Why?]");
       hashMap.put("ma1","Answer: The place I like to visit the most is the \"National Zoo\" in Dhaka. I'm drawn to this stunning location, which has welcomed and bid farewell to thousands of visitors.");
       hashMap.put("mq2","2.How often do you visit this place? [Why?]");
       hashMap.put("ma2","Answer: I like to visit this place, one of the most famous attractions in Bangladesh, if not the most, twice a year. Visiting beautiful places is one of the few things I truly enjoy amid my busy work life.");
       hashMap.put("mq3","3.Why do you like it so much?");
       hashMap.put("ma3","Answer: I like visiting this place so much because of its unique features. There are very few places on this earth where one can witness the ancestors' period of animals, which is completely unknown to many people.");
       hashMap.put("mq4","4.Is it popular with many other people? [Why?]");
       hashMap.put("ma4","Answer: Certainly, it is popular with many other people because of the National Zoo in Bangladesh. Most people love to spend leisure time with family members and friends, making it a popular destination.");
       arrayList.add(hashMap);


       hashMap = new HashMap<>();
       hashMap.put("topictoy","Topic - Cold weather");
       hashMap.put("mq1","1.Have you ever been in very cold weather? [When?]");
       hashMap.put("ma1","Answer: Although I live in Dhaka, where the weather is typically hot and humid with the effects of a monsoon season, I did experience very cold weather when I visited the northern part of Bangladesh. Specifically, I lived there with my paternal aunt for some time when I was around 10 years old, almost 20 years ago.");
       hashMap.put("mq2","2.How often is the weather cold where you come from?");
       hashMap.put("ma2","Answer: Where I live in Bangladesh, the weather remains cold for about 3 to 4 months, from mid-November to February, sometimes stretching into March. However, our winter period can be dry, with temperatures ranging from 10 degrees Celsius to 25 degrees Celsius.");
       hashMap.put("mq3","3.Are some parts of your country colder than others? [Why?]");
       hashMap.put("ma3","Answer: Bangladesh is a relatively small country, but temperatures can vary significantly from the north to the south and from valley to valley, depending on the elevation. For instance, the northern part of Bhutan, bordering with Sylhet, can be extremely cold and covered with snow due to its higher altitude.");
       hashMap.put("mq4","4.Would you prefer to live in a hot place or a cold place? [Why?]");
       hashMap.put("ma4","Answer: I prefer living in a hot place. Even during the summer, I feel cold, so the hotter the weather, the better for me. Additionally, I find it inconvenient to put on and take off layers of clothing every time I go out.");
       arrayList.add(hashMap);




   }



   public void actable (){

       arrayListac = new ArrayList<>();

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-18");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2018%20ac.pdf?alt=media&token=d00b88d0-02e1-45e9-8ed3-599a604d303f");
       arrayListac.add(hashMapac);


       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-17");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2017%20ac.pdf?alt=media&token=3879d2b3-5162-4962-b49b-9f7f8de45336");
       arrayListac.add(hashMapac);



       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-16");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2016%20ac.pdf?alt=media&token=3bcfced0-254c-4b50-8052-202e5f562b22");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-15");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cambridge_ielts_15.pdf?alt=media&token=122a4268-fb0b-45cf-8ec3-62623ebd9409");
       arrayListac.add(hashMapac);


       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-14");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2014%20ac.pdf?alt=media&token=b4e3a87f-3f25-4da7-8a6f-d297fbe8e255");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-13");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%2013%20Academic.pdf?alt=media&token=c55ca87d-201c-4ae4-a478-5c7edbb7e4d2");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-12");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2012%20ac.pdf?alt=media&token=3d30db78-9d25-4960-9255-b80f41a35731");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-11");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%2011%20GT-compressed.pdf?alt=media&token=eb8b69f0-12e8-453a-a268-470869592976");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-10");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%2010%20ac-compressed.pdf?alt=media&token=75518169-7094-4f8e-9560-4ca03bf10846");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-09");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cam%209%20ac.pdf?alt=media&token=9a9dd7ee-e20e-4410-98ac-6dc7a4bcb708");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-08");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cambridge%20ielts%208%20self_.pdf?alt=media&token=f8630e2c-9542-4a0f-bea2-a0162cb77b0a");
       arrayListac.add(hashMapac);

       hashMapac = new HashMap<>();
       hashMapac.put("nameac","Cambridge-07");
       hashMapac.put("booklinkac","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cambridge%207%20Ac.pdf?alt=media&token=be7d63c0-c306-4e84-96a3-7a3a19c986f8");
       arrayListac.add(hashMapac);

   }



    public void gttable (){

        arrayListgt = new ArrayList<>();

        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-17");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cambridge%20IELTS%2017%20GT-compressed.pdf?alt=media&token=0c5db5a5-c6fb-4c7f-955c-6b7ff0914222");
        arrayListgt.add(hashMapgt);

        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-16");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cambridge%2016%20gt-compressed.pdf?alt=media&token=6ecb202a-aabe-4d5f-8b98-32e8d17cc2ca");
        arrayListgt.add(hashMapgt);


        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-15");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cambridge%20IELTS%2015%20Gen%20.pdf?alt=media&token=4ae3ce01-c223-4325-9c79-6fda6b2a98fd");
        arrayListgt.add(hashMapgt);


        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-14");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%2014%20GT.pdf?alt=media&token=210cb40f-ae43-4f2e-9e02-6b5fab4c996c");
        arrayListgt.add(hashMapgt);


        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-13");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/CAM%2013%20General.pdf?alt=media&token=9057ad4b-ec42-4c8a-8d02-733025449a45");
        arrayListgt.add(hashMapgt);

        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-12");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/CAM%2012%20General.pdf?alt=media&token=dff78f8a-9f03-4f90-8755-ff1412627963");
        arrayListgt.add(hashMapgt);


        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-11");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%2011%20GT-compressed.pdf?alt=media&token=eb8b69f0-12e8-453a-a268-470869592976");
        arrayListgt.add(hashMapgt);

        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-10");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%2010-compressed.pdf?alt=media&token=7b241942-5404-49a8-bf12-8083d41aee17");
        arrayListgt.add(hashMapgt);

        hashMapgt = new HashMap<>();
        hashMapgt.put("namegt","Cambridge-09");
        hashMapgt.put("booklinkgt","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Cam%209%20gt.pdf?alt=media&token=592d2e3c-8396-4197-bf96-91f989841742");
        arrayListgt.add(hashMapgt);






    }


    public void makkar (){


        arrayListmakkar = new ArrayList<>();

        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Academic Reading");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Academic%20Reading%2050test.pdf?alt=media&token=b86a947b-b262-437d-8ed7-b796502fecc0");
        arrayListmakkar.add(hashMapmakkar);


        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Makkar Speaking-1");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20January-April%202023%20speaking.pdf?alt=media&token=31ce8d76-8b15-4ae5-9b17-03efb1d07566");
        arrayListmakkar.add(hashMapmakkar);


        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Makkar Speaking-2");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Speaking%20May%20to%20August%202022%20new.pdf?alt=media&token=d2fc8f79-89fd-4606-9f3b-056697d1b9ff");
        arrayListmakkar.add(hashMapmakkar);

        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Makkar Speaking-3");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Speaking%20May-Aug%202023%20Final.pdf?alt=media&token=4b26d59f-19e4-458b-9830-d5098a0cc45e");
        arrayListmakkar.add(hashMapmakkar);

        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Makkar Speaking-4");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Speaking%20Sept%20to%20Dec%202022%20latest-compressed.pdf?alt=media&token=06e9edd4-80f5-4c76-b92a-b417648fdc98");
        arrayListmakkar.add(hashMapmakkar);

        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Makkar Speaking-5");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Speaking.pdf?alt=media&token=2a24777c-e601-4b79-9f6f-f289967038f2");
        arrayListmakkar.add(hashMapmakkar);

        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Writing Task 1");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Writing%20Task%201%20Academic.pdf?alt=media&token=10b61770-4e78-4305-a61e-b5c0c73ac62d");
        arrayListmakkar.add(hashMapmakkar);


        hashMapmakkar = new HashMap<>();
        hashMapmakkar.put("namemakkar","Writing Task 2 GT");
        hashMapmakkar.put("booklinkmakkar","https://firebasestorage.googleapis.com/v0/b/mb-load-5b8bd.appspot.com/o/Makkar%20Writing%20Task%202%20GT.pdf?alt=media&token=818ec42f-1d25-47ff-a67d-be7ded33e0ed");
        arrayListmakkar.add(hashMapmakkar);


    }

    public void liz (){

        arrayListliz = new ArrayList<>();

        hashMapliz = new HashMap<>();
        hashMapliz.put("nameliz","Volume-1");
        hashMapliz.put("booklinkliz","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Liz%20Grammar%20-%20Volume%201-compressed.pdf?alt=media&token=08d8fbba-9aa6-42fe-9d33-100880909eab");
        arrayListliz.add(hashMapliz);

        hashMapliz = new HashMap<>();
        hashMapliz.put("nameliz","Volume-2");
        hashMapliz.put("booklinkliz","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Liz%20Grammar%20-%20Volume%202-compressed.pdf?alt=media&token=85f5c9b8-9e97-46ab-a72e-93a8e0ef380b");
        arrayListliz.add(hashMapliz);

        hashMapliz = new HashMap<>();
        hashMapliz.put("nameliz","Volume-3");
        hashMapliz.put("booklinkliz","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Liz%20Grammar%20-%20Volume%203-compressed.pdf?alt=media&token=5bb8a5c0-bc29-4067-a4bc-bb96c8e1c31e");
        arrayListliz.add(hashMapliz);

        hashMapliz = new HashMap<>();
        hashMapliz.put("nameliz","IELTS-Official-Guide");
        hashMapliz.put("booklinkliz","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IELTS-Official-Guide-compressed.pdf?alt=media&token=250eb97f-aa56-4ab6-989c-4f486bdeb58e");
        arrayListliz.add(hashMapliz);




    }

    public void vocab (){

        arrayListvocab = new ArrayList<>();

        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","Topics Vocab");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Vocabulary%20by%20Topics.pdf?alt=media&token=1f02b7eb-dc2f-42f3-ba4f-850a244ee1a2");
        arrayListvocab.add(hashMapvocab);


        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","Saifur's Vocab");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Saifurs%20Student%20Vocabulary-compressed.pdf?alt=media&token=e0f49f81-cd1e-4227-b722-c8ffe19616d7");
        arrayListvocab.add(hashMapvocab);

        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","Writing Task-1 Vocab");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IELTS%20Writing%20Task-1%20Vocabulary.pdf?alt=media&token=4a4a8832-9ae5-46fc-ba80-7434ceb20214");
        arrayListvocab.add(hashMapvocab);

        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","Cambridge 6-13");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/cambridge%206-13%20Vocabulary.pdf?alt=media&token=2aedc4dc-7500-4310-9f0c-765e59c52be0");
        arrayListvocab.add(hashMapvocab);

        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","Band 9 Topic");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Band%209%20Topic%20Vocabulary.pdf?alt=media&token=e351578e-34a3-4def-8b5c-68e8cc0ac607");
        arrayListvocab.add(hashMapvocab);

        hashMapvocab = new HashMap<>();
        hashMapvocab.put("namevocab","800 idioms");
        hashMapvocab.put("booklinkvocab","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/800%20idioms.pdf?alt=media&token=a3a67c6b-fa67-465b-b6cd-786e680879df");
        arrayListvocab.add(hashMapvocab);
    }



    public void smanswer (){

        arrayListsm = new ArrayList<>();

        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Task-1 Simon");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Writing%20Task%201_Simon.pdf?alt=media&token=18b9e1cf-2895-41d7-a99f-9cbb0fbb85c1");
        arrayListsm.add(hashMapsm);

        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Task-2 Simon");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Writing%20Task%202_Simon.pdf?alt=media&token=215ecaa4-2a53-4c37-9f59-419b87230a9b");
        arrayListsm.add(hashMapsm);



        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Rachel Mitchell");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Rachel%20Mitchell%20Writing%20Task%202.pdf?alt=media&token=4ab9c583-c696-46f7-91fc-6db70de1b00e");
        arrayListsm.add(hashMapsm);

        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","AC Writing Task-1");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IELTS_Actual_Tests_Academic_Writing_Task_1-compressed.pdf?alt=media&token=18d4d3ff-a079-4d92-aaa3-5ae627988a6e");
        arrayListsm.add(hashMapsm);


        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","GT Writing Task-1");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IELTS_Actual_Tests_General_Writing_Task_1.pdf?alt=media&token=a7f86af8-e041-444f-ba33-dcd26160b3ce");
        arrayListsm.add(hashMapsm);



        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Journal Task-2");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IELTS%20Journal%20Writing%20Task%202.pdf?alt=media&token=e6230640-39fe-4276-96af-2ae2e0f50350");
        arrayListsm.add(hashMapsm);



        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","IDEAS Task-2");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/IDEAS%20for%20Writing%20Task%202-compressed.pdf?alt=media&token=34eeda72-1af3-4698-a67d-d6ba0faf23c1");
        arrayListsm.add(hashMapsm);



        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Combined graph");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Combine%20graph2.pdf?alt=media&token=800aa042-9b38-4fec-8aad-6d9f95384308");
        arrayListsm.add(hashMapsm);


        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Combined graph-2");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Combined%20graph.pdf?alt=media&token=921c6f55-f8b0-4e3b-90db-a57d0776c344");
        arrayListsm.add(hashMapsm);


        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","GT Task 1");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/51%20Letters%20for%20IELTS%20GT%20Writing%20Task%201.pdf?alt=media&token=85d4055f-cfbf-4d4a-9425-79729570dc64");
        arrayListsm.add(hashMapsm);



        hashMapsm = new HashMap<>();
        hashMapsm.put("smname","Task-1 Question");
        hashMapsm.put("smlink","https://firebasestorage.googleapis.com/v0/b/ielts-guide-17fdd.appspot.com/o/Writing%20Task%201.pdf?alt=media&token=1a783091-8502-45fd-9de0-a25d792d1737");
        arrayListsm.add(hashMapsm);




    }

    private void videoads (){

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3903757500487439/4541552646", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

    }
    private void bannarads2() {


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView1.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();

                count ++;
                if (count == counttime){
                    AdView1.setVisibility(View.GONE);
                    long currenttime = System.currentTimeMillis();
                    long lastclick = sharedPreferences.getLong("lastClick",0);

                    if ( currenttime - lastclick >= hidetime)
                    {
                        editor.putLong("lastClick",currenttime);
                        editor.apply();

                    } else {
                        AdView1.setVisibility(View.GONE);
                    }
                }

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        AdView1.loadAd(adRequest);
    }

    private void adssetting (){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("ads1");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

                String resultactivity = snapshot.child("w_res_v").getValue(String.class);

                if (resultactivity.contains("ON")){

                    videoads();
                }
                else if (resultactivity.contains("OFF")) {

                }
            }

            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

            }
        });

    }
    private void bannaradssetting (){

        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if(networkInfo!=null&&networkInfo.isConnected()){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("ads1");

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

                    String resultactivitybannar = snapshot.child("w_res_b").getValue(String.class);

                    if (resultactivitybannar.contains("ON")){

                        bannarads2();
                        AdView1.setVisibility(View.VISIBLE);
                    }
                    else if (resultactivitybannar.contains("OFF")) {
                        AdView1.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

                }
            });

        }
        else {
            ads1.setVisibility(View.GONE);
        }

    }

    private void internet (Context context) {
        // Inflate the custom layout
        View view = LayoutInflater.from(context).inflate(R.layout.interne_alert, null);

        // Create AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);


        AlertDialog dialog = builder.create();


        view.findViewById(R.id.close_btn).setOnClickListener(v -> {
            dialog.dismiss();
            onBackPressed();


        });



        dialog.show();
    }


}