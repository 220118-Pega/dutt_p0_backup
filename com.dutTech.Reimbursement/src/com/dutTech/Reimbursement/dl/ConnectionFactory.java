package com.dutTech.Reimbursement.dl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import org.apache.logging.log4j.LogManager;

public class ConnectionFactory {
	
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties prop = new Properties();
	private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(this.getClass());
	
	static {
		try {		
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			prop.load(loader.getResourceAsStream("db.properties"));
		}catch(IOException e){
			e.printStackTrace();
			logger.error("Can't find db.props file");
		}
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Can't get connection");
		}
		return conn;
	}
		
	}

