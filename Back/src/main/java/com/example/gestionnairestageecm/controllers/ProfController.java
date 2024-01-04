package com.example.gestionnairestageecm.controllers;

import com.example.gestionnairestageecm.models.Prof;
import com.example.gestionnairestageecm.models.ResponseMsg;
import com.example.gestionnairestageecm.services.ProfService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/profs")
public class ProfController {

    private final ProfService profServices;


    @GetMapping("/list")
    public ResponseEntity<ResponseMsg> getProfs() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("Professeurs",profServices.Profs(10)))
                        .message("Professeur sont arrivee")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



    @GetMapping("/id={numero_prof}")
    public ResponseEntity<ResponseMsg> getProfById(@PathVariable Long numero_prof) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("professeur",profServices.get(numero_prof)))
                        .message("Prof est  arrive")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/name={first}+{last}")
    public ResponseEntity<ResponseMsg> getByName(@PathVariable String first , @PathVariable String last) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.getByName(first,last)))
                        .message("prof a etait affiche")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("upd/id={id}")
    public ResponseEntity<ResponseMsg> updateTask(@PathVariable Long id,@RequestBody  Prof prof) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.update(id,prof)))
                        .message("prof est mis a jour (Updated)")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("create")
    public ResponseEntity<ResponseMsg> create(@RequestBody Prof prof) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.create(prof)))
                        .message("prof est cree.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseMsg> deleteTask(@PathVariable Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.delete(id)))
                        .message("prof est supprime")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}