package com.example.client3;

import java.io.Serializable;

public abstract class Make implements Serializable {
    private static final long serialVersionUID = 1L;
    private byte mainCommandType;

    public Make(byte mainCommandType) {
        this.mainCommandType = mainCommandType;
    }

    public byte getMainCommandType() {
        return mainCommandType;
    }

    // Abstract method for getting output based on MainCommandType
    public abstract byte getSubCommandType();
}

class Make_Jog extends Make { //MakeType00은 maincommandtype이 0x00~0x02까지
    private byte subCommandType;
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float dist;
    private float ori;
    private float joint;

    public Make_Jog(byte mainCommandType, byte subCommandType, float x, float y, float z, float rx, float ry, float rz,float dist, float ori, float joint) {
        super(mainCommandType);
        this.subCommandType = subCommandType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.dist = dist;
        this.ori = ori;
        this.joint = joint;


    }

    public byte getSubCommandType() {
        return subCommandType;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getRX() {
        return rx;
    }

    public float getRY() {
        return ry;
    }

    public float getRZ() {
        return rz;
    }

    public float getDist() {
        return dist;
    }

    public float getOri() {
        return ori;
    }

    public float getJoint() {
        return joint;
    }
}


class Make_User extends Make { //maincommandtype이 0x03(User)일때
    private byte subCommandType;
    private float base;
    private float shoulder;
    private float elbow;
    private float wrist1;
    private float wrist2;
    private float wrist3;
    private float dist;
    private float ori;
    private float joint;

    public Make_User(byte mainCommandType, byte subCommandType, float base, float shoulder, float elbow, float wrist1, float wrist2, float wrist3, float dist, float ori, float joint) {
        super(mainCommandType);
        this.subCommandType = subCommandType;
        this.base = base;
        this.shoulder = shoulder;
        this.elbow = elbow;
        this.wrist1 = wrist1;
        this.wrist2 = wrist2;
        this.wrist3 = wrist3;
        this.dist = dist;
        this.ori = ori;
        this.joint = joint;
    }

    public byte getSubCommandType() {
        return subCommandType;
    }

    public float getBase() {
        return base;
    }

    public float getShoulder() {
        return shoulder;
    }

    public float getElbow() {
        return elbow;
    }

    public float getWrist1() {
        return wrist1;
    }

    public float getWrist2() {
        return wrist2;
    }

    public float getWrist3() {
        return wrist3;
    }

    public float getDist() {
        return dist;
    }

    public float getOri() {
        return ori;
    }

    public float getJoint() {
        return joint;
    }
}



class Make_Move extends Make { //maincommand type이 0x04(Move)
    private byte subCommandType;
    private byte type;
    private byte moveType;
    private String name;
    private float speed;
    private float acc;
    private float finish_at;
    private float stopping_time;
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float base;
    private float shoulder;
    private float elbow;
    private float wrist1;
    private float wrist2;
    private float wrist3;
    private float j0;
    private float j1;
    private float j2;
    private float j3;
    private float j4;
    private float j5;
    private float jj0;
    private float jj1;
    private float jj2;
    private float jj3;
    private float jj4;
    private float jj5;
    private byte reference_Point;
    private byte reference_Coordinate;

