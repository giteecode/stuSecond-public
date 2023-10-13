package com.mrxu.stucomplarear2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mrxu.stucomplarear2.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Xu
 * @since 2021-12-01
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("select user_id from user where username = #{username}")
    String selectUserIdByUsername(String username);

}
