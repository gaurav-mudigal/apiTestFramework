package apiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gaurav.test.api.dto.Data;
import com.gaurav.test.api.dto.ObjectsPojo;
import com.gaurav.test.base.BaseTest;
import com.gaurav.test.config.ConfigKeys;
import com.gaurav.test.config.ConfigManager;
import com.gaurav.test.helper.Constants;
import com.gaurav.test.helper.ApiHelper;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testScript extends BaseTest {


    @DataProvider(name = "testData")
    public Object[][] testDataProvider(){
        return new Object[][]{
                {1992,12.22, "Intel Core i9","1 TB", "Apple MacBook Pro 16"}
        };
    }

    @Test(description = "Verify post api", dataProvider = "testData")
    public void test(int year, double price, String cpuModel, String hardDiskSize, String name) throws JsonProcessingException {
        Data data = new Data(year,price,cpuModel,hardDiskSize);
        ObjectsPojo objectsPojo = new ObjectsPojo(name,data);

        Response response = ApiHelper.callPostApi(
                getBaseURI(), Constants.OBJECT_API_PATH, objectsPojo);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        String id = response.jsonPath().get("id");

        Response getResponse = ApiHelper.callGetApi(getBaseURI(), Constants.OBJECT_API_PATH,id);
        Assertions.assertThat(getResponse.getStatusCode()).isEqualTo(200);
    }
}
