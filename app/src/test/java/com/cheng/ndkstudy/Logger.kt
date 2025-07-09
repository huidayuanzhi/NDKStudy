package com.cheng.ndkstudy

object Logger {

    @JvmStatic
    fun log(nums: IntArray) {
        println(nums.joinToString(","))
    }

    @JvmStatic
    fun <T> log(list: List<T>) {
        println(list.joinToString(","))
    }

    @JvmStatic
    fun log(msg: String) {
        println(msg)
    }

    @JvmStatic
    fun log(nums: Array<IntArray>) {
        println(nums.map { it.joinToString(",") }.joinToString("\n"))
    }
}