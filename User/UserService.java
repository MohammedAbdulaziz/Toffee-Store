package User;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String email, String password, String address) throws UserRegistrationException {
        if (userRepository.exists(email)) {
            throw new UserRegistrationException("User with this email already exists");
        }
        User user = new User(email, password, address);
        userRepository.create(user);
    }

    public User login(String email, String password) throws UserLoginException {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new UserLoginException("Invalid email or password");
        }
        return user;
    }

    public void logout(User user) {
        // implementation
    }
}
