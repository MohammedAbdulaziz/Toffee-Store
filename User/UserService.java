// package User;

// public class UserService {
// private UserRepository userRepository;

// public UserService(UserRepository userRepository) {
// this.userRepository = userRepository;
// }

// public void register(String username, String password) throws
// UserRegistrationException {
// if (userRepository.exists(username)) {
// throw new UserRegistrationException("User with this username already
// exists");
// }
// User user = new User(username, password);
// userRepository.create(user);
// }

// public User login(String username, String password) throws UserLoginException
// {
// User user = userRepository.findByUsername(username);
// if (user == null || !user.getPassword().equals(password)) {
// throw new UserLoginException("Invalid username or password");
// }
// return user;
// }

// }
