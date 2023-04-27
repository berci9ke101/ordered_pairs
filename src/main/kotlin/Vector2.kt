package ordered_pairs

import kotlin.math.*

/**
 * 2D vector class
 *
 * Defines a 2D vector class with basic functions
 * @author Kovács Bertalan
 */
class Vector2
{
    /*Attributes*/
    /**
     * Variable for the first (x) coordinate
     */
    var x: Float
        /**
         * Keeping the setter private
         */
        private set

    /**
     * Variable for the second (y) coordinate
     */
    var y: Float
        /**
         * Keeping the setter private
         */
        private set

    /**
     * Helps to convert radians to degrees
     */
    companion object
    {
        private const val radtodeg: Float = 180.0f / PI.toFloat()
    }

    /*Constructors*/
    /**
     * Parameterized constructor
     *
     * Sets the vector's values to the given values
     *
     * @param x the X coordinate of the vector
     * @param y the Y coordinate of the vector
     */
    constructor(x: Float = 0.0f, y: Float = 0.0f)
    {
        this.x = x
        this.y = y
    }

    /**
     * Null-safe constructor with custom values
     *
     * @param x the X coordinate of the vector
     * @param y the Y coordinate of the vector
     */
    constructor(x: Float?, y: Float?) : this(x ?: 0.0f, y ?: 0.0f)

    /*Operators*/
    /**
     * Operator  **+**
     *
     * Returns the sum of two vectors
     * @param other the other vector
     * @return the sum of the two vectors
     */
    operator fun plus(other: Vector2): Vector2 = Vector2(this.x + other.x, this.y + other.y)

    /**
     * Operator  **+=**
     *
     * Adds the value of the right operand to a variable and assigns the result to the variable
     * @param other the other vector
     */
    operator fun plusAssign(other: Vector2)
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
    operator fun minus(other: Vector2): Vector2 = Vector2(this.x - other.x, this.y - other.y)

    /**
     * Operator **-=**
     *
     * Subtracts the value of the right operand to a variable and assigns the result to the variable
     * @param other the other vector
     */
    operator fun minusAssign(other: Vector2)
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
    operator fun times(other: Float): Vector2 = Vector2(this.x * other, this.y * other)

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
        if (other !is Vector2)
        {
            return false
        }
        return x - other.x < 0.0001f && y - other.y < 0.0001f
    }

    /*Methods*/
    /**
     * Length of a vector
     *
     * @return the length of the vector
     */
    fun length(): Float = sqrt(x * x + y * y)

    /**
     * Dot product of two vectors
     *
     * @param other the other vector
     * @return the dot product
     */
    fun dot(other: Vector2): Float = (x * other.x + y * other.y)

    /**
     * Angle of two vectors
     *
     * @param other the other vector
     * @return the smaller angle of two vectors in radians
     */
    fun angleRad(other: Vector2): Float = acos(this.dot(other) / (this.length() * other.length()))

    /**
     * Angle of two vectors
     *
     * @param other the other vector
     * @return the smaller angle of two vectors in degrees
     */
    fun angleDeg(other: Vector2): Float = acos(this.dot(other) / (this.length() * other.length())) * radtodeg

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
    fun rotDeg(angle: Float) = this.rotRad(angle * (1 / radtodeg))

    /**
     * Represents the vector's coordinates in a fancy way
     *
     * Overrides the super's toString method
     * @return the vector's coordinates such as: (x;y)
     */
    override fun toString(): String = "(${x};${y})"


    /**
     * The hashCode of the vector
     *
     * @return the vector object's hashcode
     */
    override fun hashCode(): Int
    {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }
}