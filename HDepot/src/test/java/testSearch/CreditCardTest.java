package testSearch;

import keyworddriven.Features;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pro.CreditCardService;
import reporting.TestLogger;
import reporting.TestLogger;

import static base.CommonAPI.convertToString;

public class CreditCardTest {

    public class CreditCardtest extends CreditCardService {
        CreditCardService creditCardService;

        @BeforeMethod
        public void init() {
            creditCardService = PageFactory.initElements(driver, CreditCardService.class);
        }

        @Test
        public void ProjectLoan() {
            TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
            }.getClass().getEnclosingMethod().getName()));
            super.ProjectLoan();
        }

        @Test
        public void creditService() {
            TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
            }.getClass().getEnclosingMethod().getName()));
            super.creditService();
        }

        @Test
        public void ExclusiveCredit() {
            TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
            }.getClass().getEnclosingMethod().getName()));
            super.ExclusiveCredit();
        }

        @Test
        public void CommercialAccBenifit() {
            TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
            }.getClass().getEnclosingMethod().getName()));
            super.CommercialAccBenifit();
        }
    }

}
