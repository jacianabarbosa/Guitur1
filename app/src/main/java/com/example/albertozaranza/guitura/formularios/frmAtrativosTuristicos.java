package com.example.albertozaranza.guitura.formularios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.AtrativosTuristicos;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmAtrativosTuristicos extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    AtrativosTuristicos at = new AtrativosTuristicos();

    /* COMPONENTES */

    // EditText

    private EditText editTextCategoria, editTextTipo ,editTextSubtipo, editTextCodigo,
            editTextUF, editTextMunicipio, editTextDistrito, editTextHierarquia, editTextNome,
            editTextLocalizacao, editTextLocalidadeProxima, editTextDistancia, editTextAcessoMaisUtilizado,
            editTextDetalhamento, editTextDescricao, editTextProtecao, editTextMesesMaiorMovimentacao,
            editTextIntegraRoteirosCitar, editTextTransportesTipoFrequencia, editTextLocalProduto,
            editTextObservacoes, editTextRemissivas;

    private RadioGroup transportes, privacidade, qualidade, ingresso, origemVisitante, integraRoteiro;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_atrativos_turisticos);

        // Declaração e chamada de evento do botão de save
        Button btnSalvar = (Button) findViewById(R.id.buttonSalvar);
        btnSalvar.setOnClickListener(btnSalvarAction);

        // Declaração dos editText
        editTextCategoria = (EditText) findViewById(R.id.editTextCategoria);
        editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        editTextSubtipo = (EditText) findViewById(R.id.editTextSubtipo);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextUF = (EditText) findViewById(R.id.editTextUF);
        editTextMunicipio = (EditText) findViewById(R.id.editTextMunicipio);
        editTextDistrito = (EditText) findViewById(R.id.editTextDistrito);
        editTextHierarquia = (EditText) findViewById(R.id.editTextHierarquia);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextLocalizacao = (EditText) findViewById(R.id.editTextLocalizacao);
        editTextLocalidadeProxima = (EditText) findViewById(R.id.editTextLocalidadeProxima);
        editTextDistancia = (EditText) findViewById(R.id.editTextDistancia);
        editTextAcessoMaisUtilizado = (EditText) findViewById(R.id.editTextAcessoMaisUtilizado);
        editTextDetalhamento = (EditText) findViewById(R.id.editTextDetalhamento);
        editTextDescricao = (EditText) findViewById(R.id.editTextDescricao);
        editTextProtecao = (EditText) findViewById(R.id.editTextProtecao);
        editTextMesesMaiorMovimentacao = (EditText) findViewById(R.id.editTextMesesMaiorMovimentacao);
        editTextIntegraRoteirosCitar = (EditText) findViewById(R.id.editTextIntegraRoteirosCitar);
        editTextTransportesTipoFrequencia = (EditText) findViewById(R.id.editTextTransportesTipoFrequencia);
        editTextLocalProduto = (EditText) findViewById(R.id.editTextLocalProduto);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoes);
        editTextRemissivas = (EditText) findViewById(R.id.editTextRemissivas);

        transportes = (RadioGroup) findViewById(R.id.radioGroupTransportes);
        privacidade = (RadioGroup) findViewById(R.id.radioGroupPNP);
        qualidade = (RadioGroup) findViewById(R.id.radioGroupEstadoConservacao);
        ingresso = (RadioGroup) findViewById(R.id.radioGroupIngresso);
        origemVisitante = (RadioGroup) findViewById(R.id.radioGroupOrigemVisitantes);
        integraRoteiro = (RadioGroup) findViewById(R.id.radioGroupRoteiros);

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            at.setAuth(firebaseUser.getEmail());
            at.setCategoria(editTextCategoria.getText().toString());
            at.setTipo(editTextTipo.getText().toString());
            at.setSubtipo(editTextSubtipo.getText().toString());
            at.setCodigo(editTextCodigo.getText().toString());
            at.setUf(editTextUF.getText().toString());
            at.setMunicipio(editTextMunicipio.getText().toString());
            at.setDistrito(editTextDistrito.getText().toString());
            at.setHierarquia(editTextHierarquia.getText().toString());
            at.setNome(editTextNome.getText().toString());
            at.setLocalizacao(editTextLocalizacao.getText().toString());
            at.setLocalidade_proxima(editTextLocalidadeProxima.getText().toString());
            at.setDistancia(editTextDistancia.getText().toString());
            at.setAcesso_mais_utilizado(editTextAcessoMaisUtilizado.getText().toString());
            at.setDetalhamento(editTextDetalhamento.getText().toString());
            at.setDescricao(editTextDescricao.getText().toString());
            at.setProtecao(editTextProtecao.getText().toString());
            at.setMeses_maior_movimentacao(editTextMesesMaiorMovimentacao.getText().toString());
            at.setIntegra_roteiros_citar(editTextIntegraRoteirosCitar.getText().toString());
            at.setTransportes_tipo_frequencia(editTextTransportesTipoFrequencia.getText().toString());
            at.setLocal_produto(editTextLocalProduto.getText().toString());
            at.setObservacoes(editTextObservacoes.getText().toString());
            at.setRemissivas(editTextRemissivas.getText().toString());

            transportes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonRodoviario:
                            at.setTransporte("rodoviario");
                            break;
                        case R.id.radioButtonFerroviario:
                            at.setTransporte("ferroviario");
                            break;
                        case R.id.radioButtonHidroviario:
                            at.setTransporte("hidroviario");
                            break;
                        case R.id.radioButtonAereo:
                            at.setTransporte("aereo");
                            break;
                    }
                }
            });

            privacidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonP:
                            at.setPrivacidade("privativo");
                            break;
                        case R.id.radioButtonNP:
                            at.setPrivacidade("não privativo");
                            break;
                    }
                }
            });

            qualidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonBomQualidade:
                            at.setQualidade("bom");
                            break;
                        case R.id.radioButtonRegularQualidade:
                            at.setQualidade("regular");
                            break;
                        case R.id.radioButtonRuimQualidade:
                            at.setQualidade("ruim");
                            break;
                    }
                }
            });

            origemVisitante.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonInternacional:
                            at.setOrigem_visitante("internacional");
                            break;
                        case R.id.radioButtonNacional:
                            at.setOrigem_visitante("nacional");
                            break;
                        case R.id.radioButtonRegional:
                            at.setOrigem_visitante("regional");
                            break;
                        case R.id.radioButtonLocal:
                            at.setOrigem_visitante("local");
                            break;
                    }
                }
            });

            integraRoteiro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSim:
                            at.setIntegra_roteiro("sim");
                            break;
                        case R.id.radioButtonNao:
                            at.setIntegra_roteiro("não");
                            break;
                    }
                }
            });

            firebaseReference.child("atratitivo_turistico").push().setValue(at);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
