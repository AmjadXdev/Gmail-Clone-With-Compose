package com.amjadxdev.ch7gmailapp.model

data class Account(
    val icon : Int? = null,
    val userName : String,
    val email : String,
    val unReadMails : Int
)
