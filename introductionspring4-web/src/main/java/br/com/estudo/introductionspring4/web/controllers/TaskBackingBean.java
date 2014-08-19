package br.com.estudo.introductionspring4.web.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.estudo.introductionspring4.services.TaskService;
import br.com.estudo.introductionspring4.web.model.Task;

@Component("taskBB")
@Scope("request")
@RequestScoped
@ManagedBean
public class TaskBackingBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(TaskBackingBean.class);

	private Task task = new Task();
	private List<Task> tasks;

	@Autowired
	private TaskService taskService;

	
	public Task getTask() {
		return task;
	}

	public void saveTask() {
	    logger.debug("Salvando Task...");
	    taskService.saveOrUpdate(task);
		task = new Task();
		invalidateTasks();
	}

	private void invalidateTasks() {
	    logger.debug("invalidateTasks...");
		tasks = null;
	}

	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = taskService.list();
		}
		return tasks;
		
	}

}
