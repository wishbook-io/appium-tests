package com.wishbook.catalog.TestCases;

public class TestCaseOptions {

    public TestCaseOptions(InitialLoginType initialLoginType) {
        this.initialLoginType = initialLoginType;
        this.handleOnboarding=false;
    }

    public TestCaseOptions(InitialLoginType initialLoginType, boolean handleOnboarding) {
        this.initialLoginType = initialLoginType;
        this.handleOnboarding = handleOnboarding;
    }

    //region initial login
    public enum InitialLoginType{
        DontLogin,
        LoginAsWholeSaler,
        LoginAsRetailer,
        LoginAsManufacturer,
        LoginAsTestRetailer,
        LoginAsTestManufacturer,
        LoginAsTestWholeSaler,
        LoginAsBroker,
        LoginAsUser,
        LoginAsGuestUser,
        LoginAsSalesPerson,
        LoginAsWishbookInfoServices,
        LoginAsTestReseller,
        LoginAsWholesalerCatalogUploader;

    }
    private InitialLoginType initialLoginType=InitialLoginType.LoginAsWholeSaler;

    public InitialLoginType getInitialLoginType() {
        return initialLoginType;
    }


    //endregion

    //region handle onboarding
    private boolean handleOnboarding=false;

    public boolean isHandleOnboarding() {
        return handleOnboarding;
    }

    //endregion


}
