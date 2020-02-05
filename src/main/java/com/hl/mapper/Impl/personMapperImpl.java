/***
 * CopyRight(C), 2018-2020
 * FileName:   personMapperImpl
 * Author:     
 * Date:       2020/2/4 20:10
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.mapper.Impl;

import com.hl.entity.person;
import com.hl.mapper.personMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personMapperImpl implements personMapper {

    @Autowired
    personMapper pm;

    @Override
    public person selectByPrimaryKey(Integer id) {
        return  pm.selectByPrimaryKey(id);
    }
}
