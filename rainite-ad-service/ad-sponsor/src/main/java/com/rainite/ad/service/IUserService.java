package com.rainite.ad.service;

import com.rainite.ad.exception.AdException;
import com.rainite.ad.vo.CreateUserRequest;
import com.rainite.ad.vo.CreateUserResponse;

public interface IUserService {
    // Create a user
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
