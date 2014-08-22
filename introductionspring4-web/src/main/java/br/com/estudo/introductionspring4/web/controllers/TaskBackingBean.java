package br.com.estudo.introductionspring4.web.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import br.com.estudo.introductionspring4.model.Task;
import br.com.estudo.introductionspring4.services.TaskService;
import br.com.estudo.introductionspring4.stereotype.RequestScopeSpring;

@Named("taskBB")
@RequestScopeSpring
@RequestScoped
@ManagedBean(name = "taskBB")
@Controller
public class TaskBackingBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private static final Log logger = LogFactory.getLog(TaskBackingBean.class);

    /* Exemplo obter valor de db.properties */
    @Value("${db.url}")
    private String url;
    @Value("${db.driver}")
    private String driver;
    
	private Task task = new Task();
	private List<Task> tasks;
	
	@Inject
	private TaskService taskService;

	
	public Task getTask() {
		return task;
	}

	public void saveTask() {
	    logger.info(String.format("Banco --> URL: %s -- DRIVER: %s", url, driver));
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
