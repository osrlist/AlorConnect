package org.sbadin.net.market.allorConnect.config;

/**
 * Configuration .
 */
public class AlorApiConfig {


	public static final String ENDPOINT_SECURITY_APIKEY = "Authorization";
	public static final String PREFIX_SECURITY = "Bearer ";
	public static final String ENDPOINT_SECURITY_TYPE_APIKEY = ENDPOINT_SECURITY_APIKEY + ": #";

	private static String BASE_DOMAIN = ".alor.ru";

    private static final String TESTNET_DOMAIN = "dev.alor.ru";

    public static boolean useTestnet = false;

    public static long jwtTokenTTL = 60;

	public static boolean isUseTestnet() {
		return useTestnet;
	}
	public static void setUseTestnet(boolean useTestnet) {
		AlorApiConfig.useTestnet = useTestnet;
	}

	public static void setBaseDomain(final String baseDomain) {
		BASE_DOMAIN = baseDomain;
	}

	public static String getBaseDomain() {
		return useTestnet? TESTNET_DOMAIN: BASE_DOMAIN;
	}

	public static String getApiBaseUrl() {
		return String.format("https://api%s", getBaseDomain());
	}

	public static String getStreamApiBaseUrl() {
		return String.format("wss://api%s/ws", getBaseDomain());
	}

	public static String getAuthorBaseUrl() {
		return String.format("https://oauth%s/", getBaseDomain());
	}

	public static long getJwtTokenTTL() {
		return jwtTokenTTL;
	}

	public static void setJwtTokenTTL(long jwtTokenTTL) {
		AlorApiConfig.jwtTokenTTL = jwtTokenTTL;
	}


}
