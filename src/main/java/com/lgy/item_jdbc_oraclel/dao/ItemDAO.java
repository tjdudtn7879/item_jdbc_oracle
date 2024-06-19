package com.lgy.item_jdbc_oraclel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.item_jdbc_oracle.dto.ItemDTO;
import com.lgy.item_jdbc_oracle.util.Constant;




public class ItemDAO {
//	DataSource dataSource;
	
	JdbcTemplate template=null;
	
	public ItemDAO() {
		template=Constant.template;
	}
	
	/*
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public void write(final String name, final int price, final String description) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String sql = "insert into item(name, price, description) "
						+ "values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				
				
				return pstmt;
			}
		});
		
		/*
	}
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into item(name, price, description) "
								  + "values(?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, description);
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null){pstmt.close(); }
				if(conn != null){conn.close(); }
			}catch(Exception se){
				se.printStackTrace();
			}
			
			*/
		}
		
		
	
	
//	게시판 목록 조회(type parameter : 게시글 객체)
	public ArrayList<ItemDTO> list() {
		
		return (ArrayList<ItemDTO>) template.query("select name, price, description from item", new BeanPropertyRowMapper(ItemDTO.class));
		
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name, price, description from item";
		ArrayList<ItemDTO> dtos = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name =rs.getString("name");
				int price =rs.getInt("price");
				String description =rs.getString("description");
				
//				하나의 게시글 객체
				ItemDTO dto = new ItemDTO(name, price, description);
//				게시글을 추가(dtos : 여러 게시글이 될수 있음)
				dtos.add(dto);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null){rs.close(); }
				if(pstmt != null){pstmt.close(); }
				if(conn != null){conn.close(); }
			}catch(Exception se){
				se.printStackTrace();
			}
		}
		
		return dtos;
		
		*/
	}
}
