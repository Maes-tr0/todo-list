package ua.maestr0.todolist.repository;

import org.springframework.stereotype.Repository;
import ua.maestr0.todolist.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class NoteRepository {
    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public void add(Note note) {
        note.setId(idGenerator.incrementAndGet());
        notes.add(note);
    }

    public void deleteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public void update(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(note.getId())) {
                notes.set(i, note);
                return;
            }
        }
    }

    public Note getById(Long id) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes);
    }
}
