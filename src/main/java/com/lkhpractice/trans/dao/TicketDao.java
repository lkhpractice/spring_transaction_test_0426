package com.lkhpractice.trans.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lkhpractice.trans.dto.CardDto;

public class TicketDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void buyTicket(final CardDto dto) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				
				String sql = "INSERT INTO card (consumerid, amount) VALUES (?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				
				String sql = "INSERT INTO ticket (consumerid, countnum) VALUES (?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
	
}
