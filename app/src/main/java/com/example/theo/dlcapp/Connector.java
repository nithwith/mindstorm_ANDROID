package com.example.theo.dlcapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.UUID;

public class Connector {

    //Target NXTs for communication



    BluetoothAdapter localAdapter;
    BluetoothSocket socket_nxt;
    boolean success = false;

    // Enables Bluetooth if not enabled
    public void enableBT(){
        localAdapter = BluetoothAdapter.getDefaultAdapter();
        // If Bluetooth not enable then do it
        if (!localAdapter.isEnabled()) {
            localAdapter.enable();
            while(!(localAdapter.isEnabled()));
        }
    }

    // Connect to both NXTs
    public boolean connectToNXT() {

        // Get the BluetoothDevice of the NXT

        //ADRESSE NXT A DEFINIR

        String addr = "00:16:53:07:AA:F6";

        BluetoothDevice nxt = localAdapter.getRemoteDevice(addr);
        // Try to connect to the nxt
        try {
            socket_nxt = nxt.createRfcommSocketToServiceRecord(UUID
                    .fromString("00001101-0000-1000-8000-00805F9B34FB"));

            socket_nxt.connect();

            success = true;

        } catch (IOException e) {
            Log.d("Bluetooth","Err: Device not found or cannot connect");
            success=false;
        }
        return success;
    }


    public void writeMessage(byte msg) throws InterruptedException {
        BluetoothSocket connSock;


        connSock = socket_nxt;

        try {

            OutputStreamWriter out = new OutputStreamWriter(connSock.getOutputStream());
            out.write(msg);
            out.flush();

            Thread.sleep(1000);

        } catch (IOException e) {
            // TODO: Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int readMessage(String nxt) {
        BluetoothSocket connSock;
        int n;

        connSock=socket_nxt;

        if (connSock!=null) {
            try {

                InputStreamReader in = new InputStreamReader(connSock.getInputStream());
                n = in.read();
                return n;

            } catch (IOException e) {
                // TODO: Auto-generated catch block
                e.printStackTrace();
                return -1;
            }
        } else {
            // Error
            return -1;
        }
    }
}
