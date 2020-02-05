package com.hl.mapper;

import com.hl.entity.role;
import org.springframework.stereotype.Service;

@Service
public interface roleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}