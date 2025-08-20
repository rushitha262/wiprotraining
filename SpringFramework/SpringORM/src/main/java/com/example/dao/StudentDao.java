package com.example.dao;

import com.example.model.Student;
import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void update(Student student);
    void delete(Long id);
}