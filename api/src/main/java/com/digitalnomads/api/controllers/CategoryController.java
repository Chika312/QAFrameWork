package com.digitalnomads.api.controllers;

import com.digitalnomads.api.ApiRequest;
import io.restassured.response.Response;

import static com.digitalnomads.api.application.TalentLMSBaseEndpoint.*;

public class CategoryController extends ApiRequest {
    public CategoryController(String url) {
        super(url, API_KEY);
    }
    public Response getAllCategories(){
        return this.response = super.get(getEndpoint(API,V1,CATEGORIES));
    }

}
