
package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月28日 上午9:46:06 

* 类说明 

*/

public interface OrderMapper {

	/**
	 * 插入订单数据
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	Integer insertOrder(Order Order);
	
	/**
	 * 插入订单商品数据
	 * @param order 订单商品数据
	 * @return 受影响的行数
	 */
	Integer insertOrderItem(OrderItem orderItem);
}

