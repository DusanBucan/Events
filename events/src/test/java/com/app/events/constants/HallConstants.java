package com.app.events.constants;

/**
 * HallConstans
 */
public class HallConstants {

    /*
        info of persisted hall from data2.sql script
    */
    public static final Long PERSISTED_HALL_ID = 1l;
    public static final String PERSISTED_HALL_NAME = "sala1";
    public static final Long PERSISTED_HALL_PLACE_ID  = 1l;
    public static final Long PERSISTED_HALL_EVENT_ID  = 1l;

    
    public static final Long PERSISTED_HALL_ID2 = 2l;
    public static final Long PERSISTED_HALL_ID3 = 3l;

    /*
        constants for pesisting new hall in db
    */
    public static final String VALID_HALL_NAME_FOR_PERSISTANCE = "hall10";

    public static final Long VALID_HALL_ID = 1l;
    public static final Long INVALID_HALL_ID = -1l;
    public static final Long INVALID_PLACE_ID = -1l;
    public static final Long INVALID_EVENT_ID = -1l;


	public static final String URI_PREFIX = "/api/hall/";

}