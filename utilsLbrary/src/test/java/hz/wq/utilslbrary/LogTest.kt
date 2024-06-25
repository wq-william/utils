package hz.wq.utilslbrary

import hz.wq.utilslbrary.log.LogUtils
import hz.wq.utilslbrary.log.wqLog
import kotlinx.coroutines.test.runTest
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LogTest {

    init {
        LogUtils.isAndroidLog = false
    }

    @Test
    fun logTest() = runTest {
        "点击这里跳转".wqLog()
    }
}