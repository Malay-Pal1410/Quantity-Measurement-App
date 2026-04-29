package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    // ✅ ENUM (all units + conversion to base unit = inches)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInchesFactor;

        LengthUnit(double toInchesFactor) {
            this.toInchesFactor = toInchesFactor;
        }

        public double toInches(double value) {
            return value * toInchesFactor;
        }

        public double fromInches(double inches) {
            return inches / toInchesFactor;
        }
    }

    // ✅ Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    // ✅ UC5: Conversion Method
    public double convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double inches = unit.toInches(value);
        return targetUnit.fromInches(inches);
    }

    // ✅ UC6: Addition Method
    public Length add(Length other) {
        if (other == null)
            throw new IllegalArgumentException("Second length cannot be null");

        double thisInches = this.unit.toInches(this.value);
        double otherInches = other.unit.toInches(other.value);

        double sumInches = thisInches + otherInches;

        double resultValue = this.unit.fromInches(sumInches);

        // round to 2 decimal places
        resultValue = Math.round(resultValue * 100.0) / 100.0;

        return new Length(resultValue, this.unit);
    }

    // ✅ Equality (UC3/UC4)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double thisInches = this.unit.toInches(this.value);
        double otherInches = other.unit.toInches(other.value);

        return Math.abs(thisInches - otherInches) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}