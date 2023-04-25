package com.wishbook.catalog.PageObject.Core;


/**
 * Created by wishbook on 16/3/18.
 */

@SuppressWarnings("unused")
public class AndroidLocator {


    //region LoginPage

    //endregion



    //region Android widgets
    public static final String excelPath="/home/wishbook/Documents/appium/project/catalog/src/test/java/com/wishbook/catalog/ExcelData/AppiumInput.xlsx";
    public static final String WIDGET_RADIO_BUTTON = "android.widget.RadioButton";
    public static final String WIDGET_CHECK_BOX = "android.widget.CheckBox";
    public static final String WIDGET_TEXT_VIEW = "android.widget.TextView";
    public static final String WIDGE_IMAGE_BUTTON = "android.widget.ImageButton";
    public static final String WIDGE_IMAGE_VIEW = "android.widget.ImageView";
    public static final String WIDGE_CHECKED_TEXT_VIEW	="android.widget.CheckedTextView";
    public static final String WIDGE_RELATIVE_LAY0UT ="android.widget.RelativeLayout";
    public static final String WIDGE_LINEAR_LAYOUT="android.widget.LinearLayout";
    public static final String WIDGE_BUTTON="android.widget.Button";
    public static final String SCROLL_VIEW="com.wishbook.catalog:id/scroll_view";
    //endregion

