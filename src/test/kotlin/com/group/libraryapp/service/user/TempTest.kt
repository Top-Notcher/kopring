package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.util.TxHelper
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TempTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository,
//    private val userLoanHistoryRepository: UserLoanHistoryRepository,
    private val txHelper: TxHelper,
) {

    @Test
    fun `유저 1명과 책 2권을 저장하고 대출한다`() {
        // when
        userService.saveUserAndLoanTwoBooks()

        // then
        txHelper.exec {
            val users = userRepository.findAllWithHistories()
            assertThat(users).hasSize(1)
            assertThat(users[0].userLoanHistories).hasSize(2)
        }

//        val histories = userLoanHistoryRepository.findAll()
//        assertThat(histories).hasSize(2)
//        assertThat(histories[0].user.id).isEqualTo(users[0].id)
    }
}