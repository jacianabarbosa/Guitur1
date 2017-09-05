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
import com.example.albertozaranza.guitura.objetos.EquipamentoHoteleiro;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmEquipamentoHoteleiro extends AppCompatActivity {

    private EditText editTextCategoria, editTextTipo, editTextSubtipo, editTextCodigo,
            editTextUF, editTextMunicipio, editTextDistrito, editTextClassificacao,
            editTextDenominacao, editTextRazaoSocial, editTextRazaoProprietario,
            editTextInformacoes, editTextEndereco, editTextTelefone, editTextFax,
            editTextHomePage, editTextEmail, editTextTelefoneReserva, editTextRegistroEmbratur,
            editTextDataInicio, editTextCitar,
            editTextApartSglPreco, editTextApartSglAposentoComBanheiro, editTextApartSglAposentoSemBanheiro,
            editTextApartDblPreco, editTextApartDblComBanheiro, editTextApartDblSemBanheiro,
            editTextApartTplPreco, editTextApartTplComBanheiro, editTextApartTplSemBanheiro,
            editTextLuxoSglPreco, editTextLuxoSglAposentoComBanheiro, editTextLuxoSglAposentoSemBanheiro,
            editTextLuxoDblPreco, editTextLuxoDblComBanheiro, editTextLuxoDblSemBanheiro,
            editTextLuxoTplPreco, editTextLuxoTplComBanheiro, editTextLuxoTplSemBanheiro,
            editTextSuiteExecutivaPreco, editTextSuiteExecutivaComBanheiro, editTextSuiteExecutivaSemBanheiro,
            editTextSuitePresidencialPreco, editTextSuitePresidencialComBanheiro, editTextSuitePresidencialSemBanheiro,
            editTextChalePreco, editTextChaleComBanheiro, editTextChaleSemBanheiro,
            editTextPermanenciaMediaHotel,
            editTextKitinetePreco, editTextKitineteComBanheiro, editTextKitineteSemBanheiro,
            editTextUmQuartoPreco, editTextUmQuartoComBanheiro, editTextUmQuartoSemBanheiro,
            editTextDoisQuartosPreco, editTextDoisQuartosComBanheiro, editTextDoisQuartosSemBanheiro,
            editTextTresQuartosPreco, editTextTresQuartosComBanheiro, editTextTresQuartosSemBanheiro,
            editTextPermanenciaMediaFlat,
            editTextColetivoPreco, editTextColetivoComBanheiro, editTextColetivoSemBanheiro,
            editTextQuartoPreco, editTextQuartoComBanheiro, editTextQuartoSemBanheiro,
            editTextPermanenciaMediaQuarto,
            editTextUnidadeHabitacional, editTextCamaCasal, editTextCamaSolteiro, editTextLeitos,
            editTextApartamentoOcupado, editTextNumeroHospedes, editTextCartao,
            editTextTotalCamareira, editTextSalarioCamareira,
            editTextTotalCarregadores, editTextSalarioCarregadores,
            editTextTotalCozinheiro, editTextSalarioCozinheiro,
            editTextTotalFaxineiro, editTextSalarioFaxineiro,
            editTextTotalGarcon, editTextSalarioGarcon,
            editTextTotalPorteiro, editTextSalarioPorteiro,
            editTextTotalRecepcionista, editTextSalarioRecepcionista,
            editTextTotalOutros, editTextSalarioOutros,
            editTextObservacoes;

    private RadioGroup natureza, cadeiaHoteleira, hotelPousada, cafeManha, diaria, cartao;

    private CheckBox permanenciaHotelPousada, albergue, ar, banheiro, chuveiroEletrico, cofre,
            fogao, frigobar, guardaRoupa, sala, som, telefone, televisao, ventilador, auditorio,
            bar, telefoneComunitario, estacionamento, piscina, quadra, salao, salaReuniao,
            sauna, somAmbiente, televisaoComunitaria;

    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    EquipamentoHoteleiro eht = new EquipamentoHoteleiro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_equipamento_hoteleiro);

        Button btnSalvar = (Button) findViewById(R.id.buttonSalvar);
        btnSalvar.setOnClickListener(btnSalvarAction);

        editTextCategoria = (EditText) findViewById(R.id.editTextCategoria);
        editTextTipo = (EditText) findViewById(R.id.editTextTipo);
        editTextSubtipo = (EditText) findViewById(R.id.editTextSubtipo);
        editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
        editTextUF = (EditText) findViewById(R.id.editTextUF);
        editTextMunicipio = (EditText) findViewById(R.id.editTextMunicipio);
        editTextDistrito = (EditText) findViewById(R.id.editTextDistrito);
        editTextClassificacao = (EditText) findViewById(R.id.editTextClassificacaoEmbratur);
        editTextDenominacao = (EditText) findViewById(R.id.editTextDenominacao);
        editTextRazaoSocial = (EditText) findViewById(R.id.editTextRazaoSocial);
        editTextRazaoProprietario = (EditText) findViewById(R.id.editTextRazaoProprietario);
        editTextInformacoes = (EditText) findViewById(R.id.editTextInformacoes);
        editTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextFax = (EditText) findViewById(R.id.editTextFax);
        editTextHomePage = (EditText) findViewById(R.id.editTextHomePage);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextTelefoneReserva = (EditText) findViewById(R.id.editTextTelefoneReserva);
        editTextRegistroEmbratur = (EditText) findViewById(R.id.editTextRegistroEmbratur);
        editTextDataInicio = (EditText) findViewById(R.id.editTextDataInicio);
        editTextCitar = (EditText) findViewById(R.id.editTextCitar);
        editTextApartSglPreco = (EditText) findViewById(R.id.editTextSGLPreco);
        editTextApartSglAposentoComBanheiro = (EditText) findViewById(R.id.editTextSGLAposentosComBanheiros);
        editTextApartSglAposentoSemBanheiro = (EditText) findViewById(R.id.editTextSGLAposentosSemBanheiros);
        editTextApartDblPreco = (EditText) findViewById(R.id.editTextDBLPreco);
        editTextApartDblComBanheiro = (EditText) findViewById(R.id.editTextDBLAposentosComBanheiros);
        editTextApartDblSemBanheiro = (EditText) findViewById(R.id.editTextDBLAposentosSemBanheiros);
        editTextApartTplPreco = (EditText) findViewById(R.id.editTextApartTPLPreco);
        editTextApartTplComBanheiro = (EditText) findViewById(R.id.editTextApartTPLAposentosComBanheiro);
        editTextApartTplSemBanheiro = (EditText) findViewById(R.id.editTextApartTPLAposentosSemBanheiro);
        editTextLuxoSglPreco = (EditText) findViewById(R.id.editTextLuxoSGLPreco);
        editTextLuxoSglAposentoComBanheiro = (EditText) findViewById(R.id.editTextLuxoSGLAposentosComBanheiro);
        editTextLuxoSglAposentoSemBanheiro = (EditText) findViewById(R.id.editTextLuxoSGLAposentosSemBanheiros);
        editTextLuxoDblPreco = (EditText) findViewById(R.id.editTextLuxoDBLPreco);
        editTextLuxoDblComBanheiro = (EditText) findViewById(R.id.editTextLuxoDBLAposentosComBanheiro);
        editTextLuxoDblSemBanheiro = (EditText) findViewById(R.id.editTextLuxoDBLAposentosSemBanheiros);
        editTextLuxoTplPreco = (EditText) findViewById(R.id.editTextApartLuxoTPLPreco);
        editTextLuxoTplComBanheiro = (EditText) findViewById(R.id.editTextApartLuxoTPLAposentosComBanheiro);
        editTextLuxoTplSemBanheiro = (EditText) findViewById(R.id.editTextApartLuxoTPLAposentosSemBanheiro);
        editTextSuiteExecutivaPreco = (EditText) findViewById(R.id.editTextSuiteExecutivaPreco);
        editTextSuiteExecutivaComBanheiro = (EditText) findViewById(R.id.editTextSuiteExecutivaAposentosComBanheiro);
        editTextSuiteExecutivaSemBanheiro = (EditText) findViewById(R.id.editTextSuiteExecutivaAposentosSemBanheiro);
        editTextSuitePresidencialPreco = (EditText) findViewById(R.id.editTextSuitePresidencialPreco);
        editTextSuitePresidencialComBanheiro = (EditText) findViewById(R.id.editTextSuitePresidencialAposentosComBanheiro);
        editTextSuitePresidencialSemBanheiro = (EditText) findViewById(R.id.editTextSuitePresidencialAposentosSemBanheiro);
        editTextChalePreco = (EditText) findViewById(R.id.editTextChalePreco);
        editTextChaleComBanheiro = (EditText) findViewById(R.id.editTextChaleAposentosComBanheiro);
        editTextChaleSemBanheiro = (EditText) findViewById(R.id.editTextChaleAposentosSemBanheiros);
        editTextPermanenciaMediaHotel = (EditText) findViewById(R.id.editTextPermanenciaHotelPousada);
        editTextKitinetePreco = (EditText) findViewById(R.id.editTextKitinetePreco);
        editTextKitineteComBanheiro = (EditText) findViewById(R.id.editTextKitineteAposentosComBanheiro);
        editTextKitineteSemBanheiro = (EditText) findViewById(R.id.editTextKitineteAposentosSemBanheiro);
        editTextUmQuartoPreco = (EditText) findViewById(R.id.editTextUmQuartoPreco);
        editTextUmQuartoComBanheiro = (EditText) findViewById(R.id.editTextUmQuartoAposentosComBanheiro);
        editTextUmQuartoSemBanheiro = (EditText) findViewById(R.id.editTextUmQuartoAposentosSemBanheiros);
        editTextDoisQuartosPreco = (EditText) findViewById(R.id.editTextDoisQuartosPreco);
        editTextDoisQuartosComBanheiro = (EditText) findViewById(R.id.editTextDoisQuartosAposentosComBanheiro);
        editTextDoisQuartosSemBanheiro = (EditText) findViewById(R.id.editTextDoisQuartosAposentosSemBanheiros);
        editTextTresQuartosPreco = (EditText) findViewById(R.id.editTextTresQuartosPreco);
        editTextTresQuartosComBanheiro = (EditText) findViewById(R.id.editTextTresQuartosAposentosComBanheiro);
        editTextTresQuartosSemBanheiro = (EditText) findViewById(R.id.editTextTresQuartosAposentosSemBanheiro);
        editTextPermanenciaMediaFlat = (EditText) findViewById(R.id.editTextPermanenciaFlatPartHotel);
        editTextColetivoPreco = (EditText) findViewById(R.id.editTextColetivoPreco);
        editTextColetivoComBanheiro = (EditText) findViewById(R.id.editTextColetivoAposentosComBanheiro);
        editTextColetivoSemBanheiro = (EditText) findViewById(R.id.editTextColetivoAposentosSemBanheiro);
        editTextQuartoPreco = (EditText) findViewById(R.id.editTextQuartoPreco);
        editTextQuartoComBanheiro = (EditText) findViewById(R.id.editTextQuartoAposentosComBanheiro);
        editTextQuartoSemBanheiro = (EditText) findViewById(R.id.editTextQuartoAposentosSemBanheiro);
        editTextPermanenciaMediaQuarto = (EditText) findViewById(R.id.editTextPermanenciaQuarto);
        editTextUnidadeHabitacional = (EditText) findViewById(R.id.editTextUnidadeHabitacional);
        editTextCamaCasal = (EditText) findViewById(R.id.editTextCasal);
        editTextCamaSolteiro = (EditText) findViewById(R.id.editTextSolteiro);
        editTextLeitos = (EditText) findViewById(R.id.editTextLeitos);
        editTextApartamentoOcupado = (EditText) findViewById(R.id.editTextApartamentosOcupados);
        editTextNumeroHospedes = (EditText) findViewById(R.id.editTextNumeroHospedes);
        editTextCartao = (EditText) findViewById(R.id.editTextQuaisCartoes);
        editTextTotalCamareira = (EditText) findViewById(R.id.editTextTotalCamareiras);
        editTextSalarioCamareira = (EditText) findViewById(R.id.editTextSalarioCamareiras);
        editTextTotalCarregadores = (EditText) findViewById(R.id.editTextTotalCarregadores);
        editTextSalarioCarregadores = (EditText) findViewById(R.id.editTextSalarioCarregadores);
        editTextTotalCozinheiro = (EditText) findViewById(R.id.editTextCozinheirosTotal);
        editTextSalarioCozinheiro = (EditText) findViewById(R.id.editTextCozinheirosSalario);
        editTextTotalFaxineiro = (EditText) findViewById(R.id.editTextFaxineirosTotal);
        editTextSalarioFaxineiro = (EditText) findViewById(R.id.editTextFaxineirosSalario);
        editTextTotalGarcon = (EditText) findViewById(R.id.editTextGarconsTotal);
        editTextSalarioGarcon = (EditText) findViewById(R.id.editTextGarconsSalario);
        editTextTotalPorteiro = (EditText) findViewById(R.id.editTextPorteirosTotal);
        editTextSalarioPorteiro = (EditText) findViewById(R.id.editTextPorteirosSalario);
        editTextTotalRecepcionista = (EditText) findViewById(R.id.editTextRecepcionistasTotal);
        editTextSalarioRecepcionista = (EditText) findViewById(R.id.editTextRecepcionistasSalario);
        editTextTotalOutros = (EditText) findViewById(R.id.editTextOutrosTotal);
        editTextSalarioOutros = (EditText) findViewById(R.id.editTextOutrosSalario);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoesComplementares);

        natureza = (RadioGroup) findViewById(R.id.radioGroupNatureza);
        cadeiaHoteleira = (RadioGroup) findViewById(R.id.radioGroupCadeia);
        hotelPousada = (RadioGroup) findViewById(R.id.radioGroupHotelPousada);
        cafeManha = (RadioGroup) findViewById(R.id.radioGroupCafeManha);
        diaria = (RadioGroup) findViewById(R.id.radioGroupIncluidoDiaria);
        cartao = (RadioGroup) findViewById(R.id.radioGroupAceitaCartao);

        permanenciaHotelPousada = (CheckBox) findViewById(R.id.checkBoxPermanenciaHotelPousada);
        albergue = (CheckBox) findViewById(R.id.checkBoxAlbergue);
        ar = (CheckBox) findViewById(R.id.checkBoxAr);
        banheiro = (CheckBox) findViewById(R.id.checkBoxBanheiro);
        chuveiroEletrico = (CheckBox) findViewById(R.id.checkBoxChuveiroEletrico);
        cofre = (CheckBox) findViewById(R.id.checkBoxCofre);
        fogao = (CheckBox) findViewById(R.id.checkBoxFogao);
        frigobar = (CheckBox) findViewById(R.id.checkBoxFrigobar);
        guardaRoupa = (CheckBox) findViewById(R.id.checkBoxGuardaRoupa);
        sala = (CheckBox) findViewById(R.id.checkBoxSala);
        som = (CheckBox) findViewById(R.id.checkBoxSom);
        telefone = (CheckBox) findViewById(R.id.checkBoxTelefone);
        televisao = (CheckBox) findViewById(R.id.checkBoxTelevisao);
        ventilador = (CheckBox) findViewById(R.id.checkBoxVentilador);
        auditorio = (CheckBox) findViewById(R.id.checkBoxAuditorio);
        bar = (CheckBox) findViewById(R.id.checkBoxBar);
        telefoneComunitario = (CheckBox) findViewById(R.id.checkBoxTelefoneComunitario);
        estacionamento = (CheckBox) findViewById(R.id.checkBoxEstacionamentoProprio);
        piscina = (CheckBox) findViewById(R.id.checkBoxPiscina);
        quadra = (CheckBox) findViewById(R.id.checkBoxQuadra);
        salao = (CheckBox) findViewById(R.id.checkBoxSalao);
        salaReuniao = (CheckBox) findViewById(R.id.checkBoxSalaReuniao);
        sauna = (CheckBox) findViewById(R.id.checkBoxSauna);
        somAmbiente = (CheckBox) findViewById(R.id.checkBoxSomAmbiente);
        televisaoComunitaria = (CheckBox) findViewById(R.id.checkBoxTelevisaoComunitaria);

    }

    private View.OnClickListener btnSalvarAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            eht.setAuth(firebaseUser.getEmail());
            eht.setCategoria(editTextCategoria.getText().toString());
            eht.setTipo(editTextTipo.getText().toString());
            eht.setSubtipo(editTextSubtipo.getText().toString());
            eht.setCodigo(editTextCodigo.getText().toString());
            eht.setUf(editTextUF.getText().toString());
            eht.setMunicipio(editTextMunicipio.getText().toString());
            eht.setDistrito(editTextDistrito.getText().toString());
            eht.setClassificacao(editTextClassificacao.getText().toString());
            eht.setDenominacao(editTextDenominacao.getText().toString());
            eht.setRazao_social(editTextRazaoSocial.getText().toString());
            eht.setRazao_proprietario(editTextRazaoProprietario.getText().toString());
            eht.setInformacoes(editTextInformacoes.getText().toString());
            eht.setEndereco(editTextEndereco.getText().toString());
            eht.setTelefone(editTextTelefone.getText().toString());
            eht.setFax(editTextFax.getText().toString());
            eht.setHome_page(editTextHomePage.getText().toString());
            eht.setEmail(editTextEmail.getText().toString());
            eht.setTelefone_reserva(editTextTelefoneReserva.getText().toString());
            eht.setRegistro_embratur(editTextRegistroEmbratur.getText().toString());
            eht.setData_inicio(editTextDataInicio.getText().toString());
            eht.setCitar(editTextCitar.getText().toString());
            eht.setApart_sgl_preco(editTextApartSglPreco.getText().toString());
            eht.setApart_sgl_aposento_com_banheiro(editTextApartSglAposentoComBanheiro.getText().toString());
            eht.setApart_sgl_aposento_sem_banheiro(editTextApartSglAposentoSemBanheiro.getText().toString());
            eht.setApart_dbl_preco(editTextApartDblPreco.getText().toString());
            eht.setApart_dbl_com_banheiro(editTextApartDblComBanheiro.getText().toString());
            eht.setApart_dbl_sem_banheiro(editTextApartDblSemBanheiro.getText().toString());
            eht.setApart_tpl_preco(editTextApartTplPreco.getText().toString());
            eht.setApart_tpl_com_banheiro(editTextApartTplComBanheiro.getText().toString());
            eht.setApart_tpl_sem_banheiro(editTextApartTplSemBanheiro.getText().toString());
            eht.setApart_tpl_preco(editTextApartTplPreco.getText().toString());
            eht.setApart_tpl_com_banheiro(editTextApartTplComBanheiro.getText().toString());
            eht.setApart_tpl_sem_banheiro(editTextApartTplSemBanheiro.getText().toString());
            eht.setLuxo_sgl_preco(editTextLuxoSglPreco.getText().toString());
            eht.setLuxo_sgl_aposento_com_banheiro(editTextLuxoSglAposentoComBanheiro.getText().toString());
            eht.setLuxo_sgl_aposento_sem_banheiro(editTextLuxoSglAposentoSemBanheiro.getText().toString());
            eht.setLuxo_dbl_preco(editTextLuxoDblPreco.getText().toString());
            eht.setLuxo_dbl_com_banheiro(editTextLuxoDblComBanheiro.getText().toString());
            eht.setLuxo_dbl_sem_banheiro(editTextLuxoDblSemBanheiro.getText().toString());
            eht.setLuxo_tpl_preco(editTextLuxoTplPreco.getText().toString());
            eht.setLuxo_tpl_com_banheiro(editTextLuxoTplComBanheiro.getText().toString());
            eht.setLuxo_tpl_sem_banheiro(editTextLuxoTplSemBanheiro.getText().toString());
            eht.setSuite_executiva_preco(editTextSuiteExecutivaPreco.getText().toString());
            eht.setSuite_executiva_com_banheiro(editTextSuiteExecutivaComBanheiro.getText().toString());
            eht.setSuite_executiva_sem_banheiro(editTextSuiteExecutivaSemBanheiro.getText().toString());
            eht.setSuite_presidencial_preco(editTextSuitePresidencialPreco.getText().toString());
            eht.setSuite_presidencial_com_banheiro(editTextSuitePresidencialComBanheiro.getText().toString());
            eht.setSuite_presidencial_sem_banheiro(editTextSuitePresidencialSemBanheiro.getText().toString());
            eht.setChale_preco(editTextChalePreco.getText().toString());
            eht.setChale_com_banheiro(editTextChaleComBanheiro.getText().toString());
            eht.setChale_sem_banheiro(editTextChaleSemBanheiro.getText().toString());
            eht.setPermanencia_media_hotel(editTextPermanenciaMediaHotel.getText().toString());
            eht.setKitinete_preco(editTextKitinetePreco.getText().toString());
            eht.setKitinete_com_banheiro(editTextKitineteComBanheiro.getText().toString());
            eht.setKitinete_sem_banheiro(editTextKitineteSemBanheiro.getText().toString());
            eht.setUm_quarto_preco(editTextUmQuartoPreco.getText().toString());
            eht.setUm_quarto_com_banheiro(editTextUmQuartoComBanheiro.getText().toString());
            eht.setUm_quarto_sem_banheiro(editTextUmQuartoSemBanheiro.getText().toString());
            eht.setDois_quartos_preco(editTextDoisQuartosPreco.getText().toString());
            eht.setDois_quartos_com_banheiro(editTextDoisQuartosComBanheiro.getText().toString());
            eht.setDois_quartos_sem_banheiro(editTextDoisQuartosSemBanheiro.getText().toString());
            eht.setTres_quarto_preco(editTextTresQuartosPreco.getText().toString());
            eht.setTres_quartos_com_banheiro(editTextTresQuartosComBanheiro.getText().toString());
            eht.setTres_quartos_sem_banheiro(editTextTresQuartosSemBanheiro.getText().toString());
            eht.setPermanencia_media_flat(editTextPermanenciaMediaFlat.getText().toString());
            eht.setColetivo_preco(editTextColetivoPreco.getText().toString());
            eht.setColetivo_com_banheiro(editTextColetivoComBanheiro.getText().toString());
            eht.setColetivo_sem_banheiro(editTextColetivoSemBanheiro.getText().toString());
            eht.setQuarto_preco(editTextQuartoPreco.getText().toString());
            eht.setQuarto_com_banheiro(editTextQuartoComBanheiro.getText().toString());
            eht.setQuarto_sem_banheiro(editTextQuartoSemBanheiro.getText().toString());
            eht.setPermanencia_media_quarto(editTextPermanenciaMediaQuarto.getText().toString());
            eht.setUnidade_habitacional(editTextUnidadeHabitacional.getText().toString());
            eht.setCama_casal(editTextCamaCasal.getText().toString());
            eht.setCama_solteiro(editTextCamaSolteiro.getText().toString());
            eht.setLeitos(editTextLeitos.getText().toString());
            eht.setApartamento_ocupado(editTextApartamentoOcupado.getText().toString());
            eht.setNumero_hospedes(editTextNumeroHospedes.getText().toString());
            eht.setCartao(editTextCartao.getText().toString());
            eht.setTotal_camareira(editTextTotalCamareira.getText().toString());
            eht.setSalario_camareira(editTextSalarioCamareira.getText().toString());
            eht.setTotal_carregadores(editTextTotalCarregadores.getText().toString());
            eht.setSalario_carregadores(editTextSalarioCarregadores.getText().toString());
            eht.setTotal_cozinheiro(editTextTotalCozinheiro.getText().toString());
            eht.setSalario_cozinheiro(editTextSalarioCozinheiro.getText().toString());
            eht.setTotal_faxineiro(editTextTotalFaxineiro.getText().toString());
            eht.setSalario_faxineiro(editTextSalarioFaxineiro.getText().toString());
            eht.setTotal_garcon(editTextTotalGarcon.getText().toString());
            eht.setSalario_garcon(editTextSalarioGarcon.getText().toString());
            eht.setTotal_porteiro(editTextTotalPorteiro.getText().toString());
            eht.setSalario_porteiro(editTextSalarioPorteiro.getText().toString());
            eht.setTotal_recepcionista(editTextTotalRecepcionista.getText().toString());
            eht.setSalario_recepcionista(editTextSalarioRecepcionista.getText().toString());
            eht.setTotal_outros(editTextTotalOutros.getText().toString());
            eht.setSalario_outros(editTextSalarioOutros.getText().toString());
            eht.setObservacoes(editTextObservacoes.getText().toString());

            natureza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonHoteis:
                            eht.setNatureza("apart hotel");
                            break;
                        case R.id.radioButtonPousadas:
                            eht.setNatureza("pousada");
                            break;
                        case R.id.radioButtonPensao:
                            eht.setNatureza("pensão");
                            break;
                        case R.id.radioButtonHotel:
                            eht.setNatureza("hotel");
                            break;
                        case R.id.radioButtonAlbergues:
                            eht.setNatureza("albergue");
                            break;
                        case R.id.radioButtonFlat:
                            eht.setNatureza("flat");
                            break;
                        case R.id.radioButtonCasaFamilia:
                            eht.setNatureza("casa de familia");
                            break;
                        case R.id.radioButtonOutros:
                            eht.setNatureza("outros");
                            break;
                    }
                }
            });

            cadeiaHoteleira.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonCadeiaSim:
                            eht.setCafe_manha("sim");
                            break;
                        case R.id.radioButtonCadeiaNao:
                            eht.setCafe_manha("não");
                            break;
                    }
                }
            });

            hotelPousada.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonHotel2:
                            eht.setHotel_pousada("hotel");
                            break;
                        case R.id.radioButtonPousada:
                            eht.setHotel_pousada("pousada");
                            break;
                    }
                }
            });

            cafeManha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSimCafe:
                            eht.setCafe_manha("sim");
                            break;
                        case R.id.radioButtonNaoCafe:
                            eht.setCafe_manha("não");
                            break;
                    }
                }
            });

            diaria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSimIncluido:
                            eht.setDiaria("sim");
                            break;
                        case R.id.radioButtonNaoIncluido:
                            eht.setDiaria("não");
                            break;
                    }
                }
            });

            cartao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButtonSimAceita:
                            eht.setCartao_rg("sim");
                            break;
                        case R.id.radioButtonNaoAceita:
                            eht.setCartao_rg("não");
                            break;
                    }
                }
            });

            if(permanenciaHotelPousada.isChecked()){
                eht.setPermanencia_hotel_pousada_checkbox("true");
            }

            if(albergue.isChecked()){
                eht.setAlbergue_checkbox("true");
            }

            if(ar.isChecked()){
                eht.setAr_checkbox("true");
            }

            if(banheiro.isChecked()){
                eht.setBanheiro_checkbox("true");
            }

            if(chuveiroEletrico.isChecked()){
                eht.setChuveiro_eletrico_checkbox("true");
            }

            if(cofre.isChecked()){
                eht.setCofre_checkbox("true");
            }

            if(fogao.isChecked()){
                eht.setFogao_checkbox("true");
            }

            if(frigobar.isChecked()){
                eht.setFrigobar_checkbox("true");
            }

            if(guardaRoupa.isChecked()){
                eht.setGuarda_roupa_checkbox("true");
            }

            if(sala.isChecked()){
                eht.setSala_checkbox("true");
            }

            if(som.isChecked()){
                eht.setSom_checkbox("true");
            }

            if(telefone.isChecked()){
                eht.setTelefone_checkbox("true");
            }

            if(televisao.isChecked()){
                eht.setTelevisao_checkbox("true");
            }

            if(ventilador.isChecked()){
                eht.setVentilador_checkbox("true");
            }

            if(auditorio.isChecked()){
                eht.setAuditorio_checkbox("true");
            }

            if(bar.isChecked()){
                eht.setBar_checkbox("true");
            }

            if(telefoneComunitario.isChecked()){
                eht.setTelefone_comunitario_checkbox("true");
            }

            if(estacionamento.isChecked()){
                eht.setEstacionamento_checkbox("true");
            }

            if(piscina.isChecked()){
                eht.setPiscina_checkbox("true");
            }
            if(quadra.isChecked()){
                eht.setQuadra_checkbox("true");
            }

            if(salao.isChecked()){
                eht.setSalao_checkbox("true");
            }

            if(salaReuniao.isChecked()){
                eht.setSala_reuniao_checkbox("true");
            }

            if(sauna.isChecked()){
                eht.setSauna_checkbox("true");
            }

            if(somAmbiente.isChecked()){
                eht.setSom_ambiente_checkbox("true");
            }

            if(televisaoComunitaria.isChecked()){
                eht.setTelevisao_comunitaria_checkbox("true");
            }

            firebaseReference.child("equipamento_hoteleiro").push().setValue(eht);

            Toast toast = Toast.makeText(getApplicationContext(), "Dado salvo com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    };
}
