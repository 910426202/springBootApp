package com.example.demo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by panting1 on 2017/7/22.
 */
@RestController
public class UserController {

    //@Autowired
    private UserRespository userRespository;

    @RequestMapping("/add")
    public User addUser(@RequestParam("name") String name,
                          @RequestParam("money") Integer money){
        User user = new User();
        user.setName(name);
        user.setMoney(money);
        userRespository.save(user);
        return user;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer idArg){
        userRespository.delete(idArg);
        return "delete user success";
    }

    @RequestMapping("/find")
    public User findOne(@RequestParam("id") Integer id)//id名称需要保持一致
    {
        return userRespository.findOne(id);
    }

    //事务支持
    @Transactional
    @RequestMapping("/delete")
    public void delete(){
        userRespository.delete(1);

        userRespository.delete(2);
        //throw new RuntimeException("exception");
    }

}
