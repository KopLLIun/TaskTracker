package com.intexsoft.nikita;

import com.intexsoft.nikita.entity.Request;
import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.entity.User;
import com.intexsoft.nikita.service.TaskServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        TaskServiceImpl taskServiceHibernate = new TaskServiceImpl();
        taskServiceHibernate.getTaskById((long) 1);
    }
}