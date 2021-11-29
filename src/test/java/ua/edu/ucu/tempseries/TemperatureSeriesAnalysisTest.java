package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {

    private TempSummaryStatistics statistics;

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }
    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }
    @Test
    public void testDeviation() {
        double[] temperatureSeries = {1,5,4,2,-3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.7856776554368237;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 100;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {-200};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -200;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }
    @Test
    public void testMin() {
        double[] temperatureSeries = {5,7,-10,4,-2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -10;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testMax() {
        double[] temperatureSeries = {5,7,-10,4,90,-2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 90;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double[] temperatureSeries = {28};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 28;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        double[] temperatureSeries = {41};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 41;

        double actualResult = seriesAnalysis.findTempClosestToValue(20);

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(33);
    }
    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {-5,7,-10,5,-7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {-5,7,-10,5,10,-7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10;

        double actualResult = seriesAnalysis.findTempClosestToValue(9);

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        double[] temperatureSeries = {41};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult,0.0);
        double[] expResult1 = {41};
        double[] actualResult1 = seriesAnalysis.findTempsLessThen(50);
        assertArrayEquals(expResult1, actualResult1,0.0);
    }
    @Test
    public void testFindTempsGreaterThenWithOneElementArray() {
        double[] temperatureSeries = {41};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {41};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult,0.0);
        double[] expResult1 = {};
        double[] actualResult1 = seriesAnalysis.findTempsGreaterThen(50);
        assertArrayEquals(expResult1, actualResult1,0.0);
    }
    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {1,6,7,-1,3,4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1,1};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult,0.0);
        double[] expResult1 = {-1,1,3,4,6,7};
        double[] actualResult1 = seriesAnalysis.findTempsLessThen(50);
        assertArrayEquals(expResult1, actualResult1,0.0);
        double[] expResult2 = {};
        double[] actualResult2 = seriesAnalysis.findTempsLessThen(-10);
        assertArrayEquals(expResult2, actualResult2,0.0);
    }
    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {1,6,7,-1,3,4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {4,6,7};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult,0.0);
        double[] expResult1 = {};
        double[] actualResult1 = seriesAnalysis.findTempsGreaterThen(50);
        assertArrayEquals(expResult1, actualResult1,0.0);
        double[] expResult2 = {-1,1,3,4,6,7};
        double[] actualResult2 = seriesAnalysis.findTempsGreaterThen(-10);
        assertArrayEquals(expResult2, actualResult2,0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }
    @Test
    public void testSummaryStatisticsWithOneElement() {
        double[] temperatureSeries = {3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        statistics = seriesAnalysis.summaryStatistics();
        assertEquals(statistics.getAvgTemp(),3.0,0.000001);
        assertEquals(statistics.getDevTemp(),0.0,0.000001);
        assertEquals(statistics.getMaxTemp(),3.0,0.000001);
        assertEquals(statistics.getMinTemp(),3.0,0.000001);
    }
    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3,6,-2,8,-5,-1,0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        statistics = seriesAnalysis.summaryStatistics();
        assertEquals(statistics.getAvgTemp(),1.2857142857142858,0.000001);
        assertEquals(statistics.getDevTemp(),4.266624149448022,0.000001);
        assertEquals(statistics.getMaxTemp(),8.0,0.000001);
        assertEquals(statistics.getMinTemp(),-5,0.000001);
    }
    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {3,6,-2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(seriesAnalysis.getSize(),3);
        seriesAnalysis.addTemps(-5,-1,0,8);
        assertEquals(seriesAnalysis.getSize(),12);
        statistics = seriesAnalysis.summaryStatistics();
        assertEquals(statistics.getAvgTemp(),1.2857142857142858,0.000001);
        assertEquals(statistics.getDevTemp(),4.266624149448022,0.000001);
        assertEquals(statistics.getMaxTemp(),8.0,0.000001);
        assertEquals(statistics.getMinTemp(),-5,0.000001);
    }
    @Test
    public void testAddTempsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(seriesAnalysis.getSize(),0);
        seriesAnalysis.addTemps(1,2,3);
        assertEquals(seriesAnalysis.getSize(),4);
    }
}
