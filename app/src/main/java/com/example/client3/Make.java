package com.example.client3;

import java.io.Serializable;

public class Make implements Serializable {
    private byte mainCommandType;
    private byte subCommandType;
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float Dist;
    private float Ori;
    private float Joint;
    private float Base;
    private float Shoulder;
    private float Elbow;
    private float Wrist1;
    private float Wrist2;
    private float Wrist3;

    public Make(byte mainCommandType, byte subCommandType, float x, float y, float z, float rx, float ry, float rz) {
        this.mainCommandType = mainCommandType;
        this.subCommandType = subCommandType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
    }

    public Make(byte mainCommandType, byte subCommandType, float Base, float Shoulder, float Elbow, float Wrist1, float Wrist2, float Wrist3) {
        this.mainCommandType = mainCommandType;
        this.subCommandType = subCommandType;
        this.Base = Base;
        this.Shoulder = Shoulder;
        this.Elbow = Elbow;
        this.Wrist1 = Wrist1;
        this.Wrist2 = Wrist2;
        this.Wrist3 = Wrist3;
    }

    public Make(byte mainCommandType, byte subCommandType, float Dist, float Ori, float Joint) {
        this.mainCommandType = mainCommandType;
        this.subCommandType = subCommandType;
        this.Dist = Dist;
        this.Ori = Ori;
        this.Joint = Joint;
    }

    @Override
    public String toString() {
        if (mainCommandType == 1) {
            return "Main Command Type is 1: " +
                    "Sub Command Type=" + subCommandType +
                    ", X=" + x +
                    ", Y=" + y +
                    ", Z=" + z +
                    ", RX=" + rx +
                    ", RY=" + ry +
                    ", RZ=" + rz;
        } else if (mainCommandType == 2) {
            return "Main Command Type is 2: " +
                    "Base=" + Base +
                    ", Shoulder=" + Shoulder +
                    ", Elbow=" + Elbow +
                    ", Wrist1=" + Wrist1 +
                    ", Wrist2=" + Wrist2 +
                    ", Wrist3=" + Wrist3;
        } else if (mainCommandType == 3) {
            return "Main Command Type is 3: " +
                    "Dist=" + Dist +
                    ", Ori=" + Ori +
                    ", Joint=" + Joint;
        } else {
            return "Main Command Type is unknown: " +
                    "Sub Command Type=" + subCommandType;
        }
    }

}