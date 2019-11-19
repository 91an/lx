
package cn.tedu.store.entity;


/** 
* @author 作者 Your-Name: Bard
* @version 创建时间：2019年10月12日 上午11:34:07 

* 类说明 
* 用户数据的实体类

*/

public class User extends BaseEntity{
	
	private static final long serialVersionUID = -6236210950748302627L;
	
	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private Integer gender;
	private String phone;
	private String email;
	private String avatar;
	private Integer isDelete;
	
	
	
	public User() {
		super();
	}
	public User(Integer uid, String username, Integer gender, String phone, String avatar) {
		super();
		this.uid = uid;
		this.username = username;
		this.gender = gender;
		this.phone = phone;
		this.avatar = avatar;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the avator
	 */
	public String getAvator() {
		return avatar;
	}
	public void setAvator(String avator) {
		this.avatar = avator;
	}
	/**
	 * @return the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", gender="
				+ gender + ", phone=" + phone + ", email=" + email + ", avator=" + avatar + ", isDelete=" + isDelete
				+ ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	public User(String phone, String email, Integer gender) {
		super();
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}
	
	
}

