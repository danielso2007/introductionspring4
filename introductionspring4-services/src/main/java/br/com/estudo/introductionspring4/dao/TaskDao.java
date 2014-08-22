package br.com.estudo.introductionspring4.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.estudo.introductionspring4.model.Task;


public interface TaskDao extends GenericDao<Task, Long> {

	List<Task> listarTask() throws DataAccessException;

}
