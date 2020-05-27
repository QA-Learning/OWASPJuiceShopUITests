package com.example.pageobjects;

import com.example.actions.Base;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPageAndObjects extends Base {

    @Autowired
    public LoginPageObjects loginPageObjects;


    @Autowired
    public BasketPageObjects basketPageObjects;

}
