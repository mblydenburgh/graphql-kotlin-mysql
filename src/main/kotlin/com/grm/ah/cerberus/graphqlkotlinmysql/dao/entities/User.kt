package com.blydenburgh.kotlineverywhere.dao.entities

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    val id: Long = (1000*Math.random()).toLong(),
    @Column
    val username: String,
    @Column
    val age: Int,
    @Column
    val gender: Gender,
    @OneToMany(mappedBy = "username")
    val posts: List<Post>? = null
)

enum class Gender {
    MALE, FEMALE, OTHER;

    override fun toString(): String = when (this) {
        MALE -> "M"
        FEMALE -> "F"
        else -> "O"
    }
}

fun Char.toGender() = when (this) {
    'M' -> Gender.MALE
    'F' -> Gender.FEMALE
    else -> Gender.OTHER
}