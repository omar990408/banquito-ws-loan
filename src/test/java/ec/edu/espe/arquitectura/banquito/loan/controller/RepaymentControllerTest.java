package ec.edu.espe.arquitectura.banquito.loan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.arquitectura.banquito.loan.dto.RepaymentRS;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.service.RepaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(RepaymentController.class)
class RepaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RepaymentService repaymentService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String URL = "/api/v1/repayment";

    @Test
    void doPay() {
    }

    @Test
    void getRepayment() {
        //given
    }
}