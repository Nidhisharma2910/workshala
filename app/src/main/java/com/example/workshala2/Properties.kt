package com.example.workshala2

import android.text.Editable
import android.text.InputFilter

data class Properties(
    val email: Email,
    val password: Password
) : Editable {
    override fun get(index: Int): Char {
        TODO("Not yet implemented")
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        TODO("Not yet implemented")
    }

    override fun getChars(start: Int, end: Int, dest: CharArray?, destoff: Int) {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getSpans(start: Int, end: Int, type: Class<T>?): Array<T> {
        TODO("Not yet implemented")
    }

    override fun getSpanStart(tag: Any?): Int {
        TODO("Not yet implemented")
    }

    override fun getSpanEnd(tag: Any?): Int {
        TODO("Not yet implemented")
    }

    override fun getSpanFlags(tag: Any?): Int {
        TODO("Not yet implemented")
    }

    override fun nextSpanTransition(start: Int, limit: Int, type: Class<*>?): Int {
        TODO("Not yet implemented")
    }

    override fun setSpan(what: Any?, start: Int, end: Int, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun removeSpan(what: Any?) {
        TODO("Not yet implemented")
    }

    override fun append(text: CharSequence?): Editable {
        TODO("Not yet implemented")
    }

    override fun append(text: CharSequence?, start: Int, end: Int): Editable {
        TODO("Not yet implemented")
    }

    override fun append(text: Char): Editable {
        TODO("Not yet implemented")
    }

    override fun replace(st: Int, en: Int, source: CharSequence?, start: Int, end: Int): Editable {
        TODO("Not yet implemented")
    }

    override fun replace(st: Int, en: Int, text: CharSequence?): Editable {
        TODO("Not yet implemented")
    }

    override fun insert(where: Int, text: CharSequence?, start: Int, end: Int): Editable {
        TODO("Not yet implemented")
    }

    override fun insert(where: Int, text: CharSequence?): Editable {
        TODO("Not yet implemented")
    }

    override fun delete(st: Int, en: Int): Editable {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun clearSpans() {
        TODO("Not yet implemented")
    }

    override fun setFilters(filters: Array<out InputFilter>?) {
        TODO("Not yet implemented")
    }

    override fun getFilters(): Array<InputFilter> {
        TODO("Not yet implemented")
    }

    override val length: Int
        get() = TODO("Not yet implemented")
}