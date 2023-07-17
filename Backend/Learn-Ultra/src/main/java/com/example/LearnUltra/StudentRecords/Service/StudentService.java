package com.example.LearnUltra.StudentRecords.Service;

import com.example.LearnUltra.StudentRecords.Entity.Student;
import com.example.LearnUltra.StudentRecords.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
       Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("email already exists");
       }
        int totalMarks=600;
        int obtainedMarks = student.getSubjects().getEnglish() + student.getSubjects().getEnvironmentalStudy() + student.getSubjects().getGeography()+student.getSubjects().getPolity()+student.getSubjects().getSociology()+student.getSubjects().getSpanish();
        double result = (double) obtainedMarks / (double) totalMarks;
        if ((result * 100) < 30) {
            student.getSubjects().setStudentGrade("F");
        }

        else if((result * 100) >= 30 && (result * 100) < 50) {
            student.getSubjects().setStudentGrade("C");
        }

        else if ((result * 100) >= 50 && (result * 100) < 75) {
            student.getSubjects().setStudentGrade("B");
        }

        else if ((result * 100) >= 75 && (result * 100) <= 100) {
            student.getSubjects().setStudentGrade("A");
        }
       studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        int totalMarks=600;
        int obtainedMarks = student.getSubjects().getEnglish() + student.getSubjects().getEnvironmentalStudy() + student.getSubjects().getGeography()+student.getSubjects().getPolity()+student.getSubjects().getSociology()+student.getSubjects().getSpanish();
        double result = (double) obtainedMarks / (double) totalMarks;
        if ((result * 100) < 30) {
            student.getSubjects().setStudentGrade("F");
        }

        else if((result * 100) >= 30 && (result * 100) < 50) {
            student.getSubjects().setStudentGrade("C");
        }

        else if ((result * 100) >= 50 && (result * 100) < 75) {
            student.getSubjects().setStudentGrade("B");
        }

        else if ((result * 100) >= 75 && (result * 100) <= 100) {
            student.getSubjects().setStudentGrade("A");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("student with id"+id+"does not exists");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudentById(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("student with id"+id+"does not exist"));
        if(name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email already exists");
            }
            student.setEmail(email);
        }
    }
}
