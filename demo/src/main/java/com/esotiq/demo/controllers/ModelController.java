package com.esotiq.demo.controllers;

import com.esotiq.demo.Services.ModelServices;
import com.esotiq.demo.models.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

private final ModelServices modelServices;

    public ModelController(ModelServices modelServices) {
        this.modelServices = modelServices;
    }

@GetMapping
    public List<Model> getAllModels() {
     return modelServices.getAllModels();
    }


}
