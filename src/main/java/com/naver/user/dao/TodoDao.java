package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TodoDao {
    private final JdbcTemplate jdbcTemplate;

    public TodoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TodoJoinUser> findAll(){
        String sql = "select todos.id," +
                "todos.user_id," +
                "users.name," +
                "todos.create_at," +
                "todos.content," +
                "todos.checked "
                +"from todos "
                +"inner join users on todos.user_id = users.id";

        List<TodoJoinUser> list = jdbcTemplate.query(sql,(rs, rowNum) -> new TodoJoinUser(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("content"),
                rs.getString("create_at"),
                rs.getBoolean("checked"),
                null));
        return list;
    }

    public List<TodoJoinUser> findSomething(String keyword){
        String sql = "select todos.id," +
                "todos.user_id," +
                "users.name," +
                "todos.create_at," +
                "todos.content," +
                "todos.checked "
                +"from todos "
                +"inner join users on todos.user_id = users.id "
                +"where content like ? ";
        if(keyword!= null && !keyword.equals("")){

        }

        List<TodoJoinUser> list = jdbcTemplate.query(sql,(rs, rowNum) -> new TodoJoinUser(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("content"),
                rs.getString("create_at"),
                rs.getBoolean("checked"),
                null),"%"+ keyword +"%");
        return list;
    }

    public int insert(String content,Integer uname){
        String sql = "insert into todos(user_id, content,checked) "+
                "value(?,?,false)";

        try {
            return jdbcTemplate.update(sql,uname,content);
        }catch (Exception e){
            return 0;
        }

    }
}
