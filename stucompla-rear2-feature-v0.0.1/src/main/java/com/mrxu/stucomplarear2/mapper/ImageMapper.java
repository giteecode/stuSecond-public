package com.mrxu.stucomplarear2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mrxu.stucomplarear2.entity.Image;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Mr.Xu
 * @since 2022-01-23
 */
@Component
public interface ImageMapper extends BaseMapper<Image> {

    @Update("update image set state = '0' where id = #{imageId}")
    int deleteImageByUpdateSteta(String imageId);
}
