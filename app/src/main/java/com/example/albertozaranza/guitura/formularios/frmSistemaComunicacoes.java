package com.example.albertozaranza.guitura.formularios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.SistemaComunicacoes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmSistemaComunicacoes extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

    private EditText editTextCategoria, editTextTipo, editTextSubtipo, editTextCodigo, editTextUF,
            editTextMunicipio, editTextDistrito, editTextOrdem, editTextEstabelecimento,
            editTextEndereco, editTextPublico, editTextPrivado, editTextAtendimento, editTextEspecificacao;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    SistemaComunicacoes sc = new SistemaComunicacoes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_sistema_comunicacoes);

        // Declaração e chamada de evento do botão de save
        Button btnSalvar = (Button) findViewById(R.id.buttonSalvar);
        btnSalvar.setOnClickListener(btnSalvarAction);

        editTextCategoria = (EditText) findViewById(R.id.editTextCategoria);
        editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        editTextSubtipo = (EditText) findViewById(R.id.editTextSubtipo);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextUF = (EditText) findViewById(R.id.editTextUF);
        editTextMunicipio = (EditText) findViewById(R.id.editTextMunicipio);
        editTextDistrito = (EditText) findViewById(R.id.editTextDistrito);
        editTextOrdem = (EditText) findViewById(R.id.editTextOrdem);
        editTextEstabelecimento = (EditText) findViewById(R.id.editTextNomeEstabelecimento);
        editTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editTextPublico = (EditText) findViewById(R.id.editTextPublico);
        editTextPrivado = (EditText) findViewById(R.id.editTextPrivado);
        editTextAtendimento = (EditText) findViewById(R.id.editTextHorarioAtendimento);
        editTextEspecificacao = (EditText) findViewById(R.id.editTextHorarioEspecificacao);


    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            sc.setAuth(firebaseUser.getEmail());
            sc.setCategoria(editTextCategoria.getText().toString());
            sc.setTipo(editTextTipo.getText().toString());
            sc.setSubtipo(editTextSubtipo.getText().toString());
            sc.setCodigo(editTextCodigo.getText().toString());
            sc.setUf(editTextUF.getText().toString());
            sc.setMunicipio(editTextMunicipio.getText().toString());
            sc.setDistrito(editTextDistrito.getText().toString());
            sc.setOrdem(editTextOrdem.getText().toString());
            sc.setEstabelecimento(editTextEstabelecimento.getText().toString());
            sc.setEndereco(editTextEndereco.getText().toString());
            sc.setPublico(editTextPublico.getText().toString());
            sc.setPrivado(editTextPrivado.getText().toString());
            sc.setAtendimento(editTextAtendimento.getText().toString());
            sc.setEspecificacao(editTextEspecificacao.getText().toString());

            firebaseReference.child("sistema_comunicacoes").push().setValue(sc);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
