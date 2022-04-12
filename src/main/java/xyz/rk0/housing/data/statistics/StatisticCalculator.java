package xyz.rk0.housing.data.statistics;

import com.newrelic.api.agent.Trace;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StatisticCalculator {

    @Trace
    public double calculateStatistic(List<Double> values, String statistic) {

        return switch (statistic) {
            case "min" -> Collections.min(values);
            case "max" -> Collections.max(values);
            case "average" -> values.stream()
                .mapToDouble(record -> record)
                .average()
                .orElse(0);
            case "sum" -> values.stream()
                .mapToDouble(record -> record)
                .sum();
            case "range" -> Collections.max(values) - Collections.min(values);
            default -> throw new IllegalArgumentException("Did not know how to calculate " + statistic);
        };
    }
}
