package com.slowgenius.mapper;

import com.slowgenius.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author slowgenius
 * @date 2/24/2020 12:17 AM
 * @description
 */
@Mapper
public interface UserMapper {

    User selectByPrimaryKey(Integer id);


}
