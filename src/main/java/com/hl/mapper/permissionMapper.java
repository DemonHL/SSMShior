package com.hl.mapper;

import com.hl.entity.permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface permissionMapper {

    List<String> selectAllResource();

    int deleteByPrimaryKey(Long id);

    int insert(permission record);

    int insertSelective(permission record);

    permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);
}