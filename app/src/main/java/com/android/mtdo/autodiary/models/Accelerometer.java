package com.android.mtdo.autodiary.models;

/**
 * Created by thangdo on 26/12/2015.
 */
public class Accelerometer {
    // accelerometer data
    private double 	acceX			;
    private double 	acceY			;
    private double 	acceZ			;
    private long 	sensorTimeStamp	;
    private long 	cpuTimeStamp	;

    public double getAcceX() {
        return acceX;
    }

    @Override
    public String toString() {
        return "Accelerometer{" +
                "acceX=" + acceX +
                ", acceY=" + acceY +
                ", acceZ=" + acceZ +
                ", sensorTimeStamp=" + sensorTimeStamp +
                ", cpuTimeStamp=" + cpuTimeStamp +
                '}';
    }

    public void setAcceX(double acceX) {
        this.acceX = acceX;
    }

    public double getAcceY() {
        return acceY;
    }

    public void setAcceY(double acceY) {
        this.acceY = acceY;
    }

    public double getAcceZ() {
        return acceZ;
    }

    public void setAcceZ(double acceZ) {
        this.acceZ = acceZ;
    }

    public long getSensorTimeStamp() {
        return sensorTimeStamp;
    }

    public void setSensorTimeStamp(long sensorTimeStamp) {
        this.sensorTimeStamp = sensorTimeStamp;
    }

    public long getCpuTimeStamp() {
        return cpuTimeStamp;
    }

    public void setCpuTimeStamp(long cpuTimeStamp) {
        this.cpuTimeStamp = cpuTimeStamp;
    }
}
