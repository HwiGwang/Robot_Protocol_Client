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
                Make sendData0 = new MakeType01((byte) 0x3, (byte) 0x01,0, 3.0f, 4.0f, 5.0f,
                        6.0f,0,0,0,1);

                Make sendData1 = new MakeType02((byte) 0x4, (byte) 0x02,(byte) 0x03,(byte)0x00, "Move", 3.0f, 4.0f, 5.0f,
                        6.0f,0,0,0,1,2,3,4,5,6,7,8,9,10,11,
                        12,13,14,15,16,17,18,19,20,21,(byte)0x00,(byte)0x01);
                Make sendData2 = new MakeType04((byte) 0x05, (byte) 0x01, (byte) 0x00, (byte) 0x00, 1,2,3,4,5,6,7,8,9,10,
                        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(sendData2);

                // 서버로부터 데이터를 읽는 부분
                InputStream in = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(in);
                Make receivedData = (Make) objectInputStream.readObject();
                objectInputStream.close();

                // MakeType00 또는 MakeType01등으로 형변환
                if (receivedData instanceof MakeType00) {
                    MakeType00 receivedDataOfType00 = (MakeType00) receivedData;
                    return "Received: MainCommandType=" + receivedDataOfType00.getMainCommandType() +
                            ", SubCommandType=" + receivedDataOfType00.getSubCommandType() +
                            ", X=" + receivedDataOfType00.getX() +
                            ", Y=" + receivedDataOfType00.getY() +
                            ", Z=" + receivedDataOfType00.getZ() +
                            ", RX=" + receivedDataOfType00.getRX() +
                            ", RY=" + receivedDataOfType00.getRY() +
                            ", RZ=" + receivedDataOfType00.getRZ() +
                            ", Dist=" + receivedDataOfType00.getDist() +
                            ", Ori=" + receivedDataOfType00.getOri() +
                            ", Joint=" + receivedDataOfType00.getJoint();
                } else if (receivedData instanceof MakeType01) {
                    MakeType01 receivedDataOfType01 = (MakeType01) receivedData;
                    return "Received: MainCommandType=" + receivedDataOfType01.getMainCommandType() +
                            ", SubCommandType=" + receivedDataOfType01.getSubCommandType() +
                            ", Base=" + receivedDataOfType01.getBase() +
                            ", Shoulder=" + receivedDataOfType01.getShoulder() +
                            ", Elbow=" + receivedDataOfType01.getElbow() +
                            ", Wrist1=" + receivedDataOfType01.getWrist1() +
                            ", Wrist2=" + receivedDataOfType01.getWrist2() +
                            ", Wrist3=" + receivedDataOfType01.getWrist3() +
                            ", Dist=" + receivedDataOfType01.getDist() +
                            ", Ori=" + receivedDataOfType01.getOri() +
                            ", Joint=" + receivedDataOfType01.getJoint();
                }else if (receivedData instanceof MakeType02) {
                    MakeType02 receivedDataOfType02 = (MakeType02) receivedData;
                    // MakeType02에 대한 처리를 여기에 추가
                    return "Received: MainCommandType=" + receivedDataOfType02.getMainCommandType() +
                            ", SubCommandType=" + receivedDataOfType02.getSubCommandType() +
                            ", Type =" + receivedDataOfType02.getType() +
                            ", MoveType=" + receivedDataOfType02.getMoveType() +
                            ", Name=" + receivedDataOfType02.getName() +
                            ", Speed=" + receivedDataOfType02.getSpeed() +
                            ", Acc=" + receivedDataOfType02.getAcc() +
                            ", FinishAt=" + receivedDataOfType02.getFinishAt() +
                            ", StoppingTime=" + receivedDataOfType02.getStoppingTime() +
                            ", X=" + receivedDataOfType02.getX() +
                            ", Y=" + receivedDataOfType02.getY() +
                            ", Z=" + receivedDataOfType02.getZ() +
                            ", RX=" + receivedDataOfType02.getRX() +
                            ", RY=" + receivedDataOfType02.getRY() +
                            ", RZ=" + receivedDataOfType02.getRZ() +
                            ", Base=" + receivedDataOfType02.getBase() +
                            ", Shoulder=" + receivedDataOfType02.getShoulder() +
                            ", Elbow=" + receivedDataOfType02.getElbow() +
                            ", Wrist1=" + receivedDataOfType02.getWrist1() +
                            ", Wrist2=" + receivedDataOfType02.getWrist2() +
                            ", Wrist3=" + receivedDataOfType02.getWrist3() +
                            ", J0=" + receivedDataOfType02.getJ0() +
                            ", J1=" + receivedDataOfType02.getJ1() +
                            ", J2=" + receivedDataOfType02.getJ2() +
                            ", J3=" + receivedDataOfType02.getJ3() +
                            ", J4=" + receivedDataOfType02.getJ4() +
                            ", J5=" + receivedDataOfType02.getJ5() +
                            ", JJ0=" + receivedDataOfType02.getJJ0() +
                            ", JJ1=" + receivedDataOfType02.getJJ1() +
                            ", JJ2=" + receivedDataOfType02.getJJ2() +
                            ", JJ3=" + receivedDataOfType02.getJJ3() +
                            ", JJ4=" + receivedDataOfType02.getJJ4() +
                            ", JJ5=" + receivedDataOfType02.getJJ5() +
                            ", Reference_Point=" + receivedDataOfType02.getReference_Point() +
                            ", Reference_Coordiante=" + receivedDataOfType02.getReference_Coordinate();
                }

                else {
                    // Handle other types if needed
                    return "Received: Unknown Make type";
                }

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