package com.nazim.nn.data;

import com.nazim.nn.infrastructure.adapter.model.OutpayHeaderModel;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<OutpayHeaderModel> createOutpayHeaderModelList() {
        List<OutpayHeaderModel> models = new ArrayList<>();
        OutpayHeaderModel model = new OutpayHeaderModel();
        models.add(model);
        return models;
    }
}
