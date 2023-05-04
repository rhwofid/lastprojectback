package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.TravelcourseDto;
import project.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public List<TravelcourseDto> selectCourseList() throws Exception {
		return projectMapper.selectCourseList();
	}

	@Override
	public int insertCourse(TravelcourseDto travelcourseDto) throws Exception {
		return projectMapper.insertCourse(travelcourseDto);

	}

	@Override
	public TravelcourseDto selectCourseDetail(int travelcourseIdx) throws Exception {
		return projectMapper.selectCourseDetail(travelcourseIdx);
	}

	@Override
	public int updateCourse(TravelcourseDto travelcourseDto) throws Exception {
	    int updatedCount = projectMapper.updateCourse(travelcourseDto);
	    return updatedCount;
	}
	
	@Override
	public void deleteCourse(int travelcourseIdx) throws Exception {
	    projectMapper.deleteCourse(travelcourseIdx);
	}
}
