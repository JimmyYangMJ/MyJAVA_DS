package com.java.Fire.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author ymj
 * @Date： 2020/8/6 10:33
 * @description:
 */
public class FastJson {
    public static void main(String[] args) {
        String res = "{\"result\":[{\"vno\":\"冀EL9827\",\"mil\":\"\",\"lon\":\"69308998\",\"adr\":\"河北省衡水市冀州区冀州恒通棉花仓储有限公司,西北方向,72.5米\",\"vco\":\"2\",\"utc\":\"1591261969000\",\"state\":1001,\"province\":\"河北省\",\"spd\":\"76.0\",\"lat\":\"22492654\",\"drc\":\"212\",\"country\":\"冀州区\",\"city\":\"衡水市\"}],\"status\":1001}";
        JSONObject ret = JSON.parseObject(res);
        JSONArray error = ret.getJSONArray("result");
        JSONObject ret2 = JSON.parseObject(error.get(0).toString());
        System.out.println(ret2.get("country"));
    }
}
