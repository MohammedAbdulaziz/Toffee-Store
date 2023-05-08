package User;

public interface UserRepository {
    boolean exists(String email);

    void create(User user);

    void update(User user);

    User findByEmail(String email);
}
