package br.com.projeto.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.dto.OrderedDto;
import br.com.projeto.ecommerce.service.OrderedService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/ordered")
public class OrderedController {

    @Autowired
    private OrderedService orderedService;

    @GetMapping("/numberOrdered")
    public ResponseEntity<OrderedDto> findByNumberOrdered(@PathVariable(value = "/numberOrdered") Integer numberOrdered){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderedService.findByOrderedNumber(numberOrdered));
    }

    @GetMapping("/dateOrdered")
    public ResponseEntity<List<OrderedDto>> findOrderedByDate(@PathVariable(value = "/dateOrdered")LocalDateTime date){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderedService.findByDate(date));
    }

}
