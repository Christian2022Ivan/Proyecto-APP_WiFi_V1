package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaramos nuestros objetos
    Button b1, b2;
    TextView tv1;
    WifiManager wifi;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Realizamos nuestros enlaces
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.tv1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        //Decalramos la clase WifiManager, nos va a permitir obtener
        //        //los datos relativos a la conexión WIFI con nuestro dispositivo Android.
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        tv1.setText("Información WiFi:" +info.toString());
        //Para obtener la lista de redes configuradas
        List<WifiConfiguration> lista = wifi.getConfiguredNetworks();
        for (WifiConfiguration config: lista) {
            texto="\n\n"+config.toString();
        }
        tv1.append(texto);
    }
    //Declaramos el metodo OnClick el cual nos ayudara con la acción de los botones
    //Con un Toast se mandara un mensaje cuando se presione Habilitar o Inhabilitar
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button1)
        {
            wifi.setWifiEnabled(true);
            Toast.makeText(getApplicationContext(),"Wifi Habilitado ",Toast.LENGTH_SHORT).show();
        }
        if (view.getId()==R.id.button2)
        {
            wifi.setWifiEnabled(false);
            Toast.makeText(getApplicationContext(),"WiFi Deshabilitado",Toast.LENGTH_SHORT).show();
        }

    }
}