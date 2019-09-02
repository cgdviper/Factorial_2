package com.example.ejemplo01;

import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    EditText EDT1 ;
    Button BT1;
    TextView txterror,txtres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EDT1 = (EditText) findViewById(R.id.editText1);
        BT1 =  (Button) findViewById(R.id.button1);

        txterror = (TextView) findViewById(R.id.textView3);
        txtres = (TextView) findViewById(R.id.textView4);

        EDT1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               txterror.setText("");
               txtres.setText("");
            }
        });

        BT1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicboton();
            }
        });




    }

    private void borrar() {
        EDT1.setText("");
        txtres.setText("");

    }

    private boolean validar(String M)
    {
        boolean band=false;
        Pattern p = Pattern.compile("^([1-9][0-9]*|0)$");  // exp. reg que representa lo que deseo escribir en el textfield
        Matcher m1 = p.matcher(M);  // aplico el patron a un String
        band = m1.matches();  // Si el texto  corresponde al patron, retorna TRUE

        return band;
    }

    private void clicboton() {
        String txt= EDT1.getText().toString().trim();
        if(txt.equals(""))
        {
            this.txterror.setText("Debe ingresar un numero");
            this.txterror.setTextColor(Color.RED);
        }
        else
        {
            if(validar(txt)==true) {
                int N = Integer.parseInt(String.valueOf(EDT1.getText()));
                int m = Factorial(N);
                txtres.setText("El factorial de " + N + " es " + m);
            }
            else
            {
                this.txterror.setText("Valor ingresado NO válido");
                this.txterror.setTextColor(Color.RED);
            }
        }
        txtres.requestFocus();
    }

    private int Factorial(int N)
    {
        int F=1;
        for(int i=1;i<=N;i++)
        {
            F= F * i;
        }
        return F;
    }

    @Override
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
}
