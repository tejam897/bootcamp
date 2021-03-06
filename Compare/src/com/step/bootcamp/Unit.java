package com.step.bootcamp;

import java.util.Objects;

import static com.step.bootcamp.MeasurementType.*;

public enum Unit {
    INCH(1, 0, LENGTH),FEET(12, 0, LENGTH), CENTIMETER(0.4, 0, LENGTH) , MILLI_METER(0.04, 0, LENGTH),
    LITRE(1, 0, VOLUME) , GALLON(3.78, 0, VOLUME),
    GRAM(1, 0, WEIGHT), KILOGRAM(1000, 0, WEIGHT), TON(1000*1000, 0, WEIGHT),
    CELCIUS(9, -32+14.222222222222214, TEMPARATURE),FAHRENHEIT(5, 32, TEMPARATURE);

    private final double valueInBaseUnit;
    private final double offset;
    private final MeasurementType type;

    Unit(double valueInBaseUnit, double offset, MeasurementType type) {
        this.valueInBaseUnit = valueInBaseUnit;
        this.offset = offset;
        this.type = type;
    }

    public double toUnit(double value, Unit other) {
        return valueInBaseUnit /other.valueInBaseUnit * value + other.offset;
    }

    public boolean isOfSameBaseUnit(Unit unit) {
        return type == unit.type;
    }

    public int hash(double value) {
        return Objects.hash((double) (Math.round((value * valueInBaseUnit) * 10) / 10));
    }

}


