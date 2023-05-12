package com.example.carpool_harsha.models

import java.sql.Driver

data class FeedbackModel(
    val feedId: String?=null,
    val serviceTitle: String? = null,
    val driver: String? = null,
    val feedback: String? = null,
    val about: String? = null

)
