package com.theironyard;

/**
 * Create a class named Converter. This class will have one static method that
 * will convert a length in one unit to the equivalent value in another unit.
 */
public class Converter {


	/**
	 * Create a static method named `convert`. This method will accept the
	 * following arguments:
	 * <p>
	 * length - a double representing the length being converted
	 * from - a Unit representing the unit to convert from
	 * to - a Unit representing the unit to convert to
	 * <p>
	 * The `convert` method will return the converted value.
	 *
	 * @param length the length being converted
	 * @param from   the unit to convert from
	 * @param to     the unit to convert to
	 * @return the converted length
	 */
	// todo: create convert method
	public static double convert(double length, Unit from, Unit to) {

        /*
            Since any unit knows how long it is in millimeters, we can use
            millimeters as a "base" unit. IE, to convert from miles to feet, we
            can get the number of millimeters in a mile, multiply our length by
            that to get the total millimeters. Then, we can divide that by the
            number of millimeters in a foot to find the number of feet in a
            mile.
         */
	// todo: create a variable and set it to length times the number of millimeters in the unit
		double newUnit = length * from.toMillimeters();

	// todo: return the result of dividing the length in millimeters by the number of millimeters in the unit we're convering to
		return newUnit / to.toMillimeters();
	}
}