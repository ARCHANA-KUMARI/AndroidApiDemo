package com.example.androidapidemo
import kotlinx.serialization.Serializable

@Serializable data object Main
@Serializable data class Detail(val text: String)