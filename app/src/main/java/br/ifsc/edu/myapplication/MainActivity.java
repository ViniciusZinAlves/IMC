package br.ifsc.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText  txtPeso          ;
    EditText  txtAltura        ;
    ImageView imgResultadoImc  ;
    TextView  txtSituacaoPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAltura         = (EditText) findViewById (R.id.txtAltura      );
        txtSituacaoPessoa = (TextView) findViewById (R.id.txtSituacaoPeso);
        txtPeso           = (EditText) findViewById (R.id.txtPeso        );
        imgResultadoImc   = (ImageView)findViewById (R.id.imgResultadoImc);

    }

    public void calculaImc(View v) {
        float fPeso = 0, fAltura = 0, fImc = 0;

        if ((txtPeso.getText().toString().length() > 0) && (txtAltura.getText().toString().length() > 0))
        {
            fPeso   = Float.parseFloat(txtPeso.getText().toString());
            fAltura = Float.parseFloat(txtAltura.getText().toString());

            if ((fPeso > 0) && (fAltura > 0))
            {
                fImc = (fPeso / (fAltura * fAltura));
                if (fImc <= 18.5)
                {
                    imgResultadoImc.setImageResource(R.drawable.abaixopeso);
                    txtSituacaoPessoa.setText("Abaixo do Peso" + fImc);
                } else if (fImc <= 24.9)
                {
                    imgResultadoImc.setImageResource(R.drawable.normal);
                    txtSituacaoPessoa.setText("Peso Normal");
                } else if (fImc <= 29.9)
                {
                    imgResultadoImc.setImageResource(R.drawable.sobrepeso);
                    txtSituacaoPessoa.setText("SobrePeso");
                } else if (fImc <= 34.9)
                {
                    imgResultadoImc.setImageResource(R.drawable.obesidade1);
                    txtSituacaoPessoa.setText("Obesidade Tipo1");
                } else if (fImc <= 39.9)
                {
                    imgResultadoImc.setImageResource(R.drawable.obesidade2);
                    txtSituacaoPessoa.setText("Obesidade Tipo2");
                } else
                {
                    imgResultadoImc.setImageResource(R.drawable.obesidade3);
                    txtSituacaoPessoa.setText("Obesidade Tipo3");
                }
            }
            else
                txtSituacaoPessoa.setText("Informações incorretas");
        }
    }
}
