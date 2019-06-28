package com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "payments")
data class Payment (
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column
    val paymentNumber: String,

    @Column
    val claimId: String,

    @Column
    val claimantFullName: String
)