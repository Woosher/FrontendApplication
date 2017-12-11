package application.networkservices;


import application.models.SearchProduct;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<SearchProduct> theList = new ArrayList<>();

    private static final String base_url = "http://82.211.197.145:17094";

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<SearchProduct> findProducts(String query){
        final String uri = base_url + "/api/v1/searchitems";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("query", query);
        ResponseEntity<String> result = getUrl(builder);
        JSONObject jsonObject = new JSONObject(result.getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("search_results");
        List<SearchProduct> myObjects = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
            int line_id = object.getInt("line_id");
            String play_name = object.getString("play_name");
            int speech_number = 0;
            try{
                speech_number = object.getInt("speech_number");
            }catch (Exception e){
            }
            String line_number = object.getString("line_number");
            String speaker = object.getString("speaker");
            String text_entry = object.getString("text_entry");
            SearchProduct searchProduct = new SearchProduct(line_id,speech_number,play_name,line_number,speaker,text_entry);
            myObjects.add(searchProduct);
        }
        theList.clear();
        theList.addAll(myObjects);
        return theList;
    }

    private ResponseEntity<String> getUrl(UriComponentsBuilder builder){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
    }
}
