package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.service.ITaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskListServlet extends HttpServlet {

    final ITaskService taskService = new TaskServiceImpl();
    private static final Logger logger =  LoggerFactory.getLogger(TaskListServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("############### Print list of tasks ###############");
        /*PrintWriter out = response.getWriter();

        out.write(taskService.getTaskById((long)1).toString());
        out.flush();*/
        request.setAttribute("taskList", taskService.getTasks());
        request.getRequestDispatcher("WEB-INF/views/taskList.jsp").
                forward(request, response);
    }
}
