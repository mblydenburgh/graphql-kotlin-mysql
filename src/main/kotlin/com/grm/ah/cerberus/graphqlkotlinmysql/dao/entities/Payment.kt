package com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities

import java.util.*
import javax.persistence.*

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
    val claimantFullName: String,

    @ManyToOne
    @JoinColumn(name = "claimId", insertable = false, updatable = false)
    val claim: Claim? = null
)