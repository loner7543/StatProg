package ru.javastudy.springMVC.model.statistics;

/**
 * Created by User on 08.10.2016.
 */
public class StatisticsData {
    private double Point;
    private double Sko;
    private double Psyst;
    private double Psum;
    private double DovInt;

    public StatisticsData(double point, double sko, double psyst, double psum,double dovInt) {
        Point = point;
        Sko = sko;
        Psyst = psyst;
        Psum = psum;
        DovInt = dovInt;
    }

    public double getPoint() {
        return Point;
    }

    public double getSko() {
        return Sko;
    }

    public double getPsum() {
        return Psum;
    }

    public double getDovInt() {
        return DovInt;
    }

    public double getPsyst() {
        return Psyst;
    }
}
