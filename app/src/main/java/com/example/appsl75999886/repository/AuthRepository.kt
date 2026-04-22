package com.example.appsl75999886.repository

import com.example.appsl75999886.database.PatientDao
import com.example.appsl75999886.model.Patient

class AuthRepository(
    private val patientDao: PatientDao,
    private val samplePatients: List<Patient>
) {

    suspend fun loginPatient(codpaciente: String, password: String): Patient? {
        val patient = samplePatients.firstOrNull {
            it.codpaciente == codpaciente && it.password == password
        } ?: return null

        patientDao.insert(patient)
        return patientDao.getPatientByCod(patient.codpaciente) ?: patient
    }

    suspend fun savePatient(patient: Patient) {
        patientDao.insert(patient)
    }

    suspend fun getPatient(codpaciente: String): Patient? {
        return patientDao.getPatientByCod(codpaciente)
    }
}
