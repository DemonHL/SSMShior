package com.hl.mapper;

import com.hl.entity.permission;
import com.hl.entity.person;
import org.springframework.stereotype.Service;


public interface personMapper {



    person selectByPrimaryKey(Integer id);

}