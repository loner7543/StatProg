package ru.javastudy.springMVC.model.data;

/**
 * Created by User on 08.10.2016.
 */
public class Data {
    private double amp;
    private double[] H;

    public Data(double[] H)
    {
        this.H=H;
        this.amp=amp();

    }

    public double amp()
    {
        double max=Double.NEGATIVE_INFINITY;
        double min=Double.POSITIVE_INFINITY;
        for(int i=0;i<H.length;i++)
        {
            if(H[i]<min)min=H[i];
            if(H[i]>max)max=H[i];
        }
        return (max-min);
    }

    public double[] getH()
    {
        return H;
    }

    public double getAmp()
    {
        return amp;
    }

}
