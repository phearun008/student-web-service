package student.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import student.entity.Student;
import student.service.StudentService;


@RestController	
@RequestMapping("/api/student")
public class StudentController {

	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAll(){
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("MESSAGE", "");
		map.put("DATA", studentService.findAll());
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> saveStudent(@RequestBody Student student){
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("MESSAGE", "SUCCESS");
		map.put("STATUS", studentService.save(student));
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
