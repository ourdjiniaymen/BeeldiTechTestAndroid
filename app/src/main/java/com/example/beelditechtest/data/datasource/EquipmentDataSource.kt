package com.example.beelditechtest.data.datasource

import android.content.Context
import android.util.Log
import com.example.beelditechtest.data.model.EquipmentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONArray
import java.io.IOException

class EquipmentDataSource(private val context: Context) {

     fun getEquipmentsFlow(): Flow<List<EquipmentEntity>> = flow {
         try {
             val jsonString = context.assets.open("equipments.json")
                 .bufferedReader()
                 .use { it.readText() }

             val jsonArray = JSONArray(jsonString)
             val equipmentEntities = mutableListOf<EquipmentEntity>()

             for (i in 0 until jsonArray.length()) {
                 val jsonObject = jsonArray.getJSONObject(i)
                 val equipmentEntity = EquipmentEntity(
                     id = jsonObject.getString("id"),
                     name = jsonObject.getString("name"),
                     brand = jsonObject.getString("brand"),
                     model = jsonObject.getString("model"),
                     serialNumber = jsonObject.getString("serialNumber"),
                     location = jsonObject.getString("location"),
                     type = jsonObject.getInt("type")
                 )
                 equipmentEntities.add(equipmentEntity)
             }

             emit(equipmentEntities)
         } catch (e: IOException) {
             emit(emptyList())
         } catch (e: Exception) {
             Log.e("EquipmentDataSource", "Erreur lors de la lecture du fichier JSON", e)
             emit(emptyList())
         }
     }.flowOn(Dispatchers.IO)
}