package com.example.reactivedemo.service;

import com.example.reactivedemo.entities.StudentRequest;
import com.example.reactivedemo.entities.Student;
import com.example.reactivedemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Flux<Student> findAll() {
        return repository.findAll()
                         .delayElements(Duration.ofSeconds(1L));
    }

    public Mono<Student> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Student> save(StudentRequest request) {
        return repository.save(Student.builder()
                                      .firstName(request.getFirstName())
                                      .lastName(request.getLastName())
                                      .age(request.getAge())
                                      .build());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Flux<Student> findAllByFirstName(String firstName) {
        return repository.findAllByFirstNameIgnoreCase(firstName);
    }
}
