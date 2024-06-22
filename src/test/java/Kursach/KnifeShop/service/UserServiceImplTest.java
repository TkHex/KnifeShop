package Kursach.KnifeShop.service;

import Kursach.KnifeShop.exceptions.UsernameAlreadyExistsException;
import Kursach.KnifeShop.model.User;
import Kursach.KnifeShop.model.UserAuthority;
import Kursach.KnifeShop.model.UserRole;
import Kursach.KnifeShop.repository.UserRepository;
import Kursach.KnifeShop.repository.UserRolesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRolesRepository userRolesRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registration_Successful() {
        String username = "testUser";
        String password = "testPassword";
        User user = new User()
                .setId(1L)
                .setUsername(username)
                .setPassword(password)
                .setLocked(false)
                .setExpired(false)
                .setEnabled(true);
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.registration(username, password);
        verify(userRepository, times(1)).save(any(User.class));
        verify(userRolesRepository, times(1)).save(any(UserRole.class));
    }

    @Test
    void registration_Failure_UsernameAlreadyExists() {
        String username = "existingUser";
        String password = "testPassword";
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(new User()));
        assertThrows(UsernameAlreadyExistsException.class, () -> userService.registration(username, password));
        verify(userRepository, never()).save(any(User.class));
        verify(userRolesRepository, never()).save(any(UserRole.class));
    }

    @Test
    void loadUserByUsername_Successful() {
        String username = "testUser";
        User user = new User()
                .setId(1L)
                .setUsername(username)
                .setPassword("encodedPassword")
                .setLocked(false)
                .setExpired(false)
                .setEnabled(true);
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        User loadedUser = (User) userService.loadUserByUsername(username);
        assertNotNull(loadedUser);
        assertEquals(username, loadedUser.getUsername());
    }

    @Test
    void loadUserByUsername_Failure_UsernameNotFound() {
        String username = "nonExistingUser";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
    }
}
