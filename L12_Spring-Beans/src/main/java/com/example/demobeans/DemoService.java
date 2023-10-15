package com.example.demobeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // singleton scope ==> prototype
@Scope("prototype")
public class DemoService {
}
