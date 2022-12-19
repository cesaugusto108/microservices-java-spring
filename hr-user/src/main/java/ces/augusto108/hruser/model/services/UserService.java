package ces.augusto108.hruser.model.services;

import ces.augusto108.hruser.model.entities.Role;
import ces.augusto108.hruser.model.entities.User;
import ces.augusto108.hruser.model.repositories.UserRepository;
import ces.augusto108.hruser.model.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "Not found. Id: " + id + ", Type: " + User.class.getName()
                )
        );
    }

    public User findByEmail(String email) {
        User u = userRepository.findByEmail(email);

        if (u != null) return u;
        else throw new NotFoundException("Not found. Email: " + email + ", Type: " + User.class.getName());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(Long id, String name, String email, String password, String... roleSet) {
        User u = new User(id, name, email, password);

        Set<Role> userRoles = new HashSet<>();

        for (String role : roleSet) {
            long roleId = 0L;

            if (role.equals("ROLE_OPERATOR")) roleId = 1L;
            if (role.equals("ROLE_ADMIN")) roleId = 2L;

            Role r = new Role(roleId, role);

            userRoles.add(r);
        }

        u.setRoles(userRoles);

        userRepository.save(u);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
