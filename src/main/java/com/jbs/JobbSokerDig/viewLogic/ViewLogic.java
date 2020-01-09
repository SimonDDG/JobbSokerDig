package com.jbs.JobbSokerDig.viewLogic;


import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ViewLogic {

    //metod för att dela qualificiation list
    public List<List<Qualification>> splitQualificationList(List<Qualification> bigList, int innerSize) {

        int size = bigList.size();
        List<List<Qualification>> parts = new ArrayList<List<Qualification>>();

        for (int i = 0; i < size; i += innerSize) {
            parts.add(new ArrayList<Qualification>(bigList.subList(i, Math.min(size, i + innerSize))));
        }

        return parts;
    }

    //metod för att dela benefit list


}
