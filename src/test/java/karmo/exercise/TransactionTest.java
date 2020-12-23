package karmo.exercise;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TransactionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void transferMoneyTest() throws Exception{

        JSONObject transferObject = new JSONObject();
        transferObject.put("fromName", "first");
        transferObject.put("toName", "second");
        transferObject.put("tAmount", "2");

        mockMvc.perform(put("/restricted/transfer")
                .contentType("Application/json")
                .content(String.valueOf(transferObject))
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Done"));
    }
}
