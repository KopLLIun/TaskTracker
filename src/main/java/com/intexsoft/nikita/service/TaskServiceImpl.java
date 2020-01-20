package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private static Connection dbConnection = DBConnection.getConnection();

    @Override
    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<>();
        String getTasks = "SELECT * FROM task";
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet tasks = statement.executeQuery(getTasks);

            while (tasks.next()) {
                Long id = Long.parseLong(tasks.getString("id"));
                String description = tasks.getString("description");
                //Date startDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").parse(tasks.getString("start_date"));
                //Date finishDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").parse(tasks.getString("start_date"));
                Long executorId = Long.parseLong(tasks.getString("executor_id"));
                Long requestId = Long.parseLong(tasks.getString("request_id"));
                Long assigneeId = Long.parseLong(tasks.getString("assignee_id"));
                Task task = new Task(id, description, requestId, assigneeId, executorId);
                taskList.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Bad request");
        }
        taskList.forEach(System.out::println);
        return taskList;
    }

    //not completed
    @Override
    public Task getTaskById(Long id) {

        String getTaskById = "SELECT description, executor_id FROM task where id =?";

        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(getTaskById);

            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String description = resultSet.getString("description");
                Long executorId = resultSet.getLong("executor_id");
                return new Task(id, description, executorId);
            }
        } catch (SQLException e) {
            System.out.println("Bad request");
        }

        return null;
    }

    @Override
    public void addTask(Task task) {
        String insertTask = "INSERT INTO task (id, description, executor_id) VALUES(?, ?, ?)";

        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTask);

            preparedStatement.setString(1, String.valueOf(task.getId()));
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, String.valueOf(task.getExecutorId()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Bad request");;
        }

    }

    @Override
    public void updateTask(Task task) {
        String updateTask = "Update task set description =?, executor_id =? where id =?";

        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(updateTask);

            preparedStatement.setString(1, task.getDescription());
            preparedStatement.setString(2, String.valueOf(task.getExecutorId()));
            preparedStatement.setString(3, String.valueOf(task.getId()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Bad request");
        }
    }

    @Override
    public void deleteTask(Long id) {
        String deleteTask = "DELETE FROM task where id =?";

        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteTask);

            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Bad request");
        }
    }
}
