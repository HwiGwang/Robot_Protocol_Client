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

class MakeType00 extends Make { //MakeType00은 maincommandtype이 0x00~0x02까지
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

    public MakeType00(byte mainCommandType, byte subCommandType, float x, float y, float z, float rx, float ry, float rz,float dist, float ori, float joint) {
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


class MakeType01 extends Make { //maincommandtype이 0x03(User)일때
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

    public MakeType01(byte mainCommandType, byte subCommandType, float base, float shoulder, float elbow, float wrist1, float wrist2, float wrist3, float dist, float ori, float joint) {
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

class MakeType02 extends Make { //maincommand type이 0x04(Move)
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

    public MakeType02(byte mainCommandType, byte subCommandType, byte type, byte moveType, String name, float speed, float acc, float finish_at, float stopping_time, float x,
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
class MakeType04 extends Make { // maincommand type이 0x06(Circle)
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

    public MakeType04(byte mainCommandType, byte subCommandType, byte ori_Type, byte type, float speed, float acc, float finish_at, float stopping_time, float x1,
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






