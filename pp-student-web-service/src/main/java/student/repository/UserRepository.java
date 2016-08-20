package student.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import student.entity.user.Role;
import student.entity.user.User;

@Repository
public interface UserRepository {

	@Select("SELECT id, username, email, password, status FROM tbuser WHERE email=#{email}")
	@Results(value = {
		@Result(property="id", column="id"),
		@Result(property="roles", column="id", many = @Many(select="findRolesByUserId"))
	})
	public User findUserByEmail(String email);

	@Select("SELECT role_id, name FROM tbuser_detail ud INNER JOIN tbrole r ON ud.role_id = r. ID WHERE ud.user_id = #{id}")
	@Results({
		@Result(property="id", column="role_id"),
		@Result(property="name", column="name"),
	})
	public List<Role> findRolesByUserId(@Param("id") int id);
}
