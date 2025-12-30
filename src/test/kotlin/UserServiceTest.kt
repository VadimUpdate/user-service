import com.bank.user.dto.CreateUserRequest
import com.bank.user.repository.UserRepository
import com.bank.user.service.UserService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val repo = mockk<UserRepository>()
    private val service = UserService(repo)

    @Test
    fun `create user successfully`() {
        every { repo.existsByEmail(any()) } returns false
        every { repo.save(any()) } answers { firstArg() }

        val user = service.createUser(
            CreateUserRequest("test@mail.com", "John Doe")
        )

        assertEquals("test@mail.com", user.email)
    }
}
