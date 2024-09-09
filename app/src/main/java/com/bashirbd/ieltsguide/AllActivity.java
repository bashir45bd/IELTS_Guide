package com.bashirbd.ieltsguide;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.RelativeLayout;



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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Random;


public class AllActivity extends AppCompatActivity {

    AdView AdView;

    int count = 0;
    int counttime = 3;

    long hidetime = 1800000;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private InterstitialAd mInterstitialAd;



    //====================acboook=================================
    RelativeLayout bookpage,modules,intro,basic,routine;

    CardView speaking,listening,reading,writing;

    LinearLayout academic,genaral,makkar,liz,vocab,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,ads;

    ImageView backintro,backro,backbasic;









    //====================acboook=================================



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);


        backintro = findViewById(R.id.backintro);
        backro = findViewById(R.id.backro);
        backbasic = findViewById(R.id.backbasic);
        ads= findViewById(R.id.ads);


        adssetting();


        AdView = findViewById(R.id.AdView);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        long currenttime = System.currentTimeMillis();
        long lastclick = sharedPreferences.getLong("lastClick",0);

        if (currenttime - lastclick >= hidetime){
            bannaradssetting();
            AdView.setVisibility(View.VISIBLE);

        } else {
            AdView.setVisibility(View.GONE);

        }




        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);



//========================================================
        bookpage = findViewById(R.id.bookpage);
        modules = findViewById(R.id.modules);
        intro = findViewById(R.id.intro);
        basic = findViewById(R.id.basic);
        routine = findViewById(R.id.routine);


        speaking = findViewById(R.id.speaking);
        listening = findViewById(R.id.listening);
        reading = findViewById(R.id.reading);
        writing = findViewById(R.id.writing);


        Bundle bun=getIntent().getExtras();
        int val =bun.getInt("VAL");

        if(val==1) {
            bookpage.setVisibility(View.VISIBLE);
            modules.setVisibility(View.GONE);


        }
       else if(val==2) {
            bookpage.setVisibility(View.GONE);
            modules.setVisibility(View.VISIBLE);

        }
        else if(val==21) {
            bookpage.setVisibility(View.GONE);
            modules.setVisibility(View.GONE);
            intro.setVisibility(View.VISIBLE);

        }
        else if(val==22) {
            bookpage.setVisibility(View.GONE);
            modules.setVisibility(View.GONE);
            intro.setVisibility(View.GONE);
            basic.setVisibility(View.VISIBLE);

        }

        else if(val==24) {
            bookpage.setVisibility(View.GONE);
            modules.setVisibility(View.GONE);
            intro.setVisibility(View.GONE);
            basic.setVisibility(View.GONE);
            routine.setVisibility(View.VISIBLE);

        }



//====================back=============================
        backintro.setOnClickListener(v -> {

            onBackPressed();
        });

        backro.setOnClickListener(v -> {

            onBackPressed();
        });

        backbasic.setOnClickListener(v -> {

            onBackPressed();
        });
// ====================back=============================







        //====================acboook=================================

        academic = findViewById(R.id.academic);



      academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){

                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 5);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);



                }
                else {
                internet(AllActivity.this);
                }



            }
        });





        //====================acboookend=================================

        //====================gtboook=================================

        genaral = findViewById(R.id.genaral);


        genaral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 6);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);




                }
                else {
                    internet(AllActivity.this);
                }


            }
        });





        //====================gtboook=================================

        //====================makkarboook=================================

        makkar = findViewById(R.id.makkar);


        makkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){

                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 7);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);



                }
                else {
                    internet(AllActivity.this);
                }

            }
        });


        //====================makkarboook=================================


        //====================lizboook=================================

        liz = findViewById(R.id.liz);


        liz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){

                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 8);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);



                }
                else {
                    internet(AllActivity.this);
                }

            }
        });


        //====================lizboook=================================


        //====================vocabboook=================================

        vocab = findViewById(R.id.vocab );


        vocab .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected()){

                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 9);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);



                }
                else {
                    internet(AllActivity.this);
                }

            }
        });


        //====================makkarboook=================================

        //===================modulespade=================================

        speaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 31);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 31);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 31);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);

                }




            }
        });

        listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 32);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 32);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 32);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);

                }



            }
        });

        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 33);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 33);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 33);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);

                }




            }
        });


        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 34);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 34);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 34);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);

                }



            }
        });




        //====================mudulespade=================================


        //====================basicpage=================================
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 60);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 60);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 60);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }







            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){

                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 61);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 61);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 61);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }




            }
        });

       b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 62);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 62);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 62);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }


            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 63);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 63);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 63);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }



            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 64);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 64);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 64);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }


            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 65);
                nextActivity.putExtras(bundle);
                startActivity(nextActivity);

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 66);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 66);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 66);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }




            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 67);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 67);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 67);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }



            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 68);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 68);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 68);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }


            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 69);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 69);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 69);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }




            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int ads_int = random.nextInt(100-5)+5;

                if (ads_int%2==0){
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(AllActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                videoads();
                                Intent nextActivity = new Intent(AllActivity.this, Result.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("VAL", 70);
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
                        Intent nextActivity = new Intent(AllActivity.this, Result.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("VAL", 70);
                        nextActivity.putExtras(bundle);
                        startActivity(nextActivity);


                    }
                }
                else {
                    Intent nextActivity = new Intent(AllActivity.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 70);
                    nextActivity.putExtras(bundle);
                    startActivity(nextActivity);
                }



            }
        });











    } //=====oncreate end here ======


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

    private void bannarads1() {


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();

                count ++;
                if (count == counttime){
                    AdView.setVisibility(View.GONE);
                    long currenttime = System.currentTimeMillis();
                    long lastclick = sharedPreferences.getLong("lastClick",0);

                    if ( currenttime - lastclick >= hidetime)
                    {
                        editor.putLong("lastClick",currenttime);
                        editor.apply();

                    } else {
                        AdView.setVisibility(View.GONE);

                    }
                }

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        AdView.loadAd(adRequest);
    }

    private void adssetting (){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("ads1");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

                String allactivity = snapshot.child("w_all_ac_v").getValue(String.class);

                if (allactivity.contains("ON")){

                    videoads();
                }
                else if (allactivity.contains("OFF")) {

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

        if(networkInfo!=null&&networkInfo.isConnected()) {


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("ads1");

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

                    String allactivitybannar= snapshot.child("w_all_c_b").getValue(String.class);

                    if (allactivitybannar.contains("ON")){

                        bannarads1();
                        AdView.setVisibility(View.VISIBLE);

                    }
                    else if (allactivitybannar.contains("OFF")) {
                        AdView.setVisibility(View.GONE);

                    }
                }

                @Override
                public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

                }
            });


        }
        else {
            ads.setVisibility(View.GONE);
            AdView.setVisibility(View.GONE);
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