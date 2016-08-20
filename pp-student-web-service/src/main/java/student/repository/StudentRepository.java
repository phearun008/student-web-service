package student.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import student.entity.Student;

@Repository
public interface StudentRepository {

	@Insert(SQL.INSERT)
	boolean save(Student student);
	
	@Delete(SQL.DELETE)
	boolean remove(int id);
	
	@Update(SQL.UPDATE)
	boolean update(Student student);
	
	@Select(SQL.SELECT_ALL)
	ArrayList<Student> findAll();
	
	@Select(SQL.SELECT_BY_ID)
	Student findById(int id);
	
	@Select(SQL.SELECT_BY_NAME)
	ArrayList<Student> findByName(String name);
	
	interface SQL{
		
		String INSERT = ""
				+ "	INSERT INTO tbstudent "
				+ "	("	
				+ "		id, "
				+ "		name, "
				+ "		gender, "
				+ "		score"
				+ "	)"
				+ "	VALUES"
				+ "	("
				+ "		 #{id}, "
				+ "		 #{name}, "
				+ "		 #{gender}, "
				+ "		 #{score}	"
				+ "	)	";
		
		String DELETE = ""
				+ "	DELETE"
				+ "		FROM tbstudent"
				+ "	WHERE "
				+ "		id = #{id}";
		
		String UPDATE = ""
				+ "	UPDATE"
				+ "		tbstudent"
				+ "	SET"
				+ "		name = #{name},"
				+ "		gender = #{gender},"
				+ "		score = #{score}"
				+ "	WHERE"
				+ "		id = #{id}";
		
		String SELECT_ALL = ""
				+ "	SELECT"
				+ "		id,"
				+ "		name,"
				+ "		gender,"
				+ "		score	"
				+ "	FROM"
				+ "		tbstudent"
				+ "	ORDER BY"
				+ "		ID DESC";
		
		String SELECT_BY_ID = ""
				+ "	SELECT"
				+ "		id,"
				+ "		name,"
				+ "		gender,"
				+ "		score	"
				+ "	FROM"
				+ "		tbstudent"
				+ "	WHERE "
				+ "		id = #{id}";
		
		String SELECT_BY_NAME = ""
				+ "	SELECT"
				+ "		id,"
				+ "		name,"
				+ "		gender,"
				+ "		score	"
				+ "	FROM"
				+ "		tbstudent"
				+ "	WHERE "
				+ "		LOWER(name) LIKE '%' || LOWER(#{name}) || '%'"
				+ "	ORDER BY"
				+ "		ID DESC";
	}
	
}
