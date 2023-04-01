package com.ktxdevelopment.biometrics.presentation.util

class InverseList<T> : ArrayList<T>() {
    fun addBefore(element: T) {
        for (i in this.size - 2 downTo 0) {
            this[i + 1] = this[i]
        }
        this[0] = element
    }
}