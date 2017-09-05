package com.example.albertozaranza.guitura.formularios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.Entretenimento;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmEntretenimentoOutrosServicos extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    Entretenimento et = new Entretenimento();

    private EditText editTextCategoria, editTextTipo, editTextSubtipo,
            editTextCodigo, editTextUF, editTextMunicipio, editTextDistrito,
            editTextDenominacao, editTextLocalizacao, editTextTelefone, editTextFax, editTextHomepage,
            editTextEmail, editTextRegistro, editTextLocalidadeProxima, editTextDistancia, editTextLocaliacaoProxima,
            editTextCaracterizacaoEquipamento, editTextCapacidadeEquipamento, editTextServicosOferecidos, editTextObservacoes;

    private RadioGroup transporte, privacidade, transporteUrbano;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_entretenimento_outros_servicos);

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
        editTextLocalizacao = (EditText) findViewById(R.id.editTextLocalizacao);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextFax = (EditText) findViewById(R.id.editTextFax);
        editTextHomepage = (EditText) findViewById(R.id.editTextHomePage);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextRegistro = (EditText) findViewById(R.id.editTextRegistroEmbratur);
        editTextLocalidadeProxima = (EditText) findViewById(R.id.editTextLocalidadeProxima);
        editTextDistancia = (EditText) findViewById(R.id.editTextDistancia);
        editTextLocaliacaoProxima = (EditText) findViewById(R.id.editTextLocalizacaoProxima);
        editTextCaracterizacaoEquipamento = (EditText) findViewById(R.id.editTextCaracterizacaoEquipamento);
        editTextCapacidadeEquipamento = (EditText) findViewById(R.id.editTextCapacidadeEquipamento);
        editTextServicosOferecidos = (EditText) findViewById(R.id.editTextServicosOferecidos);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoes);

        transporte = (RadioGroup) findViewById(R.id.radioGroupTransportesAcesso);
        privacidade = (RadioGroup) findViewById(R.id.radioGroupPNP);
        transporteUrbano = (RadioGroup) findViewById(R.id.radioGroupTransportes);

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            et.setAuth(firebaseUser.getEmail());
            et.setCategoria(editTextCategoria.getText().toString());
            et.setTipo(editTextTipo.getText().toString());
            et.setSubtipo(editTextSubtipo.getText().toString());
            et.setCodigo(editTextCodigo.getText().toString());
            et.setUf(editTextUF.getText().toString());
            et.setMunicipio(editTextMunicipio.getText().toString());
            et.setDistrito(editTextDistrito.getText().toString());
            et.setDenominacao(editTextDenominacao.getText().toString());
            et.setLocalizacao(editTextLocalizacao.getText().toString());
            et.setTelefone(editTextTelefone.getText().toString());
            et.setFax(editTextFax.getText().toString());
            et.setHomepage(editTextHomepage.getText().toString());
            et.setEmail(editTextEmail.getText().toString());
            et.setRegistro(editTextRegistro.getText().toString());
            et.setLocalidade_proxima(editTextLocalidadeProxima.getText().toString());
            et.setDistancia(editTextDistancia.getText().toString());
            et.setLocalizacao_proxima(editTextLocaliacaoProxima.getText().toString());
            et.setCaracterizacao_equipamento(editTextCaracterizacaoEquipamento.getText().toString());
            et.setCapacidade_equipamento(editTextCapacidadeEquipamento.getText().toString());
            et.setServicos_oferecidos(editTextServicosOferecidos.getText().toString());
            et.setObservacoes(editTextObservacoes.getText().toString());

            transporte.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonRodoviario:
                            et.setTransporte("rodoviario");
                            break;
                        case R.id.radioButtonFerroviario:
                            et.setTransporte("ferroviario");
                            break;
                        case R.id.radioButtonHidroviario:
                            et.setTransporte("hidroviario");
                            break;
                        case R.id.radioButtonAereo:
                            et.setTransporte("areo");
                            break;
                    }
                }
            });

            privacidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonP:
                            et.setPrivacidade("privativo");
                            break;
                        case R.id.radioButtonNP:
                            et.setPrivacidade("não privativo");
                            break;
                    }
                }
            });

           transporteUrbano.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonOnibus:
                            et.setTransporte_urbano("onibus");
                            break;
                        case R.id.radioButtonMetro:
                            et.setTransporte_urbano("metro");
                            break;
                        case R.id.radioButtonTaxi:
                            et.setTransporte_urbano("taxi");
                            break;
                        case R.id.radioButtonBonde:
                            et.setTransporte_urbano("bonde");
                            break;
                        case R.id.radioButtonOutros:
                            et.setTransporte_urbano("outros");
                            break;
                    }
                }
            });

            firebaseReference.child("entretenimento").push().setValue(et);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
