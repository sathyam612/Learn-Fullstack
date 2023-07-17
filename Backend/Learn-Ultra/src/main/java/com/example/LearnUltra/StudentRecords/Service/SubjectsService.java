package com.example.LearnUltra.StudentRecords.Service;

import com.example.LearnUltra.StudentRecords.Entity.Subjects;
import com.example.LearnUltra.StudentRecords.Repo.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectsService {

    private final SubjectsRepository subjectsRepository;

    @Autowired
    public SubjectsService(SubjectsRepository subjectsRepository){
        this.subjectsRepository = subjectsRepository;
    }

    public List<Subjects> getMarks(){
        return subjectsRepository.findAll();
    }

    public Optional<Subjects> getMarksById(Long id){
        return subjectsRepository.findById(id);
    }

    public void addNewMarks(Subjects subjects){
        int totalMarks=600;
        int obtainedMarks = subjects.getEnglish() + subjects.getEnvironmentalStudy() + subjects.getGeography()+subjects.getPolity()+subjects.getSociology()+subjects.getSpanish();
        double result = (double) obtainedMarks / (double) totalMarks;
        if ((result * 100) < 30) {
            subjects.setStudentGrade("F");
        }

        else if((result * 100) >= 30 && (result * 100) < 50) {
            subjects.setStudentGrade("C");
        }

        else if ((result * 100) >= 50 && (result * 100) < 75) {
            subjects.setStudentGrade("B");
        }

        else if ((result * 100) >= 75 && (result * 100) <= 100) {
            subjects.setStudentGrade("A");
        }

        subjectsRepository.save(subjects);
    }

    public void updateMarks(Subjects subjects){
        int totalMarks=600;
        int obtainedMarks = subjects.getEnglish() + subjects.getEnvironmentalStudy() + subjects.getGeography()+subjects.getPolity()+subjects.getSociology()+subjects.getSpanish();
        double result = (double) obtainedMarks / (double) totalMarks;
        if ((result * 100) < 30) {
            subjects.setStudentGrade("F");
        }

        else if((result * 100) >= 30 && (result * 100) < 50) {
            subjects.setStudentGrade("C");
        }

        else if ((result * 100) >= 50 && (result * 100) < 75) {
            subjects.setStudentGrade("B");
        }

        else if ((result * 100) >= 75 && (result * 100) <= 100) {
            subjects.setStudentGrade("A");
        }

        subjectsRepository.save(subjects);
    }

    public void deleteMarks(Long id){
        boolean exists = subjectsRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Records for id "+id+" does not exists");
        }
        subjectsRepository.deleteById(id);
    }



}
