package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.service.TaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;
import org.apache.juli.logging.org.slf4j.Logger;
import org.apache.juli.logging.org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTaskServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CreateTaskServlet.class);

    final TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/createTask.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String description = (String) request.getParameter("description");
        Long executorId = Long.parseLong(request.getParameter("executor_id"));
        Task task = new Task(id, description, executorId);

        String errorString = null;

        taskService.addTask(task);

        request.setAttribute("task", task);
        response.sendRedirect(request.getContextPath() + "/taskList");

    }
}
