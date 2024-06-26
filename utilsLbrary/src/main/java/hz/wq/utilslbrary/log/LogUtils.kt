package hz.wq.utilslbrary.log

import android.os.Build
import android.util.Log
import hz.wq.utilslbrary.BuildConfig

/**
 * 描述: 日志工具类
 */
fun String.wqLog() {

    if (LogUtils.isAndroidLog) {
        if (LogUtils.isDebug()) {
            var clickStr = getClickStr(4)
            Log.i("wq", "$clickStr $this")
        }
    } else {
        var clickStr = getClickStr(3)
        println("$clickStr $this ")
    }
}

private fun getClickStr(stackTraceIndex: Int): String {
    val stackTrace = Thread.currentThread().stackTrace
    val previousMethod = stackTrace[stackTraceIndex]
    var clickStr = "wqLog.(${previousMethod.fileName}:${previousMethod.lineNumber})"
    return clickStr
}

object LogUtils {
    /**
     * 是否是安卓Log
     */
    var isAndroidLog: Boolean = true
    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }


}