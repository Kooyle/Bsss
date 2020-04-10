/*
package com.evan.bs.service;


import com.evan.bs.dao.ComUserDAO;
import com.evan.bs.pojo.ComUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComUserService {
    @Autowired
    ComUserDAO comuserDAO;

    public List<ComUser> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "cid");
        return comuserDAO.findAll(sort);
    }

    public boolean isExist(String username) {
        ComUser comuser = getByName(username);
        return null!=comuser;
    }
    public ComUser findByUserName(String username) {
        return comuserDAO.findByUsername(username);
    }

    public ComUser getByName(String username) {
        return comuserDAO.findByUsername(username);
    }

    public ComUser get(String username, String password){
        return comuserDAO.getByUsernameAndPassword(username, password);
    }

    public void add(ComUser comuser) {
        comuserDAO.save(comuser);
    }
}
*/
