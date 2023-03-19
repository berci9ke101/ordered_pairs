package ordered_pairs

import kotlin.math.*

/**
 * 2D vector class
 *
 * Defines a 2D vector class with basic functions
 * @author Kovács Bertalan
 */
class vector2
{
    /*Attributes*/
    /**
     * Variable for the first (x) coordinate
     */
    var x: Float
        /**
         * Keeping the setter private
         */
        private set(value)
        {
            field = value
        }

    /**
     * Variable for the second (y) coordinate
     */
    var y: Float
        /**
         * Keeping the setter private
         */
        private set(value)
        {
            field = value
        }

    /**
     * Helps to convert radians to degrees
     */
    private val _radtodeg: Float = 180.0f / PI.toFloat()


    /*Constructors*/
    /**
     * Default constructor
     *
     * Sets the vector's default values to 0.0
     */
    constructor()
    {
        this.x = 0.0f
        this.y = 0.0f
    }

    /**
     * Null-safe constructor with custom values
     *
     * @param x the X coordinate of the vector
     * @param y the Y coordinate of the vector
     */
    constructor(x: Float?, y: Float?) : this()
    {
        if (!(x == null || y == null))
        {
            this.x = x
            this.y = y
        }
    }


    /*Operators*/
    /**
     * Operator  **+**
     *
     * Returns the sum of two vectors
     * @param other the other vector
     * @return the sum of the two vectors
     */
    operator fun plus(other: vector2): vector2
    {
        return vector2(this.x + other.x, this.y + other.y)
    }

    /**
     * Operator  **+=**
     *
     * Adds the value of the right operand to a variable and assigns the result to the variable
     * @param other the other vector
     */
    operator fun plusAssign(other: vector2)
    {
        this.x += other.x
        this.y += other.y
    }

    /**
     * Operator  **-**
     *
     * Returns the difference of the right operand and the given vector
     * @param other the other vector
     * @return the difference of the two vectors
     */
    operator fun minus(other: vector2): vector2
    {
        return vector2(this.x - other.x, this.y - other.y)
    }

    /**
     * Operator **-=**
     *
     * Subtracts the value of the right operand to a variable and assigns the result to the variable
     * @param other the other vector
     */
    operator fun minusAssign(other: vector2)
    {
        this.x -= other.x
        this.y -= other.y
    }

    /**
     * Operator *
     *
     * Multiples the vector with the scalar and returns it
     * @param other the scalar
     * @return the product of a vector and a scalar
     */
    operator fun times(other: Float): vector2
    {
        return vector2(this.x * other, this.y * other)
    }


    /**
     * Operator *=
     *
     * Multiples the vector with the scalar
     * @param other the scalar
     */
    operator fun timesAssign(other: Float)
    {
        this.x *= other
        this.y *= other
    }

    /**
     * Operator **==**
     *
     * Decides whether two vectors are equal
     * @param other the object we want to compare to
     * @return the logical value
     */
    override operator fun equals(other: Any?): Boolean
    {
        if (other !is vector2)
        {
            return false
        }
        return x == other.x && y == other.y
    }

    /*Methods*/
    /**
     * Length of a vector
     *
     * @return the length of the vector
     */
    fun length(): Float
    {
        return sqrt(x * x + y * y)
    }

    /**
     * Represents the vector's coordinates in a fancy way
     *
     * Overrides the super's toString method
     * @return the vector's coordinates such as: (x;y)
     */
    override fun toString(): String
    {
        return "(${x};${y})"
    }

    /**
     * Dot product of two vectors
     *
     * @param other the other vector
     * @return the dot product
     */
    fun dot(other: vector2): Float
    {
        return (x * other.x + y * other.y)
    }

    /**
     * Angle of two vectors
     *
     * @param other the other vector
     * @return the smaller angle of two vectors in radians
     */
    fun angleRad(other: vector2): Float
    {
        return acos(this.dot(other) / (this.length() * other.length()))
    }

    /**
     * Angle of two vectors
     *
     * @param other the other vector
     * @return the smaller angle of two vectors in degrees
     */
    fun angleDeg(other: vector2): Float
    {
        return acos(this.dot(other) / (this.length() * other.length())) * _radtodeg
    }

    /**
     * Rotates the vector with the given angle in radians
     *
     * @param angle the angle in radians
     */
    fun rotRad(angle: Float)
    {
        val setx = (x * cos(angle) - (y * sin(angle)))
        val sety = (x * sin(angle) + (y * cos(angle)))
        x = (round(setx * 1_000_000) / 1_000_000)
        y = (round(sety * 1_000_000) / 1_000_000)
    }

    /**
     * Rotates the vector with the given angle in degrees
     *
     * @param angle the angle in degrees
     */
    fun rotDeg(angle: Float)
    {
        this.rotRad(angle * (1 / _radtodeg))
    }
}