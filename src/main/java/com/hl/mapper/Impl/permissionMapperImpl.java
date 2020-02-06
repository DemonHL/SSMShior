/***
 * CopyRight(C), 2018-2020
 * FileName:   permissionMapperImpl
 * Author:     
 * Date:       2020/2/6 0:50
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.mapper.Impl;

import com.hl.entity.permission;
import com.hl.mapper.permissionMapper;
import com.hl.mapper.personMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class permissionMapperImpl implements permissionMapper {

    @Autowired
    permissionMapper pm;

    @Override
    public List<String> selectAllResource() {
        return pm.selectAllResource();
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(permission record) {
        return pm.insert(record);
    }

    @Override
    public int insertSelective(permission record) {
        return pm.insertSelective(record);
    }

    @Override
    public permission selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(permission record) {
        return 0;
    }
}
