package bmo5.bmo5tests.tools;

public class Constants {
 private Constants() { }

//	~~~~~~~~~~~~~~~~~~~~~~~~~~~   UAT5   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
    public static final String BMO_HOST = "http://bmo-uat5.bmiresearch.com/authentication/login/";
	public static final String ADM_HOST = "https://adm-uat5.bmiresearch.com/user/login";
	public static final String BMO_HOST_IP = "http://bmo-uat5.bmiresearch.com";
	public static final String BMO_DOMAIN = "http://bmo-uat5.bmiresearch.com";
 	public static final String ADM_DELETE_WIDGET = "https://adm-uat5.bmiresearch.com/widgets/businessruleswidgets/delete?widget_id=";
	public static final String WWW_DOMAIN = "http://www.businessmonitor.uat5";
	public static final String ADM_URL = "https://adm-uat5.bmiresearch.com/";

//	~~~~~~~~~~~~~~~~~~~~~~~~~~~   STG    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//	public static final String BMO_HOST = "https://bmo-stg.bmiresearch.com/authentication/login/";
//	public static final String ADM_HOST = "https://adm-stg.bmiresearch.com/user/login";
//	public static final String BMO_HOST_IP = "https://bmo-stg.bmiresearch.com";
//	public static final String BMO_DOMAIN = "https://bmo-stg.bmiresearch.com";
//	public static final String ADM_DELETE_WIDGET = "https://adm-stg.bmiresearch.com/widgets/businessruleswidgets/delete?widget_id=";
//	public static final String WWW_DOMAIN = "http://www-stg.bmiresearch.com";
//	public static final String ADM_URL = "https://adm-stg.bmiresearch.com/";
	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~   LIVE    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//	public static final String BMO_HOST = "http://162.13.26.155/authentication/login/";
//	public static final String ADM_HOST = "http://162.13.26.155/user/login";
//	public static final String BMO_HOST_IP = "http://162.13.26.155";
//	public static final String BMO_DOMAIN = "http://162.13.26.155";
//	public static final String ADM_DELETE_WIDGET = "https://adm-stg.businessmonitor.com/widgets/businessruleswidgets/delete?widget_id=";
//	public static final String WWW_DOMAIN = "http://www.businessmonitor.com";
//	public static final String ADM_URL = "https://adm.businessmonitor.com/";

//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	public static final String ADM_RESOURCES_PREFIX = "src/test/java/resources/adm/";

	public static final String BMO_RESOURCES_PREFIX = "src/test/java/resources/bmo/";

	public static final String TRACKING_RESOURCES_PREFIX = "src/test/java/resources/tracking/";
 

	public static final String DOWNLOAD_FOLDER_PATH = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\";

	public static final String HELP_PREFIX = "GEName-";
	
	public static final String RESOURCES_MEDIA="Media/";
	
	public static final String RESOURCES_EXCEL="Excel/";
	
	public static final String CGI_BIN="/cgi-bin/request.pl";
	
	public static final String ENTER="/enter";
	
	public static final String BMO="/bmo";
	
	public static final String AuthenticationTypesURL="http://analytics.businessmonitor.com/test_IP_and_URL_BMO5_UAT5.html";
	
	//Sikuli wait time
	public static final int Wait_Time = 100000;
	
	public static final String IpUat5 = "10.10.10.20";
	
	public static final String IpStaging = PublicIP.returnPublicIP();
	
	public static final String IpPublic = PublicIP.returnPublicIP();
	
	public static final String UserReportingURL = ADM_URL+"/userreports/usage";
	
	public static final String YourReportsURL = ADM_URL+"/userreports/reportslog";
	
	public static final String DATA_TOOL_LOAD_DVPACK_URL="/data/datatool/load?dvpack=";
	
	public static final String ReportsDownloadPath="services/download/retrieve_excel?keep_file=1&excel_name=/nfs_share/adm/mi_reports/";
	
	public static final String BMO5UserProfilePage=BMO_DOMAIN+"/account/profile/my_profile";

}