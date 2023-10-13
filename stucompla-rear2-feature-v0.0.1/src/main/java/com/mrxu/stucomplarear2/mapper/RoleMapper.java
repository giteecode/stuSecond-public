package com.mrxu.stucomplarear2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mrxu.stucomplarear2.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Xu
 * @since 2021-12-01
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select role_name from user natural join role where user_id = #{userId}")
    Set<String> selectRolesByUserId(Integer userId);

    @Select("select role_name from admin natural join role where admin_id = #{adminId}")
    Set<String> selectRolesByAdminId(Integer adminId);
}
