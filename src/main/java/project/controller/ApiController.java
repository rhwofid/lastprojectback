package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.dto.TravelcourseDto;
import project.service.ProjectService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {

	private static final String TravelcourseDto = null;
	@Autowired
	private ProjectService projectService;

	@GetMapping("/api/course")
	public ResponseEntity<List<TravelcourseDto>> openCourseList() throws Exception {
		List<TravelcourseDto> list = projectService.selectCourseList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/api/course/write")
	public ResponseEntity<String> insertCourse(
//			@Parameter(description="게시물 정보를 담고 있는 객체", required=true)
			@RequestBody TravelcourseDto travelcourseDto) throws Exception {
		int insertedCount = 0;
		try {
			insertedCount = projectService.insertCourse(travelcourseDto);
			System.out.println(">>>>>>>>>" + insertedCount);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록오류");
		}
		return ResponseEntity.status(HttpStatus.OK).body("정상처리");
	}

	@GetMapping("/api/course/{travelcourseIdx}")
	public ResponseEntity<String> openCourseDetail1(@PathVariable("travelcourseIdx") int travelcourseIdx)
			throws Exception {
		TravelcourseDto travelcourseDto = projectService.selectCourseDetail(travelcourseIdx);
		if (travelcourseDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(TravelcourseDto);
		}
	}

	@PutMapping("/api/course/{travelcourseIdx}")
	public ResponseEntity<Integer> updateCourse(@PathVariable("travelcourseIdx") int travelcourseIdx,
			@RequestBody TravelcourseDto travelcourseDto) throws Exception {
		travelcourseDto.setTravelcourseIdx(travelcourseIdx);
		int updatedCount = projectService.updateCourse(travelcourseDto);
		if (updatedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
		}
	}

	@DeleteMapping("/api/course/{travelcourseIdx}")
	public void deleteCourse(@PathVariable("travelcourseIdx") int travelcourseIdx) throws Exception {
		projectService.deleteCourse(travelcourseIdx);
	}
}
