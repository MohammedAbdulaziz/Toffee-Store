package User;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String username, String password) throws UserRegistrationException {
        if (userRepository.exists(username)) {
            throw new UserRegistrationException();
        }
        User user = new User(username, password, );
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
