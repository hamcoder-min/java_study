package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class DepartmentDao extends DBConn{
	public DepartmentDao() {
		super();
	}
	
	// 3단계 : CRUD 기능에 따라 메소드 생성
	
	public boolean insert(DepartmentVo department) {
		boolean result = false;
		try {
			String sql = """
					insert into department(dept_id, dept_name, unit_id, start_date)
								values(?, ?, ?, curdate())
				""";
			getPreparedStatement(sql);
			pstmt.setString(1, department.getDeptId());
			pstmt.setString(2, department.getDeptName());
			pstmt.setString(3, department.getUnitId());
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) result = true;
			
//			getStatement();
//			if(stmt != null) {
//				StringBuilder sb = new StringBuilder();
//				sb.append("insert into department(dept_id, dept_name, unit_id, start_date)");
//				sb.append(" values('");
//				sb.append(department.getDeptId() + "','");
//				sb.append(department.getDeptName() + "','");
//				sb.append(department.getUnitId() + "',");
//				sb.append(" curdate() )");
//				
//				int resultRow = stmt.executeUpdate(sb.toString());
//				if(resultRow == 1) result = true;
//			}
		} catch (Exception e) { e.printStackTrace(); }
		return result;
	}
	
	/**
	 * 전체 리스트
	 */
	public List<DepartmentVo> getList() {
		List<DepartmentVo> list = new ArrayList<DepartmentVo>();
		String sql = """
					select	dept_id
							, dept_name
							, unit_id
							, start_date
					from	department
				""";
		try {
			getStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//rs 객체의 1 row --> DepartmentVo 저장
				DepartmentVo department = new DepartmentVo();
					department.setDeptId(rs.getString(1));
					department.setDeptName(rs.getString(2));
					department.setUnitId(rs.getString(3));
					department.setStartDate(rs.getString(4));
				
				list.add(department);
			}
		} catch (Exception e) { e.printStackTrace(); }
		close();
		return list;
	}
}

