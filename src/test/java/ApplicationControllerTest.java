import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.shpi0.resttest.App;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {App.class})
public class ApplicationControllerTest {

    private static final String CONTROLLER_URL = "/api/application/contact";
    private static final String XML_ROOT_NAME = "APPLICATION";
    private static final String FIELD_NAME_CONTACT_ID = "CONTACT_ID";
    private static final String FIELD_NAME_APPLICATION_ID = "APPLICATION_ID";
    private static final String FIELD_NAME_DT_CREATED = "DT_CREATED";
    private static final String FIELD_NAME_PRODUCT_NAME = "PRODUCT_NAME";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void incorrectRequestShouldReturnBadRequest() throws Exception {

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/blablabla"))
                .andDo(print())
                .andExpect(status().is(400));

    }

    @Test
    public void unavailableContactIdShouldReturnNotFound() throws Exception {

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/-1"))
                .andDo(print())
                .andExpect(status().is(404));

    }

    @Test
    public void contactWithoutApplicationsShouldReturnNotFound() throws Exception {

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/2"))
                .andDo(print())
                .andExpect(status().is(404));

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/5"))
                .andDo(print())
                .andExpect(status().is(404));

    }

    @Test
    public void contactByIdShouldReturnLastApplication() throws Exception {

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + FIELD_NAME_CONTACT_ID).value("1"))
                .andExpect(jsonPath("$." + FIELD_NAME_PRODUCT_NAME).value("APP_14"))
                .andExpect(jsonPath("$." + FIELD_NAME_DT_CREATED).value("07.04.2019 12:00:00"))
                .andExpect(jsonPath("$." + FIELD_NAME_APPLICATION_ID).value("1"));

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + FIELD_NAME_CONTACT_ID).value("3"))
                .andExpect(jsonPath("$." + FIELD_NAME_PRODUCT_NAME).value("APP_30"))
                .andExpect(jsonPath("$." + FIELD_NAME_DT_CREATED).value("11.10.2018 12:00:00"))
                .andExpect(jsonPath("$." + FIELD_NAME_APPLICATION_ID).value("6"));

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + FIELD_NAME_CONTACT_ID).value("4"))
                .andExpect(jsonPath("$." + FIELD_NAME_PRODUCT_NAME).value("APP_42"))
                .andExpect(jsonPath("$." + FIELD_NAME_DT_CREATED).value("11.12.2018 12:00:00"))
                .andExpect(jsonPath("$." + FIELD_NAME_APPLICATION_ID).value("8"));

    }

    @Test
    public void contactByIdAndXmlParamShouldReturnLastApplicationInXmlFormat() throws Exception {

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/1").param("xml", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_CONTACT_ID).string("1"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_PRODUCT_NAME).string("APP_14"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_DT_CREATED).string("07.04.2019 12:00:00"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_APPLICATION_ID).string("1"));

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/3").param("xml", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_CONTACT_ID).string("3"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_PRODUCT_NAME).string("APP_30"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_DT_CREATED).string("11.10.2018 12:00:00"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_APPLICATION_ID).string("6"));

        this.mockMvc
                .perform(get(CONTROLLER_URL + "/4").param("xml", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_CONTACT_ID).string("4"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_PRODUCT_NAME).string("APP_42"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_DT_CREATED).string("11.12.2018 12:00:00"))
                .andExpect(xpath(XML_ROOT_NAME + "/" + FIELD_NAME_APPLICATION_ID).string("8"));

    }



}
