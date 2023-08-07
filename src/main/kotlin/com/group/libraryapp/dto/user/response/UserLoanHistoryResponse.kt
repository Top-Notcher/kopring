package com.group.libraryapp.dto.user.response

data class UserLoanHistoryResponse(
    val name: String,   // 유저 이름
    val books: List<BookHistoryResposne>
) {
}

data class BookHistoryResposne(
    val name: String,   // 책의 이름
    val isReturn: Boolean,
)