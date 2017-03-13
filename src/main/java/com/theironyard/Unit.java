package com.theironyard;

/**
 * For this file you will need to create an enum that represents lengths. EG:
 * mile, inch, millimeter, etc. Each of these units will have an associated
 * value that is it's length in millimeters. For example, a foot is 304.8
 * millimeters. This will help us write another class that can convert
 * measurements in one unit to another unit.
 * <p>
 * Follow the instructions below to create this enum.
 */
// todo: create a new enum named "Unit"
public enum Unit {

    /*
        We need to have a set of values defined for our units. Each of these
        values has an associated number, which is the length in millimeters. For
        example, a foot is 304.8 millimeters.

        In enums, you specify default values as if you were invoking a
        constructor. For example, let's say we had a unit of furlongs. A furlong
        is 1/8 mile, or 201,168 millimeters. To define this value for our enum
        we would use:

        FURLONG(201168)

        This tells Java to call the Unit's constructor, passing in 201168 as the
        first argument, when the FURLONG value is used.

        Note: enum values are comma separated. The final enum value is
        terminated with a semicolon.

        Your job is to define the following values with their associated
        measurements in millimeters. Be sure to use the correct naming
        conventions!

        mile = 1609344 millimeters
        yard = 914.4 millimeters
        foot = 304.8 millimeters
        inch = 25.4 millimeters
        kilometer = 1000000 millimeters
        meter = 1000 millimeters
        centimeter = 10 millimeters
        millimeter = 1 millimeters
     */
	// todo: define Unit enum values

		MILE(1609344),
		YARD(914.4),
		FOOT(304.8),
		INCH(25.4),
		KILOMETER(1000000),
		METER(1000),
		CENTIMETER(10),
		MILLIMETER(1);


    /*
        We need a private property to hold the number of millimeters for a given
        enum value.
     */
	// todo: define a private property to hold the number of millimeters represented by this Unit value
	private double millimeters;

	/**
	 * Create a constructor that accepts the number of millimeters for the unit
	 * and stores them in a private property.
	 * @param millimeters The number of millimeters for a given unit. EG: 914.4 for a yard.
	 */
	// todo: create the Unit enum's constructor.
	Unit(double millimeters){
		this.millimeters = millimeters;
	}



	/**
	 * Create a method named `toMillimeters` that returns the number of
	 * millimeters in this Unit.
	 * @return The number of millimeters in this unit. EG: 201168 for a furlong
	 */
	// todo: create toMillimeters method
	public double toMillimeters(){
		return this.millimeters;
	}
}

