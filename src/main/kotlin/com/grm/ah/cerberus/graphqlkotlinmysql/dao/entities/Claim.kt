package com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "claims")
data class Claim (
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column
    val claimId: String,

    @Column
    var lossDate: String,

    @OneToMany(mappedBy = "claimId")
    val payments: List<Payment>? = null
)