package xyz.rk0.housing.data.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.rk0.housing.data.statistics.StatisticCalculator;

import java.util.List;

public class StatisticsTest {

    @Test
    public void testAverage() {
        StatisticCalculator calculator = new StatisticCalculator();
        double average = calculator.calculateStatistic(List.of(1.0, 2.0, 3.0, 4.0), "average");
        Assertions.assertEquals(2.5, average);
    }

    @Test
    public void testSum() {
        StatisticCalculator calculator = new StatisticCalculator();
        double average = calculator.calculateStatistic(List.of(10.0, 11.0, 12.0, 13.0), "sum");
        Assertions.assertEquals(46, average);
    }

}
