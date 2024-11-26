package ua.maestr0.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.maestr0.todolist.model.Note;
import ua.maestr0.todolist.service.NoteService;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        noteService.deleteNote(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam(required = false) Long id, Model model) {
        Note note = (id != null) ? noteService.getNote(id) : new Note();
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        if (note.getId() != null) {
            noteService.updateNote(note);
        } else {
            noteService.createNote(note);
        }
        return "redirect:/note/list";
    }
}
