package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.product.model.Phone;
import com.ssafy.util.DBUtil;

@Repository
public class PhoneDAOImpl implements IPhoneDAO {
	@Autowired
	private DBUtil dbUtil;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void insert(Map<String, String> map) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("insert  into Phones \n");
			registerArticle.append("values(?,?,?,?)");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setString(1, map.get("num"));
			pstmt.setString(2, map.get("model"));
			pstmt.setInt(3, Integer.parseInt(map.get("price")));
			pstmt.setInt(4, Integer.parseInt(map.get("vcode")));
			
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<Phone> list() throws Exception {
		List<Phone> list = new ArrayList<Phone>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select p.num, p.model, p.price, c.vendor, p.vcode \n");
			sql.append("from Phones p\n");
			sql.append("join company c \n");
			sql.append("on p.vcode = c.vcode");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Phone item = new Phone();
				item.setNum(rs.getString("num"));
				item.setMode(rs.getString("model"));
				item.setPrice(rs.getInt("price"));
				item.setVendor(rs.getString("vendor"));
				item.setVcode(rs.getInt("vcode"));
				
				list.add(item);
				
			}
			
			
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public void delete(String num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("delete from Phones \n");
			registerArticle.append("where num = ?");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public Phone viewone(String num) throws Exception {
		Phone item = new Phone();
		System.out.println(num);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select p.num, p.model, p.price, c.vendor, p.vcode \n");
			sql.append("from Phones p\n");
			sql.append("join company c \n");
			sql.append("on p.vcode = c.vcode \n");
			sql.append("where p.num=? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				item = new Phone();
				item.setNum(rs.getString("num"));
				item.setMode(rs.getString("model"));
				item.setPrice(rs.getInt("price"));
				item.setVendor(rs.getString("vendor"));
				item.setVcode(rs.getInt("vcode"));
				
			}
			
			
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return item;
	}

	@Override
	public boolean login(Map<String, String> map) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select id, pw \n");
			loginMember.append("from user \n");
			loginMember.append("where id = ? and pw= ? \n");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return flag;
	}
}
