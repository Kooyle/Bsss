package com.evan.bs.service;

import com.evan.bs.dao.UsermsgDAO;
import com.evan.bs.pojo.Usermsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsermsgService {
    @Autowired
    UsermsgDAO usermsgDAO;


   /* public List<Usermsg> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        return UsermsgDAO.findAll(sort);
    }*/


   public void add(Usermsg usermsg){
       usermsgDAO.save(usermsg);
   }

    public boolean addOrUpdate(Usermsg usermsg) {
        try {
            usermsgDAO.save(usermsg);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}

