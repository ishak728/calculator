package com.ishak.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String girilenDeger="";
    double sayi1=0,sayi2=0;
    double result=0;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editTxt1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {  ///klavyenin gelmesini engeller
            editText1.setShowSoftInputOnFocus(false);
        } else {
            editText1.setTextIsSelectable(true);
        }
    }


    public void btn(View view){


        switch (view.getId()){
            case R.id.btn0:{
                girilenDeger+=0;break;
            }
            case R.id.btn1:{
                girilenDeger+=1;break;
            }
            case R.id.btn2:{
                girilenDeger+=2;break;
            }
            case R.id.btn3:{
                girilenDeger+=3;break;
            }
            case R.id.btn4:{
                girilenDeger+=4;break;
            }
            case R.id.btn5:{
                girilenDeger+=5;break;
            }
            case R.id.btn6:{
                girilenDeger+=6;break;
            }
            case R.id.btn7:{
                girilenDeger+=7;break;
            }
            case R.id.btn8:{
                girilenDeger+=8;break;
            }
            case R.id.btn9:{
                girilenDeger+=9;break;
            }
            case R.id.btnPozitive:{
                girilenDeger+="+";break;
            }
            case R.id.btnNegative:{
                girilenDeger+="-";break;
            }
            case R.id.btnMultiply:{
                girilenDeger+="x";break;
            }
            case R.id.btnDivide:{
                girilenDeger+="/";break;
            }

            case R.id.btnCiftSifir:{
                girilenDeger+="00";break;
            }
            case R.id.btnAC:{
                girilenDeger="";
                result=0;break;
            }
            case R.id.btnDel:{
                if(!girilenDeger.matches("")){
                    girilenDeger=editText1.getText().toString();
                    girilenDeger=girilenDeger.substring(0,(girilenDeger.length()-1));break;
                }

            }
            case R.id.btnEqual:{
                girilenDeger=editText1.getText().toString();
               girilenDeger=String.valueOf(calculate());

               int deger1=(int)Double.parseDouble(girilenDeger);
               if(deger1==Double.parseDouble(girilenDeger)){
                   girilenDeger=String.valueOf(deger1);
               }

                break;
            }

            case R.id.btnNokta:{
                girilenDeger+=".";break;
            }

        }

        editText1.setText(girilenDeger);


    }

    public double calculate(){
        char operand=' ';
        int i=0,x=1;
        String girilenDegerYedek=girilenDeger;
        if(girilenDeger.charAt(0)=='-'){
            girilenDeger=girilenDeger.substring(1);
        }
        for (i=0; i < girilenDeger.length(); i++) {///operandın indeksini bulmak içindir
            if(girilenDeger.charAt(i)=='/'||girilenDeger.charAt(i)=='x'||girilenDeger.charAt(i)=='+'||girilenDeger.charAt(i)=='-'){
                x=0;
                operand=girilenDeger.charAt(i);
                break;
            }
        }
        if(x==1){//(+,-,*,/)sembollerden birinin "girilenDeger"değişkeninde olup olmadığını sorgular
            result=Double.parseDouble(girilenDeger);
            return result;
        }

        sayi1=Double.parseDouble(girilenDeger.substring(0,i));
        if(girilenDegerYedek.charAt(0)=='-'){
            sayi1*=-1;
        }
        i++;

        if(karekterMi(girilenDeger.charAt(i))){
            return sayi1;
        }
        sayi2=Double.parseDouble(girilenDeger.substring(i));

        if(operand=='/'){
            result=(sayi1/sayi2);
        }
       else if(operand=='x'){
            result=(sayi1*sayi2);
       }
        else if(operand=='+'){
            result= (sayi1+sayi2);
        }
       else if(operand=='-'){
            result= (sayi1-sayi2);
        }
        return result ;

        }
public boolean karekterMi(char girilen){
        int deger = girilen;
        boolean durum = false;

        if(deger>64 && deger<91 || deger>96 && deger<123){
        durum = true;
        }

        return durum;
        }

        }