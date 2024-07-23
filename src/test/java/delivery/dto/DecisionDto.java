package delivery.dto;

public class DecisionDto {

    int income;
    int debt;
    int age;
    boolean employed;
    int loanAmount;
    int loanPeriod;

    public DecisionDto(int income, int debt, int age, boolean employed, int loanAmount, int loanPeriod) {
        this.income = income;
        this.debt = debt;
        this.age = age;
        this.employed = employed;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }
}

