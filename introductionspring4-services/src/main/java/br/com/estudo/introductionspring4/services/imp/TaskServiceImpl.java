package br.com.estudo.introductionspring4.services.imp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.TaskDao;
import br.com.estudo.introductionspring4.model.Task;
import br.com.estudo.introductionspring4.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private static final long serialVersionUID = 1L;

    @Inject
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
