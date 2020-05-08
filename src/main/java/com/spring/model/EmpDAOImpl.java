package com.spring.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository //스프링에서 일반적으로 DAO클래스에 적용하ㅡㄴ 애노테이션
public class EmpDAOImpl implements EmpDAO{

	@Autowired //의존관계를 자동으로 설정할 때 사용하는 애노테이션.- 의존하는 객체를 삽입해 줌.
	private JdbcTemplate template;
	String sql = null;
	
	@Override
	public List<EmpDTO> getEmpList() {
		// TODO Auto-generated method stub
		List<EmpDTO> list = null;
		sql="select * from emp order by empno";
		return list = template.query(sql, new RowMapper<EmpDTO>() {

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// DTO클래스 객체 생성
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
				dto.setSal(rs.getDouble("sal"));
				dto.setComm(rs.getDouble("comm"));
				return dto;
			}
		});
	}

	@Override
	public EmpDTO empCont(int empno) {//상세내역을 가져오는 메서드
		// 
		
		sql="select * from emp where empno=?";
		
		//queryForObject: 하나의 결과값만 가져올때 사용 
		//query: 결과값이 여러개일때 사용
		return this.template.queryForObject(sql, new RowMapper<EmpDTO>() {

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setDeptno(rs.getInt("deptno"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getDouble("sal"));
				dto.setComm(rs.getDouble("comm"));
				return dto;
			}//전체리스트
		}, empno); //sql문의 ?에 해당하는 부분! 
		
	}

	@Override
	public int empInsert(final EmpDTO dto) {//  들어온 값은 변경되면 안되니까 final 붙이기(중첩클래스공부좀)
		// TODO Auto-generated method stub
		
		sql="insert into emp values (?,?,?,?,sysdate,?,?,?)";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, dto.getEmpno());
				ps.setString(2, dto.getEname());
				ps.setString(3, dto.getJob());
				ps.setInt(4, dto.getMgr());
				ps.setDouble(5, dto.getSal());
				ps.setDouble(6, dto.getComm());
				ps.setInt(7, dto.getDeptno());
			}
		});
	}//empInsert(); end;;

	@Override
	public int empUpdate(final EmpDTO dto) {//사원의 정보를 수정하느 ㄴ메섣,
		// TODO Auto-generated method stub
		
		sql="update emp set sal=?, comm=? where empno=?";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setDouble(1, dto.getSal());
				ps.setDouble(2, dto.getComm());
				ps.setInt(3, dto.getEmpno());
			}
		});
	}//empUpdate() end;

	@Override
	public int empDelete(int empno) {
		// TODO Auto-generated method stub
		
		sql="delete from emp where empno=?";
		return  template.update(sql, empno);
		
	}

}
