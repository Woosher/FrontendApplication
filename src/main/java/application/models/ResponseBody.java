package application.models;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {

    String msg, size;
    List<SearchProduct> searchProductList = new ArrayList<>();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<SearchProduct> getSearchProductList() {
        return searchProductList;
    }

    public void setSearchProductList(List<SearchProduct> searchProductList) {
        this.searchProductList.clear();
        this.searchProductList.addAll(searchProductList);
    }
}
