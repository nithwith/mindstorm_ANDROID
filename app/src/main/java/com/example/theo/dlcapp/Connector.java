package com.example.theo.dlcapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.util.UUID;

public class Connector {

    //Target NXTs for communication
    public static BluetoothAdapter localAdapter;
    public static BluetoothSocket socket_nxt;
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

        enableBT();

        String addr = "00:16:53:0A:AC:62";


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


    public void write(String input) {
        try {
            OutputStream outputStream = socket_nxt.getOutputStream();
            outputStream.write("test".getBytes());
            //outputStream.write(12345);
            //outputStream.write(input.getBytes());
            outputStream.flush();
        } catch (IOException e) {

        }
    }


    public void writeMessage(String msg) throws InterruptedException {
        BluetoothSocket connSock;

        connSock = socket_nxt;

        byte m = 1;

        try {
            OutputStreamWriter out = new OutputStreamWriter(connSock.getOutputStream());
            out.write(m);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

            Thread.sleep(1000);


    }

    public int readMessage(String nxt) {
        BluetoothSocket connSock;
        int n;

        connSock=socket_nxt;

        if (connSock!=null) {
            try {

                int size = 40;

                InputStreamReader inputStream = new InputStreamReader(connSock.getInputStream());

                char[] sizeOfIncomingData = new char[size];
                inputStream.read(sizeOfIncomingData, 0, size);


                String message = String.valueOf(sizeOfIncomingData);

                System.out.println(message);
                return 1;
                //InputStreamReader in = new InputStreamReader(connSock.getInputStream());

                //n = in.read();
                //return n;

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


    public String buildMessageLumiere(String type, int val1, int val2, int val3){

        String msg = new String();



        if(type.equals("setLum")){

            //val1 = id_lumiere
            //val2 = action (on = 1 / off = 0)
            //val3 = intensity


            msg = "/lum"
                    +String.valueOf(val1)+";"
                    +String.valueOf(val2)+";"
                    +String.valueOf(val3);
        }
        if(type.equals("confTemp")){

            //val1 = T1
            //val2 = T2
            //val3 = T3

            msg = "/confTemp"
                    +String.valueOf(val1)+";"
                    +String.valueOf(val2)+";"
                    +String.valueOf(val3);
        }

        return msg;
    }




    private int getIntFromByteArray(byte[] bytes)
    {
        return (bytes[0] & 0xFF) << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
    }
}
