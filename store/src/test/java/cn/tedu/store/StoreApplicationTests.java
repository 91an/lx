package cn.tedu.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	public DataSource dataSource;
	
	
	@Test
	public void getConnection() throws SQLException{
		System.err.println("11");
		Connection conn = dataSource.getConnection();
		System.err.println(conn);
	}
	
	public static void main(String[] args) {
		//原始密码
		String password = "Ha123.";
		//盐值
		String salt = UUID.randomUUID().toString(); //"tedu" + Math.random()*100
		System.err.println(salt);
		//执行加密
		String mdPassword = DigestUtils.md5DigestAsHex((password+salt).getBytes());
		//输出
		System.err.println(mdPassword);
		
	}
	
}
