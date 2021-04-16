package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
@Transactional
@Service(value = "todosservice")
public class TodosServiceImpl implements TodosService{





        @Autowired
        private UserRepository userRepository;
        @Autowired
        private TodosRepository todosrepos;



        @Transactional
        @Override
        public void markComplete(long todoid){
            Todos t = todosrepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found"));
            t.setCompleted(true);
        }
    }


