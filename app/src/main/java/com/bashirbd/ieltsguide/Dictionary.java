package com.bashirbd.ieltsguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Dictionary extends AppCompatActivity {

    RecyclerView dic_list;
   EditText searchView;
   LinearLayout ads2;


    ArrayList<HashMap<String,String>> arrayList;
    HashMap<String,String> hashMap;

    Dbhelper dbhelper;

    AdView AdView_dic;

    int count = 0;
    int counttime = 3;

    long hidetime = 1800000;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dic_list = findViewById(R.id.dic_list);
        searchView = findViewById(R.id.searchView);
        AdView_dic = findViewById(R.id.AdView_dic);
        ads2 = findViewById(R.id.ads2);
        dbhelper= new Dbhelper(Dictionary.this);



        dataload(dbhelper.getalldata());



        sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        long currenttime = System.currentTimeMillis();
        long lastclick = sharedPreferences.getLong("lastClick",0);

        if (currenttime - lastclick >= hidetime){
            dic_ads_set();
            AdView_dic.setVisibility(View.VISIBLE);

        } else {
            AdView_dic.setVisibility(View.GONE);

        }



        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

              String key = searchView.getText().toString();
              dataload(dbhelper.searchword(key));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }


    public void dataload(Cursor cursor){



        if (cursor!=null && cursor.getCount()>0){

            arrayList = new ArrayList<>();

            while (cursor.moveToNext()){

                int id = cursor.getInt(0);
                String word= cursor.getString(1);
                String meaning =cursor.getString(2);
                String partsOfSpeech=cursor.getString(3);
                String example = cursor.getString(4);

                hashMap=new HashMap<>();
                hashMap.put("id",""+id);
                hashMap.put("word",""+word);
                hashMap.put("means",""+meaning);
                hashMap.put("part_s",""+partsOfSpeech);
                hashMap.put("exmp",""+example);
                arrayList.add(hashMap);



            }

            dec_data adapter = new dec_data();
            dic_list.setAdapter(adapter);
            dic_list.setLayoutManager(new LinearLayoutManager(Dictionary.this));
        }

    }


    private  class dec_data extends RecyclerView.Adapter<dec_data.viewholder>{


        private class viewholder extends RecyclerView.ViewHolder{

            TextToSpeech textToSpeech;
            TextView word,part_s,means,exmp;
            LinearLayout click;
            CardView show;
            ImageView close_means,speak_us,speak_uk;



            public viewholder(@NonNull View itemView) {
                super(itemView);

                 word = itemView.findViewById(R.id.word);
                 part_s = itemView.findViewById(R.id.part_s);
                 means = itemView.findViewById(R.id.means);
                 exmp = itemView.findViewById(R.id.exmp);
                 click = itemView.findViewById(R.id.click);
                 show =itemView.findViewById(R.id.show);
                 close_means = itemView.findViewById(R.id.close_means);
                 speak_us = itemView.findViewById(R.id.speak_us);
                 speak_uk = itemView.findViewById(R.id.speak_uk);
            }
        }


        @NonNull
        @Override
        public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater= getLayoutInflater();
            View view =layoutInflater.inflate(R.layout.dic_item,parent,false);



            return new viewholder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull viewholder holder, int position) {


            HashMap<String,String> hashmap = arrayList.get(position);
            String fword = hashmap.get("word");
            String fmeans = hashmap.get("means");
            String fpart_s = hashmap.get("part_s");
            String fexmp = hashmap.get("exmp");



            holder.word.setText(fword);
            holder.means.setText(fmeans+"।");
            holder.part_s.setText("("+fpart_s+")");
            holder.exmp.setText(fexmp);

            holder.show.setOnClickListener(v -> {
                holder.click.setVisibility(View.VISIBLE);

            });

            holder.close_means.setOnClickListener(v -> {
               holder.click.setVisibility(View.GONE);
            });


            holder.speak_us.setOnClickListener(v -> {

                holder.textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        if (status==TextToSpeech.SUCCESS){

                            holder.textToSpeech.setLanguage(Locale.US);
                            holder.textToSpeech.setSpeechRate(1.0f);
                            holder.textToSpeech.speak(fword,TextToSpeech.QUEUE_ADD,null);
                        }

                    }
                });

            });


            holder.speak_uk.setOnClickListener(v -> {

                holder.textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        if (status==TextToSpeech.SUCCESS){

                            holder.textToSpeech.setLanguage(Locale.UK);
                            holder.textToSpeech.setSpeechRate(1.0f);
                            holder.textToSpeech.speak(fword,TextToSpeech.QUEUE_ADD,null);
                        }

                    }
                });

            });


        }


        @Override
        public int getItemCount() {
            return arrayList.size();
        }

    }

    private void dic_ads() {


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView_dic.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();

                count ++;
                if (count == counttime){
                    AdView_dic.setVisibility(View.GONE);
                    long currenttime = System.currentTimeMillis();
                    long lastclick = sharedPreferences.getLong("lastClick",0);

                    if ( currenttime - lastclick >= hidetime)
                    {
                        editor.putLong("lastClick",currenttime);
                        editor.apply();

                    } else {
                        AdView_dic.setVisibility(View.GONE);

                    }
                }

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        AdView_dic.loadAd(adRequest);
    }
    private void dic_ads_set (){

        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if(networkInfo!=null&&networkInfo.isConnected()){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("ads1");

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

                    String allactivitybannar= snapshot.child("w_dic_page").getValue(String.class);

                    if (allactivitybannar.contains("ON")){

                        dic_ads();
                        AdView_dic.setVisibility(View.VISIBLE);

                    }
                    else if (allactivitybannar.contains("OFF")) {
                        AdView_dic.setVisibility(View.GONE);

                    }
                }

                @Override
                public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

                }
            });


        }
        else {
            ads2.setVisibility(View.GONE);
        }


    }



}