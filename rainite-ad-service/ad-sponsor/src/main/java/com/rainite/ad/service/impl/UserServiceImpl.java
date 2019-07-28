package com.rainite.ad.service.impl;

import com.rainite.ad.constant.Constants;
import com.rainite.ad.dao.AdUserRepository;
import com.rainite.ad.entity.AdUser;
import com.rainite.ad.exception.AdException;
import com.rainite.ad.service.IUserService;
import com.rainite.ad.utils.CommonUtils;
import com.rainite.ad.vo.CreateUserRequest;
import com.rainite.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        //1. 验证传入参数
        if(!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //2. 查同名用户
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException((Constants.ErrorMsg.SAME_NAME_ERROR));
        }
        //3. 获取新的token创建新的用户
        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));
        //4. 通过request返回response
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
