package com.example.appsinvo.models

data class FakeDataModel(
    val id: String,
    val title: String,
    val body: String
){
    fun toStringRepresentation(): String{
        return "ID: $id\nTitle: $title\nBody: $body "
    }
}
