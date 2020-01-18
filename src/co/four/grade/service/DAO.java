package co.four.grade.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DAO{ //서장원
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	private String driver;
	private String url;
	private String user;
	private String password;

	public DAO(){
		getConfiguration(); 
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

	private void getConfiguration(){
		Properties properties = new Properties();
		try{
			Reader read = new FileReader("config/db.properties");
			properties.load(read);

			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
