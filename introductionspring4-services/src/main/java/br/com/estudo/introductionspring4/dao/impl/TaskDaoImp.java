package br.com.estudo.introductionspring4.dao.impl;

import org.springframework.stereotype.Component;

import br.com.estudo.introductionspring4.dao.TaskDao;
import br.com.estudo.introductionspring4.web.model.Task;

@Component
public class TaskDaoImp extends GenericDaoImpl<Task, Long> implements TaskDao {
	
    private static final long serialVersionUID = 1L;
    
}
