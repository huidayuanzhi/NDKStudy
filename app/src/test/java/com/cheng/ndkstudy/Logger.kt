package com.cheng.ndkstudy

object Logger {

    @JvmStatic
    fun log(nums: IntArray) {
        println(nums.joinToString(","))
    }

    @JvmStatic
    fun log(msg: String) {
        println(msg)
    }
}