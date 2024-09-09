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

public class Resultgt extends Fragment {

    private InterstitialAd mInterstitialAd;

    EditText gttext1,gttext2,gttext3,gttext4,gttext5,gttext6;
    TextView gtcalculate,gtcalculate1,gtcalculate2,gtreset1,gtreset2,gtreset3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_resultgt, container, false);



        gtreset1 = view.findViewById(R.id.gtreset1);
        gtreset2 = view.findViewById(R.id.gtreset2);
        gtreset3 = view.findViewById(R.id.gtreset3);

        gttext1 = view.findViewById(R.id.gttext1);
        gttext2 = view.findViewById(R.id.gttext2);
        gttext3 = view.findViewById(R.id.gttext3);
        gttext4 = view.findViewById(R.id.gttext4);
        gttext5 = view.findViewById(R.id.gttext5);
        gttext6 = view.findViewById(R.id.gttext6);
        gtcalculate = view.findViewById(R.id.gtcalculate);
        gtcalculate1 = view.findViewById(R.id.gtcalculate1);
        gtcalculate2 = view.findViewById(R.id.gtcalculate2);

        adssetting();


        //===========================calculate==================================




        gtreset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gttext1.getText().clear();
            }
        });

        gtreset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gttext2.getText().clear();
            }
        });

        gtreset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gttext3.getText().clear();
                gttext4.getText().clear();
                gttext5.getText().clear();
                gttext6.getText().clear();
            }
        });

        gtcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String stext11 = gttext1.getText().toString();


                if (stext11.length()>0){

                    float ftext1 = Float.parseFloat(stext11);

                    if(ftext1==40 && ftext1<41){

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
                    else if (ftext1==39) {

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


                    else if (ftext1>=37 && ftext1<=38) {

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
                    else if (ftext1==36) {

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
                    else if (ftext1>=34 && ftext1<=35) {
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
                    else if (ftext1>=32 && ftext1<=33) {

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
                    else if (ftext1>=30 && ftext1<=31) {

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
                    else if (ftext1>=27 && ftext1<=29) {

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
                    else if (ftext1>=23 && ftext1<=26) {

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
                    else if (ftext1>=18 && ftext1<=22) {

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
                    else if (ftext1>=15 && ftext1<=17) {

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
                    else if (ftext1>=13 && ftext1<=14) {

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
                                                .setMessage("Your Reading Band score is 3.5.")
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
                                        .setMessage("Your Reading Band score is 3.5.")
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
                                    .setMessage("Your Reading Band score is 3.5.")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }

                    }
                    else if (ftext1>=10 && ftext1<=12) {
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
                    else if (ftext1>=8 && ftext1<=9) {


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
                    else if (ftext1>=6 && ftext1<=7) {
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

                    else if (ftext1>=4 && ftext1<=5) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Reading Band score is 1.5.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();


                    }
                    else if (ftext1>=2 && ftext1<=3) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Well Done!")
                                .setMessage("Your Reading Band score is 1.0.")
                                .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();


                    }
                    else if (ftext1==1) {
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
                                .setTitle("Oh no!")
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
                            .setTitle("Oh no!")
                            .setMessage("Enter number!")
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

        gtcalculate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String stext2 = gttext2.getText().toString();


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
                                .setTitle("Well Done!!")
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
                                .setTitle("Oh no!")
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
                            .setTitle("Oh no!")
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
        gtcalculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String stext3 = gttext3.getText().toString();
                String stext4 = gttext4.getText().toString();
                String stext5 = gttext5.getText().toString();
                String stext6 = gttext6.getText().toString();



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
                                    .setTitle("Oh no!")
                                    .setMessage("Failed")
                                    .setNegativeButton("Thank You", new DialogInterface.OnClickListener() {
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
                        else if (avarege>=5.35 && avarege<=5.74) {


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
                                .setTitle("Oh no!")
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
                            .setTitle("Oh no!")
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

                String resultgt = snapshot.child("w_re_gt_v").getValue(String.class);

                if (resultgt.contains("ON")){

                    videoads();
                }
                else if (resultgt.contains("OFF")) {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}