    public Make_Move(byte mainCommandType, byte subCommandType, byte type, byte moveType, String name, float speed, float acc, float finish_at, float stopping_time, float x,
                     float y, float z, float rx, float ry, float rz, float base, float shoulder, float elbow, float wrist1, float wrist2, float wrist3,float j0,
                     float j1, float j2, float j3, float j4, float j5, float jj0,float jj1,float jj2,float jj3,float jj4,float jj5, byte reference_Point, byte reference_Coordinate) {
        super(mainCommandType);
        this.subCommandType = subCommandType;
        this.type = type;
        this.moveType = moveType;
        this.name = name;
        this.speed = speed;
        this.acc = acc;
        this.finish_at = finish_at;
        this.stopping_time = stopping_time;
        if (subCommandType ==0x00) //MoveJ
        {
            if(type == 0x00) { //Absoulte(MoveJ)
                this.x = x;
                this.y = y;
                this.z = z;
                this.rx = rx;
                this.ry = ry;
                this.rz = rz;
                this.base = base;
                this.shoulder = shoulder;
                this.elbow = elbow;
                this.wrist1 = wrist1;
                this.wrist2 = wrist2;
                this.wrist3 = wrist3;
            }
            if(type == 0x01) //Relative(MoveJ)
            {
                this.j0=j0;
                this.j1 = j1;
                this.j2 = j2;
                this.j3 = j3;
                this.j4 = j4;
                this.j5 = j5;
            }
            if(type ==0x03) { //Variable(MoveJ)
                this.jj0=jj0;
                this.jj1=jj1;
                this.jj2=jj2;
                this.jj3=jj3;
                this.jj4=jj4;
                this.jj5=jj5;
            }

        }
        if (subCommandType ==0x02)
        {
            if(type==0x03) { // Absolute(MoveL)
                this.x = x;
                this.y = y;
                this.z = z;
                this.rx = rx;
                this.ry = ry;
                this.rz = rz;
                this.base = base;
                this.shoulder = shoulder;
                this.elbow = elbow;
                this.wrist1 = wrist1;
                this.wrist2 = wrist2;
                this.wrist3 = wrist3;
            }

            if(type==0x04) { //Relative(MoveL)
                this.j0 = j0;
                this.j1 = j1;
                this.j2 = j2;
                this.j3 = j3;
                this.j4 = j4;
                this.j5 = j5;
            }

            if(type==0x05) { //Variable(MoveL)
                this.jj0=jj0;
                this.jj1=jj1;
                this.jj2=jj2;
                this.jj3=jj3;
                this.jj4=jj4;
                this.jj5=jj5;
                this.reference_Point=reference_Point;
                this.reference_Coordinate=reference_Coordinate;
            }

            if(type==0x06) { //UserCoordinate(MoveL)
                this.x = x;
                this.y = y;
                this.z = z;
                this.rx = rx;
                this.ry = ry;
                this.rz = rz;
                this.reference_Coordinate = reference_Coordinate;
            }
        }



    }


    public byte getSubCommandType() {
        return subCommandType;
    }

    public byte getType() {
        return type;
    }

    public byte getMoveType() {
        return moveType;
    }

