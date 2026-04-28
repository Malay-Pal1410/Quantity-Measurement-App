public class QuantityMeasurementApp {

    // ✅ ENUM (extended for UC4)
    enum Unit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),                 // 1 yard = 3 feet
        CENTIMETERS(0.0328084);     // 1 cm = 0.0328084 feet

        private final double toFeet;

        Unit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }
    }

    // ✅ Generic Quantity class
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

        // Convert to base unit (feet)
        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double diff = Math.abs(this.toFeet() - other.toFeet());

            return diff < 0.0001;   // ✅ tolerance (VERY IMPORTANT)
        }
    }

    // ✅ Main method (Demo)
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, Unit.YARDS);
        Quantity q2 = new Quantity(3.0, Unit.FEET);

        System.out.println("1 yard == 3 feet ? " + q1.equals(q2));

        Quantity q3 = new Quantity(1.0, Unit.CENTIMETERS);
        Quantity q4 = new Quantity(0.393701, Unit.INCHES);

        System.out.println("1 cm == 0.393701 inch ? " + q3.equals(q4));
    }
}