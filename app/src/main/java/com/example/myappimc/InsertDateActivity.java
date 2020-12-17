package com.example.myappimc;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class InsertDateActivity  extends AppCompatActivity {

    private Button btVoltar, btCalcular;
    private EditText edPeso, edAltura;
    float peso,altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);

        //Connect With Buttons on Xml
        btVoltar = (Button)findViewById(R.id.btVoltarTelaInsert);
        btCalcular = (Button)findViewById(R.id.btCalcular) ;

        //Connect With TextField on Xml
        edPeso = (EditText)findViewById(R.id.edTextPeso);
        edAltura= (EditText)findViewById(R.id.edTextAltura);




        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get result by insert values
                if(edPeso.getText().toString().isEmpty() || edAltura.getText().toString().isEmpty()){
                    System.out.println("Campos vazios");
                }else{

                    peso = Float.parseFloat(edPeso.getText().toString());
                    altura = Float.parseFloat(edAltura.getText().toString());
                    //get result by insert values
                    float resultIMC = CalculaIMC(peso,altura);
                    //sending value for result activity
                    Intent intent = new Intent(v.getContext(), ResultadoActivity.class);
                    intent.putExtra("resultadoIMC",resultIMC);
                    v.getContext().startActivity(intent);
                }

            }
        });

    }
    //Calcula o Valor de IMC
    public float CalculaIMC(float peso, float altura){
        return peso/(altura*altura);
    }
}


