package com.naver.user.controller;

import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.UpdateRequest;
import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/main")
    public ModelAndView showMain(@RequestParam(required = false, name = "keyword") String keyword){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");


        if(keyword == null) {
            modelAndView.addObject("todolist", todoService.findAll());
        }else {
            modelAndView.addObject("todolist", todoService.findSomething(keyword));
        }
        // 투두리스트 가져다 줘야함.
        //

        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView inputdata(
        @RequestParam("content") String content,
        ModelAndView mav,
        HttpSession session){

        Integer uname =(Integer) session.getAttribute("id");

        if(uname !=null && todoService.insert(content,uname) !=0 ){
            mav.setViewName("redirect:/main");
        }else{

            mav.setViewName("redirect:/main?err=not_insert");
            mav.addObject("err","not insert");
        }
        return mav;
    }

    @GetMapping("/todo/update")
    public ModelAndView showUpdatePage(@RequestParam("todoid") String id,
                                       ModelAndView mav
                                       ){

        mav.setViewName("/todos/todoupdate");
        mav.addObject("todoid",id);

        return mav;
    }

    @PostMapping("/todo/update")
    public ModelAndView updateData(@RequestParam("id") int id,
                                   @RequestParam("content") String content,
                                   HttpSession session,
                                   ModelAndView mav){
        UpdateRequest request = new UpdateRequest();
        Integer uid = (Integer) session.getAttribute("id");

        request.setUid(uid);
        request.setId(id);
        request.setContent(content);


        int test = 0;
        test = todoService.update(request);

        if(test != 0){
            mav.setViewName("redirect:/main");
        }else {
            mav.setViewName("/todos/todoupdate");
        }
        return mav;
    }
}
