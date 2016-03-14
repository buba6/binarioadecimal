package com.example.arturo.binario;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Stack;

import static android.widget.Button.*;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    EditText texto;
    private dos conversor = new dos();

    private EditText entradaUsuario,en;

    private TextView resultado;

    TextView txtBinary, txtDecimal,


    txtOctal, txtHexadecimal, txtad,txtb,tex2;

    //Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (EditText) findViewById(R.id.texto1);
       tex2 = (EditText) findViewById(R.id.bub);
        txtDecimal = (TextView) findViewById(R.id.texto1);

        txtBinary = (TextView) findViewById(R.id.txtBinary);

        txtOctal = (TextView) findViewById(R.id.txtOctal);
        txtad = (TextView) findViewById(R.id.txtad);

        txtHexadecimal = (TextView) findViewById(R.id.txtHexadecimal);

        txtDecimal.addTextChangedListener(this);

        txtb = (TextView) findViewById(R.id.bub);
        txtb.addTextChangedListener(this);

        entradaUsuario = (EditText) findViewById(R.id.texto1);
        en=(EditText) findViewById(R.id.bub);
        resultado = (TextView) findViewById(R.id.txtad);


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void click(View view) {




        Intent i = new Intent(this, dos.class);
        i.putExtra("nombre", tex2.getText() + "");
        i.putExtra("adec", txtad.getText() + "");

        startActivity(i);


    }

    public void click2(View view) {
        Intent n = new Intent(this, tres.class);

        n.putExtra("nombre1", texto.getText() + "");
        n.putExtra("BINARIO", txtBinary.getText() + "");

        startActivity(n);


    }

    public void beforeTextChanged(CharSequence sequence, int start, int count, int after)

    {

    }

    public void afterTextChanged(Editable editable) {


    }

    public void onTextChanged(CharSequence sequence, int start, int before, int count)

    {

        calculate(2, txtBinary);

        calculate(8, txtOctal);

        calculate(16, txtHexadecimal);




                convertir(txtad);





    /*catch(Exception e)

    {

        Toast.makeText(getApplicationContext(), "e", Toast.LENGTH_SHORT).show();
    }*/

}





        //txtDecimal.setKeyListener(DigitsKeyListener.getInstance("01"));


        public  void convertir (View view) {





    String eu = en.getEditableText().toString();

    long resultadoLong = conversor.convertirBinarioADecimal(eu);
    resultado.setText("" + resultadoLong);



                }










    public void calculate(int base,TextView txtView)

    {

        if(txtDecimal.getText().toString().trim().length()==0)

        {

            txtView.setText("");

            return;

        }

        try

        {

            Stack<Object> stack=new Stack<Object>();



            int number=Integer.parseInt(txtDecimal.getText().toString());

            while (number>0)

            {

                int remainder=number%base;

                if(remainder<10)


                {

                    stack.push(remainder);


                }

                else

                {

                    switch (remainder)

                    {

                        case 10:

                            stack.push("A");


                            break;

                        case 11:

                            stack.push("B");

                            break;

                        case 12:

                            stack.push("C");


                            break;


                        case 13:
                            stack.push("D");

                            break;

                        case 14:

                            stack.push("E");


                            break;

                        case 15:


                            stack.push("F");

                            break;

                    }

                }

                number/=base;

            }

            StringBuffer buffer=new StringBuffer();

            while (!stack.isEmpty())

            {

                buffer.append(stack.pop().toString());

            }

            txtView.setText(buffer.toString());

        }

        catch (Exception e)

        {

            txtView.setText(e.getMessage());

        }

    }



   }


