package com.naver.user.controller;

import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignupRequest;
import com.naver.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    // 왜 여기에 의문을 안가졌었지?

    public UserController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")

    public String getLoginPage(){

        return "/user/login";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(HttpServletRequest res
//            , @RequestParam("id") String id
//            , @RequestParam("pw") String pw
//            , @RequestParam(value = "idSave",required = false) Boolean idSave
            , @ModelAttribute LoginRequest request// 이야.. 버그다 버그. 그런데 잘 안씀.
                                  // 이유는 id값은 고유해야하는데, setter로 값을 입력하기떄문
                                  // 데이터를 한묶음으로 옮기는 것.
             , ModelAndView mav
    , HttpSession session){
 // Http -> @RequestParam -> (ModelAttribute) -> 모델 엔 뷰
//        String id = res.getParameter("id");
//        String pw = res.getParameter("pw");
//        System.out.println(id + " " + pw);
//        System.out.println(user.getId() + " " + user.getPw());
//        System.out.println(mav.getModel());
        //

//        if(idSave ==null) idSave = false;
        User login = userService.login(request);
        if(login !=null){
            session.setAttribute("id",login.getId());
            session.setAttribute("uname",login.getUsername());

            mav.setViewName("redirect:/main");
        }else {
            mav.setViewName("redirect:/user/login");
//            if(idSave){
//                mav.addObject("id",id);
//            }
        }
//        mav.addObject("id",id); // url 에 얹어서 옮김 // 서블릿의 get방식과의 차이를 알면 좋음.
        return mav;
    }

    @GetMapping("/signup")
    public String getSignPage(){
        return "/user/signup";
    }


    @PostMapping("/signup")
    public ModelAndView postSignUp(
            @RequestParam("username") String id,
            @RequestParam("password") String pw,
            @ModelAttribute SignupRequest signupRequest,
            ModelAndView mav){


        if (userService.signup(signupRequest)) {
            //로그인이 되면 그 id를 바로 세션에 넣어주면 된다.
            mav.setViewName("redirect:/user/login");
        }else {
            mav.setViewName("redirect:/user/signup");
        }
        //mav.addObject("id",id); // url 에 얹어서 옮김 // 서블릿의 get방식과의 차이를 알면 좋음.
        return mav;
    }
}
