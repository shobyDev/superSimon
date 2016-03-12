package com.example.thomas.supersimon;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Timer;
import java.util.TimerTask;

public class FacileActivity extends AppCompatActivity {

    //timer
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;


    //nb boutons
    final static int MIN = 1;
    final static int MAX = 4;

    //boutons de couleur
    public Button btnVert;
    public Button btnRouge;
    public Button btnJaune;
    public Button btnBleu;


    private boolean en_jeu = true;
    private boolean bienRepondu = false;
    private int nbClic = 0;
    private int nbTours = 0;
    private ArrayList<Button> tabBtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facile);

        final Button btnRetour = (Button) findViewById(R.id.idButtonRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //retour(v);
                clignoterBtns();
            }
        });

        final Button btnJouer = (Button) findViewById(R.id.idButtonJouer);
        btnJouer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jouerFacile();
            }
        });

        //boutons de couleurs
        btnVert = (Button) findViewById(R.id.idButtonNiv1_1);
        btnRouge = (Button) findViewById(R.id.idButtonNiv1_2);
        btnJaune = (Button) findViewById(R.id.idButtonNiv1_3);
        btnBleu = (Button) findViewById(R.id.idButtonNiv1_4);

        btnVert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clignoter(btnVert);

                //verif
                verif(btnVert);
            }
        });

        btnRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clignoter(btnRouge);

                //verif
                verif(btnRouge);
            }
        });

        btnJaune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clignoter(btnJaune);

                //verif
                verif(btnJaune);
            }
        });

        btnBleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clignoter(btnBleu);

                //verif
                verif(btnBleu);
            }
        });


        tabBtns = new ArrayList<Button>();//on créé l'arraylist contenant les boutons
        System.out.println("FacileActivity.onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("FacileActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
            System.out.println("FacileActivity.onResume");
        }

        @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("FacileActivity.onRestart");
        }

    @Override
    protected void onPause() {
        System.out.println("FacileActivity.onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("FacileActivity.onStop");
        super.onStop();
    }

        @Override
    protected void onDestroy() {
        System.out.println("FacileActivity.onDestroy");
        super.onDestroy();
    }

    public void retour(View v) {
        finish();
    }

    public void rejouer(View v) {
        finish();
    }

    //jouer
    public void jouerFacile(){
        boutonSupplementaire();

    }

    //clignotement d'un bouton
    public void clignoter(Button btn){
        if(btn == btnVert){
            btnVert.setBackgroundColor(getResources().getColor(R.color.vertClique));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnVert.setBackgroundColor(getResources().getColor(R.color.vert));
                }
            }, 100);
        }
        else if(btn == btnRouge){
            btnRouge.setBackgroundColor(getResources().getColor(R.color.rougeClique));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnRouge.setBackgroundColor(getResources().getColor(R.color.rouge));
                }
            }, 100);
        }
        else if(btn == btnJaune){
            btnJaune.setBackgroundColor(getResources().getColor(R.color.jauneClique));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnJaune.setBackgroundColor(getResources().getColor(R.color.jaune));
                }
            }, 100);
        }
        else if(btn == btnBleu){
            btnBleu.setBackgroundColor(getResources().getColor(R.color.bleuClique));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnBleu.setBackgroundColor(getResources().getColor(R.color.bleu));
                }
            }, 100);
        }
    }

    //ajouter un bouton dans l'arraylist
    public void boutonSupplementaire(){
        //random
        Random rand = new Random();
        int num = rand.nextInt(4);

        if(num==0){
            //bouton Vert
            btnVert.setText(String.valueOf(nbTours+1));
            clignoter(btnVert);
            tabBtns.add(btnVert);
        }
        else if(num==1){
            //bouton Rouge
            btnRouge.setText(String.valueOf(nbTours+1));
            clignoter(btnRouge);
            tabBtns.add(btnRouge);
        }
        else if(num==2){
            //bouton Jaune
            btnJaune.setText(String.valueOf(nbTours+1));
            clignoter(btnJaune);
            tabBtns.add(btnJaune);
        }
        else if(num==3){
            //bouton Bleu
            btnBleu.setText(String.valueOf(nbTours+1));
            clignoter(btnBleu);
            tabBtns.add(btnBleu);
        }

        nbTours++;
    }



    /*** PROBLEME ***/


    //fais clignoter les boutons de l'arraylist
    public void clignoterBtns(){
        for(int i=0;i<tabBtns.size();i++){
            final int j = i;
            final Handler handler = new Handler();
            Runnable myrunnable = (new Runnable() {
                @Override
                public void run() {
                    clignoter(tabBtns.get(j)); // fonction clignoter permet de faire clignoter un bouton passé en parametre
                }
            });
            handler.postDelayed(myrunnable,1000);
        }
        //boutonSupplementaire();
    }


    /*** FIN PROBLEME ***/

    //verif du boutons cliqués
    public void verif(Button btn){
        if(nbClic == tabBtns.size()){
            if(btn == tabBtns.get(nbClic)) {
                bienRepondu = true;
            }
            else{
                fin();
            }
            //fonction clignoterBtns + new btn
        }
        else if(btn == tabBtns.get(nbClic)){
            bienRepondu = true;
            nbClic ++;
        }
        else{
            fin();
        }
    }

    //fin
    public void fin(){
        Intent intentMS = new Intent(this, GameOverActivity.class);
        startActivity(intentMS);
    }

}
