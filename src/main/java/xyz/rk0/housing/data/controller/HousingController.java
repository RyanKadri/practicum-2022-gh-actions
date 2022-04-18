package xyz.rk0.housing.data.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.rk0.housing.data.loader.DataLoader;
import xyz.rk0.housing.data.loader.FieldExtractor;
import xyz.rk0.housing.data.loader.HousingDataFilter;
import xyz.rk0.housing.data.model.HousingRecord;
import xyz.rk0.housing.data.model.HousingResult;
import xyz.rk0.housing.data.statistics.StatisticCalculator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public final class HousingController {

    private final DataLoader dataLoader;
    private final HousingDataFilter dataFilter;
    private final FieldExtractor fieldExtractor;
    private final StatisticCalculator statisticCalculator;
    private static final Logger LOGGER = LogManager.getLogger(HousingRecord.class);

    HousingController(
        DataLoader dataLoader,
        HousingDataFilter dataFilter,
        FieldExtractor fieldExtractor,
        StatisticCalculator statisticCalculator
    ) {
        this.dataLoader = dataLoader;
        this.dataFilter = dataFilter;
        this.fieldExtractor = fieldExtractor;
        this.statisticCalculator = statisticCalculator;
    }

    @GetMapping("/housing-data")
    public HousingResult readHousingData(
        @RequestParam(required = false) String zipCode,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam String statistic,
        @RequestParam String field
    ) throws IOException {

        LOGGER.info("${java:version} -- Calculating " + statistic + " for " + field + " field");
        List<HousingRecord> housingData = this.dataLoader.readCsv();
        LocalDate localStartDate = startDate == null
                ? null
                : LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate localEndDate = endDate == null
                ? null
                : LocalDate.parse(endDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        List<HousingRecord> filteredData = this.dataFilter.filterData(housingData, zipCode, localStartDate, localEndDate);
        List<Double> values = this.fieldExtractor.extractValues(filteredData, field);
        double result = this.statisticCalculator.calculateStatistic(values, statistic);
        LOGGER.info("Got result: " + result);
        return new HousingResult(result, filteredData.size());
    }

}
