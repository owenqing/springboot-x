package org.owenqing.springboot.x.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.owenqing.springboot.x.entity.OrderInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoDao {

    @Select("SELECT * FROM order_info WHERE id = #{id}")
    OrderInfo queryOrder(@Param("id") Integer id);
}