    //region AndroidsViews
    public static final String FIND_SCROLLVIEW_AT = "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").index(";
    public static final String AND_SCROLL_TO_VIEW = ")).scrollIntoView(new UiSelector().resourceId(\"";
    public static final String AND_FINISH_SCROLL = "\"))";
    public static final String PERMISSION_ALLOW = "com.android.packageinstaller:id/permission_allow_button";
    public static final String PERMISSION_DENY = "com.android.packageinstaller:id/permission_deny_button";
    public static final String PACKAGE_NAME = "com.wishbook.catalog";
    public static final String id = ":id/";
    public static final String PID = PACKAGE_NAME + id;
    public static final String YES = PID + "md_buttonDefaultNegative";
    public static final String NO = PID + "md_buttonDefaultPositive";
    public static final String MORE_TAB = PID + "tab_more";
    public static final String GET_START_BUTTON = PID + "btn_step";
    public static final String RECYCLER_VIEW = PID + "recycler_view";
    public static final String NAVIGATION_VIEW = PID + "design_navigation_view";

    //endregion

    //region Login
    public static final String LOGIN_INPUT_MOBILE = PID + "input_mobile";
    public static final String LOGIN_INPUT_PASSWORD = PID + "input_password";
    public static final String PROCEED_BUTTON = PID + "btn_submit";
    public static final String DONE_BUTTON = PID + "btn_save";
    public static final String SKIP_BUTTON = PID + "skip";
    public static final String NEXT_BUTTON = PID + "next";
    public static final String SELECT_SIZE_KURTI= PID+"flex_available_sizes";
    public static final String ENTER_DISPATCH_DATE=PID+"edit_dispatch_date";
    public static final String HOME_PAGE_SEARCH_TEXTFIELD=PID+"txt_home_search";
    //endregion

    //region Registration
    public static final String REGISTER_BUTTON = PID + "txt_register";
    public static final String STATE_SPINNNER = PID + "spinner_state";
    public static final String SELECTED_STATE = "//android.widget.TextView[@text='Bihar']";
    public static final String CITY_SPINNER = PID + "spinner_city";
    public static final String SELECTED_CITY = "//android.widget.TextView[@text='Patna']";
    public static final String COMPANY_NAME = PID + "companyautocomp";
    public static final String COMPANY_TYPE = PID + "input_company_type";
    public static final String MANUFACTURE = PID + "manufacturer";
    public static final String WHOLESALER = PID + "wholesaler_distributor";
    public static final String RETAILER = PID + "retailer";
    public static final String ONLINE_RETAILER_RESELLER = PID + "onlineretailer_reseller";
    public static final String BROKER = PID + "broker";
    public static final String OK_BUTTUN = PID + "txt_ok";
    public static final String NAME = PID + "input_name";
    public static final String EMAIL = PID + "input_email";
    public static final String CHECKBOX_TERMS = PID + "check_terms";

    public static final String FACEBOOK_LOGIN = PID + "login_facebookLoginButton";
    public static final String FACEBOOK_CLOSE = "//android.widget.ImageView[@index='1']";
    public static final String BACK_BUTTON = "//android.widget.ImageButton[@index='0']";
    public static final String GOOGLE_LOGIN = "//android.widget.Button[@text='Register with Google']";
    @SuppressWarnings("unused")
    public static final String GOOGLE_ACCOUNT = "com.google.android.gms:id/account_name";
    public static final String ENTER_HIS_NUMBER_HERE = PID + "txt_scan_dialog";
    public static final String ENTER_SUPPIER_NUMBER = PID + "input_mobile_scan";
    @SuppressWarnings("unused")
    public static final String FOLLOW_TEXT = PID + "txt_brand_i_follow_value";
    public static final String TOOLBAR = PID + "toolbar";
    public static final String MY_TOOLBAR=PID+"my_toolbar";
    //endregion

    //region CatalogsUpload

    public static final String PAYABLE_AMOUNT=PID+"txt_payable_amt";
    public static final String REWARD_POINTS=PID+"txt_reward_point";
    public static final String PAID_AMOUNT=PID+"txt_paid_amt";
    public static final String UPLOAD_CATALOGS = PID + "add_catalog";

    public static final String CHOOSE_CATEGORY = PID + "spinner_category";

    public static final String CHOOSE_BRAND = PID + "spinner_brand";
    @SuppressWarnings("unused")
    public static final String ENTER_CATALOGS_NAME = PID + "auto_text_catalog";
    @SuppressWarnings("unused")
    public static final String CHECKBOX_SELL_FULL_CATALOG = PID + "fulcatalog";
    public static final String SHOW_HINTS = PID + "hint_switch";
    public static final String UPLOAD_PHOTO_COVER = PID + "btn_upload_cover";
    public static final String CONTINUE_BUTTUN = PID + "btn_continue";
    public static final String OK_CONFIRMATION = PID + "md_buttonDefaultPositive";
    public static final String CAMERA_UPLOAD_XAPTH = "//android.widget.TextView[@index='0']";
    public static final String JUST_ONCE_BUTTON = "android:id/button_once";

    @SuppressWarnings("unused")
    public static final String CAMERA_CLICK_BUTTON = "com.android.camera2:id/shutter_button";
    public static final String RETAKE_CAMERA_PIC = "com.android.camera2:id/retake_button";
    public static final String PIC_CLICK_DONE = "com.android.camera2:id/done_button";
    public static final String PIC_CANCEL = "com.android.camera2:id/cancel_button";
    public static final String PIC_ROTATE = PID + "rotateRight";
    public static final String PIC_SELECT_SAVE = PID + "save";
    public static final String ADD_NEW_ADDRESS_BROKER=PID+"btn_add_address";
    public static final String ENTER_ADDRESS_LINE1_broker=PID+"edit_addline1";
    public static final String ENTER_DELIVERY_PINCODE=PID+"edit_pincode";
    public static final String SAVE_BROKER_ADDRESS_BUTTON=PID+"btn_save_address";



    //UPLOAD_CATALOG_PAGE2
    public static final String ADD_FABERIC = PID + "btn_add_fabric_first";
    public static final String ADD_WORK = PID + "btn_add_work_first";

    public static final String ENTER_OTHER_DETAILS = PID + "edit_other_detail";
    public static final String PRODUCT_WITHOUT_SKU = PID + "productsWS";
    public static final String CATALOG_ENABLE_DURATION = PID + "edit_enable_duration";
    public static final String ADD_PRODUCT_PHOTOS_BUTTON=PID+"btn_add_product";
    public static final String CALENDER=PID+"linear_dispatch_date";
    public static final String CALENDER_OK=PID+"android:id/button1";
    public static final String NUMBER_OF_PIECES_PER_SCREEN=PID+"edit_screen_pc_set";
    public static final String PRICES_PER_PIECES_SCREEN=PID+"edit_screen_price_pc";
    //upload page catalog page3
    public static final String PUBLIC_CATALOG = PID + "public_catalog";
    public static final String PRIVATE_CATALOG = PID + "private_catalog";
    public static final String SAME_PRICE_DETAILS = PID + "public_single_price";
    public static final String ENTER_PRICE_FOR_THIS_CATALOG = PID + "public_input_price";
    public static final String ENTER_INDIVIDUAL_PRICE_DETAILS = PID + "public_individual_price";

    //upload page catalog page4
    public static final String TAP_TO_SELECT_IMAGE = PID + "image_view_image_select";
    public static final String ADD_IMAGE_ICON = PID + "menu_item_add_image";

    public static final String SELECT_CATALOG_DESIGN = PID + "uploadcard";
    public static final String UPLOAD_CATALOG_BUTTON = PID + "btn_continue";
    public static final String ENTER_PRICE = PID + "edit_price";
    public static final String SINGLE_PIECES_FULL_CATALOG_AT_ADD_PRODUCT=PID+"radio_single_piece_catalog";
    //endregion

    //region SearchCatalog
    public static final String SEARCH_BUTTON = PID + "action_search";
    public static final String SEARCH_TEXTBOX = PID + "search_src_text";
    public static final String SEARCH_CLOSE = PID + "img_searchclose";
    public static final String NO_CATALOGS_TO_DISPLAY=PID+"list_empty1";
    public static final String KYC_BANK_DETAILS=PID+"settings_gst";
    public static final String WISHBOOK_MONEY=PID+"settings_wb_money";
    //endregion

    //region FilterProducts
    public static final String FILTER_ICON = PID + "filter_image";
    @SuppressWarnings("unused")
    public static final String CLEAR_ALL_FILTER = PID + "menu_clear_filter";
    public static final String FROM_MY_NETWORK_CHECKBOX = PID + "radioGroup_public";
    @SuppressWarnings("unused")
    public static final String FULL_CATALOG_FOR_SALE = PID + "check_full_catalog";
    public static final String SINGLE_PIECE_AVAILABLE = PID + "check_single_piece";
    public static final String TRUSTED_SELLER_ONLY = PID + "trusted_filter";
    @SuppressWarnings("unused")
    public static final String BRAND_FILTER = PID + "relative_brand";
    public static final String FABRIC_FILTER = PID + "relative_fabric";
    public static final String CATEGORY = PID + "relative_category";
    public static final String WORK_FILTER = PID + "relative_work";
    public static final String PRICE_FILTER = PID + "relative_price";

    public static final String CATALOG_FILTER = PID + "relative_ctype";
    public static final String SHOW_DISABLE_BY_ME_CHECKBOX = PID + "check_buyer_disable";
    public static final String SHOW_DISABLE_SUPPLIER_CHECKBOX = PID + "check_supplier_disable";
    public static final String SHOW_DISABLED_BY_ME=PID+"check_buyer_disable";
    public static final String FULL_CATALOG_FOR_SALE_CHECKBOX = PID + "check_full_catalog";
    public static final String SINGLE_PIECE_SALE_CHECKBOX = PID + "check_single_piece";
    public static final String SAVE_FILTER = PID + "btn_clear_all";

    public static final String SEARCH_CATALOG = PID + "edit_catalog_title";
    public static final String CATALOG_SUITS_STITCH = PID + "relative_strich";
    public static final String SIZE = PID + "relative_strich";
    //endregion

    //region SearchCatalog
    public static final String APPLY_BUTTON=PID+"btn_filter_apply";
    public static final String SAVE_CATALOG_INPUTTEXT = "android:id/input";
    public static final String CLICK_SAVE_FILTER_BUTTON = PID + "btn_clear_all";
    public static final String BACK_SEARCH_BUTTON = PID + "img_searchclose";
    //endregion

    //region SortingProducts
    public static final String SORT_ICON = PID + "img_sort";
    public static final String SORT_CLOSE = PID + "img_close";
    public static final String SORT_PRICE_HIGHTOLOW = PID + "price_high_to_low_selected";
    public static final String SORT_PRICE_LOWTOHIGH = PID + "price_low_to_high_selected";
    public static final String SORT_NUMBEROFVIEWS = PID + "number_of_views_selected";
    public static final String SORT_RECENTLY_UPLOADED = PID + "latest_selected";
    //endregionre

    //region MyFilter
    public static final String MYFILTERS_ICON = PID + "saved_filter_icon";
    @SuppressWarnings("unused")
    public static final String CLOSE_MYFILTERS = PID + "img_close";
    @SuppressWarnings("unused")
    public static final String CLEAR_ALL_MYFILTER = PID + "txt_clear_filter";

    //endregion

    // region EnquiryCreated


    public static final String SEND_ENQUIRY_BUTTON = PID + "btn_send_enquiry";
    //YES-->POSITIVE
    //NO--->NEGATIVE
    //endregion

    //region CatalogDetails
    public static final String SOLD_BYLINK = PID + "txt_sold_by";
    public static final String SOLD_BY_ALLLINK = PID + "txt_see_all_seller";
    public static final String CALLTOSUPPIER = PID + "btn_call";
    public static final String CHATTOSUPPLIER = PID + "chat_user";
    public static final String ORDERS_SUPPLIER = "//android.widget.TextView[@text='ORDERS']";
    public static final String WISHLIST_BUTTON = PID + "txt_wishlist";
    public static final String FOLLOW = PID + "btn_brand_follow";
    public static final String SEE_MORE_LINK = PID + "txt_material_see_more";
    public static final String BECOME_SELLER_OF_THIS_CATALOG = PID + "btn_become_seller";
    public static final String CHAT_ENQUIRY_BUTTON = PID + "btn_enquiry_chat";
    public static final String ADD_TO_CART = PID + "btn_purchase";
    public static final String CART_ICON = PID+"cart";
    public static final String RECYCLER_VIEW1=PID+"recycler_view1";
    public static final String ITEM_IMAGE_ID = PID + "item_img";
    public static final String PRICE_TEXT=PID+"txt_price";
    public static final String WORK_TEXT=PID+"txt_work";
    public static final String FABRIC_TEXT=PID+"txt_fabric";
    public static final String DISABLED_BY_SUPPLIER_TEXT=PID+"disable_text1";
    public static final String CATALOG_TITLE=PID+"cattitle";
    public static final String SHARE_BUTTON_CATALOG_DETAILS=PID+"linear_share";
    public static final String BUY_AS_BROKER=PID+"btn_broker";
    public static final String GETTEXT_STATUS_LEAD_ENQUIRY=PID+"txt_status";
    public static final String GETTEXT_ENQUIRED_ABOUT=PID+"txt_enquired_about_value";
    public static final String ENTER_PAYMENT_DETAILS_BUTTON=PID+"btn_payment";
    public static final String WHOLESALER_CASH_DISCOUNT=PID+"edit_wholeseller_cd";
    public static final String WHOLESALER_CREDIT_DISCOUNT=PID+"edit_wholeseller_crd";
    public static final String RETAILER_CASH_DISCOUNT=PID+"edit_retailer_cd";
    public static final String RETAILER_CREDIT_DISCOUNT=PID+"edit_retailer_crd";
    public static final String DISCOUNT_SETTINGS_MY_BUSINESS=PID+"settings_discount";
    public static final String ADD_CATALOG_IN_MY_BUSINESS=PID+"setting_add_catalog";

    //endregion

    //region ShareCatalogPublic
    public static final String SHARE_CATALOG_ICON = PID + "linear_share";
    //GROUP SHARE
    public static final String SHARE_SELL_FULL_CATALOG_CHECKBOX = PID + "fullcatalog";
    public static final String SHARE_AT_DIFFERENT_PRICE = PID + "radio_share_different_price";
    public static final String SHARE_AFTER_ADDING_MARGIN = PID + "radio_share_add_margin";
    public static final String DONE_BUTTON_SHARE = PID + "share_go";
    public static final String ENTER_NEW_PRICE = PID + "input_new_price";
    public static final String SHARE_AFTER_MARGIN_ADD_PERCENTAGE = PID + "input_percentage";
    public static final String ADD_FIXED_AMOUNT = PID + "input_price";
    public static final String BUYER_GROUP_TEXTFIELD="spintext";
    //INDIVIDUAL SHARE
    public static final String INDIVIDUAL_SHARE = "//android.widget.TextView[@text='INDIVIDUAL SHARE']";
    public static final String ENTER_BUYER_NAME = PID + "edit_buyername";
    //endregion

    //region MyCompany
    @SuppressWarnings("unused")
    public static final String MY_COMPANY_LOGO = "//android.widget.TextView[@text='My Company']";
    //endregion

    //region MyBrands
    @SuppressWarnings("unused")
    public static final String MY_BRANDS_LOGO = "//android.widget.TextView[@text='My Brands']";
    public static final String BRANDS_I_OWN = PID + "add_brands_own";
    public static final String BRANDS_I_SELL = PID + "add_brands_sell";
    public static final String BRAND_UPLOAD_IMAGE = PID + "btn_upload";
    public static final String BRAND_ENTER_YOUR_BRAND_NAME = PID + "input_brand";
    public static final String SUPPORT_MESSAGE = PID + "badge_layout1";
    public static final String SUPPORT_BACK_BUTTON = "//android.widget.ImageButton[@content-desc='ऊपर जाएं']";
    public static final String BRAND_I_FOLLOW = PID + "setting_brand_i_follow";
    public static final String WISHLIST_MY_BUSINESS = PID + "setting_my_wishlist";
    //endregion

    //region OrderCreation
    @SuppressWarnings("unused")
    public static final String EDIT_ORDER_REQUIREMENT = PID + "edit_order_requirement";
    public static final String PLUS_BUTTON = PID + "btn_plus";
    @SuppressWarnings("unused")
    public static final String MINUS_BUTTON = PID + "btn_minus";
    @SuppressWarnings("unused")
    public static final String HIDE_CATALOGS_DETAILS = PID + "txt_expand_txt";
    public static final String PACKING_TYPE_NO_BOXING = PID + "radio_default_naked";
    public static final String PACKING_TYPE_BOXING = PID + "radio_default_boxed";
    @SuppressWarnings("unused")
    public static final String ADD_MORE_CATALOGS = PID + "btn_add_more_catalog";
    public static final String TOTAL_PRICE_CATALOGS = PID + "totalprice";
    @SuppressWarnings("unused")
    public static final String CONTINUE_ORDER = PID + "order";
    @SuppressWarnings("unused")
    public static final String ENTER_BUYER_NAME_BROKER_ORDER=PID+"edit_buyername";
    public static final String SEARCH_BUYER_NAME_BROKER_ORDER=PID+"textInt";
    public static final String BUYER_NAME_OREDR_RECEIPT_TEXT=PID+"txt_buyer_name";
    public static final String ALL_PEN_DIS_CAN_SPINNER=PID+"spinner";
    public static final String BROKER_NAME_GET_TEXT=PID+"order_broker_name";
    public static final String PAY_BUTTON_ORDER_RECEIPT=PID+"btn_accept";
    public static final String ORDER_RECEIVED_BUTTON=PID+"btn_order_received";
    public static final String CLOSE_SEARCH_TEXT_FIELD=PID+"img_searchclose";
    public static final String DISPATCHED_SPINNER="//android.widget.TextView[@index='2']";
    public static final String PENDING_SPINNER="//android.widget.TextView[@index='1']";
    public static final String SHARE_ON_WISHBOOK=PID+"btn_share_wishbook";
    public static final String DATE_ON_RECEIPT=PID+"txt_order_date";
    public static final String DATE_PAYMENT=PID+"txt_payment_date";
    public static final String DISCOUNT_INVOICE=PID+"txt_seller_discount";
    public static final String DISCOUNTING_INVOICE_PRICE=PID+"invoice_prod_value";
    public static final String CALL_WB_SUPPORT_BUTTON=PID+"btn_call_wb_support";
    public static final String CHAT_WB_SUPPORT_BUTTON=PID+"btn_chat_wb_support";
    @SuppressWarnings("unused")
    public static final String WISHBOOK_MONEY_TEXT_ON_ORDER_DEATILS=PID+"txt_wishbook_amount";
    public static final String ENTER_TOTAL_NUMBER_OF_DESIGN=PID+"edit_product_selection";

    //endregion

    //region ShipmentAndPayment
    public static final String SELECT_ADDRESS_RECYCLER = PID + "recycler_address";
    public static final String TRANSPORT_VIA_WISHBOOK = PID + "radio_wishbook_transport";
    public static final String WISHBOOK_SHIPPING_CHARGE = PID + "txt_shipping_charge";
    public static final String WISHBOOK_SHIPPING_INVOICE=PID+"txt_shipping_amount";
    public static final String OTHER_TRANSPOTATION_MEDIUM = PID + "radio_customer_transport";
    public static final String ORDER_NUMBER = PID + "invoice_order_no";
    public static final String NUMBER_ITEMS_DISPATCHED=PID+"dispatched_items";
    public static final String NUMBER_OF_ITEMS_AT_BOTTOM=PID+"txt_total_products";
    public static final String TRACK_YOUR_ORDER_BUTTON=PID+"linear_main_order_track";
    public static final String SUPPLIER_NAME = PID + "invoice_supplier_name";
    public static final String PAYBLE_AMOUNT = PID + "txt_payable_amt";
    public static final String PAYMENT_RADIO_BUTTONS_GROUP = "//android.widget.RadioButton[@text='BUY ON CREDIT']";
    public static final String CANCEL_ORDER = PID + "btn_cancel_order";
    public static final String PROCEED_TO_PAYMENT = PID + "btn_payment";
    public static final String SHIPPING_PROVIDER_WISHBOOK=PID+"txt_shipping_provider";

    public static final String ATTACHMENT_SELLER_ORDER_RECEIPT=PID+"attach_button";
    public static final String CANCEL_ORDER_BUTTON=PID+"btn_cancel_order";
    public static final String ORDER_STATUS = PID + "txt_order_status";
    public static final String PAYMENT_STATUS = PID + "txt_payment_status";
    public static final String PAYMENT_DETAILS = "txt_payment_detail";
    public static final String TRANSFER_BUTTON=PID+"btn_transfer";
    public static final String AMOUNT_ON_ORDER_DEATILS = PID + "order_amount";
    public static final String SUPPLIER_NAME_ON_ORDER_DETAILS = PID + "order_supplier_name";
    public static final String DONE_ORDER = PID + "btn_payment_credit";
    public static final String PENDING_SALES_ORDER = PID + "linear_sales_pending";
    public static final String STAR_RATINGS_ORDER_RECEIPT_PAGE=PID+"ratingBar";
    public static final String SEARCHED_ORDER_CATALOG = PID + "main_container_2";
    public static final String CAMERA_CLICKED_IMAGE_SAVE = PID + "save";
    public static final String STOP_SELLING = PID + "btn_enable_disable";
    public static final String BACK_PROFILE = "android.widget.ImageButton";
    public static final String SAVE_FILTER_SAVE = PID + "md_buttonDefaultPositive";
    public static final String WISHLIST_ICON = PID + "action_wishlist";
    public static final String MENU_BADGE = PID + "menu_badge";
    public static final String APP_BAR = PID + "appbar";
    public static final String NOTIFICATION_ICON=PID+"action_notification";

    public static final String SEARCH_HOME=PID+"txt_home_search";

    public static final String ACCEPT_ORDER_BUTTON=PID+"btn_accept";
    public static final String DISPATCH_ORDER_BUTTON=PID+"btn_dispatch";
    @SuppressWarnings("unused")
    public static final String ENTER_MODE_OF_DISPATCH=PID+"input_mode";
    public static final String SAVE_DISPATCH_DETAILS=PID+"btn_add";
    public static final String DISPATCH_BUTTON_SALES=PID+"linear_sales_dispatch";
    public static final String DISPATCH_BUTTON_PURCHASE=PID+"linear_purchase_dispatch";
    public static final String CANCEL_BUTTON_SALES_ORDER=PID+"linear_sales_cancel";

    public static final String OPEN_LEADS_TEXT=PID+"txt_leads_open";
    public static final String RESOLVED_LEADS_TEXT=PID+"txt_leads_closed";
    public static final String OPEN_LEADS_BUTTON=PID+"linear_leads_new";
    public static final String RESOLVED_LEADS_BUTTON=PID+"linear_leads_old";
    public static final String TOTAL_TEXT_LEAD=PID+"txt_leads_total";

    public static final String OPEN_ENQUIRIES_TEXT=PID+"txt_enquiry_open";
    public static final String RESOLVED_ENQUIRIES_TEXT=PID+"txt_enquiry_closed";
    public static final String OPEN_ENQUIRIES_BUTTON=PID+"linear_enquiry_new";
    public static final String RESOLVED_ENQUIRIES_BUTTON=PID+"linear_enquiry_old";
    public static final String TOTAL_TEXT_ENQUIRIES=PID+"txt_enquiry_total";


    public static final String VIEW_ARROW_BUTTON=PID+"arrow_img";
    public static final String PURCHASE_CANCEL_BUTTON=PID+"linear_purchase_cancel";

    //endregion

    //region changePassword
    public static final String NEW_PASSWORD = PID + "new_pswd";
    public static final String REPEAT_PASSWORD = PID + "cnfrm_pswd";
    public static final String CHANGE_PASSWORD_BUTTON = PID + "btn_change_pswd";
    //endregion

    //region profile
    public static final String PROFILE_FIRST_NAME = PID + "input_firstname";
    public static final String PROFILE_LAST_NAME = PID + "input_lastname";
    public static final String PROFILE_YOUR_USERNAME = PID + "input_username";
    public static final String PROFILE_COMPANY_NAME = PID + "company_profile_name";
    public static final String PROFILE_SELECT_STATE = PID + "company_profile_spinner_state";
    public static final String PROFILE_SELECT_CITY = PID + "company_profile_spinner_city";
    public static final String PROFILE_EMAILID = PID + "input_email";
    public static final String PROFILE_PHONE_NUMBER = PID + "input_mobile";
    public static final String PROFILE_SAVE_CHANGE = PID + "btn_save_profile";
    @SuppressWarnings("unused")
    public static final String GETTEXT_USERNAME_FULLNAME = PID + "txt_firstname";
    public static final String GETTEXT_PROFILE_LOGO = PID + "txt_first_initialize";
    @SuppressWarnings("unused")
    public static final String GETTEXT_COMPANY_NAME = PID + "txt_companyname";
    public static final String GETTEXT_CITY=PID+"spintext";
    //endregion

    //region BrandISell
    public static final String BRAND_I_SELL_SEARCH = PID + "search_src_text";
    public static final String BRAND_I_SELL_CANCEL = PID + "cancel";
    public static final String BRAND_I_SELL_DONE = PID + "done";
    @SuppressWarnings("unused")
    public static final String BRAND_I_SELL_MYBUSINESS = PID + "settings_my_brands";
    //endregion

    //region language
    public static final String HINDI_LANGUAGE = "//android.widget.RadioButton[@text='Hindi']";
    public static final String ENGLISH_LANGUAGE = "//android.widget.RadioButton[@text='English']";
    //endregion

    //region BottomTab
    public static final String IMAGE_GALLERY_FOLDER = PID + "image_view_album_image";
    public static final String CATALOG_TAB = PID + "tab_catalogs";
    public static final String PROFILE_TAB = PID + "tab_profile";
    public static final String HOME_TAB = PID + "tab_home";
    public static final String ORDER_TAB = PID + "tab_orders";
    public static final String WISHLIST_TEXT_VALUE = PID + "txt_my_wishlist_value";
    public static final String BRAND_I_FOLLOW_TEXT_VALUE = PID + "txt_brand_i_follow_value";
    //endregion

    //region appbar
    @SuppressWarnings("unused")
    public static final String LOGOUT = " //android.widget.TextView[@text='Kurti']";
    @SuppressWarnings("unused")
    public static final String MORE_TAB_LOG_OUT = "//android.widget.CheckedTextView[@text='Logout']";
    @SuppressWarnings("unused")
    public static final String CHANGE_PASSWORD = "//android.widget.CheckedTextView[@text='Change Password']";
    @SuppressWarnings("unused")
    public static final String CATEGORIES = "com.wishbook.catalog:id/appbar";
    //endregion

    //region orderDetails
    public static final String ORDER_NUMBER_TEXT = PID + "txt_order_no";
    public static final String RECYCLER_SUGGESTION = PID + "recyclerSuggestion";
    public static final String CAMERA_LIST_VIEW = "android:id/select_dialog_listview";
    public static final String ORDER_NUMBER_TEXT_SHIPMENT=PID+"invoice_order_no";
    public static final String SUPPLIER_NAME_SHIPMENT=PID+"invoice_supplier_name";

    //endregion

    //region MyBusiness
    @SuppressWarnings("unused")
    public static final String MY_CATALOGS_MY_BUSINESS=PID+"setting_my_catalog";
    public static final String MY_NETWORK=PID+"setting_my_network";
    public static final String REJECTED_BUYERS=PID+"setting_rejected_buyer_seller";
    //endregion

    //region MyCatalog
    public static final String SEARCH_ICON_=PID+"search_icon";
    public static final String SEARCH_TEXTFIELD=PID+"search_src_text";
    //endregion

   //region CreditRating
    public static final String CREDIT_RATING_BUTTON=PID+"txt_apply_credit";
    @SuppressWarnings("unused")
    public static final String ACCEPT_AND_CONTINUE_BUTTON=PID+"btn_accept";
    @SuppressWarnings("unused")
    public static final String FILL_MANUALLY_BUTTON=PID+"btn_manually";
    @SuppressWarnings("unused")
    public static final String ADHAR_CARD_TEXTFIELD=PID+"edit_aadhar_number";
    @SuppressWarnings("unused")
    public static final String FULLNAME_TEXTFIELD=PID+"edit_full_name";
    public static final String RADIOBUTTON_MALE=PID+"radio_male";

    public static final String RADIOBUTTON_OTHER=PID+"radio_other";
    @SuppressWarnings("unused")
    public static final String ADDRESS_TEXTFIELD=PID+"edit_address";
    public static final String PIN_TEXTFIELD=PID+"edit_pincode";
    public static final String STATE_TEXTFIELD=PID+"edit_state";
    public static final String CITY_TEXTFIELD=PID+"edit_city";
    public static final String NEXT_BUTTON_credit=PID+"btn_submit";
    public static final String PANCARD_CODE=PID+"edit_pan_card_number";
    public static final String DATE_OF_BIRTH=PID+"edit_dob";
    public static final String FATHER_NAME_TEXTFIELD=PID+"edit_father_name";
    public static final String SPOUCE_NAME=PID+"edit_spouce_name";
    public static final String MOBILE_NUMBER_CREDIT=PID+"edit_mobile_number";
    public static final String CATALOG_NON_CATALOG_SPINNER=PID+"catalog_type_spinner";

    public static final String EMAIL_ID_CREDIT=PID+"edit_email";

    @SuppressWarnings("unused")
    public static final String DONE_BUTTON_CREDIT=PID+"btn_submit";



   //endregion

    //region MyNetwork
    public static final String SEARCH_BUYER= PID+"search_src_text";
    public static final String SELECT_BUYER_NAME=PID+"buyer_name";
    @SuppressWarnings("unused")
    public static final String GET_SUPPLIER_NAME=PID+"seller_name";
    public static final String REJECT_BUYER_BUTTON=PID+"btn_reject";
    public static final String APPROVE_BUTTON=PID+"btn_approve";
    public static final String REJECTED_SUPPLIER_BUTTON=PID+"setting_rejected_supplier_retailer";
    //endregion

    //region orderpage
    public static final String TOTAL_PURCHASE_ORDER_TEXT=PID+"txt_purchase_total";
    public static final String PURCHASE_PENDING_ORDER_TEXT=PID+"txt_purchase_pending";
    public static final String PURCHASE_DISPATCHED_ORDER_TEXT=PID+"txt_purchase_dispatch";
    public static final String PURCHASE_CANCELLED_OREDR_TEXT=PID+"txt_purchase_cancel";

    public static final String TOTAL_SALES_ORDER_TEXT=PID+"txt_total_sales";
    public static final String SALES_PENDING_ORDER_TEXT=PID+"txt_sales_pending";
    public static final String SALES_DISPATCHED_ORDER_TEXT=PID+"txt_sales_dispatch";
    public static final String SALES_CANCELLED_ORDER_TEXT=PID+"txt_sales_cancel";

    public static final String TOTAL_BROKERAGE_ORDER_TEXT=PID+"txt_broker_total";
    public static final String BROKERAGE_PENDING_ORDER_TEXT=PID+"txt_broker_pending";
    public static final String BROKERAGE_DISPATCHED_ORDER_TEXT=PID+"txt_broker_dispatch";
    public static final String BROKERAGE_CANCELLED_ORDER_TEXT=PID+"txt_broker_cancel";

    public static final String BROKERAGE_PENDING_ORDER_BUTTON=PID+"linear_broker_pending";
    public static final String ORDERS_SEARCH_ICON=PID+"search_icon";
    public static final String ORDER_SEARCH_TEXTFIELD=PID+"search_src_text";
    public static final String SEARCHED_ORDER=PID+"main_container_2";
    public static final String CHAT_WITH_BUYER_BUTTON=PID+"btn_chat_buyer";
    public static final String CHAT_WITH_SUPPLIER_BUTTON=PID+"btn_chat_supplier";
    public static final String ORDER_AMOUNT_ORDER_RECEIPT=PID+"order_amount";
    //endregion

    //region orderTab myBusiness
    public static final String MY_ORDERS_BUSINESS=PID+"setting_my_orders";
    //endregion

    //regionHomePageUi
    public static final String RECENTLY_VIEWED_CATALOGS=PID+"recent_catalog_heading";
    public static final String MOST_SOLD_CATALOGS_30DAY_XAPTH="//android.widget.TextView[@text='Most Sold Catalogs (30 Days)']";
    public static final String MOST_VIEWED_CATALOGS_7DAYS_XAPTH="//android.widget.TextView[@text='Most Viewed Catalogs (7 Days)']";
    public static final String TOP_10_XAPTH=PID+"//android.widget.TextView[@text='Top 10']";
    @SuppressWarnings("unused")
    public static final String FROM_YOUR_WISHLIST_XPATH="//android.widget.TextView[@text='From Your Wishlist']";
    public static final String BANNER2=PID+"second_banner_img";
    public static final String BANNER1=PID+"first_banner_img";
    public static final String BANNER3=PID+"third_banner_img";
    public static final String BANNER4=PID+"forth_banner_img";
    public static final String RECEIVED_CATALOG_XPATH="//android.widget.TextView[@text='Received Catalogs']";
    public static final String KURTI_SAREES_DEEPLINK=PID+"recycler_view_deep_link";
    public static final String WISHBOOK_STORIES=PID+"txt_stories_label";
    public static final String STORIES_RECYCLER_VIEW=PID+"recycler_view_stories";
    public static final String CATEGORY_RECYCLER_VIEW=PID+"recycler_view_category";
    public static final String IMAGE_VIEW_SLIDER_ADD=PID+"imageView";
    public static final String TRUSTED_SALLER_RECYCLER_VIEW=PID+"recyclerViewItem";
    public static final String ACTIVE_CATALOGS=PID+"relative_active_catalog";
    public static final String ADD_NEW_CATALOG_HOME=PID+"txt_add_new_catalog";
    public static final String VIEWS_ON_YOUR_LATEST_CATALOG=PID+"item_bg";
    public static final String FIFTH_BANNER=PID+"fifth_banner_img";
    public static final String ADD_CATALOG_CONTAINER=PID+"relative_add_new";
    public static final String ENABLE_CATALOG_CONTAINER=PID+"catalog_container";
    public static final String CREATE_SALES_ORDER_BUTTON=PID+"btn_sales_order1";
    public static final String BRAND_NAME_TEXT=PID+"txt_brand_name";
    public static final String Number_Of_Design_Text=PID+"txt_number_design";
    public static final String MY_VIEWERS_BUTTON=PID+"linear_my_viewers";
    //endregion

    //region My Viewers
    @SuppressWarnings("unused")
    public static final String GET_CATALOGNAME_MY_VIEWSER=PID+"catalog_name";
    @SuppressWarnings("unused")
    public static final String GET_CATALOGBRAND_NAME_MY_VIEWERS=PID+"txt_brand_name";
    @SuppressWarnings("unused")
    public static final String GET_BUYER_COMAPANY_MY_VIEWERS=PID+"txt_buyer_company";
    //endregion

    //region My cart
    public static final String GET_CATALOG_NAME_MY_CART=PID+"cart_catalog_name";
    public static final String GET_SOLDBY_MY_CART=PID+"cart_catalog_seller";
    @SuppressWarnings("unused")
    public static final String GET_DISCOUNT_PRICE_MY_CART=PID+"cart_catalog_after_discount_price";
    @SuppressWarnings("unused")
    public static final String GET_GRAND_TOTAL_PRICE_MY_CART=PID+"grand_total";
    public static final String PLACE_ORDER_BUTTON=PID+"place_order";
    @SuppressWarnings("unused")
    public static final String INCREASE_QUATITY_MY_CART=PID+"btn_plus";
    public static final String GET_WB_MONEY_FROM_CHECKBOX=PID+"txt_available_wb_money";

    @SuppressWarnings("unused")
    public static final String DELETE_BUTTON_MY_CART=PID+"btn_catalog_delete";
    //endregion
    public static final String SINGLE_PIECES_AND_FULL_CATALOG_BOTH_RADIOBUTTON=PID+"radio_single_piece_catalog";
    public static final String FULL_CATALOG_ONLY_RADIOBUTTON=PID+"radio_full_catalog";
    public static final String ADD_MARGIN_IN_PERCENTAGE_RADIOBUTTON=PID+"radio_common_per";
    public static final String GET_PRICE_FOR_SINGLE_PC=PID+"txt_single_pc_product_price";
    public static final String ADD_MARGING_IN_RS_RADIOBUTTON=PID+"radio_common_price";
    public static final String ADD_MARGIN_TEXTFIELD=PID+"edit_common_add_margin";
    public static final String ADD_MARGING_IN_RS_TEXTFIELD=PID+"edit_price";
    public static final String PROCEED_FOR_PAYMENT_BUTTON=PID+"btn_payment";
    public static final String OTHER_TRANSPORTATION_MEDIUM=PID+"radio_customer_transport";
    public static final String GET_WISHBOOK_SHIPPING_CHARGE=PID+"txt_charge";
    public static final String ENTER_MARGIN_IN_PERCENT_ADD_PRODUCTS=PID+"radio_single_piece_per";
    public static final String ENTER_MARGIN_IN_PRICE_ADD_PRODUCTS=PID+"radio_single_piece_price";
    public static final String ENTER_MARGIN_TEXTFIELD_ADD_PRODUCT=PID+"edit_add_margin";

    public static final String GET_TOTAL_ORDER_AMOUNT_SHIPMENT_PAGE=PID+"total_amount";
    public static final String GET_TOTAL_DISCOUNT_SHIPMENT_PAGE=PID+"discount_amount";
    public static final String GET_TOTAL_GST_SHIPMENT_PAGE=PID+"gst_amount";
    public static final String GET_DELIVERY_CHARGE_SHIPMENT_PAGE=PID+"delivery_amount";
    public static final String GET_TOTAL_PAYABLE_AMOUNT=PID+"payable_amount";
    public static final String DELETE_BUTTON_CART=PID+"btn_catalog_delete";

    public static final String GET_DATE_ON_CART=PID+"cart_date";

    public static final String FULL_CATALOG_RADIOBUTTON=PID+"radio_Full_catalog";
    public static final String SINGLE_PIECES_AND_FULL_CATALOG_BOTH=PID+"radio_single_piece";
    public static final String CURRENT_PRICE_WITH_PERCENT_RADIOBUTTON=PID+"radio_per";
    public static final String CURRENT_PRICE_WITH_PRICE_RADIOBUTTON=PID+"radio_price";
    public static final String CURRENT_PRICE_WITH_PRICE_TEXTFIELD=PID+"edit_price";

    public static final String CATALOG_NAME_DETAILS=PID+"txt_catalog_name";
    public static final String EDIT_SET_SCREEN=PID+"btn_edit_screen_set";
    public static final String ADD_SET_SCREEN=PID+"btn_add_screen_set";

    public static final String ENTER_GST_NUMBER=PID+"kyc_gst";
    public static final String ENTER_PAYTM_NUMBER=PID+"kyc_paytm";
    public static final String BANK_NAME=PID+"kyc_bank_name";
    public static final String ACCOUNT_NUMBER=PID+"kyc_bank_accno";
    public static final String IFSC_CODE=PID+"kyc_bank_ifsc";
    public static final String ACCOUNT_TYPE=PID+"kyc_bank_acctype";
    public static final String ACCOUNT_HOLDER_NAME=PID+"kyc_bank_accname";
    public static final String SAVINGS_TYPE_XPATH="//android.widget.TextView[@index='1']";
    public static final String SAVE_BUTTON=PID+"kyc_submit";

    public static  final String SELL_ALL_NON_CATALOG_BUTTON=PID+"non_catalog_see_all";
    public static final String SEE_ALL_SINGLE_PIECES=PID+"single_pc_see_all";

    public static final String SEE_MORE_BRAND=PID+"txt_brand_see_more";
    public static final String SEE_ALL_WISHLIST=PID+"wishlist_see_all";

    // discount

    public static final String ADD_MORE_BUTTON=PID+"btn_add_brands";
    public static final String SAVE_DISCOUNT=PID+"btn_submit";
    public static final String SAVE_SELECTED_SEARCHED_BRAND_NAME=PID+"btn_save";

    public static final String ENTER_CASH_DISCOUNT_TEXTFIELD=PID+"edit_cash_discount";
    public static final String SEARCH_BRANDS_BY_NAME_TEXTFIELD="";
    public static final String DELETE_SET_DISCOUNT=PID+"menu_delete";
    public static final String ADD_DISCOUNT_ICON=PID+"add_discount";

    public static final String GET_CATALOG_PRICE_ON_MY_CART=PID+"cart_catalog_priceperpcs";

    public static final String WISHBOOK_MONEY_CHECKBOX=PID+"chk_wb_money";
    public static final String SEE_DETAILS_INVOICE=PID+"invoice_detail";

    public static final String PRE_ORDER_BUTTON=PID+"pre_order_filter";
    public static final String READY_TO_DISPATCH=PID+"ready_to_dispatch_filter";
    public static final String READY_TO_SHIP_TEXT_ON_CATALOG="txt_ready_to_dispatch";
    public static final String PRE_ORDER_TEXT_ON_CATALOG="txt_pre_order";
    public static final String READY_TO_DISPATCH_RADIO=PID+"radio_ready_dispatch";
    public static final String PRE_ORDER_BUTTON_RADIO=PID+"radio_pre_order";
    public static final String BOTH_AVAILABLE_RADIO=PID+"radio_availability_both";
    public static final String FULL_CATALOG_FOR_SALE_RADIO=PID+"check_full_catalog";
    public static final String SINGLE_PIECES_AVAILABLE_RADIO=PID+"check_full_catalog";
    public static final String FULL_SINGLE_BOTH_AVAILABLE_RADIO=PID+"check_both";


    //region Reseller
    public static final String ORDER_AMOUNT_IN_CHANGE_RESALE_AMOUNT_POPUP=PID+"txt_resale_order_amount";
    public static final String RESALE_AMOUNT_CHANGE_RESALE_AMOUNT_POPUP=PID+"txt_total_resale_amount";
    public static final String QUANTITY_ITEM_IN_CHANGE_RESALE_AMOUNT_POPUP=PID+"item_qty";
    public static final String ENTER_RESALE_AMOUNT_TEXT_FIELD=PID+"edit_add_margin";
    public static final String TOTAL_GST_INCL_ITEM_PRICE=PID+"catalog_total_amount";
    public static final String CLOSE_CHANGE_RESALE_POPUP=PID+"img_close";
    public static final String DONE_CHANGE_RESALE_POPUP=PID+"btn_done";

    public static final String ORDER_AMOUNT_IN_SHIPMENT=PID+"txt_resale_order_amount";
    public static final String RESALE_AMOUNT_IN_SHIPMENT=PID+"txt_total_resale_amount";

    public static final String TOGGLE_RESALE=PID+"switch_resale_order";



}






