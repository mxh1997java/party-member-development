package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findAllUser() throws Exception;

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    User findOne(User user) throws RuntimeException;

    int addUser(User user) throws RuntimeException;

    int modifyUser(User user) throws RuntimeException;

    int deleteUser(Long userId) throws RuntimeException;

    boolean login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws RuntimeException;

}
