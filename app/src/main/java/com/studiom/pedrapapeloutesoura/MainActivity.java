package com.studiom.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");

    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){
        ImageView imageUsuario = findViewById(R.id.imageUsuario);
        ImageView imageApp = findViewById(R.id.imageApp);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaUsuario){
            case "pedra":
                imageUsuario.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageUsuario.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageUsuario.setImageResource(R.drawable.tesoura);
                break;
        }
        switch (escolhaApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
            break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
            break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
            break;
        }
        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){
            textoResultado.setText("App Ganhou!");
        } else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                    (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){
            textoResultado.setText("Usuario Ganhou!");
    }else
        textoResultado.setText("Empate!");
    }
}