package com.example.data.local

import androidx.room.TypeConverter
import com.example.data.model.QuizOption
import org.json.JSONArray
import org.json.JSONObject

class Converters {
    @TypeConverter
    fun fromStringList(value: List<String>?): String {
        if (value == null) return "[]"
        val array = JSONArray()
        for (item in value) {
            array.put(item)
        }
        return array.toString()
    }

    @TypeConverter
    fun toStringList(value: String?): List<String> {
        if (value.isNullOrBlank()) return emptyList()
        val list = mutableListOf<String>()
        try {
            val array = JSONArray(value)
            for (i in 0 until array.length()) {
                list.add(array.getString(i))
            }
        } catch (_: Exception) {}
        return list
    }

    @TypeConverter
    fun fromOptionList(value: List<QuizOption>?): String {
        if (value == null) return "[]"
        val array = JSONArray()
        for (opt in value) {
            val obj = JSONObject()
            obj.put("key", opt.key)
            obj.put("text", opt.text)
            array.put(obj)
        }
        return array.toString()
    }

    @TypeConverter
    fun toOptionList(value: String?): List<QuizOption> {
        if (value.isNullOrBlank()) return emptyList()
        val list = mutableListOf<QuizOption>()
        try {
            val array = JSONArray(value)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                list.add(
                    QuizOption(
                        key = obj.optString("key", ""),
                        text = obj.optString("text", "")
                    )
                )
            }
        } catch (_: Exception) {}
        return list
    }
}
