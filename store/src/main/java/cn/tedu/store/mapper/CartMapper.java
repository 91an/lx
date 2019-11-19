
package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月25日 上午10:49:46 

* 类说明 

*/

public interface CartMapper {
	/**
	 * 为购物车插入新的数据
	 */
	Integer addNew(Cart cart);
	
	/**
	 * 更新购物车内已有商品的数量
	 * @param cid 购物车数据的id
	 * @param num 商品的数量
	 */
	Integer updateNumByCid(@Param("cid") Integer cid,
							@Param("num") Integer num,
							@Param("modifiedUser") String modifiedUser,
							@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 查询购物车内是否有哪条数据既是该用户且是该商品判断
	 */
	Cart findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);
	
	/**
	 * 显示购物车列表
	 */
	List<CartVO> findVOByUid(Integer uid);
	
	/**
	 * 更新前检查数据
	 */
	Cart findByCid(Integer cid);
	
	List<CartVO> findVOByCids(Integer[] cids);
}

