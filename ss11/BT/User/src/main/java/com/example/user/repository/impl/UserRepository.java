package com.example.user.repository.impl;

import com.example.user.model.User;
import com.example.user.repository.IUserRepo;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository implements IUserRepo {
    public static final String SELECT_All_USERS = "select * from users";
    public static final String INSERT_USER = "insert into users (id,name,email,country) values (?,?,?,?)";
    public static final String SELECT_USER = "select * from users where id = ?";
    public static final String DELETE_USER_BY_ID = "delete from users where id =?";
    public static final String UPDATE_USER = "update users set name = ?,email=?,country = ? where id =?;";
    public static final String SELECT_USER_BY_COUNTRY = "select * from users where country like ?";
    public static final String ORDER_BY_NAME = "select * from users order by name;";
    private static final String SQL_UPDATE  = "UPDATE EMPLOYEE SET SALARY = ? WHERE NAME =?";
    private static final String SQL_INSERT  = "INSERT INTO EMPLOYEE(NAME,SALARY,CREATE_DATE) VALUES(?,?,?)";
    private static final String SQL_TABLE_CREATE  = "CREATE TABLE EMPLOYEE"+
            "( ID serial primary key,NAME varchar(100) NOT NULL,SALARY numeric(15,2) NOT NULL,CREATE_DATE timestamp)";
    private static final String SQL_DROP_TABLE  = "DROP TABLE IF EXISTS EMPLOYEE";

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_All_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
                users.add(user);
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;

    }

    @Override
    public void insertUser(User user) {

        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());
            statement.executeUpdate();
            connection.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User findById(int id) {
        User user;
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idX = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
                return user;
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> users = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            statement.setString(1,"%"+country+"%");
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryX = resultSet.getString("country");
                user = new User(id,name,email,countryX);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User> users = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(ORDER_BY_NAME);
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
                users.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "CALL get_user_by_id(?)";
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1,user.getName());
        callableStatement.setString(2,user.getEmail());
        callableStatement.setString(3,user.getCountry());
        callableStatement.executeUpdate();

    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        PreparedStatement ptsm = null;
        PreparedStatement pstmAssignment = null;
        ResultSet resultSet = null;
        try {
            connection.setAutoCommit(false);
            ptsm = connection.prepareStatement(INSERT_USER);
            ptsm.setInt(1,user.getId());
            ptsm.setString(2,user.getName());
            ptsm.setString(3,user.getEmail());
            ptsm.setString(4,user.getCountry());
            int rowAffected = ptsm.executeUpdate();
           int idx = user.getId();
            if(rowAffected==1){
                String sqlPivot= "INSERT INTO user_permision(user_id,permision_id) VALUES(?,?)";
                pstmAssignment = connection.prepareStatement(sqlPivot);
                for(int permisionId : permision){
                    pstmAssignment.setInt(1,user.getId());
                    pstmAssignment.setInt(2,permisionId);
                    pstmAssignment.executeUpdate();
                }
                connection.commit();
            }
            else {
                connection.rollback();
            }


        } catch (SQLException e) {
            try{
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            System.out.println(e.getMessage());
        }
        finally {

            try {

                if (resultSet != null) resultSet.close();

                if ( ptsm!= null) ptsm.close();

                if (pstmAssignment != null) pstmAssignment.close();

                if (connection != null) connection .close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            statement.execute(SQL_DROP_TABLE);
            statement.execute(SQL_TABLE_CREATE);

            //Run list of insert command
            psInsert.setString(1,"Quynh");
            psInsert.setBigDecimal(2,new BigDecimal(10));
            psInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1,"Nga");
            psInsert.setBigDecimal(2,new BigDecimal(20));
            psInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //Run list of update commands

            //below line cause error ,test transaction

            psUpdate.setBigDecimal(2,new BigDecimal(999.99));

//            psUpdate.setBigDecimal(1,new BigDecimal(999.99));
            psUpdate.setString(2,"Quynh");
            psUpdate.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateWithTransaction() {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            statement.execute(SQL_DROP_TABLE);
            statement.execute(SQL_TABLE_CREATE);

            //Run list of insert command
            psInsert.setString(1,"Quynh");
            psInsert.setBigDecimal(2,new BigDecimal(10));
            psInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1,"Nga");
            psInsert.setBigDecimal(2,new BigDecimal(20));
            psInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //Run list of update commands

            //below line cause error ,test transaction

//            psUpdate.setBigDecimal(2,new BigDecimal(999.99));

            psUpdate.setBigDecimal(1,new BigDecimal(99.99));
            psUpdate.setString(2,"Quynh");
            psUpdate.execute();

            // end transaction block ,commit changes
            connection.commit();

            // good practice to set it back to default true

            connection.setAutoCommit(false); // default true


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> displayUsersByProcedure() {
        List<User> userList = new ArrayList<>();
        String query ="call display_list_user();";
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            User user;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void deleteUserByProcedure(int id) {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        String query = "call delete_user_by_id(?)";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUserByProcedure(User user) {
        Connection connection = this.baseRepository.getConnectionJavaToDB();
        String query = "call update_user(?,?,?,?)";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