    public String getName() {
        return name;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAcc() {
        return acc;
    }

    public float getFinishAt() {
        return finish_at;
    }

    public float getStoppingTime() {
        return stopping_time;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getRX() {
        return rx;
    }

    public float getRY() {
        return ry;
    }

    public float getRZ() {
        return rz;
    }

    public float getBase() {
        return base;
    }

    public float getShoulder() {
        return shoulder;
    }

    public float getElbow() {
        return elbow;
    }

    public float getWrist1() {
        return wrist1;
    }

    public float getWrist2() {
        return wrist2;
    }

    public float getWrist3() {
        return wrist3;
    }
    public float getJ0() {
        return j0;
    }
    public float getJ1() {
        return j1;
    }
    public float getJ2() {
        return j2;
    }
    public float getJ3() {
        return j3;
    }
    public float getJ4() {
        return j4;
    }
    public float getJ5() {
        return j5;
    }
    public float getJJ0() {
        return jj0;
    }
    public float getJJ1() {
        return jj1;
    }
    public float getJJ2() {
        return jj2;
    }
    public float getJJ3() {
        return jj3;
    }
    public float getJJ4() {
        return jj4;
    }
    public float getJJ5() {
        return jj5;
    }
    public float getReference_Point() {
        return reference_Point;
    }
    public float getReference_Coordinate() {
        return reference_Coordinate;
    }
}
class Make_Circle extends Make { // maincommand type이 0x06(Circle)
    private byte subCommandType;
    private byte ori_Type;
    private byte type;
    private float speed;
    private float acc;
    private float finish_at;
    private float stopping_time;
    private float x1;
    private float y1;
    private float z1;
    private float rx1;
    private float ry1;
    private float rz1;
    private float base1;
    private float shoulder1;
    private float elbow1;
    private float wrist1_1;
    private float wrist2_1;
    private float wrist3_1;
    private float x2;
    private float y2;
    private float z2;
    private float rx2;
    private float ry2;
    private float rz2;
    private float base2;
    private float shoulder2;
    private float elbow2;
    private float wrist1_2;
    private float wrist2_2;
    private float wrist3_2;
    private float degree;

    public Make_Circle(byte mainCommandType, byte subCommandType, byte ori_Type, byte type, float speed, float acc, float finish_at, float stopping_time, float x1,
                       float y1, float z1, float rx1, float ry1, float rz1, float base1, float shoulder1, float elbow1, float wrist1_1, float wrist2_1, float wrist3_1,
                       float x2, float y2, float z2, float rx2, float ry2, float rz2, float base2, float shoulder2, float elbow2, float wrist1_2, float wrist2_2, float wrist3_2, float degree) {
        super(mainCommandType);
        this.subCommandType = subCommandType;
        this.ori_Type = ori_Type;
        this.type = type;
        this.speed = speed;
        this.acc = acc;
        this.finish_at = finish_at;
        this.stopping_time = stopping_time;
        if (subCommandType == 0x00) { // 3point
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.rx1 = rx1;
            this.ry1 = ry1;
            this.rz1 = rz1;
            this.base1 = base1;
            this.shoulder1 = shoulder1;
            this.elbow1 = elbow1;
            this.wrist1_1 = wrist1_1;
            this.wrist2_1 = wrist2_1;
            this.wrist3_1 = wrist3_1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
            this.rx2 = rx2;
            this.ry2 = ry2;
            this.rz2 = rz2;
            this.base2 = base2;
            this.shoulder2 = shoulder2;
            this.elbow2 = elbow2;
            this.wrist1_2 = wrist1_2;
            this.wrist2_2 = wrist2_2;
            this.wrist3_2 = wrist3_2;
        }
        if (subCommandType == 0x01) { // Axis/Center
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
            this.degree = degree;
        }
    }

    public byte getSubCommandType() {
        return subCommandType;
    }

    public byte getOri_Type() {
        return ori_Type;
    }

    public byte getType() {
        return type;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAcc() {
        return acc;
    }

    public float getFinishAt() {
        return finish_at;
    }

    public float getStoppingTime() {
        return stopping_time;
    }


    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getZ1() {
        return z1;
    }

    public float getRX1() {
        return rx1;
    }

    public float getRY1() {
        return ry1;
    }

    public float getRZ1() {
        return rz1;
    }

    public float getBase1() {
        return base1;
    }

    public float getShoulder1() {
        return shoulder1;
    }

    public float getElbow1() {
        return elbow1;
    }

    public float getWrist1_1() {
        return wrist1_1;
    }

    public float getWrist2_1() {
        return wrist2_1;
    }
    public float getWrist3_1() {
        return wrist3_1;
    }
    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    public float getZ2() {
        return z2;
    }

    public float getRX2() {
        return rx2;
    }

    public float getRY2() {
        return ry2;
    }

    public float getRZ2() {
        return rz2;
    }

    public float getBase2() {
        return base2;
    }

    public float getShoulder2() {
        return shoulder2;
    }

    public float getElbow2() {
        return elbow2;
    }

    public float getWrist1_2() {
        return wrist1_2;
    }

    public float getWrist2_2() {
        return wrist2_2;
    }
    public float getWrist3_2() {
        return wrist3_2;
    }
    public float getDegree() {
        return degree;
    }


}
class Make_Get extends Make { //maincommandtype이 0x03(User)일때
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float base;
    private float shoulder;
    private float elbow;
    private float wrist1;
    private float wrist2;
    private float wrist3;


    public Make_Get(byte mainCommandType, float x, float y, float z, float rx, float ry, float rz, float base, float shoulder, float elbow, float wrist1, float wrist2, float wrist3) {
        super(mainCommandType);
        this.x=x;
        this.y=y;
        this.z=z;
        this.rx=rx;
        this.ry=ry;
        this.rz=rz;
        this.base = base;
        this.shoulder = shoulder;
        this.elbow = elbow;
        this.wrist1 = wrist1;
        this.wrist2 = wrist2;
        this.wrist3 = wrist3;


    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getZ() {
        return z;
    }
    public float getRx() {
        return rx;
    }
    public float getRy() {
        return ry;
    }
    public float getRz() {
        return rz;
    }

    public float getBase() {
        return base;
    }

    public float getShoulder() {
        return shoulder;
    }

    public float getElbow() {
        return elbow;
    }

    public float getWrist1() {
        return wrist1;
    }

    public float getWrist2() {
        return wrist2;
    }

    public float getWrist3() {
        return wrist3;
    }


    @Override
    public byte getSubCommandType() {
        return 0;
    }
}

class Make_Debug extends Make {
    private byte subCommandType;
    private String name;

    public Make_Debug(byte mainCommandType, byte subCommandType, String name) {
        super(mainCommandType);
        if (subCommandType == 0x00) { // From Control Box
            this.name = name;}
        if(subCommandType == 0x01) {
            this.name = name;
        }

    }

    public byte getSubCommandType() {
        return subCommandType;
    }

    public String getName() {
        return name;
    }

}

class Make_Set extends Make {
    private byte subCommandType;
    private float threshold;
    private float mass;
    private float mass_x;
    private float mass_y;
    private float mass_z;
    private float base_x;
    private float base_y;
    private float base_z;
    private float base_rx;
    private float base_ry;
    private float base_rz;
    private byte inbox_Box;
    private byte inbox_Mode;
    private float tcp_x;
    private float tcp_y;
    private float tcp_z;
    private float tcp_rx;
    private float tcp_ry;
    private float tcp_rz;
    private float box_x_width;
    private float box_y_width;
    private float box_z_width;
    private float box_x;
    private float box_y;
    private float box_z;
    private float workspace_x_width;
    private float workspace_y_width;
    private float workspace_z_width;
    private float workspace_x;
    private float workspace_y;
    private float workspace_z;
    private byte enable_Workspace;

    public Make_Set(byte mainCommandType, byte subCommandType, float threshold, float mass, float mass_x, float mass_y, float mass_z,
                    float base_x, float base_y, float base_z, float base_rx, float base_ry, float base_rz, byte inbox_Box, byte inbox_Mode,
                    float tcp_x, float tcp_y, float tcp_z, float tcp_rx, float tcp_ry, float tcp_rz, float box_x_width, float box_y_width,
                    float box_z_width, float box_x, float box_y, float box_z, float workspace_x_width, float workspace_y_width, float workspace_z_width,
                    float workspace_x, float workspace_y, float workspace_z, byte enable_Workspace) {
        super(mainCommandType);
        this.subCommandType = subCommandType;

        if (subCommandType == 0x00) { // 충돌감지감도조절
            this.threshold = threshold;
        }
        if (subCommandType == 0x01) { // TCP하중
            this.mass = mass;
            this.mass_x = mass_x;
            this.mass_y = mass_y;
            this.mass_z = mass_z;
        }
        if (subCommandType == 0x02) { // 동작오프셋
            this.base_x = base_x;
            this.base_y = base_y;
            this.base_z = base_z;
            this.base_rx = base_rx;
            this.base_ry = base_ry;
            this.base_rz = base_rz;
        }
        if (subCommandType == 0x03) { // 인박스
            this.inbox_Box = inbox_Box;
            this.inbox_Mode = inbox_Mode;
        }
        if (subCommandType == 0x04) { // TCP 좌표 임시 설정
            this.tcp_x = tcp_x;
            this.tcp_y = tcp_y;
            this.tcp_z = tcp_z;
            this.tcp_rx = tcp_rx;
            this.tcp_ry = tcp_ry;
            this.tcp_rz = tcp_rz;
        }
        if (subCommandType == 0x05) { // 툴 안전영역 설정
            this.box_x_width = box_x_width;
            this.box_y_width = box_y_width;
            this.box_z_width = box_z_width;
            this.box_x = box_x;
            this.box_y = box_y;
            this.box_z = box_z;
        }
        if (subCommandType == 0x06) { //작업안전영역설정
            this.workspace_x_width = workspace_x_width;
            this.workspace_y_width = workspace_y_width;
            this.workspace_z_width = workspace_z_width;
            this.workspace_x = workspace_x;
            this.workspace_y = workspace_y;
            this.workspace_z = workspace_z;
            this.enable_Workspace = enable_Workspace;
        }
    }

    public byte getSubCommandType() {
        return subCommandType;
    }

    public float getThreshold() {
        return threshold;
    }

    public float getMass() {
        return mass;
    }

    public float getMassX() {
        return mass_x;
    }

    public float getMassY() {
        return mass_y;
    }

    public float getMassZ() {
        return mass_z;
    }

    public float getBaseX() {
        return base_x;
    }

    public float getBaseY() {
        return base_y;
    }

    public float getBaseZ() {
        return base_z;
    }

    public float getBaseRX() {
        return base_rx;
    }

    public float getBaseRY() {
        return base_ry;
    }

    public float getBaseRZ() {
        return base_rz;
    }

    public byte getInboxBox() {
        return inbox_Box;
    }

    public byte getInboxMode() {
        return inbox_Mode;
    }

    public float getTCPX() {
        return tcp_x;
    }

    public float getTCPY() {
        return tcp_y;
    }

    public float getTCPZ() {
        return tcp_z;
    }

    public float getTCPRX() {
        return tcp_rx;
    }

    public float getTCPRY() {
        return tcp_ry;
    }

    public float getTCPRZ() {
        return tcp_rz;
    }

    public float getBoxXWidth() {
        return box_x_width;
    }

    public float getBoxYWidth() {
        return box_y_width;
    }

    public float getBoxZWidth() {
        return box_z_width;
    }

    public float getBoxX() {
        return box_x;
    }

    public float getBoxY() {
        return box_y;
    }

    public float getBoxZ() {
        return box_z;
    }

    public float getWorkspaceXWidth() {
        return workspace_x_width;
    }

    public float getWorkspaceYWidth() {
        return workspace_y_width;
    }

    public float getWorkspaceZWidth() {
        return workspace_z_width;
    }

    public float getWorkspaceX() {
        return workspace_x;
    }

    public float getWorkspaceY() {
        return workspace_y;
    }

    public float getWorkspaceZ() {
        return workspace_z;
    }

    public byte getEnableWorkspace() {
        return enable_Workspace;
    }
}



