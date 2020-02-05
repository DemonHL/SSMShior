package com.hl.mapper;

import com.hl.entity.user;
import org.springframework.stereotype.Service;

@Service
public interface userMapper {

    user selectByUserName(String username);

    int deleteByPrimaryKey(Long id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}