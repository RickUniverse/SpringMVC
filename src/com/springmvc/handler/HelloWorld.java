package com.springmvc.handler;

import com.springmvc.dao.EmployeeDao;
import com.springmvc.exception.OtherException;
import com.springmvc.pojo.Employee;
import com.springmvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/11/21 - 15:37
 */
@SessionAttributes(value = {"userSession"}, types = {String.class})
@RequestMapping("/testRequestMapping")
@Controller
public class HelloWorld {

    //测试SimpleMappingExceptionResolver
    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("num") Integer num) {
        String[] strings = new String[10];
        System.out.println(strings[num]);
        return "hello";
    }

    //测试responseStatus异常
    @RequestMapping("/testResponseStatus")
    public String testResponseStatus(@RequestParam("num") Integer num) {
        if (num == 10) {
            System.out.println("出错了！");
            throw new OtherException();
        }
        System.out.println("正常执行");
        return "hello";
    }



    //测试异常
    @RequestMapping("/testException")
    public String testException(@RequestParam(value = "num", required = false) Integer num) {
        System.out.println(10 / num);
        return "hello";
    }


    //文件上传
    @RequestMapping("/upload")
    public String testUpload(@RequestParam String desc,
                             @RequestParam MultipartFile multipartFile) throws IOException {
        System.out.println(desc);
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getInputStream());
        return "hello";
    }



    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @RequestMapping("/i18n")
    public String testI18n(Locale locale) {
        String message = messageSource.getMessage("i18n.user", null, locale);
        System.out.println(message);
        return "forward:/views/i18n/i18n.jsp";
    }

