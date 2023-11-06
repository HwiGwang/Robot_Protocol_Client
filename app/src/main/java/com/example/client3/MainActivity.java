package com.example.client3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SocketClient";
    private Socket socket;
    private TextView receivedMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedMessageTextView = findViewById(R.id.receivedMessageTextView);

        new SocketClient().execute();
    }

    private class SocketClient extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                socket = new Socket("192.168.35.149", 64321);


                Make sendData = new Make((byte)0x00,(byte)0x01,1.0f,2.0f,3.0f,4.0f,5.0f,6.0f);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(sendData);

                InputStream in = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(in);


                Make receivedData = (Make) objectInputStream.readObject();
                objectInputStream.close();

                return "Received: MainCommandType=" + receivedData.getMainCommandType() +
                        ", SubCommandType=" + receivedData.getSubCommandType() +
                        ", X=" + receivedData.getX() +
                        ", Y=" + receivedData.getY() +
                        ", Z=" + receivedData.getZ() +
                        ", RX=" + receivedData.getRX() +
                        ", RY=" + receivedData.getRY() +
                        ", RZ=" + receivedData.getRZ();


            } catch (IOException | ClassNotFoundException e) {
                Log.e(TAG, "Error: " + e.getMessage());
                return "오류 발생";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Log.d(TAG, "서버로부터 받은 메시지: " + result);

            // 결과를 UI에 표시
            receivedMessageTextView.setText("서버로부터 받은 메시지: " + result);
        }
    }
}