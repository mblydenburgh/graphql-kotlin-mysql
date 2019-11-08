package com.blydenburgh.kotlineverywhere.dao.entities

import javax.persistence.*

@Entity
@Table(name = "posts")
data class Post(
    @Id
    val id: Long = (1000 * Math.random()).toLong(),
    @Column
    val body: String,
    @Column
    val username: String,
    @Column
    val publishDate: String
)