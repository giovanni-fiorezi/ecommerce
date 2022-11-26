package br.com.projeto.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.service.OrderedService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/ordered")
public class OrderedController {

    @Autowired
    private OrderedService orderedService;

    @GetMapping("/listAll")
    public ResponseEntity<List<OrderedDto>> listAll(){
        this.orderedService.listAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{numberOrdered}")
    public ResponseEntity<OrderedDto> findByNumberOrdered(@PathVariable(value = "/numberOrdered") Integer numberOrdered){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderedService.findByOrderedNumber(numberOrdered));
    }

    @GetMapping("/dateOrdered")
    public ResponseEntity<List<OrderedDto>> findOrderedByDate(@PathVariable(value = "/dateOrdered")LocalDateTime date){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderedService.findByDate(date));
    }

    @PostMapping("/insert")
    public ResponseEntity<OrderedDto> insertOrdered(@RequestBody OrderedDto orderedDto){
        OrderedDto ordered = this.orderedService.insert(orderedDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordered);
    }

    @PutMapping("/update/{orderedNumber}")
    public ResponseEntity<String> updateOrdered(@RequestBody OrderedDto orderedDto, Integer orderedNumber) {
        this.orderedService.update(orderedDto, orderedNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{orderedNumber}")
    public ResponseEntity<Void> deleteOrdered(@PathVariable(value = "/orderedNumber") Integer orderedNumber){
        this.orderedService.deleteOrdered(orderedNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
