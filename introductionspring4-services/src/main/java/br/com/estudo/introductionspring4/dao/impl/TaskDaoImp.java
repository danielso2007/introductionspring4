package br.com.estudo.introductionspring4.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.TaskDao;
import br.com.estudo.introductionspring4.model.Task;

@Repository
public class TaskDaoImp extends GenericDaoImpl<Task, Long> implements TaskDao {
	
    private static final long serialVersionUID = 1L;
    
    private JdbcTemplate jdbcTemplate;
 
    public TaskDaoImp() {
	}
    
    @Override
    @Transactional(readOnly = true)
    public List<Task> listarTask() throws DataAccessException {
    	List<Task> tasks = this.jdbcTemplate.query("select id, description from task", new TaskMapper());
    	return tasks;
    }
    
    private static final class TaskMapper implements RowMapper<Task> {
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Task task = new Task();
        	task.setId(rs.getLong("id"));
            task.setDescription(rs.getString("description"));
            return task;
        }
    }

    @Autowired
	public void setDataSource(DataSource dataSource) {
    	jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
}
