package com.example.formulagral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC;
    Button btnCalcular, btnLimpiar;
    TextView txvX1, txvX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = (EditText)findViewById(R.id.edtA);
        edtB = (EditText)findViewById(R.id.editText2);
        edtC = (EditText)findViewById(R.id.edtC);
        txvX1 = (TextView)findViewById(R.id.txvX1);
        txvX2 = (TextView) findViewById(R.id.txvX2);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                txvX1.setText("X1:");
                txvX2.setText("X2:");
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double dblA, dblB, dblC, dblD, dblX1, dblX2;
                dblA = Double.valueOf(edtA.getText().toString());
                dblB = Double.valueOf(edtB.getText().toString());
                dblC = Double.valueOf(edtC.getText().toString());
                /*PRIMERO DEBEMOS CALCULAR EL DETERMINANTE*/
                dblD = Math.pow(dblB,2)-(4*dblA*dblC);
                if(dblD<0){
                    txvX1.setText("NO TIENE SOLUCIÓN EN LOS REALES");
                    txvX2.setText("NO TIENE SOLUCIÓN EN LOS REALES");
                }else {
                    if (dblD == 0){
                        txvX2.setText("");
                        dblX1 = (-dblB) / (2 * dblA);
                        txvX1.setText("X = " + dblX1);
                    }else{
                        dblX1 = ((-dblB)+Math.sqrt(dblD)) / (2 * dblA);
                        dblX2 = ((-dblB)-Math.sqrt(dblD)) / (2 * dblA);
                        txvX1.setText("X1 = " + dblX1);
                        txvX2.setText("X2 = " + dblX2);
                    }
                }
            }
        });
    }
}
