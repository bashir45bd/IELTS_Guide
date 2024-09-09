package com.bashirbd.ieltsguide;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
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

import java.util.Random;

public class ResultAc extends Fragment {
    private InterstitialAd mInterstitialAd;

    EditText text1,text2,text3,text4,text5,text6;
    TextView reset1,reset2,reset3,calculate,calculate1,calculate2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view = inflater.inflate(R.layout.fragment_result_ac, container, false);



        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        text3 = view.findViewById(R.id.text3);
        text4 = view.findViewById(R.id.text4);
        text5 = view.findViewById(R.id.text5);
        text6 = view.findViewById(R.id.text6);
        reset1 = view.findViewById(R.id.reset1);
        reset2 = view.findViewById(R.id.reset2);
        reset3 = view.findViewById(R.id.reset3);
        calculate = view.findViewById(R.id.calculate);
        calculate1 = view.findViewById(R.id.calculate1);
        calculate2 = view.findViewById(R.id.calculate2);


        adssetting();




        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.getText().clear();

            }
        });


        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.getText().clear();

            }
        });

        reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text3.getText().clear();
                text4.getText().clear();
                text5.getText().clear();
                text6.getText().clear();

            }
        });


        //===========================calculate==================================

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String stext1 = text1.getText().toString();


                if (stext1.length()>0){

                    float ftext = Float.parseFloat(stext1);

                    if(ftext>=39 && ftext<=40){

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 9.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 9.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 9.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }

                    else if (ftext>=37 && ftext<=38) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 8.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 8.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 8.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext>=35 && ftext<=36) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 8.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 8.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 8.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext>=33 && ftext<=34) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 7.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 7.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 7.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext>=30 && ftext<=32) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 7.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 7.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 7.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext>=27 && ftext<=29) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 6.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 6.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 6.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext>=23 && ftext<=26) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 6.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 6.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 6.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }




                    }
                    else if (ftext>=19 && ftext<=22) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 5.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 5.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 5.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }
                    else if (ftext>=15 && ftext<=18) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 5.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 5.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 5.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }
                    else if (ftext>=13 && ftext<=14) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 4.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 4.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 4.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext>=10 && ftext<=12) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 4.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 4.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 4.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext>=8 && ftext<=9) {

                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Reading Band score is 3.5.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();


                    }
                    else if (ftext>=6 && ftext<=7) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Reading Band score is 3.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Reading Band score is 3.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Reading Band score is 3.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext>=4 && ftext<=5) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Reading Band score is 2.5.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    else if (ftext>=2 && ftext<=3) {


                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Reading Band score is 2.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();

                    }

                    else if (ftext==1) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Oh no!")
                                .setMessage("Your Reading Band score is 0.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    else {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Oh No!")
                                .setMessage("Please enter a valid number")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }

                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Oh No!")
                            .setMessage("Enter Number")
                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }

            }
        });

        //=========================calculate1=========================

        calculate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String stext2 = text2.getText().toString();


                if (stext2.length()>0){

                    float ftext2 = Float.parseFloat(stext2);
                    if (ftext2>=39 && ftext2<=40){


                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 9.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 9.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 9.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=37 && ftext2<=38) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 8.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 8.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 8.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }



                    }
                    else if (ftext2>=35 && ftext2<=36) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 8.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 8.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 8.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=32 && ftext2<=34) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 7.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 7.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 7.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }
                    else if (ftext2>=30 && ftext2<=31) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 7.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 7.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 7.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=26 && ftext2<=29) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 6.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 6.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 6.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=23 && ftext2<=25) {


                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 6.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 6.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 6.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }
                    else if (ftext2>=18 && ftext2<=22) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 5.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 5.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 5.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=16 && ftext2<=17) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 5.0.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 5.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 5.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=13 && ftext2<=15) {
                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 4.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 4.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 4.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=10 && ftext2<=12) {

                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Listening Band score is 4.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    else if (ftext2>=8 && ftext2<=9) {

                        Random random = new Random();
                        int ads_int = random.nextInt(100-5)+5;

                        if (ads_int%2==0){

                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(getActivity());
                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        super.onAdDismissedFullScreenContent();
                                        mInterstitialAd = null;
                                        videoads();

                                        new AlertDialog.Builder(getActivity())
                                                .setTitle("Well Done!")
                                                .setMessage("Your Listening Band score is 3.5.")
                                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                })
                                                .show();
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                        super.onAdFailedToShowFullScreenContent(adError);
                                        mInterstitialAd = null;
                                    }
                                });
                            } else {

                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Well Done!")
                                        .setMessage("Your Listening Band score is 3.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                            }


                        }
                        else {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Well Done!")
                                    .setMessage("Your Listening Band score is 3.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext2>=6 && ftext2<=7) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Listening Band score is 3.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    else if (ftext2>=4 && ftext2<=5) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Listening Band score is 2.5.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }
                    else if (ftext2>=2 && ftext2<=3) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Listening Band score is 2.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }

                    else if (ftext2==1) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Oh no!")
                                .setMessage("Your Listening Band score is 0.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }



                    else {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Oh No!")
                                .setMessage("Please enter a valid number")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    }


                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Oh No!")
                            .setMessage("Enter Number")
                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }

            }
        });
