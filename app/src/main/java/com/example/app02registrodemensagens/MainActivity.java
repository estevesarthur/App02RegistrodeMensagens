package com.example.app02registrodemensagens;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> strRegistro;
    private EditText edtMensagem;
    private TextView txtRegistros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strRegistro = new ArrayList<>();
        edtMensagem = findViewById(R.id.edtMensagem);
        txtRegistros = findViewById(R.id.txtRegistros);
        txtRegistros.setMovementMethod(new ScrollingMovementMethod());
    }
    public void btnRegistraOnClick(View view) {
        String msg;
        msg = edtMensagem.getText().toString();
// if(msg != null && !msg.trim().isEmpty()) {
        if(msg != null && !msg.isEmpty()) {
            strRegistro.add(msg);
            edtMensagem.setText("");
        }
        exibeRegistro();
    }
    private void exibeRegistro() {
        String s = "";
        for(int i = 0; i < strRegistro.size(); i++) {
            if (i < strRegistro.size()-1)
                s = s + (i+1) + ": " + strRegistro.get(i).toString() + "\n";
            else
                s = s + (i+1) + ": " + strRegistro.get(i).toString();
        }
        txtRegistros.setText(s);
    }
}