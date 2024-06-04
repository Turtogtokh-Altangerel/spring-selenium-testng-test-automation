package com.example.springdemo.framework.wait_strategy;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OptionalTimeout {}
