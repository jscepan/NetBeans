package com.mycompany.zadatakgetpostxmlfinal.controller.connectionRequests;

import java.util.ArrayList;
import java.util.List;

public class Properties extends ConnectionToBase {

    public static final String PART_URL = "/p76/types/properties";

    public Properties() {
    }

    public String getAllProperties() {
        List<String> allPropertiesTypes = new ArrayList<>();
        allPropertiesTypes.add("com.lcs.wc.flexbom.FlexBOMLink.designBomCommentsKey");
        allPropertiesTypes.add("com.lcs.wc.color.isCMYKEnabled");
        allPropertiesTypes.add("com.lcs.wc.color.cmyk.InternalKeyForC");
        allPropertiesTypes.add("com.lcs.wc.color.cmyk.InternalKeyForM");
        allPropertiesTypes.add("com.lcs.wc.color.cmyk.InternalKeyForY");
        allPropertiesTypes.add("com.lcs.wc.color.cmyk.InternalKeyForK");
        allPropertiesTypes.add("com.lcs.wc.color.cmyk.InternalKeyForIsCMYK");
        String x = postMethodForSomeType(PART_URL, allPropertiesTypes);

        if (x != null) {
            return x;
        } else {
            return "Error in getting of absr";
        }
    }
}
