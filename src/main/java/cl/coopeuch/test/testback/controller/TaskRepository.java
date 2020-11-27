package cl.coopeuch.test.testback.controller;

import cl.coopeuch.test.testback.db.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<Task, Long> {

}