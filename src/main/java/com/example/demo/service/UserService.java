package com.example.demo.service;
 

import java.sql.SQLException;

public interface UserService {

    void save();
    void save(String userId)throws Exception;
    void update();
    void delete();
    void find();
}