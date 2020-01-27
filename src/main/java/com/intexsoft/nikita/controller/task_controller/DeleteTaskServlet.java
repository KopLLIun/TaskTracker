package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.service.ITaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTaskServlet extends HttpServlet {

    final ITaskService taskService = new TaskServiceImpl();
    private static final Logger logger =  LoggerFactory.getLogger(TaskListServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        //Task task = taskService.getTaskById(id);
        taskService.deleteTask(id);
        response.sendRedirect(request.getContextPath() + "/taskList");
        logger.info("############### Task was deleted ###############");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doGet(request, response);
    }
}
