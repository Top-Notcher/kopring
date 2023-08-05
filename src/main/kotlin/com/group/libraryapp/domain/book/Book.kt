package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }

//        if (type !in AVAILABLE_BOOK_TYPES) {
//            throw IllegalArgumentException("들어올 수 없는 타입입니다.")
//        }
    }

    fun getEventScore(): Int {
//        return when (type) {
//            BookType.COMPUTER -> 10
//            BookType.ECONOMY -> 8
//            BookType.SOCIETY, BookType.LANGUAGE, BookType.SCIENCE -> 5
//            else -> throw IllegalArgumentException("잘못된 타입니다")
//        }
        return type.score
    }

    companion object {
        private val AVAILABLE_BOOK_TYPES = listOf("COMPUTER", "ECONOMY", "SOCIETY", "LANGUAGE", "SCIENCE")
        fun fixture(
            name: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long? = null,
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id,
            )
        }
    }
}