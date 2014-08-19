package br.com.estudo.introductionspring4.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.web.model.Task;

@Component
public class TaskDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Task task) {
		entityManager.persist(task);
	}

	public List<Task> list() {
		return entityManager.createQuery("select t from Task t", Task.class).getResultList();
	}

}
