package hz.wq.utilslbrary

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import hz.wq.utilslbrary.log.LogUtils
import hz.wq.utilslbrary.log.wqLog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

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