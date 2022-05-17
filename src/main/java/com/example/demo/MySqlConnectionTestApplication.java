package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MySqlConnectionTestApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MySqlConnectionTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO users (fullname, email, password) VALUES (?, ?, ?)";
//
//		String date = new SimpleDateFormat("yyyy-MM-dd")
//				.format(new Date(request.getParameter("date")));
		String sql = "INSERT INTO Admin (time_added) VALUES (?)";
//		int result = jdbcTemplate.update(sql, "wale", "wale@gmail.com", "Panda1");
		int result = jdbcTemplate.update(sql,  "testTime");
//
//		if(result > 0){
//			System.out.println("A new row has been inserted");
//		}



	}
}
