package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.service.ITaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;
import com.intexsoft.nikita.util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TaskListJsonServlet", urlPatterns = "/taskListJson")
public class TaskListJsonServlet extends HttpServlet {

    final ITaskService taskService = new TaskServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskListJson = JsonConverter.toJSON(taskService.getTasks());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.write(taskListJson);
        out.flush();
    }
}
