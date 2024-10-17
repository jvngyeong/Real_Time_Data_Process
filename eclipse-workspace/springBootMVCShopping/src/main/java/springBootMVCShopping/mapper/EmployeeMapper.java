package springBootMVCShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {

	public void employeeWrite(EmployeeDTO dto);

	public List<EmployeeDTO> employeeSelectList(StartEndPageDTO sepDTO);

	public EmployeeDTO employeeSelectOne(String empNum);

	public void employeeUpdate(EmployeeDTO dto);

	public void employeeDelete(String empNum);

	public void employeesDelete(String[] empNums);

	public int employeeCount();
}