//    @RequestMapping("/i18n")
//    public String testI18n() {
//        return "forward:/views/i18n/i18n.jsp";
//    }


    //文件下载
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream is = servletContext.getResourceAsStream("/files/java路线.txt");
        body = new byte[is.available()];
        is.read(body);

        //设置响应求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=java路线.txt");
        //响应状态码
        HttpStatus httpStatus = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body,httpHeaders,httpStatus);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping("/testMessageConverst")
    public String testMessageConverst(@RequestBody String body) {
        System.out.println(body);
        return "hello world！: " + new Date();
    }



    @Autowired
    private EmployeeDao employeeDao;

    @ResponseBody
    @RequestMapping("/testJSON")
    public List<Employee> testJSON() {
        return employeeDao.getAllEmployee();
    }

    //testVew
    @RequestMapping("/testView")
    public String testView() {
        System.out.println("helloview");
        return "helloView";
    }



    /**
     * 有@ModelAttribute标记的方法，会在每个目标方法之前被调用
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                        Map<String,Object> map) {
        if (id != null) {
            //从数据库中先获取一遍
            User user = new User(1,"name","password",null);
            System.out.println("从数据库中获取了一个对象！并放入到request域中："+user);
            map.put("user",user);
        }
    }

    /**
     * 测试修改数据
     */
    @RequestMapping("/testModelAttributeUpdate")
    public String testModelAttributeUpdate(@ModelAttribute("user") User user){
        System.out.println("修改user:"+user);
        return "hello";
    }


    /**
     *  如何将数据放入session域中，同事也会放入到request域中
     *  value = {"userSession"} :说明将(userSession",new User("sadfasdf","asdfasdf",null) 放入session域中
     *  types = {String.class} ：说明将("names","忠君爱国啥") 键names对应的value值为String类型的数据放入到session
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map<String,Object> map) {
        System.out.println(map.getClass().getName());
        map.put("names","忠君爱国啥");
        map.put("userSession",new User("sadfasdf","asdfasdf",null));
        return "hello";
    }
    /**
     * 目标方法可以添加Map类型，实际上也可以是Model类型或者ModelMap类型的参数
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,String> map) {
        System.out.println(map.getClass().getName());
        map.put("names","忠君爱国啥");
        return "hello";
    }

    /**
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图信息,  
     * SpringMVC 会把ModelAndView 的model 中的数据放入到request域中: 如果使用的是转发则是在地址栏, 如果是重定向就是request域中
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }


    /**
     * Servlet原生API
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Writer out) {
        try {
            out.write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "hello";
    }
    /**
     * 级联赋值
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "hello";
    }


    /**
     *  映射请求头中的Cookie值
     *  required = false 该值是否是必须的
     *  defaultValue = "0" 默认值
     *  @CookieValue
     */
    @RequestMapping("/testRequestCookieValue")
    public String testRequestCookieValue(@CookieValue(value = "JSESSIONID", required = false, defaultValue = "JSESSIONID") String id) {

        System.out.println("CookieValue ： ID :"+id);

        return "hello";
    }
    /**
     *映射请求头
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String language) {

        System.out.println("language:"+language);

        return "hello";
    }
    /**
     * 映射请求的参数@RequestParam
     *  required = false 该值是否是必须的
     *  defaultValue = "0" 默认值
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String name,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") int age) {

        System.out.println("username:"+name+"--age:"+age);

        return "hello";
    }




    /*
    * 1,使用RequestMapping注解来映射URL
    * 2，返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver解析器会做如下解析：
    *       通过prefix + returnVal +　后缀这样的方式得到实际的物理视图，然后做转发
    * /views/hello/hello.jsp
    * */
    @RequestMapping("/helloworld")
    public String hello() {

        System.out.println("hello world");

        return "hello";
    }


    /*
    * 常用method来指定请求方式
    * */
    @RequestMapping(value = "/testMethodRequestMapping", method= RequestMethod.POST)
    public String hello2() {

        System.out.println("hello world");

        return "hello";
    }

    /*
    * parmsAndHeaders
    * */
    @RequestMapping(value = "testParamsAndHeader",params = {"username","age!=10"}, headers = {"Accept-Language= zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7"})
    public String testParamsAndHeader() {

        System.out.println("hello world");

        return "hello";
    }

    @RequestMapping("/testAntPath/*/test")
    public String testAntPath() {

        System.out.println("hello world");

        return "hello";
    }
    @RequestMapping("/testPathVariable/{id}")
    public String testAntPath(@PathVariable("id") Integer id) {

        System.out.println("hello world::" + id);

        return "hello";
    }

    //Rest
    @RequestMapping(value = "testMethodGet/{id}", method = RequestMethod.GET)
    public String testMethodGet(@PathVariable("id") Integer id) {
        System.out.println("testMethodGet::" + id);
        return "hello";
    }
    //Rest
    @RequestMapping(value = "testMethodPOST", method = RequestMethod.POST)
    public String testMethodPOST() {
        System.out.println("testMethodPOST");
        return "hello";
    }
    //Rest
    @RequestMapping(value = "testMethodPUT/{id}", method = RequestMethod.PUT)
    public String testMethodPUT(@PathVariable("id") Integer id) {
        System.out.println("testMethodPUT::" + id);
        return "hello";
    }
    //Rest
    @RequestMapping(value = "testMethodDELETE/{id}", method = RequestMethod.DELETE)
    public String testMethodDELETE(@PathVariable("id") Integer id) {
        System.out.println("testMethodDELETE::" + id);
        return "redirect:/views/hello/hello.jsp";
    }

    //解决JSPs only permit GET POST or HEAD问题方式：1，使用重定向到一个控制器
/*
    //Rest
    @RequestMapping(value = "testMethodGet/{id}", method = RequestMethod.GET)
    public String testMethodGet(@PathVariable("id") Integer id) {
        System.out.println("testMethodGet::" + id);
        return "hello";
    }
    //Rest
    @RequestMapping(value = "testMethodPOST", method = RequestMethod.POST)
    public String testMethodPOST() {
        System.out.println("testMethodPOST");
        return "hello";
    }
    //Rest
    @RequestMapping(value = "testMethodPUT/{id}", method = RequestMethod.PUT)
    public String testMethodPUT(@PathVariable("id") Integer id) {
        System.out.println("testMethodPUT::" + id);
        return "redirect:/testRequestMapping/putOrDELETE";
    }
    //Rest
    @RequestMapping(value = "testMethodDELETE/{id}", method = RequestMethod.DELETE)
    public String testMethodDELETE(@PathVariable("id") Integer id) {
        System.out.println("testMethodDELETE::" + id);
        return "redirect:/testRequestMapping/putOrDELETE";
    }

    @RequestMapping("/putOrDELETE")
    public String putOrDelete() {
        return "hello";
    }
*/

}
