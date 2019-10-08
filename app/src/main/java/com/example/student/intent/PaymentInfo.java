package com.example.student.intent;

import java.text.DecimalFormat;

public class PaymentInfo {

    private final double mLoanAmount, mAnnualInterestRateInPercent,
            mMonthlyPayment, mTotalPayments;
    private final long mLoanPeriodInMonths;
    private final String mCurrencySymbol;

    public double getmLoanAmount() {
        return mLoanAmount;
    }

    public double getmAnnualInterestRateInPercent() {
        return mAnnualInterestRateInPercent;
    }

    public double getmMonthlyPayment() {
        return mMonthlyPayment;
    }

    public double getmTotalPayments() {
        return mTotalPayments;
    }

    public long getmLoanPeriodInMonths() {
        return mLoanPeriodInMonths;
    }

    public String getmCurrencySymbol() {
        return mCurrencySymbol;
    }

    public PaymentInfo(double loanAmount, double annualInterestRateInPercent,
                       long loanPeriodInMonths, String currencySymbol) {
        mLoanAmount = loanAmount;
        mAnnualInterestRateInPercent = annualInterestRateInPercent;
        mLoanPeriodInMonths = loanPeriodInMonths;
        mCurrencySymbol = currencySymbol;
        mMonthlyPayment = LoanUtils.monthlyPayment(loanAmount,
                annualInterestRateInPercent,
                loanPeriodInMonths);
        mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;
    }

    public String getFormattedLoanAmount()
    {
        DecimalFormat formatter = new DecimalFormat("$##,##0.00");
        return formatter.format(getmLoanAmount());
    }

    public String getFormattedLoanPeriodInMonths()
    {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(getmLoanPeriodInMonths());
    }

    public String getFormattedMonthlyPayment()
    {
        DecimalFormat formatter = new DecimalFormat("$##,##0.00");
        return formatter.format(getmMonthlyPayment());
    }

    public String getFormattedTotalPayments()
    {
        DecimalFormat formatter = new DecimalFormat("$##,##0.00");
        return formatter.format(getmTotalPayments());
    }

    public String getFormattedAnnualInterestRateInPercent()
    {
        DecimalFormat formatter = new DecimalFormat("##,##0.00");
        return formatter.format(getmAnnualInterestRateInPercent());
    }
}
