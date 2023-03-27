package org.example;

public class CurrencyPairCourse {
    private CurrencyPairCourse(){};
    private int currencyCodeA;
    private int currencyCodeB;
    private long date;
    private double rateSell;
    private double rateBuy;
    private double rateCross;

    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public long getDate() {
        return date;
    }

    public double getRateSell() {
        return rateSell;
    }

    public double getRateBuy() {
        return rateBuy;
    }

    public double getRateCross() {
        return rateCross;
    }

    @Override
    public String toString() {
        return "CurrencyPairCourse{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date=" + date +
                ", rateSell=" + rateSell +
                ", rateBuy=" + rateBuy +
                ", rateCross=" + rateCross +
                '}';
    }
}

