package ru.javastudy.springMVC.model.auxiliary;

/**
 * Created by User on 04.11.2016.
 */
public class CounterNumerals {
    public static int counterNumerals(double number)
    {
        int count=1;
        int numerals=(int)number/10;
        while(numerals!=0)
        {
            numerals/=10;
            count++;
        }
        return count;
    }
}
