package br.com.estudo.introductionspring4.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.TaskDao;
import br.com.estudo.introductionspring4.services.TaskService;
import br.com.estudo.introductionspring4.web.model.Task;

@Component
public class TaskServiceImpl implements TaskService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private TaskDao taskDao;
    
    @Override
    @Transactional
    public void saveOrUpdate(Task task) {
        if (task.getId() == null) {
            taskDao.save(task);
        } else {
            task = taskDao.update(task);
        }
    }

    @Override
    @Transactional
    public List<Task> list() {
        return taskDao.list();
    }
}
