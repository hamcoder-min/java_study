package chapter20_JDBC;

import java.util.List;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		DepartmentVo insertVo = new DepartmentVo();
		insertVo.setDeptId("XYQ");
		insertVo.setDeptName("테스트");
		insertVo.setUnitId("A");	
		
		if(dao.insert(insertVo)) {
			List<DepartmentVo> list = dao.getList();
			list.forEach((department) -> {
				System.out.print(department.getDeptId() + "\t");
				System.out.print(department.getDeptName() + "\t");
				System.out.print(department.getUnitId() + "\t");
				System.out.print(department.getStartDate() + "\n");
			});
		}
		dao.close();
	}
}
