package xyz.rk0.housing.data.loader;

import org.springframework.stereotype.Component;
import xyz.rk0.housing.data.model.HousingRecord;

import java.util.ArrayList;
import java.util.List;

@Component
public final class FieldExtractor {

    /* Extract the numbers you want to do stats on before calculating the stats. That way you don't have to
     * have conditions like "if min and square footage..."
     * This little tiny bit of logic being its own class might be overkill.
     * But it makes the stats tests cleaner (maybe overly so) */

    public List<Double> extractValues(List<HousingRecord> filteredData, String field) {
        List<Double> values = new ArrayList<>();
        for (HousingRecord record : filteredData) {
            if (field.equals("squareFootage")) {
                values.add(record.getSquareFeet());
            } else {
                values.add(record.getPrice());
            }
        }
        return values;
    }
}
