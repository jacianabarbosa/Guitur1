package com.example.albertozaranza.guitura.formularios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.objetos.EquipamentoExtraHoteleiro;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmEquipamentoExtraHoteleiro extends AppCompatActivity {

    private EditText editTextCategoria, editTextTipo, editTextSubtipo, editTextCodigo, editTextUF, editTextMunicipio,
            editTextDistrito, editTextHierarquia, editTextDenominacao, editTextLocalizacao, editTextTelefone, editTextFax,
            editTextHomepage,
            editTextEmail, editTextLocalidadeProxima, editTextDistancia, editTextAreaTotal, editTextCapacidadeTotal,
            editTextPropietario, editTextGerente,
            editTextAdministracaoNumero, editTextSanitarioNumero, editTextQuenteNumero,
            editTextFrioNumero, editTextQuadraNumero, editTextChurrascariaNumero,
            editTextPratoNumero, editTextRoupaNumero, editTextIluminacaoNumero, editTextTomadaNumero,
            editTextCantinaNumero, editTextFarmaciaNumero, editTextRestauranteNumero,
            editTextBarracaNumero, editTextTrailerNumero, editTextOutrosNumero, editTextConvenioNome, editTextObservacao;

    private CheckBox administracao, sanitario, quente, frio, quadra, churrascaria, prato, roupa, iluminacao,
            tomada, cantina, farmacia, restaurante, barraca, trailer, outros;

    private RadioGroup transporte, privacidade, condicao_acesso, propriedade, area_cercada, socios, convenio;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    EquipamentoExtraHoteleiro ext = new EquipamentoExtraHoteleiro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_equipamento_extra_hoteleiro);

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
        editTextHierarquia = (EditText) findViewById(R.id.editTextHierarquia);
        editTextDenominacao = (EditText) findViewById(R.id.editTextDenominacao);
        editTextLocalizacao = (EditText) findViewById(R.id.editTextLocalizacao);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextFax = (EditText) findViewById(R.id.editTextFax);
        editTextHomepage = (EditText) findViewById(R.id.editTextHomePage);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextLocalidadeProxima = (EditText) findViewById(R.id.editTextLocalidadeProxima);
        editTextDistancia = (EditText) findViewById(R.id.editTextDistancia);
        editTextAreaTotal = (EditText) findViewById(R.id.editTextAreaTotal);
        editTextCapacidadeTotal = (EditText) findViewById(R.id.editTextCapacidadeTotal);
        editTextPropietario = (EditText) findViewById(R.id.editTextPropietario);
        editTextGerente = (EditText) findViewById(R.id.editTextGerente);
        editTextAdministracaoNumero = (EditText) findViewById(R.id.editTextADMNumero);
        editTextSanitarioNumero = (EditText) findViewById(R.id.editTextSanitariosNumero);
        editTextQuenteNumero = (EditText) findViewById(R.id.editTextQuenteNumero);
        editTextFrioNumero = (EditText) findViewById(R.id.editTextFrioNumero);
        editTextQuadraNumero = (EditText) findViewById(R.id.editTextQuadraNumero);
        editTextChurrascariaNumero = (EditText) findViewById(R.id.editTextChurrascariaNumero);
        editTextPratoNumero = (EditText) findViewById(R.id.editTextLavaPratoNumero);
        editTextRoupaNumero = (EditText) findViewById(R.id.editTextLavaRoupaNumero);
        editTextIluminacaoNumero = (EditText) findViewById(R.id.editTextIluminacaoNumero);
        editTextTomadaNumero = (EditText) findViewById(R.id.editTextTomadaNumero);
        editTextCantinaNumero = (EditText) findViewById(R.id.editTextCantinaNumero);
        editTextFarmaciaNumero = (EditText) findViewById(R.id.editTextFarmaciaNumero);
        editTextRestauranteNumero = (EditText) findViewById(R.id.editTextRestauranteNumero);
        editTextBarracaNumero = (EditText) findViewById(R.id.editTextBarracaNumero);
        editTextTrailerNumero = (EditText) findViewById(R.id.editTextTrailerNumero);
        editTextOutrosNumero = (EditText) findViewById(R.id.editTextOutroNumero);
        editTextConvenioNome = (EditText) findViewById(R.id.editTextQualConvenio);
        editTextObservacao = (EditText) findViewById(R.id.editTextObservacoesComplementares);

        transporte = (RadioGroup) findViewById(R.id.radioGroupMeiosDeAcesso);
        privacidade = (RadioGroup) findViewById(R.id.radioGroupPNP);
        condicao_acesso = (RadioGroup) findViewById(R.id.radioGroupCondicoesDeAcesso);
        propriedade = (RadioGroup) findViewById(R.id.radioGroupPropriedades);
        area_cercada = (RadioGroup) findViewById(R.id.radioGroupAreasCercadas);
        socios = (RadioGroup) findViewById(R.id.radioGroupAceitaSocio);
        convenio = (RadioGroup) findViewById(R.id.radioGroupTemConvenios);

        administracao = (CheckBox) findViewById(R.id.checkBoxAdministracao);
        sanitario = (CheckBox) findViewById(R.id.checkBoxSanitario);
        quente = (CheckBox) findViewById(R.id.checkBoxQuente);
        frio = (CheckBox) findViewById(R.id.checkBoxFrio);
        quadra = (CheckBox) findViewById(R.id.checkBoxQuadra);
        churrascaria = (CheckBox) findViewById(R.id.checkBoxChurrascaria);
        prato = (CheckBox) findViewById(R.id.checkBoxPrato);
        roupa = (CheckBox) findViewById(R.id.checkBoxRoupa);
        iluminacao = (CheckBox) findViewById(R.id.checkBoxIluminacao);
        tomada = (CheckBox) findViewById(R.id.checkBoxTomada);
        cantina = (CheckBox) findViewById(R.id.checkBoxCantina);
        farmacia = (CheckBox) findViewById(R.id.checkBoxFarmacia);
        restaurante = (CheckBox) findViewById(R.id.checkBoxRestaurante);
        barraca = (CheckBox) findViewById(R.id.checkBoxBarraca);
        trailer = (CheckBox) findViewById(R.id.checkBoxTrailer);
        outros = (CheckBox) findViewById(R.id.checkBoxOutros);

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ext.setAuth(firebaseUser.getEmail());
            ext.setCategoria(editTextCategoria.getText().toString());
            ext.setTipo(editTextTipo.getText().toString());
            ext.setSubtipo(editTextSubtipo.getText().toString());
            ext.setCodigo(editTextCodigo.getText().toString());
            ext.setUf(editTextUF.getText().toString());
            ext.setMunicipio(editTextMunicipio.getText().toString());
            ext.setDistrito(editTextDistrito.getText().toString());
            ext.setHierarquia(editTextHierarquia.getText().toString());
            ext.setDenominacao(editTextDenominacao.getText().toString());
            ext.setLocalizacao(editTextLocalizacao.getText().toString());
            ext.setTelefone(editTextTelefone.getText().toString());
            ext.setFax(editTextFax.getText().toString());
            ext.setHomepage(editTextHomepage.getText().toString());
            ext.setEmail(editTextEmail.getText().toString());
            ext.setLocalidade_proxima(editTextLocalidadeProxima.getText().toString());
            ext.setDistancia(editTextDistancia.getText().toString());
            ext.setArea_total(editTextAreaTotal.getText().toString());
            ext.setCapacidade_total(editTextCapacidadeTotal.getText().toString());
            ext.setPropietario(editTextPropietario.getText().toString());
            ext.setGerente(editTextGerente.getText().toString());
            ext.setAdministracao_numero(editTextAdministracaoNumero.getText().toString());
            ext.setSanitario_numero(editTextSanitarioNumero.getText().toString());
            ext.setQuente_numero(editTextQuenteNumero.getText().toString());
            ext.setFrio_numero(editTextFrioNumero.getText().toString());
            ext.setQuadra_numero(editTextQuadraNumero.getText().toString());
            ext.setChurrascaria_numero(editTextChurrascariaNumero.getText().toString());
            ext.setPrato_numero(editTextPratoNumero.getText().toString());
            ext.setRoupa_numero(editTextRoupaNumero.getText().toString());
            ext.setIluminacao_numero(editTextIluminacaoNumero.getText().toString());
            ext.setTomada_numero(editTextTomadaNumero.getText().toString());
            ext.setCantina_numero(editTextCantinaNumero.getText().toString());
            ext.setFarmacia_numero(editTextFarmaciaNumero.getText().toString());
            ext.setRestaurante_numero(editTextRestauranteNumero.getText().toString());
            ext.setBarraca_numero(editTextBarracaNumero.getText().toString());
            ext.setTrailer_numero(editTextTrailerNumero.getText().toString());
            ext.setOutros_numero(editTextOutrosNumero.getText().toString());
            ext.setConvenio_nome(editTextConvenioNome.getText().toString());
            ext.setObservacao(editTextObservacao.getText().toString());

            transporte.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonRodoviario:
                            ext.setTransporte("rodoviario");
                            break;
                        case R.id.radioButtonFerroviario:
                            ext.setTransporte("ferroviario");
                            break;
                        case R.id.radioButtonHidroviario:
                            ext.setTransporte("hidroviario");
                            break;
                        case R.id.radioButtonAereo:
                            ext.setTransporte("aereo");
                            break;
                    }
                }
            });

            privacidade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonP:
                            ext.setPrivacidade("privativo");
                            break;
                        case R.id.radioButtonNP:
                            ext.setPrivacidade("não privativo");
                            break;
                    }
                }
            });

            condicao_acesso.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonBom:
                            ext.setCondicao_acesso("bom");
                            break;
                        case R.id.radioButtonRegular:
                            ext.setCondicao_acesso("regular");
                            break;
                        case R.id.radioButtonRuim:
                            ext.setCondicao_acesso("ruim");
                            break;
                    }
                }
            });

            propriedade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonPublica:
                            ext.setPrivacidade("publica");
                            break;
                        case R.id.radioButtonPrivada:
                            ext.setPrivacidade("privada");
                            break;
                    }
                }
            });

            area_cercada.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonAreaSim:
                            ext.setPrivacidade("sim");
                            break;
                        case R.id.radioButtonAreaNao:
                            ext.setPrivacidade("não");
                            break;
                    }
                }
            });

            socios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSocioSim:
                            ext.setPrivacidade("sim");
                            break;
                        case R.id.radioButtonSocioNao:
                            ext.setPrivacidade("não");
                            break;
                    }
                }
            });

            convenio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonConvenioSim:
                            ext.setPrivacidade("sim");
                            break;
                        case R.id.radioButtonConvenioNao:
                            ext.setPrivacidade("não");
                            break;
                    }
                }
            });

            if(administracao.isChecked()){
                ext.setAdministracao("true");
            }

            if(sanitario.isChecked()){
                ext.setSanitario("true");
            }

            if(quente.isChecked()){
                ext.setQuente("true");
            }

            if(frio.isChecked()){
                ext.setFrio("true");
            }

            if(quadra.isChecked()){
                ext.setQuadra("true");
            }

            if(churrascaria.isChecked()){
                ext.setChurrascaria("true");
            }

            if(prato.isChecked()){
                ext.setPrato("true");
            }

            if(roupa.isChecked()){
                ext.setRoupa("true");
            }

            if(iluminacao.isChecked()){
                ext.setIluminacao("true");
            }

            if(tomada.isChecked()){
                ext.setTomada("true");
            }

            if(cantina.isChecked()){
                ext.setCantina("true");
            }

            if(farmacia.isChecked()){
                ext.setFarmacia("true");
            }

            if(restaurante.isChecked()){
                ext.setRestaurante("true");
            }

            if(barraca.isChecked()){
                ext.setBarraca("true");
            }

            if(trailer.isChecked()){
                ext.setTrailer("true");
            }

            if(outros.isChecked()){
                ext.setOutros("true");
            }

            firebaseReference.child("equipamento_extra_hoteleiro_at").push().setValue(ext);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }
    };
}
