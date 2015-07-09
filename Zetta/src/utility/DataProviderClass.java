package utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "Login_data")
	public static Object[][] dataprovide() throws Exception{
		
		 Object[][] testObjArray = Exceldata.getTableArray("C:\\Users\\824671\\workspace\\Zetta\\src\\testdata\\Exceldata.xlsx", "Login", 1);
		 
        return (testObjArray);
		
	}

}
