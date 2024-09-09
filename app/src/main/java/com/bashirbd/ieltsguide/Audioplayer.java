package com.bashirbd.ieltsguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
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

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Audioplayer extends AppCompatActivity {


    PDFView pdfView_ac,pdfView_gt,pdfView_makkar,pdfView_vocab,pdfView_liz,pdfView_smb;

    LottieAnimationView loadanim;


    RelativeLayout acpage,gtbshower,makkarbshower,lizbshower,vocabbshower,smbshower;



    public static String audiolink = "";
    public static String booklinkac = "";
    public static String booklinkgt = "";
    public static String booklinkmakkar = "";
    public static String booklinkliz = "";
    public static String booklinkvocab ="";

    public static String smlink ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_audioplayer);




        pdfView_ac= findViewById(R.id.pdfView_ac);
        pdfView_gt= findViewById(R.id.pdfView_gt);
        pdfView_makkar= findViewById(R.id.pdfView_makkar);
        pdfView_liz= findViewById(R.id.pdfView_liz);
        pdfView_vocab= findViewById(R.id.pdfView_vocab);
        pdfView_smb= findViewById(R.id.pdfView_smb);




        acpage = findViewById(R.id.acpage);
        gtbshower = findViewById(R.id.gtbshower);
        makkarbshower = findViewById(R.id.makkarbshower);
        lizbshower = findViewById(R.id.lizbshower);
        vocabbshower = findViewById(R.id.vocabbshower);
        smbshower = findViewById(R.id.smbshower);



        loadanim = findViewById(R.id.loadanim);


        loadanim.setVisibility(View.VISIBLE);



        Bundle bun=getIntent().getExtras();
        int val =bun.getInt("VAL");


         if(val==111) {
            acpage.setVisibility(View.VISIBLE);
            gtbshower.setVisibility(View.GONE);
            makkarbshower.setVisibility(View.GONE);
            lizbshower.setVisibility(View.GONE);
            vocabbshower.setVisibility(View.GONE);
            smbshower.setVisibility(View.GONE);

            String pdfUrl = booklinkac;
            pdfView_ac.setVisibility(View.INVISIBLE);
            loadPdfFromUrlac(pdfUrl);

        }
        else if(val==112) {
            acpage.setVisibility(View.GONE);
            gtbshower.setVisibility(View.VISIBLE);
            makkarbshower.setVisibility(View.GONE);
            lizbshower.setVisibility(View.GONE);
            vocabbshower.setVisibility(View.GONE);
            smbshower.setVisibility(View.GONE);

            String pdfUrlgt = booklinkgt;
            pdfView_gt.setVisibility(View.INVISIBLE);
            loadPdfFromUrlgt(pdfUrlgt);
        }
        else if(val==113) {

            acpage.setVisibility(View.GONE);
            gtbshower.setVisibility(View.GONE);
            makkarbshower.setVisibility(View.VISIBLE);
            lizbshower.setVisibility(View.GONE);
            vocabbshower.setVisibility(View.GONE);
            smbshower.setVisibility(View.GONE);


            String pdfUrlmakkar = booklinkmakkar;
            pdfView_makkar.setVisibility(View.INVISIBLE);
            loadPdfFromUrlmakkar(pdfUrlmakkar);
        }
        else if(val==114) {

            acpage.setVisibility(View.GONE);
            gtbshower.setVisibility(View.GONE);
            makkarbshower.setVisibility(View.GONE);
            lizbshower.setVisibility(View.VISIBLE);
            vocabbshower.setVisibility(View.GONE);
            smbshower.setVisibility(View.GONE);

            String pdfUrlliz = booklinkliz;
            pdfView_liz.setVisibility(View.INVISIBLE);
            loadPdfFromUrlliz(pdfUrlliz);
        }
        else if(val==115) {

            acpage.setVisibility(View.GONE);
            gtbshower.setVisibility(View.GONE);
            makkarbshower.setVisibility(View.GONE);
            lizbshower.setVisibility(View.GONE);
            vocabbshower.setVisibility(View.VISIBLE);
            smbshower.setVisibility(View.GONE);

            String pdfUrlvocab = booklinkvocab;
            pdfView_vocab.setVisibility(View.INVISIBLE);
            loadPdfFromUrlvocab(pdfUrlvocab);
        }

        else if(val==116) {

            acpage.setVisibility(View.GONE);
            gtbshower.setVisibility(View.GONE);
            makkarbshower.setVisibility(View.GONE);
            lizbshower.setVisibility(View.GONE);
            vocabbshower.setVisibility(View.GONE);
            smbshower.setVisibility(View.VISIBLE);

            String pdfUrlsmb = smlink;
            pdfView_smb.setVisibility(View.INVISIBLE);
            loadPdfFromUrlsmb(pdfUrlsmb);
        }















    } //==================oncreate end =========================



    private void loadPdfFromUrlac(String pdfUrl) {
        OkHttpClient client = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrl)
                .build();

        client.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytes = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_ac.fromBytes(pdfBytes)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {
                                        loadanim.setVisibility(View.GONE);
                                        pdfView_ac.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }
    private void loadPdfFromUrlgt(String pdfUrlgt) {
        OkHttpClient clientgt = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrlgt)
                .build();

        clientgt.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytesgt = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_gt.fromBytes(pdfBytesgt)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {

                                        loadanim.setVisibility(View.GONE);
                                        pdfView_gt.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }

    private void loadPdfFromUrlmakkar(String pdfUrlmakkar) {
        OkHttpClient clientgt = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrlmakkar)
                .build();

        clientgt.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytesgt = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_makkar.fromBytes(pdfBytesgt)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {

                                        loadanim.setVisibility(View.GONE);
                                        pdfView_makkar.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }

    private void loadPdfFromUrlliz(String pdfUrlliz) {
        OkHttpClient clientgt = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrlliz)
                .build();

        clientgt.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytesgt = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_liz.fromBytes(pdfBytesgt)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {

                                        loadanim.setVisibility(View.GONE);
                                        pdfView_liz.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }

    private void loadPdfFromUrlvocab(String pdfUrlvocab) {
        OkHttpClient clientgt = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrlvocab)
                .build();

        clientgt.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytesgt = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_vocab.fromBytes(pdfBytesgt)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {

                                        loadanim.setVisibility(View.GONE);
                                        pdfView_vocab.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }

    private void loadPdfFromUrlsmb(String pdfUrlsmb) {
        OkHttpClient clientgt = new OkHttpClient();
        Request requestgt = new Request.Builder()
                .url(pdfUrlsmb)
                .build();

        clientgt.newCall(requestgt).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final byte[] pdfBytesgt = response.body().bytes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                        pdfView_smb.fromBytes(pdfBytesgt)

                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .fitEachPage(true)
                                .pageFling(true)
                                .onLoad(new OnLoadCompleteListener() {
                                    @Override
                                    public void loadComplete(int nbPages) {

                                        loadanim.setVisibility(View.GONE);
                                        pdfView_smb.setVisibility(View.VISIBLE);
                                    }
                                })
                                .enableDoubletap(true)
                                .enableSwipe(true)
                                .fitEachPage(true)
                                .pageSnap(true)
                                .scrollHandle(new DefaultScrollHandle(Audioplayer.this))
                                .load();
                    }
                });
            }
        });
    }




}