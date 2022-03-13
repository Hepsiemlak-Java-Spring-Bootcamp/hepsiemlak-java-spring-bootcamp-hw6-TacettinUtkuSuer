package emlakburada.services;

import emlakburada.dto.AuthRequest;
import emlakburada.entity.User;
import emlakburada.entity.enums.UserType;
import emlakburada.repository.AuthRepository;
import emlakburada.service.AuthService;
import emlakburada.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Mock
    private JwtUtil jwtUtil;


    @Test
    public void getTokenUserIsNullTest(){

        Mockito.when(authRepository.findByEmail(any())).thenReturn(null);

        assertThrows(Exception.class,  ()-> authService.getToken(new AuthRequest()));
    }

    private User prepareUser() {
        return new User(1,"email@mail.com","1234", UserType.INDIVIDUAL);
    }
}
