package com.grm.ah.cerberus.graphqlkotlinmysql.dto

data class ClaimDto(
    val claimId: String,
    val paymentNumber: String,
    val lossDate: String
)