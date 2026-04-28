import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.convert(
                        1.0,
                        QuantityMeasurementApp.Unit.FEET,
                        QuantityMeasurementApp.Unit.INCHES
                ),
                EPSILON
        );
    }

    @Test
    void testYardsToFeet() {
        assertEquals(9.0,
                QuantityMeasurementApp.convert(
                        3.0,
                        QuantityMeasurementApp.Unit.YARDS,
                        QuantityMeasurementApp.Unit.FEET
                ),
                EPSILON
        );
    }
}