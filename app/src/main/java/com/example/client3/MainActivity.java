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
                socket = new Socket("192.168.35.149", 14321);

                // MakeType00~등을 이용해서 객체 생성 << 이건 서버로 데이터를 보내기위해 테스트한 것
                Make sendData0 = new Make_User((byte) 0x4, (byte) 0x01, 0, 3.0f, 4.0f, 5.0f,
                        6.0f, 0, 0, 0, 1);

                Make sendData1 = new Make_Move((byte) 0x4, (byte) 0x01, (byte) 0x03, (byte) 0x00, "Move", 3.0f, 4.0f, 5.0f,
                        6.0f, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                        12, 13, 14, 15, 16, 17, 18, 19, 20, 21, (byte) 0x00, (byte) 0x01);
                Make sendData2 = new Make_Circle((byte) 0x05, (byte) 0x01, (byte) 0x00, (byte) 0x00, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
                Make sendData3 = new Make_Debug((byte) 0x07, (byte) 0x00, "Debug 확인");
                Make sendData4 = new Make_Set((byte)0x08, (byte)0x00, 0,0,0,0,0,0,0,0,0,0,0,(byte) 0x00,(byte) 0x00,
                        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,(byte) 0x00);


                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(sendData4);

                // 서버로부터 데이터를 읽는 부분
                InputStream in = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(in);
                Make receivedData = (Make) objectInputStream.readObject();

                Log.d(TAG, "서버로부터 받은 데이터: " + receivedData);

                objectInputStream.close();

                if (receivedData instanceof Make_Get) {
                    Make_Get makeGetData = (Make_Get) receivedData;
                    return "서버에서 받은 Make_Get 객체: " +
                            "\nMainCommandType: " + makeGetData.getMainCommandType() +
                            "\nSubCommandType: " + makeGetData.getSubCommandType() +
                            "\nx: " + makeGetData.getX() +
                            "\ny: " + makeGetData.getY() +
                            "\nz: " + makeGetData.getZ() +
                            "\nrx: " + makeGetData.getRx() +
                            "\nry: " + makeGetData.getRy() +
                            "\nrz: " + makeGetData.getRz() +
                            "\nBase: " + makeGetData.getBase()+
                            "\nShoulder: " + makeGetData.getShoulder() +
                            "\nElbow: " + makeGetData.getElbow() +
                            "\nWrist1: " + makeGetData.getWrist1() +
                            "\nWrist2: " + makeGetData.getWrist2() +
                            "\nWrist3: " + makeGetData.getWrist3();
                } else if (receivedData instanceof Make_Debug) {
                    Make_Debug makeDebugData = (Make_Debug) receivedData;
                    return "서버에서 받은 Make_Debug 객체: " +
                            "\nMainCommandType: " + makeDebugData.getMainCommandType() +
                            "\nSubCommandType: " + makeDebugData.getSubCommandType() +
                            "\nName: " + makeDebugData.getName();
                } else {
                    return "서버에서 받은 데이터: " + receivedData.toString();
                }

            } catch (IOException | ClassNotFoundException e) {
                Log.e(TAG, "Error: " + e.getMessage());
                return "오류 발생: " + e.getMessage(); // 오류 메시지를 반환
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // UI 업데이트
            receivedMessageTextView.setText(result);
        }
    }
}