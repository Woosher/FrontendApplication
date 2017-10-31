package application.models;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {

    String msg;
    List<SearchProduct> searchProductList = new ArrayList<>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SearchProduct> getSearchProductList() {
        return searchProductList;
    }

    public void setSearchProductList(List<SearchProduct> searchProductList) {
        this.searchProductList.clear();
        this.searchProductList.addAll(searchProductList);
    }
}
