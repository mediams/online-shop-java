package de.telran.onlineshopgarden.service;

import de.telran.onlineshopgarden.mapper.UserMapper;
import de.telran.onlineshopgarden.repository.CartRepository;
import de.telran.onlineshopgarden.repository.FavoriteRepository;
import de.telran.onlineshopgarden.repository.UserRepository;
import de.telran.onlineshopgarden.security.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper mapper;
    @Mock
    private OrderService orderService;
    @Mock
    private FavoriteRepository favoriteRepository;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthService authService;

    @InjectMocks
    private UserService service;

    @Test
    void getAll() {
        service.getAll();

        verify(repository, times(1)).findAll();
        verify(mapper).entityListToDto(any());
    }
}