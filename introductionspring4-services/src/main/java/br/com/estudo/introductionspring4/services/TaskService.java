package br.com.estudo.introductionspring4.services;

import java.io.Serializable;
import java.util.List;

import br.com.estudo.introductionspring4.web.model.Task;

public interface TaskService extends Serializable {

    public void saveOrUpdate(Task task);

    public List<Task> list();

}
