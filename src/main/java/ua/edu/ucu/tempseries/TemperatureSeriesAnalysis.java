package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;
public class TemperatureSeriesAnalysis {
    private static final int MINPOSSIBLE = -273;
    private double[] temperatureSeries;
    private int temperatureAmount;
    private int size;
    public TemperatureSeriesAnalysis() {
         this.temperatureSeries = new double[0];
         this.temperatureAmount = temperatureSeries.length;
         this.size = 0;

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        if (check()){
            this.temperatureAmount = temperatureSeries.length;
            this.size = temperatureSeries.length;
        }
        else {
            this.temperatureSeries = new double[0];
            this.temperatureAmount = temperatureSeries.length;
            this.size=0;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean check() {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < MINPOSSIBLE) {
                throw new InputMismatchException();
            }
        }
        return true;
    }
    public double sum() {
        double temperatureSum = 0;
        for (int i = 0; i < temperatureAmount; i++) {
            temperatureSum+= temperatureSeries[i];
        }
        return temperatureSum;
    }
    public double average() {
        if (temperatureAmount == 0) {
            throw new IllegalArgumentException();
        }
        return sum() / temperatureAmount;
    }

    public double deviation() {
        if (temperatureAmount == 0) {
            throw new IllegalArgumentException();
        }
        double mean = average();
        double summa = 0;
        for (int i = 0; i < temperatureAmount; i++) {
            summa+= Math.pow(temperatureSeries[i] - mean, 2);
        }
        double variance = summa / (temperatureAmount);
        return Math.sqrt(variance);
    }

    public double min() {
        if (temperatureAmount==0) {
            throw new IllegalArgumentException();
        }
        double minTemperature = temperatureSeries[0];
        for (int i = 1; i < temperatureAmount; i++){
            if (temperatureSeries[i] < minTemperature){
                minTemperature = temperatureSeries[i];
            }
        }
        return minTemperature;
    }

    public double max() {
        if (temperatureAmount == 0) {
            throw new IllegalArgumentException();
        }
        double maxTemperature = temperatureSeries[0];
        for (int i=1; i < temperatureAmount; i++) {
            if (temperatureSeries[i] > maxTemperature) {
                maxTemperature = temperatureSeries[i];
            }
        }
        return maxTemperature;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureAmount == 0) {
            throw new IllegalArgumentException();
        }
        double closestTemperature = temperatureSeries[0];
        double closestDifference = Math.abs(tempValue - closestTemperature);
        for (int i = 1; i < temperatureAmount; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < closestDifference) {
                closestDifference = Math.abs(temperatureSeries[i] - tempValue);
                closestTemperature = temperatureSeries[i];

            }
            else if (Math.abs(temperatureSeries[i] - tempValue) == closestDifference
                     && closestTemperature < temperatureSeries[i]) {
                closestTemperature = temperatureSeries[i];
            }
        }
        return closestTemperature;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] sortedTemperatures = Arrays.copyOf(temperatureSeries,
                                                    temperatureAmount);
        Arrays.sort(sortedTemperatures);
        int range = 0;
        int index = 0;
        while (index < temperatureAmount &&
                sortedTemperatures[index] < tempValue) {
            range++;
            index++;
        }
        return Arrays.copyOfRange(sortedTemperatures ,0, range);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] sortedTemperatures = Arrays.copyOf(temperatureSeries,
                                                    temperatureAmount);
        Arrays.sort(sortedTemperatures);
        int range = 0;
        int index = temperatureAmount - 1;
        while (index >= 0 && sortedTemperatures[index] > tempValue) {
            range++;
            index--;
        }
        if (range == 0){
            return new double[]{};
        }
        else if(range == temperatureAmount) {
            return sortedTemperatures;
        }
       return Arrays.copyOfRange(sortedTemperatures, range, temperatureAmount);
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatureAmount == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public double addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < MINPOSSIBLE) {
                throw new InputMismatchException();
            }
            if (temperatureAmount == size) {
                if (size == 0) {
                    size = 1;
                }
                else {
                    size = size * 2;
                }
                double[] newTempSeries = new double[size];
                System.arraycopy(temperatureSeries, 0, newTempSeries,
                          0, temperatureAmount);
                temperatureSeries = newTempSeries;
            }
            temperatureAmount+= 1;
            temperatureSeries[temperatureAmount-1] = temp;
            }

        return sum();
    }
}
