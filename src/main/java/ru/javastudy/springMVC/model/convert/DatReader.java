package ru.javastudy.springMVC.model.convert;

import ru.javastudy.springMVC.model.statistics.ProfileStatistics;

import java.io.*;

/**
 * Created by User on 08.10.2016.
 */
public class DatReader {
    private static String readLine(BufferedReader in) throws IOException
    {
        String s = in.readLine();
        s = s.trim();
        while (s.indexOf("  ")>0)s = s.replaceAll("  "," ");
        return s;
    }

    public static ProfileStatistics readData(String fileName,InputStream stream) throws IOException
    {
        try
        {
            double surfaceRadius = 0;               //радиус фотоприемника LFP
            double emitterYOffset = 0;              //смещение осветителя
            double initialEmitterHeightPosition = 0;//Zmin осветителя
            double emitterHeightStep = 0;           //шаг осветителя
            double minReflectedLightCoord = 0;
            double maxReflectedLightCoord = 0;
            int discretePoints = 0;                 //количество точек на сечение
            int radialProfilesNumber = 0;           //количество сечений
            double[] xOffset;                       //кси
            double[] yOffset;                       //тета
            int i=0;

            BufferedReader in = new BufferedReader(new InputStreamReader(stream));

            String s=readLine(in);
            surfaceRadius = Double.parseDouble(s.substring(0, s.indexOf(" ")));
            emitterYOffset = Double.parseDouble(s.substring(s.indexOf(" ")+1));

            s=readLine(in);
            initialEmitterHeightPosition = Double.parseDouble(s.substring(0, s.indexOf(" ")));
            emitterHeightStep = Double.parseDouble(s.substring(s.indexOf(" ")+1));

            s=readLine(in);
            minReflectedLightCoord = Double.parseDouble(s.substring(0, s.indexOf(" ")));
            maxReflectedLightCoord = Double.parseDouble(s.substring(s.indexOf(" ")+1, s.lastIndexOf(" ")));

            s=readLine(in);
            discretePoints = Integer.parseInt(s.substring(0, s.indexOf(" ")));
            radialProfilesNumber = Integer.parseInt(s.substring(s.indexOf(" ")+1));

            xOffset=new double[discretePoints*radialProfilesNumber];
            yOffset=new double[discretePoints*radialProfilesNumber];
            while (in.ready())
            {
                s=readLine(in);
                xOffset[i]=Double.parseDouble(s.substring(s.indexOf(" ")+1, s.lastIndexOf(" ")));
                yOffset[i++]=Double.parseDouble(s.substring(s.lastIndexOf(" ")+1));
            }

            ProfileStatistics rs = new ProfileStatistics(surfaceRadius, emitterYOffset, initialEmitterHeightPosition, emitterHeightStep, minReflectedLightCoord, maxReflectedLightCoord, discretePoints, radialProfilesNumber, xOffset, yOffset);
           in.close();
            return rs;
        }
        catch (IOException ex)
        {
            throw new IOException(ex.toString()+"Файл: "+fileName);
        }
    }
}
