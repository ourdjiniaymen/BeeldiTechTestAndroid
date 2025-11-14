package com.example.beelditechtest

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.IOException

class EquipmentDataSource(private val context: Context) {

    suspend fun getEquipments(): List<Equipment> = withContext(Dispatchers.Main) {
        try {
            val jsonString = context.assets.open("equipments.json")
                .bufferedReader()
                .use { it.readText() }

            val jsonArray = JSONArray(jsonString)
            val equipments = mutableListOf<Equipment>()

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val equipment = Equipment(
                    id = jsonObject.getString("id"),
                    name = jsonObject.getString("name"),
                    brand = jsonObject.getString("brand"),
                    model = jsonObject.getString("model"),
                    serialNumber = jsonObject.getString("serialNumber"),
                    location = jsonObject.getString("location")
                )
                equipments.add(equipment)
            }

            equipments
        } catch (e: IOException) {
            emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
