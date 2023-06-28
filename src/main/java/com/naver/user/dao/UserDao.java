package com.naver.user.dao;

import com.naver.user.domain.dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User login(String id, String pw){
        String sql = "select id, username,password,name,create_at as creatAt " +
                "from users where username = ? and password = ?";
    //방법 1    jdbcTemplate.queryForObject(sql, getUserRowMapper(), id, pw); // 이렇겓 ㅗ사용가능

    //방법 2    jdbcTemplate.queryForObject(sql,(rs, rowNum) ->new UserRowMapper().mapRow2(rs, rowNum), id, pw);

        return jdbcTemplate.queryForObject(sql,new UserRowMapper(), id, pw); // 방법 3
    }

    private static RowMapper<User> getUserRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            return user; // 익명함수
        };
    }

    public int signUp(String id, String pw,String name){
        String sql = "insert into users(username,password,name) values(?,?,?)";
            return jdbcTemplate.update(sql,id,pw,name);
    }
}
