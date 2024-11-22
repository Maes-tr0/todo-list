package ua.maestr0.todolist.service;

import org.springframework.stereotype.Service;
import ua.maestr0.todolist.model.Note;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {
    private final Map<Long, Note> notes;
    private final Random idGenerator;

    public NoteService() {
        notes = new LinkedHashMap<>();
        idGenerator = new Random();
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        note.setId(generateUniqueId());
        return notes.put(note.getId(), note);
    }

    public void deleteById(long id) {
        isExistId(id);
        notes.remove(id);
    }

    public Note getById(long id) {
        isExistId(id);
        return notes.get(id);
    }

    public void update(Note note) {
        Long id = note.getId();
        isExistId(id);
        notes.put(id, note);
    }

    private void isExistId(Long id) {
        if (notes.containsKey(id)) {
            throw new IllegalArgumentException("Note id " + id + " not exists");
        }
    }

    private Long generateUniqueId() {
        Long id;
        do {
            id = (long) (idGenerator.nextInt(Integer.MAX_VALUE) + 1);
        } while (notes.containsKey(id));
        return id;
    }
}
