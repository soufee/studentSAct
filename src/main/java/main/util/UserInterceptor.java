package main.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.dto.StudentDTO;
import main.model.entity.Student;
import main.services.StudentService;

/**
 *
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(UserInterceptor.class);

    private StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String login = request.getUserPrincipal().getName();

        long studentId = Long.valueOf(request.getParameter("id"));
        StudentDTO student = studentService.getById(studentId);

        /*
        if (login.equals(student.getUser().getLogin())) {
            return true;
        }
        */

        logger.debug("Illegal attempt to edit student #" + studentId + " by " + login);

        throw new SecurityException("You have no permissions to edit this user! Go forth and die!");
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
