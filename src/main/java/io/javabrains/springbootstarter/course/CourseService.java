package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    List<Course> getAllCourses(String topicId) {
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    Course getCourse(String id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    void addCourse(Course course) {
        courseRepository.save(course);
    }

    void updateCourse(Course course) { courseRepository.save(course);}

    void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
