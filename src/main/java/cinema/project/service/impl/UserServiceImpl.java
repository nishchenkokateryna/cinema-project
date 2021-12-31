package cinema.project.service.impl;

import cinema.project.dao.UserDao;
import cinema.project.lib.Inject;
import cinema.project.lib.Service;
import cinema.project.model.User;
import cinema.project.service.UserService;
import cinema.project.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
