package com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "claims")
data class Claim (
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column
    val claimId: String,

    @Column
    val paymentNumber: String,

    @Column
    val lossDate: String
)