package com.misfit.testretrofitmvp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class RestResponse {

    @SerializedName("messages")
    private List<String> messages;

    @SerializedName("result")
    private List<Country> result;

    public List<Country> getResult() {
        return result;
    }

    public List<String> getMessages() {
        return messages;
    }
}