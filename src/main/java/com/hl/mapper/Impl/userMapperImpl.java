/***
 * CopyRight(C), 2018-2020
 * FileName:   userMapperImpl
 * Author:     
 * Date:       2020/2/5 0:02
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.mapper.Impl;

import com.hl.entity.user;
import com.hl.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userMapperImpl implements userMapper{

    @Autowired
    userMapper um;

    @Override
    public user selectByUserName(String username) {
        return um.selectByUserName(username);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(user record) {
        return 0;
    }

    @Override
    public int insertSelective(user record) {
        return 0;
    }

    @Override
    public user selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(user record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(user record) {
        return 0;
    }



}
