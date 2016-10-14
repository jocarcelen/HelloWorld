package es.pue.android.jose.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // definiexo un boto
    Button calcular;
    TextView resultat;
    EditText pes;
    EditText alcada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Logs sortiran al (6:Andorid Monitor)i (4:Run) del Android Studio
        Log.i("MainActivity","Iniciant el onCreate");

        // retornar una vista Button fent un cast
        // R clase que conte tots els IDs dels recursos
        calcular=(Button)findViewById(R.id.buttonCalc);

        // canviar el text
        calcular.setText("Calcula!!!");

        // mes optim aconseguir els recursos fora que no al métode del botó que repetiria
        // la crida cada vegada que es pitja el botó
        resultat=(TextView)findViewById(R.id.textViewResultat);
        pes=(EditText)findViewById(R.id.editTextPes);
        alcada=(EditText)findViewById(R.id.editTextAlcada);

        // afegim una nova clase inline que soporti l'acció onClickListener
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // int numPes = 0;
                // int numAlcada = 0;
                // float numResultat = 0;

                Log.i("MainActivity","Iniciant OnClickListener");
                String sAlcada = alcada.getText().toString();
                String sPes = pes.getText().toString();

                float fAlcada = 0;
                float fPes = 0;

                boolean hasError = false;
                try {
                    fAlcada = Float.parseFloat(sAlcada);
                    fPes = Float.parseFloat(sPes);
                } catch (NumberFormatException e){
                    resultat.setText("Alçada i pes han de ser numeros");
                    hasError = true;
                }

                if (!hasError) {
                    float IMC = fPes / (fAlcada * fAlcada);
                    resultat.setText("La masa corporal es " + Float.toString(IMC));
                }

                Log.i("MainActivity","Finalitzant OnClickListener");

                // numPes = Integer.parseInt(pes.getText().toString());
                // numAlcada = Integer.parseInt(alcada.getText().toString());
                // numResultat = (float)numAlcada / numPes;
                // resultat.setText("La masa corporal es " + Float.toString(numResultat));
            }
        });

    }
}
