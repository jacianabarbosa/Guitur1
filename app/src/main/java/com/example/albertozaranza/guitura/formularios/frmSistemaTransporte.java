package com.example.albertozaranza.guitura.formularios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.SistemaTransportes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmSistemaTransporte extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

    private EditText editTextCategoria, editTextTipo, editTextSubtipo,
            editTextCodigo, editTextUF, editTextMunicipio, editTextDistrito,
            editTextDenominacao, editTextEndereco, editTextTrecho, editTextEmpresa,
            editTextExtensao, editTextKM, editTextTempo, editTextHoras, editTextTipoVeiculo,
            editTextHorarios;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    SistemaTransportes st = new SistemaTransportes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_sistema_transporte);

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
        editTextDenominacao = (EditText) findViewById(R.id.editTextDenominacao);
        editTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editTextTrecho = (EditText) findViewById(R.id.editTextTrecho1);
        editTextEmpresa = (EditText) findViewById(R.id.editTextEmpresa1);
        editTextExtensao = (EditText) findViewById(R.id.editTextExtensao1);
        editTextKM = (EditText) findViewById(R.id.editTextKm1);
        editTextTempo = (EditText) findViewById(R.id.editTextTempoViagem1);
        editTextHoras = (EditText) findViewById(R.id.editTextHoras1);
        editTextTipoVeiculo = (EditText) findViewById(R.id.editTextTipoVeiculo1);
        editTextHorarios = (EditText) findViewById(R.id.editTextHorario1);

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            st.setAuth(firebaseUser.getEmail());
            st.setCategoria(editTextCategoria.getText().toString());
            st.setTipo(editTextTipo.getText().toString());
            st.setSubtipo(editTextSubtipo.getText().toString());
            st.setCodigo(editTextCodigo.getText().toString());
            st.setUf(editTextUF.getText().toString());
            st.setMunicipio(editTextMunicipio.getText().toString());
            st.setDistrito(editTextDistrito.getText().toString());
            st.setDenominacao(editTextDenominacao.getText().toString());
            st.setEndereco(editTextEndereco.getText().toString());
            st.setTrecho(editTextTrecho.getText().toString());
            st.setEmpresa(editTextEmpresa.getText().toString());
            st.setExtensao(editTextExtensao.getText().toString());
            st.setKm(editTextKM.getText().toString());
            st.setTempo(editTextTempo.getText().toString());
            st.setHoras(editTextHoras.getText().toString());
            st.setTipo_veiculo(editTextTipoVeiculo.getText().toString());
            st.setHorarios(editTextHorarios.getText().toString());

            firebaseReference.child("sistema_transporte").push().setValue(st);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
