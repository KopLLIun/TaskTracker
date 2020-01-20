package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.service.TaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTaskServlet extends HttpServlet {

    final TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("task", taskService.getTaskById(id));

        request.getRequestDispatcher("WEB-INF/views/editTask.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String description = (String) request.getParameter("description");
        Long executorId = Long.parseLong(request.getParameter("executor_id"));

        Task task = new Task(id, description, executorId);

        taskService.updateTask(task);

        request.setAttribute("task", task);
        response.sendRedirect(request.getContextPath() + "/taskList");
    }


}
