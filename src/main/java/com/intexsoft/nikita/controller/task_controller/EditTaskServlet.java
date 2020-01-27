package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.service.ITaskService;
import com.intexsoft.nikita.service.TaskServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTaskServlet extends HttpServlet {

    final ITaskService taskService = new TaskServiceImpl();
    private static final Logger logger =  LoggerFactory.getLogger(TaskListServlet.class);

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
        String description = request.getParameter("description");
/*        Long typeId = Long.parseLong(request.getParameter("type_id"));
        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        Date startDate = null;
        Date finishDate = null;
        try {
            startDate = dateFormat.parse(request.getParameter("start_date"));
            finishDate = dateFormat.parse(request.getParameter("finish_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long requestId = Long.parseLong(request.getParameter("request_id"));
        Long assigneeId = Long.parseLong(request.getParameter("assignee_id"));*/

        Task task = taskService.getTaskById(id);
        task.setDescription(description);

        taskService.updateTask(task);

        request.setAttribute("task", task);
        response.sendRedirect(request.getContextPath() + "/taskList");
        logger.info("############### Task was edited ###############");
    }


}
