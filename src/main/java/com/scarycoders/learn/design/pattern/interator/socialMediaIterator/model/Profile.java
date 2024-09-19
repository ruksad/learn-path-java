package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.IteratorType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Profile {

    private String name;
    private String email;
    private final Map<IteratorType, List<String>> connectionsMap= new HashMap<>();

    public Profile(String email, String name, String ...connections){
        this.name=name;
        this.email= email;

        for (String connection : connections) {
            String [] data=connection.split(":");
            connectionsMap.compute(IteratorType.valueOfStr(data[0]),(key,val)->{
                if(val==null){
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add(data[1]);
                    return strings;
                }else{
                    val.add(data[1]);
                    return val;
                }
            });
        }
    }

}
