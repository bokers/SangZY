package com.bokerr.sangzy.login.action;

import com.alibaba.fastjson.JSONObject;
import com.bokerr.sangzy.basic.BasicController;
import com.bokerr.sangzy.login.po.User;
import com.bokerr.sangzy.login.service.LoginService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@ResponseBody
public class LoginController extends BasicController {
    @Autowired
    private LoginService loginService;
    
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public JSONObject checkUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject result = this.getResultModel();
        String user_name =  request.getParameter("user_name");
        String pass_word = request.getParameter("pass_word");
        User user = loginService.findByName(user_name);
        if ( !pass_word.equals(user.getPassWord())){
            result.put("code","300");
            result.put("msg","密码错误!");
        }
        logger.info("reslt:"+result);
        return result;
    }
    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public JSONObject addUser(HttpServletResponse response,HttpServletRequest request){
        JSONObject result = this.getResultModel();
        String user_name =  request.getParameter("user_name");
        String pass_word = request.getParameter("pass_word");
        String info = request.getParameter("info");
        try{
            String id = UUID.randomUUID().getMostSignificantBits()+"";
            User newUser = new User();
            newUser.setAccount(id.length() >= 32 ? id.substring(0,32) : id);
            newUser.setHeadImg("");
            newUser.setId(id);
            newUser.setIntroduce(info);
            newUser.setMail("bokerr@qq.com");
            newUser.setPassWord(pass_word);
            newUser.setSex("1");
            newUser.setUserName(user_name);
            newUser.setNickName(user_name);
            newUser.setPhone("13107617286");
            result.put("pass_word",newUser.getPassWord());
            loginService.add(newUser);
        }catch(Exception e){
            result.put("code","300");
            result.put("msg",e.getMessage());
            e.printStackTrace();
        }
        logger.info("reslt:"+result);
        return result;
    }
}
