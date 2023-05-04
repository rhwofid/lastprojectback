package project.service;

import java.util.List;

import project.dto.TravelcourseDto;

public interface ProjectService {

public int insertCourse(TravelcourseDto travelcourseDto) throws Exception;

	TravelcourseDto selectCourseDetail(int travelcourseIdx)throws Exception;

	List<TravelcourseDto> selectCourseList() throws Exception;

	int updateCourse(TravelcourseDto travelcourseDto) throws Exception;

	void deleteCourse(int travelcourseIdx) throws Exception;

}
