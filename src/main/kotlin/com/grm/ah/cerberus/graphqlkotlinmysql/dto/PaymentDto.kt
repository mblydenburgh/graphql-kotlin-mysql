package com.grm.ah.cerberus.graphqlkotlinmysql.dto

data class PaymentDto (
    val paymentNumber: String,
    val claimId: String,
    val claimantFullName: String
)