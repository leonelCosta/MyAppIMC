package com.example.myappimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class ResultadoActivity extends AppCompatActivity {

    //all Var
    float resultadoIMC;
    private Button btvoltar;
    private TextView tvMostrarResult, tvDescricaoResult;
    private ImageView ivResultImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvMostrarResult = findViewById(R.id.tv_TituloResult);
        tvDescricaoResult= findViewById(R.id.tv_descricaoResult);
        ivResultImage = findViewById(R.id.iv_imagemResult);

        Intent intent = getIntent();
        resultadoIMC = round((intent.getFloatExtra("resultadoIMC",0)),2);



        if(resultadoIMC <= 18.5){
            tvMostrarResult.setText("O teu IMC é Baixo Peso: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoBaixoPeso));
            ivResultImage.setImageResource(R.drawable.img_baixo_peso);

        }else if(resultadoIMC >= 18.5 && resultadoIMC <= 24.9 ){
            tvMostrarResult.setText("O teu IMC é Normal: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoNormaPeso));
            ivResultImage.setImageResource(R.drawable.img_normal);

        }else if(resultadoIMC >= 25 && resultadoIMC <= 29.9){
            tvMostrarResult.setText("O teu IMC é Excesso de Peso: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoExecessoPeso));
            ivResultImage.setImageResource(R.drawable.img_execesso_peso);

        }else if(resultadoIMC >= 30.0 && resultadoIMC <= 34.9){
            tvMostrarResult.setText("O teu IMC é de Obesidade tipo 1: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoObesidade1));
            ivResultImage.setImageResource(R.drawable.img_gordo);

        }else if(resultadoIMC >= 35.0 && resultadoIMC <= 39.9){
            tvMostrarResult.setText("O teu IMC é de Obesidade tipo 2: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoObesidade2));
            ivResultImage.setImageResource(R.drawable.img_gordo);

        }else if(resultadoIMC >= 40.0){
            tvMostrarResult.setText("O teu IMC é de Obesidade tipo 3: - "+resultadoIMC);
            tvDescricaoResult.setText(getString(R.string.txtResultadoObesidade3));
            ivResultImage.setImageResource(R.drawable.img_gordo);
        }

        //Logica do bt voltar tela de Inserção
        btvoltar = findViewById(R.id.btVoltarTelaResult);
        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InsertDateActivity.class);
                view.getContext().startActivity(intent);

            }
        });//fim bt voltar


    }

    //Metodo para arrendedor
    public static float  round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}