package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory

data class UserLoanHistoryResponse(
    val name: String,   // 유저 이름
    val books: List<BookHistoryResposne>
) {
    companion object {
        fun of(user: User): UserLoanHistoryResponse {
            return UserLoanHistoryResponse(
                name = user.name,
                books = user.userLoanHistories.map(BookHistoryResposne::of)
            )
        }
    }
}

data class BookHistoryResposne(
    val name: String,   // 책의 이름
    val isReturn: Boolean,
){
    companion object {
        fun of(history: UserLoanHistory): BookHistoryResposne {
            return BookHistoryResposne(
                name = history.bookName,
                isReturn = history.isReturn
            )
        }
    }
}