package ua.maestr0.todolist.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.maestr0.todolist.model.Note;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private final Map<Long, Note> notes;

    public NoteService(){
        notes = new LinkedHashMap<>();
    }

    public List<Note> listAll(){
        return notes.values().stream().toList();
    }

    public Note add(Note note){
        return notes.put(note.getId(), note);
    }

    public void deleteById(long id){
        notes.remove(id);
    }

    public Note getById(long id){
        return notes.get(id);
    }

    public void update(Note note){
        notes.put(note.getId(), note);
    }
}
