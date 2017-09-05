package com.example.albertozaranza.guitura.formularios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.AtrativosTuristicosNaturais;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmAtrativosTuristicosNaturais extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

    /* COMPONENTES */

    // EditText

    private EditText editTextCategoria, editTextTipo ,editTextSubtipo, editTextCodigo,
            editTextUF, editTextMunicipio, editTextDistrito, editTextHierarquia, editTextNome,
            editTextLocalizacao, editTextLocalidadeProxima, editTextDistancia, editTextAcessoMaisUtilizado,
            editTextDetalhamento, editTextDescricao, editTextAcessibilidadeTemporal, editTextEquipamento,
            editTextMesesMaiorMovimentacao, editTextIntegraRoteirosCitar, editTextObservacoes, editTextRemissivas;

    private RadioGroup transportes, privacidade, qualidade, acessibilidadeTemporal, tempo,
            atividadeOcorrente, origemVisitante, integraRoteiro;

    private String transportes_txt, privacidade_txt, qualidade_txt, acessibilidadeTemporal_txt,
            tempo_txt, atividadeOcorrente_txt, origemVisitante_txt, integraRoteiro_txt;


    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_atrativos_turisticos_naturais);

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
        editTextAcessibilidadeTemporal = (EditText) findViewById(R.id.editTexAcessibilidadeTemporalCitar);
        editTextEquipamento = (EditText) findViewById(R.id.editTextEquipamentoServico);
        editTextMesesMaiorMovimentacao = (EditText) findViewById(R.id.editTextMesesMaiorMovimentacao);
        editTextIntegraRoteirosCitar = (EditText) findViewById(R.id.editTextIntegraRoteirosCitar);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoes);
        editTextRemissivas = (EditText) findViewById(R.id.editTextRemissivas);

        transportes = (RadioGroup) findViewById(R.id.radioGroupTransportes);
        privacidade = (RadioGroup) findViewById(R.id.radioGroupPNP);
        qualidade = (RadioGroup) findViewById(R.id.radioGroupQualidade);
        acessibilidadeTemporal = (RadioGroup) findViewById(R.id.radioGroupAcessibilidadeTemporal);
        tempo = (RadioGroup) findViewById(R.id.radioGroupTempo);
        atividadeOcorrente = (RadioGroup) findViewById(R.id.radioGroupAtividadesOcorrentes);
        origemVisitante = (RadioGroup) findViewById(R.id.radioGroupOrigemVisitantes);
        integraRoteiro = (RadioGroup) findViewById(R.id.radioGroupRoteiros);

        transportes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioButtonRodoviario:
                        transportes_txt = "rodoviario";
                        break;
                    case R.id.radioButtonFerroviario:
                        transportes_txt = "ferroviario";
                        break;
                    case R.id.radioButtonHidroviario:
                        transportes_txt = "hidroviario";
                        break;
                    case R.id.radioButtonAereo:
                        transportes_txt = "aereo";
                        break;
                }
            }
        });

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AtrativosTuristicosNaturais atn = new AtrativosTuristicosNaturais();


            atn.setAuth(firebaseUser.getEmail());
            atn.setCategoria(editTextCategoria.getText().toString());
            atn.setTipo(editTextTipo.getText().toString());
            atn.setSubtipo(editTextSubtipo.getText().toString());
            atn.setCodigo(editTextCodigo.getText().toString());
            atn.setUf(editTextUF.getText().toString());
            atn.setMunicipio(editTextMunicipio.getText().toString());
            atn.setDistrito(editTextDistrito.getText().toString());
            atn.setHierarquia(editTextHierarquia.getText().toString());
            atn.setNome(editTextNome.getText().toString());
            atn.setLocalizacao(editTextLocalizacao.getText().toString());
            atn.setLocalidade_proxima(editTextLocalidadeProxima.getText().toString());
            atn.setDistancia(editTextDistancia.getText().toString());
            atn.setAcesso_mais_utilizado(editTextAcessoMaisUtilizado.getText().toString());
            atn.setDetalhamento(editTextDetalhamento.getText().toString());
            atn.setDescricao(editTextDescricao.getText().toString());
            atn.setAcessibilidade_temporal(editTextAcessibilidadeTemporal.getText().toString());
            atn.setEquipamento(editTextEquipamento.getText().toString());
            atn.setMeses_maior_movimentacao(editTextMesesMaiorMovimentacao.getText().toString());
            atn.setIntegra_roteiros_citar(editTextIntegraRoteirosCitar.getText().toString());
            atn.setObservacoes(editTextObservacoes.getText().toString());
            atn.setRemissivas(editTextRemissivas.getText().toString());
            atn.setTransporte(transportes_txt);

            /*privacidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonP:
                            atn.setPrivacidade("privativo");
                            break;
                        case R.id.radioButtonNP:
                            atn.setPrivacidade("não privativo");
                            break;
                    }
                }
            });

            qualidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonBomQualidade:
                            atn.setQualidade("bom");
                            break;
                        case R.id.radioButtonRegularQualidade:
                            atn.setQualidade("regular");
                            break;
                        case R.id.radioButtonRuimQualidade:
                            atn.setQualidade("ruim");
                            break;
                    }
                }
            });

            acessibilidadeTemporal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonPermanente:
                            atn.setAcessibilidade_temporal("permanente");
                            break;
                        case R.id.radioButtonTemporario:
                            atn.setAcessibilidade_temporal("temporário");
                            break;
                    }
                }
            });

            tempo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonHoras:
                            atn.setTempo("horas");
                            break;
                        case R.id.radioButtonDias:
                            atn.setTempo("3 dias");
                            break;
                        case R.id.radioButtonPernoite:
                            atn.setTempo("pernoite");
                            break;
                        case R.id.radioButtonMaisDias:
                            atn.setTempo("mais de 3 dias");
                            break;
                    }
                }
            });

            atividadeOcorrente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSimAO:
                            atn.setAtividade_ocorrente("sim");
                            break;
                        case R.id.radioButtonNaoAO:
                            atn.setAtividade_ocorrente("não");
                            break;
                    }
                }
            });

            origemVisitante.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonInternacional:
                            atn.setOrigem_visitante("internacional");
                            break;
                        case R.id.radioButtonNacional:
                            atn.setOrigem_visitante("nacional");
                            break;
                        case R.id.radioButtonRegional:
                            atn.setOrigem_visitante("regional");
                            break;
                        case R.id.radioButtonLocal:
                            atn.setOrigem_visitante("local");
                            break;
                    }
                }
            });

            integraRoteiro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSim:
                            atn.setIntegra_roteiro("sim");
                            break;
                        case R.id.radioButtonNao:
                            atn.setIntegra_roteiro("não");
                            break;
                    }
                }
            });*/

            firebaseReference.child("atratitivo_turistico_natural").push().setValue(atn);

            Toast toast = Toast.makeText(getApplicationContext(), "Dados salvos com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
