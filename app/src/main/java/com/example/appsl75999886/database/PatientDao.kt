package com.example.appsl75999886.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appsl75999886.model.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: Patient)

    @Query("SELECT * FROM patients WHERE codpaciente = :codpaciente")
    suspend fun getPatientByCod(codpaciente: String): Patient?

    @Query("SELECT * FROM patients WHERE codpaciente = :codpaciente LIMIT 1")
    suspend fun loginPatient(codpaciente: String): Patient?

    @Query("SELECT * FROM patients")
    fun getAllPatients(): Flow<List<Patient>>
}
