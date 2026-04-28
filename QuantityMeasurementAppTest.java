import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEqualFeetAndInches() {
        QuantityMeasurementApp.Quantity q1 =
                new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.FEET);

        QuantityMeasurementApp.Quantity q2 =
                new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.Unit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testSameUnitEquality() {
        assertTrue(new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.Unit.FEET)
                .equals(new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.Unit.FEET)));
    }

    @Test
    void testDifferentValues() {
        assertFalse(new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.Unit.FEET)
                .equals(new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.Unit.FEET)));
    }
}