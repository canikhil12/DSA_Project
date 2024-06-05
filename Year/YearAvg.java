package com.weather.stats;

// Task 5


public class YearAvg implements Comparable<YearAvg> {
    private double temp;
    private int year;
    private double rain;

    public double getTemp() {
        return temp;
    }

    public void setTemp(final double temp) {
        this.temp = temp;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(final double rain) {
        this.rain = rain;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public YearAvg(double temp, int year, double rain) {
        this.temp = temp;
        this.year = year;
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "YearAvg [rain=" + String.format("%3.2f", rain) + ", temp=" + String.format("%3.2f", temp) + ", year="
                + year + "]";
    }
    // Task1
    public String toCSV() {
        return this.getTemp() + "," + this.getYear()+ "," + this.getRain();
    }

    
    

   @Override
    public int compareTo(YearAvg o) {
        Double d1 = Double.valueOf(this.rain);
        return (d1).compareTo(Double.valueOf(o.rain));
    }

}