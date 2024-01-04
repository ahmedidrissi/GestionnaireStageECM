package com.example.gestionnairestageecm.controllers;

import com.example.gestionnairestageecm.models.Prof;
import com.example.gestionnairestageecm.models.ResponseMsg;
import com.example.gestionnairestageecm.services.ProfServices;
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

    private final ProfServices profServices;


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



    @GetMapping("user/{numero_prof}")
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

    @PutMapping("upd")
    public ResponseEntity<ResponseMsg> updateTask(@RequestBody  Prof prof) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.update(prof)))
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

    @GetMapping("get/{profid}")
    public ResponseEntity<ResponseMsg> getTask(@PathVariable Long profid) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return ResponseEntity.ok(
                ResponseMsg.builder()
                        .timeStamp(now())
                        .data(of("prof",profServices.get(profid)))
                        .message("prof a etait affiche")
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
