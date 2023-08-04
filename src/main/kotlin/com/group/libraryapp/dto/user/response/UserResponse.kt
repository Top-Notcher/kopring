package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int?,

) {
    // 제일 괜찮은 것은 정적 팩토리 메소드
    companion object {
        fun of(user: User): UserResponse {
            return UserResponse(
                id = user.id!!,
                name = user.name,
                age = user.age,
            )
        }
    }

    // init을 쓰는 것보단 부생성자를 쓰는게 좋다
//    constructor(user: User): this (
//        id = user.id!!,
//        name = user.name,
//        age = user.age,
//    )


}
