public class QuantityMeasurementApp {

    // Enum for units
    enum Unit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double factor;

        Unit(double factor) {
            this.factor = factor;
        }

        public double convertToFeet(double value) {
            return value * factor;
        }
    }

    // Generic Quantity class
    static class Quantity {
        private final double value;
        private final Unit unit;

        public Quantity(double value, Unit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert any unit to feet
        private double toFeet() {
            return unit.convertToFeet(value);
        }

        // Equality check
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Quantity)) return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // Main method
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(12.0, Unit.INCH);

        Quantity q3 = new Quantity(5.0, Unit.FEET);
        Quantity q4 = new Quantity(60.0, Unit.INCH);

        System.out.println(q1 + " == " + q2 + " ? " + q1.equals(q2));
        System.out.println(q3 + " == " + q4 + " ? " + q3.equals(q4));
    }
}