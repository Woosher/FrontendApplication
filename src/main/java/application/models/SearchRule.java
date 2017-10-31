package application.models;

import org.hibernate.validator.constraints.NotBlank;

public class SearchRule {

    @NotBlank(message = "search text can't be empty!")

    private String searchtext;

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }
}