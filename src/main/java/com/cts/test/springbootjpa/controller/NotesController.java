package com.cts.test.springbootjpa.controller;


import com.cts.test.springbootjpa.model.Note;
import com.cts.test.springbootjpa.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    @PostMapping
    public void addNotes(@RequestBody Note notes){

        noteRepository.save(notes);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNote(@PathVariable(value = "id") Long id){
        Note note = noteRepository.getOne(id);
        return ResponseEntity.ok().body(note);
    }
}
