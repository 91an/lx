
package cn.tedu.store.entity;

import java.util.Date;

/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月28日 上午9:15:36 

* 类说明 

*/

public class Order extends BaseEntity{
	private static final long serialVersionUID = 5568253630367575971L;
	
	private Integer oid;
	private Integer uid;
	private String recvName;
	private String recvPhone;
	private String recvProvince;
	private String recvCity;
	private String recvArea;
	private String recvAddress;
	private Integer totalPrice;
	private Date orderTime;
	private Date payTime;
	private Integer status;
	/**
	 * @return the oid
	 */
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * @return the recvName
	 */
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	/**
	 * @return the recvPhone
	 */
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	/**
	 * @return the recvProvince
	 */
	public String getRecvProvince() {
		return recvProvince;
	}
	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}
	/**
	 * @return the recvCity
	 */
	public String getRecvCity() {
		return recvCity;
	}
	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}
	/**
	 * @return the recvArea
	 */
	public String getRecvArea() {
		return recvArea;
	}
	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}
	/**
	 * @return the recvAddress
	 */
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	/**
	 * @return the totalPrice
	 */
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return the orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * @return the payTime
	 */
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((payTime == null) ? 0 : payTime.hashCode());
		result = prime * result + ((recvAddress == null) ? 0 : recvAddress.hashCode());
		result = prime * result + ((recvArea == null) ? 0 : recvArea.hashCode());
		result = prime * result + ((recvCity == null) ? 0 : recvCity.hashCode());
		result = prime * result + ((recvName == null) ? 0 : recvName.hashCode());
		result = prime * result + ((recvPhone == null) ? 0 : recvPhone.hashCode());
		result = prime * result + ((recvProvince == null) ? 0 : recvProvince.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (payTime == null) {
			if (other.payTime != null)
				return false;
		} else if (!payTime.equals(other.payTime))
			return false;
		if (recvAddress == null) {
			if (other.recvAddress != null)
				return false;
		} else if (!recvAddress.equals(other.recvAddress))
			return false;
		if (recvArea == null) {
			if (other.recvArea != null)
				return false;
		} else if (!recvArea.equals(other.recvArea))
			return false;
		if (recvCity == null) {
			if (other.recvCity != null)
				return false;
		} else if (!recvCity.equals(other.recvCity))
			return false;
		if (recvName == null) {
			if (other.recvName != null)
				return false;
		} else if (!recvName.equals(other.recvName))
			return false;
		if (recvPhone == null) {
			if (other.recvPhone != null)
				return false;
		} else if (!recvPhone.equals(other.recvPhone))
			return false;
		if (recvProvince == null) {
			if (other.recvProvince != null)
				return false;
		} else if (!recvProvince.equals(other.recvProvince))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvProvince=" + recvProvince + ", recvCity=" + recvCity + ", recvArea=" + recvArea
				+ ", recvAddress=" + recvAddress + ", totalPrice=" + totalPrice + ", orderTime=" + orderTime
				+ ", payTime=" + payTime + ", status=" + status + ", getCreatedUser()=" + getCreatedUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	
	
}

