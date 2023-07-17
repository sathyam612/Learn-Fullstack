package com.example.LearnUltra.StudentRecords.Controller;

import com.example.LearnUltra.StudentRecords.Entity.Student;
import com.example.LearnUltra.StudentRecords.Entity.Subjects;
import com.example.LearnUltra.StudentRecords.Service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/version1/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(SubjectsService subjectsService){
        this.subjectsService=subjectsService;
    }

    @GetMapping
    public List<Subjects> getAllMarks(){
        return subjectsService.getMarks();
    }

    @GetMapping(path="{id}")
    public Optional<Subjects> getMarksById(@PathVariable("id") Long id){
        return subjectsService.getMarksById(id);
    }

    @PostMapping
    public void addNewMarks(@RequestBody Subjects subjects){
        subjectsService.addNewMarks(subjects);
    }

    @PutMapping
    public void updateMarks(@RequestBody Subjects subjects){
        subjectsService.updateMarks(subjects);
    }

    @DeleteMapping(path="{id}")
    public void deleteMarks(@PathVariable("id") Long id){
        subjectsService.deleteMarks(id);
    }

}
