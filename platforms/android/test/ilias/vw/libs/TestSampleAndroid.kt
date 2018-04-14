package ilias.vw.libs

import kotlin.test.*

class TestSampleAndroid {
    @Test
    fun testCheckPlatform() {
        val sample = Cart("test")
        val name = sample.name
        assertEquals(name, "test")
    }
}
