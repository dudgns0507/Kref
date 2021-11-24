package com.github.dudgns0507.kref

import android.content.Context
import android.content.SharedPreferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.github.dudgns0507.kref.ext.key
import com.google.common.truth.Truth.assertThat
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
const val DB_NAME = "KrefTest"

@RunWith(AndroidJUnit4::class)
@SmallTest
class KrefTest {
    private lateinit var context: Context
    private lateinit var sp: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor

    var kString: String by StringPref(default = "")

    @Before
    fun start() {
        context = InstrumentationRegistry.getInstrumentation().context
        sp = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)
        edit = sp.edit()
        KrefManager.init(context, DB_NAME)
    }

    @Test
    fun insertStringPref() {
        val testString = "Kref String"
        kString = testString

        val str = sp.getString("kString".key(), "")

        assertThat(str).isEqualTo(testString)
    }

    @AfterClass
    fun end() {
        edit.clear()
        edit.apply()
    }
}