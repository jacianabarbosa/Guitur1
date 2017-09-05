package com.example.albertozaranza.guitura.formularios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.Infraestrutura;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmInfraEstruturaApoioTuristico extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    Infraestrutura inf = new Infraestrutura();

    private EditText editTextCategoria, editTextCodigo,
            editTextUF, editTextMunicipio, editTextCep, editTextDDD, editTextDistanciaCapital,
            editTextMunicipiosLimitrofes, editTextPopulacaoTotal, editTextPopulacaoUrbana,
            editTextArea, editTextAltitudeMedia, editTextIndicePrecipitacao,
            editTextJanMaxima, editTextJanMedia, editTextJanMinima,
            editTextFevMaxima, editTextFevMedia, editTextFevMinima,
            editTextMarMaxima, editTextMarMedia, editTextMarMinima,
            editTextAbrMaxima, editTextAbrMedia, editTextAbrMinima,
            editTextMaioMaxima, editTextMaioMedia, editTextMaioMinima,
            editTextJunMaxima, editTextJunMedia, editTextJunMinima,
            editTextJulMaxima, editTextJulMedia, editTextJulMinima,
            editTextAgoMaxima, editTextAgoMedia, editTextAgoMinima,
            editTextSetMaxima, editTextSetMedia, editTextSetMinima,
            editTextOutMaxima, editTextOutMedia, editTextOutMinima,
            editTextNovMaxima, editTextNovMedia, editTextNovMinima,
            editTextDezMaxima, editTextDezMedia, editTextDezMinima,
            editTextDistanciaSede, editTextExtensao, editTextNomePrefeito,
            editTextEnderecoPrefeitura, editTextEmailPrefeitura,
            editTextHomePagePrefeitura, editTextNomeTurismo, editTextEnderecoTurismo,
            editTextCargoTurismo, editTextAtividades, editTextCaracterizacaoTuristica,
            editTextFeriadosLocal, editTextDomiciliosAtendidos, editTextEmpresaAbastecimento,
            editTextJornalLocal, editTextObservacoes;

    private RadioGroup clima, campoRepouso, asfalto, estadoConservasao,
            orgaoOficial, esgoto, energia, limpezaPublica, estacaoEmissora,
            radio, planosUrbanisticos;

    private CheckBox rodoviario, ferroviario, aereo, federal, estadual, muninicipal,
            taxi, onibus, bonde, animal, outros, agua, poco, rio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_infra_estrutura_apoio_turistico);

        Button btnSalvar = (Button) findViewById(R.id.buttonSalvar);
        btnSalvar.setOnClickListener(btnSalvarAction);

        editTextCategoria = (EditText) findViewById(R.id.editTextCategoria);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodificacao);
        editTextUF = (EditText) findViewById(R.id.editTextUF);
        editTextMunicipio = (EditText) findViewById(R.id.editTextMunicipio);
        editTextCep = (EditText) findViewById(R.id.editTextCep);
        editTextDDD = (EditText) findViewById(R.id.editTextDDD);
        editTextDistanciaCapital = (EditText) findViewById(R.id.editTextDistanciaCapital);
        editTextMunicipiosLimitrofes = (EditText) findViewById(R.id.editTextMunicipiosLimitrofes);
        editTextPopulacaoTotal = (EditText) findViewById(R.id.editTextPopulacaoTotal);
        editTextPopulacaoUrbana = (EditText) findViewById(R.id.editTextPopulacaoUrbana);
        editTextArea = (EditText) findViewById(R.id.editTextArea);
        editTextAltitudeMedia = (EditText) findViewById(R.id.editTextAltitudeMedia);
        editTextIndicePrecipitacao = (EditText) findViewById(R.id.editTextIndicePrecipitacao);
        editTextJanMaxima = (EditText) findViewById(R.id.editTextJanMaxima);
        editTextJanMedia = (EditText) findViewById(R.id.editTextJanMedia);
        editTextJanMinima = (EditText) findViewById(R.id.editTextJanMinima);
        editTextFevMaxima = (EditText) findViewById(R.id.editTextFevMaxima);
        editTextFevMedia = (EditText) findViewById(R.id.editTextFevMedia);
        editTextFevMinima = (EditText) findViewById(R.id.editTextFevMinima);
        editTextMarMaxima = (EditText) findViewById(R.id.editTextMarMaxima);
        editTextMarMedia = (EditText) findViewById(R.id.editTextMarMedia);
        editTextMarMinima = (EditText) findViewById(R.id.editTextMarMinima);
        editTextAbrMaxima = (EditText) findViewById(R.id.editTextAbrMaxima);
        editTextAbrMedia = (EditText) findViewById(R.id.editTextAbrMedia);
        editTextAbrMinima = (EditText) findViewById(R.id.editTextAbrMinima);
        editTextMaioMaxima = (EditText) findViewById(R.id.editTextMaiMaxima);
        editTextMaioMedia = (EditText) findViewById(R.id.editTextMaiMedia);
        editTextMaioMinima = (EditText) findViewById(R.id.editTextMaiMinima);
        editTextJunMaxima = (EditText) findViewById(R.id.editTextJunMaxima);
        editTextJunMedia = (EditText) findViewById(R.id.editTextJunMedia);
        editTextJunMinima = (EditText) findViewById(R.id.editTextJunMinima);
        editTextJulMaxima = (EditText) findViewById(R.id.editTextJulMaxima);
        editTextJulMedia = (EditText) findViewById(R.id.editTextJulMedia);
        editTextJulMinima = (EditText) findViewById(R.id.editTextJulMinima);
        editTextAgoMaxima = (EditText) findViewById(R.id.editTextAgoMaxima);
        editTextAgoMedia = (EditText) findViewById(R.id.editTextAgoMedia);
        editTextAgoMinima = (EditText) findViewById(R.id.editTextAgoMinima);
        editTextSetMaxima = (EditText) findViewById(R.id.editTextSetMaxima);
        editTextSetMedia = (EditText) findViewById(R.id.editTextSetMedia);
        editTextSetMinima = (EditText) findViewById(R.id.editTextSetMinima);
        editTextOutMaxima = (EditText) findViewById(R.id.editTextOutMaxima);
        editTextOutMedia = (EditText) findViewById(R.id.editTextOutMedia);
        editTextOutMinima = (EditText) findViewById(R.id.editTextOutMinima);
        editTextNovMaxima = (EditText) findViewById(R.id.editTextNovMaxima);
        editTextNovMedia = (EditText) findViewById(R.id.editTextNovMedia);
        editTextNovMinima = (EditText) findViewById(R.id.editTextNovMinima);
        editTextDezMaxima = (EditText) findViewById(R.id.editTextDezMaxima);
        editTextDezMedia = (EditText) findViewById(R.id.editTextDezMedia);
        editTextDezMinima = (EditText) findViewById(R.id.editTextDezMinima);
        editTextDistanciaSede = (EditText) findViewById(R.id.editTextDistanciaSede);
        editTextExtensao = (EditText) findViewById(R.id.editTextExtensao);
        editTextNomePrefeito = (EditText) findViewById(R.id.editTextPrefeitoNome);
        editTextEnderecoPrefeitura = (EditText) findViewById(R.id.editTextEnderecoPrefeitura);
        editTextEmailPrefeitura = (EditText) findViewById(R.id.editTextEmailPrefeitura);
        editTextHomePagePrefeitura = (EditText) findViewById(R.id.editTextPagePrefeitura);
        editTextNomeTurismo = (EditText) findViewById(R.id.editTextTurismoNome);
        editTextEnderecoTurismo = (EditText) findViewById(R.id.editTextEnderecoTurismo);
        editTextCargoTurismo = (EditText) findViewById(R.id.editTextCargoTurismo);
        editTextAtividades = (EditText) findViewById(R.id.editTextEconomicas);
        editTextCaracterizacaoTuristica = (EditText) findViewById(R.id.editTextCaracterizacaoTuristica);
        editTextFeriadosLocal = (EditText) findViewById(R.id.editTextFeriadosLocal);
        editTextDomiciliosAtendidos = (EditText) findViewById(R.id.editTextDomiciliosAtentidos);
        editTextEmpresaAbastecimento = (EditText) findViewById(R.id.editTextNomeEmpresaAbastecimento);
        editTextJornalLocal = (EditText) findViewById(R.id.editTextJornaisLocaisCitar);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoes);

        clima = (RadioGroup) findViewById(R.id.radioGroupClimas);
        campoRepouso = (RadioGroup) findViewById(R.id.radioGroupCamposRepouso);
        asfalto = (RadioGroup) findViewById(R.id.radioGroupAsfaltadas);
        estadoConservasao = (RadioGroup) findViewById(R.id.radioGroupEstadoConservacao);
        orgaoOficial = (RadioGroup) findViewById(R.id.radioGroupOrgaosOficiais);
        esgoto = (RadioGroup) findViewById(R.id.radioGroupRedeEsgotos);
        energia = (RadioGroup) findViewById(R.id.radioGroupEnergiasEleticas);
        limpezaPublica = (RadioGroup) findViewById(R.id.radioGroupLimpezasPublicas);
        estacaoEmissora = (RadioGroup) findViewById(R.id.radioGroupEstacoesEmissoras);
        radio = (RadioGroup) findViewById(R.id.radioGroupEstacoesEmissorasRadios);
        planosUrbanisticos = (RadioGroup) findViewById(R.id.radioGroupPlanosUrbanisticos);

        rodoviario = (CheckBox) findViewById(R.id.checkBoxRodoviario);
        ferroviario = (CheckBox) findViewById(R.id.checkBoxFerroviario);
        aereo = (CheckBox) findViewById(R.id.checkBoxAereo);
        federal = (CheckBox) findViewById(R.id.checkBoxFederal);
        estadual = (CheckBox) findViewById(R.id.checkBoxEstadual);
        muninicipal = (CheckBox) findViewById(R.id.checkBoxMunicipal);
        taxi = (CheckBox) findViewById(R.id.checkBoxTaxi);
        onibus = (CheckBox) findViewById(R.id.checkBoxOnibus);
        bonde = (CheckBox) findViewById(R.id.checkBoxBonde);
        animal = (CheckBox) findViewById(R.id.checkBoxAnimal);
        outros = (CheckBox) findViewById(R.id.checkBoxOutros);
        agua = (CheckBox) findViewById(R.id.checkBoxRedeAgua);
        poco = (CheckBox) findViewById(R.id.checkBoxPoco);
        rio = (CheckBox) findViewById(R.id.checkBoxRio);
    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            inf.setAuth(firebaseUser.getEmail());
            inf.setCategoria(editTextCategoria.getText().toString());
            inf.setCodigo(editTextCodigo.getText().toString());
            inf.setUf(editTextUF.getText().toString());
            inf.setMunicipio(editTextMunicipio.getText().toString());
            inf.setCep(editTextCep.getText().toString());
            inf.setDdd(editTextDDD.getText().toString());
            inf.setDistancia_capital(editTextDistanciaCapital.getText().toString());
            inf.setMunicipios_limitrofes(editTextMunicipiosLimitrofes.getText().toString());
            inf.setPopulacao_total(editTextPopulacaoTotal.getText().toString());
            inf.setPopulacao_urbana(editTextPopulacaoUrbana.getText().toString());
            inf.setArea(editTextArea.getText().toString());
            inf.setAltitude_media(editTextAltitudeMedia.getText().toString());
            inf.setIndice_precipitacao(editTextIndicePrecipitacao.getText().toString());
            inf.setJan_maxima(editTextJanMaxima.getText().toString());
            inf.setJan_media(editTextJanMedia.getText().toString());
            inf.setJan_minima(editTextJanMinima.getText().toString());
            inf.setFev_maxima(editTextFevMaxima.getText().toString());
            inf.setFev_media(editTextFevMedia.getText().toString());
            inf.setFev_minima(editTextFevMinima.getText().toString());
            inf.setMar_maxima(editTextMarMaxima.getText().toString());
            inf.setMar_media(editTextMarMedia.getText().toString());
            inf.setMar_minima(editTextMarMinima.getText().toString());
            inf.setAbr_maxima(editTextAbrMaxima.getText().toString());
            inf.setAbr_media(editTextAbrMedia.getText().toString());
            inf.setAbr_minima(editTextAbrMinima.getText().toString());
            inf.setMaio_maxima(editTextMaioMaxima.getText().toString());
            inf.setMaio_media(editTextMaioMedia.getText().toString());
            inf.setMaio_minima(editTextMaioMinima.getText().toString());
            inf.setJun_maxima(editTextJunMaxima.getText().toString());
            inf.setJun_media(editTextJunMedia.getText().toString());
            inf.setJun_minima(editTextJunMinima.getText().toString());
            inf.setJul_maxima(editTextJulMaxima.getText().toString());
            inf.setJul_media(editTextJulMedia.getText().toString());
            inf.setJul_minima(editTextJulMinima.getText().toString());
            inf.setAgo_maxima(editTextAgoMaxima.getText().toString());
            inf.setAgo_media(editTextAgoMedia.getText().toString());
            inf.setAgo_minima(editTextAgoMinima.getText().toString());
            inf.setSet_maxima(editTextSetMaxima.getText().toString());
            inf.setSet_media(editTextSetMedia.getText().toString());
            inf.setSet_minima(editTextSetMinima.getText().toString());
            inf.setOut_maxima(editTextOutMaxima.getText().toString());
            inf.setOut_media(editTextOutMedia.getText().toString());
            inf.setOut_minima(editTextOutMinima.getText().toString());
            inf.setNov_maxima(editTextNovMaxima.getText().toString());
            inf.setNov_media(editTextNovMedia.getText().toString());
            inf.setNov_minima(editTextNovMinima.getText().toString());
            inf.setDez_maxima(editTextDezMaxima.getText().toString());
            inf.setDez_media(editTextDezMedia.getText().toString());
            inf.setDez_minima(editTextDezMinima.getText().toString());
            inf.setDistancia_sede(editTextDistanciaSede.getText().toString());
            inf.setExtensao(editTextExtensao.getText().toString());
            inf.setNome_prefeito(editTextNomePrefeito.getText().toString());
            inf.setEndereco_prefeitura(editTextEnderecoPrefeitura.getText().toString());
            inf.setEmail_prefeitura(editTextEmailPrefeitura.getText().toString());
            inf.setHome_page_prefeitura(editTextHomePagePrefeitura.getText().toString());
            inf.setNome_turismo(editTextNomeTurismo.getText().toString());
            inf.setEndereco_turismo(editTextEnderecoTurismo.getText().toString());
            inf.setCargo_turismo(editTextCargoTurismo.getText().toString());
            inf.setAtividades(editTextAtividades.getText().toString());
            inf.setCaracterizacao_turistica(editTextCaracterizacaoTuristica.getText().toString());
            inf.setFeriados_local(editTextFeriadosLocal.getText().toString());
            inf.setDomicilios_atendidos(editTextDomiciliosAtendidos.getText().toString());
            inf.setEmpresa_abastecimento(editTextEmpresaAbastecimento.getText().toString());
            inf.setJornal_local(editTextJornalLocal.getText().toString());
            inf.setObservacoes(editTextObservacoes.getText().toString());

            clima.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonEquatorial:
                            inf.setClima("equatorial");
                            break;
                        case R.id.radioButtonTropical:
                            inf.setClima("tropical");
                            break;
                        case R.id.radioButtonTemperado:
                            inf.setClima("temperado");
                            break;
                    }
                }
            });

            campoRepouso.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonCampoSim:
                            inf.setCampo_repouso("sim");
                            break;
                        case R.id.radioButtonCampoNao:
                            inf.setCampo_repouso("não");
                            break;
                    }
                }
            });

            asfalto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonAsfaltadaSim:
                            inf.setAsfalto("sim");
                            break;
                        case R.id.radioButtonAsfaltadaNao:
                            inf.setAsfalto("não");
                            break;
                    }
                }
            });

            estadoConservasao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonBom:
                            inf.setEstado_conservasao("bom");
                            break;
                        case R.id.radioButtonRegular:
                            inf.setEstado_conservasao("regular");
                            break;
                        case R.id.radioButtonRuim:
                            inf.setEstado_conservasao("ruim");
                            break;
                    }
                }
            });

            orgaoOficial.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonOrgaoSim:
                            inf.setOrgao_oficial("sim");
                            break;
                        case R.id.radioButtonOrgaoNao:
                            inf.setOrgao_oficial("não");
                            break;
                    }
                }
            });

            esgoto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonEsgotoSim:
                            inf.setEsgoto("sim");
                            break;
                        case R.id.radioButtonEsgotoNao:
                            inf.setEsgoto("não");
                            break;
                    }
                }
            });

            energia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonGerador:
                            inf.setEnergia("gerador");
                            break;
                        case R.id.radioButtonRedeEletrica:
                            inf.setEnergia("rede elétrica");
                            break;
                    }
                }
            });

            limpezaPublica.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonLimpezaSim:
                            inf.setLimpeza_publica("sim");
                            break;
                        case R.id.radioButtonLimpezaNao:
                            inf.setLimpeza_publica("não");
                            break;
                    }
                }
            });

            estacaoEmissora.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonEstacaoSim:
                            inf.setEstacao_emissora("sim");
                            break;
                        case R.id.radioButtonEstacaoNao:
                            inf.setEstacao_emissora("não");
                            break;
                    }
                }
            });

            radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonEstacaoRadioSim:
                            inf.setRadio("sim");
                            break;
                        case R.id.radioButtonEstacaoNao:
                            inf.setRadio("não");
                            break;
                    }
                }
            });

            planosUrbanisticos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonPlanoSim:
                            inf.setPlanos_urbanisticos("sim");
                            break;
                        case R.id.radioButtonPlanoNao:
                            inf.setPlanos_urbanisticos("não");
                            break;
                    }
                }
            });

            if(rodoviario.isChecked()){
                inf.setRodoviario("true");
            }

            if(ferroviario.isChecked()){
                inf.setFerroviario("true");
            }

            if(aereo.isChecked()){
                inf.setAereo("true");
            }

            if(federal.isChecked()){
                inf.setFederal("true");
            }

            if(estadual.isChecked()){
                inf.setEstadual("true");
            }

            if(muninicipal.isChecked()){
                inf.setMuninicipal("true");
            }

            if(taxi.isChecked()){
                inf.setTaxi("true");
            }

            if(onibus.isChecked()){
                inf.setOnibus("true");
            }

            if(bonde.isChecked()){
                inf.setBonde("true");
            }

            if(animal.isChecked()){
                inf.setAnimal("true");
            }

            if(outros.isChecked()){
                inf.setOutros("true");
            }

            if(agua.isChecked()){
                inf.setAgua("true");
            }

            if(poco.isChecked()){
                inf.setPoco("true");
            }

            if(rio.isChecked()){
                inf.setRio("true");
            }

            firebaseReference.child("infraestrutura_de_apoio_turistico").push().setValue(inf);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
