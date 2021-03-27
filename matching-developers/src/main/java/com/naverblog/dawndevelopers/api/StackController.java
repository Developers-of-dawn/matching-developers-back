package com.naverblog.dawndevelopers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naverblog.dawndevelopers.api.dto.StackRequestDto;
import com.naverblog.dawndevelopers.service.StackService;
import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/stack")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StackController {
    private final StackService stackService;

    @PutMapping("/add")
    public ResponseEntity<?> add(@RequestBody @NotNull StackRequestDto stackRequestDto){
        Long save = stackService.save(stackRequestDto.getName());
        return ResponseEntity.ok(save+"로 저장되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        stackService.delete(id);
        return new ResponseEntity<>(id+" 삭제 완료", HttpStatus.OK);
    }
}
