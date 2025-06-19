package com.cheng.ndkstudy

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cheng.ndkstudy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(v: View?) {
        v ?: return
        when (v.id) {
            R.id.btn_j2c -> testJ2C()
            R.id.btn_add_str -> testAddStr()
            R.id.btn_sum_array -> testSumArray()
            R.id.btn_obj_from_c -> testObjFromC()
            R.id.btn_call_static_method -> testCallJavaStaticMethod()
            R.id.btn_call_instance_method -> testCallJavaInstanceMethod()
            R.id.btn_access_instance_field -> testAccessInstanceField()
            R.id.btn_access_static_field -> testAccessStaticField()
            R.id.btn_call_super_method -> testCallSuperInstanceMethod()
            R.id.btn_return_object -> testReturnObject()
        }
    }

    private fun testJ2C() {
        val s: Short = 1
        val i = 10
        val l: Long = 100
        val f = 1000.00f
        val z = true
        val array: IntArray? = null
        val mMyJavaClass: MyJavaClass? = null
        val obj: Any? = null
        val str: String? = null
        val d = 10000.000
        val b: Byte = 1
        val c = 60.toChar()
        //JNI 数据类型与 Java 数据类型的映射关系
        JniClient.TestDataTypeJ2C(s, i, l, f, d, c, z, b, str, array, obj, mMyJavaClass)
    }

    private fun testAddStr() {
        //C中处理Java中传递的字符串-字符串相加
        val strFromC = JniClient.AddStr("Java2C_参数1", "Java2C_参数2")
        binding.sampleText.text = "${binding.sampleText.text}-$strFromC"
    }

    private fun testSumArray() {
        val javaArray = intArrayOf(10, 20, 30, 40, 50, 60)
        //C中处理Java中传递的字符串-字符串相加
        val javaArrayResult = JniClient.sumArray(javaArray)
        if (javaArrayResult != null) {
            Toast.makeText(
                this@MainActivity,
                "native中返回基本数组" + javaArrayResult[0],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun testObjFromC() {
        //C中处理Java中传递的字符串-字符串相加
        val java2ArrayResult = JniClient.getArrayObjectFromC(100)
        if (java2ArrayResult != null) {
            Toast.makeText(
                this@MainActivity,
                "native中返回对象数组" + java2ArrayResult[0][0] + "===" + java2ArrayResult[1][1],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun testCallJavaStaticMethod() {
        //jni调用java的静态方法 回传值
        JniClient.callJavaStaticMethod()
        Toast.makeText(this@MainActivity, MyJavaClass.getResultFromC(), Toast.LENGTH_SHORT).show()
    }

    private fun testCallJavaInstanceMethod() {
        //jni调用java的对象方法 回传值
        JniClient.callJavaInstaceMethod()
        Toast.makeText(this@MainActivity, MyJavaClass.getResultFromC2(), Toast.LENGTH_SHORT).show()
    }

    private fun testAccessInstanceField() {
        //C/C++ 访问 Jav实例变量
        val obj = ClassField()
        obj.num = 10
        obj.str = "Hello"
        // 本地代码访问和修改ClassField为中的静态属性num
        //JniClient.accessStaticField()
        JniClient.accessInstanceField(obj)
        // 输出本地代码修改过后的值
        Log.d(TAG, "In Java--->ClassField.num = " + obj.num)
        Log.d(TAG, "In Java--->ClassField.str = " + obj.str)
        Toast.makeText(
            this@MainActivity,
            "C/C++ 访问 Java实例变量 修改str " + obj.num + "===" + obj.str,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun testAccessStaticField() {
        //C/C++ 访问 Jav静态变量
        val obj = ClassField()
        obj.num = 10
        obj.str = "Hello"
        // 本地代码访问和修改ClassField为中的静态属性num
        JniClient.accessStaticField()
        //JniClient.accessInstanceField(obj)
        // 输出本地代码修改过后的值
        Log.d(TAG, "In Java--->ClassField.num = " + obj.num)
        Log.d(TAG, "In Java--->ClassField.str = " + obj.str)
        Toast.makeText(
            this@MainActivity,
            "C/C++ 访问 Java静态变量 修改str " + obj.num + "===" + obj.str,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun testCallSuperInstanceMethod() {
        //JNI 调用构造方法和父类实例方法
        Toast.makeText(this@MainActivity, "JNI 调用构造方法和父类实例方法 ", Toast.LENGTH_SHORT)
            .show()
        JniClient.callSuperInstanceMethod()
    }

    private fun testReturnObject() {
        val cat = JniClient.getObjectFromC("")
        cat.run()
        Log.d(TAG, "testReturnObject - $cat, ${cat.getName()}")
    }

    /**
     * A native method that is implemented by the 'ndkstudy' native library,
     * which is packaged with this application.
     */

    companion object {
        private const val TAG = "=====JNI====="

        // Used to load the 'ndkstudy' library on application startup.
        init {
            System.loadLibrary("ndkstudy")
        }
    }
}