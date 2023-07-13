package ec.edu.espe.arquitectura.banquito.loan.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Loan {

    private String loanId;
    private String sccountHolderType;
    private Date crationDate;
    private Date aproverDate;
    private Date lastModified;
    private String name;
    private Integer amount;
    private Integer principalDue;
    private Integer interestPaid;
    private Integer feesDue;
    private Integer feesPaid;
    private Integer penaltyDue;
    private Integer penaltyPaid;
    private Integer repaymentPeriodCount;
    private String reapaymentPeriodUnit;
    private Integer repaymentInstallmenst;
    private String gracePeriodType;
    private Integer gracePeriod;
    private BigDecimal interestRate;
    private String interestChargeFrequence;
    private String interestCalculationMethod;
    private String notes;
    private Date lastAccountAppraisalDate;
    private String scheuldeDueDatesMethod;
    private Integer fixedDays;
    private BigDecimal taxRate;
    private BigDecimal penaltyRate;
    private BigDecimal principalPaid;
    private Integer version;



    
    
}
