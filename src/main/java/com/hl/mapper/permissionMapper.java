package com.hl.mapper;

import com.hl.entity.permission;
import org.springframework.stereotype.Service;

@Service
public interface permissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(permission record);

    int insertSelective(permission record);

    permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);
}