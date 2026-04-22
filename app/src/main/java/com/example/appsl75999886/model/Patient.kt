package com.example.appsl75999886.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey
    val codpaciente: String,
    val password: String,
    val nombreapellido: String,
    val celular: String
)
