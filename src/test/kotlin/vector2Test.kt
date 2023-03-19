import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ordered_pairs.*
import kotlin.math.PI

class vector2Test
{
    private val _final_nullvec: vector2 = vector2()
    private val _final_onezero: vector2 = vector2(1f, 0f)
    private val _final_zeroone: vector2 = vector2(0f, 1f)

    @Test
    fun nullConstructor()
    {
        val dummy = vector2(null, null)
        assertEquals(dummy, vector2())
    }

    @Test
    fun getX()
    {
        assertEquals(0f, _final_nullvec.x)
        assertEquals(1f, _final_onezero.x)
        assertEquals(0f, _final_zeroone.x)
    }

    @Test
    fun getY()
    {
        assertEquals(0f, _final_nullvec.y)
        assertEquals(0f, _final_onezero.y)
        assertEquals(1f, _final_zeroone.y)
    }

    @Test
    fun plus()
    {
        val test = _final_nullvec + vector2(6f, 9f)
        assertEquals(vector2(6f, 9f), test)

        val test2 = _final_onezero + vector2(6f, 9f)
        assertEquals(vector2(7f, 9f), test2)
    }

    @Test
    fun plusAssign()
    {
        val dummy = vector2(2f, 2f)
        dummy += vector2(1f, 1f)
        assertEquals(vector2(3f, 3f), dummy)
    }

    @Test
    fun minus()
    {
        val test = _final_nullvec - vector2(6f, 9f)
        assertEquals(vector2(-6f, -9f), test)

        val test2 = _final_onezero - vector2(6f, 9f)
        assertEquals(vector2(-5f, -9f), test2)
    }

    @Test
    fun minusAssign()
    {
        val dummy = vector2(2f, 2f)
        dummy -= vector2(1f, 1f)
        assertEquals(vector2(1f, 1f), dummy)
    }

    @Test
    fun times()
    {
        val test = _final_nullvec * 11f
        assertEquals(vector2(0f, 0f), test)

        val test2 = _final_onezero * 21f
        assertEquals(vector2(21f, 0f), test2)
    }

    @Test
    fun timesAssign()
    {
        val dummy = vector2(2f, 1f)
        dummy *= 12f
        assertEquals(vector2(24f, 12f), dummy)
    }

    @Test
    fun testEquals()
    {
        assertNotEquals(true, _final_onezero == _final_nullvec)
        assertEquals(true, vector2() == _final_nullvec)
        assertNotEquals(true, _final_nullvec.equals(12))

        assertNotEquals(false, _final_onezero != _final_nullvec)
        assertEquals(false, vector2() != _final_nullvec)
    }

    @Test
    fun length()
    {
        assertEquals(0f, _final_nullvec.length())
        assertEquals(1f, _final_onezero.length())
        assertEquals(1f, _final_zeroone.length())
    }

    @Test
    fun testToString()
    {
        assertEquals("(0.0;0.0)", _final_nullvec.toString())
        assertEquals("(1.0;0.0)", _final_onezero.toString())
        assertEquals("(0.0;1.0)", _final_zeroone.toString())
        assertEquals("(13.2;1.02)", vector2(13.2f, 1.02f).toString())
    }

    @Test
    fun dot()
    {
        assertEquals(0f, _final_nullvec.dot(_final_onezero))
        assertEquals(0f, _final_zeroone.dot(_final_onezero))
        assertEquals(11f, vector2(1.0f, 2.0f).dot(vector2(3.0f, 4.0f)))
    }

    @Test
    fun angleRad()
    {
        assertEquals((PI / 2).toFloat(), _final_zeroone.angleRad(_final_onezero))
        assertEquals(0f, _final_zeroone.angleRad(_final_zeroone))
    }

    @Test
    fun angleDeg()
    {
        assertEquals(90f, _final_zeroone.angleDeg(_final_onezero))
        assertEquals(0f, _final_zeroone.angleDeg(_final_zeroone))
    }

    @Test
    fun rotRad()
    {
        val dummy = _final_onezero
        dummy.rotRad((PI / 2).toFloat())
        assertEquals(true, dummy == _final_onezero)
    }

    @Test
    fun rotDeg()
    {
        val dummy = _final_onezero
        dummy.rotDeg(90f)
        assertEquals(true, dummy == _final_onezero)
    }
}
