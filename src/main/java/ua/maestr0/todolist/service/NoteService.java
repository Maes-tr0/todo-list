package ua.maestr0.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.maestr0.todolist.model.Note;
import ua.maestr0.todolist.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public void createNote(Note note) {
        noteRepository.add(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public void updateNote(Note note) {
        noteRepository.update(note);
    }

    public Note getNote(Long id) {
        return noteRepository.getById(id);
    }

    public List<Note> getAllNotes() {
        return noteRepository.listAll();
    }
}
