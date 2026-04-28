public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-6;

    // ✅ 1. ENUM comes first (recommended)
    public enum Unit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double toFeet;

        Unit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeet;
        }
    }

    // ✅ 2. PASTE YOUR Quantity CLASS HERE 👇
    static class Quantity {

        private static final double EPSILON = 1e-6;

        private double value;
        private Unit unit;

        public Quantity(double value, Unit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Quantity)) return false;

            Quantity other = (Quantity) obj;

            double thisInFeet = unit.toFeet(value);
            double otherInFeet = other.unit.toFeet(other.value);

            return Math.abs(thisInFeet - otherInFeet) < EPSILON;
        }
    }

    // ✅ 3. convert() method
    public static double convert(double value, Unit source, Unit target) {
        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid number");

        double valueInFeet = source.toFeet(value);
        return target.fromFeet(valueInFeet);
    }

    // ✅ 4. main method (optional)
    public static void main(String[] args) {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(12.0, Unit.INCHES);

        System.out.println(q1.equals(q2)); // true
    }
}