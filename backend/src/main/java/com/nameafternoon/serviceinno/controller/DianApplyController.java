package com.nameafternoon.serviceinno.controller;

import NET_Apply.NetApply;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/dian")
public class DianApplyController {


    private List<List<Double>> list;

    @PostMapping("")
    public void getByJSON(@RequestBody List<Map<String, Double>> mapList){
        list = null;
        list = new ArrayList<List<Double>>();
        for(int i = 0; i < mapList.size(); i++){
            ArrayList<Double> arrayList = new ArrayList<Double>();
            for(String string : mapList.get(i).keySet()){
                arrayList.add(mapList.get(i).get(string));
            }
            list.add(arrayList);
        }
    }

    @PostMapping("/upload")
    public List<Double> returnAns(){
        List<Double> listAns = new ArrayList<Double>();

        if(list == null)
            return listAns;

        MWNumericArray input = null;
        Object[] result = null;
        NetApply netApply = null;
        try {
            Double[][] in = new Double[list.size()][list.get(0).size()];
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.get(0).size(); j++){
                    in[i][j] = list.get(i).get(j);
                }
            }

            input = new MWNumericArray(in, MWClassID.DOUBLE);

            netApply = new NetApply();
            result = netApply.NET_Apply(1, input);

            for(Double i : ((MWNumericArray)result[0]).getDoubleData()){
                listAns.add(i);
            }

        } catch (
                MWException e) {
            e.printStackTrace();
        } finally {
          MWArray.disposeArray(input);
          MWArray.disposeArray(result);

        }


        return listAns;
    }

}