//=============================================================
        calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String stext3 = text3.getText().toString();
                String stext4 = text4.getText().toString();
                String stext5 = text5.getText().toString();
                String stext6 = text6.getText().toString();



                if (stext3.length()>0 && stext4.length()>0 && stext5.length()>0 && stext6.length()>0) {


                    float ftext3 = Float.parseFloat(stext3);
                    float ftext4 = Float.parseFloat(stext4);
                    float ftext5 = Float.parseFloat(stext5);
                    float ftext6 = Float.parseFloat(stext6);

                    float total = (float) ftext3+ftext4+ftext5+ftext6;

                    float avarege = total/4;

                    if (ftext3<10 && ftext4<10 && ftext5<10 && ftext6<10)
                    {
                        if (avarege>=0 && avarege<=1.24) {

                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Oh No!")
                                    .setMessage("Failed")
                                    .setNegativeButton("Thank You!", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                        else if (avarege>=1.25 && avarege<=1.74) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Congratulation Buddy!")
                                    .setMessage("Your Band Score is 1.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                        else if (avarege>=1.75 && avarege<=2.24) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Congratulation Buddy!")
                                    .setMessage("Your Band Score is 2.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                        else if (avarege>=2.25 && avarege<=2.74) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Congratulation Buddy!")
                                    .setMessage("Your Band Score is 2.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                        else if (avarege>=2.75 && avarege<=3.24) {


                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Congratulation Buddy!")
                                    .setMessage("Your Band Score is 3.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                        else if (avarege>=3.25 && avarege<=3.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 3.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 3.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 3.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }



                        }
                        else if (avarege>=3.75 && avarege<=4.24) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 4.0.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 4.0.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 4.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }
                        else if (avarege>=4.25 && avarege<=4.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 4.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 4.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 4.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }


                        }
                        else if (avarege>=4.75 && avarege<=5.24) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 5.0.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 5.0.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 5.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }
                        else if (avarege>=5.25 && avarege<=5.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 5.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 5.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 5.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }
                        else if (avarege>=5.75 && avarege<=6.24) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 6.0.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 6.0.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 6.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }


                        }
                        else if (avarege>=6.25 && avarege<=6.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 6.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 6.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 6.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }
                        else if (avarege>=6.75 && avarege<=7.24) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 7.0.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 7.0.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 7.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }
                        else if (avarege>=7.25 && avarege<=7.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 7.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 7.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 7.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }


                        }
                        else if (avarege>=7.75 && avarege<=8.24) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 8.0.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 8.0.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 8.0.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }

                        else if (avarege>=8.25 && avarege<=8.74) {

                            Random random = new Random();
                            int ads_int = random.nextInt(100-5)+5;

                            if (ads_int%2==0){
                                if (mInterstitialAd != null) {
                                    mInterstitialAd.show(getActivity());
                                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent();
                                            mInterstitialAd = null;
                                            videoads();

                                            new AlertDialog.Builder(getActivity())
                                                    .setTitle("Congratulation Buddy!")
                                                    .setMessage("Your Band Score is 8.5.")
                                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .show();
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            super.onAdFailedToShowFullScreenContent(adError);
                                            mInterstitialAd = null;
                                        }
                                    });
                                } else {

                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Congratulation Buddy!")
                                            .setMessage("Your Band Score is 8.5.")
                                            .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            })
                                            .show();

                                }

                            }
                            else {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Congratulation Buddy!")
                                        .setMessage("Your Band Score is 8.5.")
                                        .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }

                        }


                        else if (avarege>=8.75 && avarege<=9) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Congratulation Buddy!")
                                    .setMessage("Your Band Score is 9.0.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }


                    }
                    else {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Oh No!")
                                .setMessage("Please enter a valid number")
                                .setNegativeButton("Thank You!", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();

                    }


                }
                else {

                    new AlertDialog.Builder(getActivity())
                            .setTitle("Oh No!")
                            .setMessage("Enter number")
                            .setNegativeButton("Thank You!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }




            }
        });

        //=================================================
        return view;

    }

    private void videoads (){

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(getActivity(),"ca-app-pub-3903757500487439/4541552646", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@org.checkerframework.checker.nullness.qual.NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@org.checkerframework.checker.nullness.qual.NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

    }
    private void adssetting (){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("ads1");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String resultac = snapshot.child("w_re_ac_v").getValue(String.class);

                if (resultac.contains("ON")){

                    videoads();
                }
                else if (resultac.contains("OFF")) {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}