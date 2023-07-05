package com.example.exercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private SeekBar skbTamanho;
    private TextView txtView;
    private EditText edtTxt;
    private CheckBox chkNegrito;
    private CheckBox chkItalico;
    private CheckBox chkMaiuscula;
    private RadioGroup rdgCor;
    private RadioButton rdbVermelho;
    private RadioButton rdbVerde;
    private RadioButton rdbAzul;
    private Button btnEnviar;
    private TextView txtTamanho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        txtTamanho = findViewById(R.id.txtTamanho);
        edtTxt = findViewById(R.id.edtTxt);
        skbTamanho = findViewById(R.id.skbTamanho);
        chkNegrito = findViewById(R.id.chkNegrito);
        chkItalico = findViewById(R.id.chkItalico);
        chkMaiuscula = findViewById(R.id.chkMaiuscula);
        rdgCor = findViewById(R.id.rdgCor);
        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdbVerde = findViewById(R.id.rdbVerde);
        rdbAzul = findViewById(R.id.rdbAzul);
        btnEnviar = findViewById(R.id.btnEnviar);



        skbTamanho.setOnSeekBarChangeListener(this);
        btnEnviar.setOnClickListener(this);
        chkNegrito.setOnCheckedChangeListener(this);
        chkItalico.setOnCheckedChangeListener(this);
        chkMaiuscula.setOnCheckedChangeListener(this);
        rdgCor.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        txtView.setText(edtTxt.getText());
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String c = Integer.toString(progress);
        txtView.setTextSize(progress);
        txtTamanho.setText(progress + "sp");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(chkNegrito.isChecked() && chkItalico.isChecked()){
            txtView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
        }
        else if(chkNegrito.isChecked()){
            txtView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else if (chkItalico.isChecked()){
            txtView.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        }else{
            txtView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }


        if (chkMaiuscula.isChecked()){
            txtView.setAllCaps(true);
        } else{
            txtView.setAllCaps(false);
        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(rdbAzul.isChecked()){
            txtView.setTextColor(rdbAzul.getTextColors());
        }else if(rdbVerde.isChecked()){
            txtView.setTextColor(rdbVerde.getTextColors());
        }else if(rdbVermelho.isChecked()){
            txtView.setTextColor(rdbVermelho.getTextColors());
        }
    }
}