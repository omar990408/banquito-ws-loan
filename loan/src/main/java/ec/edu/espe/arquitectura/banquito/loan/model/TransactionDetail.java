package ec.edu.espe.arquitectura.banquito.loan.model;

import java.sql.Date;

public class TransactionDetail {
    private Integer id;

    private Integer loanTransactionId;
    private Integer transactionChannelId;

    private Boolean internalTransfer;
    private Date createDay;
    private Date lastmodifiedDate;
    private Integer version;
    
}
