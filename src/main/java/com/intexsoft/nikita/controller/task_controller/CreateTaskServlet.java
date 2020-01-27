package com.intexsoft.nikita.controller.task_controller;

import com.intexsoft.nikita.entity.Request;
import com.intexsoft.nikita.entity.Task;
import com.intexsoft.nikita.entity.TaskType;
import com.intexsoft.nikita.entity.User;
import com.intexsoft.nikita.service.*;
import org.apache.juli.logging.org.slf4j.Logger;
import org.apache.juli.logging.org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTaskServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CreateTaskServlet.class);

    final ITaskService taskService = new TaskServiceImpl();
    final IUserService userService = new UserServiceImpl();
    final IRequestService requestService = new RequestServiceImpl();
    final ITaskTypeService taskTypeService = new TaskTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/createTask.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String description = request.getParameter("description");
        //Long typeId = Long.parseLong(request.getParameter("type_id"));
/*      DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        Date startDate = null;
        Date finishDate = null;
        try {
            startDate = dateFormat.parse(request.getParameter("start_date"));
            finishDate = dateFormat.parse(request.getParameter("finish_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //Long requestId = Long.parseLong(request.getParameter("request_id"));
        //Long assigneeId = Long.parseLong(request.getParameter("assignee_id"));
        User user = userService.getUserById((long)1);
        Request request1 = requestService.getRequestById((long)1);
        TaskType taskType = taskTypeService.getTaskTypeById((long)1);
        Task task = Task.builder().id(id).description(description).
                assignee(user).
                executor(user).
                request(request1).
                type(taskType).
                build();
        String errorString = null;
//        User user = User.builder().
//        task.setAssignee(user);
        taskService.addTask(task);

        request.setAttribute("task", task);
        response.sendRedirect(request.getContextPath() + "/taskList");
        logger.info("############### Task was created ###############");
    }
}
