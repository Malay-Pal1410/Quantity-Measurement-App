import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testYardToFeet() {
        assertTrue(
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.YARDS)
                        .equals(new QuantityMeasurementApp.Quantity(3.0, QuantityMeasurementApp.Unit.FEET))
        );
    }

    @Test
    void testYardToInches() {
        assertTrue(
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.YARDS)
                        .equals(new QuantityMeasurementApp.Quantity(36.0, QuantityMeasurementApp.Unit.INCHES))
        );
    }

    @Test
    void testCmToInches() {
        assertTrue(
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.CENTIMETERS)
                        .equals(new QuantityMeasurementApp.Quantity(0.393701, QuantityMeasurementApp.Unit.INCHES))
        );
    }

    @Test
    void testDifferentValues() {
        assertFalse(
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.YARDS)
                        .equals(new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.Unit.FEET))
        );
    }
}