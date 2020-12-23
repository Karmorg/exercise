package karmo.exercise;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAccount() throws Exception{

        JSONObject accountObject = new JSONObject();
        accountObject.put("name", "forth");
        accountObject.put("currency", "EUR");
        accountObject.put("balance", "0");
        accountObject.put("treasury", "true");

        mockMvc.perform(post("/public/accounts")
                .contentType("Application/json")
                .content(String.valueOf(accountObject))
                )
                .andExpect(status().isOk());
    }

    @Test
    void accountExists () throws Exception{

        mockMvc.perform(get("/restricted/accounts/first")
                .contentType("Application/json")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("true"));


    }
}
