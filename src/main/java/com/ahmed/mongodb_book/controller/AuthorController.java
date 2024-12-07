package com.ahmed.mongodb_book.controller;

import com.ahmed.mongodb_book.model.Author;
import com.ahmed.mongodb_book.service.AuthorServ;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorServ autherServ;

    public AuthorController(AuthorServ autherServ) {
        super();
        this.autherServ = autherServ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        return ResponseEntity.ok(autherServ.findByid(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(autherServ.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {

        return ResponseEntity.ok(autherServ.insert(entity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity) {

        return ResponseEntity.ok(autherServ.update(entity));
    }

    @PutMapping("/custom")
    public ResponseEntity<?> updateEmail(@RequestParam @Email String email, @RequestParam String name,
                                         @RequestParam String phone) {

        autherServ.updateEmail(email, name, phone);

        return ResponseEntity.ok(null);
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {

        return ResponseEntity.ok(autherServ.findAuthorByEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        autherServ.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
