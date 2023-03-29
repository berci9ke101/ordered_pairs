import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ordered_pairs.*
import kotlin.math.PI

class Vector2Test {
    private val final_nullvec: Vector2 = Vector2()
    private val final_onezero: Vector2 = Vector2(1f, 0f)
    private val final_zeroone: Vector2 = Vector2(0f, 1f)

    @Test
    fun nullConstructor() {
        val dummy = Vector2(null, null)
        assertEquals(dummy, Vector2())
    }

    @Test
    fun getX() {
        assertEquals(0f, final_nullvec.x, .0001f)
        assertEquals(1f, final_onezero.x, .0001f)
        assertEquals(0f, final_zeroone.x, .0001f)
    }

    @Test
    fun getY() {
        assertEquals(0f, final_nullvec.y, .0001f)
        assertEquals(0f, final_onezero.y, .0001f)
        assertEquals(1f, final_zeroone.y, .0001f)
    }

    @Test
    fun plus() {
        val test = final_nullvec + Vector2(6f, 9f)
        assertEquals(Vector2(6f, 9f), test)

        val test2 = final_onezero + Vector2(6f, 9f)
        assertEquals(Vector2(7f, 9f), test2)
    }

    @Test
    fun plusAssign() {
        val dummy = Vector2(2f, 2f)
        dummy += Vector2(1f, 1f)
        assertEquals(Vector2(3f, 3f), dummy)
    }

    @Test
    fun minus() {
        val test = final_nullvec - Vector2(6f, 9f)
        assertEquals(Vector2(-6f, -9f), test)

        val test2 = final_onezero - Vector2(6f, 9f)
        assertEquals(Vector2(-5f, -9f), test2)
    }

    @Test
    fun minusAssign() {
        val dummy = Vector2(2f, 2f)
        dummy -= Vector2(1f, 1f)
        assertEquals(Vector2(1f, 1f), dummy)
    }

    @Test
    fun times() {
        val test = final_nullvec * 11f
        assertEquals(Vector2(0f, 0f), test)

        val test2 = final_onezero * 21f
        assertEquals(Vector2(21f, 0f), test2)
    }

    @Test
    fun timesAssign() {
        val dummy = Vector2(2f, 1f)
        dummy *= 12f
        assertEquals(Vector2(24f, 12f), dummy)
    }

    @Test
    fun testEquals() {
        assertNotEquals(true, final_onezero == final_nullvec)
        assertEquals(true, Vector2() == final_nullvec)
        assertNotEquals(true, final_nullvec.equals(12))

        assertNotEquals(false, final_onezero != final_nullvec)
        assertEquals(false, Vector2() != final_nullvec)
    }

    @Test
    fun length() {
        assertEquals(0f, final_nullvec.length(), .0001f)
        assertEquals(1f, final_onezero.length(), .0001f)
        assertEquals(1f, final_zeroone.length(), .0001f)
    }

    @Test
    fun testToString() {
        assertEquals("(0.0;0.0)", final_nullvec.toString())
        assertEquals("(1.0;0.0)", final_onezero.toString())
        assertEquals("(0.0;1.0)", final_zeroone.toString())
        assertEquals("(13.2;1.02)", Vector2(13.2f, 1.02f).toString())
    }

    @Test
    fun dot() {
        assertEquals(0f, final_nullvec.dot(final_onezero), .0001f)
        assertEquals(0f, final_zeroone.dot(final_onezero), .0001f)
        assertEquals(11f, Vector2(1.0f, 2.0f).dot(Vector2(3.0f, 4.0f)), .0001f)
    }

    @Test
    fun angleRad() {
        assertEquals((PI / 2).toFloat(), final_zeroone.angleRad(final_onezero), .0001f)
        assertEquals(0f, final_zeroone.angleRad(final_zeroone), .0001f)
    }

    @Test
    fun angleDeg() {
        assertEquals(90f, final_zeroone.angleDeg(final_onezero), .0001f)
        assertEquals(0f, final_zeroone.angleDeg(final_zeroone), .0001f)
    }

    @Test
    fun rotRad() {
        val dummy = final_onezero
        dummy.rotRad((PI / 2).toFloat())
        assertEquals(true, dummy == final_zeroone)
    }

    @Test
    fun rotDeg() {
        val dummy = final_onezero
        dummy.rotDeg(180f)
        assertEquals(true, dummy == Vector2(-1.0f, 0.0f))
    }
}
