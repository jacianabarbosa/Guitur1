package com.example.albertozaranza.guitura.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.albertozaranza.guitura.R;
import com.example.albertozaranza.guitura.accounts.LoginActivity;
import com.example.albertozaranza.guitura.formularios.frmAtrativosTuristicos;
import com.example.albertozaranza.guitura.formularios.frmAtrativosTuristicosNaturais;
import com.example.albertozaranza.guitura.formularios.frmEntretenimentoOutrosServicos;
import com.example.albertozaranza.guitura.formularios.frmEquipamentoExtraHoteleiro;
import com.example.albertozaranza.guitura.formularios.frmEquipamentoExtraHoteleiroAlimentacaoEntretenimento;
import com.example.albertozaranza.guitura.formularios.frmEquipamentoHoteleiro;
import com.example.albertozaranza.guitura.formularios.frmInfraEstruturaApoioTuristico;
import com.example.albertozaranza.guitura.formularios.frmSistemaComunicacoes;
import com.example.albertozaranza.guitura.formularios.frmSistemaTransporte;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button buttonAtrativosTuristicosNaturais, buttonAtrativosTuristicos,
            buttonEquipamentoHoteleiro, buttonEquipamentoExtraHoteleiroAT,
            buttonEquipamentoExtraHoteleiroAEO, buttonEntretenimentos,
            buttonInfraestrutura, buttonSistemaTransporte,
            buttonSistemaComunicacao;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        buttonAtrativosTuristicosNaturais = (Button) findViewById(R.id.buttonAtrativosTuristicosNaturais);
        buttonAtrativosTuristicos = (Button) findViewById(R.id.buttonAtrativosTuristicos);
        buttonEquipamentoHoteleiro = (Button) findViewById(R.id.buttonEquipamentoHoteleiro);
        buttonEquipamentoExtraHoteleiroAT = (Button) findViewById(R.id.buttonEquipamentoExtraHoteleiroAT);
        buttonEquipamentoExtraHoteleiroAEO = (Button) findViewById(R.id.buttonEquipamentoExtraHoteleiroAEO);
        buttonEntretenimentos = (Button) findViewById(R.id.buttonEntretenimentos);
        buttonInfraestrutura = (Button) findViewById(R.id.buttonInfraestrutura);
        buttonSistemaTransporte = (Button) findViewById(R.id.buttonSistemaTransporte);
        buttonSistemaComunicacao = (Button) findViewById(R.id.buttonSistemaComunicacao);
        Button signOut = (Button) findViewById(R.id.btn_sign_out);

        buttonAtrativosTuristicosNaturais.setOnClickListener(btnAtrativosTuristicosNaturaisAction);
        buttonAtrativosTuristicos.setOnClickListener(btnAtrativosTuristicosAction);
        buttonEquipamentoHoteleiro.setOnClickListener(btnEquipamentoHoteleiroAction);
        buttonEquipamentoExtraHoteleiroAT.setOnClickListener(btnEquipamentoExtraHoteleiroATAction);
        buttonEquipamentoExtraHoteleiroAEO.setOnClickListener(btnEquipamentoExtraHoteleiroAEOAction);
        buttonEntretenimentos.setOnClickListener(btnEntretenimentosAction);
        buttonInfraestrutura.setOnClickListener(btnInfraestruturaAction);
        buttonSistemaTransporte.setOnClickListener(btnSistemaTransporteAction);
        buttonSistemaComunicacao.setOnClickListener(btnSistemaComunicacoesAction);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    private View.OnClickListener btnAtrativosTuristicosNaturaisAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmAtrativosTuristicosNaturais.class));
        }
    };

    private View.OnClickListener btnAtrativosTuristicosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmAtrativosTuristicos.class));
        }
    };

    private View.OnClickListener btnEquipamentoHoteleiroAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmEquipamentoHoteleiro.class));
        }
    };

    private View.OnClickListener btnEquipamentoExtraHoteleiroATAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmEquipamentoExtraHoteleiro.class));
        }
    };

    private View.OnClickListener btnEquipamentoExtraHoteleiroAEOAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmEquipamentoExtraHoteleiroAlimentacaoEntretenimento.class));
        }
    };

    private View.OnClickListener btnEntretenimentosAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmEntretenimentoOutrosServicos.class));
        }
    };

    private View.OnClickListener btnInfraestruturaAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmInfraEstruturaApoioTuristico.class));
        }
    };

    private View.OnClickListener btnSistemaTransporteAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmSistemaTransporte.class));
        }
    };

    private View.OnClickListener btnSistemaComunicacoesAction = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, frmSistemaComunicacoes.class));
        }
    };

}
