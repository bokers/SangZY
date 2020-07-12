package com.bokerr.sangzy.basic;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

public class BasicController {
    public JSONObject getResultModel(){
        JSONObject result = new JSONObject();
        result.put("code","200");
        result.put("msg","success");
        return  result;
    }
    public void setResponse(HttpServletResponse response,String text){
        this.setResponse(response,text,"");
    }
    public void setResponse(HttpServletResponse response,String text,String ContentType){
        try{
            if (StringUtils.isNotBlank(ContentType)){
                response.setContentType(ContentType);
            }
            response.getWriter().write(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
