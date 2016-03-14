package com.example.arturo.binario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class dos extends AppCompatActivity  {

    TextView text, text2;
    EditText txtDecimal;
    TextView txtBinary, txtOctal, txtHexadecimal;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
        text = (TextView) findViewById(R.id.num);
        boolean b = true;

       /*/ text.addTextChangedListener(new TextWatcher(){ public void afterTextChanged(Editable s)
        {} public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {} public void onTextChanged(CharSequence s, int start, int before, int count)
        { String strEnteredVal = text.getText().toString(); if(!strEnteredVal.equals(""))
        { int num=Integer.parseInt(strEnteredVal); if(num==1234){ text.setText(""+num); }else{ text.setText(""); } } }});*/


        //text.setKeyListener(DigitsKeyListener.getInstance("01"));


        String n = getIntent().getStringExtra("nombre");
        text.setText(n);

        //text.setText(n);

        String n2 = getIntent().getStringExtra("adec");

        text2 = (TextView) findViewById(R.id.n3);
        text2.setText(n2);


    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private long convertirBaseADecimal(String numeroConvertir, int base) {


        long resultado = 0;

        int numeroDigitos = numeroConvertir.length();

        for (int i = 0; i < numeroDigitos; i++) {

            int digito;

            String digitoString = "" + numeroConvertir.charAt(i);

            if (digitoString.equalsIgnoreCase("a")) {

                digito = 10;

            } else if (digitoString.equalsIgnoreCase("b")) {

                digito = 11;

            } else if (digitoString.equalsIgnoreCase("c")) {

                digito = 12;

            } else if (digitoString.equalsIgnoreCase("d")) {

                digito = 13;

            } else if (digitoString.equalsIgnoreCase("e")) {

                digito = 14;

            } else if (digitoString.equalsIgnoreCase("f")) {

                digito = 15;

            } else {

                digito = Integer.parseInt(digitoString);

            }

            int potencia = numeroDigitos - i - 1;


            resultado += (digito * Math.pow(base, potencia));

        }


        return resultado;


    }


    public long convertirBinarioADecimal(String binario) {

        return convertirBaseADecimal(binario, 2);


    }

    }

